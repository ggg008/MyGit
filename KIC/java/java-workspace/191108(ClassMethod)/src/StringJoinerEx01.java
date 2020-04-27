import java.util.StringJoiner;

public class StringJoinerEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		StringJoiner sjoin1 = new StringJoiner(":");
		StringJoiner sjoin1 = new StringJoiner(":", "[", "]"); // 구분자, 접두어, 접미어
		sjoin1.add("사과");
		sjoin1.add("수박");
		sjoin1.add("딸기");

		System.out.println(sjoin1 + "\n\n");
		System.out.println(sjoin1.toString());
	}

}
