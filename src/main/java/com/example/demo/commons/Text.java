package com.example.demo.commons;

import org.springframework.beans.BeanUtils;
import sun.misc.IOUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Text {
    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        //字符串倒叙
//        String s = "abc";
//        char[] c = s.toCharArray();
//        for(int i=c.length-1;i>=0;i--){
//            System.out.print(c[i]+"");
//        }

        //从字符串中查找小写字母的次数，大写字母的次数isUpperCase()
//        String s="abcDE";
//        char[] c = s.toCharArray();
//        int count=0;
//        for (char a:
//             c) {
//            if(Character.isLowerCase(a)){
//                count++;
//            }
//        }
//        System.out.print(count);

        //从字符串中找出相同的另一个字符串
//         String s="666abcdef123abc666";
//         String src="abc";
//         int count=0;
//         int index=0;
//         while((index=s.indexOf(src))!=-1){
//             count++;
//             s=s.substring(index+src.length());
//         }
//        System.out.print(count);

        //从字符串中找出第一个单词
//        String s="hello world";
//        String[] sl = s.split(" ");
//        System.out.print(sl[0]);

        //检测字符串以什么为前缀
//        String s="www.baidu.com";
//        boolean b=s.startsWith("www");
//        System.out.print(b);

        //替换字符串
//        String s="hello world";
//        String replace = s.replace("o", "t");
//        System.out.print(replace);

        //字符串转换
//        String s="hello world";
//        char[] chars = s.toCharArray();
//        String s1 = String.copyValueOf(chars);
//        System.out.print(s1);

        //字符串复制
//        String s="hello world";
//        char[] chars=new char[6];
//        try {
//            s.getChars(1,4,chars,2);
//            System.out.println(chars);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //字符串区域判定
//        String s="hello world";
//        String s1="boy hello";
//        boolean b = s.regionMatches(true, 1, s1, 5, 4);
//        System.out.print(b);

        //字符串提取字符序列
//        String s="hello world";
//        CharSequence charSequence = s.subSequence(3, 8);
//        System.out.print(charSequence);

        //StringBuffer StringBuilder
//        StringBuilder s=new StringBuilder("hello world");
//        int capacity = s.capacity();
//        System.out.print(capacity);

        //数组 旧数组去0复制到新数组
//        int[] old=new int[]{5,0,2,3,0,4};
//        int count=0;
//        for (int i = 0; i <old.length ; i++) {
//            if (old[i] ==0) {
//                count++;
//            }
//        }
//        int[] newArray = new int[old.length - count];
//        int m=0;
//        for (int i = 0; i <old.length ; i++) {
//            if (old[i]!=0) {
//                newArray[m]=old[i];
//                m++;
//            }
//        }
//        for (int i:
//             newArray) {
//            System.out.print(i+" ");
//        }
        //Arrays运用
//        int[] arr=new int[]{3,9,8,4,6,7};
//        Arrays.sort(arr);
//        for (int i:
//             arr) {
//            System.out.print(i+" ");
//        }
//        int a=5;
//        int i = Arrays.binarySearch(arr, a);
//        System.out.print(i);
//        Arrays.fill(arr,1,3,a);
//        for (int j:
//                arr) {
//            System.out.println(j+" ");
//        }

        //io流
//        File f=new File("D:/txt/txt.txt");
//        System.out.println(f.getPath());
//        System.out.println(f.getName());
//        System.out.println(f.length());
//        System.out.println(f.getAbsolutePath());
//        try {
//            OutputStream outputStream=new FileOutputStream("D:/txt/txt.txt",true);
//            byte[] b = "是不是呢".getBytes();
//            outputStream.write(b);
//            outputStream.close();;
//        }catch (Exception e){
//            e.getMessage();
//        }
//        InputStream inputStream=null;
//        try {
//            inputStream=new FileInputStream("D://txt/txt.txt");
//            byte[] bytes = new byte[1024];
//            int len=0;
//            while ((len=inputStream.read(bytes))!=-1){
//                System.out.print(new String(bytes,0,len));
//            }
//        }catch (Exception e){
//            e.getMessage();
//        }finally {
//            try{
//             inputStream.close();
//            }catch (Exception e){
//                e.getMessage();
//            }
//        }
        //复制图片
        // 创建流对象
//        InputStream inputStream=null;
//        OutputStream outputStream=null;
//        try {
//             inputStream = new FileInputStream("D://txt/1.jpg");
//             outputStream = new FileOutputStream("D://txt/text/3.jpg");
//            // 读写数据
//            byte[] bytes = new byte[1024];
//            int len;
//            while ((len = inputStream.read(bytes)) != -1) {
//                outputStream.write(bytes, 0, len);
//            }
//
//            // 关闭资源
//
//        }catch (Exception e){
//            e.getMessage();
//        }finally {
//            try{
//                outputStream.close();
//                inputStream.close();
//            }catch (Exception e){
//                e.getMessage();
//            }
//        }

        //字符流的io
//        FileWriter writer=null;
//        FileReader reader=null;
//        try {
//            reader=new FileReader("D://txt/txt.txt");
//            writer=new FileWriter("D://txt/text/txt.txt");
//            char[] chars = new char[1024];
//            int len;
//            while((len=reader.read(chars))!=-1){
//                writer.write(chars,0,len);
//            }
//            writer.flush();
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            try {
//                writer.close();
//                reader.close();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }

        //高速缓冲流
//        long start = System.currentTimeMillis();
//        try(
//                BufferedInputStream inputStream=new BufferedInputStream(new FileInputStream("d://chromeDown/setup.exe"));
//                BufferedOutputStream outputStream=new BufferedOutputStream(new FileOutputStream("d://txt/setup.exe"));
//            ){,
//                int len;
//            byte[] bytes = new byte[8 * 1024];
//            while ((len=inputStream.read(bytes))!=-1){
//                    outputStream.write(bytes,0,len);
//                }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        long end = System.currentTimeMillis();
//        System.out.print("时间"+(end-start));

        //王者荣耀排序进场
//        ArrayList<people> list = new ArrayList<people>();
//        list.add(new people("zhaoxin",200));
//        list.add(new people("wolong",100));
//        list.add(new people("jinhang",300));
//        Collections.sort(list);
//        for (people p:
//             list) {
//            System.out.println(p.toString());
//        }

    }
}

//人员战备
//class people implements Comparable<people>{
//    private String name;
//    private int rank;
//    public people(String name,int rank){
//        this.name=name;
//        this.rank=rank;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public void setRank(int rank) {
//        this.rank = rank;
//    }
//    public String getName() {
//        return name;
//    }
//    public int getRank() {
//        return rank;
//    }
//    @Override
//    public String toString() {
//        return "people{" +
//                "name='" + name + '\'' +
//                ", rank=" + rank +
//                '}';
//    }
//
//    @Override
//    public int compareTo(people o) {
//        return this.rank - o.rank;/
//    }
//}
