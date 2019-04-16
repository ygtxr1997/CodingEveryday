class RandomizedSet {
public:
    vector<int> data;
    unordered_map<int, int> dataMap;

    /** Initialize your data structure here. */
    RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    bool insert(int val) {
        if(!dataMap.count(val)) {
            data.push_back(val);
            dataMap[val] = data.size() - 1;
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    bool remove(int val) {
        if(dataMap.count(val)) {
            int tmpIndex = dataMap[val];
            dataMap[data.back()] = tmpIndex;
            swap(data[tmpIndex], data[data.size() - 1]);
            data.resize(data.size() - 1);
            dataMap.erase(val);
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    int getRandom() {
        if(data.empty()) return -1;
        int index = rand() % data.size();
        return data[index];
    }
};
