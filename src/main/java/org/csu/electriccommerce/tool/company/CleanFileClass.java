
package org.csu.electriccommerce.tool.company;

import java.io.*;

public class CleanFileClass {
    public static void Clean(String wordIn, String wordOut) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        File fileOut = new File(wordOut);
        InputStreamReader inStream = new InputStreamReader(new FileInputStream(new File(wordIn)), "GBK");//读取文件
        OutputStreamWriter outStream = new OutputStreamWriter(new FileOutputStream(new File(wordOut)), "utf-8");
        BufferedReader bf = new BufferedReader(inStream);
        BufferedWriter bw = new BufferedWriter(outStream);
        String valueString = null;
        char c[];
        int sign = -1;
        while ((valueString=bf.readLine())!=null){
            c = valueString.toCharArray(); 
            for(int i = 0; i < valueString.length(); i++) { //只保留下关键字
                if(c[i] == '[') {
                     sign = 1;
                     i++;
                }
                if(c[i] == ']') sign = -1;
                if(sign == 1) {
                    //System.out.print(c[i]);
                    bw.append(c[i]);
                }
            }
            //System.out.println();
            bw.newLine();

        }
        bw.close();
        //ps.close();
    }
}
