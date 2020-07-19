/*

Minimum and Maximum values of an expression with * and +

Given an expression which contains numbers and two operators ‘+’ and ‘*’, we need to find maximum 
and minimum value which can be obtained by evaluating this expression by different parenthesization.
Examples:

Input  : expr = “1+2*3+4*5” 
Output : Minimum Value = 27, Maximum Value = 105 
Explanation:
Minimum evaluated value = 1 + (2*3) + (4*5) = 27
Maximum evaluated value = (1 + 2)*(3 + 4)*5 = 105

Approach : We can solve this problem by dynamic programming method, we can see that this problem is similar to matrix chain multiplication, 
here we are trying different parenthesization to maximize and minimize expression value instead of number of matrix multiplication.
In below code first we have separated the operators and numbers from given expression then two 2D arrays are taken for storing the 
intermediate result which are updated similar to matrix chain multiplication and different parenthesization are tried among the numbers 
but according to operators occurring in between them. At the end last cell of first row will store the final result in both the 2D arrays. */


#include <bits/stdc++.h> 
using namespace std; 
  
// Utility method to check whether a character 
// is operator or not 
bool isOperator(char op) 
{ 
    return (op == '+' || op == '*'); 
} 
  
// method prints minimum and maximum value 
// obtainable from an expression 
void printMinAndMaxValueOfExp(string exp) 
{ 
    vector<int> num; 
    vector<char> opr; 
    string tmp = ""; 
  
    //  store operator and numbers in different vectors 
    for (int i = 0; i < exp.length(); i++) 
    { 
        if (isOperator(exp[i])) 
        { 
            opr.push_back(exp[i]); 
            num.push_back(atoi(tmp.c_str())); 
            tmp = ""; 
        } 
        else
        { 
            tmp += exp[i]; 
        } 
    } 
    //  storing last number in vector 
    num.push_back(atoi(tmp.c_str())); 
  
    int len = num.size(); 
    int minVal[len][len]; 
    int maxVal[len][len]; 
  
    //  initializing minval and maxval 2D array 
    for (int i = 0; i < len; i++) 
    { 
        for (int j = 0; j < len; j++) 
        { 
            minVal[i][j] = INT_MAX; 
            maxVal[i][j] = 0; 
  
            //  initializing main diagonal by num values 
            if (i == j) 
                minVal[i][j] = maxVal[i][j] = num[i]; 
        } 
    } 
  
    // looping similar to matrix chain multiplication 
    // and updating both 2D arrays 
    for (int L = 2; L <= len; L++) 
    { 
        for (int i = 0; i < len - L + 1; i++) 
        { 
            int j = i + L - 1; 
            for (int k = i; k < j; k++) 
            { 
                int minTmp = 0, maxTmp = 0; 
  
                // if current operator is '+', updating tmp 
                // variable by addition 
                if(opr[k] == '+') 
                { 
                    minTmp = minVal[i][k] + minVal[k + 1][j]; 
                    maxTmp = maxVal[i][k] + maxVal[k + 1][j]; 
                } 
  
                // if current operator is '*', updating tmp 
                // variable by multiplication 
                else if(opr[k] == '*') 
                { 
                    minTmp = minVal[i][k] * minVal[k + 1][j]; 
                    maxTmp = maxVal[i][k] * maxVal[k + 1][j]; 
                } 
  
                //  updating array values by tmp variables 
                if (minTmp < minVal[i][j]) 
                    minVal[i][j] = minTmp; 
                if (maxTmp > maxVal[i][j]) 
                    maxVal[i][j] = maxTmp; 
            } 
        } 
    } 
  
    //  last element of first row will store the result 
    cout << "Minimum value : " << minVal[0][len - 1] 
         << ", Maximum value : " << maxVal[0][len - 1]; 
} 
  
//  Driver code to test above methods 
int main() 
{ 
    string expression = "1+2*3+4*5"; 
    printMinAndMaxValueOfExp(expression); 
    return 0; 
} 
