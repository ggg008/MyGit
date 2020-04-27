public class Day05_Java{
    public static void main(String[] args) {
        System.out.printf("%n---------------------------------------%n");

        System.out.println("HelloWorld\n");//HelloWorld

        System.out.println("Hello World");        
        //글자 인코딩(소스: utf-8 / 실행 : ansi)-한글출력이 에러가 나는 이유
        System.out.println("한글 출력 : javac -encoding utf-8 HelloWorld.java로 인코딩");
        /*출력
        System.out.print - 엔터키 미포함
        System.out.printf - 엔터키 포함
        System.out.println - 형식대로
        */
        System.out.print("Hello print");
        System.out.print("Hello print");
        System.out.print("Hello print");

        
        System.out.println("Hello println");
        System.out.println("Hello println");
        System.out.println("Hello println");


        System.out.printf("%s 이용하여 %s라고 출력 합니다 %n", "printf", "Hello S");
        
        //javac -encoding utf-8 HelloWorld.java -언어 인코딩 옵션

        System.out.printf("%n---------------------------------------%n");
        
        System.out.println("VariableEx01\n");//변수
        //변수의 선언
        byte age;
        //처음 변수의 값을 할당 : 초기화
        age = 10;
        System.out.println(age);
        
        //선언동시에 초기화
        double height = 180.5;
        System.out.println(height);
        
        System.out.printf("%n---------------------------------------%n");
        
        System.out.println("ConstantEx01\n");//상수
        int vNum = 20;
        System.out.printf("vNum : %d\n", vNum );
        
        //새로운 할당
        vNum = 40;
        System.out.printf("vNum : %d\n", vNum );
        
        final int C_NUM = 40;
        System.out.printf("C_NUM : %d\n", C_NUM );        

        System.out.printf("\n---------------------------------------\n");
        
        System.out.println("DataTypeEx01\n");//자료형
        char c1 = 'A';
        //char c2 = 'AA'; //문자열 에러
        System.out.printf("char %s \n", c1);
        
        char c2 = 65;//ascii A
        System.out.printf("ascii %s \n", c2);

        char c3 = '\uC790';//unicode '자' \\u + 16진수 아스키값 \t
        System.out.printf("unicode %s \n", c3);

        //특수 escape code / printer 제어용 / 화면제어
        System.out.printf("Hello Char \t Char \n Char \n");
        

        System.out.printf("\n---------------------------------------\n");
        
        System.out.println("DataTypeEx02\n");//DataTypeEx02
        //문자
        char c = 'A';
        //문자열(기본 자료형 아님)
        String str = "AAA"; 
        
        System.out.println(c);
        System.out.println(str);
        
        
        System.out.printf("\n---------------------------------------\n");
        
        System.out.println("DataTypeEx03\n");//DataTypeEx03
        
        boolean bool = true;		
        //boolean bool2 = True; //error
        //boolean bool3 = "true"; //error
        
        System.out.println(bool);
        
        
        System.out.printf("\n---------------------------------------\n");

        System.out.println("DataTypeEx04\n");//DataTypeEx04

        int in10 = 10;
        System.out.printf("10진수 i : %d\n", in10);
        

        //십진수
        byte b = 1;
        short s = 1;
        long l = 1;
        
        //이진수, 팔진수, 십육진수
        int in2 = 0b1010;
        System.out.printf("2진수 0b1010 : %d\n", in2);
        int in8 = 030;
        System.out.printf("8진수 030 : %d\n", in8);
        int in16 = 0xA4;
        System.out.printf("16진수 0xA4 : %d\n", in16);

        byte b1 = -128;
        System.out.println(b1);

        int i1 = 15;
        int i2 = 0b1111;
        int i3 = 170;
        int i4 = 0xf;
        System.out.println(i1 + ", " + i2 + ", "+ i3 + ", " +i4);

        int i5 = 1_000_000_000;//,대신 _로 구분 가능
        System.out.println(i5);

        //long l1 = 10000000000; //int로 간주
        long l2 = 10_000_000_000L; //L을 붙여 long 타입임을 명시
        System.out.println(l2);


        System.out.printf("\n---------------------------------------\n");
        
        System.out.println("DataTypeEx05\n");//DataTypeEx05
        //2.5
        //int i = 2.5; //error

        double d= 2.5;//소수 기본은 double
        System.out.println(d);
        float f= 2.5f;//f를 붙여 float임을 명시
        System.out.println(f);

        double d2 = 1.0e3;//지수도 가능 1 * 1000
        System.out.println(d2);
        
        System.out.printf("\n---------------------------------------\n");
        
        System.out.println("TypeCastingEx01\n");//형변환

        int ii1 =266;
        byte bb1 = 0;//ii1;
        byte bb2 =(byte)ii1;//큰곳에서  작은곳으로 갈때는 컴파일러가 에러로 지적해준다
        System.out.printf("ii1 : %d bb1 : %d bb2 : %d\n", ii1, bb1, bb2);

        short s1 = 10;//묵시적형변환
        int iTC0 = s1;

        float f1 = 10.0f;
        double dTC1 = f1;

        char cTC0 = 'A';
        int iii2 = cTC0;

        System.out.println(cTC0); // 문자
        System.out.println(iii2); // output ascii code

        /*
        String sTest1 = cTC0;
        System.out.printf("%d \n", sTest1);
        */
        
        System.out.printf("\n---------------------------------------\n");
                
        System.out.println("TypeCastingEx02\n");//명시적 형변환

        int iTC1 = 20;
        //()형변환 연산자
        short sTC1 = (short)iTC1;
        System.out.println(sTC1);
        
        char cTC1 = 'A';
        int iTC2 = cTC1 + 3;
        System.out.println(iTC2);
        System.out.println((char)iTC2);
        
        System.out.printf("\n---------------------------------------\n");

        
    }
}