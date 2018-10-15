
package kr.gaulim.lib.random;


import org.junit.Test;

import static org.junit.Assert.*;


public class RandomGeneratorTests
{
    @Test
    public void test_GENERATE_STR()
    {
        final int length = 10;

        final String strLower = RandomGenerator.generateLower(length);
        final String strUpper = RandomGenerator.generateUpper(length);
        final String strHex = RandomGenerator.generateHexStr(length);

        final RandomGenerator rg = RandomGenerator.getInstance();
        final String prefix = "PREFIX_";
        final String strKey = rg.generateKey(prefix, false);

        System.out.println("\n=== test_GENERATE_STR Start ===");
        System.out.println(String.format("Lower Str(%d): %s", length, strLower));
        System.out.println(String.format("Upper Str(%d): %s", length, strUpper));
        System.out.println(String.format("Hex Str(%d): %s", length, strHex));
        System.out.println(String.format("Key Str: %s", strKey));
        System.out.println("=== test_GENERATE_STR End ===\n");

        assertEquals(length, strLower.length());
        assertEquals(length, strUpper.length());
        assertEquals((length * 2), strHex.length());
        assertEquals((prefix.length() + 21), strKey.length());
    }


    @Test
    public void test_GENERATE_NUM()
    {
        final RandomGenerator rg = RandomGenerator.getInstance();
        final int length = 10;
        final int count = 5;

        final int imin = 100, imax = 1000;
        final float fmin = 100.0f, fmax = 1000.0f;
        final double dmin = 1000.0f, dmax = 10000.0f;

        final int inum = rg.makeNumber(imin, imax);
        final float fnum = rg.makeNumber(fmin, fmax);
        final double dnum = rg.makeNumber(dmin, dmax);

        final long lnum = RandomGenerator.generateNum(length);
        final int[] inums = rg.makeNumbers(count);

        System.out.println("\n=== test_GENERATE_NUM Start ===");
        System.out.println(String.format("Int Number(%d ~ %d): %d", imin, imax, inum));
        System.out.println(String.format("Float Number(%.1f ~ %.1f): %.1f", fmin, fmax, fnum));
        System.out.println(String.format("Double Number(%.2f ~ %.2f): %.2f", dmin, dmax, dnum));
        System.out.println(String.format("Long Number(%d): %d", length, lnum));
        for ( int ii = 0; ii < count; ++ii )
            System.out.println(String.format("Array Number[%d]: %d", (ii + 1), inums[ii]));
        System.out.println("=== test_GENERATE_NUM End ===\n");

        assertTrue((imin <= inum) && (inum < imax));
        assertTrue((fmin <= fnum) && (fnum < fmax));
        assertTrue((dmin <= dnum) && (dnum < dmax));
        assertEquals(length, ("" + lnum).length());

        for ( int kk = 0; kk < count; ++kk )
            assertTrue((0 <= inums[kk]) && (inums[kk] < count));
    }


    @Test
    public void test_SPEED_PURE_GENERATE_NUM()
    {
        final RandomGenerator rg = RandomGenerator.getInstance();
        final int length = 6;
        final int loop = 100000;

        String resultStr = "";
        int ii;
        long begin, resultNum = 0L;
        float interval1, interval2;

        begin = System.nanoTime();
        for ( ii = 0; ii < loop; ++ii )
            resultStr = rg.generateNumStr(length);
        interval1 = (System.nanoTime() - begin) / 1000000.0f;

        begin = System.nanoTime();
        for ( ii = 0; ii < loop; ++ii )
            resultNum = RandomGenerator.generateNum(length);
        interval2 = (System.nanoTime() - begin) / 1000000.0f;

        System.out.println("\n=== test_SPEED_PURE_GENERATE_NUM Start ===");
        System.out.println(String.format("generateNumStr: %s [%.4f ms]", resultStr, interval1));
        System.out.println(String.format("generateNum   : %d [%.4f ms]", resultNum, interval2));
        System.out.println("=== test_SPEED_PURE_GENERATE_NUM End ===\n");
    }


    @Test
    public void test_SPEED_TOSTR_GENERATE_NUM()
    {
        final RandomGenerator rg = RandomGenerator.getInstance();
        final int length = 6;
        final int loop = 100000;

        String resultStr1 = "";
        String resultStr2 = "";
        int ii;
        long begin;
        float interval1, interval2;

        begin = System.nanoTime();
        for ( ii = 0; ii < loop; ++ii )
            resultStr1 = rg.generateNumStr(length);
        interval1 = (System.nanoTime() - begin) / 1000000.0f;

        begin = System.nanoTime();
        for ( ii = 0; ii < loop; ++ii )
            resultStr2 = String.valueOf(RandomGenerator.generateNum(length));
        interval2 = (System.nanoTime() - begin) / 1000000.0f;

        System.out.println("\n=== test_SPEED_TOSTR_GENERATE_NUM Start ===");
        System.out.println(String.format("generateNumStr: %s [%.4f ms]", resultStr1, interval1));
        System.out.println(String.format("generateNum   : %s [%.4f ms]", resultStr2, interval2));
        System.out.println("=== test_SPEED_TOSTR_GENERATE_NUM End ===\n");
    }

    // End of RandomGeneratorTests.class
}

// End of RandomGeneratorTests.java

