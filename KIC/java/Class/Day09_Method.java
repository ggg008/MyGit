//데이터 클래스
public class Day09_Method{
    //메서드 선언
    void doTest1()
    {
        //지역변수
        //제어문
        //실행문
        System.out.println("call doTest1()");
    }
    
    void doTest2(int data1)// argument / parameta / 매개변수
    {
        System.out.println("call doTest2() : " + data1);
    }

    void doTest3(int data1, int data2)
    {
        System.out.println("call doTest3() : " + data1 + ", " + data2);
    }

    //void 리턴이 없다(공허)를 상징하는 예약어
    int doTest4(int data1, int data2)
    {
        System.out.println("call doTest4() : " + data1 + ", " + data2);
        return data1 + data2;
    }

    void imUtillMethod(int timeTable)
    {        
        System.out.println("\ncall imUtillMethod\nI make gugudan\nyou input num : " + timeTable);
        for(int i = 1 ; i <= 9; ++i)
        {
            System.out.println(timeTable + " x " + i + " = " + timeTable * i);
        }
    }

    String imUtillMethod2(int timeTable)
    {        
        String result = "";
        System.out.println("\ncall imUtillMethod2\nI make gugudan\nyou input num : " + timeTable);
        for(int i = 1 ; i <= 9; ++i)
        {
            result += timeTable + " x " + i + " = " + timeTable * i + "\n";
        }
        return result;
    }

    void imCalcMethod(int i1, String oper, int i2)
    {
        System.out.println("\ncall imCalcMethod\nyou input num : " + i1 + ", "+ i2);
        //지역변수 : 반드시 초기화
        //멤버변수 : 자동 초기화
        
        int iResult = 0;              
        switch (oper) {
            case "+":
                iResult = i1 + i2;
                break;
            case "-":
                iResult = i1 - i2;
                break;
            case "x":
                iResult = i1 * i2;
                break;
            case "/":
                iResult = i1 / i2;
                break;
            default:
                System.out.println();
                break;
        }
        System.out.printf("%d %s %d = %d!\n", i1, oper, i2, iResult);        
    }
    
    //지역변수 : 반드시 초기화 
    //멤버변수 : 자동 초기화
    //EX
    //멤버변수
    //인스턴스 멤버변수
    int iVal;
    //클래스 멤버변수
    static int cVal;

    void doVal1()
    {
        //지역변수
        int lVal = 0;
        System.out.println(lVal);

    }

    void doMember2Test1(){
        System.out.println("call doTest1()" );
    }
    
    static void doMember2Test2(){
        // System.out.println("call static doTest2()" + iVal);
    }
    
    void doOverloadingTest1(){
        System.out.println("call doOverloadingTest1()" );
        
    }
    
    void doOverloadingTest1(int a){
        System.out.println("call doOverloadingTest1(int a)" );        
    }
    
    void doOverloadingTest1(double d){
        System.out.println("call doOverloadingTest1(double d)" );        
    }

    void doOverloadingTest1(int a,double d){
        System.out.println("call doOverloadingTest1(int a, double d)" );        
    }

    void doOverloadingTest1(double d, int a){
        System.out.println("call doOverloadingTest1(double d, int a)" );        
    }
    
    // int doOverloadingTest1(double d, int a){
    //     System.out.println("call doOverloadingTest1(double d, int a)" );        
    //     return a;
    // }리턴타입으로는 불가

      

    void walk(){
        // System.out.println("move 100cm");
        walk(100, "cm");
    }

    void walk(int distance)
    {
        // System.out.println("move-" + distance + "cm");
        walk(distance, "cm");
    }

    void walk(int distance, String unit)
    {
        switch(unit)
        {
            case "cm":
                break;
            case "inch":
                distance *= 2.54;
                break;
            default:
                System.out.println("unknown");
                break;
        }
        System.out.println("move~" + distance + "cm");
    }


    void doVariableArgument(int a, int b)
    {
        System.out.println("doTest(int a, int b) 호출");
    }

    //배열화된 데이터로 생성
    void doVariableArgument2(int ... data)
    {
        // System.out.println(data.length);
        for(int inData : data)
        {
            System.out.println(inData);
        }
        System.out.println();
    }

    void doGuGudan(int ... timeTable)
    {
        for(int time : timeTable)
        {
            System.out.printf("\n%d단 시작!\n", time);
            for(int j = 1 ; j <= 9 ; ++j)
            {
                System.out.printf("%2d *%2d = %2d\t", time, j, time * j);
                if(j % 3 == 0)
                {
                    System.out.println();
                }
            }
        }
        System.out.println();
    }

    void doConstuctor()
    {

    }
}
