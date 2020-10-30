package com.demo.platform.common.utils;

import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.MapContext;
import org.apache.commons.jexl3.internal.Engine;

import java.util.HashMap;
import java.util.Map;

/**
 * 执行java语句
 */
public class Jexl3Util {

    private static JexlEngine jexlEngine = new Engine();

    public static Object executeExpression(String jexlExpression, Map<String, Object> map) {
        JexlExpression expression = jexlEngine.createExpression(jexlExpression);
        JexlContext context = new MapContext();
        map.forEach(context::set);
        return expression.evaluate(context);
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("content", "test haha");
        System.out.println();
        Object str = executeExpression(" content.toUpperCase()", map);
        System.out.println(str);
    }
}
