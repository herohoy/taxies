package org.taxicom.taxijava.util;

import org.taxicom.taxijava.beans.TaxiBill;
import org.taxicom.taxijava.enums.TaxiMode;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author lihui  2018/4/16 下午3:43
 **/
public class TaxiUtil {
    /**
     * 起步距离(公里数)
     */
    private static final int STARTING_DISTANCE;
    /**
     * 高阶价格计算距离(超过该公里数按高阶价格计算)
     */
    private static final int SENIOR_DISTANCE;
    /**
     * 起步价（日间）
     */
    private static final double STARTING_PRICE_DAY;
    /**
     * 起步价（夜间）
     */
    private static final double STARTING_PRICE_NIGHT;
    /**
     * 每公里价（日间）
     */
    private static final double PRICE_DAY;
    /**
     * 每公里价（夜间）
     */
    private static final double PRICE_NIGHT;
    /**
     * 每公里高阶价（日间）
     */
    private static final double SENIOR_PRICE_DAY;
    /**
     * 每公里夜间价（夜间）
     */
    private static final double SENIOR_PRICE_NIGHT;
    /**
     * 日班车起始时间（几点钟）
     */
    private static final int DAYTIME_START_POINT;
    /**
     * 夜班车起始时间（几点钟）
     */
    private static final int NIGHT_START_POINT;

    /**
     * 静态块，用于引入配置文件
     */
    static {
        Properties properties = new Properties();
        String path = Thread.currentThread().getContextClassLoader().getResource(
                "application.properties").getPath();
        try {
            properties.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        STARTING_DISTANCE = 3;
        SENIOR_DISTANCE = 10;
        STARTING_PRICE_DAY = 14;
        STARTING_PRICE_NIGHT = 18;
        PRICE_DAY = 2.5;
        PRICE_NIGHT = 3;
        SENIOR_PRICE_DAY = 3.5;
        SENIOR_PRICE_NIGHT = 4.7;
        DAYTIME_START_POINT = 6;
        NIGHT_START_POINT = 23;
    }

    /**
     * 传入订单，计算价格
     * @param bill
     * @return
     */
    public static double computePrice(TaxiBill bill){
        double result = 0;
        //超出高阶价公里数计算
        int senior = bill.getDistance() - SENIOR_DISTANCE < 0 ? 0 : bill.getDistance() - SENIOR_DISTANCE;
        //超出起步价公里数计算
        int normal = senior>0 ? SENIOR_DISTANCE - STARTING_DISTANCE :
                (bill.getDistance() - STARTING_DISTANCE<0 ? 0 : bill.getDistance() - STARTING_DISTANCE);
        //市区车
        if(bill.getTaxi().getMode()==TaxiMode.DOWNTOWN){
            //日间车
            if(bill.getCurrentHour() >= DAYTIME_START_POINT && bill.getCurrentHour() < NIGHT_START_POINT){
                result += STARTING_PRICE_DAY + PRICE_DAY*normal + SENIOR_PRICE_DAY*senior;
            }
            //夜间车
            else {
                result += STARTING_PRICE_NIGHT + PRICE_NIGHT*normal + SENIOR_PRICE_NIGHT*senior;
            }
        }
        //外环车
        else {
            //日间车
            if(bill.getCurrentHour() >= DAYTIME_START_POINT && bill.getCurrentHour() < NIGHT_START_POINT){
                result += STARTING_PRICE_DAY + PRICE_DAY*(normal + senior);
            }
            //夜间车
            else {
                result += STARTING_PRICE_NIGHT + PRICE_NIGHT*(normal + senior);
            }
        }
        return result;
    }

}
