package com.company;

import java.util.Random;

public class SinglyLinkedList<T> {
    //local variables
    private SinglyLinkedNode head;
    private SinglyLinkedNode tail;
    private int size;

    //constructor
    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    //inserting at the end
    public void regularInsert(T data) {
        SinglyLinkedNode newNode = new SinglyLinkedNode(data, null);
        //if the head is empty link to it else link from the tail
        if (head == null) {
            //setting the next node to head
            head.setNext(newNode);
            tail = head;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public void randomInsert(T data) {
        if (head == null) {
            System.out.println("Please insert at least one element first");
        } else {
            //generating random numbers
            Random rand = new Random();
            int randomN = rand.nextInt(size) + 0;
            //getting the first pointer
            SinglyLinkedNode randomNode = new SinglyLinkedNode(data, null);
            SinglyLinkedNode prevNode = head.getNextNode();
            SinglyLinkedNode nextNode = prevNode.getNextNode();
            //going to the random spot in the LL to insert a node
            for (int i = 0; i < randomN; i++) {
                prevNode = prevNode.getNextNode();
            }
            //inserting the random node
            nextNode = prevNode.getNextNode();
            prevNode.setNext(randomNode);
            randomNode.setNext(nextNode);
            size++;
        }
    }

    //removing the node x
    public void remove(T dataToRemove) {
        if (head != null) {
            SinglyLinkedNode node = head;
            SinglyLinkedNode prevNode = head;

            //finding the node with the given data
            int i = 0;
            while (i < size) {
                if (node.getData() == dataToRemove) {
                    break;
                }
                //accounting for the first and second node
                prevNode = node;
                node = node.getNextNode();
                i++;
            }
            //removing the node by setting the previous node to link to the next node
            prevNode.setNext(node.getNextNode());
            size--;
        } else {
            System.out.println("The list is empty");
        }
    }

    public SinglyLinkedNode getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {

        String finalString = "";
        if (size != 0) {
            SinglyLinkedNode node = head;
            for (int i = 0; i < size; i++) {
                finalString = "[" + head.toString() + "]";
                if (i < size - 2) {
                    finalString = finalString + ",";
                }
            }
            return finalString;
        } else {
            return "[]";
        }
    }
}
