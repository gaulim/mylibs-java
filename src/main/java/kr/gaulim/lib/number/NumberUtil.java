
package kr.gaulim.lib.number;


import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;


public class NumberUtil
{
//  private static final String TAG = NumberUtil.class.getSimpleName();


    private NumberUtil() { }


    /**
     * <p>int 배열에서 최소값을 얻는다.</p>
     *
     * @param numbers int 배열
     *
     * @return 최소값
     */
    public static int min(final int[] numbers)
    {
        if ( null == numbers )
            return 0;

        return Collections.min(Arrays.stream(numbers).boxed()
                .collect(Collectors.toList()));
    }


    /**
     * <p>long 배열에서 최소값을 얻는다.</p>
     *
     * @param numbers long 배열
     *
     * @return 최소값
     */
    public static long min(final long[] numbers)
    {
        if ( null == numbers )
            return 0;

        return Collections.min(Arrays.stream(numbers).boxed()
                .collect(Collectors.toList()));
    }


    /**
     * <p>int 배열에서 최대값을 얻는다.</p>
     *
     * @param numbers int 배열
     *
     * @return 최대값
     */
    public static int max(final int[] numbers)
    {
        if ( null == numbers )
            return 0;

        return Collections.max(Arrays.stream(numbers).boxed()
                .collect(Collectors.toList()));
    }


    /**
     * <p>long 배열에서 최대값을 얻는다.</p>
     *
     * @param numbers long 배열
     *
     * @return 최대값
     */
    public static long max(final long[] numbers)
    {
        if ( null == numbers )
            return 0;

        return Collections.max(Arrays.stream(numbers).boxed()
                .collect(Collectors.toList()));
    }


    /**
     * <p>자료를 할당할 최적화된 버퍼 크기를 얻는다.</p>
     *
     * @param dataSize 자료 크기
     *
     * @return 버퍼 크기 정수값
     */
    public static int getBufSize(final int dataSize)
    {
        if ( 1 > dataSize )
            throw new IllegalArgumentException("A negative number or 0 was entered.");

        final int DIVIDEND = Integer.BYTES;
        final int MID = DIVIDEND / 2;
        final int remainder = dataSize % DIVIDEND;

        if ( MID <= remainder )
            return dataSize + (DIVIDEND - remainder) + DIVIDEND;
        else if ( 0 < remainder )
            return dataSize + (DIVIDEND - remainder);
        else
            return dataSize + DIVIDEND;
    }


    /**
     * <p>숫자 1000자리 구분기호 삽입</p>
     *
     * @param number 숫자
     *
     * @return 구분기호 삽입된 수치형 문자열
     */
    public static String formattedNumber(final long number)
    {
        final DecimalFormat df = new DecimalFormat("#,##0");
        return df.format(number);
    }

    // End of NumberUtil.class
}

// End of NumberUtil.java

