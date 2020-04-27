import java.util.Random;
import java.util.Scanner;

public class Day06_Java{
    public static void main(String[] args) {
        
        System.out.printf("\n---------------------------------------\n");
        System.out.printf("Day06_Java");
        System.out.printf("\n---------------------------------------\n");                
        System.out.printf("OperEx01\n\n\n");//연산자

        //1.5 몫만 출력
        System.out.println(3/2);
        
        int i1_Oper1 = 3;
        double d1_Oper1 = 2;
                
        // 정수로 연산하면 (산술연산자) 정수 => 정수
        // 실수로 연산하면 (산술연산자) 실수 => 실수
        System.out.println(i1_Oper1 / d1_Oper1);//1.5
        System.out.println(i1_Oper1 / 2.0);//1.5
        

        System.out.printf("\n---------------------------------------\n");                
        System.out.printf("OperEx02\n\n\n");
        
        //% : 나누고 나머지 == modulus 연산

        //수를 그룹화
        // % 2 : 짝수 / 홀수 (즉, 짝/홀수 구분할때 쓰기 용이하다)
        System.out.println(1 % 2);
        System.out.println(2 % 2);
        System.out.println(3 % 2);
        System.out.println(4 % 2);
        System.out.println(37 % 5);//2
        System.out.println(7 % 4);//3

        System.out.printf("\n---------------------------------------\n");    
        System.out.printf("OperEx03\n\n\n");            

        int i1_Oper3 = 10;
        // int iOper3_2 = i1_Oper3 + 10;
        // i1_Oper3 = i1_Oper3 + 10;
        i1_Oper3 += 20;

        System.out.println(i1_Oper3);
        
        i1_Oper3 -= 10;
        System.out.println(i1_Oper3);
        i1_Oper3 *= 10;
        System.out.println(i1_Oper3);
        i1_Oper3 /= 10;
        System.out.println(i1_Oper3);
        i1_Oper3 %= 2;
        System.out.println(i1_Oper3);


        System.out.printf("\n---------------------------------------\n");   
        System.out.printf("OperEx04\n\n\n");                         

        int i1_Oper4 = 10;
        //1 증가
        i1_Oper4 = i1_Oper4 - 1;
        ++i1_Oper4;

        System.out.printf("i1_Oper4 : %d\n", i1_Oper4);
        

        System.out.printf("\n---------------------------------------\n");   
        System.out.printf("OperEx05\n\n\n");                         

        int a1_Oper5 = 10;
        int a2_Oper5 = 10;
        
        // 연산자 우선순위
        // ++ -> =
        int b1_Oper5 = ++a1_Oper5;
        // = -> ++
        int b2_Oper5 = a2_Oper5++;
        
        
        System.out.printf("b1_Oper5 : %d\n", b1_Oper5);
        System.out.printf("b2_Oper5 : %d\n", b2_Oper5);
        
        System.out.printf("a1_Oper5 : %d\n", a1_Oper5);
        System.out.printf("a2_Oper5 : %d\n", a2_Oper5);
        
        System.out.printf("\n---------------------------------------\n");           
        System.out.printf("OperEx06\n\n\n");                         
        int a1_Oper6 = 10;
        int b1_Oper6 = 5;

        System.out.println( a1_Oper6 == b1_Oper6 );
        System.out.println( a1_Oper6 != b1_Oper6 );

        //p98
        System.out.println('A' > 'B');
        System.out.println('A' == 65);
        System.out.println(3 == 3.0);

        System.out.println(0.1 + " : " + 0.1f + " : " + (0.1 == 0.1f));
        System.out.println(0.5 + " : " + 0.5f + " : " + (0.5 == 0.5f));
        double d1_Oper6 = 0.1;
        float f1_Oper6 = 0.1f;

        System.out.println((int)(d1_Oper6* 10) == (int)(f1_Oper6*10));
        System.out.println((float)d1_Oper6 == f1_Oper6);

        String s1_Oper6 = new String("Hello");
        String s2_Oper6 = new String("Hello");
        System.out.println((s1_Oper6 == s2_Oper6)/*참조비교 이므로 */ + " : " + s1_Oper6.equals(s2_Oper6)/*값비교*/);

        //p101
        int a2_Oper6 = 10;
        int b2_Oper6 = 20;
        //비트연산자(원)
        System.out.println((a2_Oper6 += 10) > 15 | (b2_Oper6 -= 10) > 15);
        System.out.println("a2_Oper6 = " + a2_Oper5 + ", b2_Oper6 = " + b2_Oper6);
        
        a2_Oper6 = 10;
        b2_Oper6 = 20;
        //짧은 연산 = short circuit (전연산자로 인해 결과가 결정될경우 후연산자는 연산을 하지않는다)))
        //숏서킷 : 비트연산자 발전형  
        System.out.println((a2_Oper6 += 10) > 15 || (b2_Oper6 -= 10) > 15);
        System.out.println("a2_Oper6 = " + a2_Oper5 + ", b2_Oper6 = " + b2_Oper6);        
        System.out.printf("\n---------------------------------------\n");   
        System.out.printf("OperEx07\n\n\n");    
        
        System.out.printf("\n---------------------------------------\n");   
        System.out.printf("OperEx08\n\n\n");    
        
        //삼항연산자
        //(비교연산자 or 논리연산자) ? 참 : 거짓 
        String sResult_Oper8 = (10 % 2 == 0) ? "짝수" : "홀수";
        System.out.println(sResult_Oper8);

        System.out.printf("\n---------------------------------------\n");   
        System.out.printf("OperEx09\n\n\n");//문자열 연결 p69
        
        System.out.println("1" + 1 + 1);// 111 문자열로 시작하면 문자형으로 타입변환에 유의!
        System.out.println(1 + "1" + 1);// 111
        System.out.println(1 + 1 + "1");// 21 문자열로 시작안했을시는 초기형은 인티저

        System.out.println(1 + 1 + "1" + 1 + 1);// 2111 인티저가 문자형으로 바뀌었음을 확인

        System.out.printf("\n---------------------------------------\n");    
        System.out.printf("ConditionEx01\n\n\n");

        System.out.println("start");
        
        //단순조건
        if( 5 > 3 ){
            //참일때 실행하는 문장
            System.out.println("so big");
        }
        System.out.println("end");

        System.out.printf("\n---------------------------------------\n");      
        System.out.printf("ConditionEx02\n\n\n");

        System.out.println("start");        
        //조건
        if( 5 < 3 ){
            //참일때 실행하는 문장
            System.out.println("big");
        }
        else{
            //거짓일때 실행하는 문장
            System.out.println("small");            
        }
        System.out.println("end");

        System.out.printf("\n---------------------------------------\n");  
        System.out.printf("ConditionEx03\n\n\n");

        int i_Cond3 = 10;

        // i_Cond3의 값이 짝수 홀수 구분하여 출력
        System.out.printf("i_Cond3의 값은 %s.\n", (i_Cond3 % 2 == 0) ? "짝" : "홀");    
        
        // String result_Cond3 = (i_Cond3 % 2 == 0) ? "짝" : "홀";
        // System.out.println(result_Cond3);
        
        System.out.printf("\n---------------------------------------\n");    
        System.out.printf("ConditionEx04\n\n\n");  

        //i 5와 10사이에 있으면 "영역내" 그렇지 않으면 "영역외"
        java.util.Random random_Cond4 = new java.util.Random();
        int i_Cond4 = random_Cond4.nextInt(100);

        System.out.printf("i_Cond4의 랜덤값은 %d이며 %s이다\n", 
            i_Cond4, (5 <= i_Cond4 && i_Cond4 <= 10) ? "영역\"내\"" : "영역\"외\""); 

        System.out.printf("\n---------------------------------------\n");  
        System.out.printf("ConditionEx05\n\n\n");  

        int i_Cond5 = 8;
        String s2_Cond5 = new String();
        if(i_Cond5 >= 6){
            s2_Cond5 += "if1방문 ";
            if(i_Cond5 >= 9){
                s2_Cond5 += "if2방문 ";
                System.out.println("BB" + " " + s2_Cond5);
           }
            else{
                s2_Cond5 += "else2방문 ";       
                System.out.println("BA" + " " + s2_Cond5);
           }
        }
        else{
            s2_Cond5 += "else1방문 "; 
            if(i_Cond5 >= 3){  
                s2_Cond5 += "if3방문 ";              
                System.out.println("AB" + " " + s2_Cond5);       
            }
            else{                
                s2_Cond5 += "else3방문 "; 
                System.out.println("AA" + " " + s2_Cond5);
           }
        }

        System.out.printf("\n---------------------------------------\n");   
        System.out.printf("ConditionEx06\n\n\n");   
        //점수를 이용해서 학점
        /*
            90점 이상 -A
            80점 이상 -B
            70점 이상 -C
            60점 이상 -D
            ETC      -F
        */

        int iScore = random_Cond4.nextInt(6);
        if(0 < iScore)        
            System.out.printf("당신의 연속킬수는 %d입니다. %s!\n", iScore, 
            5 <= iScore ? "펜타킬" : 
                (4 <= iScore ? "쿼드라킬" : 
                    (3 <= iScore ? "트리플킬" : 
                        (2 <= iScore ? "더블킬" : "퍼스트블러드")
                    )
                )
            ); 
        else
            System.out.printf("당신의 킬수는 %d입니다!", iScore);

        
            
        System.out.printf("\n---------------------------------------\n");  
        System.out.printf("ConditionEx07\n\n\n");   
            
            
        // 선택적 if
        // if("조건")
        // else if("조건")
        if(iScore >= 5){
            System.out.printf("당신의 킬수는 %d입니다.\n", iScore); 
        }
        else if(iScore >= 4){
            System.out.printf("당신의 킬수는 %d입니다.\n", iScore); 
        }
        else if(iScore >= 3){
            System.out.printf("당신의 킬수는 %d입니다.\n", iScore); 
        }
        else if(iScore >= 2){
            System.out.printf("당신의 킬수는 %d입니다.\n", iScore); 
        }
        else if(iScore >= 1){
            System.out.printf("당신의 킬수는 %d입니다.\n", iScore); 
        }
        else{
            System.out.printf("당신의 킬수는 %d입니다.\n", iScore); 
        }

        System.out.printf("\n---------------------------------------\n");
        System.out.printf("ConditionEx08\n\n\n");
        /*
        i 를 4로 나눈 나머지가 
            0 이면  -A
            1 이면  -B
            2 이면  -C
            3 이면  -D
        */
        int i_Cond8 = random_Cond4.nextInt(11);
        int i2_Cond8 = random_Cond4.nextInt(11);
        int iResult_Cond8 = i_Cond8 % i2_Cond8;

        System.out.printf("i_Cond8 값은 %d고 i2_Cond8의 값은 %d이며, \ni_Cond8 %% i2_Cond8의 값은 %d이다. 적절한 알파벳은 %s!\n", 
        i_Cond8, i2_Cond8, iResult_Cond8,
            (iResult_Cond8 == 0 ? "A" : 
                (iResult_Cond8 == 1 ? "B" : 
                    (iResult_Cond8 == 2 ? "C" : 
                        (iResult_Cond8 == 3 ? "D" : "F")
                    )
                )
            )
        ); 

        System.out.printf("\n---------------------------------------\n");  
        System.out.printf("ConditionEx09\n\n\n");

        int data_Cond9 = 10;

        switch(data_Cond9){
            case 10 :
                System.out.println("10");
                break;
            case 20 :
                System.out.println("20");
                break;
            case 30 :
                System.out.println("30");
                break;
            default :
                System.out.println("40");
                break;
        }
        
        System.out.printf("\n---------------------------------------\n");
        System.out.printf("ConditionEx10\n\n\n");

        String data_Cond10 = "10";

        switch(data_Cond10){
            case "10" :
                System.out.println("10");
                break;
            case "20" :
                System.out.println("20");
                break;
            case "30" :
                System.out.println("30");
                break;
            default :
                System.out.println("40");
                break;
        }

        int jumsu = random_Cond4.nextInt(101);
        String sJumsu = new String();

        switch (jumsu/10) {
            case 9:
                sJumsu = "A";
                break;
            case 8:
                sJumsu = "B";
                break;        
            case 7:
                sJumsu = "C";
                break;
            case 6:
                sJumsu = "D";
                break;
            default:
                sJumsu = "F";
                break;
        }
        System.out.printf("점수는 %d, 등급은 %s\n", jumsu, sJumsu);

        Random random1 = new Random();
        int sel = random1.nextInt(4);
        String level = "관리자";

        switch (sel) {
            case 1:
                level = "관리자";
                break;
            case 2:
                level = "운영자";
                break;
            case 3:
                level = "회원";
                break;
            default:
                break;
        }

        String lvStr = "";

        switch (level) {
            case "관리자":
                lvStr += "운영자관리";
                break;            
            case "운영자":
                lvStr += "회원관리";
                break;            
            case "회원":
                lvStr += "글쓰기";
                break;
            default:
                lvStr += "보기";
                break;
        }
        System.out.println("당신의 권한은 : " + lvStr);

        /*
        Scanner sca1 = new Scanner(System.in);
        // int inputIn = sca1.nextInt();
        String inputStr = sca1.nextLine();
        sca1.close();

        System.out.printf("입력한 값은 %s", inputStr);
        */
        
        
        System.out.printf("\n---------------------------------------\n");    
    }
}