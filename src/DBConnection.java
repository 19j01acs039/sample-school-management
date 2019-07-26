import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author 19j01acs039
 */
public class DBConnection {
    
    String host="jdbc:mysql://localhost:3306/system";
    String user="root";
    String pass="";
    
    //declare connection object
    Connection conn;
    
     //initialise connection object
    
    public Connection getConnection(){
        try {
            conn=DriverManager.getConnection(host, user, pass);
            JOptionPane.showMessageDialog(null,"connection Successful");
            return conn;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
          return null;  
        }
    }

   
     public void insertschool(String admno,String fname,String lname,String age,String email,String gender,String tel) {
         String q="INSERT into school(admno,fname,lname,age,email,gender,tel)VALUES(?,?,?,?,?,?,?)";
         int k=0;
         try{
             PreparedStatement st=getConnection().prepareStatement(q);
             st.setString(1,admno);
              st.setString(2,fname);
               st.setString(3,lname);
                st.setString(4,age);
                st.setString(5,email);
                st.setString(6,gender);
                 st.setString(7,tel);

    if(st.executeUpdate()>k){
        JOptionPane.showMessageDialog(null,admno+"  registred successfully");
    }

             
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null, ex.getMessage());
     
}
     }
     
     
     
     
      public ResultSet getschool()
 {
         String q="SELECT *FROM  school";
        
         try{
         Statement st=getConnection().createStatement();
         ResultSet rs=st.executeQuery(q);
        return rs;
                    
      }
catch(SQLException ex)
{
    
JOptionPane.showMessageDialog(null,ex.getMessage());
 return null;
}
 }
       public void updateschool(String admno,String fname,String lname,String age,String email,String gender,String tel){
         String q="UPDATE  school SET fname=?,lname=?,age=?,email=?,gender=?,tel=? WHERE admno=?";
        
            
         try{
                int k=0; 
          PreparedStatement st=getConnection().prepareStatement(q);
        
         st.setString(1,fname);
         st.setString(2,lname);
         st.setString(3,age);
         st.setString(4,email);
         st.setString(5,gender);
         st.setString(6,tel);
         st.setString(7,admno);
         
 if(st.executeUpdate()>k)
           {
           JOptionPane.showMessageDialog(null,admno+ "patient record updated");
           }
}
catch(SQLException x)
           {
     JOptionPane.showMessageDialog(null,x.getMessage());
 }
 }

     public void deleteschool(String admno) {
         String q="DELETE FROM  school WHERE admno=?";
         try{
          int k=0;
                PreparedStatement st=getConnection().prepareStatement(q);
                st.setString(1,admno);
               ;
       if(st.executeUpdate()>k){
               JOptionPane.showMessageDialog(null,admno+"  school record deleted");
    }
}
catch(SQLException ex){
    
JOptionPane.showMessageDialog(null,ex.getMessage());
     
}
     


     }
     
       
   
}
