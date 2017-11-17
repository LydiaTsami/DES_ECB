import java.util.ArrayList;
import java.util.List;

public class Permutation {
	
	public static List<Integer> Leftkey = new ArrayList<Integer>();
	public static List<Integer> Rightkey = new ArrayList<Integer>();
	public static List<Integer> originalkey = new ArrayList<Integer>();
	public static List<Integer> editedkey = new ArrayList<Integer>();
	public  List<Integer> pc = new ArrayList<Integer>();
	
	public Permutation(List<Integer> pc,List<Integer> originalkey) {
		this.pc = pc;
		this.originalkey = originalkey;
	}
	
	public List<Integer> PermutationPc(int number) {
		List<Integer> key = new ArrayList<Integer>();
		for(int i=0;i<pc.size(); i++) {
			editedkey.add(originalkey.get(pc.get(i)-1));
		}
		key =this.SplitKey(editedkey,number);
		return key;
	}
	
	public List<Integer> SplitKey(List<Integer> key,int number) {
		Leftkey.clear();
		Rightkey.clear();
		for(int i=0;i<(key.size()/2); i++) {
			Leftkey.add(key.get(i));
		}
		System.out.println(Leftkey.size());
		this.Rotation(Leftkey, number);
		System.out.println("Leftkey " + Leftkey);
		for( int i=(key.size()/2); i<key.size(); i++) {
			Rightkey.add(key.get(i));
		}
		this.Rotation(Rightkey, number);
		System.out.println("Rightkey " + Rightkey);
		
		key.clear();
		key.addAll(Leftkey);
		key.addAll(Rightkey);
		return key;
	}
	
	public void Rotation(List<Integer> key,int number) {
		int temp1,temp2,temp3,temp4;
		if(number==0) {
			temp1= key.get(0);
			temp2= key.get(7);
			temp3= key.get(14);
			temp4= key.get(21);
			key.remove(0);
			key.add(6, temp2);
			key.remove(7);
			key.add(13, temp3);
			key.remove(14);
			key.add(20, temp4);
			key.remove(21);
			key.add(27, temp1);
		}
		else if(number==1) {
			temp1= key.get(0);
			temp2= key.get(6);
			temp3= key.get(12);
			temp4= key.get(18);
			key.remove(0);
			key.add(5, temp2);
			key.remove(6);
			key.add(11, temp3);
			key.remove(12);
			key.add(17, temp4);
			key.remove(18);
			key.add(23, temp1);
		}
		else {
			temp1= key.get(0);
			temp2= key.get(6);
			temp3= key.get(12);
			temp4= key.get(18);
			key.remove(0);
			key.add(5, temp3);
			key.remove(6);
			key.add(11, temp4);
			key.remove(12);
			key.add(17, temp1);
			key.remove(18);
			key.add(23, temp2);
		}

	}

}
