/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsrunnablesexecutors;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Dresen_HP
 */
public class IncrementCounter 
{
    static class Counter
        {
            private AtomicInteger c = new AtomicInteger(0);

            public int increment() 
            {
                int result = c.getAndIncrement();
                return result;
            }
            public int value()
            {
                return c.get();
            }
        }
    
}
