package org.csu.electriccommerce.tool.datafile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.*;
import java.util.*;

public class WordFrequency {
    private Map<String, Integer> count(Map<String, Integer> frequencies, String content) throws IOException{

        if (frequencies == null) {
            frequencies = new HashMap<>();
        }
        if(StringUtils.isBlank(content)){
            return frequencies;
        }

        File file1 = new File("E:\\entertainment\\关于学习\\学习使我快乐\\大三上\\电子商务\\ElectronicCommerce\\src\\main\\java\\org\\csu\\stopWords.txt");
        List<String> stopword= FileUtils.readLines(file1,"utf8");
        IKSegmenter ikSegmenter = new IKSegmenter(new StringReader(content), true);

        Lexeme lexeme;
        while ((lexeme = ikSegmenter.next()) != null) {
            final String text = lexeme.getLexemeText();

            if(text.length() > 1) {
                //递增
                if(stopword.contains(text))
                    continue;
                if (frequencies.containsKey(text)) {
                    frequencies.put(text, frequencies.get(text) + 1);
                } else {//首次出现
                    frequencies.put(text, 1);
                }
            }
        }
        return frequencies;
    }
    /**
     * 按出现次数，从高到低排序
     *
     * @param data
     * @return
     */
    private List<Map.Entry<String, Integer>> order(Map<String, Integer> data) {
        List<Map.Entry<String, Integer>> result = new ArrayList<>(data.entrySet());
        Collections.sort(result, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        return result;
    }

    public void wordCutandFrequencies(String relatefile, String frequencyfile)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(relatefile)));
        String line = null;
        Map hm = new HashMap<String, Integer>();
        while((line = br.readLine())!=null){
           hm = count( hm, line);
        }
        br.close();

        List<Map.Entry<String, Integer>> result = order(hm);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(frequencyfile)));

        for(int i = 0; i < result.size(); i++){
            String data = String.valueOf(result.get(i));
            bw.append(data);
            bw.newLine();
        }
        bw.close();
    }

}
