package JDBC.练习;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class 数据查询 {
    public static void main(String[] args) {
        数据查询 s = new 数据查询();
        s.select();
    }
    //@org.junit.Test
    public void select(){

        Scanner sc = new Scanner(System.in);
        int ID =0;
        int i =0;
        String s;
        String select;
        String SQL = new String();
        int Type  = 0;
        String IDCard = new String();
        String ExamCard= new String();
        String StudentName= new String();
        String Location= new String();
        int Grade =0;
        ResultSet resultSet = null;
        Connection connection =null;
        try {
            connection = 数据库连接.testDriverManager();
            Statement statement = connection.createStatement();
            System.out.println("请选择要输入的类型");
            System.out.println("    a:准考证号");
            System.out.println("    b:身份证号");
            s = sc.next();
            if ((!s.equals("a"))&&(!s.equals("b"))){
                System.out.println("您输入的有误，请重新进入程序！");
            }
            if (s.equalsIgnoreCase("a")){
                System.out.print("请输入准考证号：");
                select = sc.next();
                SQL = "SELECT FlowID,Type,IDCard,ExamCard,StudentName,Location,Grade FROM zhangao.examstudent WHERE ExamCard ='"+select+"';";
                System.out.println(SQL);
            }
            if (s.equalsIgnoreCase("b")){
                System.out.print("请输入身份证号");
                select = sc.next();
                SQL = "SELECT FlowID,Type,IDCard,ExamCard,StudentName,Location,Grade FROM zhangao.examstudent WHERE IDCard ='"+select+"';";
            }
            resultSet = statement.executeQuery(SQL);
            //System.out.println(resultSet.next());
        } catch (Exception e) {
            System.out.println(11111);
            e.printStackTrace();

        }
        try {
            while (resultSet.next()){
                ID =resultSet.getInt("FlowID");
                Type = resultSet.getInt("Type");
                IDCard = resultSet.getString("IDCard");
                ExamCard = resultSet.getString("ExamCard");
                StudentName = resultSet.getString("StudentName");
                Location = resultSet.getString("Location");
                Grade = resultSet.getInt("Grade");
                i = 1;
            }
            if (i ==1) {
                System.out.println("流水号：" + ID);
                System.out.println("四级/六级：" + Type);
                System.out.println("身份证号："+IDCard);
                System.out.println("准考证号："+ExamCard);
                System.out.println("学生姓名："+StudentName);
                System.out.println("区域："+Location);
                System.out.println("成绩："+Grade);
            }
            if ( i == 0){
                System.out.println("查无此人！");
            }
        } catch (SQLException e) {
            System.out.println("查无此人！");
        }
        finally {
            if (resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
    }

}
