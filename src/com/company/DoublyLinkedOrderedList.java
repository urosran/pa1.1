package com.company;

public class DoublyLinkedOrderedList<T> implements Comparable<T> {
    /**
     * Local variables
     */
    private int size = 0;
    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;

    /**
     * Constructor
     */
    public DoublyLinkedOrderedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    /**
     * inserts the node
     * O(n)
     *
     * @param data
     */

    public void insert(T data) {
        if (head == null) {
            head = new DoublyLinkedNode(null, null, data);
            size++;
        } else {
            DoublyLinkedNode node = head;
            DoublyLinkedNode prev = head;

            while (node.getNextNode() != null) {
                if (node.compareTo(node.getNextNode().getData()) == -1) {
                    //exit the loop you are at the node that is smaller than the next one
                    break;
                }
                prev = node;
                node = node.getNextNode();
            }

            DoublyLinkedNode insert = new DoublyLinkedNode(node, node.getNextNode(), data);
            prev.setNextNode(insert);
            node.getNextNode().setPreviousNode(insert);
            size++;
        }
    }


    /**
     * Removes the first node with the given data O(n)
     *
     * @param dataToRemove
     */
    public void remove(T dataToRemove) {
        if (head != null) {
            DoublyLinkedNode node = head;
            DoublyLinkedNode prevNode = head;
            DoublyLinkedNode nextNode = head;
            //finding the node with the given data
            int i = 0;
            while (i <= size) {
                if (node.getData() == dataToRemove) {
                    break;
                }
                node=node.getNextNode();
                i++;
            }
            //accounting for the first and second node
            prevNode = node.getPreviousNode();
            nextNode = node.getNextNode();

            //setting the pointer of the node before the deleted one to point to the
            //one after the
            if (prevNode != null) {
                prevNode.setNextNode(node.getNextNode());
            } else {
                //in case we want to remove the head, the 2nd node becomes the head
                head = node.getNextNode();
            }
            //setting the previous pointer of the node after the deleted node
            //to point to the node before the deleted node
            nextNode.setPreviousNode(prevNode);
            size--;
        } else {
            System.out.println("The list is empty");
        }
    }


    /**
     * Method to get the head
     * O(1)
     *
     * @return
     */
    public DoublyLinkedNode getHead() {
        return head;
    }

    /**
     * Method to get a tail
     * O(1)
     *
     * @return
     */
    public DoublyLinkedNode getTail() {
        return tail;
    }

    @Override
    public int compareTo(T o) {
        return 0;
    }

    /**
     * Returns String representation of the doubly linked list
     * O(n)
     *
     * @return
     */
    @Override
    public String toString() {

        String finalString = "";
        if (size != 0) {
            DoublyLinkedNode node = head;
            for (int i = 0; i < size; i++) {
                finalString = finalString + "[" + node.toString() + "]";
                if (i < size - 1) {
                    finalString = finalString + ",";
                }
                node = node.getNextNode();
            }
            return finalString;
        } else {
            return "[]";
        }
    }
}
