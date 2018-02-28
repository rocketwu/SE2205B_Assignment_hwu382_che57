/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortings;

import java.util.Random;

/**
 *
 * @author will
 */
public final class Model {
    private int[] intArray;
    private int arraySize;
    private static final int DEFAULT_SIZE=60;

    public Model(int size){
        this.arraySize=size;
        this.reset(size);
    }
    
    public Model(){
        this(DEFAULT_SIZE);
}
    
    public void reset(int size){
        intArray=null;
        Random rand = new Random();
        int[] temp=new int[size];
        intArray=new int[size];
        
        for(int index=0;index<size;index++){
            temp[index]=index+1;
        }
        for(int index=0;index<size;index++){
            int r=rand.nextInt(size-index);
            intArray[index]=temp[r];
            temp[r]=temp[size-1-index];
        }
            
    }
    
    public int[] getUnSortedList(){
        return intArray;
    }
    
    public int getSize(){
        return arraySize;
    }
    
    public void setSize(int size){
        arraySize=size;
        reset(this.arraySize);
    }
    
    
    //<<<<<<<<<<<<<<<<<<<<<<<ARE WE ARROWED TO ADD EXTRA FUNCTION IN MODEL.JAVA? SINCE THE SCHEME DIDNT MENTION.<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    public boolean isSorted()
    {
        
        for (int i=1;i<intArray.length;i++)
        {
            if (intArray[i-1]!=(intArray[i]-1)) return false;
        }
        return true;
    }
    
}
