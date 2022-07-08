package com.markus.effective.java.chapter12.item88;

import java.io.*;
import java.util.Date;

/**
 * @author: markus
 * @date: 2022/5/29 11:39 上午
 * @Description:
 * @Blog: http://markuszhang.com/
 */
public class MutablePeriod {
    public final Period period;

    public final Date start;
    public final Date end;

    public MutablePeriod() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);

            out.writeObject(new Period(new Date(), new Date()));

            byte[] ref = {0x71, 0, 0x7e, 0, 5};
            bos.write(ref);// The start field;

            ref[4] = 4;
            bos.write(ref);// The end field;

            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
            period = (Period) in.readObject();
            start = (Date) in.readObject();
            end = (Date) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new AssertionError(e);
        }
    }

    public static void main(String[] args) {
        MutablePeriod mp = new MutablePeriod();
        Period p = mp.period;
        Date pEnd = mp.end;

        pEnd.setYear(78);
        System.out.println(p);

        pEnd.setYear(69);
        System.out.println(p);
    }
}
