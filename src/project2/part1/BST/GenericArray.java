package project2.part1.BST;

import java.util.Arrays;

public class GenericArray <E>{

    public GenericArray(E[] array) {
        this.array = array;
    }
    
    E [] array;
    int capacity;
    
    public GenericArray(){
    capacity = 1; // update 
    array = (E[])new Object[capacity];
    }
    
    public int insert (E item){ 
        int firstNull = 0;
        while(array[firstNull] != null ){
            firstNull++;
            if(firstNull >= capacity)
               array = Arrays.copyOf(array,capacity+=2);
        }
        array[firstNull] = item;  
        return firstNull;
    }
    
    public E get(int index){
        if(index >= capacity)
            return null;
        return array[index];
    }
    
    public E remove(int index){
        if(index >= capacity)
            return null; // 
        E deletedItem = array[index];
        array[index] = null;
        return deletedItem;
    }

    public String toString(){
        return Arrays.toString(array);
    }
}
