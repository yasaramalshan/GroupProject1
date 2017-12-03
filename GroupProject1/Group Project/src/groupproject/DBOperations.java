package groupproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Yasara JLP
 */
public class DBOperations {

    private final String url = "jdbc:mysql://localhost:3306/groupproject";
    private final String userName = "root";
    private final String password = null;
    private Connection con;//null
    private PreparedStatement pst;
    private ResultSet rs;

    public Log userLogin(int userId) {
        try {
            con = DriverManager.getConnection(url, userName,null);
            String query = "SELECT * FROM login_detail WHERE user_id =" + userId;
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            rs.next();//for pass the pointer to data raw,because normally the pointer points the raw with column names..without this statement the pointer does not go down 
            String userPassword = rs.getString("user_password");
            int userLevel = rs.getInt("user_level");
            int userStatus = rs.getInt("user_status");

            return (new Log(userPassword, userLevel, userStatus));
            
        } catch (Exception e) {
            System.out.println("Exception in userLogin method\n" + e);
            return null;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
    
    public void setLoginStatus(int userId,int userStatus){
        try {
            con = DriverManager.getConnection(url, userName,null);
            String query = "UPDATE login_detail SET user_status = "+userStatus+" WHERE user_id =" + userId;
            pst = con.prepareStatement(query);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Exception in setLogStatus method\n" + e);
        }finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        
    }

    public void changeAdminPass(String pass) {
        try {
            con = DriverManager.getConnection(url, userName, password);
            String query = "UPDATE admin_password SET admin_password=?";
            pst = con.prepareStatement(query);
            pst.setString(1, pass);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("Exception in changeAdminPassword method\n" + e);
            }
        }
    }
    
    public boolean addApplicant(Applicant applicant) {
        try {
            con = DriverManager.getConnection(url, userName, password);
            String query = "INSERT INTO applicant VALUES (?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query);
            pst.setInt(1, 0);
            pst.setString(2, applicant.getFirstName());
            pst.setString(3, applicant.getLastName());
            pst.setString(4, applicant.getAddress());
            pst.setString(5, applicant.getNIC());
            pst.setString(6, applicant.getPhone());
            pst.setString(7, applicant.getEmail());

            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("exception in addPatient method\n" + e);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
    
    public boolean getApplicant(String nic) {
        try {
            con = DriverManager.getConnection(url, userName, password);
            String query = "SELECT * FROM applicant WHERE nic = ?";
            pst = con.prepareStatement(query);
            pst.setString(1,nic);
            rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Exception in getAdminPassword method\n" + e);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
    
    public ResultSet getApplicant(String text,int method) {
        try {
            con = DriverManager.getConnection(url, userName, password);
            String query;
            if (method == 0) { // get details using nic
                query = "SELECT * FROM applicant WHERE nic = ?";
            }else if(method == 1){ // get details using initial name
                query = "SELECT * FROM applicant WHERE init_name = ?";
            }else{ // get details using last name
                query = "SELECT * FROM applicant WHERE last_name = ?";
            }
            
            pst = con.prepareStatement(query);
            pst.setString(1,text);
            rs = pst.executeQuery();
             return rs;
        } catch (Exception e) {
            System.out.println("Exception in getApplicant method\n" + e);
            return null;
        } 
    }
}
