package com.danske;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    int[][] array;
    List<Node> values = new ArrayList<>();

    public Tree(int[][] array) {
        this.array = array;
    }

    //get max sum and print path
    public long findMax() {
        Node root = getRoot();
        long maxsum = findMaxUtil( root );
        printPath( root, maxsum );
        return maxsum;
    }
// find max sum from some node
    public long findMaxUtil(Node node) {
   long sumcenter = 0;
        long sumright = 0;

        Node centerNode = getCenter( node );

        if (centerNode == null) {
            sumcenter = 0;
        } else {
            sumcenter = findMaxUtil( centerNode );
        }

        Node rightNode = getRight( node );

        if (rightNode == null) {
            sumright = 0;
        } else {
            sumright = findMaxUtil( rightNode );
        }

        long maxsingle = Math.max( sumright, sumcenter ) + node.getValue();
        return maxsingle;
    }

// get the one below this node
    private Node getCenter(Node root) {
        int size = array.length;
        if (root.getRow() == size - 1) {
            return null;
        } else {
            int value = array[root.getRow() + 1][root.getCol()];

            boolean isodd = value % 2 == 1 ? true : false;
            if (root.isOdd() == isodd) {
                return null;
            } else {
                return new Node( root.getCol(), root.getRow() + 1, value, isodd );
            }
        }
    }

  //  get the one below right this node
    private Node getRight(Node root) {
        int size = array.length;

        if (root.getRow() == size - 1) {
            return null;
        } else {
            int value = array[root.getRow() + 1][root.getCol() + 1];
            boolean isodd = value % 2 == 1 ? true : false;
            if (root.isOdd() == isodd) {
                return null;
            } else {

                return new Node( root.getCol() + 1, root.getRow() + 1, value, isodd );
            }
        }
    }
// print path by sum
    public boolean printPath(Node node, long sum) {

        if (sum == 0) {
            return true;
        }

        if (node == null) {
            return false;
        }
        Node centerNode = getCenter( node );
        Node rightNode = getRight( node );
        boolean left = printPath( centerNode, sum - node.getValue() );
        boolean right = printPath( rightNode, sum - node.getValue() );

        if (left || right) {

            values.add( node );
        }

        return left || right;
    }
// get  root from array
    public Node getRoot() {
        boolean isodd = array[0][0] % 2 == 1 ? true : false;
        return new Node( 0, 0, array[0][0], isodd );
    }

//print Pyramid
    void printArray() {
        int size = array.length;
        System.out.println( "masyvo dydis " + size );
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print( array[i][j] + " " );
            }
            System.out.println( "" );
        }

    }
//print path
    void printList() {
        System.out.println(" this max sum is from:");
        int valueSize = values.size();
        for (int i = valueSize - 1; i >= 0; i--) {
            Node node = values.get( i );
            System.out.println( "[" + node.getRow() + "," + node.getCol() + "]  --> " + node.getValue() );

        }
        System.out.println();
    }


}