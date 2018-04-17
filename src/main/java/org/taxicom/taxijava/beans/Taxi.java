package org.taxicom.taxijava.beans;

import org.taxicom.taxijava.enums.TaxiMode;
//import com.taxiorg.enums.TaxiTimeline;

//import java.util.Calendar;

/**
 * @author lihui  2018/4/16 下午4:00
 **/
public class Taxi {
    private TaxiMode mode = TaxiMode.DOWNTOWN;

    /** (不再使用该方式，改为在订单类中定义时间的 小时 数值)
     * 昼夜班次（如不传入参数，则根据当前时间自动判断）
     * 时间段的两点 可用配置文件进行设置
     */
//    private TaxiTimeline timeline = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)>=6 &&
//            Calendar.getInstance().get(Calendar.HOUR_OF_DAY)<23 ?
//            TaxiTimeline.DAY_TIME : TaxiTimeline.NIGHT_TIME;


    public TaxiMode getMode() {
        return mode;
    }

    public void setMode(TaxiMode mode) {
        this.mode = mode;
    }

}
