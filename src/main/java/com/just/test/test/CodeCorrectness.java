/**
 * Test cases for Secure Assist plug-in.
 * These focus on problems starting with user input.
 */
package com.just.test.test;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.Reference;
import java.nio.ByteBuffer;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class CodeCorrectness {
	
	public String className() {
		String classname = "";
		if(this.getClass().getName().equals("CodeCorrectness")) {
			classname =  this.getClass().getName();
		}
		return classname;
	}

	public String simpleDate() {
		
		String s;
		Format formatter;
		Date date = new Date();
		
		// 01/09/02
		formatter = new SimpleDateFormat("MM/dd/yy");
		s = formatter.format(date);
		return s;
	}
	
	public String tmpFile() throws IOException {
		File tmp = File.createTempFile("test",".tmp");
		return tmp.getAbsolutePath();
	}
	
	@SuppressWarnings("deprecation")
	public void datasteam() throws IOException {
		File file = new File("C:/data.txt");
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        while (dis.available() != 0) {
                System.out.println(dis.readLine());
        }
        dis.close();		
	}
	
	public void gc() {
		HashMap<String,Boolean> map = new HashMap<String,Boolean>();
		
		map.put("test", true);
		map.put("test1", false);
		System.gc();
		map.put("test2", true);
		System.gc();
	}
	
	public void yield() {
		HashMap<String,Boolean> map = new HashMap<String,Boolean>();
		
		map.put("test", true);
		map.put("test1", false);
		System.gc();
		map.put("test2", true);
		System.gc();
	}
	
	public static ByteBuffer copy(ByteBuffer b) {
	    byte[] oldBytes = b.array();
	    byte[] copiedBytes = new byte[oldBytes.length];
	    
	    System.arraycopy(oldBytes, 0, copiedBytes, 0, oldBytes.length);
	    ByteBuffer duplicate = ByteBuffer.wrap(copiedBytes);
	    return duplicate;
	}
	
	public void finalize() throws Throwable {
	    try {
	    	  System.out.println("finalize");
	    } finally {
	        super.finalize();
	    }
	}
	
}
