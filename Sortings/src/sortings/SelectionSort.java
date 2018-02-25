/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortings;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author will
 */
public class SelectionSort implements SortingsStrategy {

    public Thread thread;
    @Override
    public void Sort(int[] array) {
       thread= new Thread(() -> {
           while(true) {
               //>>>>>>>>>>>>>sorting function here>>>>>>>>>remember to break!
               
               
               
               //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<remember to break!
               try {
                   Thread.sleep(100);
               } catch (InterruptedException ex) {
                   System.out.println("error");
               }
           }
       });
       thread.start();
    }

    @Override
    public Thread getThread() {
        return thread;
    }
    
}
