package JDBC.练习;

import JDBC.JDBCTools;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class 数据插入 {
    public static void main(String[] args) {;
        数据插入 main = new 数据插入();
        try {
            main.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @org.junit.Test
    public void create() throws Exception{
        Connection connection = 数据库连接.testDriverManager();
        Statement statement = connection.createStatement();
        System.out.println("请输入要插入的信息");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入四六级类型");
        int Type = sc.nextInt();
        System.out.println("请输入身份证号");
        String IDCard = sc.next();
        System.out.println("请输入准考证号");
        String ExamCard = sc.next();
        System.out.println("请输入学生姓名");
        String StudentName = sc.next();
        System.out.println("请输入区域");
        String Location = sc.next();
        System.out.println("请输入成绩");
        int Grade = sc.nextInt();
        String SQL = new String();
            SQL = "insert into zhangao.examtudent (Type,IDCard,ExamCard,StudentName,Location,Grade) value("+"'"+Type+"'"+","+"'"+IDCard+"'"+","+"'"+ExamCard+"'"+","+"'"+StudentName+"'"+","+
                    "'"+Location+"'"+","+"'"+Grade+"'"+");";
         System.out.println(SQL);
         statement.executeUpdate(SQL);
        JDBCTools.releaseSource(statement,connection);
    }
}
