
package kr.gaulim.lib.string;


import org.junit.Test;

import static org.junit.Assert.*;


public class NvlTests
{
    @Test
    public void test_NVL()
    {
        final String str1 = null;
        final String str2 = "null";
        final String str3 = "";
        final String str4 = "str";

        final String result1 = Nvl.null2zero(str1);
        final String result2 = Nvl.null2zero(str2);
        final String result3 = Nvl.null2zero(str3);
        final String result4 = Nvl.null2zero(str4);

        System.out.println("\n=== test_NVL Start ===");
        System.out.println(String.format("str1: [%s]", result1));
        System.out.println(String.format("str2: [%s]", result2));
        System.out.println(String.format("str3: [%s]", result3));
        System.out.println(String.format("str4: [%s]", result4));
        System.out.println("=== test_NVL End ===\n");

        assertNotNull(result1);
        assertEquals("", result1);
        assertEquals("", result2);
        assertEquals("", result3);
        assertEquals("str", result4);
    }

    // End of NvlTests.class
}

// End of NvlTests.java

