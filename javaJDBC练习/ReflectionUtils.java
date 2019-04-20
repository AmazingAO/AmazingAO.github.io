package JDBC.练习;

import java.lang.reflect.Field;

public class ReflectionUtils {
    public static void setFieldValue(Object obj,String s1,Object obj1){
        Class clazz = obj.getClass();
        try {
            Object p = clazz.newInstance();
            Field f1 = clazz.getField(s1);
            f1.set(p,obj1);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
