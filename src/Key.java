import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Key {
	
	static String key;
	public  List<Integer> pc1 = new ArrayList<Integer>();
	
	public static List<Integer> binarykey = new ArrayList<Integer>();
	public static List<Integer> permutedkey = new ArrayList<Integer>();
	
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
	}
	
	public String hexToBinary(String hex) {
	    String bin = new BigInteger(hex, 16).toString(2);
	    for (int j = 0; j < bin.length(); j++) {
	    	int c = Character.digit(bin.charAt(j), 10);
	    		binarykey.add(c);
	    }
	    return bin;
	}
	
//	public void DeleteParityBit() {
//		for(int i=1;i<binarykey.size(); i++) {
//			if((i%7)==0) {
//				binarykey.set(i, null);
//			}
//		}
//	}
	
	public void Permutation() {
		for(int i=0;i<pc1.size(); i++) {
			permutedkey.add(binarykey.get(pc1.get(i)-1));
		}
	}
	
	
	
	public void getpc1() {
		System.out.println(key);
		this.hexToBinary(key);
		System.out.println(binarykey);
		this.Permutation();
		System.out.println(permutedkey);
	}
	
}
