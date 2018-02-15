package tests;

import com.company.DoublyLinkedOrderedList;
import com.company.Queue;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test {
    @Test
    public void testQueue() {
        int x = 1;
        Queue <Integer> newQueue = new Queue<>(Integer.class, 30);
        Queue <Integer> testQueue;
        testQueue = newQueue;
        newQueue.enqueue(x);
//        System.out.println(newQueue);
        assertEquals("testing ints on queue", testQueue, newQueue);

        String y = "uros";
        Queue <String > newQueue1 = new Queue<>(String.class, 30);
        Queue <String > testQueue1;
        testQueue1 = newQueue1;
        newQueue1.enqueue(y);
//        System.out.println(newQueue1);
        assertEquals("testing ints on queue", testQueue1, newQueue1);

        newQueue1.dequeue();
//        System.out.println(newQueue1);
        assertEquals("testing dequeue on first element", newQueue1, testQueue1);


        while (!newQueue1.isFull()){
            newQueue1.enqueue(y);
            System.out.println("1"+newQueue1);
        }
        assertEquals("does not exceed limits when filling and fills all spots", newQueue1, testQueue1);
    }

    @Test
    public void testDoublyLinkedList(){
        DoublyLinkedOrderedList list = new DoublyLinkedOrderedList();

        list.insert("uros");
        list.insert(1);
        list.insert(true);
        System.out.println(list.toString());

        list.remove(true);

        System.out.println(list.toString());

    }
}
