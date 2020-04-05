// 看错题目，写成了LRU，抽象啊抽象
class LFUCache {
private:
    typedef struct Node {
        Node(int k, int v) : key(k), val(v) {}
        int key;
        int val;
        Node* older = nullptr;
        Node* newer = nullptr;
    } Node, *PNode;
    unordered_map<int, PNode> m_umHash;
    PNode m_pOldest = nullptr;
    PNode m_pNewest = nullptr;
    int m_nCapacity = 0;
    int m_nSize = 0;
public:
    LFUCache(int capacity) {
        m_nCapacity = capacity;
        m_nSize = 0;
    }
    
    int get(int key) {
        cout << "get(" << key << endl; 
        auto ite = m_umHash.find(key);
        if (ite != m_umHash.end()) { // key存在
            if (ite->second == m_pNewest) { // 恰好是最近使用的
                // nothing to do
            } else if (ite->second == m_pOldest) { // key是最久未使用的
                m_pNewest = m_pOldest;
                m_pOldest = m_pOldest->newer;
            } else { // key既不是最近使用的，也不是最久未使用的
                PNode pCur = ite->second;
                
                PNode pLeft = pCur->older;
                PNode pRight = pCur->newer;
                pLeft->newer = pRight;
                pRight->older = pLeft;
                
                m_pNewest->newer = pCur;
                pCur->older = m_pNewest;
                
                m_pOldest->older = pCur;
                pCur->newer = m_pOldest;
                
                m_pNewest = pCur;
            }
            return m_pNewest->val;
        } else { // key不存在
            return -1;
        }
    }
    
    void put(int key, int value) {
        cout << "put(" << key << '-' << value << endl; 
        if (m_nSize < m_nCapacity) {        // 1. 未超出最大容量
            if (m_umHash.count(key) == 0) { // 1.1 key不存在
                PNode pCur = new Node(key, value);
                m_umHash[key] = pCur;
                if (m_nSize == 0) {         // 1.1.1 为空
                    m_pNewest = pCur;
                    m_pOldest = pCur;
                    pCur->older = pCur;
                    pCur->newer = pCur;
                } else {                    // 1.1.2 不为空
                    m_pNewest->newer = pCur;
                    pCur->older = m_pNewest;
                    m_pOldest->older = pCur;
                    pCur->newer = m_pOldest;
                    
                    m_pNewest = pCur;
                }
                cout << m_pNewest->key << ' ' << m_pOldest->key << endl;
                m_nSize++;
            } else {                        // 1.2 key已经存在
                get(key); // 更新双向链表
                m_pNewest->val = value; // 更新value值
            }
        } else {                            // 2. 超出最大容量
            if (m_umHash.count(key) == 0) { // 2.1 key不存在
                int delete_key = m_pOldest->key;
                get(delete_key);
                m_pNewest->key = key;
                m_pNewest->val = value;
                m_umHash.erase(delete_key);
                m_umHash[key] = m_pNewest;
            } else {                        // 2.2 key已经存在
                get(key);
                m_pNewest->val = value;
            }
        }
    }
};

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache* obj = new LFUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */