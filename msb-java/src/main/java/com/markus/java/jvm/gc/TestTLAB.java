package com.markus.java.jvm.gc;

/**
 * @author: markus
 * @date: 2022/9/21 11:15 PM
 * @Description: 验证线程本地分配区的存在
 * 1. 逃逸分析
 * 2. 标量替换
 * 3. 线程本地分配
 * 4. 关掉以上功能的参数：-XX:-DoEscapeAnalysis -XX:-EliminateAllocations -XX:-UseTLAB
 *      4.1 关闭功能之前 均时在400ms左右
 *      4.2 关闭功能之后 均时在800ms左右
 * -Xlog:c5_gc*
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class TestTLAB {
    User user;

    class User {
        int id;
        String name;

        private User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public void alloc(int i) {
        new User(i, "name " + i);
    }

    public static void main(String[] args) {
        TestTLAB testTLAB = new TestTLAB();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000_0000; i++) {
            testTLAB.alloc(i);
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
