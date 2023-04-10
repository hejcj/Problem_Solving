class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int denom = denom1;
        if(denom1 != denom2) {
            numer1 *= denom2;
            numer2 *= denom1;
            denom = denom1 * denom2;
        }
        int numer = numer1 + numer2;

        int[] answer;
        for(int i = numer; i >= 2; i--) {
            if(denom % i == 0 && numer % i == 0) {
                answer = new int[]{numer /i,denom / i};
                return answer;
            }
        }
        
        
       answer = new int[]{numer,denom};
       
        return answer;
    }
}