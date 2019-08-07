package sockMerchant;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SocksTest {

    @Test
    public void testPairCounter() {

        Assert.assertEquals(2, sockMerchant(5, new int[]{1, 2, 1, 2, 1, 3, 2}));
    }

    @Test
    public void testPairCounter1() {

        Assert.assertEquals(3, sockMerchant(9, new int[]{10,20,20,10,10,30,50,10,20}));
    }

    @Test
    public void testPairCounter2() {

        Assert.assertEquals(4, sockMerchant(10, new int[]{1,1,3,1,2,1,3,3,3,3}));
    }



    static int sockMerchant(int n, int[] ar) {
        Arrays.sort(ar);
        int[][] map = new int[n][2];
        int aux = ar[0];
        int count = 0;
        int position = 0;
        int pairs = 0;
        for (int number : ar) {
            if (aux == number) {
                count++;
                map[position][0] = aux;
                map[position][1] = count;
            } else {
                aux = number;
                count = 1;
                position++;
            }
        }
        for(int i = 0;i< n;i++){
            pairs += (int) map[i][1] /2;
        }
        return pairs;
    }
}
