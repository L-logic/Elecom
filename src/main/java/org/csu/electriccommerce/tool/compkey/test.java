package org.csu.electriccommerce.tool.compkey;

import org.csu.electriccommerce.tool.datafile.MainDataClass;
import org.csu.electriccommerce.tool.datafile.PathClass;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class test {
    public static void main(String[] args) throws Exception {
        String wordKey = "奔驰";
        int n = 10;
        PathClass pa = new PathClass();
        System.out.println("开始从总搜索量中提取出与种子关键字相关的搜索信息...");
        try {
            new MainDataClass().data(wordKey);  //已完成从原数据中提取出与种子关键字相关的搜索信息
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("开始查找中介关键词...");
        /*用关键字的频率来代替权重，找出前10个中介关键字，并将保存到文件wordMidKey中*/
        InputStreamReader inStream = null;
        inStream = new InputStreamReader(new FileInputStream("E:\\entertainment\\关于学习\\学习使我快乐\\大三上\\电子商务\\奔驰frequencis.txt"), StandardCharsets.UTF_8);
        OutputStreamWriter outStream = new OutputStreamWriter(new FileOutputStream(new File("E:\\entertainment\\关于学习\\学习使我快乐\\大三上\\电子商务\\test奔驰.txt")), StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(outStream);
        BufferedReader bf = new BufferedReader(inStream);
            PrintStream out = System.out;
            String valueString = null;
            int sum = 0;
        try {
            valueString = bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                if (!((valueString = bf.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            int temp = valueString.indexOf("=");
                valueString = valueString.substring(0, temp); //过滤词频文件中，单字词语、首位为数字的词和种子关键字
                char c = valueString.charAt(0);
                if(valueString.length() <= 1 || valueString.contains(wordKey) || (c >= '0' && c <= '9')) { //过滤掉一个字的中介关键词和种子关键字
                    continue;
                } else {
                    System.out.println(valueString);
                    sum++;
                    bw.write(valueString);
                    bw.newLine();
                }
                if (sum == n) {
                    break;
                }
            }
        bw.close();
    }
}
