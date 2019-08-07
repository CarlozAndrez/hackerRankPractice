package leftRotation;

import org.junit.Assert;
import org.junit.Test;

public class leftRotation {

    @Test
    public void testLEftRotation() {

        int[] rotatedVector = rotLeft(new int[]{1, 2, 3, 4, 5}, 3);
        int[] expectedVector = new int[]{4, 5, 1, 2, 3};

        for (int i = 0; i < rotatedVector.length; i++) {
            Assert.assertEquals(expectedVector[i], rotatedVector[i]);
        }
    }

    public int[] rotLeft(int[] a, int d) {
        int[] finalVector = new int[a.length];
        boolean secondTime = false;
        for (int k = 0; k < d; k++) {
            if (secondTime) {
                for (int j = 0; j < a.length; j++) {
                    a[j] = finalVector[j];
                }
            }
            for (int i = 0; i < a.length; i++) {
                try {
                    finalVector[i] = a[i + 1];
                    secondTime = true;
                } catch (ArrayIndexOutOfBoundsException e) {

                }
            }
            finalVector[a.length - 1] = a[0];
        }
        return finalVector;
    }

    /**
     * int n = a.length;
     * int[] result = new int[n];
     * for (int i = d, j = 0; i < n; i++, j++) {
     * result[j] = a[i];
     * }
     * <p>
     * for (int i = 0, j = n-d; i < d; i++, j++) {
     * result[j] = a[i];
     * }
     * return result;
     */

    public void caothicYear(int[] q) {
        int bribe = 0;
        boolean chaotic = false;
        int n = q.length;
        for (int i = 0; i < n; i++) {
            if (q[i] - (i + 1) > 2) {
                chaotic = true;
                break;
            }
            for (int j = Math.max(0, q[i] - 1 - 1); j < i; j++)
                if (q[j] > q[i])
                    bribe++;
        }
        if (chaotic)
            System.out.println("Too chaotic");
        else
            System.out.println(bribe);
    }
}
