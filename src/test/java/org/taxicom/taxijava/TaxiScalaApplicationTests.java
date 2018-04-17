package org.taxicom.taxijava;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.taxicom.taxijava.beans.TaxiBill;
import org.taxicom.taxijava.util.TaxiUtil;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class TaxiScalaApplicationTests {

//	@Test
	public void contextLoads() {
		System.out.println("java mode:");
		System.out.println(TaxiUtil.computePrice(new TaxiBill()));
	}

}
