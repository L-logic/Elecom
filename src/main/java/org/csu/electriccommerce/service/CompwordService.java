package org.csu.electriccommerce.service;

import org.csu.electriccommerce.entity.CompwordSet;
import org.csu.electriccommerce.persistence.CompwordMapper;
import org.csu.electriccommerce.persistence.MidDataMapper;
import org.csu.electriccommerce.tool.datafile.PathClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CompwordService {

    @Autowired
    private CompwordMapper compwordMapper;

    @Autowired
    private MidDataMapper midDataMapper;

    public List<CompwordSet> getCompSetList(String keyword){
        return compwordMapper.getSetList(keyword);
    }

    public CompwordSet getCompSetById(int id){
        return compwordMapper.getSetById(id);

    }

    public CompwordSet getCompSet(String keyword, String compword){
        return compwordMapper.getSetByKeyAndComp(keyword,compword);
    }

    public void insertCompSet(CompwordSet compwordSet){
        compwordMapper.insertCompwordSet(compwordSet);
    }

    public void insertCompSet(String Keyword,String midkey,String compkey,String compPower){
        CompwordSet compwordSet = new CompwordSet();
        compwordSet.setKeyword(Keyword);
        compwordSet.setMidkey(midkey);
        compwordSet.setCompkey(compkey);
        compwordSet.setCompPower(Double.valueOf(compPower));
        compwordMapper.insertCompwordSet(compwordSet);
    }

    public void updateCompSet(CompwordSet compwordSet){
        compwordMapper.updateCompwordSet(compwordSet);
    }

    public List<String> getAllKeyword(){
        return compwordMapper.getKeywordList();
    }

    public void fileToDB(String fileName){
        //取出数据
        BufferedReader bufferedReader = null;
        //为保存的数组分配空间
        String[] datas = new String[3];
        try {

            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File(fileName)));
            bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            String keyword = null;
            int i=0;
            //按行读取
            while((line = bufferedReader.readLine() )!= null){
                if(i == 0) {
                    String[] strings = line.split(" ");
                    keyword = strings[0];
                    keyword = keyword.substring(1,keyword.length()-1);
                }
                if((null != line && i>2)){
//                    System.out.println(line);
                    //将按行读取的字符串按空格分割，得到一个string数组
                    String[] strings = line.split("\\t");
                    //依次转换为int类型存入到分配好空间的数组中
                    for(int k = 0;k<strings.length;k++){
                        datas[k] = strings[k];
//                        System.out.println(datas[k]);
                    }
                    insertCompSet(keyword,datas[0],datas[1],datas[2]);
                }
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
