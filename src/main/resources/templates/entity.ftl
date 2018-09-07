package ${package};

<#list columnDatas as cd>
<#if cd.columnJavaType = 'Date'>
import java.util.Date;;
</#if>
</#list>

public class ${entityName} {
    <#list columnDatas as cd>
    /**
    <#list cd.columnComment ?split("\r\n") as name>
     * ${name}
    </#list>
     */
    private ${cd.columnJavaType} ${cd.columnJavaName};
    </#list>

    <#list columnDatas as cd>
    public String get${cd.columnJavaName ? cap_first}() {
        return ${cd.columnJavaName};
    }

    public void set${cd.columnJavaName ? cap_first}(String ${cd.columnJavaName}) {
    <#if cd.columnJavaType = 'String'>
        this.${cd.columnJavaName} = ${cd.columnJavaName} == null ? null : ${cd.columnJavaName}.trim();
    </#if>
    }
    </#list>

    @Override
    public String toString() {
        return "${entityName}{" +
            <#list columnDatas as cd>
                ", ${cd.columnJavaName}＝'" + ${cd.columnJavaName} + '\'' +
            </#list>
                '}';
    }

}