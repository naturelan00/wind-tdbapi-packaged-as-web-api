package com.windtdb;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aoito on 2017/6/11.
 */
public class TdbType {

    //cqFlag
    //REFILL_NONE 0 不复权
    //REFILL_BACKWARD 1 全程向前复权(从现在向过去)
    //REFILL_FORWARD 2 全程向后复权(从过去向现在)
    public static int chgCqFlag(String e){
        int res = 0;
        switch (e){
            case "none":
                res = 0;
                break;
            case "backward":
                res = 1;
                break;
            case "forward":
                res = 2;
                break;
        }
        return res;
    }

    //cycType: 对应关系
    //CYC_SECOND 0 秒线
    //CYC_MINUTE 1 分钟线
    //CYC_DAY 2 日线
//    CYC_WEEK 3 周线
//    CYC_MONTH 4 月线
//    CYC_SEASON 5 季线
//    CYC_HAFLYEAR 6 半年线
//    CYC_YEAR 7 年线
//    CYC_TICKBAR 8 TickBar
    public static int chgCycType(String e){
        int res = 0;
        switch (e){
            case "second":
                res = 0;
                break;
            case "minute":
                res = 1;
                break;
            case "day":
                res = 2;
                break;
            case "week":
                res = 3;
                break;
            case "month":
                res = 4;
                break;
            case "season":
                res = 5;
                break;
            case "halfyear":
                res = 6;
                break;
            case "year":
                res = 7;
                break;
            case "tickbar":
                res = 8;
                break;
        }
        return res;
    }
}
