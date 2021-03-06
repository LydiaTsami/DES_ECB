import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Key {
	
	public  List<Integer> pc1 = new ArrayList<Integer>();
	private String key;
	public  List<Integer> pc2 = new ArrayList<Integer>();
	public static List<Integer> binarykey = new ArrayList<Integer>();
	private ArrayList<Integer> shift;
	public static ArrayList<MyList> Leftkey = new ArrayList<MyList>();
	public static ArrayList<MyList> Rightkey = new ArrayList<MyList>();
	public static ArrayList<MyList> LeftRightkey = new ArrayList<MyList>();
	public static List<Integer> originalkey = new ArrayList<Integer>();
	public static ArrayList<MyList> K = new ArrayList<MyList>();
	
	public Key(String key) {
		this.key =key;
		
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
		
		String leftname,rightname,leftrightname,keyname;
		for(int i=0;i<17;i++) {
			leftname = "C" +i;
			rightname = "D" +i;
			keyname = "K" + i;
			leftrightname = "C" +i +"D" +i;
			Leftkey.add(new MyList(leftname));
			Rightkey.add(new MyList(rightname));
			LeftRightkey.add(new MyList(leftrightname));
			K.add(new MyList(keyname));
		}
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
//	    Permutation perm1= new Permutation(pc1,binarykey);
//	    	perm1.PermutationPc1();
	    this.PermutationPc1();
	}
	
	
	@SuppressWarnings("unchecked")
	public void PermutationPc1() {
		for(int i=0;i<pc1.size(); i++) {
			K.get(0).add(binarykey.get(pc1.get(i)-1));
		}
		System.out.println(K.get(0).GetName() + ": "+ K.get(0));
		SplitKey(K.get(0));
	}
	
	public void PermutationPc2(int number) {
		for(int i=0;i<pc2.size(); i++) {
			K.get(number).add(LeftRightkey.get(number).get(pc2.get(i)-1));
		}
		System.out.println(K.get(number).GetName() + ": "+ K.get(number));
	}
	
	public void SplitKey(List<Integer> key) {
		for(int i=0;i<(key.size()/2); i++) {
			Leftkey.get(0).add(key.get(i));
			//Leftkey.add(key.get(i));
		}
		System.out.println(Leftkey.get(0).GetName() + ": "+ Leftkey.get(0));
		for(int num=1;num<17;num++) {
			Leftkey.get(num).addAll(Leftkey.get(num-1));
			Rotation(Leftkey.get(num),num-1);
			System.out.println(Leftkey.get(num).GetName() + ": "+ Leftkey.get(num));
		}
		for( int i=(key.size()/2); i<key.size(); i++) {
			Rightkey.get(0).add(key.get(i));
		}
		System.out.println(Rightkey.get(0).GetName() + ": "+ Rightkey.get(0));
		for(int num=1;num<17;num++) {
			Rightkey.get(num).addAll(Rightkey.get(num-1));
			Rotation(Rightkey.get(num),num-1);
			System.out.println(Rightkey.get(num).GetName() + ": "+ Rightkey.get(num));
		}
		for(int i=1;i<17;i++) {
			LeftRightkey.get(i).addAll(Leftkey.get(i));
			LeftRightkey.get(i).addAll(Rightkey.get(i));
			System.out.println(LeftRightkey.get(i).GetName() + ": "+ LeftRightkey.get(i) + " size:" + LeftRightkey.get(i).size());
			PermutationPc2(i);
		}
	}
	
	public void Rotation(List<Integer> key,int number) {
		int temp;
		int turn;
		shift = new ArrayList<Integer>();
		shift.addAll(Arrays.asList(1,1,2,2,2,2,2,2,1,2,2,2,2,2,2,1));
		turn = shift.get(number);
		if(turn==1) {
			temp = key.get(0);
			key.remove(0);
			key.add(temp);
		}
		else if( turn==2) {
			temp = key.get(0);
			key.remove(0);
			key.add(temp);
			temp = key.get(0);
			key.remove(0);
			key.add(temp);
		}
	}
}
