import day14Class.*;

public class P274VehicleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println();
		System.out.println("자식 클래스의 addFuel");
		
		Vehicle[] vehicles = {new DieselSUV(), new ElectricCar()};
        for(Vehicle v : vehicles)
        {
            v.addFuel();
            v.reportPosition();
        }  
	}

}
