package org.csu.electriccommerce.service;

import org.csu.electriccommerce.persistence.MidDataMapper;
import org.csu.electriccommerce.tool.datafile.PathClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

@Service
public class MidDataService {

    @Autowired
    MidDataMapper midDataMapper;


    public void insertMidRelated(String keyword){
        midDataMapper.deleteMidRelated();
        midFileToDB(keyword,"midRelated");

    }

    public void insertWordApart(String keyword){
        midDataMapper.deleteWordApart();
        midFileToDB(keyword,"wordApart");

    }

    public void insertFrequencis(String keyword){
        midDataMapper.deleteFrequencis();
        midFileToDB(keyword,"frequencis");
    }

    public void insertMidKeyword(String keyword){
        if(midDataMapper.selectMidKeyword(keyword)!= null)
            midDataMapper.deleteMidKeyword(keyword);
        //取出数据
        BufferedReader bufferedReader = null;
        //为保存的数组分配空间
        String[] datas = new String[10];

        for(int j = 0 ; j < datas.length ; j++){
            datas[j] = "";
        }

        try {

            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File(new PathClass().wordNewPath +keyword+"midKeyword.txt")));
            bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            int i=0;
            //按行读取
            while((line = bufferedReader.readLine() )!= null){
                if((null != line)){
                    datas[i] = line;
                }
                i++;
            }
            midDataMapper.insertMidKeyword(keyword,datas[0],datas[1],datas[2],datas[3],datas[4],datas[5],datas[6],datas[7],datas[8],datas[9]);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void insertCompApart(String keyword){
        midDataMapper.deleteCompApart();
        midFileToDB(keyword,"compApart");
    }

    public void insertCompFrequencis(String keyword){
        midDataMapper.deleteCompFrequencis();
        midFileToDB(keyword,"compFrequencis");
    }

    public void midFileToDB(String keyword,String choose){
        //取出数据
        BufferedReader bufferedReader = null;
        //为保存的数组分配空间
        String[] datas = new String[15];

        try {

            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File(new PathClass().wordNewPath +keyword+choose+".txt")));
            bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            int i=0;
            //按行读取
            while((line = bufferedReader.readLine() )!= null){
                if((null != line)){

                    for(int j = 0 ; j < datas.length ; j++){
                        datas[j] = "";
                    }
//                    System.out.println(line);
                    //将按行读取的字符串按空格分割，得到一个string数组
                    String[] strings = line.split(" ");
                    //依次转换为int类型存入到分配好空间的数组中
                    for(int k = 0;k<strings.length;k++){
                        datas[k] = strings[k];
//                        System.out.println(datas[k]);
                    }
                    switch (choose){
                        //种子分词
                        case "wordApart":
                            midDataMapper.insertWordApart(datas[0],datas[1],datas[2],datas[3],datas[4],datas[5],datas[6],datas[7]);
                            break;
                        //中介词频
                        case "frequencis":
                            midDataMapper.insertFrequencis(datas[0],Integer.valueOf(datas[1]));
                            break;
                        //种子相关
                        case "midRelated":
                            midDataMapper.insertMidRelated(datas[0]);
                            break;
                        //中介分词
                        case "compApart":
                            midDataMapper.insertCompApart(datas[0],datas[1],datas[2],datas[3],datas[4],datas[5],datas[6],datas[7]);
                            break;
                        //comp词频
                        case "compFrequencis":
                            midDataMapper.insertCompFrequencis(datas[0],Integer.valueOf(datas[1]));

                    }

                }
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertMidData(String keyword){
        insertWordApart(keyword);
        insertFrequencis(keyword);
        insertMidKeyword(keyword);
        insertMidRelated(keyword);
        insertCompApart(keyword);
        insertCompFrequencis(keyword);
    }

}
