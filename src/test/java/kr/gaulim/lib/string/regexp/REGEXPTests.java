
package kr.gaulim.lib.string.regexp;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import static org.junit.Assert.*;


public class REGEXPTests
{
    private void testRegExp(final String regexp, final String text)
    {
        final Matcher matcher = Pattern.compile(regexp).matcher(text);
        final boolean isMatch = matcher.find();

        System.out.println(String.format("Match: %b, Text: %s", isMatch, text));
        assertTrue(isMatch);
    }


    private void testRegExp(final String regexp, final String[] textArr, final boolean forcePrintGroup)
    {
        final Pattern pattern = Pattern.compile(regexp);

        Matcher matcher;
        String grpVal;
        boolean isMatch;
        int groupCnt;

        for ( String str : textArr )
        {
            matcher = pattern.matcher(str);
            isMatch = matcher.find();
            groupCnt = matcher.groupCount();
            System.out.println(String.format("Match: %b, Text: %s", isMatch, str));
            assertTrue(isMatch);

            if ( forcePrintGroup || (1 < groupCnt) )
            for ( int ii = 1; ii <= groupCnt; ++ii )
            {
                grpVal = matcher.group(ii);
                System.out.println(String.format(" - Group[%d] Val: %s", ii, grpVal));
            }
        }
    }


    private void testRegExp(final String regexp, final String[] textArr)
    {
        testRegExp(regexp, textArr, false);
    }


    ////////////////////////////////////////////////////////////////////////////
    // 공통 정규식

    @Test
    public void test_REGEXP_COLOR()
    {
        final String[] colors = {
            "#a3c113",
            "a3c113",
            "A3C113",
            "0xA3C113",
            "#a3c",
            "a3c",
            "ffaa33cc",
            "#ffaa33cc"
        };

        System.out.println("\n=== test_REGEXP_COLOR Start ===");
        testRegExp(REGEXP.COLOR, colors);
        System.out.println("=== test_REGEXP_COLOR End ===\n");
    }


    @Test
    public void test_REGEXP_EMAIL()
    {
        final String[] emails = {
            "mailid@domain.한국",
            "mailid@domain.net",
            "mailid123@domain.com",
            "mailid.1234@domain.com",
            "12mailid@domain.com",
            "34mailid123@domain.co.kr",
            "56mailid.1234@domain.com",
            "_12mailid@domain.com",
            "_34mailid123@domain.co.kr",
            "_56mailid.1234@domain.net",
            "-12mailid@domain.com",
            "-34mailid123@domain.한국",
            "-56mailid.1234@domain.co.kr",
            "help-_-me@domain.net",
            "k.a.i.s.t@domain.net",
            "MAILID@DOMAIN.CO.KR"
        };

        System.out.println("\n=== test_REGEXP_EMAIL Start ===");
        testRegExp(REGEXP.EMAIL, emails);
        System.out.println("=== test_REGEXP_EMAIL End ===\n");
    }


    @Test
    public void test_REGEXP_HEX()
    {
        final String[] hexs = {
            "F3A7", "f3a7", "ffffff",
            "0xF3A7", "0xf3a7", "0xffffff"
        };

        System.out.println("\n=== test_REGEXP_HEX Start ===");
        testRegExp(REGEXP.HEX, hexs);
        System.out.println("=== test_REGEXP_HEX End ===\n");
    }


    @Test
    public void test_REGEXP_IP4()
    {
        final String[] ips = {
            "192.168.0.255",
            "73.60.124.136",
            "249.099.199.1"
        };

        System.out.println("\n=== test_REGEXP_IP4 Start ===");
        testRegExp(REGEXP.IP4, ips);
        System.out.println("=== test_REGEXP_IP4 End ===\n");
    }


    @Test
    public void test_REGEXP_PORT_NUM()
    {
        final String[] ports = {
            "80", "250", "9999",
            "16384", "28475", "39587",
            "43710", "59999", "64987",
            "65492", "65529", "65535"
        };

        System.out.println("\n=== test_REGEXP_PORT_NUM Start ===");
        testRegExp(REGEXP.PORT_NUM, ports);
        System.out.println("=== test_REGEXP_PORT_NUM End ===\n");
    }


    @Test
    public void test_REGEXP_URL()
    {
        final String[] urls = {
            "domain.com",
            "192.168.0.2:59999/dir",
            "DOMAIN.CO.KR:65535/DIR",
            "http://192.168.0.2:59999/dir",
            "https://www.domain.co.kr:65535/dir",
            "http://newsky.kma.go.kr/service?param1=123&param2=345&param3=567",
            "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?ServiceKey=sdflkjseohlsdjfiowelsdhfwiuehsl%3D%3D&sidoName=%EC%84%9C%EC%9A%B8&numOfRows=300",
            "openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?ServiceKey=sdflkjseohlsdjfiowelsdhfwiuehsl%3D%3D&sidoName=%EC%84%9C%EC%9A%B8&numOfRows=300",
            "id@domain.com",
            "id:pwd@domain.com",
            "sftp://id:pwd@domain.com:22/dir",
            "192.168.0.2",
            "id@192.168.0.2",
            "id:pwd@192.168.0.2",
            "sftp://id:pwd@192.168.0.2:22/dir"
        };

        System.out.println("\n=== test_REGEXP_URL Start ===");
        testRegExp(REGEXP.URL, urls);
        System.out.println("=== test_REGEXP_URL End ===\n");
    }


    @Test
    public void test_REGEXP_TAG()
    {
        final String[] tags = {
            "<HTML></HTML>",
            "<A HREF='http://www.domain.com'>도메인</A>",
            "<IMG SRC='img.jpg' ALT='My Image' />",
            "<MANIFEST />",
            "<html></html>",
            "<a href='http://www.domain.com'>도메인</a>",
            "<img src='img.jpg' alt='My Image' />",
            "<manifest />",
            "<img src='http://image3.inews24.com/image_gisa/thumbnail/201504/1429082627492_1_162420.jpg' width='94' height='100' border='0'>",
            "<img src=\"http://cfile29.uf.tistory.com/image/216EC047552DCA360F6DE1\" filemime=\"image/jpeg\" filename=\"1.커버의 매력.jpg\" height=\"600\" width=\"500\"/>",
            "<img id=\"ccl-icon-771-0\" class=\"entry-ccl-by\" src=\"http://i1.daumcdn.net/cfs.tistory/resource/580/static/admin/editor/ccl_black01.png\" alt=\"저작자 표시\"/>",
            "<img border=\"0\" alt=\"\" align=\"absMiddle\" src=\"/wys2/swf_upload/2015/05/21/14322081685166.jpg\" />",
            "<IMG src=\"http://cfile29.uf.tistory.com/image/216EC047552DCA360F6DE1\" filemime=\"image/jpeg\" filename=\"1.커버의 매력.jpg\" height=\"600\" width=\"500\"/>",
            "<IMG id=\"ccl-icon-771-0\" class=\"entry-ccl-by\" src=\"http://i1.daumcdn.net/cfs.tistory/resource/580/static/admin/editor/ccl_black01.png\" alt=\"저작자 표시\"/>",
            "<IMG border=\"0\" alt=\"\" align=\"absMiddle\" src=\"/wys2/swf_upload/2015/05/21/14322081685166.jpg\" />"
        };

        System.out.println("\n=== test_REGEXP_TAG Start ===");
        testRegExp(REGEXP.TAG, tags);
        System.out.println("=== test_REGEXP_TAG End ===\n");
    }


    @Test
    public void test_REGEXP_TAG_SRC()
    {
        final String[] tagSrcs = {
            "src='http://image3.inews24.com/image_gisa/thumbnail/201504/1429082627492_1_162420.jpg'",
            "src=\"http://image3.inews24.com/image_gisa/thumbnail/201504/1429082627492_1_162420.jpg\"",
            "src=\"//t1.gstatic.com/images?q=tbn:ANd9GcRP2uY2_3H71iJN7H9uBxQy5aK0j57EQUlM8jy8c1WNdMTNX4_FJyDZUnYiyc29zu1p6AWT8Y2v\"",
            "src=\"t2.gstatic.com/imagestbn:ANd9GcQzG1sU5acuKaTN6OxLBd0dibV4N_COnm4JHxAnsC9kDDRLYjQ1dqOg7W7WvCag2SH4iKNhyqIx\"",
            "src=\"/wys2/swf_upload/2015/05/21/14322081685166.jpg\""
        };

        System.out.println("\n=== test_REGEXP_TAG_SRC Start ===");
        testRegExp(REGEXP.TAG_SRC, tagSrcs, true);
        System.out.println("=== test_REGEXP_TAG_SRC End ===\n");
    }


    @Test
    public void test_REGEXP_UUID()
    {
        final String[] uuids = {
            "e85a34600c6346678f153417a1571e3b",
            "e85a3460 0c63 4667 8f15 3417a1571e3b",
            "e85a3460-0c63-4667-8f15-3417a1571e3b"
        };

        System.out.println("\n=== test_REGEXP_UUID Start ===");
        testRegExp(REGEXP.UUID, uuids);
        System.out.println("=== test_REGEXP_UUID End ===\n");
    }


    ////////////////////////////////////////////////////////////////////////////
    // 대한민국 코드 체계 정규식

    @Test
    public void test_REGEXP_ADDR_LL()
    {
        final String[] addrs = {
            "한국 서울특별시 성동구 사근동 231-22 2층",
            "대한민국 서울특별시 동작구 신대방동 719 동작상떼빌@ 106동 310호",
            "서울특별시 동작구 신대방동 719 동작상떼빌아파트 106동 310호",
            "서울특별시 동작구 신대방동 719 동작상떼빌APT 106/310",
            "서울특별시 동작구 신대방동 719 동작상떼빌@ 106-310",
            "서울시 동작구 노량진동 206 백명트렌디타워 1408호",
            "한국 세종특별자치시 금남면 용포리 122-1",
            "충남 연기군 금남면 석삼리 123-45",
            "경상남도 김해시 장유면 삼문리 123",
            "서울시 강북구 번2동 산23-27",
            "서울시 강북구 번2동 311-330",
            "서울시 강북구 번3동 산28",
            "서울시 강북구 번3동 621",
            "인천광역시 강화군 강화읍 123-1",
            "서울시 동작구 신대방동 719 동작상떼빌@ 106/310",
            "서울시 구로구 구로동 ACE트윈타워"
        };

        System.out.println("\n=== test_REGEXP_ADDR_LL Start ===");
        testRegExp(REGEXP_KOR.ADDR_LL, addrs);
        System.out.println("=== test_REGEXP_ADDR_LL End ===\n");
    }


    @Test
    public void test_REGEXP_ADDR_RN()
    {
        final String[] addrs = {
            "대한민국 서울특별시 중구 세종대로 110 (태평로1가) 서울특별시청",
            "대한민국 서울특별시 동작구 신대방1가길 38 (신대방동, 동작상떼빌아파트) 106동 310호",
            "서울특별시 동작구 신대방1가길 38 (신대방동, 동작상떼빌아파트) 106/310",
            "서울시 동작구 신대방1가길 38 106-310",
            "세종특별자치시 한누리대로 2130",
            "대한민국 세종시 갈매로 37-12",
            "한국 세종특별자치시 금남면 용포로 57 금남면사무소",
            "경상남도 합천군 합천읍 옥산로 3",
            "경남 합천군 합천읍 용계길 1",
            "제주특별자치도 제주시 첨단로 242",
            "대한민국 서울특별시 강남구 봉은사로114길 32(삼성동, 우남빌딩) 2층 (주)페이콕"
        };

        System.out.println("\n=== test_REGEXP_ADDR_RN Start ===");
        testRegExp(REGEXP_KOR.ADDR_RN, addrs);
        System.out.println("=== test_REGEXP_ADDR_RN End ===\n");
    }


    @Test
    public void test_REGEXP_CURRENCY()
    {
        final String[] currencies = {
            "1234",
            "123456789",
            "1,204,507",
            "$1234",
            "$1,204,507",
            "1234.56",
            "1,204.56",
            "23,305.06789",
            "$1204.56",
            "$1,204.56",
            "$23,305.06789"
        };

        System.out.println("\n=== test_REGEXP_CURRENCY Start ===");
        testRegExp(REGEXP_KOR.CURRENCY, currencies);
        System.out.println("=== test_REGEXP_CURRENCY End ===\n");
    }


    @Test
    public void test_REGEXP_MOBILE_NUM()
    {
        final String[] mobiles = {
            "01012345678",
            "010-1234-5678",
            "821012345678",
            "82-10-1234-5678",
            "+82 (0) 10-1234-5678"
        };

        System.out.println("\n=== test_REGEXP_MOBILE_NUM Start ===");
        testRegExp(REGEXP_KOR.MOBILE_NUM, mobiles);
        System.out.println("=== test_REGEXP_MOBILE_NUM End ===\n");
    }


    @Test
    public void test_REGEXP_PHONE_NUM()
    {
        final String[] phones = {
            "12345678",
            "1234-5678",
            "0212345678",
            "02)12345678",
            "(02)1234-5678",
            "02-1234-5678",
            "82212345678",
            "+82212345678",
            "82-2-1234-5678",
            "+82-2-1234-5678",
            "0315436789",
            "031)5436789",
            "(031)543-6789",
            "031-543-6789",
            "82315436789",
            "+82315436789",
            "82-31-543-6789",
            "+82-31-543-6789",
            "01098765432",
            "010-9876-5432",
            "821098765432",
            "82-10-9876-5432",
            "+82 (0) 10-9876-5432"
        };

        System.out.println("\n=== test_REGEXP_PHONE_NUM Start ===");
        testRegExp(REGEXP_KOR.PHONE_NUM, phones);
        System.out.println("=== test_REGEXP_PHONE_NUM End ===\n");
    }


    @Test
    public void test_REGEXP_RRN()
    {
        final String[] rrns = {
            "991231-1234567",
            "0001013456789"
        };

        System.out.println("\n=== test_REGEXP_RRN Start ===");
        testRegExp(REGEXP_KOR.RRN, rrns);
        System.out.println("=== test_REGEXP_RRN End ===\n");
    }

    // End of REGEXPTests.class
}

// End of REGEXPTests.java

