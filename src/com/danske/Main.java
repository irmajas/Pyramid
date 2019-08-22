package com.danske;

public class Main {

    public static void main(String[] args) {


        int[][] triangle = new int[][]{
                {1, 0, 0, 0},
                {8, 9, 0, 0},
                {1, 5, 9, 0},
                {4, 5, 2, 3}

        };
        int[][] triangle2 = new int[][]{
                {215, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {192, 124, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {117, 269, 442, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {218, 836, 347, 235, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {320, 805, 522, 417, 345, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {229, 601, 728, 835, 133, 124, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {248, 202, 277, 433, 207, 263, 257, 0, 0, 0, 0, 0, 0, 0, 0},
                {359, 464, 504, 528, 516, 716, 871, 182, 0, 0, 0, 0, 0, 0, 0},
                {461, 441, 426, 656, 863, 560, 380, 171, 923, 0, 0, 0, 0, 0, 0},
                {381, 348, 573, 533, 448, 632, 387, 176, 975, 449, 0, 0, 0, 0, 0},
                {223, 711, 445, 645, 245, 543, 931, 532, 937, 541, 444, 0, 0, 0, 0},
                {330, 131, 333, 928, 376, 733, 017, 778, 839, 168, 197, 197, 0, 0, 0},
                {131, 171, 522, 137, 217, 224, 291, 413, 528, 520, 227, 229, 928, 0, 0},
                {223, 626, 034, 683, 839, 052, 627, 310, 713, 999, 629, 817, 410, 121, 0},
                {924, 622, 911, 233, 325, 139, 721, 218, 253, 223, 107, 233, 230, 124, 233}
        };
// find max sum for exemple
        Tree first = new Tree( triangle );
        first.printArray();
        System.out.println( "Max sum is >> " + first.findMax() );
        first.printList();
//find max sum for given task
        Tree second = new Tree( triangle2 );
        second.printArray();
        System.out.println( "Max sum is >> " + second.findMax() );
        second.printList();
    }
}

