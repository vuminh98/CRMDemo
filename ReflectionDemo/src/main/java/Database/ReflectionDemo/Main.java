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
        
        
        //asdjasjhdjkaskjdhjashjdhasjkhjkdhajhdjahjskdhjkashjkdhjkashjkdhkashdkashkjdhkasjhdjkhkasd
    }
}
