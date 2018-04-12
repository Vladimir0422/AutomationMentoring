package homeWork.module5.task4;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 4/11/2018
 */


public class BinaryTree {
    public static void main(String[] args) {
        WorkWithBinaryTree tree = new WorkWithBinaryTree();
        tree.insert(57, 109);
        tree.insert(22, 213);
        tree.insert(41, 59);
        tree.print();
        tree.remove(22);
        tree.remove(41);
        tree.print();
        tree.remove(4);
        System.out.println("Searched value is " + tree.search(109));
    }
}
