/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortings;

/**
 *
 * @author will
 */
public class Model {
    private int[] intArray;
    private int arraySize;
    
    public void reset(int size){
        
    }
    
    public int[] getUnSortedList(){
        return intArray;
    }
    
    public int getSize(){
        return arraySize;
    }
    
    public void setSize(int size){
        arraySize=size;
    }
    
}
