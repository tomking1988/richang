#include <stack>
#include <string>
#include <sstream>
#include <vector>
#include <iostream>

using namespace std;

class Solution {
public:
    bool isOperator(const string& input)
    {
        string ops[] = {"+", "-", "*", "/"};
        for (int i = 0; i < 4; i++)
        {
            if (input == ops[i])
            {
                return true;
            }
        }
        return false;
    }
    
    void performOp(const string& input, stack<int>& calcStack)
    {
        int lVal, rVal, result;
        rVal = calcStack.top();
        calcStack.pop();
        
        lVal = calcStack.top();
        calcStack.pop();
        
        if (input == "+")
            result = lVal + rVal;
        else if (input == "-")
            result = lVal - rVal;
        else if (input == "*")
            result = lVal * rVal;
        else if (input == "/")
            result = lVal / rVal;
            
        calcStack.push(result);
    }
    
    int evalRPN(vector<string> &tokens) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        stack<int> calcStack;
        for (vector<string>::iterator it = tokens.begin(); it != tokens.end(); ++it)
        {
            int num;
            if (istringstream(*it) >> num)
                calcStack.push(num);
            else if (isOperator(*it))
                performOp(*it, calcStack);
        }
        
        return calcStack.top();
    }
};