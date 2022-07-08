package com.markus.designpattern.strategy;

/**
 * @author: markus
 * @date: 2022/7/8 10:27 下午
 * @Description: 苦逼考试人
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class MarkusZhang {
    public static void main(String[] args) {
        IStrategy monthExamStrategy = new CheatSheet();//快要考试了，我准备打小抄
        Exam exam = new Exam(monthExamStrategy);//月考
        exam.exam();//考试了，别被逮着

        IStrategy midtermStrategy = new Peep();//快要期中考试了，我准备偷看同学试卷通过考试
        Exam midtermExam = new Exam(midtermStrategy);
        midtermExam.exam();

        IStrategy finalStrategy = new Review();//上次被逮着了，被记了大过，这次要好好复习了
        Exam finalExam = new Exam(finalStrategy);
        finalExam.exam();
    }
}
