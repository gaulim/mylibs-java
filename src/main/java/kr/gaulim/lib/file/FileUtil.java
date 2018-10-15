
package kr.gaulim.lib.file;


import java.io.*;
import java.nio.channels.FileChannel;


public class FileUtil
{
//  private static final String TAG = FileUtil.class.getSimpleName();
    private static final int BUF_SIZE = 1024;


    private FileUtil() { }


    /**
     * <p>디렉토리가 있는지 검사</p>
     *
     * @param dirName 디렉토리명
     *
     * @return 디렉토리 존재 여부 (true:있음, false:없음)
     */
    public static boolean isExistDir(final String dirName)
    {
        final File dir = new File(dirName);
        return dir.isDirectory();
    }


    /**
     * <p>파일이 있는지 검사</p>
     *
     * @param pathName 전체 경로명
     *
     * @return 파일 존재 여부 (true:있음, false:없음)
     */
    public static boolean isExistFile(final String pathName)
    {
        final File file = new File(pathName);
        return file.isFile();
    }


    /**
     * <p>파일이 있는지 검사</p>
     *
     * @param pathName 경로명
     * @param fileName 파일명
     *
     * @return 파일 존재 여부 (true:있음, false:없음)
     */
    public static boolean isExistFile
    (
        final String pathName,
        final String fileName
    )
    {
        return isExistFile(pathName + File.separator + fileName);
    }


    /**
     * <p>디렉토리를 만든다.</p>
     *
     * @param pathName 경로명
     */
    public static void makeDirectory(final String pathName)
    {
        final File dir = new File(pathName);

        if ( !dir.isDirectory() )
            dir.mkdirs();
    }


    /**
     * <p>텍스트 파일을 만든다.</p>
     *
     * @param pathName 전체 경로명
     * @param text     파일 내용 (텍스트)
     *
     * @throws IOException 파일 쓰기 예외시 발생
     */
    public static void makeFile
    (
        final String pathName,
        final String text
    )
    throws IOException
    {
        try ( final BufferedWriter bw = new BufferedWriter(new FileWriter(pathName)) )
        {
            bw.write(text);
            bw.newLine();
        }
    }


    /**
     * <p>텍스트 파일을 만든다.</p>
     *
     * @param pathName 경로명
     * @param fileName 파일명
     * @param text     파일 내용 (텍스트)
     *
     * @throws IOException 파일 쓰기 예외시 발생
     */
    public static void makeFile
    (
        final String pathName,
        final String fileName,
        final String text
    )
    throws IOException
    {
        makeFile(pathName + File.separator + fileName, text);
    }


    /**
     * <p>2진 파일을 만든다.</p>
     *
     * @param pathName 전체 경로명
     * @param buf      파일 내용 (2진)
     *
     * @throws IOException 파일 쓰기 예외시 발생
     */
    public static void makeFile
    (
        final String pathName,
        final byte[] buf
    )
    throws IOException
    {
      try
      (
          final FileOutputStream fos = new FileOutputStream(pathName);
          final BufferedOutputStream bos = new BufferedOutputStream(fos);
      )
      {
          bos.write(buf);
      }
    }


    /**
     * <p>2진 파일을 만든다.</p>
     *
     * @param pathName 경로명
     * @param fileName 파일명
     * @param buf      파일 내용 (2진)
     *
     * @throws IOException 파일 쓰기 예외시 발생
     */
    public static void makeFile
    (
        final String pathName,
        final String fileName,
        final byte[] buf
    )
    throws IOException
    {
        makeFile(pathName + File.separator + fileName, buf);
    }


    /**
     * <p>텍스트 파일을 읽는다.</p>
     *
     * @param pathName 경로명
     *
     * @return 텍스트 내용
     *
     * @throws IOException 파일 읽기 예외시 발생
     */
    public static String readTextFile(final String pathName) throws IOException
    {
        final StringBuilder sb = new StringBuilder();

        try ( final BufferedReader br = new BufferedReader(new FileReader(pathName)) )
        {
            String text;

            while ( null != (text = br.readLine()) )
                sb.append(text);
        }

        return sb.toString();
    }


    /**
     * <p>텍스트 파일을 읽는다.</p>
     *
     * @param pathName 경로명
     * @param fileName 파일명
     *
     * @return 텍스트 내용
     *
     * @throws IOException 파일 읽기 예외시 발생
     */
    public static String readTextFile(final String pathName, final String fileName)
            throws IOException
    {
        return readTextFile(pathName + File.separator + fileName);
    }


    /**
     * <p>2진 파일을 읽는다.</p>
     *
     * @param pathName 경로명
     *
     * @return 2진 내용 (byte[])
     *
     * @throws IOException 파일 읽기 예외시 발생
     */
    public static byte[] readBinaryFile(final String pathName) throws IOException
    {
        byte[] result = null;

        try
        (
            final FileInputStream fis = new FileInputStream(pathName);
            final BufferedInputStream bis = new BufferedInputStream(fis, BUF_SIZE);
            final ByteArrayOutputStream baos = new ByteArrayOutputStream(BUF_SIZE);
        )
        {
            byte[] buf = new byte[BUF_SIZE];
            int readCount;

            while ( -1 != (readCount = bis.read(buf)) )
                baos.write(buf, 0, readCount);

            result = baos.toByteArray();
        }

        return result;
    }


    /**
     * <p>2진 파일을 읽는다.</p>
     *
     * @param pathName 경로명
     * @param fileName 파일명
     *
     * @return 2진 내용 (byte[])
     *
     * @throws IOException 파일 읽기 예외시 발생
     */
    public static byte[] readBinaryFile(final String pathName, final String fileName)
            throws IOException
    {
        return readBinaryFile(pathName + File.separator + fileName);
    }


    /**
     * <p>파일을 원하는 경로에 복사한다.</p>
     *
     * @param srcFile     원본 파일
     * @param destFile    사본 파일
     * @param isOverwrite 덮어쓸것인가?
     *
     * @return 복사된 바이트 크기
     *
     * @throws IOException 파일 읽기/쓰기 예외시 발생
     */
    public static long copyFile
    (
        final File srcFile,
        final File destFile,
        final boolean isOverwrite
    )
    throws IOException
    {
        long result = 0L;

        final String targetDirName = destFile.getParent();
        final File targetDir = new File(targetDirName);

        // 경로를 검사하여 없으면 생성한다.
        if ( !targetDir.isDirectory() )
            targetDir.mkdirs();

        // 기존 파일이 있으면 지운다.
        if ( isOverwrite && destFile.exists() )
            destFile.delete();

        // 기존 파일이 없을 경우에만 복사한다.
        if ( !destFile.exists() )
        {
            try
            (
                final FileInputStream fis = new FileInputStream(srcFile);
                final FileOutputStream fos = new FileOutputStream(destFile);
                final FileChannel fcin = fis.getChannel();
                final FileChannel fcout = fos.getChannel()
            )
            {
                long size = fcin.size();
                result = fcin.transferTo(0, size, fcout);
            }
        }

        return result;
    }


    /**
     * <p>디렉토리를 원하는 경로에 복사한다.</p>
     *
     * @param srcPathName  원본 경로
     * @param destPathName 사본 경로
     * @param isOverwrite  덮어쓸것인가?
     *
     * @throws IOException 파일 읽기/쓰기 예외시 발생
     */
    public static void copyDirectory
    (
        final String srcPathName,
        final String destPathName,
        final boolean isOverwrite
    )
    throws IOException
    {
        final File dirFile = new File(srcPathName);

        // 자식 디렉토리 목록을 얻는다.
        final String[] children = dirFile.list();

        if ( null != children )
        {
            String srcPath;
            String destPath;

            File srcFile;
            File destFile;

            for ( String fileName : children )
            {
                srcPath = srcPathName + File.separator + fileName;
                destPath = destPathName + File.separator + fileName;

                srcFile = new File(srcPath);
                destFile = new File(destPath);

                // 디렉토리이면 안에 있는 것 부터 복사한다.
                if ( srcFile.isDirectory() )
                    copyDirectory(srcPath, destPath, isOverwrite);

                copyFile(srcFile, destFile, isOverwrite);
            }
        }
    }


    /**
     * <p>파일을 지운다.</p>
     *
     * @param pathName 디렉토리 경로
     * @param fileName 파일명
     *
     * @return 파일 지움 결과 (true:성공, false:실패)
     */
    public static boolean deleteFile(final String pathName, final String fileName)
    {
        return deleteFile(pathName + File.separator + fileName);
    }


    /**
     * <p>파일을 지운다.</p>
     *
     * @param pathName 파일 경로
     *
     * @return 파일 지움 결과 (true:성공, false:실패)
     */
    public static boolean deleteFile(final String pathName)
    {
        final File file = new File(pathName);
        return (file.exists() && file.delete());
    }


    /**
     * <p>지정한 폴더 안에있는 모든 내용을 지운다.</p>
     *
     * @param pathName 디렉토리 경로
     */
    public static void deleteFileAll(final String pathName)
    {
        final File parent = new File(pathName);

        // 경로가 있는 경우
        if ( parent.exists() )
        {
            // 경로가 디렉토리인 경우
            if ( parent.isDirectory() )
            {
                // 자식 디렉토리 목록을 얻는다.
                final String[] children = parent.list();

                if ( null != children )
                {
                    String fullPathName;
                    File child;

                    for ( String fileName : children )
                    {
                        fullPathName = pathName + File.separator + fileName;
                        child = new File(fullPathName);

                        // 디렉토리이면 안에 있는 것 부터 지운다.
                        if ( child.isDirectory() )
                            deleteFileAll(fullPathName);

                        // 자식 파일 또는 디렉토리를 지운다.
                        if ( child.exists() )
                            child.delete();
                    }
                }
            }

            // 파일 또는 디렉토리를 지운다.
            parent.delete();
        }
    }

    // End of FileUtil.class
}

// End of FileUtil.java

