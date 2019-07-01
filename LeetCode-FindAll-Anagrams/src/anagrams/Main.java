package anagrams;

public class Main {
	public static void main(String[] args){
		String s = "cbaebabacd";
		String p = "abc";
		
		System.out.println("s: " + s + " p: " + p);
		
		FindAllAnagramsSolution solution = new FindAllAnagramsSolution();
		
		System.out.println("Solution: " + solution.findAnagrams(s, p));
	}
}
