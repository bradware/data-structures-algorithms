
public class tester {
	public static void main(String[] args) {
		System.out.println(TextSearch.runBruteForce("Ball last", "last"));
		System.out.println(TextSearch.comparision);
		
		
		System.out.println(TextSearch.runBoyerMoore("Ball last", "last"));
		System.out.println(TextSearch.comparision);
		
		
		System.out.println(TextSearch.runKMP("Ball last", "last"));
		System.out.println(TextSearch.comparision);
		
		System.out.println(TextSearch.runKMP("abadabacbabacaba", "abacaba"));
		System.out.println(TextSearch.comparision);
		
		System.out.println(TextSearch.runBruteForce("abadabacbabacaba", "abacaba"));
		System.out.println(TextSearch.comparision);
	}
	
}
