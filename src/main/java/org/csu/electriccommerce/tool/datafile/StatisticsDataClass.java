
package org.csu.electriccommerce.tool.datafile;

import org.apdplat.word.WordFrequencyStatistics;
import org.apdplat.word.segmentation.SegmentationAlgorithm;

import java.io.File;
import java.io.PrintStream;

public class StatisticsDataClass {

    public static void statistic(String wordOut, String wordApart, String wordStatistics) throws Exception {
        //词频统计设置
        PathClass pa = new PathClass();
        PrintStream ps = new PrintStream(pa.log);/*过滤屏幕信息*/
        PrintStream out = System.out;
        System.setOut(ps);
        WordFrequencyStatistics wordFrequencyStatistics = new WordFrequencyStatistics();
        wordFrequencyStatistics.setRemoveStopWord(true);//去掉虚词和一般的连词
        wordFrequencyStatistics.setResultPath(wordStatistics);
        wordFrequencyStatistics.setSegmentationAlgorithm(SegmentationAlgorithm.MaxNgramScore);
        wordFrequencyStatistics.seg(new File(wordOut), new File(wordApart));
        wordFrequencyStatistics.dump();//输出词频统计结果
        System.setOut(out);

    }
}
