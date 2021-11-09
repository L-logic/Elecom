package org.csu.electriccommerce.tool.compkey;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class DrawPicture {

        public static void main(String[] args) {
//        public static void drawPicture() {

            int runTime [][] = getSparseArrayFromFile();

            DefaultCategoryDataset ds = new DefaultCategoryDataset();

            for(int i = 0;i <5 ;i++){
                String rowKey = i*2+2+"个关键词";
                for(int j = 0;j<6;j++){
                    String columnKey = j*5+5+"M";
                    ds.setValue(runTime[i][j], rowKey, columnKey);

                }
            }

            String filePath1 = "E:\\entertainment\\关于学习\\学习使我快乐\\大三上\\电子商务\\小组成员\\evaluate.jpg";


            File file = new File(filePath1);		//创建指定文件
            if(file.exists()){
                file.delete();				//如果指定文件不存在，新建文件

            }

            createLineChart(ds,filePath1);
        }

        public static void createLineChart(DefaultCategoryDataset ds, String filePath) {
            try {
                // 创建柱状图.标题,X坐标,Y坐标,数据集合,orientation,是否显示legend,是否显示tooltip,是否使用url链接
                JFreeChart chart = ChartFactory.createLineChart("算法运算效率", "数据大小（M）", "运行时间（ms）", ds, PlotOrientation.VERTICAL,false, true, true);
                chart.setBackgroundPaint(Color.WHITE);
                Font font = new Font("宋体", Font.BOLD, 12);
                chart.getTitle().setFont(font);
                chart.setBackgroundPaint(Color.WHITE);
                // 配置字体（解决中文乱码的通用方法）
                Font xfont = new Font("仿宋", Font.BOLD, 12); // X轴
                Font yfont = new Font("宋体", Font.BOLD, 12); // Y轴
                Font titleFont = new Font("宋体", Font.BOLD, 12); // 图片标题
                CategoryPlot categoryPlot = chart.getCategoryPlot();
                categoryPlot.getDomainAxis().setLabelFont(xfont);
                categoryPlot.getDomainAxis().setLabelFont(xfont);
                categoryPlot.getRangeAxis().setLabelFont(yfont);
                chart.getTitle().setFont(titleFont);
                categoryPlot.setBackgroundPaint(Color.WHITE);
                // x轴 // 分类轴网格是否可见
                categoryPlot.setDomainGridlinesVisible(true);
                // y轴 //数据轴网格是否可见
                categoryPlot.setRangeGridlinesVisible(true);
                // 设置网格竖线颜色
                categoryPlot.setDomainGridlinePaint(Color.LIGHT_GRAY);
                // 设置网格横线颜色
                categoryPlot.setRangeGridlinePaint(Color.LIGHT_GRAY);
                // 没有数据时显示的文字说明
                categoryPlot.setNoDataMessage("没有数据显示");
                // 设置曲线图与xy轴的距离
                categoryPlot.setAxisOffset(new RectangleInsets(0d, 0d, 0d, 0d));
                // 设置面板字体
                Font labelFont = new Font("SansSerif", Font.TRUETYPE_FONT, 12);
                // 取得Y轴
                NumberAxis rangeAxis = (NumberAxis) categoryPlot.getRangeAxis();
                rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
                rangeAxis.setAutoRangeIncludesZero(true);
                rangeAxis.setUpperMargin(0.20);
                rangeAxis.setLabelAngle(Math.PI / 2.0);
                // 取得X轴
                CategoryAxis categoryAxis = (CategoryAxis) categoryPlot.getDomainAxis();
                // 设置X轴坐标上的文字
                categoryAxis.setTickLabelFont(labelFont);
                // 设置X轴的标题文字
                categoryAxis.setLabelFont(labelFont);
                // 横轴上的 Lable 45度倾斜
                categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
                // 设置距离图片左端距离
                categoryAxis.setLowerMargin(0.0);
                // 设置距离图片右端距离
                categoryAxis.setUpperMargin(0.0);
                // 获得renderer 注意这里是下嗍造型到lineandshaperenderer！！
                LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryPlot.getRenderer();
                // 是否显示折点
                lineandshaperenderer.setBaseShapesVisible(true);
                // 是否显示折线
                lineandshaperenderer.setBaseLinesVisible(true);
                // series 点（即数据点）间有连线可见 显示折点数据
                lineandshaperenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
                lineandshaperenderer.setBaseItemLabelsVisible(true);
                ChartUtilities.saveChartAsJPEG(new File(filePath), chart, 1207, 500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    private static int[][] getSparseArrayFromFile(){
        //将稀疏矩阵从文件中读取出来
        BufferedReader bufferedReader = null;
        //为保存的数组分配空间
        int[][] datas = new int[5][6];;
        try {

            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File("E:\\IDEA\\e_commerce\\ecData\\temp.txt")));
            bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            int i=0;
            //按行读取
            while((line = bufferedReader.readLine() )!= null){
                if(null != line){
                    //将按行读取的字符串按空格分割，得到一个string数组
                    String[] strings = line.split("\\t");
                    //依次转换为int类型存入到分配好空间的数组中
                    for(int k = 0;k<strings.length;k++){
                        datas[i][k] = Integer.valueOf(strings[k]);
                        System.out.println(datas[i][k]);
                    }
                    //行数加1
                    i++;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回读取的二维数组
        return datas;
    }


}
