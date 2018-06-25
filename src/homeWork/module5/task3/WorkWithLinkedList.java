package homeWork.module5.task3;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 4/11/2018
 */


public class WorkWithLinkedList {

    protected Node start;

    protected Node end;

    public int size;

    public WorkWithLinkedList() {
        start = null;

        end = null;

        size = 0;
    }


    public int getSize()

    {
        return size;
    }

    public void insertAtStart(int val)

    {
        Node nptr = new Node(val, null);

        size++;

        if (start == null) {
            start = nptr;

            end = start;
        } else {
            nptr.setLink(start);

            start = nptr;
        }

    }

    public void insertAtEnd(int val)

    {
        Node nptr = new Node(val, null);

        size++;

        if (start == null) {
            start = nptr;

            end = start;
        } else {
            end.setLink(nptr);

            end = nptr;
        }

    }

    public void insertAtPos(int number, int position) {
        Node nptr = new Node(number, null);

        Node ptr = start;

        position = position - 1;

        for (int i = 1; i < size; i++) {
            if (i == position) {

                Node tmp = ptr.getLink();

                ptr.setLink(nptr);

                nptr.setLink(tmp);

                break;
            }
            ptr = ptr.getLink();
        }
        size++;
    }

    public void deleteAtPos(int position) {
        if (position == 1) {
            start = start.getLink();

            size--;

            return;
        }

        if (position == size) {
            Node s = start;

            Node t = start;

            while (s != end) {
                t = s;

                s = s.getLink();
            }
            end = t;

            end.setLink(null);

            size--;

            return;
        }

        Node ptr = start;

        position = position - 1;

        for (int i = 1; i < size - 1; i++) {

            if (i == position) {

                Node tmp = ptr.getLink();

                tmp = tmp.getLink();

                ptr.setLink(tmp);

                break;
            }
            ptr = ptr.getLink();
        }
        size--;
    }

    public void display() {

        System.out.print("\nSingly Linked List = ");

        if (size == 0) {
            System.out.print("empty\n");

            return;
        }

        if (start.getLink() == null) {
            System.out.println(start.getData());

            return;
        }

        Node ptr = start;

        System.out.print(start.getData() + "->");

        ptr = start.getLink();

        while (ptr.getLink() != null) {
            System.out.print(ptr.getData() + "->");

            ptr = ptr.getLink();
        }

        System.out.print(ptr.getData() + "\n");
    }


    public Object getElement(int index) {
        boolean flag = true;
        if (index < 0) {
            System.out.println("Incorrect index. Please enter index in range from 0  to " + (size - 1));
            flag = false;
        } else if (index > (size - 1)) {
            System.out.println("Incorrect index. Please enter index in range from 0 to " + (size - 1));
            flag = false;
        }
        Node tmp = start;
        if (flag) {
            for (int i = 0; i < index; i++) {
                tmp = tmp.getLink();
            }
            System.out.println("Value in index " + index + " is " + tmp.getData());
        }
        return tmp.getData();
    }
}

