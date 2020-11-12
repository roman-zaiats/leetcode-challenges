package com.rzaiats.leetcode;

import java.util.HashMap;
import java.util.Map;

//Design a logger system that receive stream of messages along with its timestam
//ps, each message should be printed if and only if it is not printed in the last
//10 seconds.
//
// Given a message and a timestamp (in seconds granularity), return true if the
//message should be printed in the given timestamp, otherwise returns false.
//
// It is possible that several messages arrive roughly at the same time.
//
// Example:
//
//
//Logger logger = new Logger();
//
//// logging string "foo" at timestamp 1
//logger.shouldPrintMessage(1, "foo"); returns true;
//
//// logging string "bar" at timestamp 2
//logger.shouldPrintMessage(2,"bar"); returns true;
//
//// logging string "foo" at timestamp 3
//logger.shouldPrintMessage(3,"foo"); returns false;
//
//// logging string "bar" at timestamp 8
//logger.shouldPrintMessage(8,"bar"); returns false;
//
//// logging string "foo" at timestamp 10
//logger.shouldPrintMessage(10,"foo"); returns false;
//
//// logging string "foo" at timestamp 11
//logger.shouldPrintMessage(11,"foo"); returns true;
// Related Topics Hash Table Design
// 👍 597 👎 127


/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
public class LoggerLimiter_359 {

    public static void main(String[] args) {
        Logger logger = new Logger();

        logger.shouldPrintMessage(1, "foo");

        logger.shouldPrintMessage(2, "bar");

        logger.shouldPrintMessage(3, "foo");

        logger.shouldPrintMessage(8, "bar");

        System.out.println(logger.shouldPrintMessage(10, "foo"));

        System.out.println(logger.shouldPrintMessage(11, "foo"));
    }

    static class Logger {
        private Map<String, Integer> messageTimestampMap;

        /**
         * Initialize your data structure here.
         */
        public Logger() {
            this.messageTimestampMap = new HashMap<String, Integer>();
        }

        /**
         * Returns true if the message should be printed in the given timestamp, otherwise returns false.
         * If this method returns false, the message will not be printed.
         * The timestamp is in seconds granularity.
         */
        public boolean shouldPrintMessage(int timestamp, String message) {
            Integer value = messageTimestampMap.get(message);
            if (value == null) {
                messageTimestampMap.put(message, timestamp);

                return true;
            }

            if (timestamp - value >= 10) {
                messageTimestampMap.put(message, timestamp);

                return true;
            } else {
                return false;
            }
        }
    }
}
