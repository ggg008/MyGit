import java.util.Arrays;
import java.util.List;

//추상 클래스 없는 abstract class : 미완성을 전제하는 클래스(인스턴스화 불가가 목적: 상속전제)
//미완성 메서드를 포함할수 있으므로 인스턴스화가 불가
//상속을 전제
//미완성 메서드를 상속을 통해서 완성 : *부모+자식=완성 == 추상클래스

abstract class Vehicle {
    private int curX, curY;

    public void reportPosition(){
        System.out.printf("현재위치 : (%d, %d)\n", curX, curY);
    }

    // public void addFuel() {
    //     System.out.println("모든 운송 수단은 연료가 필요");        
    // }

    public abstract void addFuel();//미완성 메서드 : {} 없어야 미완성 : addFuel(){}도 구현이다
}

//**실행을 위해선...=> 반드시 메소드 구현하던가 or abstract class화 (즉, 강제구현)
abstract class Car extends Vehicle{
    //승계▼
    public abstract void addFuel();
}

class DieselSUV extends Car{
    @Override
    public void addFuel(){        
        System.out.println("주유소에서 급유");
    }

    public void addFuel2(){
        System.out.println("호출할수 있나?");
    };
}

class ElectricCar extends Car{
    @Override
    public void addFuel(){        
        System.out.println("급속충전");
    }
}

//


interface MyInterface{ //부분 구현 : 추상클래스 <> 전부구현 : 인터페이스(*클래스다)
    //인터페이스가 가질수 있는 너
    //상수
    //추상 메소드

    public static final int MEMBER = 10;
    int MEMBER2 = 10;

    public abstract void method1();    
    void method2();    
}

class MainInterface implements MyInterface{
    public void method1(){
        System.out.println("method 1 호출");            
    }

    // public void method2(){
    //     System.out.println("method 2 호출");            
    // }
} 


public class Day14_JavaEx01{
    public static void main(String[] args) {
        System.out.printf("\n---------------------------------------\n");
        System.out.printf("Day14_Java");
        
        List argsList = Arrays.asList(args);
        
        System.out.printf("\n---------------------------------------\n");

        System.out.printf("VehicleTest");        
        if( argsList.contains("VehicleTest") || argsList.contains("all") )
        {
            System.out.printf("\n\n\n");
            
            System.out.println();
            System.out.println("부모 클래스의 addFuel");
            Vehicle v1 = new Vehicle();
            // v1.addFuel();//추상클래스 선언시 호출 불가            

            /*
            Vehicle[] vehicles = {new DieselSUV(), new ElectricCar()};
            System.out.println();
            System.out.println("자식 클래스의 addFuel");
            for(Vehicle v : vehicles)
            {
                v.addFuel();
                v.reportPosition();
            }  
            */ 
            DieselSUV v2 = new Vehicle();
            
        }
        System.out.printf("\n---------------------------------------\n");

        System.out.printf("MyInterfaceMain");        
        if( argsList.contains("MyInterfaceMain") || argsList.contains("all") )
        {
            System.out.printf("\n\n\n");
            
            // MyInterface mi = new MyInterface();
            MainInterface mi = new MainInterface();

            mi.method1();
            // mi.method2();            

        }
        System.out.printf("\n---------------------------------------\n");

        System.out.printf("-");        
        if( argsList.contains("-") || argsList.contains("all") )
        {
            System.out.printf("\n\n\n");
        }
        System.out.printf("\n---------------------------------------\n");   
                

    }
}
