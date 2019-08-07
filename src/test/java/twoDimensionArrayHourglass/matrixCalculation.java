package twoDimensionArrayHourglass;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class matrixCalculation {

    @Test
    public void testHourglass() {
        int[][] matrix = {
                {-9, -9, -9, 1, 1, 1},
                {0, -9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

        Assert.assertEquals(28, hourglassSum(matrix));

    }

    static int hourglassSum(int[][] arr) {
        int matrixSize = 6;
        ArrayList<Integer> sumArray = new ArrayList<>();
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                try {
                    sumArray.add(
                            (arr[i][j] + arr[i][j + 1] + arr[i][j + 2]) +
                            (arr[i + 1][j + 1]) +
                            (arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2])
                    );
                }catch (ArrayIndexOutOfBoundsException e){

                }
            }
        }
        return sumArray.stream().mapToInt(x -> x).max().getAsInt();
    }

}
