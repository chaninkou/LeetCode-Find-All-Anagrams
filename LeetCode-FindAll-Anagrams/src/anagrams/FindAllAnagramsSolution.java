package anagrams;
import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsSolution {
	public List<Integer> findAnagrams(String s, String p) {

		List<Integer> list = new ArrayList<>();
		
		if (s == null || p == null || p.length() == 0 || s.length() == 0) {
			return list;
		}
		
		// character hash
		int[] hash = new int[256];

		// record each character in p to hash
		for (char c : p.toCharArray()) {
			hash[c] = hash[c] + 1;
		}

		// two points, initialize count to p's length
		int left = 0;
		int right = 0;
		int count = p.length();

		while (right < s.length()) {
			if (hash[s.charAt(right++)]-- >= 1) {
				count--;
			}

			if (count == 0) {
				list.add(left);
			}

			if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) {
				count++;
			}
		}
		return list;
	}
}
