#include <string>

class Solution {
public:
    int iterate(int num) {
        int sumVal = 0;
        std::string str = std::to_string(num);

        for (size_t i = 0; i < str.length(); i++) {
            int c = str[i] - '0';
            sumVal += c;
        }

        return sumVal;
    }

    int addDigits(int num) {
        int res = iterate(num);
        while (res >= 10) {
            res = iterate(res);
        }
        return res;
    }
};

