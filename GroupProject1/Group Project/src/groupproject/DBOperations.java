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
            con = DriverManager.getConnection(url, userName, null);
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

    public void setLoginStatus(int userId, int userStatus) {
        try {
            con = DriverManager.getConnection(url, userName, null);
            String query = "UPDATE login_detail SET user_status = " + userStatus + " WHERE user_id =" + userId;
            pst = con.prepareStatement(query);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Exception in setLogStatus method\n" + e);
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
            System.out.println("exception in addApplicant method\n" + e);
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
            pst.setString(1, nic);
            rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Exception in getApplicant method\n" + e);
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

    public ResultSet getApplicant(String text, int method) {
        try {
            con = DriverManager.getConnection(url, userName, password);
            String query;
            if (method == 0) { // get details using nic
                query = "SELECT * FROM applicant WHERE nic = ?";
            } else if (method == 1) { // get details using initial name
                query = "SELECT * FROM applicant WHERE init_name = ?";
            } else { // get details using last name
                query = "SELECT * FROM applicant WHERE last_name = ?";
            }

            pst = con.prepareStatement(query);
            pst.setString(1, text);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            System.out.println("Exception in getApplicant method\n" + e);
            return null;
        }
    }

    public boolean addApplication(Application application) {
        try {
            con = DriverManager.getConnection(url, userName, password);
            String query = "INSERT INTO application VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query);
            pst.setString(1, application.getApplicantNIC());
            pst.setString(2, application.getApplicationID());
            pst.setString(3, application.getRatePaymentReceiptNo());
            pst.setString(4, application.getStreetName());
            pst.setString(5, application.getWardNo());
            pst.setString(6, application.getSurvayorPlanNo());
            pst.setString(7, application.getBlockNo());
            pst.setDouble(8, application.getAreaOfTheLand());
            pst.setDouble(9, application.getAreaOfCurrentBuilding());
            pst.setString(10, application.getPurposeOfCurrentBuilding());
            pst.setBoolean(11, application.getIsCurrentBuildingPlanApproved());
            pst.setBoolean(12, application.getIsCurrentBuildingHaveCOC());
            pst.setString(13, application.getTypeOfTheBuilding());
            pst.setString(14, application.getProposedUse());
            pst.setString(15, application.getEffectOnNeighbour());
            pst.setDouble(16, application.getAreaCoveredByBuilding());
            double areas[] = application.getFloorAreas();
            pst.setDouble(17, areas[0]);
            pst.setDouble(18, areas[1]);
            pst.setDouble(19, areas[2]);
            pst.setDouble(20, areas[3]);
            pst.setDouble(21, areas[4]);
            double distance[] = application.getDistances();
            pst.setDouble(22, distance[0]);
            pst.setDouble(23, distance[1]);
            pst.setDouble(24, distance[2]);
            pst.setDouble(25, distance[3]);
            pst.setBoolean(26, application.getWalls());
            pst.setBoolean(27, application.getRoof());
            pst.setBoolean(28, application.getFloor());
            pst.setFloat(29, application.getWidthOfTheEntranceRoad());
            pst.setString(30, application.getTypeOfTheRoad());
            pst.setBlob(31, application.getSurvayorPlan());
            pst.setBlob(32, application.getNewBuildingPlan());
            pst.setBlob(33, application.getExistingBuildingPlan());
            pst.setBlob(34, application.getExistingBuildingCoC());

            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("exception in addApplication method\n" + e);
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

    public boolean removeApplicant(String applicantNIC) {
        try {
            con = DriverManager.getConnection(url, userName, password);
            String query = "DELETE FROM applicant WHERE nic = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, applicantNIC);
            pst.executeUpdate();
            return true;
            
        } catch (Exception e) {
            System.out.println("Exception in getApplicant method\n" + e);
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
}
