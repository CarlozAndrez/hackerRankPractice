package minimumSwaps;

import org.junit.Test;

public class minimumSwaps {
    @Test
    public void minimumSwaps() {

//        Assert.assertEquals(3, bubbleSort(new int[]{1, 3, 5, 2, 4, 6, 7}));
//        Assert.assertEquals(3, bubbleSort(new int[]{2, 3, 4, 1, 5}));
//        Assert.assertEquals(2, minSwaps(new int[]{4, 3, 1, 2}));
//        Assert.assertEquals(5, minSwaps(new int[]{7, 1, 3, 2, 4, 5, 6}));

    }

    /**
     * {4, 3, 1, 2}
     * {1, 3, 4, 2}
     * {1, 2, 4, 3}
     *
     */
//    public int minSwaps(int [] arr){
//        Map<Integer, Integer> numberToIndex = IntStream.range(0, arr.length).boxed()
//                .collect(Collectors.toMap(i -> arr[i], Function.identity()));
//
//    }

//    public int bubbleSort(int[] array) {
//        boolean sorted = false;
//        int temp;
//        int amountSteps = 0;
//        int position = getMinValuePosition(array);
//        if (position != 0) {
//            int minValue = array[position];
//            int aux = array[0];
//            array[0] = minValue;
//            array[position] = aux;
//        }
//        while (!sorted) {
//            sorted = true;
//            for (int i = 0; i < array.length - 1; i++) {
//
//                if (array[i] > array[i + 1]) {
//                    temp = array[i];
//                    array[i] = array[i + 1];
//                    array[i + 1] = temp;
//                    sorted = false;
//                    amountSteps++;
//                }
//            }
//        }
//        return amountSteps;
//    }

    public int getMinValuePosition(int[] numbers, int flag) {
        int minValue = numbers[0];
        int positionOfMinValue = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < minValue) {
                minValue = numbers[i]+flag;
                positionOfMinValue = i;
            }
        }
        return positionOfMinValue;
    }

    public int getMaxValuePosition(int[] numbers, int flag) {
        int maxValue = numbers[0];
        int positionOfMinValue = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maxValue) {
                maxValue = numbers[i]-flag;
                positionOfMinValue = i;
            }
        }
        return positionOfMinValue;
    }
}
