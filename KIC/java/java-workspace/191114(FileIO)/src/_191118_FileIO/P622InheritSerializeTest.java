package _191118_FileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class P622InheritSerializeTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		File target = new File("C:/Temp/objParent.dat");
		Child child = new Child("홍", 20);
		try (
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(target));
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(target));	
			) {
			oos.writeObject(child);
			System.out.println("--------");
			Object readed = ois.readObject();
			
			if(readed != null && readed instanceof Child) {
				Child casted = (Child)readed;
				System.out.println(casted.toString());
			}
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


	static class Parent
	{
		protected String name;
	}
	
	static class Child extends Parent implements Serializable
	{
		private static final long serialVersionUID = 4261512421193094142L;
		private int age;
		
		public Child(String name, int age)
		{
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString()
		{
			return "Child [age=" + age + ", name=" + name + "]";
		}
		
		private void writeObject(ObjectOutputStream out) throws IOException//직렬화 또한 상속받듯이 오버라이드해서 사용하여야한다
		{
			System.out.println("call override writeObject " + out.toString());
			
			out.writeUTF(name);
			out.defaultWriteObject();//자기 클래스의 WriteObject를 호출
		}
		
		private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException
		{			
			System.out.println("call override readObject" + in.toString());
			name = in.readUTF();
			in.defaultReadObject();
		}
	}
	
	
}
