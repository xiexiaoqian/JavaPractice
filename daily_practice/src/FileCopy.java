import java.io.*;

/**
 * @author xxq
 * @ClassName FileCopy
 * @Description TODO
 * @Date 2020/1/30
 * @Version 1.0
 **/
public class FileCopy {

    public static void main(String[] args) {
        //构造字符串，需要拷贝的文件路径
        String srcFilePath = "D:\\JavaWebWork\\寒假\\JAVA日日练\\FileCopy\\file.txt";
        String srcFilePathPic = "D:\\JavaWebWork\\寒假\\JAVA日日练\\FileCopy\\cat (5).png";
        //目的地路径和文件名
        String destFilePathStr = "D:\\JavaWebWork\\寒假\\JAVA日日练\\FileCopy\\file_strcopy.txt";
        String destFilePathCh = "D:\\JavaWebWork\\寒假\\JAVA日日练\\FileCopy\\file_chcopy.txt";
        String destFilePathChBys = "D:\\JavaWebWork\\寒假\\JAVA日日练\\FileCopy\\cat (5).png_copy.jpg";

        //缓冲字符流，一次读取一个字符
        FileCopy.chCopy(srcFilePath, destFilePathStr);
        //缓冲字符流，一次读取一行
        FileCopy.strCopy(srcFilePath, destFilePathCh);
        //缓冲字节流，拷贝图片文件
        FileCopy.chCopyByStream(srcFilePathPic,destFilePathChBys);
    }


    /**
     * 缓冲字符流拷贝文件，一次读写一行数据
     *
     * @param srcFilePath
     * @param destFilePath
     * @throws IOException
     */
    public static void strCopy(String srcFilePath, String destFilePath){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(srcFilePath));
            bw = new BufferedWriter(new FileWriter(destFilePath));

            long starTime = System.currentTimeMillis();

            //缓冲流一次读取一行
            String str;
            while ((str = br.readLine()) != null) {
                bw.write(str);
                bw.newLine();
            }
            //冲刷缓冲区
            bw.flush();

            long endTime = System.currentTimeMillis() - starTime;
            System.out.println("运行时间：" + endTime + "ms");
        } catch (FileNotFoundException e) {
            System.out.println("目标文件未找到！");
        }catch (IOException e) {
            System.out.println("文件读写异常！");
        }finally {
            try {
                bw.close();
                br.close();
            } catch (IOException e) {
                System.out.println("关闭字符流错误！");
            }
        }
        System.out.println("拷贝完成！");
    }

    /**
     * 缓冲字符流拷贝文件，一次读写一个字符
     *
     * @param srcFilePath
     * @param destFilePath
     * @throws IOException
     */
    public static void chCopy(String srcFilePath, String destFilePath) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(srcFilePath));
            bw = new BufferedWriter(new FileWriter(destFilePath));

            long startTime = System.currentTimeMillis();

            //缓冲流一次读取一行
            int ch;
            while ((ch = br.read()) != -1) {
                bw.write(ch);
            }
            bw.flush();

            long endTime = System.currentTimeMillis() - startTime;
            System.out.println("运行时间：" + endTime + "ms");
        } catch (FileNotFoundException e) {
            System.out.println("目标文件未找到！");
        } catch (IOException e) {
            System.out.println("文件读写异常！");
        } finally {
            try {
                bw.close();
                br.close();
            } catch (IOException e) {
                System.out.println("关闭字符流错误！");
            }
        }
        System.out.println("拷贝完成！");
    }

    /**
     * 缓冲字节流拷贝文件，拷贝图片
     *
     * @param srcFilePath
     * @param destFilePath
     * @throws IOException
     */
    public static void chCopyByStream(String srcFilePath, String destFilePath) {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(srcFilePath));
            bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
            byte[] temp = new byte[1024];

            long startTime = System.currentTimeMillis();

            int length = 0;
            while ((length = bis.read(temp,0,temp.length)) != -1) {
                bos.write(temp,0,length);
            }
            bos.flush();

            long endTime = System.currentTimeMillis() - startTime;
            System.out.println("运行时间：" + endTime + "ms");
        } catch (FileNotFoundException e) {
            System.out.println("目标文件未找到！");
        }catch (IOException e) {
            System.out.println("文件读写异常!");
        }finally {
            try {
                bos.close();
                bis.close();
            } catch (IOException e) {
                System.out.println("关闭字节流错误！");
            }
        }
        System.out.println("拷贝完成！");

    }

}
