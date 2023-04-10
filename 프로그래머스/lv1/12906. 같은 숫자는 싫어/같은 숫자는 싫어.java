import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < arr.length; i++) {
            if(deque.isEmpty()) deque.offer(arr[i]);
            else {
                if(deque.peekLast() != arr[i]) {
                    deque.offer(arr[i]);
                }
            }
        }
        int[] answer = new int[deque.size()];
        int idx = 0;
        while(!deque.isEmpty()) {
            answer[idx++] = deque.poll();
        }
        return answer;
    }
}