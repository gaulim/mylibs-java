
package kr.gaulim.lib.compress;


import kr.gaulim.lib.random.RandomGenerator;

import java.io.IOException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Base64;

import org.junit.Test;

import static org.junit.Assert.*;


public class CompressTests
{
    private String displayCompactText(final String text)
    {
        if ( 36 < text.length() )
            return text.substring(0, 32) + " ...";
        else
            return text;
    }


    @Test
    public void test_ZIP_UNZIP()
    {
        final String src = "모든 테스트가 끝나고 이 문장을 읽을 수 있다면 테스트 성공입니다.";

        String encoded, decoded;
        byte[] zipData, unzipData;
        int srcLen, encodedLen, decodedLen;

        try
        {
            encoded = Base64.getEncoder().encodeToString(src.getBytes("UTF-8"));
            zipData = Zip.compressBytes("ziptest", encoded.getBytes("UTF-8"));
            unzipData = Zip.uncompressBytes(zipData);
            decoded = new String(Base64.getDecoder().decode(unzipData), "UTF-8");

            srcLen = src.getBytes("UTF-8").length;
            encodedLen = encoded.getBytes("UTF-8").length;
            decodedLen = decoded.getBytes("UTF-8").length;

            System.out.println("\n=== test_ZIP_UNZIP Start ===");
            System.out.println(String.format("원문  : [%d B] - [%s]", srcLen, src));
            System.out.println(String.format("인코딩: [%d B] - [%s]", encodedLen, encoded));
            System.out.println(String.format("Zip   : [%d B]", zipData.length));
            System.out.println(String.format("Unzip : [%d B]", unzipData.length));
            System.out.println(String.format("디코딩: [%d B] - [%s]", decodedLen, decoded));
            System.out.println("=== test_ZIP_UNZIP End ===\n");

            assertEquals(src, decoded);
        }
        catch ( final IOException e )
        {
            e.printStackTrace();
            assertTrue(e.getLocalizedMessage(), false);
        }
    }


    @Test
    public void test_ZIP_LOOP()
    {
        final int MAX_SIZE = 1024 * 1024 * 2;
        final StringBuilder builder = new StringBuilder(MAX_SIZE);

        String plainText;
        String resultText;

        byte[] plainData;
        byte[] zipData;
        byte[] unzipData;

        int num = 0;
        int size = 1;

        int textSize;
        int zipSize;
        int unzipSize;
        float rate;

        long beginTime;
        float zipTime, unzipTime;

        try
        {
            while ( MAX_SIZE > (size *= 2) )
            {
                ++num;

                builder.setLength(0);
                builder.append(RandomGenerator.generateLower(size));
                plainText = builder.toString();
                size = plainText.length();

                plainData = plainText.getBytes("UTF-8");

                beginTime = System.nanoTime();
                zipData = Zip.compressBytes("ziptest", plainData);
                zipTime = (System.nanoTime() - beginTime) / 1000000.0f;

                beginTime = System.nanoTime();
                unzipData = Zip.uncompressBytes(zipData);
                unzipTime = (System.nanoTime() - beginTime) / 1000000.0f;

                resultText = new String(unzipData, "UTF-8");

                textSize = plainData.length;
                zipSize = zipData.length;
                unzipSize = unzipData.length;
                rate = ((float)zipSize) / ((float)textSize) * 100.0f;

                System.out.println("\n=== test_ZIP_LOOP (" + num + ") Start ===");
                System.out.println(String.format("원문: %d bytes, %s",
                                        textSize, displayCompactText(plainText)));
                System.out.println(String.format("압축: %d bytes, %.2f%%, %.2f ms",
                                                    zipSize, rate, zipTime) );
                System.out.println(String.format("해제: %d bytes, %.2f ms",
                                                    unzipSize, unzipTime) );
                System.out.println("=== test_ZIP_LOOP (" + num + ") End ===\n");

                assertEquals(plainText, resultText);
            }
        }
        catch ( final UnsupportedCharsetException | IOException e )
        {
            e.printStackTrace();
            assertTrue(e.getLocalizedMessage(), false);
        }
    }


    @Test
    public void test_GZIP_LOOP()
    {
        final int MAX_SIZE = 1024 * 1024 * 2;
        final StringBuilder builder = new StringBuilder(MAX_SIZE);

        String plainText;
        String resultText;

        byte[] plainData;
        byte[] gzipData;
        byte[] gunzipData;

        int num = 0;
        int size = 1;

        int textSize;
        int gzipSize;
        int gunzipSize;
        float rate;

        long beginTime;
        float gzipTime, gunzipTime;

        try
        {
            while ( MAX_SIZE > (size *= 2) )
            {
                ++num;

                builder.setLength(0);
                builder.append(RandomGenerator.generateLower(size));
                plainText = builder.toString();
                size = plainText.length();

                plainData = plainText.getBytes("UTF-8");

                beginTime = System.nanoTime();
                gzipData = GZip.compressBytes(plainData);
                gzipTime = (System.nanoTime() - beginTime) / 1000000.0f;

                beginTime = System.nanoTime();
                gunzipData = GZip.uncompressBytes(gzipData);
                gunzipTime = (System.nanoTime() - beginTime) / 1000000.0f;

                resultText = new String(gunzipData, "UTF-8");

                textSize = plainData.length;
                gzipSize = gzipData.length;
                gunzipSize = gunzipData.length;
                rate = ((float)gzipSize) / ((float)textSize) * 100.0f;

                System.out.println("\n=== test_GZIP_LOOP (" + num + ") Start ===");
                System.out.println(String.format("원문: %d bytes, %s",
                                        textSize, displayCompactText(plainText)));
                System.out.println(String.format("압축: %d bytes, %.2f%%, %.2f ms",
                                                    gzipSize, rate, gzipTime) );
                System.out.println(String.format("해제: %d bytes, %.2f ms",
                                                    gunzipSize, gunzipTime));
                System.out.println("=== test_GZIP_LOOP (" + num + ") End ===\n");

                assertEquals(plainText, resultText);
            }
        }
        catch ( final UnsupportedCharsetException | IOException e )
        {
            e.printStackTrace();
            assertTrue(e.getLocalizedMessage(), false);
        }
    }

    // End of CompressTests.class
}

// End of CompressTests.java

