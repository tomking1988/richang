package Problems;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++){
            map.put(numbers[i], i);
        }
        
        int[] result = new int[2];
        for(int i = 0; i < map.size(); i++){
            if(map.containsKey(target - numbers[i])){
                result[0] = i+1;
                result[1] = map.get(target - numbers[i])+1;
                return result;
            }
        }
        
        return result;
    }
}
