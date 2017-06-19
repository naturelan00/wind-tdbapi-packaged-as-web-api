package com.windtdb;

/**
 * Created by aoito on 2017/6/11.
 */
public class TdbKLine {
    private final String windCode;
    private final String code;
    private final int date;
    private final int time;
    private final int open;
    private final int high;
    private final int low;
    private final int close;
    private final long volume;

    public TdbKLine(String windCode, String code, int date, int time, int open, int high, int low, int close, long volume) {
        this.windCode = windCode;
        this.code = code;
        this.date = date;
        this.time = time;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }

    public String getWindCode() {
        return windCode;
    }

    public String getCode() {
        return code;
    }

    public int getDate() {
        return date;
    }

    public int getTime() {
        return time;
    }

    public int getOpen() {
        return open;
    }

    public int getHigh() {
        return high;
    }

    public int getLow() {
        return low;
    }

    public int getClose() {
        return close;
    }

    public long getVolume() {
        return volume;
    }
}
