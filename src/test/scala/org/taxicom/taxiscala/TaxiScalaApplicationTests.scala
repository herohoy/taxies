package org.taxicom.taxiscala

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.taxicom.taxiscala.beans.TaxiBill
import org.taxicom.taxiscala.util.TaxiUtil

/**
  *
  * @author lihui  2018/4/17 下午12:07
  **/
object TaxiScalaApplicationTests {

}

@RunWith(classOf[SpringRunner])
@SpringBootTest
class TaxiScalaApplicationTests{

  @Test
  def contextLoads(): Unit = {
    println("scala mode:")
    println(TaxiUtil.computePrice(TaxiBill()))
  }
}
