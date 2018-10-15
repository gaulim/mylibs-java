
package kr.gaulim.lib.range;


import org.junit.Test;


public class RangeCheckerTests
{
    private void printResult(final int resultCode)
    {
        switch ( resultCode )
        {
        case RangeChecker.RANGE_INVALD : System.out.println(" - 무효한 범위");   break;
        case RangeChecker.RANGE_ZERO   : System.out.println(" - 범위 없음");     break;
        case RangeChecker.RANGE_OK     : System.out.println(" - 정상 범위");     break;
        case RangeChecker.RANGE_TOO_BIG: System.out.println(" - 범위가 매우 큼"); break;
        }
    }


    private void testRangeCheck(final long baseIdx, final long count, final long maxCount)
    {
        System.out.println(String.format("Base:%d, Count:%d/%d",
                                         baseIdx, count, maxCount));
        printResult(RangeChecker.check(baseIdx, count, maxCount));
    }


    private void testRangeCheck
    (
        final long startIdx, final long endIdx,
        final long baseIdx, final long maxCount
    )
    {
        System.out.println(String.format("Base:%d, Range:%d~%d, MaxCount:%d",
                                         baseIdx, startIdx, endIdx, maxCount));
        printResult(RangeChecker.check(startIdx, endIdx, baseIdx, maxCount));
    }


    @Test
    public void test_RANGE_CHECK()
    {
        System.out.println("\n=== test_RANGE_CHECK Start ===");
        testRangeCheck(10, -10, 100);
        testRangeCheck(-10, 10, 100);
        testRangeCheck(10, 0, 100);
        testRangeCheck(10, 30, 20);
        testRangeCheck(30, 60, 100);
        testRangeCheck(50, 70, 110);
        testRangeCheck(30, 20, 20, 30);
        testRangeCheck(20, 30, 25, 30);
        testRangeCheck(20, 60, 10, 30);
        testRangeCheck(20, 60, 10, 50);
        System.out.println("=== test_RANGE_CHECK End ===\n");
    }

    // End of RangeCheckerTests.class
}

// End of RangeCheckerTests.java

