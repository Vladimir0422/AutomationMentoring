package homeWork.module5.task3;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 4/11/2018
 */


public class Node {

    protected int data;

    protected Node link;

    public Node() {
        link = null;

        data = 0;
    }

    public Node(int d, Node n) {
        data = d;

        link = n;
    }

    public void setLink(Node n) {
        link = n;
    }

    public void setData(int d) {
        data = d;
    }

    public Node getLink() {
        return link;
    }

    public int getData() {
        return data;
    }
}
