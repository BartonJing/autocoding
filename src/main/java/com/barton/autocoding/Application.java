package com.barton.autocoding;

import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;

public class Application {
    private final static Log LOGGER = LogFactory.get();
    public static void main(String [] args){

        AutoCode autoCode = new AutoCode();
        autoCode.setDriver("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8")
                .setUsername("root")
                .setPassword("root")
                .setTableName("aa")
                .setXmlpath("/home/barton/workspace/autocoding/src/main/resources/test/")
                .setJavaPath("/home/barton/workspace/autocoding/src/main/java/")
                .setMapperPackage("com.barton.autocoding.test.dao")
                .setEntityPackage("com.barton.autocoding.test.entity")
                .setServicePackage("com.barton.autocoding.test.service")
                .setServiceImplPackage("com.barton.autocoding.test.service.impl")
                .setControllerPackage("com.barton.autocoding.test.controller")
                .execute();



    }
}
