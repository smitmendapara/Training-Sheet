import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo
{
    public static void main(String[] args)
    {
        try
        {
            StudentDao studentDao = new StudentDao();

            Student student = studentDao.getStudent(1);

            if (student != null)
            {
                System.out.println(student.name);
            }
            else
            {
                System.out.println("failed to retrieve studnet info...");
            }


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}

class StudentDao
{
    public Student getStudent(int id)
    {
        try
        {
            String query = "select name from student where id=" + id;

            Student student = new Student();

            student.id = id;

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "Password_123");

            if (connection != null && !connection.isClosed())
            {
                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(query);

                //resultSet.next();

                while (resultSet.next())
                {
                    student.name = resultSet.getString(1);

                    String data = resultSet.getInt(1) + " " + resultSet.getString(2);

                    System.out.println(data);
                }


            }

            return student;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }
}

class Student
{
    int id;
    String name;
}
