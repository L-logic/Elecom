
package org.csu.electriccommerce.tool.datafile;

public class PathClass {
//    public String wordIn = "E:\\entertainment\\关于学习\\学习使我快乐\\大三上\\电子商务\\电子商务与电子政务实验数据\\搜狗搜索日志\\SogouQ.reduced";
//    /*wordIn文件格式：00:00:00	2982199073774412	[360安全卫士]	8 3	download.it.com.cn/softweb/software/firewall/antivirus/20067/17938.html*/
//    public String wordInNew = "E:\\entertainment\\关于学习\\学习使我快乐\\大三上\\电子商务\\电子商务与电子政务实验数据\\搜狗比赛数据\\user_tag_query.10W.TRAIN";
//    /*wordInNew文件格式：00627779E16E7C09B975B2CE13C088CB     4     2     0     钢琴曲欣赏100首     一个月的宝宝眼睫毛那么是黄色     宝宝右眼有眼屎    小儿抽搐怎么办    剖腹产后刀口上有线头    属羊和属鸡的配吗 */
//    public String wordOut = "E:\\entertainment\\关于学习\\学习使我快乐\\大三上\\电子商务\\实验数据\\所有搜索词.txt"; /*所有的搜索关键字*/
//    public String wordRelated = "E:\\entertainment\\关于学习\\学习使我快乐\\大三上\\电子商务\\实验数据\\种子关键字相关短句.txt";/*与指定关键字有关的信息*/
//    public String wordApart = "E:\\entertainment\\关于学习\\学习使我快乐\\大三上\\电子商务\\实验数据\\种子关键字相关短句分词.txt";/*相关信息分词结果*/
//    public String wordStatistics = "E:\\entertainment\\关于学习\\学习使我快乐\\大三上\\电子商务\\实验数据\\词频.txt";/*相关信息词频统计*/
//
//    public String wordNewPath = "E:\\entertainment\\关于学习\\学习使我快乐\\大三上\\电子商务\\实验数据\\新分词\\";/*相关信息词频统计*/
//
//    public String wordMidKey = "E:\\entertainment\\关于学习\\学习使我快乐\\大三上\\电子商务\\实验数据\\中介关键字.txt";/*中介关键词*/
//
//    public String wordTempKey = "E:\\entertainment\\关于学习\\学习使我快乐\\大三上\\电子商务\\实验数据\\临时中介关键字短句.txt";/*临时文件*/
//    public String wordTempApart = "E:\\entertainment\\关于学习\\学习使我快乐\\大三上\\电子商务\\实验数据\\临时中介关键字短句分词.txt";/*临时文件*/
//    public String wordTempStatistics = "E:\\entertainment\\关于学习\\学习使我快乐\\大三上\\电子商务\\实验数据\\临时词频.txt";/*临时文件*/
//
//    public String wordResult = "E:\\entertainment\\关于学习\\学习使我快乐\\大三上\\电子商务\\实验数据\\新结果\\";/*结果文件*/
//    public String txt = ".txt";
//    public String log = "E:\\entertainment\\关于学习\\学习使我快乐\\大三上\\电子商务\\实验数据\\屏幕分词信息.txt";/*过滤屏幕分词信息*/
    static String head1 = "E:\\1319910840\\FileRecv\\电子商务\\电子商务与电子政务实验数据\\搜狗比赛数据\\";
    static String head2 = "E:\\1319910840\\FileRecv\\电子商务\\电子商务与电子政务实验数据\\实验数据\\";
    public String wordIn = head1+"SogouQ.reduced";
    /*wordIn文件格式：00:00:00	2982199073774412	[360安全卫士]	8 3	download.it.com.cn/softweb/software/firewall/antivirus/20067/17938.html*/
    public String wordInNew = head1+"user_tag_query.10W.TRAIN";
    /*wordInNew文件格式：00627779E16E7C09B975B2CE13C088CB     4     2     0     钢琴曲欣赏100首     一个月的宝宝眼睫毛那么是黄色     宝宝右眼有眼屎    小儿抽搐怎么办    剖腹产后刀口上有线头    属羊和属鸡的配吗 */
    public String wordOut = head2+"所有搜索词.txt"; /*所有的搜索关键字*/
    public String wordRelated =head2+ "种子关键字相关短句.txt";/*与指定关键字有关的信息*/
    public String wordApart = head2+"种子关键字相关短句分词.txt";/*相关信息分词结果*/
    public String wordStatistics = head2+"词频.txt";/*相关信息词频统计*/
    public String wordNewPath = head2+"新分词\\";/*相关信息词频统计*/
    public String wordMidKey = head2+" 中介关键字.txt";/*中介关键词*/

    public String wordTempKey = head2+" wordTempKey.txt";/*临时文件*/
    public String wordTempApart = head2+" wordTempApart.txt";/*临时文件*/
    public String wordTempStatistics =head2+ " wordTempStatistics.txt";/*临时文件*/

    public String wordResult = head2+"新结果\\ ";/*结果文件*/
    public String txt =".txt";
    public String log =head2+ "屏幕分词信息.txt";/*过滤屏幕分词信息*/

}
