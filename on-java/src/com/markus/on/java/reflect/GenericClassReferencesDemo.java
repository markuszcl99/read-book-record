package com.markus.on.java.reflect;

/**
 * @author: markus
 * @date: 2022/8/20 3:13 PM
 * @Description: 泛型类引用示例
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class GenericClassReferencesDemo {
    public static void main(String[] args) {
        Class intClass = int.class;
        intClass = double.class;

        Class<Integer> genericIntClass = int.class;
        // int & Integer一致，合法
        genericIntClass = Integer.class;
        // 编译时报错，不合法
//        genericIntClass = double.class;

        // Integer的class对象不是Number的class对象的子类
//        Class<Number> genericNumberClass = int.class;

        Class<? extends Number> intWildcardClass = int.class;
        intWildcardClass = double.class;
        intWildcardClass = float.class;
        //...或者是任何继承了Number的类

        // ? super Number 限定的是任何Number的基类
//        Class<? super Number> superClass = int.class;
    }
}
