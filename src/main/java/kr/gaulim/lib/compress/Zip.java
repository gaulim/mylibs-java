
package kr.gaulim.lib.compress;


import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


public class Zip
{
//  private static final String TAG = Zip.class.getSimpleName();
    private static final int BUF_SIZE = 4096;
    private static final int COMPRESSION_LEVEL = 9; // 압축률(기본값: 8, 최대값: 9)


    private Zip() { }


    /**
     * <p>지정한 경로를 압축한다.</p>
     *
     * @param path 압축할 경로
     *
     * @throws IOException 파일/경로 관련 예외시 발생
     */
    public static void compressFiles(final File path) throws IOException
    {
        try
        (
            final ByteArrayOutputStream bos = new ByteArrayOutputStream();
            final ZipOutputStream zos = new ZipOutputStream(bos)
        )
        {
            final byte[] buffer = new byte[BUF_SIZE];
            final String basePath = path.getCanonicalFile().getParent();

            compressFiles(basePath, path, zos, buffer);
        }
    }


    /**
     * <p>지정한 경로를 압축한다.</p>
     *
     * @param basePath  기본 경로
     * @param toAdd     추가 경로
     * @param zos       Zip 출력 스트림
     * @param plainData 버퍼
     *
     * @throws IOException 파일/경로 및 버퍼 입출력 예외시 발생
     */
    private static void compressFiles
    (
        final String basePath, final File toAdd,
        final ZipOutputStream zos, final byte[] plainData
    )
    throws IOException
    {
        if ( toAdd.isDirectory() )
        {
            final File[] files = toAdd.listFiles();

            if ( null != files )
            {
                for ( final File file : files )
                    compressFiles(basePath, file, zos, plainData);
            }
        }
        else
        {
            try ( final FileInputStream fis = new FileInputStream(toAdd) )
            {
                final String name = toAdd.getCanonicalPath().substring(basePath.length() + 1);
                final ZipEntry entry = new ZipEntry(name.replace('\\', '/'));
                zos.putNextEntry(entry);

                int readBytes;

                while ( -1 != ( readBytes = fis.read(plainData) ) )
                    zos.write(plainData, 0, readBytes);

                zos.closeEntry();
            }
        }
    }


    /**
     * <p>지정한 평문 자료를 압축한다.</p>
     *
     * @param name      압축 파일명
     * @param plainData 평문 이진 자료
     *
     * @return 압축된 이진 자료
     *
     * @throws IOException 파일/경로 및 버퍼 입출력 예외시 발생
     */
    public static byte[] compressBytes(final String name, final byte[] plainData)
            throws IOException
    {
        if ( 1 > plainData.length )
            return null;

        try
        (
            final ByteArrayInputStream bais = new ByteArrayInputStream(plainData);
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();
            final ZipOutputStream zos = new ZipOutputStream(baos)
        )
        {
            final byte[] buffer = new byte[BUF_SIZE];
            int readBytes;

            final ZipEntry entry = new ZipEntry(name.replace('\\', '/'));
            zos.putNextEntry(entry);

            while ( -1 != ( readBytes = bais.read(buffer) ) )
                zos.write(buffer, 0, readBytes);

            zos.closeEntry();

            return baos.toByteArray();
        }
    }


    ////////////////////////////////////////////////////////////////////////////

    /**
     * <p>지정한 Zip 파일을 압축 푼다.</p>
     *
     * @param compressFile 압축된 파일 경로
     *
     * @throws IOException 파일/경로 관련 예외시 발생
     */
    public static void uncompressFiles(final File compressFile) throws IOException
    {
        try
        (
            final FileInputStream fis = new FileInputStream(compressFile);
            final ZipInputStream zis = new ZipInputStream(fis)
        )
        {
            final String dir = compressFile.getCanonicalFile().getParent();
            final byte[] buffer = new byte[BUF_SIZE];
            int readBytes;

            ZipEntry entry;

            while ( null != ( entry = zis.getNextEntry() ) )
            {
                final File file = new File(dir, entry.getName());

                if ( entry.isDirectory() )
                {
                    file.mkdir();
                    continue;
                }

                try ( final BufferedOutputStream bos = new BufferedOutputStream(
                        new FileOutputStream(file)) )
                {
                    while ( -1 != ( readBytes = zis.read(buffer) ) )
                        bos.write(buffer, 0, readBytes);
                }

                zis.closeEntry();
            }
        }
    }


    /**
     * <p>지정한 Zip 자료를 압축 푼다.</p>
     *
     * @param zipData Zip 이진 자료
     *
     * @return 평문 이진 자료
     *
     * @throws IOException 파일/경로 및 버퍼 입출력 예외시 발생
     */
    public static byte[] uncompressBytes(final byte[] zipData) throws IOException
    {
        if ( 1 > zipData.length )
            return null;

        try
        (
            final ByteArrayInputStream bais = new ByteArrayInputStream(zipData);
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();
            final ZipInputStream zis = new ZipInputStream(bais)
        )
        {
            final byte[] buffer = new byte[BUF_SIZE];
            int readBytes;

            while ( null != zis.getNextEntry() )
            {
                while ( -1 != ( readBytes = zis.read(buffer) ) )
                    baos.write(buffer, 0, readBytes);

                zis.closeEntry();
            }

            return baos.toByteArray();
        }
    }

    // End of Zip.class
}

// End of Zip.java

