package groupproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Yasara JLP
 */
public class DBOperations {

    private final String url = "jdbc:mysql://localhost:3306/hospital_management_system";
    private final String userName = "root";
    private final String password = "1234";
    private Connection con;//null
    private PreparedStatement pst;
    private ResultSet rs;

    public String getAdminPassword() {
        try {
            con = DriverManager.getConnection(url, userName, password);
            String query = "SELECT * FROM admin_password";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            rs.next();//for pass the pointer to data raw,because normally the pointer points the raw with column names..without this statement the pointer does not go down 
            String adminPassword = rs.getString("admin_password");

            return adminPassword;
        } catch (Exception e) {
            System.out.println("Exception in getAdminPassword method\n" + e);
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
}
