package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import static org.junit.Assert.*;

public class Percolation {
    private WeightedQuickUnionUF sets;
    private boolean[] setsState;
    private int len;
    private int numberOpen;
    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N) {
        len = N;
        numberOpen = 0;
        sets = new WeightedQuickUnionUF(N * N + 2);
        setsState = new boolean[N * N];
        for (int i = 0; i < N * N; i++) {
            setsState[i] = false;
        }

        //for (int i = 0; i < len; i++) {
            //sets.union(i, N * N);
            //sets.union(N * N - N + i, N * N + 1);
        //}
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



        if ((row == len - 1) && isFull(row, col)) {
            sets.union(twoDto1D(row, col), len * len + 1);
        }

        if (row == 0) {
            sets.union(twoDto1D(row, col), len * len);
        }

        for (int i = 0; i < len; i++) {
            if (isFull(len - 1, i)) {
                sets.union(twoDto1D(len - 1, i), len * len + 1);
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
