import java.util.*;
class Solution {
    
    
    public int solution(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0 ; i < nums.length; i++) {
            if(set.contains(nums[i])) continue;
            set.add(nums[i]);
            if(set.size() >= nums.length /2) break;
        }
        
        return set.size();
    }
}