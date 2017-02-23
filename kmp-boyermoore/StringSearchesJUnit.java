import org.junit.Test;


public class StringSearchesJUnit {
	
	@Test
	//map[c] = needle.length() - 1 - index of the last occurrence of c
	public void test1BuildLastFunction(){
		System.out.println("Begin Boyer Moore Testing");
		System.out.println("Test 1 Build Last Function --------");
		String needle = "abcdef";
		int [] failureTable = StringSearches.buildLastFunction(needle);
		System.out.println("a: " + failureTable['a']);
		System.out.println("b: " + failureTable['b']);
		System.out.println("c: " + failureTable['c']);
		System.out.println("d: " + failureTable['d']);
		System.out.println("e: " + failureTable['e']);
		System.out.println("f: " + failureTable['f']);
		System.out.println("i: " + failureTable['i']);
		System.out.println();

	}
	
	@Test
	public void test2BuildLastFunction(){
		System.out.println("Test 2 Build Last Function --------");
		String needle = "abcdefab";
		int [] failureTable = StringSearches.buildLastFunction(needle);
		System.out.println("Needle length: " + needle.length());
		System.out.println("a: " + failureTable['a']);
		System.out.println("b: " + failureTable['b']);
		System.out.println("c: " + failureTable['c']);
		System.out.println("d: " + failureTable['d']);
		System.out.println("e: " + failureTable['e']);
		System.out.println("f: " + failureTable['f']);
		System.out.println();

	}
	
	@Test
	public void test3BuildLastFunction(){
		System.out.println("Test 3 Build Last Function --------");
		String needle = "aaaaa";
		int [] failureTable = StringSearches.buildLastFunction(needle);
		System.out.println("a: " + failureTable['a']);
		System.out.println("b: " + failureTable['b']);
		System.out.println("c: " + failureTable['c']);
		System.out.println("d: " + failureTable['d']);
		System.out.println("e: " + failureTable['e']);
		System.out.println("f: " + failureTable['f']);
		System.out.println();

	}
	
	@Test
	public void test4BuildLastFunction(){
		System.out.println("Test 4 Build Last Function --------");
		String needle = "";
		int [] failureTable = StringSearches.buildLastFunction(needle);
		for(int i = 0; i < failureTable.length; i++){
			System.out.println(failureTable[i] + ", ");
		}
	}
	
	@Test
	public void test5BuildLastFunction(){
		System.out.println("Test 5 Build Last Function --------");
		String needle = " ";
		int [] failureTable = StringSearches.buildLastFunction(needle);
		System.out.println("a: " + failureTable['a']);
		System.out.println("b: " + failureTable['b']);
		System.out.println("c: " + failureTable['c']);
		System.out.println("d: " + failureTable['d']);
		System.out.println("e: " + failureTable['e']);
		System.out.println("f: " + failureTable['f']);
		System.out.println("space: " + failureTable[' ']);//should be 1 as well

		System.out.println();
		
	}
	
	@Test
	public void test6BuildLastFunction(){
		System.out.println("Test 6 Build Last Function --------");
		String needle = null;
		int [] failureTable = StringSearches.buildLastFunction(needle);
		for(int i = 0; i < failureTable.length; i++){
			System.out.println(failureTable[i] + ", ");
		}
		System.out.println();
		
	}
	
	@Test
	public void test7BuildLastFunction(){
		System.out.println("Test 7 Build Last Function --------");
		String needle = "what the hell is going on";
		System.out.println("Needle length " + needle.length());
		int [] failureTable = StringSearches.buildLastFunction(needle);
		System.out.println("a: " + failureTable['a']);
		System.out.println("b: " + failureTable['b']);
		System.out.println("c: " + failureTable['c']);
		System.out.println("d: " + failureTable['d']);
		System.out.println("e: " + failureTable['e']);
		System.out.println("f: " + failureTable['f']);
		System.out.println("space: " + failureTable[' ']);
		System.out.println("t: " + failureTable['t']);
		System.out.println("h: " + failureTable['h']);
		System.out.println("l: " + failureTable['l']);
		System.out.println("o: " + failureTable['o']);
		System.out.println("n: " + failureTable['n']);
		System.out.println();
		
	}
	
	@Test
	public void test8BuildLastFunction(){
		System.out.println("Test 8 Build Last Function --------");
		String needle = "what the hell is going on";
		System.out.println("Needle length " + needle.length());
		int [] failureTable = StringSearches.buildLastFunction(needle);
		System.out.println("a: " + failureTable['a']);
		System.out.println("b: " + failureTable['b']);
		System.out.println("c: " + failureTable['c']);
		System.out.println("d: " + failureTable['d']);
		System.out.println("e: " + failureTable['e']);
		System.out.println("f: " + failureTable['f']);
		System.out.println("space: " + failureTable[' ']);
		System.out.println("t: " + failureTable['t']);
		System.out.println("h: " + failureTable['h']);
		System.out.println("l: " + failureTable['l']);
		System.out.println("o: " + failureTable['o']);
		System.out.println("n: " + failureTable['n']);
		System.out.println("N: " + failureTable['N']);
		System.out.println("H: " + failureTable['H']);
		System.out.println();
		
	}
	
	@Test
	public void test9BuildLastFunction(){
		System.out.println("Test 9 Build Last Function --------");
		String needle = "what the HelL is goinG on";
		System.out.println("Needle length " + needle.length());
		int [] failureTable = StringSearches.buildLastFunction(needle);
		System.out.println("a: " + failureTable['a']);
		System.out.println("b: " + failureTable['b']);
		System.out.println("c: " + failureTable['c']);
		System.out.println("d: " + failureTable['d']);
		System.out.println("e: " + failureTable['e']);
		System.out.println("f: " + failureTable['f']);
		System.out.println("space: " + failureTable[' ']);
		System.out.println("t: " + failureTable['t']);
		System.out.println("h: " + failureTable['h']);
		System.out.println("l: " + failureTable['l']);
		System.out.println("o: " + failureTable['o']);
		System.out.println("n: " + failureTable['n']);
		System.out.println("N: " + failureTable['N']);
		System.out.println("H: " + failureTable['H']);
		System.out.println("L: " + failureTable['L']);
		System.out.println("G: " + failureTable['G']);
		System.out.println("A: " + failureTable['A']);
		System.out.println();
		
	}
	
	
	
	@Test
	public void test1BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 1 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore("aaaa", "a");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test2BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 2 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore("aaaa", "aa");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test3BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 3 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore("aaaa", "aaaa");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	//Edge Cases begin Here
	@Test
	public void test4BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 4 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore("aa", "aaaa");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test5BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 5 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore("", "aaaa");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test6BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 6 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore("aaa", "");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test7BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 7 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore("anteaters are aardvarks", "aardvark");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test8BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 8 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore("crush kkyle with aardvarks", "aardvark");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test9BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 9 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore("I want to get away from you to", "to");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test10BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 10 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore("I want to get away from you to", "I");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test11BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 11 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore("I want to get away from you to", "want");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test12BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 12 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore("Hello World", "");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test13BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 13 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore("Hello World", "l");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test14BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 14 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore("Hello World Hello", "el");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test15BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 15 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore("el", "Hello World Hello");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test16BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 16 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore("this is a test", "");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test17BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 17 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore("this is a test", " ");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test18BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 18 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore(null, "aaaa");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test19BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 19 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore("", null);
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test20BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 20 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore(null, null);
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test21BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 21 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore(null, "");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test22BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 22 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore( "aaaa", null);
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test23BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 23 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore( "Jesus is my homeboy", "z");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test24BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 24 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore( "Jesus is my homeboyz", "z");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test25BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 25 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore( "zJesus is my homeboyz", "z");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test26BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 26 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore( "Jesus is my homeboyz", "boy");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test27BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 27 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore( "Jesus is my homeboyz", "j");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test28BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 28 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore( "Jesus is my homeboyz", "J");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test29BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 29 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore( "JeSus iS my hoMeboyz", "Su");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test30BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 30 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore( "JeSus iS my hoMeboyZ", "yz");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test31BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 31 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore( "JeSus iS my hoMeboyZ", "yZ");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test32BoyerMooreSearch(){
		System.out.println();
		System.out.println("Test 32 Boyer Moore Search *******");
		int [] matches = StringSearches.boyerMoore( "JeSus iS my hoMeboyZ", "M");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test1KMPPrefixTable(){
		System.out.println("Beginning KMP Testing");
		System.out.println();
		System.out.println("Test 1 KMP Prefix Table ########");
		int [] prefixTable = StringSearches.buildPrefixFunction("abcabc");
		for(int i = 0; i < prefixTable.length; i++){
			System.out.print(prefixTable[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test2KMPPrefixTable(){
		System.out.println();
		System.out.println("Test 2 KMP Prefix Table ########");
		int [] prefixTable = StringSearches.buildPrefixFunction("abcdabcabe");
		for(int i = 0; i < prefixTable.length; i++){
			System.out.print(prefixTable[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test3KMPPrefixTable(){
		System.out.println();
		System.out.println("Test 3 KMP Prefix Table ########");
		int [] prefixTable = StringSearches.buildPrefixFunction("abacab");
		for(int i = 0; i < prefixTable.length; i++){
			System.out.print(prefixTable[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test4KMPPrefixTable(){
		System.out.println();
		System.out.println("Test 4 KMP Prefix Table ########");
		int [] prefixTable = StringSearches.buildPrefixFunction("a b a b a c a ");
		for(int i = 0; i < prefixTable.length; i++){
			System.out.print(prefixTable[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test5KMPPrefixTable(){
		System.out.println();
		System.out.println("Test 5 KMP Prefix Table ########");
		int [] prefixTable = StringSearches.buildPrefixFunction("alfalfa");
		for(int i = 0; i < prefixTable.length; i++){
			System.out.print(prefixTable[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test6KMPPrefixTable(){
		System.out.println();
		System.out.println("Test 6 KMP Prefix Table ########");
		int [] prefixTable = StringSearches.buildPrefixFunction("a");
		for(int i = 0; i < prefixTable.length; i++){
			System.out.print(prefixTable[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test7KMPPrefixTable(){
		System.out.println();
		System.out.println("Test 7 KMP Prefix Table ########");
		int [] prefixTable = StringSearches.buildPrefixFunction("aa");
		for(int i = 0; i < prefixTable.length; i++){
			System.out.print(prefixTable[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test8KMPPrefixTable(){
		System.out.println();
		System.out.println("Test 8 KMP Prefix Table ########");
		int [] prefixTable = StringSearches.buildPrefixFunction("");
		for(int i = 0; i < prefixTable.length; i++){
			System.out.print(prefixTable[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test9KMPPrefixTable(){
		System.out.println();
		System.out.println("Test 9 KMP Prefix Table ########");
		int [] prefixTable = StringSearches.buildPrefixFunction(null);
		for(int i = 0; i < prefixTable.length; i++){
			System.out.print(prefixTable[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test10KMPPrefixTable(){
		System.out.println();
		System.out.println("Test 10 KMP Prefix Table ########");
		int [] prefixTable = StringSearches.buildPrefixFunction("aaaaa");
		for(int i = 0; i < prefixTable.length; i++){
			System.out.print(prefixTable[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test11KMPPrefixTable(){
		System.out.println();
		System.out.println("Test 11 KMP Prefix Table ########");
		int [] prefixTable = StringSearches.buildPrefixFunction("What the hell is going on");
		for(int i = 0; i < prefixTable.length; i++){
			System.out.print(prefixTable[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test12KMPPrefixTable(){
		System.out.println();
		System.out.println("Test 12 KMP Prefix Table ########");
		int [] prefixTable = StringSearches.buildPrefixFunction("aaaaAa");
		for(int i = 0; i < prefixTable.length; i++){
			System.out.print(prefixTable[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test13KMPPrefixTable(){
		System.out.println();
		System.out.println("Test 13 KMP Prefix Table ########");
		int [] prefixTable = StringSearches.buildPrefixFunction("ababaBabAab");
		for(int i = 0; i < prefixTable.length; i++){
			System.out.print(prefixTable[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test14KMPPrefixTable(){
		System.out.println();
		System.out.println("Test 14 KMP Prefix Table ########");
		int [] prefixTable = StringSearches.buildPrefixFunction("alfaLfa");
		for(int i = 0; i < prefixTable.length; i++){
			System.out.print(prefixTable[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test15KMPPrefixTable(){
		System.out.println();
		System.out.println("Test 15 KMP Prefix Table ########");
		int [] prefixTable = StringSearches.buildPrefixFunction("abcAbc");
		for(int i = 0; i < prefixTable.length; i++){
			System.out.print(prefixTable[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test16KMPPrefixTable(){
		System.out.println();
		System.out.println("Test 16 KMP Prefix Table ########");
		int [] prefixTable = StringSearches.buildPrefixFunction(null);
		for(int i = 0; i < prefixTable.length; i++){
			System.out.print(prefixTable[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test17KMPPrefixTable(){
		System.out.println();
		System.out.println("Test 17 KMP Prefix Table ########");
		int [] prefixTable = StringSearches.buildPrefixFunction("aaa");
		for(int i = 0; i < prefixTable.length; i++){
			System.out.print(prefixTable[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test1KMPMatching(){
		System.out.println();
		System.out.println("KMP Matching test 1");
		int [] matchesTable = StringSearches.kmp("abab", "ab");
		for(int i = 0; i < matchesTable.length; i++){
			System.out.print(matchesTable[i] + ", ");
		}
		System.out.println();	
	}
	
	@Test
	public void test2KMPMatching(){
		System.out.println();
		System.out.println("KMP Matching test 2");
		int [] matchesTable = StringSearches.kmp("abcdabcabcdabfabcdabcabe", "abcdabcabe");
		for(int i = 0; i < matchesTable.length; i++){
			System.out.print(matchesTable[i] + ", ");
		}
		System.out.println();	
	}
	
	@Test
	public void test3KMPMatching(){
		System.out.println();
		System.out.println("KMP Matching test 3");
		int [] matchesTable = StringSearches.kmp("aaaa", "a");
		for(int i = 0; i < matchesTable.length; i++){
			System.out.print(matchesTable[i] + ", ");
		}
		System.out.println();	
	}
	
	@Test
	public void test4KMPMatching(){
		System.out.println();
		System.out.println("KMP Matching test 4");
		int [] matchesTable = StringSearches.kmp("aaaa", "aa");
		for(int i = 0; i < matchesTable.length; i++){
			System.out.print(matchesTable[i] + ", ");
		}
		System.out.println();	
	}
	
	@Test
	public void test5KMPMatching(){
		System.out.println();
		System.out.println("KMP Matching test 5");
		int [] matchesTable = StringSearches.kmp("aaaa", "aaaa");
		for(int i = 0; i < matchesTable.length; i++){
			System.out.print(matchesTable[i] + ", ");
		}
		System.out.println();	
	}
	
	@Test
	public void test6KMPMatching(){
		System.out.println();
		System.out.println("KMP Matching test 6");
		int [] matchesTable = StringSearches.kmp("aa", "aaaa");
		for(int i = 0; i < matchesTable.length; i++){
			System.out.print(matchesTable[i] + ", ");
		}
		System.out.println();	
	}
	
	@Test
	public void test7KMPMatching(){
		System.out.println();
		System.out.println("KMP Matching test 7");
		int [] matchesTable = StringSearches.kmp("", "aaaa");
		for(int i = 0; i < matchesTable.length; i++){
			System.out.print(matchesTable[i] + ", ");
		}
		System.out.println();	
	}
	
	@Test
	public void test8KMPMatching(){
		System.out.println();
		System.out.println("KMP Matching test 8");
		int [] matchesTable = StringSearches.kmp("aaa", "");
		for(int i = 0; i < matchesTable.length; i++){
			System.out.print(matchesTable[i] + ", ");
		}
		System.out.println();	
	}
	
	@Test
	public void test9KMPMatching(){
		System.out.println();
		System.out.println("KMP Matching test 9");
		int [] matchesTable = StringSearches.kmp("anteaters are aardvarks", "aardvark");
		for(int i = 0; i < matchesTable.length; i++){
			System.out.print(matchesTable[i] + ", ");
		}
		System.out.println();	
	}
	
	@Test
	public void test10KMPMatching(){
		System.out.println();
		System.out.println("KMP Matching test 10");
		int [] matchesTable = StringSearches.kmp("crush kkyle with aardvarks", "aardvark");
		for(int i = 0; i < matchesTable.length; i++){
			System.out.print(matchesTable[i] + ", ");
		}
		System.out.println();	
	}
	
	@Test
	public void test11KMPMatching(){
		System.out.println();
		System.out.println("KMP Matching test 11");
		int [] matchesTable = StringSearches.kmp("I want to get away from you to", "to");
		for(int i = 0; i < matchesTable.length; i++){
			System.out.print(matchesTable[i] + ", ");
		}
		System.out.println();	
	}
	
	@Test
	public void test12KMPMatching(){
		System.out.println();
		System.out.println("KMPMatching Test 12  *******");
		int [] matches = StringSearches.boyerMoore("I want to get away from you to", "I");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test13KMPMatching(){
		System.out.println();
		System.out.println("KMPMatching Test 13 *******");
		int [] matches = StringSearches.boyerMoore("I want to get away from you to", "want");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test14KMPMatching(){
		System.out.println();
		System.out.println("KMPMatching Test 14");
		int [] matches = StringSearches.boyerMoore("Hello World", "");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test15KMPMatching(){
		System.out.println();
		System.out.println("KMPMatching Test 15");
		int [] matches = StringSearches.boyerMoore("Hello World", "l");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test16KMPMatching(){
		System.out.println();
		System.out.println("KMPMatching Test 16");
		int [] matches = StringSearches.boyerMoore("Hello World Hello", "el");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test17KMPMatching(){
		System.out.println();
		System.out.println("KMPMatching Test 17");
		int [] matches = StringSearches.boyerMoore("el", "Hello World Hello");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test18KMPMatching(){
		System.out.println();
		System.out.println("KMPMatching Test 18");
		int [] matches = StringSearches.boyerMoore("this is a test", "");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test19KMPMatching(){
		System.out.println();
		System.out.println("KMPMatching Test 19");
		int [] matches = StringSearches.boyerMoore("this is a test", " ");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test20KMPMatching(){
		System.out.println();
		System.out.println("KMPMatching Test 20");
		int [] matches = StringSearches.boyerMoore(null, "aaaa");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test21KMPMatching(){
		System.out.println();
		System.out.println("KMPMatching Test 21");
		int [] matches = StringSearches.boyerMoore("", null);
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test22KMPMatching(){
		System.out.println();
		System.out.println("KMPMatching Test 22");
		int [] matches = StringSearches.boyerMoore(null, null);
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test23KMPMatching(){
		System.out.println();
		System.out.println("Test 23 KMP Matching");
		int [] matches = StringSearches.boyerMoore(null, "");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test24KMPMatching(){
		System.out.println();
		System.out.println("Test 24 KMP Matching");
		int [] matches = StringSearches.boyerMoore( "aaaa", null);
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test25KMPMatching(){
		System.out.println();
		System.out.println("Test 25 KMP Matching");
		int [] matches = StringSearches.boyerMoore( "Jesus is my homeboy", "z");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test26KMPMatching(){
		System.out.println();
		System.out.println("Test 26 KMP Matching");
		int [] matches = StringSearches.boyerMoore( "Jesus is my homeboyz", "z");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test27KMPMatching(){
		System.out.println();
		System.out.println("Test 27 KMP Matching");
		int [] matches = StringSearches.boyerMoore( "zJesus is my homeboyz", "z");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test28KMPMatching(){
		System.out.println();
		System.out.println("Test 28 KMP Matching");
		int [] matches = StringSearches.boyerMoore( "Jesus is my homeboyz", "boy");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test29KMPMatching(){
		System.out.println();
		System.out.println("Test 29 KMP Matching");
		int [] matches = StringSearches.boyerMoore( "Jesus is my homeboyz", "j");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test30KMPMatching(){
		System.out.println();
		System.out.println("Test 30 KMP Matching");
		int [] matches = StringSearches.boyerMoore( "Jesus is my homeboyz", "J");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test31KMPMatching(){
		System.out.println();
		System.out.println("Test 31 KMP Matching");
		int [] matches = StringSearches.boyerMoore( "JeSuS is my homeboyss", "S");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test32KMPMatching(){
		System.out.println();
		System.out.println("Test 32 KMP Matching");
		int [] matches = StringSearches.boyerMoore( "JeSuS is my homeboyss", "s");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	@Test
	public void test33KMPMatching(){
		System.out.println();
		System.out.println("Test 33 KMP Matching");
		int [] matches = StringSearches.boyerMoore( "JeSuS is my homeboyss", "JeSuS is my homeboyss");
		for(int i = 0; i < matches.length; i++){
			System.out.print(matches[i] + ", ");
		}
		System.out.println();
	}
	
	
}
