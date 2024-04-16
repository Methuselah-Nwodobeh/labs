package com.amalitech.upskilling.week_two.lab_one.creational.singleton;

import com.amalitech.upskilling.OutPut;

public class TestLogging {
    public static boolean isLogginInstanceSingle() {
        /*
          Since all the loggers use the same instance, they should all have the same memory address *.
          Since no equals method is implemented in the SingletonLogger class,
          when comparing the two logger instances, they should be equal,if not they are two separate instances.

          @return boolean
         */
        SingletonLogger logger1 = SingletonLogger.getInstance();
        SingletonLogger logger2 = SingletonLogger.getInstance();

        return logger1 == logger2;
    }

    public static void main(String[] args) {
        OutPut.printColoredTextBlock("check if logging instance is single: " + isLogginInstanceSingle(), OutPut.Colors.CYAN);
        OutPut.printColoredTextBlock("--------------------------------------------------------------- " + isLogginInstanceSingle(), OutPut.Colors.WHITE);
        OutPut.printColoredTextBlock("Testing logging methods " + isLogginInstanceSingle(), OutPut.Colors.CYAN);
        SingletonLogger logger = SingletonLogger.getInstance();
        logger.log("This is a log");
        logger.info("This is an info");
        logger.error("This is an error");
        logger.warning("This is a warning");
        logger.debug("This is a debug");
        logger.trace("This is a trace");
    }
}
