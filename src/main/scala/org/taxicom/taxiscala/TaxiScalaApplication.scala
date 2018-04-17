package org.taxicom.taxiscala

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.taxicom.taxiscala.beans.{Taxi, TaxiBill}
import org.taxicom.taxiscala.enums.TaxiMode
import org.taxicom.taxiscala.util.TaxiUtil
import org.taxicom.taxiscala.beans.TaxiBill

/**
  *
  * @author lihui  2018/4/17 上午10:39
  **/
@SpringBootApplication
class TaxiScalaApplication {

}

object TaxiScalaApplication{
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[TaxiScalaApplication], args.toString)

    println(TaxiUtil.computePrice(TaxiBill()))

    println(TaxiUtil.computePrice(TaxiBill(currentHour = 7)))


    println(TaxiUtil.computePrice(TaxiBill(currentHour = 0)))


    println(TaxiUtil.computePrice(TaxiBill(currentHour = 7,distance = 5)))


    println(TaxiUtil.computePrice(TaxiBill(currentHour = 0,distance = 5)))


    println(TaxiUtil.computePrice(TaxiBill(currentHour = 7,distance = 12)))


    println(TaxiUtil.computePrice(TaxiBill(currentHour = 0,distance = 12)))


    println(TaxiUtil.computePrice(TaxiBill(taxi = Taxi(mode = TaxiMode.OUTLINE),currentHour = 7,distance = 12)))

    println(TaxiUtil.computePrice(TaxiBill(taxi = Taxi(mode = TaxiMode.OUTLINE),currentHour = 0,distance = 12)))
  }
}
