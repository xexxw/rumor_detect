# -*- codeing = utf-8 -*-
# @Time : 2022/3/24 16:32
# @Author : llj
# @File : weibojiekou1.py
# @Software: PyCharm

import sinaweibopy

def reply_comments():  # 回复评论

    url = 'https://api.weibo.com/2/comments/reply.json'

    data = {
        'access_token': '',
        'cid': ,
        'id': ,
        'comment': ''
    }

    html = requests.post(url, json=data)

    print(html)


reply_comments()
