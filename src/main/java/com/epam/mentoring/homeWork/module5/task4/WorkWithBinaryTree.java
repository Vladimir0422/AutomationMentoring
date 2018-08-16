package com.epam.mentoring.homeWork.module5.task4;

/**
 * Created by : Volodymyr_Silitskyi
 * Created at : 4/11/2018
 */


public class WorkWithBinaryTree {
    Node root;

    static class Node {
        int key;
        int value;
        Node parent;
        Node leftChild;
        Node rightChild;

        public Node(int key, int value, Node parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }
    }

    public void insert(int key, int value) {
        root = insert(root, null, key, value);
    }

    private Node insert(Node newRoot, Node parent, int key, int value) {
        if (newRoot == null) {
            newRoot = new Node(key, value, parent);
        } else {
            if (key < newRoot.key){
                newRoot.leftChild = insert(newRoot.leftChild, newRoot, key, value);
            } else {
                newRoot.rightChild = insert(newRoot.rightChild, newRoot, key, value);
            }
        }
        return newRoot;
    }

    public Node search(int key) {
        return search(root, key);
    }

    private Node search(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }
        if (key < root.key) {
            return search(root.leftChild, key);
        } else {
            return search(root.rightChild, key);
        }
    }

    private void replace(Node currentRoot, Node rootForReplace) {
        if (currentRoot.parent == null)
            root = rootForReplace;
        else if (currentRoot == currentRoot.parent.leftChild)
            currentRoot.parent.leftChild = rootForReplace;
        else
            currentRoot.parent.rightChild = rootForReplace;
        if (rootForReplace != null)
            rootForReplace.parent = currentRoot.parent;
    }

    public void remove(int key) {
        remove(root, key);
    }

    private void remove(Node t, int key) {
        if (t == null)
            return;
        if (key < t.key)
            remove(t.leftChild, key);
        else if (key > t.key)
            remove(t.rightChild, key);
        else if (t.leftChild != null && t.rightChild != null) {
            Node m = t.rightChild;
            while (m.leftChild != null)
                m = m.leftChild;
            t.key = m.key;
            t.value = m.value;
            replace(m, m.rightChild);
        } else if (t.leftChild != null) {
            replace(t, t.leftChild);
        } else if (t.rightChild != null) {
            replace(t, t.rightChild);
        } else {
            replace(t, null);
        }
    }

    public void print() {
        print(root);
        System.out.println();
    }

    private void print(Node t) {
        if (t != null) {
            print(t.leftChild);
            System.out.print(t.key + ":" + t.value + " ");
            print(t.rightChild);
        }
    }
}
