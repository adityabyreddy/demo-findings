/**
 * Test cases for Secure Assist plug-in.
 * These focus on problems starting with user input.
 */
package com.just.test.test;

public class CodeCorrectThread implements Runnable {

	Thread th;

    public CodeCorrectThread(String str) {
        th = new Thread(this, str);
        th.start();
        th.stop();
        th.run();
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            if ((i % 10) == 0) {
                System.out.println(Thread.currentThread().getName() +
                        " is yielding control...");
                Thread.yield();
            }
        }
        
        System.out.println(Thread.currentThread().getName() +
                " has finished executing.");
    }

	
}
