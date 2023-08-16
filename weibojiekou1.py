# -*- codeing = utf-8 -*-
# @Time : 2022/3/24 16:32
# @Author : llj
# @File : weibojiekou1.py
# @Software: PyCharm

import sinaweibopy

def reply_comments():  # 回复评论

    url = 'https://api.weibo.com/2/comments/reply.json'

    data = {
        'access_token': '2.00HnMraGPwe4lD03a2d75cda23NfSB',
        'cid': 4750389268447250,
        'id': 4750316576705063,
        'comment': '%E8%BF%98%E8%83%BD%E8%BF%99%E6%A0%B7'
    }

    html = requests.post(url, json=data)

    print(html)


reply_comments()