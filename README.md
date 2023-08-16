# 微博谣言检测

基于循环神经网络（LSTM/GRU）的谣言检测模型


## 数据集

https://github.com/thunlp/Chinese_Rumor_Dataset

### ./rumors_v170613.json

数据集共包含从2009年9月4日至2017年6月12日的31669条谣言。文件中，每一行为一条json格式的谣言数据，字段释义如下：

* **rumorCode**: 该条谣言的唯一编码，可以通过该编码直接访问该谣言举报页面。
* **title**: 该条谣言被举报的标题内容
* **informerName**: 举报者微博名称
* **informerUrl**: 举报者微博链接
* **rumormongerName**: 发布谣言者的微博名称
* **rumormongerUr**: 发布谣言者的微博链接
* **rumorText**: 谣言内容
* **visitTimes**: 该谣言被访问次数
* **result**: 该谣言审查结果
* **publishTime**: 该谣言被举报时间

### CED_Dataset

包含与微博原文相关的转发与评论信息，数据集中共包含**谣言1538条和非谣言1849条**。该数据集分为微博原文与其转发/评论内容。

* original-microblog文件夹：所有微博原文（包含谣言与非谣言）；
* non-rumor-repost和rumor-repost文件夹：分别包含非谣言原文与谣言原文的对应的转发与评论信息。（该数据集中并不区分评论与转发）

该数据文件中，每条原文，评论或评论均为json格式的数据，部分字段释义如下：

* 微博原文信息：
  *  **text**: 微博原文的文字内容
  *  **user**: 发布该条微博原文的用户信息
  *  **time**: 用户发布该条微博原文的时间（时间戳格式）
* 转发/评论信息：
  *  **uid**:  发布该转发/评论的用户ID
  *  **text**: 转发/评论的文字内容（若部分用户转发时不添加评论内容，该项无内容）
  *  **data**: 该转发/评论的发布时间（格式如：2014-07-24 14:37:38）

## 数据集预处理

### 1. 处理成每行'y x'的格式：rumor_all_data.ipynb

### 2.分词与索引化

* 读入原始文本；
* 使用pkuseg分词（微博领域），去除停用词；
* 预训练词向量使用北京师范大学中文信息处理研究所与中国人民大学 DBIIR 实验室的研究者开源的"chinese-word-vectors"，使用微博语料训练出的词向量，github链接为：https://github.com/Embedding/Chinese-Word-Vectors；
* 索引长度标准化：长度统一为$np.mean(num_tokens) + 2 * np.std(num_tokens)$。

### 3.准备Embedding矩阵

## 模型搭建与训练

* 划分测试集与训练集；
* 搭建网络结构：
  * Embedding：使用预训练词向量，参数不可训练；
  * 双向LSTM，参数64；
  * 双向LSTM，参数32；
  * 全连接层，参数1。


## 模型优化——使用GRU

* 搭建网络结构：
  * Embedding：使用预训练词向量，参数不可训练；
  * 双向GRU，参数32；
  * 全连接层，参数6；
  * 全连接层，参数1。


 
