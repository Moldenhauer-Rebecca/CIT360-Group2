/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsrunnablesexecutors;

/**
 *
 * @author Dresen_HP
 */
public class RunnableExample implements Runnable      
{
    private Integer runnableNumber;
    
    public RunnableExample(Integer number)
    {
       this.runnableNumber = number; 
    }
    
    public void run() 
    {
        int value = ThreadsRunnablesExecutors.getMainCounter().increment();
        System.out.println("Thread " + Thread.currentThread().getName() + " wants " + runnableNumber * 3 + " pizzas. Counter: " 
                 + value);
        
    }
    
}
