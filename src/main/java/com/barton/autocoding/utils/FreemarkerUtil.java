package com.barton.autocoding.utils;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.NullCacheStorage;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.net.URLEncoder;
import java.util.Map;

public class FreemarkerUtil {
    public static final String MAPPERXMLFTL = "mapxml.ftl";
    public static final String MAPPERFTL = "mapper.ftl";
    public static final String ENTITYFTL = "entity.ftl";
    public static final String CONTROLLERFTL = "controller.ftl";
    public static final String SERVICEFTL = "service.ftl";
    public static final String SERVICEIMPLFTL = "serviceimpl.ftl";



    private FreemarkerUtil(){}
    private static final Configuration CONFIGURATION = new Configuration(Configuration.VERSION_2_3_22);

    static{
        //这里比较重要，用来指定加载模板所在的路径
        CONFIGURATION.setTemplateLoader(new ClassTemplateLoader(FreemarkerUtil.class, "/templates"));
        CONFIGURATION.setDefaultEncoding("UTF-8");
        CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        CONFIGURATION.setCacheStorage(NullCacheStorage.INSTANCE);
    }

    public static Template getTemplate(String templateName) {
        try {
            return CONFIGURATION.getTemplate(templateName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void clearCache() {
        CONFIGURATION.clearTemplateCache();
    }

    private static File createFile(Map<?, ?> dataMap, Template template,String targetPathName) {
        File f = new File(targetPathName);
        try {
            Writer w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
            template.process(dataMap, w);
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return f;
    }
    public static File createFile(Map<?, ?> dataMap, String templateName, String targetPathName) {

        File f = new File(targetPathName);
        try {
            Template template = getTemplate(templateName);
            Writer w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
            template.process(dataMap, w);
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return f;
    }
}
