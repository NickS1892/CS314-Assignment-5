/*
 * Student information for assignment:
 * On my honor, <NAME>, this programming assignment is my own work
 * and I have not provided this code to any other student.
 * UTEID:
 * email address:
 * Number of slip days I am using:
 */

import java.util.Iterator;

public class LL314<E> implements IList<E> {
    private int size;
    private DoubleListNode<E> first;
    private DoubleListNode<E> last;

    public LL314(){

    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private DoubleListNode<E> head = first;

            @Override
            public boolean hasNext() {
                return head != null;
            }

            @Override
            public E next() {
                E result = head.data;
                head = head.next;
                return result;
            }
        };
    }


    public DoubleListNode<E> getNode(int pos){

        if(pos == size - 1){
            return last;
        }

        DoubleListNode<E> curr = first;
        for(int i = 0; i < pos; i++){
            curr = curr.next;
        }

        return curr;
    }


    public E set(int pos, E item){
        DoubleListNode<E> node = getNode(pos);
        E oldData = node.data;
        node.data = item;
        return oldData;
    }

    public int size(){
        return this.size;
    }


    public E remove(int pos) {
        if (pos == 0) {
            return removeFirst();
        } else if (pos == size - 1) {
            return removeLast();
        }

        DoubleListNode<E> prevNode = getNode(pos - 1);
        E data = prevNode.next.data;

        prevNode.next = prevNode.next.next;
        prevNode.next.prev = prevNode;

        size--;

        return data;
    }

    public boolean remove(E obj) {
        DoubleListNode<E> current = first;

        while (current != null) {
            if (current.data.equals(obj)) {

                if (current == first) {
                    removeFirst();
                } else if (current == last) {
                    removeLast();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                }

                return true;
            }

            current = current.next;
        }

        return false;
    }

    public void makeEmpty(){

    }


    //get element at pos
    public E get(int pos){
        return getNode(pos).data;
    }

    public IList<E> getSubList(int start, int stop){
        DoubleListNode<E> head = first;
        for(int i = 0; i < start; i++){
            head = head.next;
        }
        LL314<E> sublist = new LL314<E>();

        for(int i = start; i < stop; i++){
            sublist.add(head.data);
            head = head.next;
        }

        return sublist;
    }

    public int indexOf(E item){
        DoubleListNode<E> head = first;
        int idx = 0;

        while(head != null){
            if(head.data.equals(item)){
                return idx;
            }
            head = head.next;
            idx++;
        }
        return -1;
    }

    public int indexOf(E item, int pos) {
        DoubleListNode<E> head = getNode(pos);
        int index = pos;

        while (head != null) {
            if (head.data.equals(item)) {
                return index;
            }

            head = head.next;
            index++;
        }

        return -1;
    }
    /**
     * insert item to position in linkedlist
     * pre: item != null <br>
     * post: size is incremented by one, get(pos) = item
     */
    public void insert(int pos, E item){

        if(pos == 0){
            addFirst(item);
        }else if(pos == size){
            add(item);
        }else{ //default case
            DoubleListNode<E> prevNode = getNode(pos - 1);
            DoubleListNode<E> newNode = new DoubleListNode<>(prevNode, item, getNode(pos));
            prevNode.next = newNode;
            size++;
        }

    }

    public void add(E item){
        DoubleListNode<E> add = new DoubleListNode<>(last, item, null);
    }
    /**
     * add item to the front of the list. <br>
     * pre: item != null <br>
     * post: size() = old size() + 1, get(0) = item
     *
     * @param item the data to add to the front of this list
     */
    public void addFirst(E item) {
        if(item == null){
            throw new IllegalArgumentException("Item to add cannot be null");
        }

        if(size == 0){
            add(item);
        }else{
            DoubleListNode<E> nodeToAdd = new DoubleListNode<>(null, item, getNode(0));
            first = nodeToAdd;
            size++;
        }
    }

    /**
     * remove and return the first element of this list. <br>
     * pre: size() > 0 <br>
     * post: size() = old size() - 1
     *
     * @return the old first element of this list
     */
    public E removeFirst() {
        E data = first.data;
        first = first.next;
        size--;
        return data;
    }

    /**
     * remove and return the last element of this list. <br>
     * pre: size() > 0 <br>
     * post: size() = old size() - 1
     *
     * @return the old last element of this list
     */
    public E removeLast() {
        E data = last.data;
        last.prev = null;
        last = null;
        return data;
    }

    public void removeRange(int start, int stop){
        for(int i = start; i < stop;i++){
            remove(start);
        }
    }

    /**
     * A class that represents a node to be used in a linked list.
     * These nodes are doubly linked. All methods are O(1).
     *
     * @author Mike Scott
     * @version 9/25/2023
     */

    private static class DoubleListNode<E> {

        // the data to store in this node
        private E data;

        // the link to the next node (presumably in a list)
        private DoubleListNode<E> next;

        // the reference to the previous node (presumably in a list)
        private DoubleListNode<E> prev;

        /**
         * default constructor.
         * <br>pre: none
         * <br>post: data = null, next = null, prev = null
         * <br>O(1)
         */
        public DoubleListNode() {
            this(null, null, null);
        }

        /**
         * create a DoubleListNode that holds the specified data
         * and refers to the specified next and previous elements.
         * <br>pre: none
         * <br>post: this.data = data, this.next = next, this.prev = prev
         * <br>O(1)
         * @param prev the previous node
         * @param data the  data this DoubleListNode should hold
         * @param next the next node
         */
        public DoubleListNode(DoubleListNode<E> prev, E data, DoubleListNode<E> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }
}