
package kr.gaulim.lib.string;


import org.junit.Test;

import static org.junit.Assert.*;


public class StringCheckerTests
{
    @Test
    public void test_VALID()
    {
        final String colorCode1 = "0xA3C113";
        final String colorCode2 = "#ffaa33cc";
        final boolean isValidColor1 = StringChecker.isValidColor(colorCode1);
        final boolean isValidColor2 = StringChecker.isValidColor(colorCode2);

        final String email1 = "mailid@domain.한국";
        final String email2 = "help-_-me@domain.net";
        final String email3 = "k.a.i.s.t@domain.net";
        final boolean isValidEmail1 = StringChecker.isValidEmail(email1);
        final boolean isValidEmail2 = StringChecker.isValidEmail(email2);
        final boolean isValidEmail3 = StringChecker.isValidEmail(email3);

        final String hex1 = "F3A7";
        final String hex2 = "0xf3a7";
        final boolean isValidHex1 = StringChecker.isValidHex(hex1);
        final boolean isValidHex2 = StringChecker.isValidHex(hex2);

        final String ip1 = "192.168.0.255";
        final String ip2 = "73.60.124.136";
        final boolean isValidIp1 = StringChecker.isValidIP4(ip1);
        final boolean isValidIp2 = StringChecker.isValidIP4(ip2);

        final String port1 = "80";
        final String port2 = "65535";
        final boolean isValidPort1 = StringChecker.isValidPort(port1);
        final boolean isValidPort2 = StringChecker.isValidPort(port2);

        final String url1 = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?ServiceKey=sdflkjseohlsdjfiowelsdhfwiuehsl%3D%3D&sidoName=%EC%84%9C%EC%9A%B8&numOfRows=300";
        final String url2 = "sftp://id:pwd@domain.com:22/dir";
        final boolean isValidUrl1 = StringChecker.isValidURL(url1);
        final boolean isValidUrl2 = StringChecker.isValidURL(url2);

        final String tag1 = "<A HREF='http://www.domain.com'>도메인</A>";
        final String tag2 = "<img src=\"http://cfile29.uf.tistory.com/image/216EC047552DCA360F6DE1\" filemime=\"image/jpeg\" filename=\"1.커버의 매력.jpg\" height=\"600\" width=\"500\"/>";
        final boolean isValidTag1 = StringChecker.isValidTag(tag1);
        final boolean isValidTag2 = StringChecker.isValidTag(tag2);

        final String uuid1 = "e85a34600c6346678f153417a1571e3b";
        final String uuid2 = "e85a3460 0c63 4667 8f15 3417a1571e3b";
        final String uuid3 = "e85a3460-0c63-4667-8f15-3417a1571e3b";
        final boolean isValidUuid1 = StringChecker.isValidUUID(uuid1);
        final boolean isValidUuid2 = StringChecker.isValidUUID(uuid2);
        final boolean isValidUuid3 = StringChecker.isValidUUID(uuid3);

        final String addrLL1 = "대한민국 서울특별시 동작구 신대방동 719 동작상떼빌@ 106동 310호";
        final String addrLL2 = "한국 세종특별자치시 금남면 용포리 122-1";
        final boolean isValidAddrLL1 = StringChecker.isValidAddressLotNumber(addrLL1);
        final boolean isValidAddrLL2 = StringChecker.isValidAddressLotNumber(addrLL2);

        final String addrRN1 = "대한민국 서울특별시 중구 세종대로 110 (태평로1가) 서울특별시청";
        final String addrRN2 = "대한민국 서울특별시 강남구 어디로100길 99(스타일동, 강남빌딩) 99층 (주)회사다";
        final boolean isValidAddrRN1 = StringChecker.isValidAddressRoadName(addrRN1);
        final boolean isValidAddrRN2 = StringChecker.isValidAddressRoadName(addrRN2);

        final String currency1 = "123456789";
        final String currency2 = "1,204,507";
        final String currency3 = "$23,305.06789";
        final boolean isValidCurrency1 = StringChecker.isValidCurrency(currency1);
        final boolean isValidCurrency2 = StringChecker.isValidCurrency(currency2);
        final boolean isValidCurrency3 = StringChecker.isValidCurrency(currency3);

        final String mobile1 = "01012345678";
        final String mobile2 = "010-1234-5678";
        final String mobile3 = "82-10-1234-5678";
        final boolean isValidMobile1 = StringChecker.isValidMobileNumber(mobile1);
        final boolean isValidMobile2 = StringChecker.isValidMobileNumber(mobile2);
        final boolean isValidMobile3 = StringChecker.isValidMobileNumber(mobile3);

        final String phone1 = "0212345678";
        final String phone2 = "(02)1234-5678";
        final String phone3 = "+82-2-1234-5678";
        final boolean isValidPhone1 = StringChecker.isValidPhoneNumber(phone1);
        final boolean isValidPhone2 = StringChecker.isValidPhoneNumber(phone2);
        final boolean isValidPhone3 = StringChecker.isValidPhoneNumber(phone3);

        final String rrn1 = "991231-1234567";
        final String rrn2 = "0001013456789";
        final boolean isValidRrn1 = StringChecker.isValidRRN(rrn1);
        final boolean isValidRrn2 = StringChecker.isValidRRN(rrn2);

        System.out.println("\n=== test_VALID Start ===");
        System.out.println(String.format("Color: %b <- %s", isValidColor1, colorCode1));
        System.out.println(String.format("Color: %b <- %s", isValidColor2, colorCode2));
        System.out.println(String.format("Email: %b <- %s", isValidEmail1, email1));
        System.out.println(String.format("Email: %b <- %s", isValidEmail2, email2));
        System.out.println(String.format("Email: %b <- %s", isValidEmail3, email3));
        System.out.println(String.format("Hex: %b <- %s", isValidHex1, hex1));
        System.out.println(String.format("Hex: %b <- %s", isValidHex2, hex2));
        System.out.println(String.format("IP4: %b <- %s", isValidIp1, ip1));
        System.out.println(String.format("IP4: %b <- %s", isValidIp2, ip2));
        System.out.println(String.format("Port: %b <- %s", isValidPort1, port1));
        System.out.println(String.format("Port: %b <- %s", isValidPort2, port2));
        System.out.println(String.format("URL: %b <- %s", isValidUrl1, url1));
        System.out.println(String.format("URL: %b <- %s", isValidUrl2, url2));
        System.out.println(String.format("TAG: %b <- %s", isValidTag1, tag1));
        System.out.println(String.format("TAG: %b <- %s", isValidTag2, tag2));
        System.out.println(String.format("UUID: %b <- %s", isValidUuid1, uuid1));
        System.out.println(String.format("UUID: %b <- %s", isValidUuid2, uuid2));
        System.out.println(String.format("UUID: %b <- %s", isValidUuid3, uuid3));
        System.out.println(String.format("AddrLL: %b <- %s", isValidAddrLL1, addrLL1));
        System.out.println(String.format("AddrLL: %b <- %s", isValidAddrLL2, addrLL2));
        System.out.println(String.format("AddrRN: %b <- %s", isValidAddrRN1, addrRN1));
        System.out.println(String.format("AddrRN: %b <- %s", isValidAddrRN2, addrRN2));
        System.out.println(String.format("Currency: %b <- %s", isValidCurrency1, currency1));
        System.out.println(String.format("Currency: %b <- %s", isValidCurrency2, currency2));
        System.out.println(String.format("Currency: %b <- %s", isValidCurrency3, currency3));
        System.out.println(String.format("Mobile: %b <- %s", isValidMobile1, mobile1));
        System.out.println(String.format("Mobile: %b <- %s", isValidMobile2, mobile2));
        System.out.println(String.format("Mobile: %b <- %s", isValidMobile3, mobile3));
        System.out.println(String.format("Phone: %b <- %s", isValidPhone1, phone1));
        System.out.println(String.format("Phone: %b <- %s", isValidPhone2, phone2));
        System.out.println(String.format("Phone: %b <- %s", isValidPhone3, phone3));
        System.out.println(String.format("RRN: %b <- %s", isValidRrn1, rrn1));
        System.out.println(String.format("RRN: %b <- %s", isValidRrn2, rrn2));
        System.out.println("=== test_VALID End ===\n");

        assertTrue(isValidColor1);
        assertTrue(isValidColor2);
        assertTrue(isValidEmail1);
        assertTrue(isValidEmail2);
        assertTrue(isValidEmail3);
        assertTrue(isValidHex1);
        assertTrue(isValidHex2);
        assertTrue(isValidIp1);
        assertTrue(isValidIp2);
        assertTrue(isValidPort1);
        assertTrue(isValidPort2);
        assertTrue(isValidUrl1);
        assertTrue(isValidUrl2);
        assertTrue(isValidTag1);
        assertTrue(isValidTag2);
        assertTrue(isValidUuid1);
        assertTrue(isValidUuid2);
        assertTrue(isValidUuid3);
        assertTrue(isValidAddrLL1);
        assertTrue(isValidAddrLL2);
        assertTrue(isValidAddrRN1);
        assertTrue(isValidAddrRN2);
        assertTrue(isValidCurrency1);
        assertTrue(isValidCurrency2);
        assertTrue(isValidCurrency3);
        assertTrue(isValidMobile1);
        assertTrue(isValidMobile2);
        assertTrue(isValidMobile3);
        assertTrue(isValidPhone1);
        assertTrue(isValidPhone2);
        assertTrue(isValidPhone3);
        assertTrue(isValidRrn1);
        assertTrue(isValidRrn2);
    }


    @Test
    public void test_CREDIT_CARD()
    {
        // TODO: 금융보안상 테스트 끝난 후에는 소스에서 카드번호를 모두 지워야 한다.
        final String[] cards = { };

        boolean isValid;

        System.out.println("\n=== test_CREDIT_CARD Start ===");

        for ( String card : cards )
        {
            isValid = StringChecker.isValidCreditCardNum(card);
            System.out.println(String.format("Card: %b <- %s", isValid, card));
            assertTrue(isValid);
        }

        System.out.println("=== test_CREDIT_CARD End ===\n");
    }

    // End of StringCheckerTests.class
}

// End of StringCheckerTests.java

