# autocoding
autocoding - 自动生成代码

可自动生成　xml,mapper,entity,service,controler
基于springmvc ＋　mybatis

目前依赖比较强　
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
