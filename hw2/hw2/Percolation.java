package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import static org.junit.Assert.*;

public class Percolation {
    private WeightedQuickUnionUF sets;
    private boolean[] setsState;
    private int[][] items;
    private int itemsLen;
    private int len;
    private int numberOpen;
    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N) {
        if (N < 0) {
            throw new IllegalArgumentException("The N must be positive!");
        }

        len = N;
        itemsLen = 0;
        numberOpen = 0;
        sets = new WeightedQuickUnionUF(N * N + 2);
        setsState = new boolean[N * N];
        items = new int[len][2];
        for (int i = 0; i < N * N; i++) {
            setsState[i] = false;
        }

        for (int i = 0; i < len; i++) {
            items[i][0] = -1;
            items[i][1] = -1;
        }
    }

    private int twoDto1D(int x, int y) {
        return x * len + y;
    }

    // open the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (isOpen(row, col)) {
            return;
        }
        setsState[twoDto1D(row, col)] = true;
        numberOpen++;
        if ((row + 1 < len) && isOpen(row + 1, col)) {
            sets.union(twoDto1D(row, col), twoDto1D(row + 1, col));
        }

        if ((row - 1 >= 0) && isOpen(row - 1, col)) {
            sets.union(twoDto1D(row, col), twoDto1D(row - 1, col));
        }

        if ((col + 1 < len) && isOpen(row, col + 1)) {
            sets.union(twoDto1D(row, col), twoDto1D(row, col + 1));
        }

        if ((col - 1 >= 0) && isOpen(row, col - 1)) {
            sets.union(twoDto1D(row, col), twoDto1D(row, col - 1));
        }

        if (row == len - 1) {
            items[itemsLen][0] = row;
            items[itemsLen][1] = col;
            itemsLen++;
        } else if (row == 0) {
            sets.union(twoDto1D(row, col), len * len);
        }

        for (int i = 0; i < itemsLen; i++) {
            if ((isFull(items[i][0], items[i][1]))
                    && (!sets.connected(twoDto1D(items[i][0], items[i][1]), len * len + 1))) {
                sets.union(twoDto1D(items[i][0], items[i][1]), len * len + 1);
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return setsState[twoDto1D(row, col)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        return sets.connected(twoDto1D(row, col), len * len);
    }

    // number of open sites
    public int numberOfOpenSites() {
        return numberOpen;
    }

    // does the system percolate?
    public boolean percolates() {
        return sets.connected(len * len, len * len + 1);
    }

    // calculate the threshold value
    /*private double calculateThreshold() {
        return (double) numberOpen / ((double) len * len);
    }*/

    // use for unit testing
    public static void main(String[] args) {
        Percolation per = new Percolation(20);
        per.open(1, 2);
        per.open(5, 6);
        per.open(8, 9);
        assertEquals(per.isOpen(1, 2), true);
    }
}
