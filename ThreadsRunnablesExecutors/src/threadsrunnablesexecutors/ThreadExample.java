/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsrunnablesexecutors;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dresen_HP
 */
public class ThreadExample extends Thread 
{
    private String threadMessage;
    
    public ThreadExample(String message) {
        this.threadMessage = message;
    }
            
    public void run() {
        try {
            sleep(1000);
            int value = ThreadsRunnablesExecutors.getMainCounter().increment();
            System.out.println(threadMessage + " from " + Thread.currentThread().getName() + ". Counter: " + value);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
}
