package linkedlist;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestLinkedList {

    LinkedList<Integer> ll;

    @BeforeEach
    // 10-> 17 -> 1 -> null
    public void setUp(){
        ll = new LinkedList<>();
        ll.addLast(10);
        ll.addLast(17);
        ll.addLast(1);
    }

    @Test
    public void testAddLast() {
        assertEquals(10, ll.head.element);
        assertEquals(1, ll.head.next.next.element);
    }

    @Test
    public void testAddFirst() {
        ll.addFirst(2);
        assertEquals(10, ll.head.next.element);
        assertEquals(2, ll.head.element);
    }

    @Test
    public void testInsertAfter() {
        ll.insertAfter(17,5);
        assertEquals(5, ll.head.next.next.element);
        assertEquals(1, ll.head.next.next.next.element);
        ll.delete(10);
        ll.delete(17);
        ll.delete(5);
        ll.delete(1);
        ll.insertAfter(111,9);
        assertEquals(9, ll.head.element);
        ll.insertAfter(9,10);
        assertEquals(10, ll.head.next.element);
        ll.insertAfter(11,12);
        assertEquals(10, ll.head.next.element);
        assertEquals(2, ll.size);
    }

    @Test
    public void testDelete() {
        ll.delete(10); // 17 -> 1 -> null
        assertEquals(17, ll.head.element);

        ll.delete(1); // 17 -> null
        assertNull(ll.head.next);
        assertEquals(1, ll.size);

        ll.delete(17); // empty
        ll.addLast(2); // 2 -> null
        assertEquals(2, ll.head.element);
        assertNull(ll.head.next);
        assertEquals(1, ll.size);
        ll.delete(2);
        assertEquals(0, ll.size);
    }

    @Test
    public void testReverse() {
        ll.reverse();
        assertEquals(1, ll.head.element);
        assertEquals(17, ll.head.next.element);
        assertEquals(10, ll.head.next.next.element);
        assertNull(ll.head.next.next.next);
    }



}
