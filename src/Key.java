import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Key {
	
	static String key;
	public  List<Integer> pc1 = new ArrayList<Integer>();
	public  List<Integer> pc2 = new ArrayList<Integer>();
	public static List<Integer> binarykey = new ArrayList<Integer>();
	public static List<Integer> permutedkey = new ArrayList<Integer>();
	public static List<Integer> Leftkey = new ArrayList<Integer>();
	public static List<Integer> Rightkey = new ArrayList<Integer>();
	public static List<Integer> K1 = new ArrayList<Integer>();
	
	public Key(String key){
		this.key = key;
		pc1.addAll(Arrays.asList(57, 49, 41, 33, 25, 17, 9,
      			1, 58, 50, 42, 34, 26, 18,
    			10, 2, 59, 51, 43, 35, 27,
    			19, 11, 3, 60, 52, 44, 36,
    			63, 55, 47, 39, 31, 23, 15,
    			7, 62, 54, 46, 38, 30, 22,
    			14, 6, 61, 53, 45, 37, 29,
    			21, 13, 5, 28, 20, 12, 4));
		pc2.addAll(Arrays.asList(
				14, 17, 11, 24, 1, 5,
				3, 28, 15, 6, 21, 10,
				23, 19, 12, 4, 26, 8,
				16, 7, 27, 20, 13, 2,
				41, 52, 31, 37, 47, 55,
				30, 40, 51, 45, 33, 48,
				44, 49, 39, 56, 34, 53,
				46, 42, 50, 36, 29, 32
				));
		this.hexToBinary(key);
	}
	
	public void hexToBinary(String hex) {
	    String bin = new BigInteger(hex, 16).toString(2);
	    for (int j = 0; j < bin.length(); j++) {
	    	int c = Character.digit(bin.charAt(j), 10);
	    		binarykey.add(c);
	    }
	    while(binarykey.size()<64) {
	    	binarykey.add(0, 0);
	    }
	    System.out.println("Binarykey and size :" + binarykey + "  " + binarykey.size());
	    Permutation perm1= new Permutation(pc1,binarykey);
	    	perm1.PermutationPc1();
	   // permutedkey = perm1.PermutationPc(0);
	   // System.out.println("Permutedkey after pc-1 and size :" + permutedkey + "  " + permutedkey.size());
	   // Permutation perm2= new Permutation(pc2,permutedkey);
	   // K1 = perm2.PermutationPc(1);
	}
	
}
