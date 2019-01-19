/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsrunnablesexecutors;

import java.util.concurrent.Callable;

/**
 *
 * @author Dresen_HP
 */
public class CallableExample implements Callable<Integer>
{
    public Integer cNumber;
    
    public CallableExample(Integer number)
    {
        this.cNumber = number;
    }
    
    @Override
    public Integer call() throws Exception {
        int result = 1;
        result = cNumber * cNumber;
        int value = ThreadsRunnablesExecutors.getMainCounter().increment();
        System.out.println(cNumber +" squared is " + result + ". Thread: " + Thread.currentThread().getName() + ". Counter: " 
                +  value);
        return result;
        
    }
}
    

