
package kr.gaulim.lib.range;


public class RangeChecker
{
//  private static final String TAG = RangeChecker.class.getSimpleName();

    public static final int RANGE_INVALD  = -1; // 무효한 범위
    public static final int RANGE_ZERO    = 0;  // 범위 없음
    public static final int RANGE_OK      = 1;  // 정상 범위
    public static final int RANGE_TOO_BIG = 2;  // 범위가 매우 큼


    private RangeChecker() { }


    /**
     * <p>범위를 검사한다.</p>
     *
     * @param baseIdx  기준 색인번호
     * @param count    개수
     * @param maxCount 개수로 지정할 수 있는 최대값
     *
     * @return 결과코드
     */
    public static int check(final long baseIdx, final long count, final long maxCount)
    {
        if ( ( 0 > baseIdx ) || ( 0 > count ) )
            return RANGE_INVALD;
        else if ( 0 == count )
            return RANGE_ZERO;
        else if ( count > maxCount )
            return RANGE_TOO_BIG;
        else
            return RANGE_OK;
    }


    /**
     * <p>범위를 검사한다.</p>
     *
     * @param startIdx 시작 색인번호
     * @param endIdx   끝 색인번호
     * @param baseIdx  기준 색인번호
     * @param maxCount 최대 범위
     *
     * @return 결과코드
     */
    public static int check
    (
        final long startIdx, final long endIdx,
        final long baseIdx, final long maxCount
    )
    {
        if ( ( startIdx > endIdx ) || ( baseIdx > startIdx ) )
            return RANGE_INVALD;
        else if ( maxCount <= endIdx - startIdx )
            return RANGE_TOO_BIG;
        else
            return RANGE_OK;
    }

    // End of RangeChecker.class
}

// End of RangeChecker.java

