package org.taxicom.taxiscala.util

import org.taxicom.taxiscala.beans.TaxiBill
import org.taxicom.taxiscala.enums.TaxiMode


/**
  *
  * @author lihui  2018/4/17 上午11:14
  **/
object TaxiUtil {
  //读取配置文件的操作，暂不使用
  /*
  val properties = new (java.util.Properties)
  val path = (java.lang.Thread).currentThread.getContextClassLoader.getResource(
    "a.properties").getPath
  properties.load(new (java.io.FileInputStream)(path))
  */

  val STARTING_DISTANCE: Int = 3
  val SENIOR_DISTANCE = 10
  val STARTING_PRICE_DAY = 14
  val STARTING_PRICE_NIGHT = 18
  val DAYTIME_START_POINT = 6
  val NIGHT_START_POINT = 23

  val PRICE_DAY: Double = 2.5
  val PRICE_NIGHT = 3.0
  val SENIOR_PRICE_DAY = 3.5
  val SENIOR_PRICE_NIGHT = 4.7

  def computePrice(bill:TaxiBill):Double = {
    val senior = if(bill.distance - SENIOR_DISTANCE < 0) 0 else bill.distance - SENIOR_DISTANCE
    val normal: Int = if(senior>0) {
      SENIOR_DISTANCE - STARTING_DISTANCE
    }else if(bill.distance - STARTING_DISTANCE < 0){
      0
    }else{
      bill.distance - STARTING_DISTANCE
    }
    bill.taxi.mode match {
      case TaxiMode.DOWNTOWN => {
        if(bill.currentHour >= DAYTIME_START_POINT && bill.currentHour < NIGHT_START_POINT)
          STARTING_PRICE_DAY + PRICE_DAY * normal + SENIOR_PRICE_DAY * senior
        else
          STARTING_PRICE_NIGHT + PRICE_NIGHT * normal + SENIOR_PRICE_NIGHT * senior
      }
      case _ => {
        if(bill.currentHour >= DAYTIME_START_POINT && bill.currentHour < NIGHT_START_POINT)
          STARTING_PRICE_DAY + PRICE_DAY * (normal + senior)
        else
          STARTING_PRICE_NIGHT + PRICE_NIGHT * (normal + senior)
      }
    }
  }
}
