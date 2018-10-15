
package kr.gaulim.lib.string;


public class Nvl
{
//  private static final String TAG = Nvl.class.getSimpleName();


    private Nvl() { }


    /**
     * <p>null을 빈 문자열로 바꾼다.</p>
     *
     * @param str 문자열
     *
     * @return null이 제거된 문자열
     */
    public static String null2zero(final String str)
    {
        if ( ( null == str ) || "null".equalsIgnoreCase(str) )
            return "";
        else
            return str;
    }


    /**
     * <p>null을 빈 문자열로 바꾼다.</p>
     *
     * @param obj 문자열로 변환 가능한 객체
     *
     * @return null이 제거된 문자열
     */
    public static String null2zero(final Object obj)
    {
        if ( null == obj )
            return "";
        else
            return null2zero(obj.toString());
    }

    // End of Nvl.class
}

// End of Nvl.java

