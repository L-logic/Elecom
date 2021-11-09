package org.csu.electriccommerce.tool.company;

import java.io.*;

public class NewCleanFileClass {
    public static void Clean(String wordIn, String wordOut,int num) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        File fileOut = new File(wordOut);
        InputStreamReader inStream = new InputStreamReader(new FileInputStream(new File(wordIn)), "GBK");//读取文件
        OutputStreamWriter outStream = new OutputStreamWriter(new FileOutputStream(new File(wordOut)), "utf-8");
        BufferedReader bf = new BufferedReader(inStream);
        BufferedWriter bw = new BufferedWriter(outStream);
        String valueString = null;
        char c[];
        while ((valueString = bf.readLine()) != null){
            c = valueString.toCharArray();
            for(int i = 39; i < valueString.length(); i++) { //只保留下关键字
                bw.append(c[i]);
                if(c[i] == '\t') {
                    bw.newLine();
                }
            }
            if(fileOut.length() > num*1000000) break;//取numM的数据num*1024*1024
        }
        bw.close();
    }
}