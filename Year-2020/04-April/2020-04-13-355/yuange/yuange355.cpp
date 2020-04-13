// 关键数据结构是：哈希表，链表
// 关键算法是：合并K个有序链表
class Twitter {
private:
    typedef struct UserInfo { // 单个用户
        UserInfo(){}
        UserInfo(int tweetId) { posts.push_front(tweetId); }
        set<int> followees; // 关注的用户集合
        list<int> posts; // 发布的推文id链表
    } UserInfo;
    unordered_map<int, int> tweets; // <tweet_id, time>
    unordered_map<int, UserInfo> users; // <user_id, user_node>
    int cur_time;
    int max_show;
public:
    /** Initialize your data structure here. */
    Twitter() {
        cur_time = 0;
        max_show = 10;
    }
    typedef struct pii { // 合并K个链表使用优先队列
        pii(){}
        pii(int Id, int T) { tId = Id; time = T; }
        bool operator<(pii p2) const { return time < p2.time; }
        bool operator>(pii p2) const { return time > p2.time; }
        int tId, time;
    } pii; 
    
    /** Compose a new tweet. */
    void postTweet(int userId, int tweetId) {
        if (users.find(userId) == users.end()) users[userId] = UserInfo(); // 该用户不存在
        else if (users[userId].posts.size() >= max_show) users[userId].posts.pop_back();
        users[userId].posts.push_front(tweetId);
        tweets[tweetId] = ++cur_time;
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    // 关键的合并K个有序链表就在这里使用
    vector<int> getNewsFeed(int userId) {
        if (users.find(userId) == users.end()) { // 用户不存在
            users[userId] = UserInfo(); return vector<int>();
        }
        priority_queue<pii> pqu;
        for (auto ite = users[userId].posts.begin(); ite != users[userId].posts.end(); ite++) 
            pqu.push(pii(*ite, tweets[*ite]));
        for (int followee : users[userId].followees) {
            auto ite = users[followee].posts.begin();
            for (int i = 0; i < 10 && ite != users[followee].posts.end(); ite++, i++) {
                pqu.push(pii(*ite, tweets[*ite]));
            }
        }
        vector<int> ret;
        while (ret.size() < 10 && !pqu.empty()) {
            ret.push_back(pqu.top().tId);
            pqu.pop();
        }
        return ret;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    void follow(int followerId, int followeeId) {
        if (users.find(followerId) == users.end()) users[followerId] = UserInfo();
        if (users.find(followeeId) == users.end()) users[followeeId] = UserInfo();
        if (followerId != followeeId) users[followerId].followees.insert(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    void unfollow(int followerId, int followeeId) {
        users[followerId].followees.erase(followeeId);
    }
};

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter* obj = new Twitter();
 * obj->postTweet(userId,tweetId);
 * vector<int> param_2 = obj->getNewsFeed(userId);
 * obj->follow(followerId,followeeId);
 * obj->unfollow(followerId,followeeId);
 */