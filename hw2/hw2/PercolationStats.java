package hw2;
import edu.princeton.cs.algs4.StdRandom;


public class PercolationStats {
    private double sumT;
    private double squareT;
    private int number;
    private double mean;
    private double dev;

    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (T <= 0) {
            throw new IllegalArgumentException("The T must be positive!");
        }
        number = T;
        sumT = 0;
        squareT = 0;
        Percolation per;
        double thresholdValue;

        for (int i = 0; i < T; i++) {
            per = pf.make(N);
            while (!per.percolates()) {
                //System.out.println(StdRandom.uniform(0, N));
                per.open(StdRandom.uniform(0, N), StdRandom.uniform(0, N));
            }
            thresholdValue = (double) per.numberOfOpenSites() / ((double) N * N);
            //System.out.println(thresholdValue);
            sumT += thresholdValue;
            squareT += thresholdValue * thresholdValue;
        }

        mean = sumT / number;
        dev = Math.sqrt((squareT - 2 * mean * sumT + number * mean * mean)
                / (number - 1));
    }

    // sample mean of percolation threshold
    public double mean() {
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return dev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLow() {
        return mean - 1.96 * dev / Math.sqrt(number);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHigh() {
        return mean + 1.96 * dev / Math.sqrt(number);
    }

    // use for unit testing
    /*public static void main(String[] args) {
        PercolationFactory pf = new PercolationFactory();
        PercolationStats   p = new PercolationStats(200, 500, pf);
        System.out.println(p.mean());
        System.out.println(p.stddev());
        System.out.println(p.confidenceLow());
        System.out.println(p.confidenceHigh());
    }*/
}
