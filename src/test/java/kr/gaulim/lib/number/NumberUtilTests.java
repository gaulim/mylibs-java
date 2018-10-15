
package kr.gaulim.lib.number;


import java.text.DecimalFormat;

import org.junit.Test;

import static org.junit.Assert.*;


public class NumberUtilTests
{
    @Test
    public void test_MIN_MAX()
    {
        final int[] snums = { 30, -10, 50, 0, 100 };
        final long[] lnums = { 300L, -100L, 500L, 0L, 1000L };

        final int snumMin = NumberUtil.min(snums);
        final int snumMax = NumberUtil.max(snums);

        final long lnumMin = NumberUtil.min(lnums);
        final long lnumMax = NumberUtil.max(lnums);

        System.out.println("\n=== test_MIN_MAX Start ===");
        System.out.println(
                String.format("int Num : Min(%d), Max(%d)", snumMin, snumMax));
        System.out.println(
                String.format("long Num: Min(%d), Max(%d)", lnumMin, lnumMax));
        System.out.println("=== test_MIN_MAX End ===\n");

        assertEquals(snumMin, -10);
        assertEquals(snumMax, 100);
        assertEquals(lnumMin, -100L);
        assertEquals(lnumMax, 1000L);
    }


    @Test
    public void test_DECIMAL_FORMAT_1()
    {
        final long beginTime = System.nanoTime();
        final int loop = 10000;

        final DecimalFormat df = new DecimalFormat("#,##0");

        String resultStr = "";

        for ( int ii = 0; ii < loop; ++ii )
        {
            final long number = 100000000000L;
            resultStr = df.format(number);
        }

        final float execTime = ( System.nanoTime() - beginTime ) / 1000000.0f;

        System.out.println("\n=== test_DECIMAL_FORMAT_1 Start ===");
        System.out.println(
                String.format("DecimalFormat(%d): %s [%.4f ms]",
                                    loop, resultStr, execTime) );
        System.out.println("=== test_DECIMAL_FORMAT_1 End ===\n");

        assertEquals("100,000,000,000", resultStr);
    }


    @Test
    public void test_DECIMAL_FORMAT_2()
    {
        final long beginTime = System.nanoTime();
        final int loop = 10000;

        String resultStr = "";

        for ( int ii = 0; ii < loop; ++ii )
        {
            final long number = 100000000000L;
            resultStr = NumberUtil.formattedNumber(number);
        }

        final float execTime = ( System.nanoTime() - beginTime ) / 1000000.0f;

        System.out.println("\n=== test_DECIMAL_FORMAT_1 Start ===");
        System.out.println(
                String.format("DecimalFormat(%d): %s [%.4f ms]",
                                    loop, resultStr, execTime) );
        System.out.println("=== test_DECIMAL_FORMAT_1 End ===\n");

        assertEquals("100,000,000,000", resultStr);
    }


    @Test
    public void test_DECIMAL_FORMAT_3()
    {
        final long beginTime = System.nanoTime();
        final int loop = 10000;

        String resultStr = "";

        for ( int ii = 0; ii < loop; ++ii )
        {
            final long number = 100000000000L;
            resultStr = String.format(String.format("%%,%dd", 3), number);
        }

        final float execTime = ( System.nanoTime() - beginTime ) / 1000000.0f;

        System.out.println("\n=== test_DECIMAL_FORMAT_2 Start ===");
        System.out.println(
                String.format("StringFormat(%d): %s [%.4f ms]",
                                    loop, resultStr, execTime) );
        System.out.println("=== test_DECIMAL_FORMAT_2 End ===\n");

        assertEquals("100,000,000,000", resultStr);
    }


    @Test
    public void test_BUFSIZE()
    {
        final int[] nums = { 1, 3, 4, 7, 8, 9, 15, 16, 17 };

        System.out.println("\n=== test_BUFSIZE Start ===");

        for ( int num : nums )
        {
            System.out.println(String.format("Num: %d -> %d",
                                             num, NumberUtil.getBufSize(num)));
        }

        System.out.println("=== test_BUFSIZE End ===\n");
    }

    // End of NumberUtilTests.class
}

// End of NumberUtilTests.java

