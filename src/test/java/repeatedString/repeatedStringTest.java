package repeatedString;

import org.junit.Assert;
import org.junit.Test;

public class repeatedStringTest {

    @Test
    public void test() {
        Assert.assertEquals(4L, repeatedString2("abcac",10));
        Assert.assertEquals(7L, repeatedString2("aba", 10));
        Assert.assertEquals(1000000000000L, repeatedString2("a", 1000000000000L));
        Assert.assertEquals(588525L, repeatedString2("aab", 882787L));
    }

    public long repeatedString2(String s, long n) {

        long amountPerString = s.chars().filter(ch -> ch == 'a').count();
        long repeats = n / s.length();
        long rest = ((s.length() * repeats)-n);
        long amountMissing = 0L;
        if(rest!=0) {
            amountMissing = s.substring(0, (int) Math.abs(rest))
                    .chars()
                    .filter(ch -> ch == 'a')
                    .count();
        }
        return ((amountPerString*repeats)+amountMissing);
    }
}
