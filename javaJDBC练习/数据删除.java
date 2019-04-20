package JDBC.练习;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class 数据删除 {
    public static void main(String[] args) {
        数据删除 s = new 数据删除();
        s.delect();
    }
    public void delect(){
        Scanner sc = new Scanner(System.in);
        Connection connection = null;
        String SQL = new String();
        String s = new String();
        int i =0;
        try {
            connection = 数据库连接.testDriverManager();
            Statement statement = connection.createStatement();
            System.out.print("请输入学生的考号:");
            s = sc.next();
            SQL = "DELETE FROM zhangao.examstudent WHERE ExamCard ='"+s+"'";
            System.out.println(SQL);
            i = statement.executeUpdate(SQL);
        } catch (Exception e) {
           System.out.println("查无此人！请重新进入程序！");
        }finally {
            if (sc!=null){
                sc.close();
            }
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        if (i>0) {
            System.out.println("删除成功！");
        }else {
            System.out.println("查无此人！请重新进入程序！");
        }
    }
}
