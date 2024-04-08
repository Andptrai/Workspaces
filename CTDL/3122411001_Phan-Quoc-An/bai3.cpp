#include <iostream>
#include <stack>
#include <string>

using namespace std;

struct CharStack {
    stack<char> data;

    void pushChar(char c) {
        data.push(c);
    }

    void printAndPop() {
        if (!data.empty()) {
            cout << data.top();
            data.pop();
        }
    }

    bool isEmpty() {
        return data.empty();
    }
};

int main() {
    string inputString = "Hello";

    CharStack charStack;

    // day tung ki tu vao stack
    for (size_t i = 0; i < inputString.length(); ++i) {
        charStack.pushChar(inputString[i]);
    }

//dao nguoc
    while (!charStack.isEmpty()) {
        charStack.printAndPop();
    }

    return 0;
}

