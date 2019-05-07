// 学习了双向链表list
class LRUCache {
public:
	LRUCache(int capacity): capacity(capacity) {}

	int get(int key) {
		if (pos.find(key) != pos.end()) {
			put(key, pos[key]->second);
			return pos[key]->second;
		}
		return -1;
	}

	void put(int key, int value) {
		if (pos.find(key) != pos.end())
			recent_list.erase(pos[key]);

		else if (recent_list.size() >= capacity) {
			pos.erase(recent_list.back().first);
			recent_list.pop_back();
		}
		
		recent_list.push_front({ key, value });
		pos[key] = recent_list.begin();
	}

private:
	int capacity;
	list<pair<int, int>> recent_list;
	unordered_map<int, list<pair<int, int>>::iterator> pos; // value存储的是一个迭代器
};

/**
* Your LRUCache object will be instantiated and called as such:
* LRUCache* obj = new LRUCache(capacity);
* int param_1 = obj->get(key);
* obj->put(key,value);
*/
