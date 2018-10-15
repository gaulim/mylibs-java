
package kr.gaulim.lib.compress;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


public class GZip
{
//  private static final String TAG = GZip.class.getSimpleName();
    private static final int BUF_SIZE = 4096;
    private static final int COMPRESSION_LEVEL = 9; // 압축률(기본값: 8, 최대값: 9)


    private GZip() { }


    /**
     * <p>지정한 이진 자료가 압축되었는지 판단한다.</p>
     *
     * @param compressedData 압축된 이진 자료
     *
     * @return 압축 여부
     */
    public static boolean isCompressed(final byte[] compressedData)
    {
        return
        (compressedData[0] == (byte)(GZIPInputStream.GZIP_MAGIC))
        &&
        (compressedData[1] == (byte)(GZIPInputStream.GZIP_MAGIC >> 8));
    }

    ////////////////////////////////////////////////////////////////////////////


    /**
     * <p>지정한 평문 자료를 압축한다.</p>
     *
     * @param plainData 평문 이진 자료
     *
     * @return 압축된 이진 자료
     *
     * @throws IOException 버퍼 입출력 예외시 발생
     */
    public static byte[] compressBytes(final byte[] plainData) throws IOException
    {
        try
        (
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();
            final GZIPOutputStream gzos = new GZIPOutputStream(baos)
        )
        {
            gzos.write(plainData);
            gzos.flush();
            gzos.close();   // 이부분이 빠지면 오류 발생

            return baos.toByteArray();
        }
    }


    ////////////////////////////////////////////////////////////////////////////

    /**
     * <p>지정한 GZip 자료를 압축 푼다.</p>
     *
     * @param gzipData GZip 이진 자료
     *
     * @return 평문 이진 자료
     *
     * @throws IOException 버퍼 입출력 예외시 발생
     */
    public static byte[] uncompressBytes(final byte[] gzipData) throws IOException
    {
        try
        (
            final ByteArrayInputStream bais = new ByteArrayInputStream(gzipData);
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();
            final GZIPInputStream gzis = new GZIPInputStream(bais) )
        {
            byte[] buffer = new byte[BUF_SIZE];
            int readBytes;

            while ( -1 != ( readBytes = gzis.read(buffer) ) )
                baos.write(buffer, 0, readBytes);

            return baos.toByteArray();
        }
    }

    // End of GZip.class
}

// End of GZip.java

