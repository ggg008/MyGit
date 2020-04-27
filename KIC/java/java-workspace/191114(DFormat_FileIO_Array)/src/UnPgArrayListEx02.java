import java.util.ArrayList;
import java.util.Arrays;

import day17_Java.arrayList.Student;

public class UnPgArrayListEx02
{
	public static void main(String[] args)
	{
		Student s1 = new Student("1", "홍씨", "010-1111-1111", "20", "서울시");
		Student s2 = new Student("2", "박씨", "010-2222-2222", "22", "서울시");
		Student s3 = new Student("3", "김씨", "010-3333-3333", "24", "서울시");

		ArrayList<Student> al = new ArrayList<Student>(Arrays.asList(s1, s2, s3));

		for (Student stu : al) {
			System.out.printf("%s %s %s %s %s\n", 
					stu.getSeq(), stu.getName(), stu.getPhone(), 
					stu.getAge(), stu.getRegion());
		}

	}
}
