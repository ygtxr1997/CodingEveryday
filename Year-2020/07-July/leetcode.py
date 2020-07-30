import requests 
import json
from pathlib import Path
import os

# params = {'operationName': "getQuestionDetail",
#               'variables': {'titleSlug': slug},
#               'query': '''query getQuestionDetail($titleSlug: String!) {
#             question(titleSlug: $titleSlug) {
#                 questionId
#                 translatedContent
#                 translatedTitle
#                 topicTags {
#                         translatedName
#                 }
#             }
#         }'''
#               }
# json_data = json.dumps(params).encode('utf8')
# 浏览器标识
user_agent = r"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)"
headers = {'User-Agent': user_agent, 'Connection':
        'keep-alive', 'Content-Type': 'application/json',
        'Referer': 'https://leetcode-cn.com/problems/all/', # + slug,
        "accept": "*/*",
        "accept-language": "zh-CN,zh;q=0.9,en;q=0.8",
        "content-type": "application/json",
        "content-encoding": "gzip, deflate, br"}
# graphQL api查询
# lc_graphql_url = "https://leetcode-cn.com/graphql"
# resp = session.post(lc_graphql_url, data=json_data, headers=headers, timeout=10)
# content = resp.json()

url = 'https://leetcode-cn.com/graphql'
# headers = {'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Safari/537.36'}
params = {"operationName":"questionOfToday",
        "variables":{},
        "query":'''query questionOfToday {
                todayRecord {
                        question {
                                questionFrontendId
                                questionTitleSlug
                                __typename
                        }
                        lastSubmission {
                                id
                                __typename
                        }
                        date
                        userStatus
                        __typename
                }
        }
        '''}
data = json.dumps(params).encode('utf8')
r = requests.post(url,headers = headers,data = data,timeout=10)
# print(r.json())
todayRecord = r.json()['data']['todayRecord'][0]
date = todayRecord['date']
questionFrontendId = todayRecord['question']['questionFrontendId']
questionTitleSlug = todayRecord['question']['questionTitleSlug']

# 创建readme文件
ls = [
        '## '+ questionFrontendId +'.' + questionTitleSlug,
        '\n[Q'+ questionFrontendId +'](https://leetcode-cn.com/problems/'+ questionTitleSlug +'/)'
]
text = "".join(ls)

# print(text)
# return text

# 把text写进readme
# path = "./"+ date +"-" + questionFrontendId +  "/Q"+ questionFrontendId +".md"
newDir = "./"+ date +"-" + questionFrontendId
os.mkdir(newDir)
path =newDir +  "/Q"+ questionFrontendId +".md"
print(path)
md_path = Path(path)
with open(path, "w+", encoding="utf-8") as md:
    md.writelines(text)


