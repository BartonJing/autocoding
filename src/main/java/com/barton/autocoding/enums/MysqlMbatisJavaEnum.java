package com.barton.autocoding.enums;

import com.barton.autocoding.entity.DataType;

import java.util.ArrayList;
import java.util.List;

public enum  MysqlMbatisJavaEnum {
    TYPE_01("char", "CHAR","String"),
    TYPE_02("varchar", "VARCHAR","String"),
    TYPE_03("tinyint", "TINYINT","String"),
    TYPE_04("smallint", "SMALLINT","short"),
    TYPE_05("int", "INTEGER","int"),
    TYPE_06("float", "FLOAT","float"),
    TYPE_07("bigint", "BIGINT","long"),
    TYPE_08("double", "DOUBLE","double"),
    TYPE_09("bit", "BOOLEAN","boolean"),
    TYPE_10("date", "Date","Date"),
    TYPE_11("time", "TIME","Date"),
    TYPE_12("timestamp", "TIMESTAMP","Date"),
    TYPE_13("text", "VARCHAR","String"),
    TYPE_14("longtext", "VARCHAR","String");


    private final String databaseType;
    private final String jdbcType;
    private final String javaType;


    MysqlMbatisJavaEnum(String databaseType, String jdbcType, String javaType) {
        this.databaseType = databaseType;
        this.jdbcType = jdbcType;
        this.javaType = javaType;
    }

    public static MysqlMbatisJavaEnum getMysqlMbatisJavaEnum(String value) {
        for (MysqlMbatisJavaEnum cp : MysqlMbatisJavaEnum.values()) {
            if (value.equalsIgnoreCase(cp.getDatabaseType())) {
                return cp;
            }
        }
        return null;
    }
    /**
     * 将次枚举类转为list
     * @return
     */
    public static List<DataType> toList() {
        List<DataType> list = new ArrayList<DataType>();
        for (MysqlMbatisJavaEnum cp : MysqlMbatisJavaEnum.values()) {
            DataType dataType = new DataType(cp.jdbcType,cp.javaType,cp.databaseType);
            list.add(dataType);
        }
        return list;
    }

    public String getDatabaseType() {
        return databaseType;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public String getJavaType() {
        return javaType;
    }
}
