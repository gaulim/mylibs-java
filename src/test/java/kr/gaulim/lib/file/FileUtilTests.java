
package kr.gaulim.lib.file;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

import static org.junit.Assert.*;


public class FileUtilTests
{
    @Test
    public void test_TEXT_FILE()
    {
        final String dir_src = "/tmp/testdir/src";
        final String dir_dest = "/tmp/testdir/dest";
        final String file_src = "file_src.txt";
        final String file_dest = "file_dest.txt";

        final String text = "텍스트 파일 내용입니다.";

        boolean isDirSrc = false;
        boolean isDirDest = false;
        boolean isFile1Src = false;
        boolean isFile1Dest = false;
        boolean isFile2Src = false;
        boolean isFile2Dest = false;
        boolean isDelFile = false;

        String text1 = null;
        String text2 = null;
        String text3 = null;
        String text4 = null;

        try
        {
            if ( !FileUtil.isExistDir(dir_src) )
                FileUtil.makeDirectory(dir_src);

            isDirSrc = FileUtil.isExistDir(dir_src);

            if ( !FileUtil.isExistFile(dir_src, file_src) )
                FileUtil.makeFile(dir_src, file_src, text);

            final File srcFile = new File(dir_src, file_src);
            final File destFile = new File(dir_src, file_dest);
            FileUtil.copyFile(srcFile, destFile, true);
            FileUtil.copyDirectory(dir_src, dir_dest, true);

            isDirDest = FileUtil.isExistDir(dir_dest);

            final String fullPath1 = dir_src + File.separator + file_src;
            final String fullPath2 = dir_src + File.separator + file_dest;
            isFile1Src = FileUtil.isExistFile(fullPath1);
            isFile1Dest = FileUtil.isExistFile(fullPath2);

            final String fullPath3 = dir_dest + File.separator + file_src;
            final String fullPath4 = dir_dest + File.separator + file_dest;
            isFile2Src = FileUtil.isExistFile(fullPath3);
            isFile2Dest = FileUtil.isExistFile(fullPath4);

            text1 = FileUtil.readTextFile(dir_src, file_src);
            text2 = FileUtil.readTextFile(dir_src, file_dest);
            text3 = FileUtil.readTextFile(dir_dest, file_src);
            text4 = FileUtil.readTextFile(dir_dest, file_dest);

            isDelFile = FileUtil.deleteFile(dir_src, file_dest);
            FileUtil.deleteFileAll(dir_dest);

            System.out.println("\n=== test_TEXT_FILE Start ===");
            System.out.println(String.format("DIR1    : (%s) %s", isDirSrc, dir_src));
            System.out.println(String.format("D1 File1: [(%s) %s] %s",
                                             isFile1Src, fullPath1, text1));
            System.out.println(String.format("D1 File2: [(%s) %s] %s",
                                             isFile1Dest, fullPath2, text2));
            System.out.println(String.format("DIR2    : (%s) %s", isDirDest, dir_dest));
            System.out.println(String.format("D2 File1: [(%s) %s] %s",
                                             isFile2Src, fullPath3, text3));
            System.out.println(String.format("D2 File2: [(%s) %s] %s",
                                             isFile2Dest, fullPath4, text4));
            System.out.println("=== test_TEXT_FILE End ===\n");
        }
        catch ( final IOException e )
        {
            e.printStackTrace();
        }

        assertTrue(isDirSrc);
        assertTrue(isFile1Src);
        assertTrue(isFile1Dest);
        assertTrue(isDirDest);
        assertTrue(isFile2Src);
        assertTrue(isFile2Dest);
        assertTrue(isDelFile);
    }


    @Test
    public void test_BINARY_FILE()
    {
        final String dir_src = "/tmp/testdir/src";
        final String dir_dest = "/tmp/testdir/dest";
        final String file_src = "file_src.bin";
        final String file_dest = "file_dest.bin";

        final String text = "텍스트를 2진으로 저장한 파일 내용입니다.";

        boolean isDirSrc = false;
        boolean isDirDest = false;
        boolean isFile1Src = false;
        boolean isFile1Dest = false;
        boolean isFile2Src = false;
        boolean isFile2Dest = false;
        boolean isDelFile = false;

        String text1 = null;
        String text2 = null;
        String text3 = null;
        String text4 = null;

        try
        {
            if ( !FileUtil.isExistDir(dir_src) )
                FileUtil.makeDirectory(dir_src);

            isDirSrc = FileUtil.isExistDir(dir_src);

            if ( !FileUtil.isExistFile(dir_src, file_src) )
                FileUtil.makeFile(dir_src, file_src, text.getBytes("UTF-8"));

            final File srcFile = new File(dir_src, file_src);
            final File destFile = new File(dir_src, file_dest);
            FileUtil.copyFile(srcFile, destFile, true);
            FileUtil.copyDirectory(dir_src, dir_dest, true);

            isDirDest = FileUtil.isExistDir(dir_dest);

            final String fullPath1 = dir_src + File.separator + file_src;
            final String fullPath2 = dir_src + File.separator + file_dest;
            isFile1Src = FileUtil.isExistFile(fullPath1);
            isFile1Dest = FileUtil.isExistFile(fullPath2);

            final String fullPath3 = dir_dest + File.separator + file_src;
            final String fullPath4 = dir_dest + File.separator + file_dest;
            isFile2Src = FileUtil.isExistFile(fullPath3);
            isFile2Dest = FileUtil.isExistFile(fullPath4);

            text1 = new String(FileUtil.readBinaryFile(dir_src, file_src), "UTF-8");
            text2 = new String(FileUtil.readBinaryFile(dir_src, file_dest), "UTF-8");
            text3 = new String(FileUtil.readBinaryFile(dir_dest, file_src), "UTF-8");
            text4 = new String(FileUtil.readBinaryFile(dir_dest, file_dest), "UTF-8");

            isDelFile = FileUtil.deleteFile(dir_src, file_dest);
            FileUtil.deleteFileAll(dir_dest);

            System.out.println("\n=== test_BINARY_FILE Start ===");
            System.out.println(String.format("DIR1    : (%s) %s", isDirSrc, dir_src));
            System.out.println(String.format("D1 File1: [(%s) %s] %s",
                                             isFile1Src, fullPath1, text1));
            System.out.println(String.format("D1 File2: [(%s) %s] %s",
                                             isFile1Dest, fullPath2, text2));
            System.out.println(String.format("DIR2    : (%s) %s", isDirDest, dir_dest));
            System.out.println(String.format("D2 File1: [(%s) %s] %s",
                                             isFile2Src, fullPath3, text3));
            System.out.println(String.format("D2 File2: [(%s) %s] %s",
                                             isFile2Dest, fullPath4, text4));
            System.out.println("=== test_BINARY_FILE End ===\n");
        }
        catch ( final UnsupportedEncodingException e )
        {
            e.printStackTrace();
        }
        catch ( final IOException e )
        {
            e.printStackTrace();
        }

        assertTrue(isDirSrc);
        assertTrue(isFile1Src);
        assertTrue(isFile1Dest);
        assertTrue(isDirDest);
        assertTrue(isFile2Src);
        assertTrue(isFile2Dest);
        assertTrue(isDelFile);
    }

    // End of FileUtilTests.class
}

// End of FileUtilTests.java

