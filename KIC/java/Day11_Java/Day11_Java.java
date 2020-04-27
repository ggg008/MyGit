import java.util.Arrays;
import java.util.List;

// Custom Package
import com.PackB;
import com.exam.test.PackC;
import com.naver.Day11_Student;


public class Day11_Java{

    int aa(){
        return 0;
    }

    public static void main(String[] args) 
    {   
        System.out.printf("\n---------------------------------------\n");
        System.out.printf("Day11_Java");
        
        List argsList = Arrays.asList(args);
        
        System.out.printf("\n---------------------------------------\n");

        System.out.printf("Shape");        
        if( argsList.contains("Shape") || argsList.contains("all") )
        {
            System.out.printf("\n\n\n");

            Circle circle = new Circle(new Point(150, 0), 50);
            circle.draw();
        }
        System.out.printf("\n---------------------------------------\n");

        System.out.printf("ObjectArrayEx01");        
        if( argsList.contains("ObjectArrayEx01") || argsList.contains("all") )
        {
            System.out.printf("\n\n\n");

            int[] ia = new int[3];
            ia[0] = 10;
            ia[1] = 20;
            ia[2] = 30;

            
            Book book0 = new Book("Yava", "김길동", 300);
            // Book book1 = new Book("JSP", "박문수", 2000);
            // Book book2 = new Book("spring", "이몽룡", 1000);
            
            // Book[] bookArray = new Book[3];
            // bookArray[0] = book0;
            // bookArray[1] = book1;
            // bookArray[2] = book2;

            Book[] bookArray = {
                new Book("Java", "홍길동", 3000),
                new Book("JSP", "박문수", 2000),
                new Book("spring", "이몽룡", 1000)
            };

            System.out.println("클래스의 참조를 확인");
            System.out.println(bookArray.length );
            System.out.println(book0.title );
            System.out.println(bookArray[0].title);            
            System.out.println();
            System.out.println("주소");
            System.out.println(book0);
            System.out.println(bookArray[0]);
            System.out.println(bookArray);
            System.out.println(ia);
            
            Circle[] cArray = new Circle[1];
            System.out.println(cArray);
            System.out.println(cArray[0]);

            System.out.println();
            System.out.println("for");            
            for(int i = 0; i < bookArray.length; ++i)
            {
                System.out.println(bookArray[i].title + " " + bookArray[i].author);
            }
            
            System.out.println();
            System.out.println("simple for");
            for(Book book : bookArray)
            {
                System.out.println(book.title + " " + book.author);
            }


        }
        System.out.printf("\n---------------------------------------\n");

        System.out.printf("PackageMain");        
        if( argsList.contains("PackageMain") || argsList.contains("all") )
        {
            System.out.printf("\n\n\n");

            PackA pA = new PackA();
            System.out.println(pA.name);
            
            // com.PackB pB = new com.PackB();            
            PackB pB = new PackB();            
            System.out.println(pB.name);

            // com.exam.test.PackC pC = new com.exam.test.PackC();            
            PackC pC = new PackC();            
            System.out.println(pC.name);            
        }
        System.out.printf("\n---------------------------------------\n");

        System.out.printf("StudentMain");        
        if( argsList.contains("StudentMain") || argsList.contains("all") )
        {
            System.out.printf("\n\n\n");
            
            Day11_Student stu = new Day11_Student();
            stu.setHakbun(11993);
            stu.setName("홍기동");
            stu.setAge(23);
            stu.setHeight(180);
            
            System.out.println( stu.getHakbun()+"/"+stu.getName()+"/"+stu.getAge()+"/"+stu.getHeight());

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


//-------------------------------------------------------------------------------//

//-------------------------------------------------------------------------------//


class Shape{
    String color = "Black";

    void draw(){
        System.out.println("[color = " + color + "]");
    }
}

class Point {
    int x;
    int y;

    Point(){
        this(0, 0);
    }

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    String getXY(){
        return "(" + x + ", " + y + ")";
    }
}

// is ~a : Shape
class Circle extends Shape{
    // has ~a
    Point center;
    int r;

    Circle(){
        this(new Point(0, 0), 100);
    }

    Circle(Point center, int r){
        this.center = center;
        this.r = r;
    }

    void draw()
    {
        System.out.println("[center = " + center.x + ", " + center.y +"]");
    }
}

class Book{
    String title;
    String author;
    int price;

    Book(String title, String author, int price)
    {
        this.title = title;
        this.author = author;
        this.price = price;
    }
}