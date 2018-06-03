package xin.val1ant;

import org.apache.commons.io.FileUtils;


import java.io.*;

import java.util.HashSet;
import java.util.Set;

/**
 * 批量实现文件GBK to UTF-8
 */
public class Main {



    public static void main(String[] args) {
        String path = args[0];
        String[] strings = path.split(",");
        Set<String> types = new HashSet<String>();
        for (String s : strings) {
            types.add(s);
        }
        File directory = new File(".");
//        System.out.println(directory.getAbsolutePath());
        handle(directory.getAbsolutePath(),types);

    }


    public static void handle(String path,Set<String> types){

        File[] files = new File(path).listFiles(); //获取该目录下所有文件或者目录
        if (files != null){
            for (File file : files) {
                if (file.isDirectory()){
                    //如果是路径，则递归调用
                    handle(file.getAbsolutePath(),types);
                }else {
                    String fileName = file.getName();
                    try {
                        String charset = getCharset(file.getAbsoluteFile());
//                        String charset = FileUtils
                        if (charset.equals("GBK") && types.contains(fileName.substring(fileName.lastIndexOf(".")+1))){
                            //输出过程
                            System.out.println(fileName+": charset encode converting........");
                            //如果编码为GBK 且在指定文件类型范围内
                            FileUtils.writeLines(new File(file.getAbsolutePath()),"UTF-8",FileUtils.readLines(file,"GBK"));
                        }

                    } catch (IOException e) {
                        System.out.println("获取文件编码异常");
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static String getCharset(File file) throws IOException {

        BufferedInputStream bin = new BufferedInputStream( new FileInputStream(file));
        int p = (bin.read() << 8) + bin.read();
        String code = null;
        //其中的 0xefbb、0xfffe、0xfeff、0x5c75这些都是这个文件的前面两个字节的16进制数
        switch (p) {
            case 0xefbb:
                code = "UTF-8";
                break;
            case 0xfffe:
                code = "Unicode";
                break;
            case 0xfeff:
                code = "UTF-16BE";
                break;
            case 0x5c75:
                code = "ANSI|ASCII" ;
                break ;
            default:
                code = "GBK";
        }

        return code;

    }

}



