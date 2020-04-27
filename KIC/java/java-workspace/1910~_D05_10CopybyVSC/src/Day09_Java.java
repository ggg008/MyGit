import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//실행클래스
public class Day09_Java{
    public static void main(String[] args) 
    {
        System.out.printf("\n---------------------------------------\n");
        System.out.printf("Day09_Java");

        List argsList = Arrays.asList(args);
        
        System.out.printf("\n---------------------------------------\n");
        
        
        System.out.printf("MethodMain");        
        if(argsList.contains("MethodMain")
        || argsList.size() <= 0 
        )
        {
            System.out.printf("\n\n\n");
            Day09_Method dm1 = new Day09_Method();
            
            //메서드 호출
            dm1.doTest1();
            dm1.doTest2(888);
            dm1.doTest2(999);

            dm1.doTest3(111, 222);
            
            // int result = dm1.doTest4(222, 333);
            System.out.println("doTest4 result : " + dm1.doTest4(222, 333));
            dm1.imUtillMethod(999);
            System.out.println(dm1.imUtillMethod2(888));

            dm1.imCalcMethod(9, "/", 3);
            dm1.imCalcMethod(1, "x", 8);
            dm1.imCalcMethod(2, "-", 8);

        }
        System.out.printf("\n---------------------------------------\n");

        
        System.out.printf("MemberMain");   
        if(argsList.contains("MemberMain")
        || argsList.size() <= 0 )
        {
            System.out.printf("\n\n\n");     
            
            Day09_Method dm2 = new Day09_Method();

            //자동으로 초기화됌을 확인
            System.out.println(dm2.iVal);
            dm2.iVal = 10;
            System.out.println(dm2.iVal);

            System.out.println(dm2.cVal);
            dm2.cVal = 100;
            System.out.println(dm2.cVal);

            //지역변수 : 초기화 안했을시 에러
            dm2.doVal1();

            dm2.doMember2Test1();
            dm2.doMember2Test2();
            //static과 멤버변수의 메모리 공간이 다름을 유의
            Day09_Method.doMember2Test2();
        }
        System.out.printf("\n---------------------------------------\n");

        
        System.out.printf("OverloadingMain");   
        if(argsList.contains("OverloadingMain")
        || argsList.size() <= 0 )
        {
            System.out.printf("\n\n\n");            

            Day09_Method dm_OM = new Day09_Method();
            dm_OM.doOverloadingTest1();
            dm_OM.doOverloadingTest1(1);
            dm_OM.doOverloadingTest1(1.0);
            dm_OM.doOverloadingTest1(1, 1.0);
            dm_OM.doOverloadingTest1(1.0, 1);

            dm_OM.walk();
            dm_OM.walk(100);
            dm_OM.walk(100, "cm");

        }
        System.out.printf("\n---------------------------------------\n");

        System.out.printf("VariableArgument");  
        if(argsList.contains("VariableArgument")
        || argsList.size() <= 0 )
        {
            System.out.printf("\n\n\n");        
            
            Day09_Method dm_VA = new Day09_Method();

            dm_VA.doVariableArgument2(10);
            dm_VA.doVariableArgument2(10, 20);
            dm_VA.doVariableArgument2(10, 20, 30);
        }
        System.out.printf("\n---------------------------------------\n");

        System.out.printf("GuGuDan");  
        if(argsList.contains("GuGuDan")
        || argsList.size() <= 0 )
        {
            System.out.printf("\n\n\n");    
            
            Day09_Method dm_GG = new Day09_Method();
            dm_GG.doGuGudan(2, 4, 6, 5, 7);            
        }
        System.out.printf("\n---------------------------------------\n");

        System.out.printf("ConstructorMain");  
        if(argsList.contains("ConstructorMain")
        || argsList.size() <= 0 )
        {
            System.out.printf("\n\n\n");         
            
            // Constructor c_cm = new Constructor();
            Constructor c_cm = new Constructor("new data");
            System.out.println(c_cm.data2);

            
        }
        System.out.printf("\n---------------------------------------\n");

        System.out.printf("ThisExMain");  
        if(argsList.contains("ThisExMain")
        || argsList.size() <= 0 )
        {
            System.out.printf("\n\n\n");    
            
            ThisEX te = new ThisEX("아아아");
            System.out.println(te);//주소출력
            System.out.println(te.name);

            te.doTest(10);
            
            
            // Timer t = new Timer();
            // TimerTask tt = new TimerTask()
            // {
            //     int cnt = 5;
            //     @Override
            //     public void isRun() 
            //     {
            //         // TODO Auto-generated method stub
            //         if(0 < cnt)
            //         {
            //             System.out.println("콜 타이머");
            //             --cnt;
            //         }
            //         else
            //         {
            //             t.cancel();
            //         }
            //     }
            // };
            // t.schedule(tt, 500, 1000);//타이머, 시작전 딜레이, 호출구간


        }
        System.out.printf("\n---------------------------------------\n");

        System.out.printf("GoblinBattle");  
        if(argsList.contains("GoblinBattle"))
        {
            System.out.printf("\n\n\n");    

            Random dice = new Random();
            

            Goblin gob1 = new Goblin("야생의 고블린", 50);
            int myHp = 100;
            boolean isRun = false;

            System.out.printf("%s이 나타났다!\n", gob1.name);
            Scanner scComand = new Scanner(System.in);
            battle : while(0 < myHp && 0 < gob1.hp )
            {
                System.out.printf("\n내 체력: %d, 고블린의 체력 %d\n", myHp, gob1.hp);
                System.out.println("어떻게 할까? 커맨드 공격 : A, 도망 : E");
                switch (scComand.nextLine()) 
                {
                    case "A":
                    case "a":
                        var myAtk = dice.nextInt(50);
                        if(myAtk == 0)
                            System.out.println("빗나갔다..");
                        else if(30 < myAtk)
                        {
                            gob1.hp -= myAtk;
                            System.out.printf("회심의 일격!!!! 데미지 %d!!!\n", myAtk);
                        }
                        else
                        {
                            gob1.hp -= myAtk;
                            System.out.printf("한방 먹여줬다! 데미지 %d\n", myAtk);
                        }
                        break;
                    case "E":
                    case "e":
                        if(5 < dice.nextInt(10))
                        {
                            isRun = true;
                            break battle;
                        }
                        else
                        {
                            System.out.println("실패했다..");
                        }
                        break;
                
                    default:
                        System.out.println("알수없는 커맨드");
                        continue;                        
                }
                int gobAtk = dice.nextInt(50);
                if(gob1.hp <= 0)
                    continue;
                else if(gobAtk == 0)
                    System.out.println("피했다!");
                else if(30 < gobAtk)
                {
                    myHp -= gobAtk;
                    System.out.printf("고블린의 강공격! 데미지 %d!!! 이건 너무 아프다...\n",  gobAtk);
                }
                else
                {
                    myHp -= gobAtk;
                    System.out.printf("고블린의 공격! 데미지 %d!! 아프다!\n",  gobAtk);
                }
            }
            scComand.close();

            if(isRun)
            {
                System.out.println("겨우 도망쳤다.");
            }
            else if(myHp <= 0)
            {
                System.out.println("죽었다...");
            }
            else
            {
                System.out.println("고블린을 물리쳤다!");
            }
            
        }
        System.out.printf("\n---------------------------------------\n");
    }  

}

class Constructor
{

    String data1 = "데이터";
    String data2;

    Constructor()
    {
        System.out.println("default initializer");
    }

    Constructor(String strData2)
    {
        System.out.println("initializer");
        data2 = strData2;
    }
}

class ThisEX
{
    String name;

    ThisEX(){
        System.out.println("ThisEx() 기본 생성자 호출");
    }

    ThisEX(String name)
    {
        this();//생성자를 호출하는 this
        System.out.println("this : " + this);//내 주소를 보여줌
        this.name = name;
        // this(); //이건안됌 무조건 첫줄에 선언 : 매우제한적
    }

    void doTest()
    {
        System.out.println("call doTest()");
    }

    void doTest(int a)
    {
        doTest();
        System.out.println("call doTest(int a)");
    }

}

class Goblin{

    String name;
    int hp;

    Goblin(String name, int hp)
    {
        this.name = name;
        this.hp = hp;
    }
}