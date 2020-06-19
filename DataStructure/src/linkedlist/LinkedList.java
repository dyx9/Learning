package linkedlist;

import javax.print.attribute.standard.SheetCollate;

public class LinkedList<E> {

    static class Node<E> {
        E element;
        Node<E> next;

        Node(E e) {
            element = e;
            next = null;
        }
    }

    public Node<E> head;
    public int size;

    public void addLast(E e) {
        Node<E> node = new Node<>(e);
        Node<E> temp = head;
        if (temp == null) {
            head = node;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        size++;
    }

    public void addFirst(E e) {
        Node<E> node = new Node<>(e);
        if (head != null) {
            node.next = head;
        }
        head = node;
        size++;
    }

    public void insertAfter(E after, E e) {
        if (!contains(after) && size != 0) {
            System.out.println(after + " Not Found");
        }
        else {
            Node<E> newNode = new Node<>(e);
            if (head == null) head = newNode;
            else {
                Node<E> node = head;
                while (!node.element.equals(after) && node.next != null) {
                    node = node.next;
                }
                if (node.element.equals(after)) {
                    newNode.next = node.next;
                    node.next = newNode;
                }
            }
            size++;
        }
    }

    public void insertBefore (E before, E e) {

    }

    public boolean contains(E e) {
        if (head == null) return false;
        else {
            Node<E> node = head;
            while (!node.element.equals(e) && node.next != null) {
                node = node.next;
            }
            return node.element.equals(e);
        }
    }

    public void delete(E e) {
        if (size > 0) {
            Node<E> node = head;
            Node<E> pre = null;
            while (!node.element.equals(e) && node.next != null) {
                pre = node;
                node = node.next;
            }
            if (node.element.equals(e)) {
                if (pre == null) {
                    if (head.next != null) {
                        head = head.next;
                    }
                    else {
                        head = null;
                    }
                }
                else {
                    pre.next = node.next;
                }
                size--;
            }
        }
        else {
            System.out.println("List is empty");
        }

    }

    public void reverse() {
        Node<E> current = head;
        Node<E> pre = null;
        while (current != null) {
            Node<E> next = current.next;
            current.next = pre;
            pre = current;
            current = next;

            if (next != null) {
                head = next;
            }
        }
    }

    public void printList(){
        if (size == 0) {
            System.out.println("Empty");
        }
        else {
            Node<E> temp = head;
            while (temp != null){
                System.out.print(temp.element + ", ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
}
