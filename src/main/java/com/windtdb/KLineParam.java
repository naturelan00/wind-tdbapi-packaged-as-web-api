package com.windtdb;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aoito on 2017/6/12.
 */
public class KLineParam {
    private String key;         //校验码，密码
    private String code;        //万得代码，如： 000001.SZ
    private String marketKey;  //市场，如： SZ-2-0(上海-L2-Source0)
    private String cqFlag;        //除权标志(REFILLFLAG 对应值)
    private int cqDate;        //复权日期
    private int qjFlag;        //全价标志(债券)(0:净价, 1:全价)
    private String cycType;       //数据周期(TdbType 对应值)
    private int cycDef;        //周期数量
    private int autoComplete; //自动补齐(0:不补齐,1:补齐)
    private int beginDate;    //开始日期(0:从今天开始)
    private int endDate;      //结束日期(0:从今天开始）
    private int beginTime;    // 开始时间
    private int endTime;      // 结束时间

    public String getKey() { return key; }

    public String getCode() {
        return code;
    }

    public String getMarketKey() {
        return marketKey;
    }

    public int getCqFlag() {
        return TdbType.chgCqFlag(this.cqFlag);
    }

    public int getCqDate() {
        return cqDate;
    }

    public int getQjFlag() {
        return qjFlag;
    }

    public int getCycType() {
        return TdbType.chgCycType(this.cycType);
    }

    public int getCycDef() {
        return cycDef;
    }

    public int getAutoComplete() {
        return autoComplete;
    }

    public int getBeginDate() {
        return beginDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public int getBeginTime() {
        return beginTime;
    }

    public int getEndTime() {
        return endTime;
    }
}
