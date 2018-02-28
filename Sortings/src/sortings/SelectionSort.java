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

    @Override
    public void Sort(int[] array) {
       new Thread(() -> {
           
               //>>>>>>>>>>>>>sorting function here>>>>>>>>>remember to break!
               
               for (int i=0;i<array.length;i++){
                   int minIndex=i;
                   for (int j = array.length-1; j >i; j--) {
                       if (array[minIndex]>array[j]){
                           minIndex=j;
                       }
                       
                   }
                   swap(array,minIndex,i);
                   try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        System.out.println("error");
                    }
               }
               
               
               
               //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<remember to break!
               
           
       }).start();
    }
    
    void swap(int[] array, int x, int y){
        if (x==y) return;
        int temp=array[x];
        array[x]=array[y];
        array[y]=temp;
    }
    
}
