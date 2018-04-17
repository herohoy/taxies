package org.taxicom.taxijava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.taxicom.taxijava.beans.Taxi;
import org.taxicom.taxijava.beans.TaxiBill;
import org.taxicom.taxijava.enums.TaxiMode;
import org.taxicom.taxijava.util.TaxiUtil;

//@SpringBootApplication
public class TaxiScalaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxiScalaApplication.class, args);

		Taxi t = new Taxi();
		TaxiBill b = new TaxiBill();
		System.out.println(TaxiUtil.computePrice(b));

		b.setCurrentHour(7);
		System.out.println(TaxiUtil.computePrice(b));

		b.setCurrentHour(0);
		System.out.println(TaxiUtil.computePrice(b));

		b.setCurrentHour(7);
		b.setDistance(5);
		System.out.println(TaxiUtil.computePrice(b));

		b.setCurrentHour(0);
		b.setDistance(5);
		System.out.println(TaxiUtil.computePrice(b));

		b.setCurrentHour(7);
		b.setDistance(12);
		System.out.println(TaxiUtil.computePrice(b));

		b.setCurrentHour(0);
		b.setDistance(12);
		System.out.println(TaxiUtil.computePrice(b));

		t.setMode(TaxiMode.OUTLINE);
		b.setTaxi(t);
		b.setCurrentHour(7);
		b.setDistance(12);
		System.out.println(TaxiUtil.computePrice(b));

		b.setCurrentHour(0);
		b.setDistance(12);
		System.out.println(TaxiUtil.computePrice(b));
	}
}
