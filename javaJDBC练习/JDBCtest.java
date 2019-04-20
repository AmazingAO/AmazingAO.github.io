package JDBC.练习;

import JDBC.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCtest {
    public static void main(String[] args) {
        JDBCtest js = new JDBCtest();
        //js.testAddNewStudent();
        //js.testGetStudent();
        //js.DelectStudent();
        js.testPreparedStatement();
    }
    public void testPreparedStatement(){
        test1Student student = new test1Student();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        test1Scanf(student);
        try {
            connection = JDBCTools.testDriverManager();
            String SQL = "INSERT into zhangao.table1(name,email,birth) value (?,?,?);";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,student.getName());
            System.out.println(student.getName());
            preparedStatement.setString(2,student.getEmail());
            System.out.println(student.getEmail());
            preparedStatement.setString(3,student.getBirth());
            System.out.println(student.getBirth());
            System.out.println(SQL);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCTools.releaseSource(preparedStatement,connection);
        }

    }
    public void  test1Scanf(test1Student student){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入信息:");
        System.out.println("姓名：");
        student.setName(sc.next());
        System.out.println("邮箱：");
        student.setEmail(sc.next());
        System.out.println("生日：");
        student.setBirth(sc.next());
    }
    public void DelectStudent(){
        String SQL  = DelectSql();
        int i = Delect(SQL);
        PrintfDelect(i);
    }
    public String DelectSql(){
        Scanner sc = new Scanner(System.in);
        String s = new String();
        System.out.println("请输入学号:");
        s=sc.next();
        String SQL = new String();
        SQL = "DELETE FROM zhangao.examstudent WHERE ExamCard ='"+s+"';";
        return SQL;
    }
    public int Delect(String SQL){
        int i = JDBCTools.Delete(SQL);
        return i;
    }
    public void PrintfDelect(int i){
        if (i>0){
            System.out.println("删除成功！");
        }else {
            System.out.println("查无此人，请重新进入程序！");
        }
    }
    public void testAddNewStudent(){
       Student student =getStundetFromConsole();
       addNewStudent(student);
    }
    private Student getStundetFromConsole(){
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        System.out.println("请输入要插入的信息");
        System.out.println("请输入四六级类型");
        student.setType(sc.nextInt());
        System.out.println("请输入身份证号");
        student.setIdCard(sc.next());
        System.out.println("请输入准考证号");
        student.setExamCard(sc.next());
        System.out.println("请输入学生姓名");
        student.setStudentName(sc.next());
        System.out.println("请输入区域");
        student.setLocation(sc.next());
        System.out.println("请输入成绩");
        student.setGrade(sc.nextInt());
        return student;
    }
    public void addNewStudent(Student student){
        String SQL;
        SQL = "insert into zhangao.examstudent (Type,IDCard,ExamCard,StudentName,Location,Grade) value("+"'"+student.getType()+"'"+","+"'"+student.getIdCard()+"'"+","+"'"+student.getExamCard()
                +"'"+","+"'"+student.getStudentName()+"'"+","+ "'"+student.getLocation()+"'"+","+"'"+student.getGrade()+"'"+");";
        JDBCTools.Updata(SQL);
    }
    public void testGetStudent(){
      String s = getSearchTypeFromConsole();
      Student student = searchStudent(s);
      printStudent(student);
    }
    private String getSearchTypeFromConsole(){
        System.out.println("请选择要输入的类型");
        System.out.println("    a:准考证号");
        System.out.println("    b:身份证号");
        Scanner sc = new Scanner(System.in);
        String type = sc.next();
        if (!type.equals("a")&&!type.equals("b")){
            System.out.println("您输入的有误，请重新进入程序！");
            throw new RuntimeException();
        }
        return type;
    }
    private Student searchStudent(String s){
        Student student = new Student();
        Scanner sc = new Scanner(System.in);
        String SQL = new String();
        String select = new String();
        int i = 0;
        if (s.equalsIgnoreCase("a")){
            System.out.print("请输入准考证号：");
            select = sc.next();
            SQL = "SELECT FlowID,Type,IDCard,ExamCard,StudentName,Location,Grade FROM zhangao.examstudent WHERE ExamCard ='"+select+"';";
            System.out.println(SQL);
            i =1;
        }
        if (s.equalsIgnoreCase("b")){
            System.out.print("请输入身份证号");
            select = sc.next();
            SQL = "SELECT FlowID,Type,IDCard,ExamCard,StudentName,Location,Grade FROM zhangao.examstudent WHERE IDCard ='"+select+"';";
            i =1;
        }
        if (i==1){
            student = getStudent(SQL);
            return student;
        }
        else {
            System.out.println("无此查询方法！");
            return null;
        }

    }
    private Student getStudent(String SQL){
      Student student = null;
        Connection connection = null;
        Statement statement =null;
        ResultSet resultSet = null;
        try {
          connection = JDBCTools.testDriverManager();
          statement = connection.createStatement();
          resultSet = statement.executeQuery(SQL);
          if (resultSet.next()){
              student = new Student(resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),
                      resultSet.getString(6),resultSet.getInt(7));
          }
        }catch (Exception e){
          e.printStackTrace();
        }finally {
            JDBCTools.releaseSource(resultSet,statement,connection);
        }
       return student;
    }
    private void printStudent(Student student){
        if (student!=null){
            System.out.println("流水号：" + student.getType());
            System.out.println("身份证号："+student.getIdCard());
            System.out.println("准考证号："+student.getExamCard());
            System.out.println("学生姓名："+student.getStudentName());
            System.out.println("区域："+student.getLocation());
            System.out.println("成绩："+student.getGrade());
        }
        else {
            System.out.println("查无此人！");
        }
    }
}
