package com.ljp.test.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingTest.class);

    public static void main(String[] args) {
        LOGGER.debug("hello world !!!");
    }

}
