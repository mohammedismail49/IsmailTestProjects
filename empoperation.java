package employeeDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class empoperation {

	public static Connection GetConnection ()
    {
        Connection con = null;
        try
        {
            Class.forName ("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/ismail?useUnicode=true&characterEncoding=utf8","ismail","miz@4499");
            
        } 
        catch (Exception e)
        {
            System.out.println (e);
        }
        return con;
    }

    public static int save(Emp e)
    {
        int status = 0;
        try
        {
            Connection con = empoperation.GetConnection ();
            if(con==null) {
            	System.out.println("****unable to create a connection****");
            }
            PreparedStatement ps =con.prepareStatement ("insert into emp(ename,dept) values (?,?)");
            ps.setString (1, e.getName ());
            ps.setString (2, e.getDept ());
            status = ps.executeUpdate ();
            con.close ();
        } 
        catch (Exception ex)
        {
            ex.printStackTrace ();
        }
        return status;
    }

    public static int update (Emp e)
    {
        int status = 0;
        try
        {
            Connection con = empoperation.GetConnection ();
            PreparedStatement ps = con.prepareStatement ("update emp set ename=?,dept=? where id=?");
            ps.setString (1, e.getName ());
            ps.setString (2, e.getDept ());
            ps.setInt (3, e.getId ());
            status = ps.executeUpdate ();
            con.close ();
        } 
        catch (Exception ex)
        {
            ex.printStackTrace ();
        }
        return status;
    }

    public static int delete (int id)
    {
        int status = 0;
        try
        {
            Connection con = empoperation.GetConnection ();
            PreparedStatement ps =con.prepareStatement ("delete from emp where id=?");
            ps.setInt (1, id);
            status = ps.executeUpdate ();
            con.close ();
        } 
        catch (Exception e)
        {
            e.printStackTrace ();
        }
        return status;
    }

    public static Emp getEmployeeById (int id)
    {
        Emp e = new Emp ();
        try
        {
            Connection con = empoperation.GetConnection ();
            PreparedStatement ps =con.prepareStatement ("select * from emp where id=?");
            ps.setInt (1, id);
            ResultSet rs = ps.executeQuery ();
            if (rs.next ())
         {
             e.setId (rs.getInt (1));
             e.setName (rs.getString (2));
             e.setDept (rs.getString (3));
         }
            con.close ();
        }
        catch (Exception ex)
        {
            ex.printStackTrace ();
           
        }
        return e;
    }

    public static List < Emp > getAllEmployees ()
    {
        List<Emp> list = new ArrayList<Emp>();
        try
        {
            Connection con = empoperation.GetConnection ();
            PreparedStatement ps = con.prepareStatement ("select * from emp");
            ResultSet rs = ps.executeQuery ();
            while (rs.next ())
         {
             Emp e = new Emp ();
             e.setId (rs.getInt (1));
             e.setName (rs.getString (2));
             e.setDept (rs.getString (3));
             list.add (e);
         }
            con.close ();
        }
        catch (Exception e)
        {
            e.printStackTrace ();
        }
        return list;
    }
	
}
