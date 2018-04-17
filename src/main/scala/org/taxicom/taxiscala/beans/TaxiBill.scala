package org.taxicom.taxiscala.beans

import java.util.Calendar

/**
  *
  * @author lihui  2018/4/17 上午11:06
  **/
case class TaxiBill(
                     taxi:Taxi = new Taxi,
                     distance:Int = 0,
                     currentHour:Int = Calendar.getInstance.get(Calendar.HOUR_OF_DAY)
                   ) {

}
