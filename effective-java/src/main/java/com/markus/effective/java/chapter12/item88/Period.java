package com.markus.effective.java.chapter12.item88;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: markus
 * @date: 2022/5/29 11:20 上午
 * @Description: 阶段
 * @Blog: http://markuszhang.com/
 */
public final class Period implements Serializable {
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

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();

        if (start.compareTo(end) > 0) {
            throw new InvalidObjectException(start + " after " + end);
        }
    }
}
