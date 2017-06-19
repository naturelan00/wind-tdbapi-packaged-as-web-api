package com.windtdb;

/**
 * Created by aoito on 2017/6/8.
 */
public class TdbTick {
    private final String windCode;
    private final String code;
    private final int date;
    private final int time;
    private final int price;
    private final long volume;
    private final int high;
    private final int low;
    private final int open;
    private final int close;
    private final int askPrice1;
    private final long askVolume1;
    private final int bidPrice1;
    private final long bidVolume1;

    public TdbTick(String windCode, String code, int date, int time,
                   int price, long volume, int high, int low, int open,
                   int close, int askPrice1, long askVolume1, int bidPrice1, long bidVolume1) {
        this.windCode = windCode;
        this.code = code;
        this.date = date;
        this.time = time;
        this.price = price;
        this.volume = volume;
        this.high = high;
        this.low = low;
        this.open = open;
        this.close = close;
        this.askPrice1 = askPrice1;
        this.askVolume1 = askVolume1;
        this.bidPrice1 = bidPrice1;
        this.bidVolume1 = bidVolume1;
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

    public int getPrice() {
        return price;
    }

    public long getVolume() {
        return volume;
    }

    public int getHigh() {
        return high;
    }

    public int getLow() {
        return low;
    }

    public int getOpen() {
        return open;
    }

    public int getClose() {
        return close;
    }

    public int getAskPrice1() {
        return askPrice1;
    }

    public long getAskVolume1() {
        return askVolume1;
    }

    public int getBidPrice1() {
        return bidPrice1;
    }

    public long getBidVolume1() {
        return bidVolume1;
    }
}
