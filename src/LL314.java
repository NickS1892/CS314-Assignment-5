/*  Student information for assignment:
 *
 *  On my honor, <Nick Sin>, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  email address: nicksin@utexas.edu
 *  UTEID:ns39543
 *  Number of slip days used on this assignment: 0
 */

import java.util.Iterator;

public class LL314<E> implements IList<E> {
    private int size;
    private DoubleListNode<E> first;
    private DoubleListNode<E> last;

    public LL314(){

    }

    /**
     * Return an Iterator for this list. <br>
     * pre: none <br>
     * post: return an Iterator object for this List <br>
     * O(1) - creates and returns a new iterator object
     */
    public Iterator<E> iterator() {
        return new LL314Iterator();
    }


    //class to create an iterator for LL314
    private class LL314Iterator implements Iterator<E>{

            private DoubleListNode<E> head = first;

            //node most recently called on by next()
            private DoubleListNode<E> lastReturned = null;


            /**
             * O(1) method, just checks if head (current node) is null
             * @return true if there are more elements to iterate over, false otherwise
             */
            @Override
            public boolean hasNext() {
                return head != null;
            }

            /**
             * Advances iterator and returns the next element. Saves node in lastReturned
             * so remove() can simply look it up rather than search for it again.
             * O(1) - follows pointer and updates current reference
             * @return next node's data
             */
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }

                lastReturned = head;
                E result = head.data;
                head = head.next;

                return result;
            }

            /**
             * Removes node most recently called by next().
             * next() must be called before, throws IllegalStateException() otherwise
             * O(1) - only small pointer updates, no traversing
             */
            @Override
            public void remove(){
                //nothing to return
                if (lastReturned == null) {
                    throw new IllegalStateException();
                }


                if (lastReturned == first) {
                    removeFirst();
                } else if (lastReturned == last) {
                    removeLast();
                } else {
                    lastReturned.prev.next = lastReturned.next;
                    lastReturned.next.prev = lastReturned.prev;
                    size--;
                }

                lastReturned = null;
            }
        }

    /**
     * Gets an element from the list <br>
     * pre: 0 <= pos < size() <br>
     * post: node at pos <br>
     * O(N) - searches up to N nodes to reach pos
     *
     * @param pos the index to search at
     * @return node at given position in the list
     */
    private DoubleListNode<E> getNode(int pos){

        if(pos < 0 || pos >= size()){
            throw new IllegalArgumentException("Pos must be in bounds");
        }
        if(pos == size - 1){
            return last;
        }

        DoubleListNode<E> curr = first;
        for(int i = 0; i < pos; i++){
            curr = curr.next;
        }

        return curr;
    }


    /**
     * Sets node at pos data to new given element
     * @param pos the position in the list to overwrite
     * @param item the new item that will overwrite the old item,
     * item != null
     * O(N) - searches up to N nodes and then swaps data at pos
     * @return data of node before setting to a new element
     */
    public E set(int pos, E item){
        if(item == null){
            throw new IllegalArgumentException("Element to be set to cannot be null.");
        }

        if(pos < 0 || pos >= size()){
            throw new IllegalArgumentException("Pos must be in bounds.");
        }
        DoubleListNode<E> node = getNode(pos);
        E oldData = node.data;
        node.data = item;
        return oldData;
    }

    //returns size of this LL314
    //O(1) - just uses instance variable that is updated throughout the class
    public int size(){
        return this.size;
    }


    /**
     * Removes and return an element at the pos. <br>
     * pre: 0 <= pos < size() <br>
     * post: size() - 1 and element removed <br>
     * O(N) - must traverse up to N nodes to reach pos
     *
     * @param pos specifies which element to get
     * @return the element at the specified position in the list
     */
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

    /**
     * Removes first occurrence of the specified object from this list.
     * <br>pre: none
     * <br>post: if obj is found, its first occurrence is removed and
     * size() is decreased by one; otherwise the list is unchanged
     * <br>O(N) - may need to search through the entire list
     *
     * @param obj the object to remove
     * @return true if an element was removed, false otherwise
     */
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

    /**
     * Removes all elements from this list.
     * <br>pre: none
     * <br>post: size() = 0, first = null, last = null
     * <br>O(1) - only resets the list references and size
     */
    public void makeEmpty(){
        first = null;
        last = null;
        size = 0;
    }


    /**
     * Gets an element from the list at pos.
     * <br>pre: 0 <= pos < size()
     * <br>post: returns the item at position pos
     * <br>O(N) - may need to traverse up to N nodes to reach pos
     *
     * @param pos specifies which element to get
     * @return the element at the specified position
     * @throws IllegalArgumentException if pos is outside the valid range
     */
    public E get(int pos){
        //pre cons checked by getNode() method
        return getNode(pos).data;
    }

    /**
     * Returns a new list containing the elements from start, inclusive,
     * to stop, exclusive.
     * <br>pre: 0 <= start <= stop <= size()
     * <br>post: returned list contains the elements from start through stop - 1
     * <br>O(N) - traverses the list to reach start and copies the requested elements
     *
     * @param start the starting position, inclusive
     * @param stop the ending position, exclusive
     * @return a new list containing the specified range of elements
     */
    public IList<E> getSubList(int start, int stop){
        if (start < 0 || start > stop || stop > size()) {
            throw new IllegalArgumentException("Start and stop must be in bounds.");
        }
        DoubleListNode<E> head = first;
        for(int i = 0; i < start; i++){
            head = head.next;
        }
        LL314<E> sublist = new LL314<>();

        for(int i = start; i < stop; i++){
            sublist.add(head.data);
            head = head.next;
        }

        return sublist;
    }

    /**
     * Returns the position of the first occurrence of the specified item.
     * <br>pre: item != null
     * <br>post: returns the index of the first occurrence of item,
     * or -1 if item is not found
     * <br>O(N) - may search through the entire list
     *
     * @param item the item to search for
     * @return the index of the first occurrence of item, or -1 if not found
     */
    public int indexOf(E item){
        if(item == null){
            throw new IllegalArgumentException("Item to search for cannot be null");
        }

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

    /**
     * find the position of an element in the list starting
     * at a specified position.
     * <br>pre: 0 <= pos < size(), item != null
     * <br>post: return the index of the first element equal
     * to item starting at pos
     * or -1 if item is not present from position pos onward
     * <br>O(N) - may search through the remainder of the list
     *
     * @param item the element to search for in the list. Item != null
     * @param pos the position in the list to start searching from
     * @return starting from the specified position
     * return the index of the first element equal to item
     * or a -1 if item is not present between pos
     * and the end of the list
     */
    public int indexOf(E item, int pos) {
        if(item == null){
            throw new IllegalArgumentException("Item to search for cannot be null");
        }

        if(pos < 0 || pos >= size()){
            throw new IllegalArgumentException("Pos must be in bounds");
        }

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
     * Insert an item at a specified position in the list.
     * <br>pre: 0 <= pos <= size(), item != null
     * <br>post: size() = old size() + 1, get(pos) = item,
     * all elements in the list with a positon >= pos have a
     * position = old position + 1
     *
     * O(N) worst case, calls getNode() up to N nodes
     * @param pos the position to insert the data at in the list
     * @param item the data to add to the list, item != null
     */
    public void insert(int pos, E item){
        if(item == null){
            throw new IllegalArgumentException("Element to be added cannot be null");
        }

        if(pos < 0 || pos > size()){
            throw new IllegalArgumentException("Pos must be in bounds");
        }

        if(pos == size()){
            add(item);
        }else if(pos == 0){
            DoubleListNode<E> newNode = new DoubleListNode<>(null, item, first);
            first.prev = newNode;
            first = newNode;
            size++;
        }else{ //default case
            DoubleListNode<E> nextNode = getNode(pos);
            DoubleListNode<E> prevNode = nextNode.prev;
            DoubleListNode<E> newNode = new DoubleListNode<>(prevNode, item, nextNode);
            prevNode.next = newNode;
            nextNode.prev = newNode;
            size++;
        }

    }

    /**
     * Adds an item to the end of the list.
     * <br>pre: item != null
     * <br>post: size() = old size() + 1 and the new item is at the end
     * <br>O(1) - directly uses the last node reference
     *
     * @param item the item to add to the end of this list
     * @throws IllegalArgumentException if item is null
     */
    public void add(E item) {
        if (item == null) {
            throw new IllegalArgumentException("Item to add cannot be null");
        }

        DoubleListNode<E> newNode = new DoubleListNode<>(last, item, null);

        if (size == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }

        size++;
    }
    /**
     * Adds an item to the front of the list.
     * <br>pre: item != null
     * <br>post: size() = old size() + 1 and get(0) = item
     * <br>O(N) - calls insert(0, item), takes a single node and updates pointers without traversing
     *
     * @param item the data to add to the front of this list
     * @throws IllegalArgumentException if item is null
     */
    public void addFirst(E item) {
        if(item == null){
            throw new IllegalArgumentException("Item to add cannot be null");
        }

        insert(0, item);
    }

    /**
     * remove and return the first element of this list. <br>
     * pre: size() > 0 <br>
     * post: size() = old size() - 1
     * O(1) - only updates the first reference and size
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
     * O(1) - only updates the last reference and size
     *
     * @return the old last element of this list
     */
    public E removeLast() {
        E data = last.data;

        if (size == 1) {
            first = null;
            last = null;
        } else {
            last = last.prev;
            last.next = null;
        }

        size--;
        return data;
    }

    /**
     * Removes all elements from start, inclusive, to stop, exclusive.
     * <br>pre: 0 <= start <= stop <= size()
     * <br>post: all elements from start through stop - 1 are removed
     * <br>O(N^2) - repeatedly calls remove(start), which may traverse the list
     *
     * @param start the starting position, inclusive
     * @param stop the ending position, exclusive
     */
    public void removeRange(int start, int stop){
        if (start < 0 || start > stop || stop > size()) {
            throw new IllegalArgumentException("Start and stop must be in bounds.");
        }

        for(int i = start; i < stop;i++){
            remove(start);
        }
    }

    /**
     * Returns a String representation of this list.
     * <br>pre: none
     * <br>post: returns a string containing all elements in list order
     * <br>O(N) - visits every node in the list once
     *
     * @return a String representation of this list
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        DoubleListNode<E> head = first;

        while (head != null) {
            sb.append(head.data);

            if (head.next != null) {
                sb.append(", ");
            }

            head = head.next;
        }

        sb.append("]");
        return sb.toString();
    }


    /**
     * Determines whether this list is equal to another object.
     * Two LL314 lists are equal if they contain the same number of elements
     * and the elements occur in the same order.
     * <br>pre: none
     * <br>post: returns true if the other object represents an equal list,
     * false otherwise
     * <br>O(N^2) - may compare every element in both lists
     *
     * @param other the object to compare with this list
     * @return true if the two lists contain the same elements in the same order,
     *         false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || !(other instanceof LL314)) {
            return false;
        }

        IList<?> otherList = (IList<?>) other;

        if (this.size != otherList.size()) {
            return false;
        }

        DoubleListNode<E> current1 = this.first;

        for(int i = 0; i < size; i++){
            if(!current1.data.equals(otherList.get(i))){
                return false;
            }
            current1 = current1.next;
        }
        return true;
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