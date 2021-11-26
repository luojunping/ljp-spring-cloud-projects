package com.ljp.test.operation;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OperationTest {

	@Test
	public void testOne() {
		BigDecimal totalNum = new BigDecimal(49 * 3);
		BigDecimal divide = totalNum.divide(new BigDecimal(100), 0, RoundingMode.HALF_UP);
		System.out.println(divide.intValue());
		System.out.println(new BigDecimal(100).multiply(new BigDecimal("0.03")).setScale(0, RoundingMode.HALF_UP));
	}

}
