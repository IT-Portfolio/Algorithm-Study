#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

int solution(vector<vector<string>> clothes) {
    unordered_map<string, int> tmp;
    int answer = 1;
    for (auto t: clothes) {
        tmp[t[1]]++;
    }
    for (auto t: tmp) {
        answer *= (t.second + 1);
    }
    return answer - 1;
}
