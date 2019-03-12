/***
 *_______________#########_______________________
 *______________############_____________________
 *______________#############____________________
 *_____________##_############___________________
 *____________###__######_#####__________________
 *____________###_########__####_________________
 *___________###__##########_####________________
 *__________####__###########_####_______________
 *________#####___###########__#####_____________
 *_______######___###_########___#####___________
 *_______#####___###___########___######_________
 *______######___###__###########___######_______
 *_____######___####_##############__######______
 *____#######__#####################_#######_____
 *____#######__##############################____
 *___#######__######_#################_#######___
 *___#######__######_######_#########___######___
 *___#######____##__######___######_____######___
 *___#######________######____#####_____#####____
 *____######________#####_____#####_____####_____
 *_____#####________####______#####_____###______
 *______#####______;###________###______#________
 *________##_______####________####______________
 */
/*
 * @Author: yuange
 * @LastEditors: yuange
 * @Description: Coding everyday!
 * @Date: 2019-03-12 09:46:33
 * @LastEditTime: 2019-03-12 11:29:24
 */

// 数据结构基础，写出来一堆BUG
class Trie {
private:
	typedef struct Node {
		Node(){}
		Node(bool b, char c) : bKey(b), cLetter(c) {}
		bool bKey = false;
		char cLetter = '0';
		vector<Node*> vSons;
	} Node;
	Node* head = nullptr;
	Node* pCur = nullptr;
public:

	/** Initialize your data structure here. */
	Trie() {
		head = new Node();
		pCur = head;
	}

	/** Inserts a word into the trie. */
	void insert(string word) {
		if (word.empty()) {
			pCur = head;
			return;
		}
		char c = word[0];
		bool bKey = word.size() == 1 ? true : false;
		for (auto son : pCur->vSons) {
			if (c == son->cLetter) {
				if (bKey) son->bKey = bKey;
				pCur = son;
				return insert(word.substr(1));
			}
		}
		Node* newNode = new Node(bKey, c);
		pCur->vSons.push_back(newNode);
		pCur = newNode;
		insert(word.substr(1));
	}

	/** Returns if the word is in the trie. */
	bool search(string word) {
		if (word.empty() || pCur->vSons.empty()) {
			bool ret = pCur->bKey ? true : false;
			pCur = head;
			return ret && word.empty();
		}
		char c = word[0];
		for (auto son : pCur->vSons) {
			if (c == son->cLetter) {
				pCur = son;
				return search(word.substr(1));
			}
		}
		pCur = head;
		return false;
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	bool startsWith(string prefix) {
		if (prefix.empty() || pCur->vSons.empty()) {
			pCur = head;
			return prefix.empty();
		}
		char c = prefix[0];
		for (auto son : pCur->vSons) {
			if (c == son->cLetter) {
				pCur = son;
				return startsWith(prefix.substr(1));
			}
		}
		pCur = head;
		return false;
	}
};

/**
* Your Trie object will be instantiated and called as such:
* Trie obj = new Trie();
* obj.insert(word);
* bool param_2 = obj.search(word);
* bool param_3 = obj.startsWith(prefix);
*/