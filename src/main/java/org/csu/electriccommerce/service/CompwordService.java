package org.csu.electriccommerce.service;

import org.csu.electriccommerce.entity.CompwordSet;
import org.csu.electriccommerce.persistence.CompwordMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CompwordService {

    @Autowired
    private CompwordMapper compwordMapper;

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

    public void updateCompSet(CompwordSet compwordSet){
        compwordMapper.updateCompwordSet(compwordSet);
    }

    public List<String> getAllKeyword(){
        return compwordMapper.getKeywordList();
    }

    public void fileToDB(String fileName){
//        //取出数据
//        BufferedReader bufferedReader = null;
//        //为保存的数组分配空间
//        String[][] datas = new String[4][10];
//        try {
//
//            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File(fileName)));
//            bufferedReader = new BufferedReader(inputStreamReader);
//            String line = null;
//            int i=0;
//            //按行读取
//            while((line = bufferedReader.readLine() )!= null){
//                if(null != line){
//                    //将按行读取的字符串按空格分割，得到一个string数组
//                    String[] strings = line.split("\\t");
//                    //依次转换为int类型存入到分配好空间的数组中
//                    for(int k = 0;k<strings.length;k++){
//                        datas[i][k] = Integer.valueOf(strings[k]);
//                        System.out.println(datas[i][k]);
//                    }
//                    //行数加1
//                    i++;
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //存入db

    }
}
