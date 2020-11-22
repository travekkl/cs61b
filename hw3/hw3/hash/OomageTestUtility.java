package hw3.hash;

import java.util.List;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /*
         * Write a utility function that returns true if the given oomages
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each oomage's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * Oomages and no bucket has more than N / 2.5 Oomages.
         */
        int N = oomages.size();
        int[] bucketArray = new int[M];
        for (int i = 0; i < M; i++) {
            bucketArray[i] = 0;
        }
        int bucketNum;
        for (Oomage o: oomages) {
            //SimpleOomage p = (SimpleOomage) o;
            bucketNum = (o.hashCode() & 0x7FFFFFFF) % M;
            bucketArray[bucketNum] += 1;
        }

        int upper = (int) ((float) N / 2.5);
        int lower = N / 50;
        for (int i = 0; i < M; i++) {
            if ((bucketArray[i] > upper) || (bucketArray[i] < lower)) {
                return false;
            }
        }
        return true;
    }
}
