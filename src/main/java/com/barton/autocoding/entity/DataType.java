package com.barton.autocoding.entity;

import com.barton.autocoding.enums.MysqlMbatisJavaEnum;

import java.util.List;

public class DataType {


    private String jdbcType;

    private String javaType;

    private String databaseType;


    public DataType(String jdbcType, String javaType, String databaseType) {
        this.jdbcType = jdbcType;
        this.javaType = javaType;
        this.databaseType = databaseType;
    }

    public static List<DataType> getDataTypes(int databaseType){
        return MysqlMbatisJavaEnum.toList();
    }

    public static DataType generateDataType(String databaseType){
        MysqlMbatisJavaEnum mysqlMbatisJavaEnum = MysqlMbatisJavaEnum.getMysqlMbatisJavaEnum(databaseType);
        return new DataType(mysqlMbatisJavaEnum.getJdbcType(),mysqlMbatisJavaEnum.getJavaType(),mysqlMbatisJavaEnum.getDatabaseType());
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }
}
