package anagrams;
import java.util.ArrayList;
import java.util.List;

public class FindAllStartingIndexOfAnagramsFunction {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		
		if(s == null || p == null || s.length() == 0 || p.length() == 0){
			return result;
		}
		
		// Since lower case abc only, use 256 if caps abc too
		int[] char_counts = new int[26];
		
		// Count the many of times each letter appear
		for(char letter : p.toCharArray()){
			char_counts[letter - 'a']++;
		}
		
		int left = 0;
		int right = 0;
		int countLeft = p.length();
		
		
		while(right < s.length()){
			if(char_counts[s.charAt(right) - 'a'] >= 1){
				countLeft--;
			}
			
			// Update the current array by subtracting 1 first, then update the right pointer
			char_counts[s.charAt(right) - 'a']--;
			right++;
			
			// If count is zero, which mean we found a starting point
			if(countLeft == 0){
				result.add(left);
			}
			
			// If it reach the p length()
			if(right - left == p.length()){
				// Which mean 
				if(char_counts[s.charAt(left) - 'a'] >= 0){
					countLeft++;
				}
				
				// Update the current array by adding 1 first, then update the left pointer
				char_counts[s.charAt(left) - 'a']++;
				left++;
				
				
			}
			
		}
		
		return result;
		
	}
}
