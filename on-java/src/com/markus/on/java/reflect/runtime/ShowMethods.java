package com.markus.on.java.reflect.runtime;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @author: markus
 * @date: 2022/8/20 10:30 PM
 * @Description: 自动展示完整接口的工具
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class ShowMethods {
    private static String usage =
            "usage:\n" +
                    "ShowMethods qualified.class.name\n" +
                    "To show all methods in class or:\n" +
                    "ShowMethods qualified.class.name world\n" +
                    "To search for methods involving 'word'";
    private static Pattern p = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> clazz = Class.forName(args[0]);
            Method[] methods = clazz.getMethods();
            Constructor[] ctors = clazz.getConstructors();
            if (args.length == 1) {
                for (Method method : methods) {
                    System.out.println(
                            p.matcher(
                                    method.toString()
                            ).replaceAll("")
                    );
                }
                for (Constructor ctor : ctors) {
                    System.out.println(
                            p.matcher(
                                    ctor.toString()
                            ).replaceAll("")
                    );
                }
                lines = methods.length + ctors.length;
            } else {
                for (Method method : methods) {
                    if (method.toString().contains(args[1])) {
                        System.out.println(p.matcher(method.toString()).replaceAll(""));
                        lines++;
                    }
                }
                for (Constructor ctor : ctors) {
                    if (ctor.toString().contains(args[1])) {
                        System.out.println(p.matcher(ctor.toString()).replaceAll(""));
                        lines++;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No such class: " + e);
        }
    }
}
