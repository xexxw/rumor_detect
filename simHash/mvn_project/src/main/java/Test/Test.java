package Test;
import  SimHash.SimHash;
//import nlp.crf_segmentor.NLPTagClient;
import java.io.IOException;

/**
 * Created by danjunwei_sx on 2017/11/15.
 */
public class Test {

    public static void main(String[] args) throws IOException {
        CountHaiming2();
    }

    // 测试 NLP 客户端
    public  static  void  Test(){}

    // 运用SimHash 并计算海明距离
    public  static  void  CountHaiming2() throws IOException
    {
        long t_start = System.currentTimeMillis();
        String s = "老公当兵时有个外号叫二球，昨晚我追起问他二球到底啥意思？他不温不火的来一句：二球就是250！。。。。。。";
        s = s.replaceAll("[\\pP‘’“”]", "");
        SimHash hash1 = new SimHash(s, 64);  //System.out.println(hash1.intSimHash + "  " + hash1.intSimHash.bitLength());
        // 计算 海明距离 在 3 以内的各块签名的 hash 值
        hash1.subByDistance(hash1, 3);
        // 删除首句话，并加入两个干扰串
        s = "老公当兵时有个.外号叫二球，昨晚我.追起m问他二球到底啥意思？他k不温,不火的来一句：二球就是250！。。。。。。";
        s = s.replaceAll("[\\pP‘’“”]", "");
        SimHash hash2 = new SimHash(s, 64);
        // System.out.println(hash2.intSimHash + "  " + hash2.intSimHash.bitCount());
        hash1.subByDistance(hash2, 3);
        // 根据鸽巢原理（也成抽屉原理，见组合数学），如果两个签名的海明距离在 3 以内，它们必有一块签名subByDistance()完全相同。
        int dis = hash1.getDistance(hash1.strSimHash, hash2.strSimHash);
        System.out.println(hash1.hammingDistance(hash2) + " " + dis);
        long t_end = System.currentTimeMillis();
        System.out.println("比较处理时间:"+(t_end-t_start)+ "ms");
    }


    // 运用SimHash 并计算海明距离
    public  static  void  CountHaiming() throws IOException
    {
        String s = "传统的 hash 算法只负责将原始内容尽量均匀随机地映射为一个签名值，"
                + "原理上相当于伪随机数产生算法。产生的两个签名，如果相等，说明原始内容在一定概 率 下是相等的；"
                + "如果不相等，除了说明原始内容不相等外，不再提供任何信息，因为即使原始内容只相差一个字节，"
                + "所产生的签名也很可能差别极大。从这个意义 上来 说，要设计一个 hash 算法，"
                + "对相似的内容产生的签名也相近，是更为艰难的任务，因为它的签名值除了提供原始内容是否相等的信息外，"
                + "还能额外提供不相等的 原始内容的差异程度的信息。";
        SimHash hash1 = new SimHash(s, 64);
        //System.out.println(hash1.intSimHash + "  " + hash1.intSimHash.bitLength());
        // 计算 海明距离 在 3 以内的各块签名的 hash 值
        hash1.subByDistance(hash1, 3);

        // 删除首句话，并加入两个干扰串
        s = "原理上相当于伪随机数产生算法。产生的两个签名，如果相等，说明原始内容在一定概 率 下是相等的；"
                + "如果不相等，除了说明原始内容不相等外，不再提供任何信息，因为即使原始内容只相差一个字节，"
                + "所产生的签名也很可能差别极大。从这个意义 上来 说，要设计一个 hash 算法，"
                + "对相似的内容产生的签名也相近，是更为艰难的任务，因为它的签名值除了提供原始内容是否相等的信息外，"
                + "干扰1还能额外提供不相等的 原始内容的差异程度的信息。";
        SimHash hash2 = new SimHash(s, 64);
        // System.out.println(hash2.intSimHash + "  " + hash2.intSimHash.bitCount());
        hash1.subByDistance(hash2, 3);

        // 首句前添加一句话，并加入四个干扰串
        s = "imhash算法的输入是一个向量，输出是一个 f 位的签名值。为了陈述方便，"
                + "假设输入的是一个文档的特征集合，每个特征有一定的权重。"
                + "传统干扰4的 hash 算法只负责将原始内容尽量均匀随机地映射为一个签名值，"
                + "原理上这次差异有多大呢3相当于伪随机数产生算法。产生的两个签名，如果相等，"
                + "说明原始内容在一定概 率 下是相等的；如果不相等，除了说明原始内容不相等外，不再提供任何信息，"
                + "因为即使原始内容只相差一个字节，所产生的签名也很可能差别极大。从这个意义 上来 说，"
                + "要设计一个 hash 算法，对相似的内容产生的签名也相近，是更为艰难的任务，因为它的签名值除了提供原始"
                + "内容是否相等的信息外，干扰1还能额外提供不相等的 原始再来干扰2内容的差异程度的信息。";
        SimHash hash3 = new SimHash(s, 64);
        //System.out.println(hash3.intSimHash + "  " + hash3.intSimHash.bitCount());
        hash1.subByDistance(hash3, 3);

        int dis = hash1.getDistance(hash1.strSimHash, hash2.strSimHash);
        System.out.println(hash1.hammingDistance(hash2) + " " + dis);
        // 根据鸽巢原理（也成抽屉原理，见组合数学），如果两个签名的海明距离在 3 以内，它们必有一块签名subByDistance()完全相同。
        int dis2 = hash1.getDistance(hash1.strSimHash, hash3.strSimHash);
        System.out.println(hash1.hammingDistance(hash3) + " " + dis2);
    }




}
