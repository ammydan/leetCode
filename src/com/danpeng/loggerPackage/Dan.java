package com.danpeng.loggerPackage;

import java.util.logging.Logger;

public class Dan {
    private String name;
    private  Logger logger;
    public Dan (String name){
        this.name = name;
        Logger danLogger = Logger.getLogger("com.danpeng.loggerPackage");
        danLogger.info("this the Dan Class, and I leave a message.");
        this.logger = danLogger;


    }

    public String getName() {
        logger.info("this is the info ban after");
        return name;

    }
}
