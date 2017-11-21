import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Text {
	
	private static final Charset UTF_8 = Charset.forName("UTF-8");
	String plaintext;
	private static Key key;
	public static List<Integer> sb = new ArrayList<Integer>();
	public static List<Integer> sbsmall = new ArrayList<Integer>();
	public  List<Integer> p = new ArrayList<Integer>();
	public  List<Integer> ip = new ArrayList<Integer>();
	public  List<Integer> ip_1 = new ArrayList<Integer>();
	public  List<Integer> IPtext = new ArrayList<Integer>();
	private List<Integer> ebit =  new ArrayList<Integer>();
	public static List<Integer> binarytext = new ArrayList<Integer>();
	public static List<Integer> permutedtext = new ArrayList<Integer>();
	public static ArrayList<MyList> L = new ArrayList<MyList>();
	public static ArrayList<MyList> R = new ArrayList<MyList>();
	public static ArrayList<MyList> ER = new ArrayList<MyList>();
	public static ArrayList<Integer> B = new ArrayList<Integer>();
	public static ArrayList<Integer> RL16 = new ArrayList<Integer>();
	public static ArrayList<MyList> f = new ArrayList<MyList>();
	private ArrayList<MyList> sBoxes= new ArrayList<MyList>();

	public Text(String text,Key key) {
		this.plaintext = text;
		this.key = key;
		
		ip_1.addAll(Arrays.asList(40, 8, 48, 16, 56, 24, 64, 32,
	            39, 7, 47, 15, 55, 23, 63, 31,
	            38, 6, 46, 14, 54, 22, 62, 30,
	            37, 5,   45,    13,    53,   21,    61,   29,
	            36, 4,   44,    12,    52,   20,    60,   28,
	            35, 3,   43,    11,    51,   19, 59, 27,
	            34, 2, 42, 10, 50, 18, 58, 26,
	            33, 1, 41, 9, 49, 17, 57, 25));
		p.addAll(Arrays.asList(16, 7, 20, 21,
                29, 12, 28, 17,
                1, 15, 23, 26,
                5,  18,  31,  10,
                2,   8,  24,  14,
               32,  27,   3,   9,
               19,  13,  30,   6,
               22,  11,   4,  25));
		ip.addAll(Arrays.asList(
			58, 50, 42, 34, 26, 18, 10, 2,
			60, 52, 44, 36, 28, 20, 12, 4,
			62, 54, 46, 38, 30, 22, 14, 6,
			64, 56, 48, 40, 32, 24, 16, 8,
			57, 49, 41, 33, 25, 17, 9, 1,
			59, 51, 43, 35, 27, 19, 11, 3,
			61, 53, 45, 37, 29, 21, 13, 5,
			63, 55, 47, 39, 31, 23, 15, 7));
		
		ebit.addAll(Arrays.asList(
				32, 1, 2, 3, 4, 5,
                4, 5, 6, 7, 8, 9,
                8, 9, 10, 11, 12, 13,
               12, 13, 14, 15, 16, 17,
               16, 17, 18, 19, 20, 21,
               20, 21, 22, 23, 24, 25,
               24, 25, 26, 27, 28, 29,
               28, 29, 30, 31, 32, 1));	
		init();
	}
	
	public void init() {
		String left,right,er,sb;
		ArrayList<Integer> sBox= new ArrayList<Integer>() ;
		//s1
		sBox.addAll(Arrays.asList(//s1
				14,4,13,1,2,15,11,8,3,10,6,12,5,9,0,7,
				0,15,7,4,14,2,13,1,10,6,12,11,9,5,3,8,
				4,1,14,8,13,6,2,11,15,12,9,7,3,10,5,0,
				15,12,8,2,4,9,1,7,5,11,3,14,10,0,6,13));
		sBoxes.add(new MyList("S1"));
		sBoxes.get(0).addAll(sBox);
		sBox.clear();
		//s2
		sBox.addAll(Arrays.asList(15,1,8,14,6,11,3,4,9,7,2,13,12,0,5,10,//s2
				3,13,4,7,15,2,8,14,12,0,1,10,6,9,11,5,
				0,14,7,11,10,4,13,1,5,8,12,6,9,3,2,15,
				13,8,10,1,3,15,4,2,11,6,7,12,0,5,14,9));
		sBoxes.add(new MyList("S2"));
		sBoxes.get(1).addAll(sBox);
		sBox.clear();
		//s3
		sBox.addAll(Arrays.asList(10,0,9,14,6,3,15,5,1,13,12,7,11,4,2,8,
				13,7,0,9,3,4,6,10,2,8,5,14,12,11,15,1,
				13,6,4,9,8,15,3,0,11,1,2,12,5,10,14,7,
				1,10,13,0,6,9,8,7,4,15,14,3,11,5,2,12));
		sBoxes.add(new MyList("S3"));
		sBoxes.get(2).addAll(sBox);
		sBox.clear();
		//s4
		sBox.addAll(Arrays.asList(7,13,14,3,0,6,9,10,1,2,8,5,11,12,4,15,
				13,8,11,5,6,15,0,3,4,7,2,12,1,10,14,9,
				10,6,9,0,12,11,7,13,15,1,3,14,5,2,8,4,
				3,15,0,6,10,1,13,8,9,4,5,11,12,7,2,14));
		sBoxes.add(new MyList("S4"));
		sBoxes.get(3).addAll(sBox);
		sBox.clear();
		//s5
		sBox.addAll(Arrays.asList(2,12,4,1,7,10,11,6,8,5,3,15,13,0,14,9,
				14,11,2,12,4,7,13,1,5,0,15,10,3,9,8,6,
				4,2,1,11,10,13,7,8,15,9,12,5,6,3,0,14,
				11,8,12,7,1,14,2,13,6,15,0,9,10,4,5,3));
		sBoxes.add(new MyList("S5"));
		sBoxes.get(4).addAll(sBox);
		sBox.clear();
		//s6
		sBox.addAll(Arrays.asList(12,1,10,15,9,2,6,8,0,13,3,4,14,7,5,11,
				10,15,4,2,7,12,9,5,6,1,13,14,0,11,3,8,
				9,14,15,5,2,8,12,3,7,0,4,10,1,13,11,6,
				4,3,2,12,9,5,15,10,11,14,1,7,6,0,8,13));
		sBoxes.add(new MyList("S6"));
		sBoxes.get(5).addAll(sBox);
		sBox.clear();
		//s7
		sBox.addAll(Arrays.asList(4,11,2,14,15,0,8,13,3,12,9,7,5,10,6,1,
				13,0,11,7,4,9,1,10,14,3,5,12,2,15,8,6,
				1,4,11,13,12,3,7,14,10,15,6,8,0,5,9,2,
				6,11,13,8,1,4,10,7,9,5,0,15,14,2,3,12));
		sBoxes.add(new MyList("S7"));
		sBoxes.get(6).addAll(sBox);
		sBox.clear();
		//s8
		sBox.addAll(Arrays.asList(13,2,8,4,6,15,11,1,10,9,3,14,5,0,12,7,
				1,15,13,8,10,3,7,4,12,5,6,11,0,14,9,2,
				7,11,4,1,9,12,14,2,0,6,10,13,15,3,5,8,
				2,1,14,7,4,10,8,13,15,12,9,0,3,5,6,11));
		sBoxes.add(new MyList("S8"));
		sBoxes.get(7).addAll(sBox);
		sBox.clear();
		
		for(int i=0;i<17;i++) {
			left = "L" +i;
			right = "R" +i;
			er = "ER" +i;
			sb = "f" +i;
			L.add(new MyList(left));
			R.add(new MyList(right));
			ER.add(new MyList(er));
			f.add(new MyList(sb));
		}	
		this.texttobytes();
		this.Permutation(binarytext,permutedtext,ip);
		System.out.println("IP: " +permutedtext + " size: " + permutedtext.size());
		SplitText();
	}
	
	public void texttobytes() {
		byte[] bytes = plaintext.getBytes();
		  StringBuilder binary = new StringBuilder();
		  for (byte b : bytes)
		  {
		     int val = b;
		     for (int i = 0; i < 8; i++)
		     {
		        binary.append((val & 128) == 0 ? 0 : 1);
		        val <<= 1;
		     }
		     binary.append(' ');
		  }
		for (int j = 0; j < binary.length(); j++) {
	    	int c = Character.digit(binary.charAt(j), 10);
	    	if(c!=-1)
	    		binarytext.add(c);
	    }
		System.out.println("Binary text: " +binarytext + " size: " + binarytext.size());
	}
	
	public void SplitText() {
		int temp,decimal;
		String text="";
		List<Integer> temp1 = new ArrayList<Integer>();
		for(int i=0;i<(permutedtext.size()/2); i++) {
			L.get(0).add(permutedtext.get(i));
		}
		System.out.println(L.get(0).GetName() + ": " +L.get(0));
		for( int i=(permutedtext.size()/2); i<permutedtext.size(); i++) {
			R.get(0).add(permutedtext.get(i));
		}
		System.out.println(R.get(0).GetName() + ": " +R.get(0) + " size: " + R.get(0).size());
		for(int i=1;i<17;i++) {
			int sindex =0;
			temp1.clear();
			sb.clear();
			B.clear();
			L.get(i).addAll(R.get(i-1));
			System.out.println(L.get(i).GetName() +": " +L.get(i));
			Permutation(R.get(i-1),ER.get(i-1),ebit);
			System.out.println(ER.get(i-1).GetName() + ": " +ER.get(i-1));
			for(int j=0;j<key.K.get(i).size();j++) {
				temp = (int)key.K.get(i).get(j) ^ (int)ER.get(i-1).get(j);
				temp1.add(temp);
			}
			B.add(temp1.get(0));
			for(int k=1 ; k <temp1.size() ; k++) {
				if(k%6!=0) {
					B.add(temp1.get(k));
				}
				else {
					sb.addAll(CalculateSB(sindex));
					sindex++;
					B.clear();
					B.add(temp1.get(k));
				}
			}
			sb.addAll(CalculateSB(sindex));
			System.out.println("SB: "+sb);
			Permutation(sb,f.get(i),p);
			System.out.println(f.get(i).GetName()+ ": " +f.get(i));
			for(int j=0; j<L.get(i-1).size();j++) {
				temp = (int)L.get(i-1).get(j) ^ (int)f.get(i).get(j);
				R.get(i).add(temp);
			}
			System.out.println(R.get(i).GetName() +": " +R.get(i));
		}
		RL16.addAll(R.get(16));
		RL16.addAll(L.get(16));
		System.out.println("R16L16: " +RL16);
		Permutation(RL16,IPtext, ip_1);
		System.out.println("IP-1 : " + IPtext + " size: " + IPtext.size());
		String alltext="";
		text = IPtext.get(0).toString();
		for(int i=1;i<IPtext.size();i++) {
			if(i%4!=0) {
				text += IPtext.get(i).toString();
			}
			else {
				decimal = Integer.parseInt(text,2);
				String hexStr = Integer.toString(decimal,16);
				alltext += hexStr;
				text = IPtext.get(i).toString();
				
			}
		}
		decimal = Integer.parseInt(text,2);
		String hexStr = Integer.toString(decimal,16);
		alltext += hexStr;
		System.out.println("Encrypted text: " +alltext.toUpperCase());
			
	}
	
	public List<Integer> CalculateSB(int index) {
		int row,col,listindex,binary;
		String bin;
		String rowcol;
		sbsmall.clear();
		
		rowcol= "";
		rowcol = B.get(0).toString();
		rowcol += B.get(5).toString();
		row = Integer.parseInt(rowcol,2);
		
		rowcol = "";
		rowcol += B.get(1).toString();
		rowcol += B.get(2).toString();
		rowcol += B.get(3).toString();
		rowcol += B.get(4).toString();
		col = Integer.parseInt(rowcol,2);
		listindex = 16*row + col;
		binary = (Integer)sBoxes.get(index).get(listindex);
		bin = Integer.toBinaryString(binary);
		while(bin.length()<4) {
			bin = "0" + bin;
		}
		
	    for (int j = 0; j < bin.length(); j++) {
	    	int c=0;
	    	if(bin.charAt(j)==48) {
	    		c=0;
	    	}
	    	else if(bin.charAt(j)==49) {
	    		c=1;
	    	}
	    	sbsmall.add(c);
	    }
	    return sbsmall;
	}
		
	
	public void Permutation(List<Integer> original,List<Integer> edited,List<Integer> table) {
		for(int i=0;i<table.size(); i++) {
			edited.add(original.get(table.get(i)-1));
		}
	}

}
