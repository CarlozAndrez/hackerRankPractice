package jumpClouds;

import org.junit.Assert;
import org.junit.Test;

public class cloudsTest {

    @Test
    public void cloudTest() {
        Assert.assertEquals(3, jumpingOnClouds(new int[]{0, 0, 0, 0, 1, 0}));

    }

    // Complete the jumpingOnClouds function below.
    public int jumpingOnClouds(int[] c) {
        int steps = 0;
        int i = 0;
        while (i < c.length - 1) {
            if (i + 2 == c.length || c[i + 2] == 1) {
                i++;
                steps++;
            } else {
                i += 2;
                steps++;
            }
        }
        return steps;
    }

    /*
    for (int cloud : c) {
            if (cloud == 0) {
                goodClouds++;
                if(goodClouds==3){
                    steps++;
                    goodClouds=0;
                }
            }else{
                steps++;
            }
        }
     */
}
