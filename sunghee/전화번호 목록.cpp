#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool solution(vector<string> phone_book) {
    bool answer = true;
    sort(phone_book.begin(), phone_book.end());

    for (int i = 0; i < phone_book.size() - 1; i++) { //어떤 번호의 접두사를 확인하기 위함
        if (phone_book[i + 1].find(phone_book[i]) == 0) {
            answer = false;
            break;
        }
    }

    return answer;
}

int main() {
    vector<string> phone_book = {"119", "97674223", "1195524421"};
    cout << solution(phone_book);
}