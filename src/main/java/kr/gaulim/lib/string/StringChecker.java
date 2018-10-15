
package kr.gaulim.lib.string;


import kr.gaulim.lib.string.regexp.REGEXP;
import kr.gaulim.lib.string.regexp.REGEXP_KOR;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringChecker
{
//  private static final String TAG = StringChecker.class.getSimpleName();


    private StringChecker() { }


    /**
     * <p>정규식 패턴 일치 여부</p>
     *
     * @param regexStr 정규식 패턴 문자열
     * @param value    비교할 값
     *
     * @return 정규식 패턴 일치 여부 (true:유효, false:무효)
     */
    private static boolean isMatch(final String regexStr, final String value)
    {
        if ( ( null == regexStr ) || ( 1 > regexStr.trim().length() ) )
            return false;

        if ( ( null == value ) || ( 1 > value.trim().length() ) )
            return false;

        final Pattern p = Pattern.compile(regexStr);
        final Matcher m = p.matcher(value);

        return m.matches();
    }


    /**
     * <p>색상코드 유효성 검사</p>
     *
     * @param colorCode 색상코드
     *
     * @return 색상코드 유효성 여부 (true:유효, false:무효)
     */
    public static boolean isValidColor(final String colorCode)
    {
        return isMatch(REGEXP.COLOR, colorCode);
    }


    /**
     * <p>전자우편 주소 유효성 검사</p>
     *
     * @param email 전자우편 주소
     *
     * @return 전자우편 유효성 여부 (true:유효, false:무효)
     */
    public static boolean isValidEmail(final String email)
    {
        return isMatch(REGEXP.EMAIL, email);
    }


    /**
     * <p>16진수 문자열 유효성 검사</p>
     *
     * @param hexCode 16진수
     *
     * @return 16진수 문자열 유효성 여부 (true:유효, false:무효)
     */
    public static boolean isValidHex(final String hexCode)
    {
        return isMatch(REGEXP.HEX, hexCode);
    }


    /**
     * <p>IP주소(ver.4) 유효성 검사</p>
     *
     * @param ipaddr IP주소
     *
     * @return IP주소(ver.4) 유효성 여부 (true:유효, false:무효)
     */
    public static boolean isValidIP4(final String ipaddr)
    {
        return isMatch(REGEXP.IP4, ipaddr);
    }


    /**
     * <p>포트번호 문자열 유효성 검사 (정수형식 비교 권장)</p>
     *
     * @param port 포트번호
     *
     * @return 포트번호 문자열 유효성 여부 (true:유효, false:무효)
     */
    public static boolean isValidPort(final String port)
    {
        return isMatch(REGEXP.PORT_NUM, port);
    }


    /**
     * <p>URL 유효성 검사</p>
     *
     * @param url URL
     *
     * @return URL 유효성 여부 (true:유효, false:무효)
     */
    public static boolean isValidURL(final String url)
    {
        return isMatch(REGEXP.URL, url);
    }


    /**
     * <p>태그 유효성 검사</p>
     *
     * @param tag 태그
     *
     * @return 태그 유효성 여부 (true:유효, false:무효)
     */
    public static boolean isValidTag(final String tag)
    {
        return isMatch(REGEXP.TAG, tag);
    }


    /**
     * <p>UUID 유효성 검사</p>
     *
     * @param uuid UUID
     *
     * @return UUID 유효성 여부 (true:유효, false:무효)
     */
    public static boolean isValidUUID(final String uuid)
    {
        return isMatch(REGEXP.UUID, uuid);
    }


    /**
     * <p>지번주소(대한민국) 유효성 검사</p>
     *
     * @param address 지번주소
     *
     * @return 지번주소 유효성 여부 (true:유효, false:무효)
     */
    public static boolean isValidAddressLotNumber(final String address)
    {
        return isMatch(REGEXP_KOR.ADDR_LL, address);
    }


    /**
     * <p>도로명주소(대한민국) 유효성 검사</p>
     *
     * @param address 도로명주소
     *
     * @return 도로명주소 유효성 여부 (true:유효, false:무효)
     */
    public static boolean isValidAddressRoadName(final String address)
    {
        return isMatch(REGEXP_KOR.ADDR_RN, address);
    }


    /**
     * <p>금액 문자열 유효성 검사</p>
     *
     * @param currency 금액 문자열
     *
     * @return 금액 문자열 유효성 여부 (true:유효, false:무효)
     */
    public static boolean isValidCurrency(final String currency)
    {
        return isMatch(REGEXP_KOR.CURRENCY, currency);
    }


    /**
     * <p>휴대폰번호(대한민국) 유효성 검사</p>
     *
     * @param telnum 휴대폰번호
     *
     * @return 휴대폰번호 유효성 여부 (true:유효, false:무효)
     */
    public static boolean isValidMobileNumber(final String telnum)
    {
        return isMatch(REGEXP_KOR.MOBILE_NUM, telnum);
    }


    /**
     * <p>전화번호(대한민국) 유효성 검사</p>
     *
     * @param telnum 전화번호
     *
     * @return 전화번호 유효성 여부 (true:유효, false:무효)
     */
    public static boolean isValidPhoneNumber(final String telnum)
    {
        return isMatch(REGEXP_KOR.PHONE_NUM, telnum);
    }


    /**
     * <p>주민등록번호(대한민국) 유효성 검사</p>
     *
     * @param rrnCode 주민등록번호
     *
     * @return 주민등록번호 유효성 여부 (true:유효, false:무효)
     */
    public static boolean isValidRRN(final String rrnCode)
    {
        return isMatch(REGEXP_KOR.RRN, rrnCode);
    }


    /**
     * <p>카드번호 유효성 검사 (룬 공식 - LUHN Formula == 모듈러스 10 == mod 10)</p>
     *
     * @param cardNum 카드번호
     *
     * @return 카드번호 유효성 여부 (true:유효, false:무효)
     */
    public static boolean isValidCreditCardNum(final String cardNum)
    {
        if ( null == cardNum )
            return false;

        final String number = cardNum.trim().replace("-", "").replace(" ", "");
        final int len = number.length();

        if ( (13 > len) || (19 < len) )
            return false;

        int num, sum = 0;

        // 마지막 숫자는 Check Digit 이므로 계산에서 제외한다.
        for ( int ii = (len - 2), loop = 1; ii >= 0; --ii, ++loop )
        {
            num = number.charAt(ii) - '0';

            // Check Digit 바로 왼쪽부터 한 자리씩 건너뛰며 2를 곱한다.
            if ( 0 != (loop % 2) )
            {
                num *= 2;

                // 2를 곱한 값이 9보다 크면 9를 빼준다.
                // 각 자리수를 각각 더해도 결과는 같다.
                // 14: (1 + 4) == (14 - 9)
                if ( 9 < num )
                    num -= 9;
            }

            sum += num;
        }

        final int checkDigit = (sum * 9) % 10;
        final int lastDigit = number.charAt(len - 1) - '0';

        // 마지막 자리수와 계산 결과가 같으면 유효함.
        return ( lastDigit == checkDigit );
    }

    // End of StringChecker.class
}

// End of StringChecker.java

