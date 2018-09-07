package com.barton.autocoding.entity;

public class ColumnData {
    //名称
    private String columnName;
    private String columnJavaName;
    //类型
    private String columnType;
    private String columnJdbcType;
    private String columnJavaType;
    //长度
    private String columnLength;
    //备注
    private String columnComment;

    public ColumnData() {
    }

    public ColumnData(String columnName, String columnType, String columnLength, String columnComment) {
        this.columnName = columnName;
        this.columnType = columnType;
        this.columnLength = columnLength;
        this.columnComment = columnComment;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnLength() {
        return columnLength;
    }

    public void setColumnLength(String columnLength) {
        this.columnLength = columnLength;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getColumnJavaName() {
        return columnJavaName;
    }

    public void setColumnJavaName(String columnName) {
        this.columnJavaName = toLowerCaseFirstOne(upperTable(columnName));
    }

    public String getColumnJavaType() {
        return columnJavaType;
    }

    public void setColumnJavaType(String columnJavaType) {
        this.columnJavaType = columnJavaType;
    }

    public String getColumnJdbcType() {
        return columnJdbcType;
    }

    public void setColumnJdbcType(String columnJdbcType) {
        this.columnJdbcType = columnJdbcType;
    }

    /**
     * 方法说明 :将首字母和带 _ 后第一个字母 转换成大写
     *
     * @return :String
     * @author :barton
     */
    public static String upperTable(String str) {
        // 字符串缓冲区
        StringBuffer sbf = new StringBuffer();
        // 如果字符串包含 下划线
        if (str.contains("_")) {
            // 按下划线来切割字符串为数组
            String[] split = str.split("_");
            // 循环数组操作其中的字符串
            for (int i = 0, index = split.length; i < index; i++) {
                // 递归调用本方法
                String upperTable = upperTable(split[i]);
                // 添加到字符串缓冲区
                sbf.append(upperTable);
            }
        } else {// 字符串不包含下划线
            // 转换成字符数组
            char[] ch = str.toCharArray();
            // 判断首字母是否是字母
            if (ch[0] >= 'a' && ch[0] <= 'z') {
                // 利用ASCII码实现大写
                ch[0] = (char) (ch[0] - 32);
            }
            // 添加进字符串缓存区
            sbf.append(ch);
        }
        // 返回
        return sbf.toString();
    }

    /**
     * 首字符小写
     * @param s
     * @return
     */
    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }
    @Override
    public String toString() {
        return "ColumnData{" +
                "columnName='" + columnName + '\'' +
                ", columnJavaName='" + columnJavaName + '\'' +
                ", columnType='" + columnType + '\'' +
                ", columnJavaType='" + columnJavaType + '\'' +
                ", columnLength='" + columnLength + '\'' +
                ", columnComment='" + columnComment + '\'' +
                '}';
    }
}
