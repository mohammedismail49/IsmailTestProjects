package RRC04.AarogyaHospital;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

public class PatientManagement{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
    	System.out.println("\n"+new PatientManagement().printGood()+"Welcome to Aarogya Hospitals\n");

        new PatientManagement().display();
    }

    public void display() throws IOException, SQLException, ClassNotFoundException {
        //enter good morning/evening message
    	

        System.out.println("Choose option from below : \n");

        System.out.println("1. patientRegistration");
        System.out.println("2. view Patient Details");
        System.out.println("3. searchPatientById");
        System.out.println("4. searchByPatientCity");
        System.out.println("5. searchByPatientAge");
        System.out.println("6. searchByPatientRecoveryDate");
        System.out.println("7. deletePatientById\n");

        System.out.println("0. Exit ");

        int option = Integer.parseInt(br.readLine());

        while(true){
            PatientManagement pm = new PatientManagement();
            if(option==1){
                pm.patientRegistration();
                pm.display();
            }
            else if(option==2){
                pm.viewPatientDetails();
                pm.display();

            }
            else if(option==3){
                pm.searchPatientById();
                pm.display();

            }
            else if(option==4){
                pm.searchByPatientCity();
                pm.display();

            }
            else if(option==5){
                pm.searchByPatientAge();
                pm.display();

            }
            else if(option==6){
                pm.searchByPatientRecoveryDate();
                pm.display();

            }
            else if(option==7){
                pm.deletePatientById();
                pm.display();

            }
            else if(option==0){
                break;
            }
            else {
                System.out.println("Invalid input please try again...");
                pm.display();

            }
        }
        //enter ending msg
        System.out.println("Thank you...Take Care...Bye Bye...");

    }

    public void patientRegistration() throws IOException, SQLException, ClassNotFoundException {

// insert patient details into the patient_table

        System.out.println("Enter patient id : ");
        int id = Integer.parseInt(br.readLine());

        System.out.println("Enter patient name : ");
        String patientName = br.readLine();

        System.out.println("Enter patient gender : ");
        String gender = br.readLine();

        System.out.println("Enter patient age : ");
        int age = Integer.parseInt(br.readLine());

        System.out.println("Enter patient city : ");
        String patientCity = br.readLine();

        System.out.println("Enter patient Address  : ");
        String patientAddress = br.readLine();

        System.out.println("Enter guardian Name: ");
        String guardianName = br.readLine();

        System.out.println("Enter guardian Address : ");
        String guardianAddress = br.readLine();

        System.out.println("Enter date Of Admission in the format 'YYYY-MM-DD' : ");
        String dateOfAdmission = br.readLine();

        System.out.println("Enter aadhar Card No : ");
        String aadharCardNo = br.readLine();

        System.out.println("Enter patient Contact No : ");
        String patientContactNo = br.readLine();

        System.out.println("Enter guardian Contact No : ");
        String guardianContactNo = br.readLine() ;

        System.out.println("Enter patient recovered Date in the format 'YYYY-MM-DD' : ");
        String recoveredDate = br.readLine();

        String query = "INSERT INTO PATIENT_TABLE VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?  )";

        PreparedStatement pstmt= createCon.setConnection().prepareStatement(query);

        pstmt.setInt(1 , id);
        pstmt.setInt(2 , age);
        pstmt.setString(3 , patientName);
        pstmt.setString(4 , gender);
        pstmt.setString(5 , patientCity);
        pstmt.setString(6 , patientAddress);
        pstmt.setString(7 , guardianName);
        pstmt.setString(8 , guardianAddress);
        pstmt.setString(9 , dateOfAdmission);
        pstmt.setString(10 , aadharCardNo);
        pstmt.setString(11 , patientContactNo);
        pstmt.setString(12 , guardianContactNo);
        pstmt.setString(13 , recoveredDate);

        int count =pstmt.executeUpdate();
        createCon.setConnection().close();
        if(count>0)
        System.out.println(count+" row/s effected Successfully");
        else System.out.println("Unable to insert data...");

    }


    public void viewPatientDetails() throws SQLException, ClassNotFoundException {
    	
        //print table
    	boolean flag=false;
    	 System.out.println(" Id   "+" "+"Age" +" "+"Patient Name             "
         +" "+"Gender" +" "+"City           "+" "+"Patient Address     "
         +" "+"Guardian Name            " +" "+"Guardian Address    " +" "+"DtOfAdmssn"
         +" "+"Aadhar No   "+" "+"Ptnt Phno "+" "+"Grdn PhNo "
         +" "+"RecoveryDt"+"\n");
    	
        Statement stmt = createCon.setConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM PATIENT_TABLE");

        while(rs.next()){
            //write a code to display column name
            System.out.println(String.format("%5d",rs.getInt(1))+" "+String.format("%3d",rs.getInt(2)) +"  "+String.format("%-25s",rs.getString(3))
                    +" "+String.format("%-6s",rs.getString(4)) +" "+String.format("%-15s",rs.getString(5))+" "+String.format("%-20s",rs.getString(6))
                    +" "+String.format("%-25s",rs.getString(7)) +" "+String.format("%-20s",rs.getString(8)) +" "+String.format("%-10s",rs.getString(9))
                    +" "+String.format("%-12s",rs.getString(10))+" "+String.format("%-10s",rs.getString(11))+" "+String.format("%-10s",rs.getString(12))
                    +" "+String.format("%-10s",rs.getString(13)));
            flag=true;
        }
        rs.close();
        createCon.setConnection().close();
        if(!flag) System.out.println("No data available/unable to fetch data");
    }

    public void searchPatientById() throws SQLException, ClassNotFoundException, IOException {

        System.out.println("Enter patient Id to search...");
        PreparedStatement pstmt =createCon.setConnection().prepareStatement("SELECT * FROM PATIENT_TABLE WHERE id = ?");
        pstmt.setInt(1,Integer.parseInt(br.readLine()));
        ResultSet rs = pstmt.executeQuery();
        boolean flag = false;
        System.out.println(" Id   "+" "+"Age" +" "+"Patient Name             "
                +" "+"Gender" +" "+"City           "+" "+"Patient Address     "
                +" "+"Guardian Name            " +" "+"Guardian Address    " +" "+"DtOfAdmssn"
                +" "+"Aadhar No   "+" "+"Ptnt Phno "+" "+"Grdn PhNo "
                +" "+"RecoveryDt"+"\n");
        
        while(rs.next()){
            //write a code to display column name
            System.out.println(String.format("%5d",rs.getInt(1))+" "+String.format("%3d",rs.getInt(2)) +"  "+String.format("%-25s",rs.getString(3))
                    +" "+String.format("%-6s",rs.getString(4)) +" "+String.format("%-15s",rs.getString(5))+" "+String.format("%-20s",rs.getString(6))
                    +" "+String.format("%-25s",rs.getString(7)) +" "+String.format("%-20s",rs.getString(8)) +" "+String.format("%-10s",rs.getString(9))
                    +" "+String.format("%-12s",rs.getString(10))+" "+String.format("%-10s",rs.getString(11))+" "+String.format("%-10s",rs.getString(12))
                    +" "+String.format("%-10s",rs.getString(13)));
            flag=true;
        }
        rs.close();
        createCon.setConnection().close();
        if(!flag) {
        	System.out.println("Unable to fetch data/data not available");
        }
    }

    public void searchByPatientCity() throws SQLException, ClassNotFoundException, IOException {
        // search patient details by city
    	boolean flag = false;
        System.out.println("Enter patient city to search...");
        PreparedStatement pstmt =createCon.setConnection().prepareStatement("SELECT * FROM PATIENT_TABLE WHERE city =?");
        pstmt.setString(1,br.readLine());
        ResultSet rs = pstmt.executeQuery();
        
        System.out.println(" Id   "+" "+"Age" +" "+"Patient Name             "
                +" "+"Gender" +" "+"City           "+" "+"Patient Address     "
                +" "+"Guardian Name            " +" "+"Guardian Address    " +" "+"DtOfAdmssn"
                +" "+"Aadhar No   "+" "+"Ptnt Phno "+" "+"Grdn PhNo "
                +" "+"RecoveryDt"+"\n");
        
        while(rs.next()){
            //write a code to display column name
            System.out.println(String.format("%5d",rs.getInt(1))+" "+String.format("%3d",rs.getInt(2)) +"  "+String.format("%-25s",rs.getString(3))
                    +" "+String.format("%-6s",rs.getString(4)) +" "+String.format("%-15s",rs.getString(5))+" "+String.format("%-15s",rs.getString(6))
                    +" "+String.format("%-25s",rs.getString(7)) +" "+String.format("%-15s",rs.getString(8)) +" "+String.format("%-10s",rs.getString(9))
                    +" "+String.format("%-12s",rs.getString(10))+" "+String.format("%-10s",rs.getString(11))+" "+String.format("%-10s",rs.getString(12))
                    +" "+String.format("%-10s",rs.getString(13)));
            flag=true;
        }
        rs.close();
        createCon.setConnection().close();
        if(!flag) {
        	System.out.println("Unable to fetch data/data not available");
        }

    }

    public void searchByPatientAge() throws SQLException, ClassNotFoundException, IOException {

        // search patient details by age
    	boolean flag = false;
        System.out.println("Enter patient age between limits to search...");
        System.out.println("Lower age limit : ");
        PreparedStatement pstmt =createCon.setConnection().prepareStatement("SELECT * FROM PATIENT_TABLE WHERE age BETWEEN ? and ?");
        pstmt.setString(1,br.readLine());
        System.out.println("Upper age limit : ");
        pstmt.setString(2,br.readLine());
        ResultSet rs = pstmt.executeQuery();
        
        System.out.println(" Id   "+" "+"Age" +" "+"Patient Name             "
                +" "+"Gender" +" "+"City           "+" "+"Patient Address     "
                +" "+"Guardian Name            " +" "+"Guardian Address    " +" "+"DtOfAdmssn"
                +" "+"Aadhar No   "+" "+"Ptnt Phno "+" "+"Grdn PhNo "
                +" "+"RecoveryDt"+"\n");
        
        while(rs.next()){
            //write a code to display column name
            System.out.println(String.format("%5d",rs.getInt(1))+" "+String.format("%3d",rs.getInt(2)) +"  "+String.format("%-25s",rs.getString(3))
                    +" "+String.format("%-6s",rs.getString(4)) +" "+String.format("%-15s",rs.getString(5))+" "+String.format("%-15s",rs.getString(6))
                    +" "+String.format("%-25s",rs.getString(7)) +" "+String.format("%-15s",rs.getString(8)) +" "+String.format("%-10s",rs.getString(9))
                    +" "+String.format("%-12s",rs.getString(10))+" "+String.format("%-10s",rs.getString(11))+" "+String.format("%-10s",rs.getString(12))
                    +" "+String.format("%-10s",rs.getString(13)));
            flag=true;
        }
        rs.close();
        createCon.setConnection().close();
        if(!flag) {
        	System.out.println("Unable to fetch data/data not available");
        }

    }

    public void searchByPatientRecoveryDate() throws SQLException, ClassNotFoundException, IOException {

        // search patient details by Recovery Date
    	boolean flag = false;
        System.out.println("Enter patient Recovery Date to search...");
        PreparedStatement pstmt =createCon.setConnection().prepareStatement("SELECT * FROM PATIENT_TABLE WHERE recoverydate LIKE ?");
        pstmt.setString(1,br.readLine());
        ResultSet rs = pstmt.executeQuery();
        
        System.out.println(" Id   "+" "+"Age" +" "+"Patient Name             "
                +" "+"Gender" +" "+"City           "+" "+"Patient Address     "
                +" "+"Guardian Name            " +" "+"Guardian Address    " +" "+"DtOfAdmssn"
                +" "+"Aadhar No   "+" "+"Ptnt Phno "+" "+"Grdn PhNo "
                +" "+"RecoveryDt"+"\n");
        
        while(rs.next()){
            //write a code to display column name
            System.out.println(String.format("%5d",rs.getInt(1))+" "+String.format("%3d",rs.getInt(2)) +"  "+String.format("%-25s",rs.getString(3))
                    +" "+String.format("%-6s",rs.getString(4)) +" "+String.format("%-15s",rs.getString(5))+" "+String.format("%-15s",rs.getString(6))
                    +" "+String.format("%-25s",rs.getString(7)) +" "+String.format("%-15s",rs.getString(8)) +" "+String.format("%-10s",rs.getString(9))
                    +" "+String.format("%-12s",rs.getString(10))+" "+String.format("%-10s",rs.getString(11))+" "+String.format("%-10s",rs.getString(12))
                    +" "+String.format("%-10s",rs.getString(13)));
            flag=true;
        }
        rs.close();
        createCon.setConnection().close();
        if(!flag) {
        	System.out.println("Unable to fetch data/data not available");
        }
        
        // write a code to print some statement if data not available  

    }

    public void deletePatientById() throws SQLException, ClassNotFoundException, IOException {

    	//delete patient by Id
    	
        System.out.println("Enter patient Id to delete record : ");
        PreparedStatement pstmt=createCon.setConnection().prepareStatement("DELETE FROM PATIENT_TABLE WHERE id LIKE ?");
        pstmt.setInt(1 , Integer.parseInt(br.readLine()));
        int count = pstmt.executeUpdate();
        if(count<0) {
        	System.out.println("Unable to delete data/data not available");
        }else 
        System.out.println(count+" row/s effected Successfully");

        createCon.setConnection().close();
        
       
    }
    
    public String printGood() {
    Calendar calendar = Calendar.getInstance();
    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    if (hour >= 0 && hour < 12) {
      return "Good morning!";
    } else if (hour >= 12 && hour < 18) {
      return "Good afternoon!";
    } else 
     return "Good evening!";
    }
    
}