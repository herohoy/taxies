package org.taxicom.taxijava.beans;

import java.util.Calendar;

/**
 * 一趟出租车行程的订单
 * @author lihui  2018/4/16 下午4:20
 **/
public class TaxiBill {
    private Taxi taxi = new Taxi();
    private int distance = 0;

    /**
     * 接单时间（用于判断昼班还是夜班）
     */
    private int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);


    public Taxi getTaxi() {
        return taxi;
    }

    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getCurrentHour() {
        return currentHour;
    }

    public void setCurrentHour(int currentHour) {
        this.currentHour = currentHour;
    }

}
