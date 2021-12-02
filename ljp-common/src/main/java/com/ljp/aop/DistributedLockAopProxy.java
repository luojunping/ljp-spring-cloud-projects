package com.ljp.aop;

import com.ljp.common.util.ResponseResultUtils;
import com.ljp.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/2/18
 * @since 1.0.0
 **/
@Slf4j
@Aspect
@Component
public class DistributedLockAopProxy {

	private static final String UNLOCK_LUA_SCRIPT = "local key = KEYS[1]; local value = ARGV[1]; if redis.call('get', key) == value then return redis.call('del', key) else return 0 end;";

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Pointcut(value = "@annotation(com.ljp.aop.DistributedLock)")
	private void pointcut() {

	}

	@Around(value = "pointcut()")
	public Object aroundLock(ProceedingJoinPoint joinPoint) {
		Object obj = JsonUtils.objToJsonStr(ResponseResultUtils.fail("请稍后再试！！！"));
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		DistributedLock distributedLock = methodSignature.getMethod().getAnnotation(DistributedLock.class);
		String lockKey = distributedLock.value();
		String lockValue = UUID.randomUUID().toString().replace("-", "");
		Boolean locked = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, lockValue, Duration.ofSeconds(2));
		if (locked.booleanValue()) {
			ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
			scheduledExecutorService.scheduleAtFixedRate(() -> {
				stringRedisTemplate.expire(lockKey, Duration.ofSeconds(2));
			}, 1, 1, TimeUnit.SECONDS);
			try {
				obj = joinPoint.proceed();
				// stringRedisTemplate.execute(RedisScript.of(UNLOCK_LUA_SCRIPT, Long.class), Lists.newArrayList(lockKey), lockValue);
			} catch (Throwable throwable) {
				// stringRedisTemplate.execute(RedisScript.of(UNLOCK_LUA_SCRIPT, Long.class), Lists.newArrayList(lockKey), lockValue);
				log.error("分布式锁方法执行出错！！！", throwable);
				obj = JsonUtils.objToJsonStr(ResponseResultUtils.fail("分布式锁方法执行出错！！！"));
			}
			scheduledExecutorService.shutdownNow();
		}
		return obj;
	}

}
