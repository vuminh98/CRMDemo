package Database.ReflectionDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Hello world!
 *
 */
public class Main {
    public static void main( String[] args ) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
        Class carClass = Car.class;
        
        Constructor constructor = carClass.getConstructor(String.class,int.class,String.class,boolean.class);
        //getConstructor: trả về đối tượng constructor tương ứng với số lượng tham số truyền vào
        
        Car car = (Car) constructor.newInstance("Porsche",2,"Gray",true);
        // newInstance: tạo mới 1 đối tượng từ class Car
        
        System.out.println(car);// Car [name=Porsche, quantity=2, color=Gray, isAvaiable=true]
        
        Method method = carClass.getMethod("buy");
        method.invoke(car); //Price: 500$
        
        Method method2 = carClass.getDeclaredMethod("sell");
        method2.setAccessible(true);
        method2.invoke(car);// Price : 300$
        
        Field color = carClass.getDeclaredField("color");
        color.setAccessible(true);
        //setAccessible: thiết lập quyền truy cập của 1 trường, phương thức
        color.set(car, "blue");
        System.out.println(car); //Car [name=Porsche, quantity=2, color=blue, isAvaiable=true]
        
        
//        Lớp Field trong Java Reflection được sử dụng để thao tác với các trường (fields) của một đối tượng. 
//        Với lớp Field, bạn có thể lấy ra giá trị của một trường, thiết lập giá trị cho một trường, hoặc lấy thông tin về kiểu dữ liệu và phạm vi truy cập của trường. 
//        Để làm việc với một trường cụ thể, bạn có thể sử dụng phương thức getDeclaredField() để lấy đối tượng Field tương ứng với trường đó.
        
//        Lớp Method trong Java Reflection được sử dụng để thao tác với các phương thức (methods) của một đối tượng. 
//        Với lớp Method, bạn có thể gọi một phương thức cụ thể, lấy thông tin về tên phương thức, kiểu trả về và tham số của phương thức đó. 
//        Để làm việc với một phương thức cụ thể, bạn có thể sử dụng phương thức getDeclaredMethod() để lấy đối tượng Method tương ứng với phương thức đó.
        
        
    }
}
