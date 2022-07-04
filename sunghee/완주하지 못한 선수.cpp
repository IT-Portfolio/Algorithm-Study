#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    sort(participant.begin(), participant.end());
    sort(completion.begin(), completion.end());
    string answer;

    for (int i = 0; i < completion.size(); i++) {
        if (participant[i] != completion[i]) {
            answer = participant[i];
            break;
        }
    }
    if (answer.empty()) {
        answer = participant[participant.size() - 1];
    }

    return answer;
}

int main() {
    vector<string> participant = {"mislav", "stanko", "mislav", "ana"};
    vector<string> completion = {"stanko", "ana", "mislav"};

    cout << solution(participant, completion);
}