package com.markus.designpattern.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @author: markus
 * @date: 2022/7/10 9:36 下午
 * @Description: 类查找工具
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class ClassUtils {
    public static List<Class> getAllClassByInterface(Class c) {
        List<Class> returnClassList = new ArrayList<>(); // 返回结果

        // 如果不是一个接口，则不做处理
        if (c.isInterface()) {
            String packageName = c.getPackage().getName(); // 获得当前的包名
            try {
                List<Class> allClass = getClasses(packageName); // 获取当前包下以及子包下的所有类
                for (int i = 0; i < allClass.size(); i++) {
                    if (c.isAssignableFrom(allClass.get(i))) { // 判断是不是一个接口
                        if (!c.equals(allClass.get(i))) { // 本身不加进去
                            returnClassList.add(allClass.get(i));
                        }
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return returnClassList;
    }

    private static List<Class> getClasses(String packageName) throws IOException, ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class> classes = new ArrayList<>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes;
    }

    private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }
}
