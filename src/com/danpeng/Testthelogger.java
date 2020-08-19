package com.danpeng;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Testthelogger {
    private String data;
    private Logger logger;
    public Testthelogger(String data) throws IOException {
        this.data = data;
        Logger logger = Logger.getLogger("com.danpeng");
        logger.info("this the inherit logger");
//        logger.setLevel(Level.WARNING);
        logger.setUseParentHandlers(false);
        FileHandler fileHandler = new FileHandler("D:\\java\\logger.txt");
        logger.addHandler(fileHandler);
        this.logger = logger;
    }

    public String getData() {
        logger.info("hello");
        return data;
    }
}
