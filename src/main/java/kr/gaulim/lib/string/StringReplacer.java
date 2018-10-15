
package kr.gaulim.lib.string;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringReplacer
{
//  private static final String TAG = StringReplacer.class.getSimpleName();


    private StringReplacer() { }


    /**
     * <p>태그 제거</p>
     *
     * @param tag 태그
     *
     * @return 태그 제거된 문자열
     */
    public static String stripTag(final String tag)
    {
        final Pattern p = Pattern.compile("<(?:.|\\s)*?>");
        final Matcher m = p.matcher(tag);
        return m.replaceAll("");
    }


    /**
     * <p>링크 만들기</p>
     *
     * @param linkText 일반 문자열
     *
     * @return 링크된 문자열
     */
    public static String makeLinkTag(final String linkText)
    {
        final Pattern p = Pattern.compile(
                            "(http|https|ftp)://[^\\s^\\.]+(\\.[^\\s^\\.]+)*" );
        final Matcher m = p.matcher(linkText);
        final StringBuffer sb = new StringBuffer();

        while ( m.find() )
        {
            m.appendReplacement(
                    sb, "<a href='" + m.group() + "'>" + m.group() + "</a>");
        }

        m.appendTail(sb);

        return sb.toString();
    }


    /**
     * <p>단어 마스킹</p>
     *
     * @param word 원본 단어
     *
     * @return 마스킹된 단어
     */
    public static String maskWord(final String word)
    {
        if ( null == word )
            return null;

        if ( 1 > word.length() )
            return "";

        final char[] chars = new char[word.length()];
        Arrays.fill(chars, '*');

        return String.valueOf(chars);
    }


    /**
     * <p>단어 마스킹</p>
     *
     * @param word    원본 단어
     * @param mask    마스킹 문자
     * @param fromIdx 마스킹 시작 위치
     * @param count   마스킹 개수
     *
     * @return 마스킹된 단어
     */
    public static String maskWord
    (
        final String word, final char mask,
        final int fromIdx, final int count
    )
    throws StringIndexOutOfBoundsException
    {
        if ( null == word )
            return null;

        final int wdLen = word.length();

        if ( 1 > wdLen )
            return "";

        if
        (
            Character.isWhitespace(mask)
            ||
            ( 1 > count )
            ||
            ( 0 > fromIdx )
            ||
            ( wdLen <= fromIdx + count - 1 )
        )
        {
            return word;
        }

        final char[] chars = new char[count];
        Arrays.fill(chars, mask);

        final String prefix = word.substring(0, fromIdx);
        final String body = String.valueOf(chars);
        final String postfix = word.substring(fromIdx + count);

        return prefix + body + postfix;
    }


    /**
     * <p>이름 마스킹</p>
     *
     * @param mask 마스킹 문자
     * @param name 이름
     *
     * @return 마스킹된 이름
     */
    public static String maskName(final char mask, final String name)
    {
        final int length = ( null != name ) ? name.length() : 0;

        if ( 2 < length )
            return StringReplacer.maskWord(name, mask, 1, length - 2);
        else
            return StringReplacer.maskWord(name, mask, 1, 1);
    }


    /**
     * <p>전화번호 마스킹</p>
     *
     * @param mask     마스킹 문자
     * @param phoneNum 전화번호
     *
     * @return 마스킹된 전화번호
     */
    public static String maskPhoneNum(final char mask, final String phoneNum)
    {
        final int length = ( null != phoneNum ) ? phoneNum.length() : 0;
        return StringReplacer.maskWord(phoneNum, mask, length - 6, 4);
    }


    /**
     * <p>카드번호 마스킹</p>
     *
     * @param mask    마스킹 문자
     * @param cardNum 카드번호
     *
     * @return 마스킹된 카드번호
     */
    public static String maskCardNum(final char mask, final String cardNum)
    {
        return StringReplacer.maskWord(cardNum, mask, 6, 6);
    }


    /**
     * <p>전자우편 주소 마스킹 처리</p>
     *
     * @param email 전자우편 주소
     *
     * @return 마스킹된 전자우편 주소
     */
    public static String maskEmail(final String email)
    {
        /*
         * 요구되는 메일 포맷
         * {userId}@domain.com
         */
        final String regex = "\\b(\\S+)+@(\\S+.\\S+)";
        final Matcher matcher = Pattern.compile(regex).matcher(email);

        if ( matcher.find() )
        {
            /*
             * userId의 길이를 기준으로 세글자 초과인 경우 뒤 세자리를 마스킹 처리하고,
             * 세글자인 경우 뒤 두글자만 마스킹,
             * 세글자 미만인 경우 모두 마스킹 처리
             */
            final String target = matcher.group(1); // 마스킹 처리할 부분인 userId
            final int length = target.length();

            if ( length < 3 )
            {
                final char[] c = new char[length];
                Arrays.fill(c, '*');

                return email.replace(target, String.valueOf(c));
            }
            else if ( length == 3 )
            {
                return email.replaceAll("\\b(\\S+)[^@][^@]+@(\\S+)", "$1**@$2");
            }
            else
            {
                return email.replaceAll("\\b(\\S+)[^@][^@][^@]+@(\\S+)", "$1***@$2");
            }
        }

        return email;
    }


    /**
     * <p>전화번호 형식으로 변경 (대한민국)</p>
     *
     * @param telnum 전화번호
     *
     * @return 전화번호 형식 지정된 문자열
     */
    public static String formatPhoneNum(final String telnum)
    {
        if ( null == telnum )
            return null;

        return telnum.replaceAll("(^02.{0}|^01.{1}|\\d{3})(\\d{3,4})(\\d{4}$)",
                "$1-$2-$3");
    }


    /**
     * <p>금칙어 처리</p>
     *
     * @param filter 거를 문자열
     * @param text   금칙어 포함된 문자열
     *
     * @return 걸러진 문자열
     */
    public static String filterText(final String filter, final String text)
    {
        final Pattern p = Pattern.compile(filter, Pattern.CASE_INSENSITIVE);
        final Matcher m = p.matcher(text);

        final StringBuffer sb = new StringBuffer();

        while ( m.find() )
            m.appendReplacement(sb, maskWord(m.group()));

        m.appendTail(sb);

        return sb.toString();
    }

    // End of StringReplacer.class
}

// End of StringReplacer.java

