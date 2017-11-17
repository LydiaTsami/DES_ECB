import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Text {
	
	private static final Charset UTF_8 = Charset.forName("UTF-8");
	String plaintext;
	public  List<Integer> ip = new ArrayList<Integer>();
	public static List<Integer> binarytext = new ArrayList<Integer>();
	public static List<Integer> permutedtext = new ArrayList<Integer>();
	
	public Text(String text) {
	this.plaintext = text;
	ip.addAll(Arrays.asList(
			58, 50, 42, 34, 26, 18, 10, 2,
			60, 52, 44, 36, 28, 20, 12, 4,
			62, 54, 46, 38, 30, 22, 14, 6,
			64, 56, 48, 40, 32, 24, 16, 8,
			57, 49, 41, 33, 25, 17, 9, 1,
			59, 51, 43, 35, 27, 19, 11, 3,
			61, 53, 45, 37, 29, 21, 13, 5,
			63, 55, 47, 39, 31, 23, 15, 7));
	this.texttobytes();
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
		System.out.println(binarytext);
		this.Permutation();
	}
		
	
	public void Permutation() {
		for(int i=0;i<ip.size(); i++) {
			permutedtext.add(binarytext.get(ip.get(i)-1));
		}
		System.out.println(permutedtext);
	}

}
