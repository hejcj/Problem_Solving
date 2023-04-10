class Solution {
    static int cnt = 0;
    static void recur (int n, int sum, int target, int[] numbers) {

        if(n == numbers.length) {
            
            if(sum == target) cnt++;   
            return;
        }
        
        // 더한다
        recur(n+1,sum+numbers[n],target,numbers);
        // 뺀다.
        recur(n+1,sum-numbers[n],target,numbers);
    }
    
    public int solution(int[] numbers, int target) {
        recur(0,0,target,numbers);
        return cnt;
    }
}