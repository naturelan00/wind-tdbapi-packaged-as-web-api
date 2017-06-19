package com.windtdb;

/**
 * Created by aoito on 2017/6/12.
 */
public class TickParam {
    private String key;
    private String code;        //万得代码，如： 000001.SZ
    private String marketKey;  //市场，如： SZ-2-0(上海-L2-Source0)
    private int Date;          //请求日期(0:今天)
    private int beginTime;    // 开始时间
    private int endTime;      // 结束时间

    public String getKey(){ return key; }

    public String getCode() {
        return code;
    }

    public String getMarketKey() {
        return marketKey;
    }

    public int getDate() {
        return Date;
    }

    public int getBeginTime() {
        return beginTime;
    }

    public int getEndTime() {
        return endTime;
    }
}
