package org.csu.electriccommerce.tool.datafile;

import java.io.*;

public class pretreatment {
    static String head = "E:\\entertainment\\关于学习\\学习使我快乐\\大三上\\电子商务\\实验数据\\新分词\\";
    static String head1 = "E:\\entertainment\\关于学习\\学习使我快乐\\大三上\\电子商务\\电子商务与电子政务实验数据\\搜狗比赛数据\\";
    static String tail = ".TRAIN";
    /**
     *数据清洗
     **/
    public static void transferFile(String srcFileName, String targetFileName) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(srcFileName), "GBK"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetFileName), "utf-8"));

        String line = null;
        String[] value;
        while ((line = br.readLine()) != null){
            line = line.substring(39);
            value = line.split("\t");
            for(int i = 0; i < value.length; i++) {
                    bw.append(value[i]);
                    bw.newLine();
            }
        }
        br.close();
        bw.close();
        System.out.println("转换完毕");
    }
    /**
     *生成全部包含有种子关键字的搜索信息的文件
     **/
    public static void matchkeywords(String srcFileName,String keyword) throws IOException {
        String line = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(srcFileName)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(head+keyword+tail),"utf-8"));
        while ((line = br.readLine()) != null) {
            if(line.contains(keyword)){
                bw.append(line+"\n");
            }
        }
        bw.flush();
        br.close();
        System.out.println("生成文件完毕");
    }

    public static void pretreatment(String keyword)throws FileNotFoundException, UnsupportedEncodingException, IOException, Exception  {
        transferFile(head1+"user_tag_query.10W"+tail,head+"cleaned"+tail);
        matchkeywords(head1+"cleaned"+tail,keyword);
        WordFrequency a = new WordFrequency();
        a.wordCutandFrequencies(head + keyword+tail,head + keyword + "frequencis.txt");
    }
}
