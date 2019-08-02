package serilizationDeserilazation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Test implements Serializable{
	int i=10,j=20;
}

public class DemoSerilizationAndDeserilization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Test t1= new Test();
		
		//Serilization
		FileOutputStream fos=new FileOutputStream("test.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		
		oos.writeObject(t1);
		
		//Deserilization
		FileInputStream fis=new FileInputStream("test.txt");
		ObjectInputStream ois=  new ObjectInputStream(fis);
		Test t2=(Test) ois.readObject();
		System.out.println(t2.i);
		System.out.println(t2.j);
		
		

	}

}
