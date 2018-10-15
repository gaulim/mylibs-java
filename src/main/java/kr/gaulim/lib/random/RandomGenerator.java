
package kr.gaulim.lib.random;


import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Random;


public class RandomGenerator
{
//  private static final String TAG = RandomGenerator.class.getSimpleName();

    private static final String NUMBERS = "0123456789";
    private static final String UPPERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERS = "abcdefghijklmnopqrstuvwxyz";

    private static RandomGenerator INSTANCE = null;
    private static SecureRandom SRND = null;
    private static Random RND = null;


    private RandomGenerator()
    {
        if ( null == SRND )
            SRND = new SecureRandom();

        if ( null == RND )
            RND = new Random();
    }


    /**
     * <p>난수발생기 인스턴스 얻음</p>
     *
     * @return 난수발생기 인스턴스
     */
    public static RandomGenerator getInstance()
    {
        if ( null == INSTANCE )
            INSTANCE = new RandomGenerator();

        return INSTANCE;
    }


    /**
     * <p>임의로 알파벳 소문자 문자열 생성</p>
     *
     * @param length 생성할 길이
     *
     * @return 임의 문자열
     */
    public static String generateLower(final int length)
    {
        getInstance();
        final StringBuilder sb = new StringBuilder();

        // 새 임시 암호 생성
        for ( int ii = 0; ii < length; ++ii )
            sb.append(LOWERS.charAt(SRND.nextInt(LOWERS.length())));

        return sb.toString();
    }


    /**
     * <p>임의로 알파벳 대문자 문자열 생성</p>
     *
     * @param length 생성할 길이
     *
     * @return 임의 문자열
     */
    public static String generateUpper(final int length)
    {
        getInstance();
        final StringBuilder sb = new StringBuilder();

        // 새 임시 암호 생성
        for ( int ii = 0; ii < length; ++ii )
            sb.append(UPPERS.charAt(SRND.nextInt(UPPERS.length())));

        return sb.toString();
    }


    /**
     * <p>임의로 10진수 정수 생성</p>
     *
     * @param length 생성할 길이
     *
     * @return 임의 숫자
     */
    public static long generateNum(final int length)
    {
        final double n0 = Math.pow(10, length - 1);  // 10 ^ (길이 - 1)
        final double n1 = Math.pow(10, length);      // 10 ^ 길이

        double result = Math.floor(Math.random() * n1) + n0;

        if ( result > n1 )
            result -= n0;

        return (long)result;
    }


    /**
     * <p>임의로 16진수 문자열 생성</p>
     *
     * @param length 바이트 길이
     *
     * @return 16진수 문자열
     */
    public static String generateHexStr(final int length)
    {
        String hexStr;

        try
        {
            final SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            final byte[] byteArr = new byte[length];
            random.nextBytes(byteArr);
            hexStr = DatatypeConverter.printHexBinary(byteArr);
        }
        catch ( final NoSuchAlgorithmException e )
        {
            hexStr = null;
        }

        return hexStr;
    }


    /**
     * <p>임의로 실수(double) 1개 생성</p>
     *
     * @param min 최소값
     * @param max 최대값
     *
     * @return 임의 수
     */
    public double makeNumber(final double min, final double max)
    {
        final double range = max - min + 1.0f;
        return RND.nextDouble() * range + min;
    }


    /**
     * <p>임의로 실수(float) 1개 생성</p>
     *
     * @param min 최소값
     * @param max 최대값
     *
     * @return 임의 수
     */
    public float makeNumber(final float min, final float max)
    {
        final float range = max - min + 1.0f;
        return RND.nextFloat() * range + min;
    }


    /**
     * <p>임의로 정수 1개 생성</p>
     *
     * @param min 최소값
     * @param max 최대값
     *
     * @return 임의 수
     */
    public int makeNumber(final int min, final int max)
    {
        final int range = max - min + 1;
        return (int)(RND.nextDouble() * range + min);
    }


    /**
     * <p>임의 정수 n개를 배열로 생성</p>
     *
     * @param count 생성할 개수
     *
     * @return 임의 정수 배열
     */
    public int[] makeNumbers(final int count)
    {
        final int[] numbers = new int[count];
        boolean found;

        for ( int ii = 0; ii < count; ++ii )
        {
            do {
                numbers[ii] = RND.nextInt(count);
                found = false;

                for ( int jj = 0; jj < ii; ++jj )
                {
                    if ( numbers[jj] == numbers[ii] )
                    {
                        found = true;
                        break;
                    }
                }
            } while ( found );
        }

        return numbers;
    }


    /**
     * <p>임의로 수치형 문자열 생성</p>
     *
     * @param length 생성할 길이
     *
     * @return 임의 수치형 문자열
     */
    public String generateNumStr(final int length)
    {
        final int targetCount = NUMBERS.length();

        final StringBuilder tempBuilder = new StringBuilder(length * 2);

        int randomInt;
        char tempChar;

        for ( int loop = 0; loop < length; ++loop )
        {
            // 첫 번째 자리는 0을 제외하고 생성한다.
            randomInt = RND.nextInt((0 < loop) ? targetCount : (targetCount - 1));
            tempChar = NUMBERS.charAt(randomInt);
            tempBuilder.append(tempChar);
        }

        return tempBuilder.toString();
    }


    /**
     * <p>사용자 정의 키 문자열을 생성한다.</p>
     *
     * @param prefix  사용자 정의 접두사
     * @param reverse 키 문자열을 뒤집어서 반환할지 여부
     *
     * @return 키 문자열
     */
    public String generateKey(final String prefix, final boolean reverse)
    {
        final Calendar cal = Calendar.getInstance();
        final int year = cal.get(Calendar.YEAR);
        final int month = cal.get(Calendar.MONTH) + 1;
        final int day = cal.get(Calendar.DAY_OF_MONTH);
        final int hour = cal.get(Calendar.HOUR_OF_DAY);
        final int minute = cal.get(Calendar.MINUTE);
        final int second = cal.get(Calendar.SECOND);
        final int msec = cal.get(Calendar.MILLISECOND);

        // ID 형식: [prefix][yyyy][MM][dd][hh24][mm][ss][SSS][postfix]
        final int postfixLen = 4;
        final int postfix = makeNumber(0, ((int)Math.pow(10, postfixLen)) - 1);

        String key = String
                .format("%s%04d%02d%02d%02d%02d%02d%03d%04d",
                        prefix, year, month, day,
                        hour, minute, second, msec, postfix);

        if ( reverse )
            key = (new StringBuilder(key)).reverse().toString();

        return key;
    }

    // End of RandomGenerator.class
}

// End of RandomGenerator.java

