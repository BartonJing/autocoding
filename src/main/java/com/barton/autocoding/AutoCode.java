package com.barton.autocoding;

import com.barton.autocoding.entity.ColumnData;
import com.barton.autocoding.utils.DatabaseUtil;
import com.barton.autocoding.utils.FreemarkerUtil;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;
import com.xiaoleilu.hutool.util.StrUtil;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutoCode {
    private final static Log log = LogFactory.get();
    // eg:"com.mysql.jdbc.Driver"
    private String driver;
    // eg:"jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8"
    private String url;
    // eg:root
    private String username;
    // eg:root
    private String password;
    //test
    private String tableName;
    //mapper package eg:cn.com.barton.dao
    private String xmlpath;
    ///home/barton/test/src/java/
    private String javaPath;
    //mapper package eg:cn.com.barton.dao
    private String mapperPackage;
    //entity package eg:cn.com.barton.entity
    private String entityPackage;
    //service package eg:cn.com.barton.service
    private String servicePackage;
    //service package eg:cn.com.barton.service.impl
    private String serviceImplPackage;
    //service package eg:cn.com.barton.controller
    private String controllerPackage;


    public AutoCode setDriver(String driver) {
        this.driver = driver;
        return this;
    }

    public AutoCode setUrl(String url) {
        this.url = url;
        return this;
    }

    public AutoCode setUsername(String username) {
        this.username = username;
        return this;
    }

    public AutoCode setPassword(String password) {
        this.password = password;
        return this;
    }

    public AutoCode setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public AutoCode setXmlpath(String xmlpath) {
        this.xmlpath = xmlpath;
        return this;
    }

    public AutoCode setJavaPath(String javaPath) {
        this.javaPath = javaPath;
        return this;
    }

    public AutoCode setMapperPackage(String mapperPackage) {
        this.mapperPackage = mapperPackage;
        return this;
    }

    public AutoCode setEntityPackage(String entityPackage) {
        this.entityPackage = entityPackage;
        return this;
    }

    public AutoCode setServicePackage(String servicePackage) {
        this.servicePackage = servicePackage;
        return this;
    }

    public AutoCode setServiceImplPackage(String serviceImplPackage) {
        this.serviceImplPackage = serviceImplPackage;
        return this;
    }

    public AutoCode setControllerPackage(String controllerPackage) {
        this.controllerPackage = controllerPackage;
        return this;
    }

    public static Log getLog() {
        return log;
    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getTableName() {
        return tableName;
    }

    public String getXmlpath() {
        return xmlpath;
    }

    public String getJavaPath() {
        return javaPath;
    }

    public String getMapperPackage() {
        return mapperPackage;
    }

    public String getEntityPackage() {
        return entityPackage;
    }

    public String getServicePackage() {
        return servicePackage;
    }

    public String getServiceImplPackage() {
        return serviceImplPackage;
    }

    public String getControllerPackage() {
        return controllerPackage;
    }

    /**
     * start
     */
    public void execute() {
        //初始化数据库信息
        DatabaseUtil.init(driver, url, username, password);
        //获取数据库对应表信息
        List<ColumnData> columnDatas = DatabaseUtil.getColumnDatas(tableName);
        log.info(columnDatas.toString());


        String entityName = ColumnData.upperTable(tableName);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("namespace", mapperPackage + "." + entityName + "Mapper");
        map.put("entityClass", entityPackage + "." + entityName);
        map.put("columnDatas", columnDatas);
        map.put("tableName", tableName);
        FreemarkerUtil.createFile(map, FreemarkerUtil.MAPPERXMLFTL, xmlpath + entityName+"Mapper.xml");
        log.info("xml---success");

        //mapper
        if (StrUtil.isNotEmpty(entityPackage)){
            map = new HashMap<String, Object>();
            map.put("entityClass", entityPackage + "." + entityName);
            map.put("entityName", entityName);
            map.put("package", mapperPackage);
            FreemarkerUtil.createFile(map, FreemarkerUtil.MAPPERFTL, javaPath + periodReplace(mapperPackage)+entityName+"Mapper.java");
            log.info("mapper---success");
        }

        //entity
        if (StrUtil.isNotEmpty(entityPackage)){
            map.clear();
            map.put("package", entityPackage);
            map.put("entityName", entityName);
            map.put("columnDatas", columnDatas);
            FreemarkerUtil.createFile(map, FreemarkerUtil.ENTITYFTL, javaPath + periodReplace(entityPackage)+entityName+".java");
            log.info("entity---success");
        }

        //service
        if (StrUtil.isNotEmpty(servicePackage)){
            map.clear();
            map.put("package", servicePackage);
            map.put("entityName", entityName);
            FreemarkerUtil.createFile(map, FreemarkerUtil.SERVICEFTL, javaPath + periodReplace(servicePackage)+entityName+"Service.java");
            log.info("service---success");
        }

        //serviceImpl
        if (StrUtil.isNotEmpty(serviceImplPackage)){
            map.clear();
            map.put("package", serviceImplPackage);
            map.put("entityName", entityName);
            FreemarkerUtil.createFile(map, FreemarkerUtil.SERVICEIMPLFTL, javaPath + periodReplace(serviceImplPackage)+entityName+"ServiceImpl.java");
            log.info("serviceImpl---success");
        }

        //controller
        if (StrUtil.isNotEmpty(controllerPackage)){
            map.clear();
            map.put("package", controllerPackage);
            map.put("entityName", entityName);
            FreemarkerUtil.createFile(map, FreemarkerUtil.CONTROLLERFTL, javaPath + periodReplace(controllerPackage)+entityName+"Controller.java");
            log.info("controller---success");
        }


    }




    /**
     * 将字符串中的.号替换为路径符号
     * @param originalStr
     * @return
     */
    public static String periodReplace(String originalStr){
        return originalStr.replace(".",File.separator)+File.separator;
    }
}
