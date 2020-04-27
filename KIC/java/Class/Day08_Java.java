import java.util.ArrayList;
import java.util.*;  

class Student2{
    String  name1;
    static String  name2;
}

// 클래스 이름이 같으면 어느것이 원본인지 구분하지 못한다
// 그리고 분리된 클래스 파일도 다시 저장해야함
// class Student{
//     String  name1;
// }

//main : 실행 class : public
public class Day08_Java{
    public static void main(String[] args) {
        System.out.printf("\n---------------------------------------\n");
        System.out.printf("Day08_Java");        
        System.out.printf("\n---------------------------------------\n");
        System.out.printf("TestEx01\n\n\n");
        
        //1~100의 수 중 2의 배수이자 3의 배수인 수의 합을 구하라 : 공배수
        System.out.println("1~100 수중 2의 배수이자 3의 배수인 수의 합을 구하라 : 공배수");
        int iMaxNum_Test1 = 100;
        int iResult = 0;
        
        for(int i = 0; i <= iMaxNum_Test1; ++i)
        {
            if(i % 2 == 0 && i % 3 == 0)
            {
                System.out.printf("| 2 && 3의 공배수. %d+%d=%d\n", i, iResult, i, (iResult + i));
                iResult += i;    
            }
        }
        System.out.printf("\n1에서 100까지 2, 3의 공배수의 합은 %d이다.\n", iResult);
        
        System.out.printf("\n---------------------------------------\n");
        System.out.printf("ArrayEx04\n\n\n");
        
        int[] ia_Array4 = new int[3];

        System.out.println(ia_Array4);//[I@448139f0 //주소값 출력
        
        System.out.println(ia_Array4[0]); // 0
        ia_Array4[0] = 10;
        ia_Array4[1] = 20;
        ia_Array4[2] = 30;
        System.out.println(ia_Array4[0]); // 10
        System.out.println(ia_Array4.length); // 크기

        for(int i = 0; i < ia_Array4.length; ++i)
        {
            System.out.println(ia_Array4[i]);
        }

        /* 향상된 포문 only JAVA : 딱히 포문보다 더좋지는 않다 *포문을 단순하게 쓰고싶을때 */
        System.out.println("향상된 포문 : 배열을 쉽게 순회 == foreach");
        for(int data : ia_Array4)
        {
            System.out.println(data);
        }
        
        System.out.printf("\n---------------------------------------\n");
        System.out.printf("ArrayEx05\n\n\n");
        
        // main의 String[] args 외부실행시 옵션용
        // 기본자료형 : (자료형)
        
        // 변환 : 문자열 -> 정수
        // Intger.parseInt(문자) -> int
        
        // System.out.println(args.length);//
        
        // for(String arg_Array5 : args)
        // {
        //     System.out.println(arg_Array5);
        // }
            
        /*
        if(0 < args.length)
        {
            System.out.println("Show args");
            System.out.println(args[0] + " " + args[1]);
            System.out.println(Integer.parseInt(args[0]) + Integer.parseInt(args[1]) );
        }
        else
            System.out.println("args.length is empty");
            */
        
        
        System.out.printf("\n---------------------------------------\n");
        System.out.printf("ArrayEx06\n\n\n");

        //2차원 : [행][열] ex:액셀

        int[][] ia_Array6 = new int[3][2];

        ia_Array6[0][0] = 10;
        ia_Array6[0][1] = 20;
        ia_Array6[1][0] = 30;
        ia_Array6[1][1] = 40;
        ia_Array6[2][0] = 50;
        ia_Array6[2][1] = 60;

        System.out.println(ia_Array6[0][0]);
        System.out.println(ia_Array6[2][1]);
        
        //생성과 동시에 초기화
        int[][] ia2_Array6 = new int[][] {{10, 20}, {30, 40}, {50, 60}};
        System.out.println(ia2_Array6[0][0]);
        System.out.println(ia2_Array6[2][1]);

        System.out.println(ia2_Array6[0].length);

        System.out.println("2중배열순회");
        for(int row = 0; row < ia2_Array6.length; ++row)
            for(int col = 0; col < ia2_Array6[row].length; ++col)
                System.out.println(ia2_Array6[row][col]);
                
        System.out.println("향상된 포문을 이용한 2중배열순회");
        for(int[] cols : ia2_Array6)
            for(int data : cols)
                System.out.println(data);

                
        System.out.println("향상된 포문 TEST");
        int[][][] iaTest = 
        new int[][][] {
            {{9, 8}, {6, 5, 4}}, 
            {{3, 3, 3}, {2, 2, 2}, {1}}, 
            {{1, 1, 1}, {0, 0}}
        };

        for(int[][] iaFrist : iaTest)
        {
            for(int[] iaSecond : iaFrist)
            {
                for(int data : iaSecond)
                    System.out.printf(data + " ");
                System.out.printf("\t");
            }
            System.out.println();
        }
                
        System.out.printf("\n---------------------------------------\n");
        System.out.printf("ArrayEx07\n\n\n");//가변배열

        int[][] ia_Aarry7 = new int[4][];
        ia_Aarry7[0] = new int[]{1,2,4,5};
        ia_Aarry7[1] = new int[]{10,20,30,40,50};
        ia_Aarry7[2] = new int[]{20,20,20};
        ia_Aarry7[3] = new int[]{30,30,30,30,30};

        int iSum_Array7 = 0;
        int iCnt_Array7 = 0;

        System.out.println("p154");
        for(int[] i : ia_Aarry7)
        {
            for(int j : i)
            {
                iSum_Array7 += j;
                ++iCnt_Array7;
                System.out.printf("iCnt : %d\t", iCnt_Array7);
            }
            System.out.printf("[ iSum은 %d  크기는 %d ]\n", iSum_Array7, i.length);            
        }
        System.out.printf("배열의 총 합은 %d, 평균은 %3.1f\n\n", iSum_Array7, (iSum_Array7 * 1.0 / iCnt_Array7));

        System.out.println("향상된 포문");
        int[][] ia2_Aarry7 = 
        {
            {1,2,4,5},
            {10,20,30,40,50},
            {20,20,20},
            {30,30,30,30,30}
        };

        for(int[] ia : ia2_Aarry7)
        {
            for(int data : ia)
                System.out.printf(data + "\t");
            System.out.println();
        }
        System.out.println();
        
        
        char[][] charArr2Dim = 
        {
            {'p', '1', '5', '5', '의', ' ', '향','상','된', ' '},
            {'포','문', '을', ' ', '이','용','한',' '},
            {'문','자', '배', '열', '순', '회'},
        };
        
        for(char[] charFirst : charArr2Dim)
        {
            for(char data : charFirst)
            {
                System.out.print(data);                
            }
        }
        System.out.println();



        System.out.printf("\n---------------------------------------\n");
        System.out.printf("ArrayEx08\n\n\n");
        
        
        System.err.println("args를 이용한 프로그램1(args 5개) / 실행 : Day08_java test1");
        if(0 < args.length && args[0].equals("test1"))
        {
            if(args.length != 5)
            {
                System.err.println("args가 5개 아님");
            }
            else
            {
                int iResult_Array8 = 0;  
                for(String data : args)
                {   
                    if(data == "test1")             
                        continue;
                    int i = Integer.parseInt(data);
                    if(i % 2 == 0)
                    {
                        iResult_Array8 += i;
                        System.out.printf("add %d!\t", i);
                    }
                }
                System.out.printf("\niSum : %d\n", iResult_Array8);
            }
            System.err.println();
        }
        

        System.err.println("args를 이용한 간단한 계산기 / 실행 : Day08_java test2");
        if(0 < args.length && args[0].equals("test2"))
        {
            int iResult_Array8 = 0;  
            for(int i =0; i < args.length; ++i)
            {            
                if(args[i].equals("test2"))
                    continue;

                if(args[i].equals("+") 
                || args[i].equals("-") 
                || args[i].equals("x") 
                || args[i].equals("/"))
                {
                    if(i == 1)
                    {
                        System.err.println("시작 값은 반드시 숫자여야한다!!");
                        break;
                    }
                    System.out.printf("args[%d] : %s\n", i, args[i]);
                    continue;
                }
                else if(i == 1)
                {
                    iResult_Array8 = Integer.parseInt(args[i]);
                    System.out.printf("계산시작!\nargs[%d] : %d\n", i, iResult_Array8);
                }
                else
                {
                    int preIndex = i - 1;
                    if(preIndex < 0)
                        continue;

                    int changeNum = Integer.parseInt(args[i]);
                    System.out.printf("args[%d] : %d\t", i, changeNum);
                    switch (args[preIndex]) {
                        case "+":
                            System.out.printf("+= %d!\n", changeNum);
                            iResult_Array8 += changeNum;
                            break;
                        case "-":
                            System.out.printf("-= %d!\n", changeNum);
                            iResult_Array8 -= changeNum;
                            break;
                        case "x":
                            System.out.printf("*= %d!\n", changeNum);
                            iResult_Array8 *= changeNum;
                            break;
                        case "/":
                            System.out.printf("/= %d!\n", changeNum);
                            iResult_Array8 /= changeNum;
                            break;
                        default:
                            System.out.println();
                            break;
                    }
                }
            }
            System.out.printf("\t\t= %d!\n", iResult_Array8);
            /*곱셉과 나눗셈의 우선순위를 높게 하는 방법은..?*/
        }
        
        
        System.out.printf("\n---------------------------------------\n");
        System.out.printf("MyTestEx01\n\n\n");

        /*
            try ~catch로 NumberFormatException 런타임에러를 회피하자! 
            숫자판별 또한 가능하다
        */
        System.err.println("try ~catch를 이용한 args 문자열에 숫자 유무 판별 / 실행 : Day08_java test3");
        if(0 < args.length && args[0].equals("test3"))
        {
            for(String data : args)
            {
                boolean isNum = false;
                try {
                    Integer.parseInt(data);
                    isNum = true;
                }
                catch(NumberFormatException e){

                }
                System.out.println(data + " is Number? : " + isNum );
            }
        }

        System.out.printf("\n---------------------------------------\n");
        System.out.printf("ClassEx01\n\n\n");

        //자료형 변수선언 - 생성
        Student stu1_Class1 = new Student();
        Student stu2_Class1 = new Student();


        //변수 초기화
        //. : 메모리 참조 연산자
        stu1_Class1.hakbun = "1001";
        stu1_Class1.name = "홍길동";
        stu1_Class1.age = 20;
        stu1_Class1.weight = 70;
        stu1_Class1.height = 180.5;

        System.out.println("▶ stu1_Class1 - ");
        System.out.println(stu1_Class1.hakbun);
        System.out.println(stu1_Class1.name);
        System.out.println();        
        
        System.out.println("▶ stu1_Class1, stu2_Class1의 주소값 - ");
        System.out.println(stu1_Class1);//Student@1d81eb93
        System.out.println(stu2_Class1);//Student@7291c18f


        System.out.printf("\n---------------------------------------\n");
        System.out.printf("ClassEx02\n\n\n");

        Student stu1_Class2 = new Student();        
        
        stu1_Class2.hakbun = "1001";
        stu1_Class2.name = "홍길동";

        System.out.println("▶ stu1_Class2와 stu2_Class2의 메모리공간(주소) 공유");
        System.out.println(stu1_Class2.hakbun);
        System.out.println(stu1_Class2.name);
        
        Student stu2_Class2 = stu1_Class2;

        System.out.println(stu2_Class2.hakbun);
        System.out.println(stu2_Class2.name);

        stu2_Class2.name = "박문수";
        System.out.println(stu1_Class2.name);
        System.out.println(stu2_Class2.name);

        System.out.println("▶ stu1_Class2와 stu2_Class2의 주소값");
        System.out.println(stu1_Class2);
        System.out.println(stu2_Class2);
        

        System.out.printf("\n---------------------------------------\n");
        System.out.printf("ClassEx03\n\n\n");//클래스 파일의 분리 : 모듈화

        // List<String> testList = new ArrayList<String>();        

        System.out.printf("\n---------------------------------------\n");
        System.out.printf("ClassEx04\n\n\n");

        Student2 stu1_Class4 = new Student2();


        stu1_Class4.name1 = "박문수";
        // stu1_Class4.name2 = "호이동";
        Student2.name2 = "호이동";

        System.out.println(stu1_Class4.name1);
        System.out.println(Student2.name2);       

        
        
        System.out.printf("\n---------------------------------------\n");
    }
}