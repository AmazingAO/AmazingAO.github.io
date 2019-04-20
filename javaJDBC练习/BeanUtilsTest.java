package JDBC.练习;

import org.apache.commons.beanutils.BeanUtils;

public class BeanUtilsTest {
    @org.junit.Test
    public void testGetProperty()throws Exception{
        Student student = new Student();
        System.out.println(student);
        BeanUtils.setProperty(student,"studentName","涂山红红");
        System.out.println(student);
        System.out.println(BeanUtils.getProperty(student,"studentName"));
    }
    @org.junit.Test
    public void testSetProperty()throws Exception{
        Student student = new Student();
        System.out.println(student);
        BeanUtils.setProperty(student,"studentName","涂山红红");
        System.out.println(student);
    }
}
