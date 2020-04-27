import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;

public class Day10_Java{
    String dataDafault;//main static에서 쓰고싶다면..
    String dataPublic;
    
    Day10_Java(){//기본생성자 오버라이딩
        System.out.println("class Day10_Java 생성자 호출");
    }
    
    Day10_Java(String dataDafault){
        this();
        this.dataDafault = dataDafault;
    }


    void doTest1(){
        dataDafault = "10";//가능
    }

    void setData(String dataDafault, String dataPublic)
    {
        this.dataDafault = dataDafault;
        this.dataPublic = dataPublic;
    }

    public static void main(String[] args) 
    {
        System.out.printf("\n---------------------------------------\n");
        System.out.printf("Day10_Java");
        
        List argsList = Arrays.asList(args);
        
        System.out.printf("\n---------------------------------------\n");

        System.out.printf("MainMethodMain");        
        if( argsList.contains("MainMethodMain") || argsList.contains("all") )
        {
            System.out.printf("\n\n\n");

            Day10_Java dj10 = new Day10_Java();//접근을 위해
            // dataDafault = 10;            
            dj10.dataDafault = "10";
        }
        System.out.printf("\n---------------------------------------\n");

        System.out.printf("Constructor1");        
        if( argsList.contains("Constructor1") || argsList.contains("all") )
        {
            System.out.printf("\n\n\n");
            
            // Day10_Java dj10 = new Day10_Java();// new 생성자 기본
            Day10_Java dj10 = new Day10_Java("man");// new 생성자 오버로딩
            // System.out.println(dataDafault);

            
        }
        System.out.printf("\n---------------------------------------\n");

        System.out.printf("ThisMain");        
        if( argsList.contains("ThisMain") || argsList.contains("all") )
        {
            System.out.printf("\n\n\n");

            Day10_Java dj10 = new Day10_Java();

            dj10.setData("20", "30");

            System.out.println(dj10.dataDafault + " / " + dj10.dataPublic);
            
        }
        System.out.printf("\n---------------------------------------\n");

        System.out.printf("StudentMain");        
        if( argsList.contains("StudentMain") || argsList.contains("all") )
        {
            System.out.printf("\n\n\n");

            Day10_Student s1 = new Day10_Student();
            System.out.println(s1.hakbun + " / " + s1.name);
            
            Day10_Student s2 = new Day10_Student("박문수");
            System.out.println(s2.hakbun + " / " + s2.name);

            Day10_Student s3 = new Day10_Student("002", "이몽룡");
            System.out.println(s3.hakbun + " / " + s3.name);
            
        }
        System.out.printf("\n---------------------------------------\n");

        System.out.printf("CodeBlockMain");        
        if( argsList.contains("CodeBlockMain") || argsList.contains("all") )
        {
            System.out.printf("\n\n\n");

            CodeBlock.staticMethod();

            System.out.println();

            CodeBlock cb = new CodeBlock();

            
        }
        System.out.printf("\n---------------------------------------\n");

       
        System.out.printf("Inheritance");        
        if( argsList.contains("Inheritance") || argsList.contains("all") )
        {
            System.out.printf("\n\n\n");

            Parent parent = new Parent();
            parent.strName = "im parent";
            System.out.println(parent.strName);
            parent.viewParentAddr();

            Child1 c1 = new Child1();
            c1.strName = "im child1";
            System.out.println(c1.strName);
            c1.viewParentAddr();//부모의 메서드를 재사용함을 주목
            c1.viewChild1Addr();
            
            Child2 c2 = new Child2();
            c2.strName = "we child2";
            System.out.println(c2.strName);
            c2.viewParentAddr();
            c2.viewChild2Addr();

            GrandChild gc1 = new GrandChild();
            gc1.strName = "im GrandChild";
            System.out.println(gc1.strName);
            gc1.viewParentAddr();
            gc1.viewChild1Addr();
            gc1.viewGrandChildAddr();

        }
        System.out.printf("\n---------------------------------------\n");

        System.out.printf("Inheritance2");        
        if( argsList.contains("Inheritance2") || argsList.contains("all") )
        {
            System.out.printf("\n\n\n");
            
            GrandChild gc1 = new GrandChild();
            gc1.viewChild1Addr();
            gc1.callSuper();

            System.out.println();
        }
        System.out.printf("\n---------------------------------------\n");

        System.out.printf("SuperMain");        
        if( argsList.contains("SuperMain") || argsList.contains("all") )
        {
            System.out.printf("\n\n\n");

            Child1 c1 = new Child1();
            // c1.method();

            c1.viewParentAddr();
            
            
        }
        System.out.printf("\n---------------------------------------\n");

        System.out.printf("InheritanceMain");        
        if( argsList.contains("InheritanceMain") || argsList.contains("all") )
        {
            System.out.printf("\n\n\n");


            FireCar fireCar = new FireCar();
            fireCar.drive();

            Ambulance ambulance = new Ambulance();
            ambulance.drive();

            //다형성
            System.out.println("다형성");

            Car car = new FireCar();
            car.drive();
            
            car = new Ambulance();
            car.drive();
        }
        System.out.printf("\n---------------------------------------\n");

        System.out.printf("ModifierMain");        
        if( argsList.contains("ModifierMain") || argsList.contains("all") )
        {
            System.out.printf("\n\n\n");
            
            Modifier mod = new Modifier();
            mod.viewData();

            mod.dataDafault = "10";
            mod.dataPublic = "20";
            mod.dataProtected = "30";
            // mod.dataPrivate = "40";

            mod.method1();
            mod.method2();
            mod.method3();
            // mod.method4();

        }
        System.out.printf("\n---------------------------------------\n");

        System.out.printf("ModifierMain02");        
        if( argsList.contains("ModifierMain02") || argsList.contains("all") )
        {
            System.out.printf("\n\n\n");

            Modifier mod = new Modifier();
            mod.setDataPrivate("10");
            System.out.println(mod.getDataPrivate());
            
        }
        System.out.printf("\n---------------------------------------\n");

        System.out.printf("-");        
        if( argsList.contains("-") || argsList.contains("all") )
        {
            System.out.printf("\n\n\n");
            
        }
        System.out.printf("\n---------------------------------------\n");

        
        System.out.printf("MyKey1");        
        if(argsList.contains("MyKey1")
        || argsList.contains("all")
        )
        {
            System.out.printf("\n\n\n");

            /*
            JFrame f = new JFrame();
            f.setSize(300, 200);
            f.setLayout( null );

            
            class key implements KeyListener
            {
                public void keyPressed(KeyEvent e) 
                    {
                        // TODO Auto-generated method stub
                        System.out.println(e);
                    }

                    public void keyReleased(KeyEvent e) 
                    {
                        // TODO Auto-generated method stub
                        
                    }

                    public void keyTyped(KeyEvent e) 
                    {
                        // TODO Auto-generated method stub
                        
                    }   
            }
            f.setVisible(true);
            f.addKeyListener(new key());
            System.out.println("end KeyListener");
            */
                        
        }        

        System.out.printf("\n---------------------------------------\n");       
    }
}

class Day10_Student
{
    String hakbun;
    String name;

    //기본값으로 초기화
    Day10_Student()
    { 
        this("000", "studentMan");
        System.out.println("class Day10_Student 생성자 호출");      
    }

    //데이터를 초기화
    Day10_Student(String hakbun, String name)
    {
        this.hakbun = hakbun;
        this.name = name;
    }

    Day10_Student(String name)
    {
        this("001", name);        
        // this.hakbun = "001";
        // this.name = name;        
    }
}

class CodeBlock
{
    //생성자 보다 빠르다 by JVM
    static
    {
        System.out.println("static block");
    }

    {
        System.out.println("instance block");
    }
    
    CodeBlock(){
        System.out.println("initalizer");        
    }
    
    static void staticMethod()
    {
        System.out.println("static Method");       
    }
    
    //생성자 보다 빠르다
    void instanceMethod()
    {   
        System.out.println("instance Method");       
    }
}

class Parent extends Object//<--명시적으로 표시해도 작동
{
    String strName = "parent";

    Parent(){
        System.out.println("Parent 생성자 호출");
    }
    
    Parent(int a){
        System.out.println("Parent(int a) 생성자 호출");
    }

    final void viewParentAddr(){
        System.out.println("Call viewParentAddr(), my주소 : " + this + "\n");
    }

}

class Child1 extends Parent{
    // String strName = "child1";

    Child1(){
        super(10);//생성자 선택
        System.out.println("Child1 생성자 호출");
    }

    void viewChild1Addr(){
        System.out.println("Call Child1 viewChild1Addr(), my주소 : " + this + "\n");
    }

    // void viewParentAddr(){
    //     System.out.println("Call Child1 viewParentAddr(), my주소 : " + this + "\n");
    // }//final test

    void method()
    {
        // String strName = "method";
        System.out.println("strName : " + strName);
        System.out.println("this.strName : " + this.strName);
        System.out.println("Super.strName : " + super.strName);
    }
}

class Child2 extends Parent{
    String strName;

    Child2(){
        System.out.println("Child2 생성자 호출");
    }

    void viewChild2Addr(){
        System.out.println("Call Child2 viewChild2Addr(), my주소 : " + this + "\n");
    }
}

class GrandChild extends Child1{

    GrandChild(){
        System.out.println("GrandChild 생성자 호출");
    }
    
    void viewGrandChildAddr(){
        System.out.println("Call viewGrandChildAddr, my주소 : " + this + "\n");
    }

    //override
    void viewChild1Addr(){
        System.out.println("Call GrandChild viewChild1Addr, my주소 : " + this + "\n");
    }
    
    void callSuper()
    {
        super.viewChild1Addr();
    }
}

//car클 drive메서드 앰뷸런스, 파이어
class Car {

    void drive(){}
}

class FireCar extends Car{
    void drive(){
        System.out.println("소방차가 이동");
    }
    
}

class Ambulance extends Car{
    void drive(){
        System.out.println("구급차가 이동");
    }
}

class Modifier{
    String dataDafault = "default";
    public String dataPublic = "public";
    protected String dataProtected = "protected";
    private String dataPrivate = "private";

    public void setDataPrivate(String data){
        System.out.println("call setter");
        this.dataPrivate = data;
    }

    public String getDataPrivate(){
        System.out.println("call getter");
        return this.dataPrivate;
    }

    void method1(){
        System.out.println("default");
    }

    public void method2(){
        System.out.println("public");
    }

    protected void method3(){
        System.out.println("protected");
    }

    private void method4(){
        System.out.println("private");
    }

    void viewData(){
        System.out.println(this.dataDafault);
        System.out.println(this.dataPublic);
        System.out.println(this.dataProtected);
        System.out.println(this.dataPrivate);

        this.method1();
        this.method2();
        this.method3();
        this.method4();
    }
}