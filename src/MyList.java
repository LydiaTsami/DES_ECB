import java.util.ArrayList;
import java.util.List;

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
	
	public void permutate(List<Integer> table) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(Integer i : table) {
			list.add(mylist.get(table.get(i)-1));
			System.out.println(list);
		}
		mylist = list;
	}
	
	

}
