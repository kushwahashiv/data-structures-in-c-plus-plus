// Source : https://leetcode.com/problems/next-permutation/description/
// Author : Shiv S. Kushwaha
// Date   : 2014-08-21

/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void nextPermutation(vector<int>& nums) {
    	int k = -1;
    	for (int i = nums.size() - 2; i >= 0; i--) {
    		if (nums[i] < nums[i + 1]) {
    			k = i;
    			break;
    		}
    	}
    	if (k == -1) {
    	    reverse(nums.begin(), nums.end());
    	    return;
    	}
    	int l = -1;
    	for (int i = nums.size() - 1; i > k; i--) {
    		if (nums[i] > nums[k]) {
    			l = i;
    			break;
    		}
    	}
    	swap(nums[k], nums[l]);
    	reverse(nums.begin() + k + 1, nums.end());
    }

void nextPermutation(vector<int> &num) {

    if(num.size()<=1) return;

    for(int i=num.size()-1; i>0; i--) {
        if (num[i-1] < num[i]){
            int j = num.size()-1;
            while( num[i-1] >= num[j]) {
                //pass;
                j--;
            }
            int tmp = num[j];
            num[j] = num[i-1];
            num[i-1] = tmp;
            //sort works as well
            //sort(num.begin()+i, num.end()); 
            reverse(num.begin()+i, num.end()); 
            return; 
        }
        //edge case: 4 3 2 1
        if (i == 1 ){
            //sort works as well
            //sort(num.begin(), num.end());
            reverse(num.begin(), num.end());
            return;
        }
    }

}

void printVector(vector<int> &num) {
    for(int i=0; i<num.size(); i++) {
        cout << num[i] << " ";
    } 
    cout <<endl;
}
bool isBeginVector(vector<int> &num) {
    for(int i=0; i<num.size(); i++) {
        if(num[i] != i+1) {
            return false;
        }
    } 
    return true;
}

int main(int argc, char** argv)
{
    int n = 4;
    if (argc>1){
        n = atoi(argv[1]);
    }
    vector<int> num;
    for(int i=1; i<=n; i++){
        num.push_back(i);
    }
    
    while(true){
        printVector(num);
        nextPermutation(num);
        if(isBeginVector(num)){
            break;
        }
    }
    return 0;
}
