
package kr.gaulim.lib.string;


import org.junit.Test;

import static org.junit.Assert.*;


public class StringReplacerTests
{
    @Test
    public void test_STRIP_TAG()
    {
        final String tagStr1 = "<p>태그 문자열 1</p>";
        final String tagStr2 = "<strong>태그 문자열 2</strong>";

        final String str1 = StringReplacer.stripTag(tagStr1);
        final String str2 = StringReplacer.stripTag(tagStr2);

        System.out.println("\n=== test_STRIP_TAG Start ===");
        System.out.println(String.format("Tag1: %s -> %s", tagStr1, str1));
        System.out.println(String.format("Tag2: %s -> %s", tagStr2, str2));
        System.out.println("=== test_STRIP_TAG End ===\n");

        assertEquals("태그 문자열 1", str1);
        assertEquals("태그 문자열 2", str2);
    }


    @Test
    public void test_MAKE_LINK()
    {
        final String link1 = "http://www.domain.com";
        final String link2 = "https://host.domain.co.kr";

        final String tag1 = StringReplacer.makeLinkTag(link1);
        final String tag2 = StringReplacer.makeLinkTag(link2);

        System.out.println("\n=== test_MAKE_LINK Start ===");
        System.out.println(String.format("Link1: %s -> %s", link1, tag1));
        System.out.println(String.format("Link2: %s -> %s", link2, tag2));
        System.out.println("=== test_MAKE_LINK End ===\n");

        assertEquals("<a href='http://www.domain.com'>http://www.domain.com</a>", tag1);
        assertEquals("<a href='https://host.domain.co.kr'>https://host.domain.co.kr</a>", tag2);
    }


    @Test
    public void test_MASK_WORD()
    {
        final String word1 = "Word1";
        final String word2 = "단어2";
        final String word3 = "Pneumonoultramicroscopicsilicovolcanoconiosis";
        final String maskedWord1 = StringReplacer.maskWord(word1);
        final String maskedWord2 = StringReplacer.maskWord(word2);
        final String maskedWord3 = StringReplacer.maskWord(word3, '+', 8, 16);

        final String name1 = "아무개";
        final String name2 = "홍길동";
        final String maskedName1 = StringReplacer.maskName('*', name1);
        final String maskedName2 = StringReplacer.maskName('$', name2);

        final String phoneNum1 = "021234567";
        final String phoneNum2 = "01022223333";
        final String maskedPhoneNum1 = StringReplacer.maskPhoneNum('*', phoneNum1);
        final String maskedPhoneNum2 = StringReplacer.maskPhoneNum('#', phoneNum2);

        final String cardNum1 = "1111333355557777";
        final String cardNum2 = "123456787654321";
        final String maskedCardNum1 = StringReplacer.maskCardNum('*', cardNum1);
        final String maskedCardNum2 = StringReplacer.maskCardNum('#', cardNum2);

        final String email = "mailid@domain.com";
        final String maskedEmail = StringReplacer.maskEmail(email);

        System.out.println("\n=== test_MASK_WORD Start ===");
        System.out.println(String.format("Word1: %s -> %s", word1, maskedWord1));
        System.out.println(String.format("Word2: %s -> %s", word2, maskedWord2));
        System.out.println(String.format("Word3: %s -> %s", word3, maskedWord3));
        System.out.println(String.format("Name1: %s -> %s", name1, maskedName1));
        System.out.println(String.format("Name2: %s -> %s", name2, maskedName2));
        System.out.println(String.format("PhoneNum1: %s -> %s", phoneNum1, maskedPhoneNum1));
        System.out.println(String.format("PhoneNum2: %s -> %s", phoneNum2, maskedPhoneNum2));
        System.out.println(String.format("CardNum1: %s -> %s", cardNum1, maskedCardNum1));
        System.out.println(String.format("CardNum2: %s -> %s", cardNum2, maskedCardNum2));
        System.out.println(String.format("Email: %s -> %s", email, maskedEmail));
        System.out.println("=== test_MASK_WORD End ===\n");

        assertEquals("*****", maskedWord1);
        assertEquals("***", maskedWord2);
        assertEquals("Pneumono++++++++++++++++silicovolcanoconiosis", maskedWord3);
        assertEquals("아*개", maskedName1);
        assertEquals("홍$동", maskedName2);
        assertEquals("021****67", maskedPhoneNum1);
        assertEquals("01022####33", maskedPhoneNum2);
        assertEquals("111133******7777", maskedCardNum1);
        assertEquals("123456######321", maskedCardNum2);
        assertEquals("mai***@domain.com", maskedEmail);
    }


    @Test
    public void test_TELNUM_FORMAT()
    {
        final String telnum1 = "12345678";
        final String telnum2 = "0212345678";
        final String telnum3 = "01012345678";

        final String telnum1F = StringReplacer.formatPhoneNum(telnum1);
        final String telnum2F = StringReplacer.formatPhoneNum(telnum2);
        final String telnum3F = StringReplacer.formatPhoneNum(telnum3);

        System.out.println("\n=== test_TELNUM_FORMAT Start ===");
        System.out.println(String.format("Telnum1: %s -> %s", telnum1, telnum1F));
        System.out.println(String.format("Telnum2: %s -> %s", telnum2, telnum2F));
        System.out.println(String.format("Telnum3: %s -> %s", telnum3, telnum3F));
        System.out.println("=== test_TELNUM_FORMAT End ===\n");

        assertEquals("12345678", telnum1F);
        assertEquals("02-1234-5678", telnum2F);
        assertEquals("010-1234-5678", telnum3F);
    }


    @Test
    public void test_FILTER_TEXT()
    {
        final String filter = "욕설1|욕설2|욕설3";

        final String str1 = "욕설1";
        final String str2 = "욕설2";
        final String str3 = "욕설3";
        final String str4 = "욕설아님";

        final String filtered1 = StringReplacer.filterText(filter, str1);
        final String filtered2 = StringReplacer.filterText(filter, str2);
        final String filtered3 = StringReplacer.filterText(filter, str3);
        final String filtered4 = StringReplacer.filterText(filter, str4);

        System.out.println("\n=== test_FILTER_TEXT Start ===");
        System.out.println(String.format("Filter: %s", filter));
        System.out.println(String.format("Str1: %s -> %s", str1, filtered1));
        System.out.println(String.format("Str2: %s -> %s", str2, filtered2));
        System.out.println(String.format("Str3: %s -> %s", str3, filtered3));
        System.out.println(String.format("Str4: %s -> %s", str4, filtered4));
        System.out.println("=== test_FILTER_TEXT End ===\n");

        assertEquals("***", filtered1);
        assertEquals("***", filtered2);
        assertEquals("***", filtered3);
        assertEquals("욕설아님", filtered4);
    }

    // End of StringReplacerTests.class
}

// End of StringReplacerTests.java

