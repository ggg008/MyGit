public class Day07_Java{
    public static void main(String[] args) {    

        System.out.printf("\n---------------------------------------\n");
        System.out.printf("Day07_Java");        
        System.out.printf("\n---------------------------------------\n");
        System.out.printf("LoopEx01\n\n\n");
        
        // System.out.println("Hello World");
        // System.out.println("Hello World");
        // System.out.println("Hello World");
        // System.out.println("Hello World");
        // System.out.println("Hello World");
        // System.out.println("Hello World");
        // System.out.println("Hello World");
        // System.out.println("Hello World");
        // System.out.println("Hello World");
        // System.out.println("Hello World");
        
        for(int i = 0; i < 10; ++i)
        {
            int iCheck_Loop1 = i + 1;
            System.out.println("Hello World " + iCheck_Loop1);
        }
        
        System.out.printf("\n---------------------------------------\n");   
        System.out.printf("LoopEx02\n\n\n");

        System.out.println("Test1");
        //1부터 10까지 출력
        for(int i = 0; i < 10; ++i)
        {
            System.out.println(i + 1);
        }
        
        //1부터 10까지 홀수
        System.out.println("\n1부터 10까지 홀수");
        for(int i = 0; i < 10; i+=2)
        {
            System.out.println((i + 1) % 2 == 1 ? i + 1 : "짝수");
            /*
            if((i + 1) % 2 == 1)
                System.out.println( i + 1 );
            else 
                System.out.println("짝수");
            */
        }
        

        System.out.printf("\n---------------------------------------\n");
        System.out.printf("LoopEx03\n\n\n");
        
        // A - Z
        // for
        for(int i = 65; i <= 90; ++i)
        {
            System.out.printf("%c ", i);
        }
        
        System.out.printf("\n---------------------------------------\n");   
        System.out.printf("LoopEx04\n\n\n");
        
        // process 3 * 3 
        for(int i = 0; i < 3; ++i)
        {
            for(int iInnerAscii = 0; iInnerAscii < 3; ++iInnerAscii)
            {
                System.out.println( (i+1) + " : " + (iInnerAscii+1) );
            }
        }
        
        System.out.printf("\n---------------------------------------\n");
        System.out.printf("LoopEx05\n\n\n");
        
        /*
        구구단을 찍고싶다
        1*1=1 1*2=2 ... 9*9=81
        */
        for(int i = 1; i <= 9; ++i)
        {
            for(int iInnerAscii = 1; iInnerAscii <= 9; ++iInnerAscii)
            {
                System.out.printf("%d*%d=%d\t", i, iInnerAscii, i*iInnerAscii);/*tab의 정렬기능에 주목*/
                // System.out.printf( i + "*" + iInnerAscii + "=" + (i*iInnerAscii)+ "\t");                
            }
            System.out.printf("\n");
        }
        
        //강사님 버전
        System.out.printf("\n강사님 버전\n");
        for(int row = 1; row<=9; row++){
            for(int col=1; col<=4; col++){
                System.out.printf( row + "X" + col + "=" + (row * col) + "\t");
            }
            System.out.println();
        }
        
        System.out.printf("\n---------------------------------------\n");   
        System.out.printf("LoopEx06\n\n\n");
        
        String result_Loop6 = "";
        
        System.out.printf("\n문자열 버전\n");
        for(int row = 1; row<=9; row++){
            for(int col=1; col<=4; col++){
                result_Loop6 = result_Loop6 + row + "X" + col + "=" + (row * col) + "\t";
                //누적
            }
            result_Loop6 = result_Loop6 + "\n";
        }
        
        System.out.println( result_Loop6 );
        
        System.out.printf("\n---------------------------------------\n");
        System.out.printf("LoopEx07\n\n\n");
        
        /*
            for * 2 ▼
            ***********
            *********** 
            ... * 10
            *********** 
        */
        for(int i = 0; i < 10; ++i)
        {
            for(int iInnerAscii = 0; iInnerAscii < 10; ++iInnerAscii)
            {
                if(iInnerAscii % 2 == 0)
                System.out.printf("★");
                else
                System.out.printf("☆");
            }
            System.out.printf("\n");
        }
        
        /*
            for * 2 ▼
            *
            **
            ... * 10
            ***********
        */
        // 행
        for(int i = 0; i < 10; ++i)
        {
            // 열
            for(int iInnerAscii = 0; iInnerAscii < i; ++iInnerAscii)
            {
                System.out.printf("★");
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");
        
        /*
            for * 2 ▼
            ***********
            **********
            ... * 10
            **
            *
        */
        for(int i = 9; 0 < i; --i)
        {
            // 열
            for(int iInnerAscii = 0; iInnerAscii < i; ++iInnerAscii)
            {
                System.out.printf("★");
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");

        System.out.printf("강사님 버전\n");
        for(int i = 1; i <= 10; i++){
            for(int iInnerAscii = 1; iInnerAscii <= 11-i; iInnerAscii++){
                System.out.printf("*");
            }
            System.out.println();
        }
        System.out.println();
        
        /*
            for * 2 ▼
            A
            AB
            ... * 10
            ABCDEFGHIJ
        */

        int iAscii_A = 'A';
        int iAscii_Z = 'Z';

        for(int i = iAscii_A; i <= iAscii_Z + 1; ++i)
        {
            for(int iInnerAscii = iAscii_A; iInnerAscii < i; ++iInnerAscii)
                System.out.printf("%c", iInnerAscii);
            System.out.printf("\n");
        }
        System.out.printf("\n");

        /*
            1에서 100까지 3의 배수의 합
            누적
            3의 배수
        */
        int iMaxNum_Loop7 = 100;
        int iResult = 0;

        for(int i = 0; i <= iMaxNum_Loop7; ++i)
        {
            if(i != 0 && i % 3 == 0)
            {
                System.out.printf("3의 배수 %d을 더함. %d + %d = %d\n", i, iResult, i, (iResult + i));
                iResult += i;                
            }
        }
        System.out.printf("1에서 100까지 3의 배수의 합은 %d이다.\n", iResult);

        // for(boolean flag =true; flag;)
        // {
        //     System.out.println("무한루핑");
        // }
        
        System.out.printf("\n---------------------------------------\n");   
        System.out.printf("LoopEx10\n\n\n");//while
        
        // 10번 반복
        int i_Loop10 = 1;
        while( i_Loop10 <= 10){
            System.out.println("Hello While");
            ++i_Loop10;
        }
        
        System.out.printf("\n---------------------------------------\n");   
        System.out.printf("LoopEx11\n\n\n");
        /*
        while ▼
        A
        AB
        ... * 10
        ABCDEFGHIJ
        */
        int iAsciiA_Loop11 = 'A';
        int iAsciiZ_Loop11 = 'Z';
        while( iAsciiA_Loop11 <= iAsciiZ_Loop11)
        {            
            int iInnerAscii = 'A';//내부값의 초기화
            while(iInnerAscii <= iAsciiA_Loop11)
            {
                System.out.printf("%c", iInnerAscii);
                ++iInnerAscii;
            }
            System.out.printf("\n");
            ++iAsciiA_Loop11;
        }
        System.out.printf("\n");
        
        
        System.out.printf("\n---------------------------------------\n");
        System.out.printf("LoopEx12\n\n\n");//do while
        
        int i_Loop12 = 1;
        do
        {
            System.out.println("Hello doWhile");
            ++i_Loop12;
        } 
        while(i_Loop12 <= 10);
        
        System.out.printf("\n---------------------------------------\n");   
        System.out.printf("LoopEx13\n\n\n");//반복문 제어
        
        //break; continue;
        //while / do while 많이 use
        
        System.out.println("start");
        int i_Loop13 = 0;
        while(i_Loop13 <= 5)
        {
            System.out.printf("%d\n", i_Loop13);
            ++i_Loop13;
            if(i_Loop13 == 3)
            {
                //반복문 종료
                // break;
                //건너뛰기 
                continue;/*로직밑에 증감을 선언하면 영원히 증감을 진행할수없기 때문에 무한루핑이 됨*/
            }
        }
        System.out.println("end");
        
        
        
        System.out.printf("\n---------------------------------------\n");
        System.out.printf("LoopEx14\n\n\n");//반복문 제어
        
        System.out.println("start");
        int iLoop14 = 0;
        while(iLoop14<=5)
        {
            ++iLoop14;
            int j =0;
            
            System.out.println("A 루트");
            while(j<=5)
            {
                System.out.println("A-a 루트");
                ++j;
                if(j==3)
                {
                    System.out.println("A-a-1 루트");
                    // break;//3 루프정지
                    continue;//3 제외후 다시루프 /*즉, 하단의 문장을 실행하지 않는다*/
                }
                System.out.println(iLoop14 + " : " + j);
                System.out.println("A-b 루트");
            }
            System.out.println("B 루트\n");
        }
        System.out.println("end");
        
        System.out.printf("\n---------------------------------------\n");   
        System.out.printf("LoopEx15\n\n\n");//반복문 제어 label
        
        myOuter : for(int i = 0; i <= 10; ++i)
        {
            myInner : for(int j = 0; j <= 10; ++j)
            {
                if(j == 5)
                {
                    /* not Important */
                    // System.out.printf("[break;]\t"); break;
                    // System.out.printf("[break-myInner;]\t"); break myInner; // == break
                    // System.out.printf("[continue;]\t"); continue; 
                    // System.out.printf("[continue-myInner;]\t"); continue myInner; //== continue
                    
                    /* 활용할 곳이 많음 */
                    // System.out.printf("[break-myOuter;]\t"); break myOuter; //★ 전부 끝낸다 (1 ~ 4출력)
                    // System.out.printf("[continue-myOuter;]\t"); continue myOuter; //★ 바깥for문에 컨티뉴 (5부터 빠지고 /n이 없어짐)
                }
                System.out.printf("[%d·%d]\t", i, j);
            }
            System.out.println();
        }
        
        System.out.printf("\n---------------------------------------\n");
        System.out.printf("ArrayEx01\n\n\n");
        
        //배열의 선언 : 저장공간 메모리 주소를 저장하는 공간 생성 : (선언 - 생성 - 초기화)
        
        //자료형[] 변수명 ○
        //자료형 변수명[] 
        int[] ia1_Array1;
//         String[] strA1_Array1;
        
        //배열의 생성 => 저장공간 메모리 주소를 대입
        ia1_Array1 = new int[10];
//        strA1_Array1 = new String[5];
        
        //배열의 기본값으로 초기화
        //배열의 값으로 초기화
        
        // index 번호로 초기화 : 0번부터 시작
        ia1_Array1[0] = 10;
        ia1_Array1[1] = 20;
        ia1_Array1[2] = 30;
        ia1_Array1[3] = 40;
        
        //접근
        System.out.println(ia1_Array1[0]);
        System.out.println(ia1_Array1[3]);
        System.out.println(ia1_Array1[9]);
        // System.out.println(ia1_Array1[11]);
        
        System.out.printf("\n---------------------------------------\n");
        System.out.printf("ArrayEx02\n\n\n");
        
        int[] ia1_Array2;
        
        ia1_Array2 = new int[3];
        ia1_Array2[0] = 10;
        ia1_Array2[1] = 20;
        ia1_Array2[2] = 30;
        
        System.out.println("Array : " + ia1_Array2[0]);
        System.out.println("Array : " + ia1_Array2[1]);
        System.out.println("Array : " + ia1_Array2[2]);
        
        int i1_Array2 = 10;
        int i2_Array2 = i1_Array2;
        
        System.out.println("i1 : " + i1_Array2);
        System.out.println("i2 : " + i2_Array2);
        
        i1_Array2 = 20;
        
        System.out.println("i1 : " + i1_Array2);
        System.out.println("i2 : " + i2_Array2);
        
        int[] ia2_Array2 = ia1_Array2;
        System.out.println("Array2 : " + ia2_Array2[0]);
        System.out.println("Array2 : " + ia2_Array2[1]);
        System.out.println("Array2 : " + ia2_Array2[2]);
        
        ia1_Array2[0] = 100;
        
        System.out.println("Array1 : " + ia1_Array2[0]);
        System.out.println("Array2 : " + ia2_Array2[0]);
        
        
        System.out.printf("\n---------------------------------------\n");
        System.out.printf("ArrayEx03\n\n\n");
        
        //선언과 생성
        System.out.println("선언과 생성(값을 모름)");
        int[] ia1_Array3 = new int[3];        
        ia1_Array3[0] = 10;
        System.out.println(ia1_Array3[0]);
        
        //선언과 생성, 초기화
        System.out.println("선언과 생성, 초기화");
        int[] ia2_Array3 = new int[] {10, 20, 30};
        System.out.println(ia2_Array3[0]);
        
        System.out.println("최대 단축");
        int[] ia3_Array3 = {10, 20, 30};
        System.out.println(ia3_Array3[0]);
        
        System.out.println("ia3_Array3의 크기");
        System.out.println(ia3_Array3.length);
        
        
        System.out.println("반복문을 이용한 출력");
        for(int i = 0; i < ia3_Array3.length; ++i)
            System.out.println(ia3_Array3[i]);
            
        //실행시 나는 에러 => 런타임에러 <> 컴파일에러
        
        char[] ca_Array3 = new char[3];
        for(int i = 0; i < ca_Array3.length; ++i)
        {
            ca_Array3[i] = (char)('A' + i);            
        }
        
        for(int i = 0; i < 4; ++i)
        {
            if(ca_Array3.length <= i )
            {
                System.out.println("Exception in thread \"main\" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3\n\tat Day07_Java.main(Day07_Java.java:449)");// :p
                break;
            }                            
            System.out.printf("%d 번째 요소 : %c\n", i, ca_Array3[i]);//런타임 에러
        }
        

        System.out.printf("\n---------------------------------------\n");
    }
}