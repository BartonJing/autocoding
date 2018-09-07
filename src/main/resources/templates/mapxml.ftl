<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${namespace}">
    <resultMap id="BaseResultMap" type="${entityClass}">
        <#list columnDatas as cd>
            <#if cd_index = 0>
                <id column="${cd.columnName}" property="${cd.columnJavaName}" jdbcType="${cd.columnJdbcType}"/>
            <#else>
                <result column="${cd.columnName}" property="${cd.columnJavaName}" jdbcType="${cd.columnJdbcType}"/>
            </#if>
        </#list>
    </resultMap>
    <sql id="Base_Column_List">
        <#list columnDatas as cd>
            <#if !cd_has_next>
                ${cd.columnName}
            <#else>
                ${cd.columnName + ','}
            </#if>
        </#list>
    </sql>
    <select id="selectByPrimaryKey" resultMap="BaseResultMap" parameterType="java.lang.String">
        select
        <include refid="Base_Column_List"/>
        from ${tableName}
        where id = ${r'#{id,jdbcType=VARCHAR}'}
    </select>
    <delete id="deleteByPrimaryKey" parameterType="java.lang.String" >
        delete from ${tableName}
        where id = ${r'#{id,jdbcType=VARCHAR}'}
    </delete>
    <insert id="insert" parameterType="${entityClass}" >
        insert into ${tableName} (
        <#list columnDatas as cd>
            <#if !cd_has_next>
                ${cd.columnName}
            <#else>
                ${cd.columnName + ','}
            </#if>
        </#list>)
        values (
        <#list columnDatas as cd>
            <#if !cd_has_next>
                ${r'#{'}${cd.columnJavaName},jdbcType${cd.columnJdbcType}${r'}'}
            <#else>
                ${r'#{'}${cd.columnJavaName},jdbcType${cd.columnJdbcType}${r'}'},
            </#if>
        </#list>)
    </insert>
    <insert id="insertSelective" parameterType="${entityClass}" >
        insert into ${tableName}
        <trim prefix="(" suffix=")" suffixOverrides="," >
            <#list columnDatas as cd>
                <if test="${cd.columnJavaName} != null" >
                    ${cd.columnName},
                </if>
            </#list>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides="," >
            <#list columnDatas as cd>
                <if test="${cd.columnJavaName} != null" >
                    ${r'#{'}${cd.columnJavaName},jdbcType${cd.columnJdbcType}${r'}'},
                </if>
            </#list>
        </trim>
    </insert>
    <update id="updateByPrimaryKeySelective" parameterType="${entityClass}" >
        update ${tableName}
        <set >
            <#list columnDatas as cd>
                <if test="${cd.columnJavaName} != null" >
                    ${cd.columnName} = ${r'#{'}${cd.columnJavaName},jdbcType${cd.columnJdbcType}${r'}'},
                </if>
            </#list>
        </set>
        where id = ${r'#{id,jdbcType=VARCHAR}'}
    </update>
    <update id="updateByPrimaryKey" parameterType="${entityClass}" >
        update ${tableName}
        set
        <#list columnDatas as cd>
            <#if !cd_has_next>
                ${cd.columnName} = ${r'#{'}${cd.columnJavaName},jdbcType${cd.columnJdbcType}${r'}'}
            <#else>
                ${cd.columnName} = ${r'#{'}${cd.columnJavaName},jdbcType${cd.columnJdbcType}${r'}'},
            </#if>
        </#list>
        where id = ${r'#{id,jdbcType=VARCHAR}'}
    </update>
    <select id="selectByParams" resultMap="BaseResultMap"
            parameterType="java.util.Map">
        select
        <include refid="Base_Column_List"/>
        from ${tableName}
        <where>
            <#list columnDatas as cd>
                <if test="${cd.columnJavaName} != null">
                    AND ${cd.columnName} ＝ ${r'#{'}${cd.columnJavaName}${r'}'}
                </if>
            </#list>
        </where>
    </select>

</mapper>