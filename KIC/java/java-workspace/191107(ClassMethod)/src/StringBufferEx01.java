
public class StringBufferEx01 {

	public static void main(String[] args) {

		// Buffer 내부 저장 공간
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer(100);
		StringBuffer sb3 = new StringBuffer("Hello World");

		// 기본크기 +16 데이터 넣을수록 확장
		System.out.println(sb1.capacity());
		System.out.println(sb2.capacity());
		System.out.println(sb3.capacity());

		System.out.println(sb3.length());

		// 내부버퍼조작 : append, insert, delete
		System.out.println(sb3);

		sb3.append(" 안녕");
		System.out.println(sb3);

		sb3.insert(3, " 추가 ");
		System.out.println(sb3);

		sb3.delete(0, 4);
		System.out.println(sb3);

		// p437
		StringBuilder builder = new StringBuilder("사봉-용산-사가정-용마산");
		System.out.println(builder);
		builder.append("-중곡");
		System.out.println(builder);
		builder.insert(3, "면목-");
		System.out.println(builder);
		builder.delete(5, 8);
		System.out.println(builder);
		builder.replace(0, 1, "상");
		System.out.println(builder);
	}
}
