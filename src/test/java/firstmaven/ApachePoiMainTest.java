package firstmaven;

import java.io.IOException;
import java.util.ArrayList;

public class ApachePoiMainTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ApachePoiDemo data=new ApachePoiDemo();
	ArrayList<String>dataretrieved=	data.getData("Logout");
	
	System.out.println(dataretrieved.get(0));
	System.out.println(dataretrieved.get(1));
	System.out.println(dataretrieved.get(2));
	System.out.println(dataretrieved.get(3));
	int n=Integer.parseInt(dataretrieved.get(3));
	
	System.out.println(n);
	

	}

}
