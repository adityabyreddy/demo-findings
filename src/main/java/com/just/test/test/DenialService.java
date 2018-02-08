/**
 * Test cases for Secure Assist plug-in.
 * These focus on problems starting with user input.
 */
package com.just.test.test;

import org.apache.commons.lang.math.NumberUtils;



public class DenialService {

	public double testDenial() {
		String str = "20.01";
		
		Double d = null;
		try {
			d = Double.parseDouble(str);
		} catch(Exception e) {
			//
		}
		return d;
	}
	
	
	public double testDenial2() {
		String str = "20.01";
		
		Double d = null;
		try {
			d = NumberUtils.createDouble(str);
		} catch(Exception e) {
			//
		}
		return d;
	}
}
