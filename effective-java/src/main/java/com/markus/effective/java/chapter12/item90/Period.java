package com.markus.effective.java.chapter12.item90;

import java.io.*;
import java.util.Date;

/**
 * @author: markus
 * @date: 2022/5/29 4:53 下午
 * @Description: 阶段
 * @Blog: http://markuszhang.com/
 */
public class Period implements Serializable {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        this.start = start;
        this.end = end;
        if (this.start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + " after " + end);
        }
    }

    public Date start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }

    public String toString() {
        return start + " - " + end;
    }

    private static class SerializationProxy implements Serializable {
        private final Date start;
        private final Date end;

        SerializationProxy(Period period) {
            this.start = period.start;
            this.end = period.end;
        }

        private Object readResolve() {
            return new Period(start, end);
        }

        private static final long serialVersionUID = 234098243823485285L;
    }

    private Object writeReplace() {
        return new SerializationProxy(this);
    }

    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required!");
    }


    public static void main(String[] args) {
        Period period = new Period(new Date(), new Date());

        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(period);

            ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream in = new ObjectInputStream(bin);
            Period periodDeserialize = (Period) in.readObject();

            System.out.println(period);
            System.out.println(periodDeserialize);
        } catch (IOException | ClassNotFoundException e) {
            throw new AssertionError(e);
        }
    }
}
