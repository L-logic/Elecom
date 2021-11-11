package org.csu.electriccommerce.tool.compkey;

import org.csu.electriccommerce.entity.Keyword;
import org.csu.electriccommerce.service.MidDataService;
import org.csu.electriccommerce.tool.datafile.MainDataClass;
import org.csu.electriccommerce.tool.datafile.PathClass;
import org.csu.electriccommerce.tool.datafile.StatisticsDataClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@Component
public class AlgorithmWithDB {


    private static MidDataService midDataService;

    @Autowired
    public void setMidDataService(MidDataService midDataService){
        AlgorithmWithDB.midDataService = midDataService;
    }

    public static void algorithm(Keyword wordKeyTemp, int num) throws UnsupportedEncodingException, IOException, Exception{
        //new pretreatment().pretreatment(wordKeyTemp.getWordKey()); //已完成从原数据中提取出与种子关键字相关的搜索信息
        /**
         * 1(1.1 wordApart;1.2 frequencis)
         */
        new MainDataClass().data(wordKeyTemp.getKeyword());

        midDataService.insertWordApart(wordKeyTemp.getKeyword());
        midDataService.insertFrequencis(wordKeyTemp.getKeyword());

        PathClass pa = new PathClass();
        InputStreamReader inStream = new InputStreamReader(new FileInputStream(pa.wordNewPath+wordKeyTemp.getKeyword()+"frequencis.txt"), StandardCharsets.UTF_8);
        BufferedReader bf = new BufferedReader(inStream);

        System.out.println(pa.wordNewPath + wordKeyTemp.getKeyword()+"frequencis.txt");

        /**
         * 2 midKeyword
         */
        OutputStreamWriter outStream = new OutputStreamWriter(new FileOutputStream(pa.wordNewPath+wordKeyTemp.getKeyword()+"midKeyword.txt"), StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(outStream);

        int count = 0;
        String word = null;
        ArrayList<String> midwordList = new ArrayList<>();
        while ((word = bf.readLine()) != null) {
            int equel = word.indexOf(" ");
            word = word.substring(0, equel); //过滤词频文件中，单字词语、首位为数字的词和种子关键字
            if(equel <= 1 || word.contains(wordKeyTemp.getKeyword()) || (word.charAt(0) >= '0' && word.charAt(0) <= '9')) { //过滤掉一个字的中介关键词和种子关键字
                continue;
            } else {
                count++;
                midwordList.add(word);
                bw.write(word);
                bw.newLine();
            }
            if (count == num) {
                break;
            }
        }
        bw.close();
        wordKeyTemp.setMidkey(midwordList);
        System.out.println(wordKeyTemp.getMidkey());

        midDataService.insertMidKeyword(wordKeyTemp.getKeyword());

        InputStreamReader inStream1 = new InputStreamReader(new FileInputStream(pa.wordOut), StandardCharsets.UTF_8);
        BufferedReader bf1 = new BufferedReader(inStream1);
        /**
         *  3 midrelated
         */
        OutputStreamWriter outStream1 = new OutputStreamWriter(new FileOutputStream(pa.wordNewPath + wordKeyTemp.getKeyword()+"midRelated.txt"), StandardCharsets.UTF_8);
        BufferedWriter bw1 = new BufferedWriter(outStream1);

        String related = null;
        while((related = bf1.readLine()) != null){
            //遍历所有中介关键字
            for (int i = 0; i < wordKeyTemp.getMidkey().size(); i++) {
                // 如果包含中介关键字,直接退出，并记录该行
                if (related.contains(wordKeyTemp.getMidkey().get(i))){
                    bw1.write(related);
                    bw1.newLine();
                    break;
                }
            }
        }
        bw1.close();

        midDataService.insertMidRelated(wordKeyTemp.getKeyword());

        //new WordFrequency().wordCutandFrequencies(pa.wordNewPath + wordKeyTemp.getWordKey()+"midRelated.txt",pa.wordNewPath+wordKeyTemp.getWordKey()+"compFrequencis.txt");
        /**
         * 4.1 compApart ;4.2 comeFrequencis
         */
        new StatisticsDataClass().statistic(pa.wordNewPath + wordKeyTemp.getKeyword()+"midRelated.txt",pa.wordNewPath+wordKeyTemp.getKeyword()+"compApart.txt",pa.wordNewPath+wordKeyTemp.getKeyword()+"compFrequencis.txt");

        midDataService.insertCompApart(wordKeyTemp.getKeyword());
        midDataService.insertCompFrequencis(wordKeyTemp.getKeyword());

        InputStreamReader inStream3 = new InputStreamReader(new FileInputStream(pa.wordNewPath+wordKeyTemp.getKeyword()+"compFrequencis.txt"), StandardCharsets.UTF_8);
        BufferedReader bf3 = new BufferedReader(inStream3);


        int temp = 0;
        String compWord = null;
        ArrayList<String> compwordList = new ArrayList<>();
        while ((compWord = bf3.readLine()) != null) {
            int equel = compWord.indexOf(" ");
            compWord = compWord.substring(0, equel);
            //过滤词频文件中，单字词语、首位为数字的词和种子关键字
            if(equel <= 1 || compWord.contains(wordKeyTemp.getKeyword()) || (compWord.charAt(0) >= '0' && compWord.charAt(0) <= '9')) { //过滤掉一个字的中介关键词和种子关键字
                continue;
            } //排除中介关键字
            else if(wordKeyTemp.getMidkey().indexOf(compWord) != -1){
                continue;
            } else {
                temp++;
                compwordList.add(compWord);

            }
            if (temp == num) {
                break;
            }
        }

        wordKeyTemp.setCompkey(compwordList);
        // System.out.println(wordKeyTemp.getCompkey());


        int a = 0; //所有含中介关键词的搜索量
        int ka = 0; //同时包含关键字和中介关键字的搜索量
        int sa = 0; //同时包含竞争关键字和中介关键字的搜索量

        //计算竞争度
        String value = null;
        //每个种子关键字对应 num 个竞争关键字
        ArrayList<Double> CompPowerList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            InputStreamReader inStream4 = new InputStreamReader(new FileInputStream(new File(pa.wordOut)), StandardCharsets.UTF_8);//读取文件
            BufferedReader bf4 = new BufferedReader(inStream4);
            while ((value = bf4.readLine()) != null) {  //与种子关键字相关的搜索信息
                if (value.contains(wordKeyTemp.getMidkey().get(i))) { //包含中介关键字
                    a++;
                }
                if (value.contains(wordKeyTemp.getMidkey().get(i)) && value.contains(wordKeyTemp.getKeyword()) && !value.contains(wordKeyTemp.getCompkey().get(i))) {
                    ka++;
                }
                if (value.contains(wordKeyTemp.getMidkey().get(i)) && value.contains(wordKeyTemp.getCompkey().get(i)) && !value.contains(wordKeyTemp.getKeyword())) {
                    sa++;
                }
            }
            double result;
            if(a - sa == 0) {
                result = -1;
                CompPowerList.add(result);
            } else {
                result = (double)ka / (double)(a - sa);
                CompPowerList.add(result);
            }
            a = 0;
            ka = 0;
            sa = 0;
        }
        wordKeyTemp.setCompPower(CompPowerList);
        System.out.println(wordKeyTemp.getCompPower());

        //输出最终结果
        PrintStream out = System.out;
        String Result = pa.wordResult + wordKeyTemp.getKeyword() + pa.txt;
        PrintStream ps1 = new PrintStream(Result);/*保存屏幕信息*/
        System.setOut(ps1);
        System.out.println("[" + wordKeyTemp.getKeyword() + "] 对应竞争性关键字的竞争度排序如下：");
        System.out.println();
        System.out.printf("%-20s%-20s%-20s","中介关键字","竞争关键字","竞争度");
        System.out.println();
        Double t;
        String x,y;
        //排序
        for(int i = 0; i < num - 1; i++) {
            for(int j = 0; j < num - i - 1; j++) {
                if(wordKeyTemp.getCompPower().get(j) < wordKeyTemp.getCompPower().get(j+1)) {
                    //替换竞争度
                    t = wordKeyTemp.getCompPower().get(j);
                    wordKeyTemp.getCompPower().set(j,wordKeyTemp.getCompPower().get(j+1));
                    wordKeyTemp.getCompPower().set(j+1,t);
                    //替换中介关键字
                    x = wordKeyTemp.getMidkey().get(j);
                    wordKeyTemp.getMidkey().set(j,wordKeyTemp.getMidkey().get(j+1));
                    wordKeyTemp.getMidkey().set(j+1,x);
                    //替换竞争关键字
                    y = wordKeyTemp.getCompkey().get(j);
                    wordKeyTemp.getCompkey().set(j,wordKeyTemp.getCompkey().get(j+1));
                    wordKeyTemp.getCompkey().set(j+1,y);
                }
            }
        }
        for(int i = 0; i < num; i++) {
//            System.out.printf("%7s%27s%25s", wordKeyTemp.getMidkey().get(i) , wordKeyTemp.getCompkey().get(i) , String.format("%.16f", wordKeyTemp.getCompPoint().get(i)));
//            System.out.println();

            System.out.println( wordKeyTemp.getMidkey().get(i) + "\t" + wordKeyTemp.getCompkey().get(i) + "\t" + String.format("%.16f", wordKeyTemp.getCompPower().get(i)));
        }
        System.setOut(out);
    }

}
