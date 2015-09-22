package com.webapp.other;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SumTest {

	static Log log = LogFactory.getLog(SumTest.class);
	public static void main(String[] args) {
		
		int sum=0;
		
		for (int i=1; i<10; i++) {
			sum += i;
			log.info(String.format("sum = %d, i=%d", sum, i));
		}
		
		log.info("total sum=" + sum);

	}

}
