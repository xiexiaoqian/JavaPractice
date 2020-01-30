import java.io.*;

/**
 * @author xxq
 * @ClassName FileCopy
 * @Description TODO
 * @Date 2020/1/30
 * @Version 1.0
 **/
public class FileCopy {

    public static void main(String[] args) throws IOException {
        //构造字符串，需要拷贝的文件路径和目的地路径
        String srcFilePath = "D:\\JavaWebWork\\寒假\\JAVA日日练\\FileCopy\\file.txt";
        String srcFilePathPic = "D:\\JavaWebWork\\寒假\\JAVA日日练\\FileCopy\\img_BZ (6).jpg";

        String destFilePathStr = "D:\\JavaWebWork\\寒假\\JAVA日日练\\FileCopy\\file_strcopy.txt";
        String destFilePathCh = "D:\\JavaWebWork\\寒假\\JAVA日日练\\FileCopy\\file_chcopy.txt";
        String destFilePathChBys = "D:\\JavaWebWork\\寒假\\JAVA日日练\\FileCopy\\img_BZ (6)_copy.jpg";

//        byteStreamCopy(srcFilePathPic, destFilePathChBys);


        //缓冲字符流，一次读取一个字符
        FileCopy.chCopy(srcFilePath, destFilePathStr);
        //缓冲字符流，一次读取一行
        FileCopy.strCopy(srcFilePath, destFilePathCh);
        //缓冲字节流，一次读写一个字节
        FileCopy.chCopyByStream(srcFilePathPic,destFilePathChBys);
    }


    /**
     * 缓冲字符流拷贝文件，一次读写一行数据
     *
     * @param srcFilePath
     * @param destFilePath
     * @throws IOException
     */
    public static void strCopy(String srcFilePath, String destFilePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(srcFilePath));
        BufferedWriter bw = new BufferedWriter(new FileWriter(destFilePath));

        String str;
        //缓冲流一次读取一行
        while ((str = br.readLine()) != null) {
            bw.write(str);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
        System.out.println("拷贝完成！");
    }

    /**
     * 缓冲字符流拷贝文件，一次读写一个字符
     *
     * @param srcFilePath
     * @param destFilePath
     * @throws IOException
     */
    public static void chCopy(String srcFilePath, String destFilePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(srcFilePath));
        BufferedWriter bw = new BufferedWriter(new FileWriter(destFilePath));

        int ch;
        //缓冲流一次读取一行
        while ((ch = br.read()) != -1) {
            bw.write(ch);
        }
        bw.flush();
        bw.close();
        br.close();
        System.out.println("拷贝完成！");
    }

    /**
     * 缓冲字节流拷贝文件，
     *
     * @param srcFilePath
     * @param destFilePath
     * @throws IOException
     */
    public static void chCopyByStream(String srcFilePath, String destFilePath) throws IOException {

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFilePath),512);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath),512);

        FileInputStream fis = new FileInputStream(srcFilePath);
        FileOutputStream fos = new FileOutputStream(destFilePath);




        byte[] temp = new byte[1024];
        int length = 0;
        while ((length = bis.read(temp,0,temp.length)) != -1) {
            bos.write(temp,0,length);
        }
        bos.flush();
        bos.close();
        bis.close();
        System.out.println("拷贝完成！");

    }


    /**
     * 通过缓冲字节流实现图片类型文件的拷贝功能
     * @param fromPath 指定文件的路径
     * @param toPath 拷贝后的文件放置路径
     */
//    public static void byteStreamCopy(String fromPath, String toPath) {
//        InputStream fis, bis = null;
//        OutputStream fos, bos = null;
//
//        try {
//            // 创建字节输入流对象
//            fis = new FileInputStream(fromPath);
//            // 创建缓冲字节输入流对象，负责读取指定路径下的文件
//            bis = new BufferedInputStream(fis, 512);
//
//            // 创建字节输出流对象
//            fos = new FileOutputStream(toPath);
//            // 创建缓冲字节输出流对象，负责文件的复制操作
//            bos = new BufferedOutputStream(fos, 512);
//
//            // 创建中转站数组，存放每次读取的内容
//            byte[] temp = new byte[1024];
//
//            long startTime = System.currentTimeMillis();
//            int length = 0;
//            // 边读边写
//            while ((length = bis.read(temp,0,temp.length)) != -1) {
//                bos.write(temp,0,length);
//            }
//            // 冲刷缓冲区
//            bos.flush();
//            long endTime = System.currentTimeMillis() - startTime;
//            System.out.println("运行时间：" + endTime + "ms");
//        } catch (FileNotFoundException e) {
//            System.out.println("指定文件未找到");
//        } catch (IOException e) {
//            System.out.println("文件读取出现异常");
//        } finally {
//            try {
//                // 关闭流
//                bos.close();
//                bis.close();
//            } catch (IOException e) {
//                System.out.println("字节流关闭出错");
//            }
//        }
//    }


}
