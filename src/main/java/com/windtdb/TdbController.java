package com.windtdb;

/**
 * Created by aoito on 2017/6/8.
 */
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
//wind
import cn.com.wind.td.tdb.*;

@RestController
public class TdbController {
    static String arrayToStr(long[] array) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for(long v: array) {
            sb.append(v).append(",");
        }
        sb.append("]");
        return sb.toString();
    }
    static String arrayToStr(int[] array) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for(int v: array) {
            sb.append(v).append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    TDBClient client = new TDBClient();

    int m_nMaxOutputCount = 1000;

    //增加dll
//        ClassLoader classLoader = getClass().getClassLoader();
//        URL url = classLoader.getResource("");
//        assert url != null;
//        String baseDir = url.getPath();
//        String jniDll = baseDir + "BOOT-INF/classes/tdbapi_jni.dll";
//        String tdbDll = baseDir + "BOOT-INF/classes/TDBAPI.dll";
//        System.load(jniDll);
//        System.load(tdbDll);
//        System.out.println(jniDll);
    TdbController() {
        //服务器信息
        String ip = "";
        int port = 0;
        String username = "";
        String password = "";

        OPEN_SETTINGS setting = new OPEN_SETTINGS();
        setting.setIP(ip);
        setting.setPort(Integer.toString(port));
        setting.setUser(username);
        setting.setPassword(password);
        setting.setRetryCount(10);
        setting.setRetryGap(10);
        setting.setTimeOutVal(20);

        //代理时填写
		/*
		TDB_PROXY_SETTING proxy_setting = new TDB_PROXY_SETTING();
		proxy_setting.setProxyHostIp("0");
		proxy_setting.setProxyPort("0");
		proxy_setting.setProxyUser("1");
		proxy_setting.setProxyPwd("1");
		proxy_setting.setProxyType(3);
		*/

        ResLogin res = client.open(setting);
        //ResLogin res = client.openProxy(setting, proxy_setting);//代理时选择此open方式
        if (res==null) {
            System.out.println("Can't connect to " + ip);
            System.exit(-1);
        } else {
            System.out.println(res.getMarkets());
            int count = res.getMarkets();
            String[] market = res.getMarket();
            int[] dyndate = res.getDynDate();

            for (int i=0; i<count; i++) {
                System.out.println( market[i] + " " + dyndate[i]);
            }
        }
    }

    //获取K线数据
    @RequestMapping(value = "/getKLine",  method = RequestMethod.POST)
    public List<TdbKLine> getKLine(@RequestBody KLineParam kLineParam) {
        int m_nMaxOutputCount = 1000;
        if(kLineParam.getKey() != "00000") return null;

        ReqKLine req = new ReqKLine();
        req.setCode(kLineParam.getCode());       //Required
        req.setMarketKey(kLineParam.getMarketKey());//Required
        req.setCQFlag(kLineParam.getCqFlag());    //默认为0
        req.setCQDate(kLineParam.getCqDate());   //默认为0
        req.setQJFlag(kLineParam.getQjFlag());   //默认为0
        req.setCycType(kLineParam.getCycType()); //Required
        req.setCycDef(kLineParam.getCycDef());	 //Optional,default 1
        req.setAutoComplete(kLineParam.getAutoComplete()); //自动补齐(0:不补齐,1:补齐)
        req.setBeginDate(kLineParam.getBeginDate());         //Optional,default today
        req.setEndDate(kLineParam.getEndDate());             //Optional,default today
        req.setBeginTime(kLineParam.getBeginTime());   //开始时间
        req.setEndTime(kLineParam.getEndTime());       //结束时间

        KLine[] kline = client.getKLine(req);
        if (kline==null) {
            System.out.println("NetWork Error,getKline failed!");//网络断开，可根据此消息，调用Client.close()后重连
        }

        List<TdbKLine> tdbKLines = new ArrayList<>();
        int nIndex = 0;
        for(KLine k : kline) {
            if (nIndex++ > m_nMaxOutputCount) break;
            TdbKLine tdbKLine = new TdbKLine(k.getWindCode(), k.getCode(), k.getDate(), k.getTime(),
                    k.getOpen(), k.getHigh(), k.getLow(), k.getClose(), k.getVolume());
            tdbKLines.add(tdbKLine);
        }
        return tdbKLines;
    }

    //获取Tick数据
    @RequestMapping(value = "/getTick", method = RequestMethod.POST)
    public List<TdbTick> getTick(@RequestBody TickParam tickParam)
    {
        if(tickParam.getKey() != "0") return null;

        ReqTick req = new ReqTick();
        req.setCode(tickParam.getCode());       //Required
        req.setMarketKey(tickParam.getMarketKey());//Required
        req.setDate(tickParam.getDate());         //Optional,default today
        req.setBeginTime(tickParam.getBeginTime());   //开始时间
        req.setEndTime(tickParam.getEndTime());       //结束时间

        Tick[] tick = client.getTick(req);
        if (tick==null) {
            System.out.println("NetWork Error,getTick failed!");//网络断开，可根据此消息，调用Client.close()后重
            return null;
        }
        List<TdbTick> tdbTicks = new ArrayList<>();
        int nIndex = 0;
        for(Tick k : tick) {
            if (nIndex++ > m_nMaxOutputCount) break;
            TdbTick tdbTick = new TdbTick(k.getWindCode(), k.getCode(),
                    k.getDate(), k.getTime(), k.getPrice(), k.getVolume(),
                    k.getHigh(), k.getLow(), k.getOpen(), k.getPreClose(),
                    k.getAskPrice()[0], k.getAskVolume()[0], k.getBidPrice()[0], k.getBidVolume()[0]);
            tdbTicks.add(tdbTick);
        }
        return tdbTicks;
    }
}
