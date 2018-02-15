package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Queue<T> {

    private int SIZE=0;
    private int userSize;
    private T[] array;
    int head = 0;
    int tail = -1;

    /**
     * constructor
     * @param c
     * @param size
     */

    public Queue(Class<T> c, int size) {
        this.userSize = size;
        T[] newArray = (T[]) Array.newInstance(c, size);
        this.array = newArray;
    }

    /**
     * Enquues element O(1)
     * @param data
     */

    public void enqueue(T data) {
        if (!isFull()) {
            tail++;
            if (tail == userSize - 1) {
                tail = 0;
            }
            array[tail] = data;
            SIZE++;
        } else {
            System.out.println("Cannot enqueue, queue full" + toString());
        }
    }

    /**
     * deques the element O(1)
     */
    public void dequeue() {
        if (!isEmpty()) {
            head++;
            if (head == userSize - 1) {
                head = 0;
            }
            SIZE--;
        } else {
            System.out.println("it's empty");
        }
    }


    /**
     * Returns the size of the array o(1)
     *
     * @return
     */
    public int getSIZE() {
        return userSize;
    }

    /**
     * Returns true if the array is not full
     *o(1)
     * @return
     */
    public boolean isFull() {
        if (SIZE == userSize) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns if the array is empty
     *o(1)
     * @return
     */
    public boolean isEmpty() {
        if (SIZE==0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * o(1) returns the string
     * @return
     */
    @Override
    public String toString() {
        return Arrays.toString(this.array);
    }
}
