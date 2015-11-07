
public class Dynamic implements DynamicInterface {

	/**
	 * Solves the largest common subsequence problem
	 * @param a
	 * @param b
	 * @return length of the Longest Common Subsequence of Strings A and B
	 */
	public int lcs(String a, String b) {

		String str = a;
		String str2 = b;
		int[][] array = new int[str.length() + 1][str2.length() + 1];

		for (int i = 0; i < array.length; i++) {
			array[i][0] = 0; // double check this
		}

		for (int i = 0; i < array[0].length; i++) {
			array[0][i] = 0;
		}

		for (int j = 1; j < array[0].length; j++) {
			for (int i = 1; i < array.length; i++) {
				if (str.charAt(i - 1) == str2.charAt(j - 1)) {
					array[i][j] = array[i - 1][j - 1] + 1;
				} else {
					array[i][j] = Math.max(array[i - 1][j], array[i][j - 1]);
				}
			}
		}
		return array[array.length - 1][array[0].length - 1];
	}

	/**
	 * finds the least amount of edits to turn one string into another
	 * @param a
	 * @param b
	 * @return number of edits
	 */
	public int edit(String a, String b) {

		String str1 = a;
		String str2 = b;
		int[][] ar = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 0; i < ar.length; i++) {
			ar[i][0] = i;
		}

		for (int i = 0; i < ar[0].length; i++) {
			ar[0][i] = i;
		}

		for (int j = 1; j < ar[0].length; j++) {
			for (int i = 1; i < ar.length; i++) {
				int temp = Math.min(ar[i - 1][j] + 1, ar[i][j - 1] + 1);
				temp = Math.min(temp,
						ar[i - 1][j - 1] + different(str1, str2, i, j));
				ar[i][j] = temp;
			}
		}

		return ar[ar.length - 1][ar[0].length - 1];
	}

	private int different(String s1, String s2, int i, int j) {
		if (s1.charAt(i - 1) == s2.charAt(j - 1))
			return 0;
		return 1;
	}
	
	/**
	 * Solution to shop problem
	 * @param weight
	 * @param value
	 * @param max
	 * @return maximum total value of the items you are able to fit into your bag
	 */
	public int shop(int[] weight, int[] value, int max) {
		int[] bags = new int[max + 1];
		int[] weights = weight;
		int[] values = value;

		for (int i = 1; i < bags.length; i++) {
			for (int j = 0; j < weights.length; j++) {
				if (weights[j] <= i
						&& (values[j] + bags[i - weights[j]]) > bags[i]) {
					bags[i] = values[j] + bags[i - weights[j]];
				}
			}
		}

		return bags[bags.length - 1];
	}

	/**
	 * Solution to matrix problem
	 * @param matrices
	 * @return minimum number of operations required
	 */
	public long matrix(int[] matrices) {
		int x = matrices.length - 1;
		int j;
		long[][] l = new long[matrices.length][matrices.length];
		for (int i = 1; i < x; i++) {
			l[i][i] = 0;
		}

		for (int L = 2; L <= l.length; L++) {
			for (int i = 1; i <= l.length - L; i++) {
				j = i + L - 1;
				l[i][j] = Long.MAX_VALUE;
				for (int k = i; k < j; k++) {
					l[i][j] = Math.min(l[i][j], l[i][k] + l[k + 1][j]
							+ (matrices[i - 1] * matrices[j] * matrices[k]));
				}
			}
		}
		return l[1][l.length - 1];
	}

	/**
	 * solution to Robbers problem
	 * @param weight
	 * @param value
	 * @param max
	 * @return maximum total value of the items you are able to steal
	 */
	public int robbers(int[] weight, int[] value, int max) {
		int x = value.length;
		int[][] array = new int[x + 1][max + 1];

		for (int i = 0; i < array.length; i++) {
			array[i][0] = 0;
		}

		for (int i = 0; i < array[0].length; i++) {
			array[0][i] = 0;
		}

		for (int j = 1; j < max + 1; j++) {
			for (int i = 1; i < x + 1; i++) {
				if (weight[i - 1] > j) {
					array[i][j] = array[i - 1][j];
				} else
					array[i][j] = Math.max(array[i - 1][j], value[i - 1]
							+ array[i - 1][j - weight[i - 1]]);
			}
		}

		return array[x][max];
	}

	/**
	 * Solution to the Circus problem
	 * @param forest
	 * @return integer representing the maximum area of the tent that the circus can bring
	 */
	public int circus(String[] forest) {
		int[][] array = new int[forest.length][forest[0].length()];
		int max = 0;
		for (int i = forest.length - 1; i >= 0; i--) {
			for (int j = forest[0].length() - 1; j >= 0; j--) {
				int count;
				if (forest[i].charAt(j) != '.') {
					count = 0;
					array[i][j] = count;
				} else {
					if (i == forest.length - 1 || j == forest[0].length() - 1) {
						count = 1;
						array[i][j] = count;
					} else {
						count = Math.min(array[i + 1][j],
								Math.min(array[i][j + 1], array[i + 1][j + 1])) + 1;
						array[i][j] = count;
						if (max < count)
							max = count;
					}
				}
			}
		}
		return (int) Math.pow(max, 2);
	}

	
	public int[] realEstate(String[] flatLand) {
		int[] array = {12314};
		return array;
	}


}