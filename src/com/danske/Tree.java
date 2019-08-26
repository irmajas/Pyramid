package com.danske;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    int[][] array;
    private List<Node> values = new ArrayList<>();

    public Tree(int[][] array) {
        this.array = array;
    }

    //get max sum and print path
    public void findMax() {
        if (array==null){
            System.out.println("Pyramide do not exist");
        }
        else {
            Node root = getRoot();

            int pathLength = findMaxPath();
            if (!(pathLength == array.length)) {
                System.out.println( "Max sum can't count, becouse way to the bottom of Pyramid don't exist" );

            } else {
                long maxsum = findMaxUtil( root, pathLength );
                getPath( root, maxsum );
                System.out.println( "Max sum is = " + maxsum );
                printList();
            }
        }
    }
//find parh in the tree with mac lentgh
    private int findMaxPath() {
        Node root = getRoot();
        int maxpath = pathdeep( root );
        return maxpath;
    }

    // find max sum from some node
    private long findMaxUtil(Node node, int length) {
        long sumcenter = 0;
        long sumright = 0;

        Node centerNode = getCenter( node );
        int centerlength = pathdeep( centerNode );

        if (centerNode == null || centerlength < length - 1) {
            sumcenter = 0;
        } else {
            sumcenter = findMaxUtil( centerNode, length - 1 );
        }

        Node rightNode = getRight( node );
        int rightlength = pathdeep( rightNode );

        if (rightNode == null || rightlength < length - 1) {
            sumright = 0;
        } else {

            sumright = findMaxUtil( rightNode, length - 1 );
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
//find max path lenght form given node
    private int pathdeep(Node node) {

        if (node == null) {
            return 0;
        }
        Node centerNode = getCenter( node );
        Node rightNode = getRight( node );
        int centerDeep = pathdeep( centerNode );
        int rightDeep = pathdeep( rightNode );

        return Math.max( rightDeep, centerDeep ) + 1;
    }

    // print path by sum
    private boolean getPath(Node node, long sum) {

        if (sum == 0) {
            return true;
        }

        if (node == null) {
            return false;
        }
        Node centerNode = getCenter( node );
        Node rightNode = getRight( node );
        boolean center = getPath( centerNode, sum - node.getValue() );
        boolean right = getPath( rightNode, sum - node.getValue() );

        if (center || right) {
            values.add( node );
        }

        return center || right;
    }

    // get  root from array
    private Node getRoot() {

        boolean isodd = array[0][0] % 2 == 1 ? true : false;
        return new Node( 0, 0, array[0][0], isodd );
    }

    //print Pyramid
    void printArray() {
        if (array==null){
            System.out.println("Nothing to print");
        }
        else {
            int size = array.length;
            System.out.println( " Pyramid is :" );
            for (int i = 0; i < size; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print( array[i][j] + " " );
                }
                System.out.println( "" );
            }
        }
    }

    //print path
    private void printList() {
        System.out.println( " this max sum is from:" );
        int valueSize = values.size();
        for (int i = valueSize - 1; i >= 0; i--) {
            Node node = values.get( i );
            System.out.println( "[" + node.getRow() + "," + node.getCol() + "]  --> " + node.getValue() );
        }
        System.out.println();

    }
}