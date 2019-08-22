package com.danske;

public class Node {
    int col;
    int row;
    int value;
    boolean odd;

    public Node(int col, int row, int value, boolean odd) {
        this.col = col;
        this.row = row;
        this.value = value;
        this.odd = odd;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isOdd() {
        return odd;
    }

    public void setOdd(boolean odd) {
        this.odd = odd;
    }
}
