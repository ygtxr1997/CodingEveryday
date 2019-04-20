// 不能用unordered_set，因为要保存hash表中元素在数组的序号，60ms，92%
class RandomizedSet {
public:
    vector<int> v;
    unordered_map<int, int> um;
public:
    /** Initialize your data structure here. */
    RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    bool insert(int val) {
        if (!um.count(val)) {
            // 注意先后顺序，要从v为empty开始
            v.push_back(val);
            um[val] = v.size() - 1;
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    bool remove(int val) {
        if (um.count(val)) {
            // 交换数组末尾元素和val的位置
            int pos = um[val];
            um[v.back()] = pos;
            swap(v[pos], v[v.size() - 1]);
            v.resize(v.size() - 1);
            um.erase(val);
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    int getRandom() {
        return v[rand() % v.size()];
    }
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet* obj = new RandomizedSet();
 * bool param_1 = obj->insert(val);
 * bool param_2 = obj->remove(val);
 * int param_3 = obj->getRandom();
 */
