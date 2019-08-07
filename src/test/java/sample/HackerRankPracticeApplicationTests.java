package sample;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@Ignore
@RunWith(SpringRunner.class)
//@SpringBootTest(classes = HackerRankPracticeApplication.class)
public class HackerRankPracticeApplicationTests {

    @Test
    public void notPossible() {
        String source = "no";
        String target = "go";
        String[] words = {"to"};
        assertEquals(-1, shortestWordEditPath(source, target, words));
    }

    @Test
    public void fiveSteps() {
        String source = "bit";
        String target = "dog";
        String[] words = {"but", "put", "big", "pot", "pog", "dog", "lot"};
        assertEquals(5, shortestWordEditPath(source, target, words));
    }

    @Test
    public void threeSteps() {
        String source = "bit";
        String target = "pog";
        String[] words = {"but", "put", "big", "pot", "pog", "pig", "dog", "lot"};
        assertEquals(5, shortestWordEditPath(source, target, words));
    }

    @Test
    public void deletionStringNine() {
        String str1 = "some";
        String str2 = "thing";
        assertEquals(9, deletionString(str1, str2));
    }

    @Test
    public void deletionStringThree() {
        String str1 = "dog";
        String str2 = "frog";
        assertEquals(7, deletionString(str1, str2));
    }

    public int deletionString(String str1, String str2) {
        String commonCharacters = getCommonCharacters(str1, str2);
        return (str1.length() + str2.length()) - commonCharacters.length();
    }

    private static String getCommonCharacters(String str1, String str2) {
        String commonCharacters = "";

        return commonCharacters;
    }


    public int deletionDistance(String str1, String str2) {
        // your code goes here

        char arr[] = new char[26];
        int count = 0;
        for (char c : str1.toCharArray())
            arr[c - 'a']++;

        for (char c : str2.toCharArray())
            arr[c - 'a']--;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0)
                count++;
        }


        return count;
    }


    @Test
    public void contextLoads() {

//        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
//
//        System.out.println(Arrays.toString(flipArray(arr, 5)));
//
//        assertEquals(true, true);

    }


    static int shortestWordEditPath(String source, String target, String[] words) {
        int steps = 0;
        boolean sourceExists = false;
        for (String word : words) {
            if (target.equals(word)) {
                sourceExists = true;
            }
            if (wordDifferentByOneCharacter(source, word)) {
                if (source.equals(word)) {
                    break;
                }
                source = word;
                steps++;
            }
        }
        if (steps == 0 || !sourceExists) {
            steps = -1;
        }
        return steps;
    }

    public static boolean wordDifferentByOneCharacter(String source, String word) {
        boolean isDifferentByOneCharacter = false;
        if (source != null && word != null && source.length() == word.length()) {
            int differenceCounter = 0;
            for (int i = 0; i < source.length(); i++) {
                if (source.charAt(i) != word.charAt(i)) {
                    differenceCounter++;
                }
            }
            if (differenceCounter == 1) {
                isDifferentByOneCharacter = true;
            }
        }
        return isDifferentByOneCharacter;
    }

    //    public static int[] flipArray(int arr[], int k) {
//        int newarr[] = new int[arr.length];
//        for (int i = k; i >= 0; i--) {
//            newarr[Math.abs(i - k)] = arr[i];
//        }
//
//        for (int i = k + 1; i < arr.length; i++) {
//            newarr[i] = arr[i];
//        }
//        return newarr;
//    }
}
