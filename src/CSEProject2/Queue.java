/**
* author: Dilara Ünbay
* twitter: twitter.com/bjornikof
* 
* The MIT License (MIT)
*
* Copyright (c) 2019 Dilara Ünbay
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in all
* copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
* SOFTWARE.
 */
package CSEProject2;

import java.util.NoSuchElementException;

/**
 * @param <T>
 */
public class Queue<T> {
       private T[] q; // array of elements  
    int N = 0; // number of elements on queue private 
    int first = 0; // index of first element of queue 
    private int last = 0; // index of next available slot

    public Queue(int size) {
        q = (T[]) new Object[size];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    // Dequeue remove the first data
    public void enqueue(T item) {
        // double size of array if necessary and recopy to front of array
        if (N == q.length) {
            resize(2 * q.length);   // double size of array if necessary
        }
        q[last++] = item;                        // add item
        if (last == q.length) {
            last = 0;          // wrap-around
        }
        N++;
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     *
     * @return the item on this queue that was least recently added
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow!");
        }
        T item = q[first];
        q[first] = null;                            // to avoid loitering
        N--;
        first++;
        if (first == q.length) {
            first = 0;           // wrap-around
        }        // shrink size of array if necessary
        if (N > 0 && N == q.length / 4) {
            resize(q.length / 2);
        }
        return item;
    }

    
      
     public String infoQueue(){
         System.out.println("Next five candies;"); 
         String s="";
        for (int i = 0; i < 5; i++) {
            if(N<5){
                if(q[(first + i) % q.length]==null){
                    s+=" x ";
                }
                else{
                Candy c = (Candy)(q[(first + i) % q.length]);
            c.info();
                }   
            }
            Candy c = (Candy)(q[(first + i) % q.length]);
            c.info();
        }
        return s;
    }


    public void resize(int newSize) {

        T[] temp = (T[]) new Object[newSize];
        for (int i = 0; i < N; i++) {
            temp[i] = q[i];
        }
        q = temp;
        first = 0;
        last = N;
    }

    public int search(T key) {

        for (int i = 0; i < N; i++) {
            if (q[(first + i) % q.length].equals(key)) {
                return i;
            }
        }
        return -1;

    }
}
