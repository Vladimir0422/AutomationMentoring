package homeWork.module5.task3;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 4/11/2018
 */


public class Node<T> {

    protected T data;

    protected Node link;

//    public Node() {
//        link = null;
//
//        data = 0;
//    }

    public Node(T d, Node n) {
        data = d;

        link = n;
    }

    public void setLink(Node n) {
        link = n;
    }

    public void setData(T d) {
        data = d;
    }

    public Node getLink() {
        return link;
    }

    public T getData() {
        return data;
    }
}
