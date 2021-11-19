package com.ljp.aop;

import java.lang.annotation.*;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/2/18
 * @since 1.0.0
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DistributedLock {

    String value();

}
