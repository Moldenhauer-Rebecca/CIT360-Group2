/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsrunnablesexecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dresen_HP
 */
public class ThreadsRunnablesExecutors 
{
    private static IncrementCounter.Counter mainCounter;
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) 
    {           
        IncrementCounter.Counter counter = new IncrementCounter.Counter();
        mainCounter = counter;
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        Future<Integer> f1 = executor.submit(new CallableExample(5));
        Future<Integer> f2 = executor.submit(new CallableExample(3));
        Future<Integer> f3 = executor.submit(new CallableExample(2));
        
        Thread t1 = new ThreadExample("Hello.");
        t1.setName("t1");
        t1.start();
        
        (new ThreadExample("How are you?")).start();
        
        Runnable r1 = new RunnableExample(2);
        new Thread(r1, "t3").start();
        new Thread(r1, "t4").start();
       (new Thread(new RunnableExample(5))).start();
        
        try 
        {
            System.out.println("f1 result: " + f1.get());
            System.out.println("f2 result: " + f2.get());
            System.out.println("f3 result: " + f3.get());
        } 
        catch (InterruptedException ex) 
        {
            Logger.getLogger(ThreadsRunnablesExecutors.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (ExecutionException ex) 
        {
            Logger.getLogger(ThreadsRunnablesExecutors.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        executor.shutdown();
        try 
        {
            if(!executor.awaitTermination(1, TimeUnit.SECONDS))
            {
                executor.shutdownNow();
            }
        }
        catch (InterruptedException ex) 
        {
            executor.shutdown();
        }
                
        
        
    }
    public static IncrementCounter.Counter getMainCounter() 
    {
        return mainCounter;
    }
    
    
    
}
