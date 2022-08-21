package com.markus.on.java.blog.reflect;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: markus
 * @date: 2022/8/21 9:55 PM
 * @Description: 使用形状的客户端
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class ShapeClient {
    public static void main(String[] args) {
        // 一般我们编程都遵循面向接口或抽象编程的原则，所以可能会有以下这样一段程序

        // 1. 我们从数据源中获取Shape对象集合
        List<Shape> shapes = getShapes();//多态，我们只需要知道是Shape集合
        shapes.forEach(Shape::draw);// 执行Shape的draw操作，至于怎么执行取决于Shape所指向的引用

        System.out.println("======使用反射拿到Circle引用，不执行打印操作======");
        shapes.stream()
                .filter(shape -> shape.getClass() != Circle.class)
                .forEach(Shape::draw);
    }

    private static List<Shape> getShapes() {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle());
        shapes.add(new Square());
        shapes.add(new Triangle());
        return shapes;
    }
}
