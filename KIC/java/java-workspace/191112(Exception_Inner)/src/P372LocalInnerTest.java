
public class P372LocalInnerTest {

	int iMember = 1;
	static int cMember = 2;

	void method() {
		int localVar = 3;

		class LocalInner {
			int innerLocalVar = 4;

			void innerMethod() {
				System.out.println("외부 인스턴스 멤버 변수: " + iMember);
				System.out.println("외부 클래스 멤버 변수: " + cMember);
				System.out.println("외부 로컬 변수: " + localVar);
				System.out.println("내부 인스턴스 멤버 변수: " + innerLocalVar);
				iMember++;
				cMember++;
				// localVar++;
				innerLocalVar++;
			}
		}
		LocalInner inner = new LocalInner();
		inner.innerMethod();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P372LocalInnerTest lit = new P372LocalInnerTest();
		lit.method();

	}

}
