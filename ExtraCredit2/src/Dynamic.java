import java.util.*;

public class Dynamic implements DynamicInterface {

	@Override
	public int lcs(String a, String b) {
		int[][] array = new int [a.length()][b.length()];
		for(int i = 0; i < array.length; i++){
			array[i] = 0;
		}
		for(int i = 0; i < array[0].length; i++){
				
			}
		
		for(int j = 1; j < array[0].length; j++){
			for(int i = 1; i < array.length; i++){
				if(a.charAt(i-1) == b.charAt(j-1)){
					//put appropriate values into array[i][j]
				}else{
					//put appropriate values into array[i][j]
				}
			}
		}
		return array[array.length -1][array[0].length -1];
	}

	@Override
	public int edit(String a, String b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int shop(int[] weight, int[] value, int max) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long matrix(int[] matrices) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int robbers(int[] weight, int[] value, int max) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int circus(String[] forest) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] realEstate(String[] flatLand) {
		// TODO Auto-generated method stub
		return null;
	}

}
