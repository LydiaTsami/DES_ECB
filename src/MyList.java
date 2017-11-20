import java.util.ArrayList;

public class MyList extends ArrayList{
	
	private ArrayList<Integer> mylist;
	private String name;
	
	public MyList(String name) {
	this.name =name;
	mylist = new ArrayList<Integer>();
	}
	
	public String GetName() {
		return name;
	}
	
	

}
