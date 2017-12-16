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

    public Log userLogin(String userId) {
        try {
            con = DriverManager.getConnection(url, userName, null);
            String query = "SELECT * FROM login_detail WHERE user_id = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, userId);
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

    public String getPassword(String userId) {
        try {
            con = DriverManager.getConnection(url, userName, null);
            String query = "SELECT * FROM login_detail WHERE user_id = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, userId);
            rs = pst.executeQuery();
            rs.next();//for pass the pointer to data raw,because normally the pointer points the raw with column names..without this statement the pointer does not go down 

            return rs.getString("user_password");

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

    public void setLoginStatus(String userId, int userStatus) {
        try {
            con = DriverManager.getConnection(url, userName, null);
            String query = "UPDATE login_detail SET user_status = " + userStatus + " WHERE user_id = '" + userId + "'";
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

    public boolean changeUserPass(String employee_id, String newPass) {
        try {
            con = DriverManager.getConnection(url, userName, password);
            String query = "UPDATE login_detail SET user_password = ? WHERE user_id = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, newPass);
            pst.setString(2, employee_id);
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
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
            pst.setString(1, applicant.getNIC());
            pst.setInt(2, 0);
            pst.setString(3, applicant.getFirstName());
            pst.setString(4, applicant.getLastName());
            pst.setString(5, applicant.getAddress());
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
    
    public boolean updateApplicant(Applicant applicant) {
        try {
            con = DriverManager.getConnection(url, userName, password);
            String query = "Update applicant SET init_name = ? , last_name = ? , address = ? ,"
                            + "phone = ? , email = ? WHERE nic = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, applicant.getFirstName());
            pst.setString(2, applicant.getLastName());
            pst.setString(3, applicant.getAddress());
            pst.setString(4, applicant.getPhone());
            pst.setString(5, applicant.getEmail());
            pst.setString(6, applicant.getNIC());

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
    
    public boolean removeApplicant(String applicantNIC) {
        try {
            con = DriverManager.getConnection(url, userName, password);
            String query = "DELETE FROM applicant WHERE nic = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, applicantNIC);
            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Exception in removeApplicant method\n" + e);
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

    public boolean addApplication(Application application) {
        try {
            con = DriverManager.getConnection(url, userName, password);
            String query = "INSERT INTO application VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            pst.setString(16, application.getAddress());////
            pst.setDouble(17, application.getAreaCoveredByBuilding());
            double areas[] = application.getFloorAreas();
            pst.setDouble(18, areas[0]);
            pst.setDouble(19, areas[1]);
            pst.setDouble(20, areas[2]);
            pst.setDouble(21, areas[3]);
            pst.setDouble(22, areas[4]);
            double distance[] = application.getDistances();
            pst.setDouble(23, distance[0]);
            pst.setDouble(24, distance[1]);
            pst.setDouble(25, distance[2]);
            pst.setDouble(26, distance[3]);
            pst.setBoolean(27, application.getWalls());
            pst.setBoolean(28, application.getRoof());
            pst.setBoolean(29, application.getFloor());
            pst.setFloat(30, application.getWidthOfTheEntranceRoad());
            pst.setString(31, application.getTypeOfTheRoad());
            pst.setBlob(32, application.getSurvayorPlan());
            pst.setBlob(33, application.getNewBuildingPlan());
            pst.setBlob(34, application.getExistingBuildingPlan());
            pst.setBlob(35, application.getExistingBuildingCoC());

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

    public ResultSet getApplication(String text, int method) {
        String query;
        if (method == 0) { //  get application using application id
            query = "SELECT * FROM application WHERE application_id = ?";

        } else { // if (method == 1) //  get application using owner's nic
            query = "SELECT * FROM application WHERE owner_nic = ?";
        }

        try {
            con = DriverManager.getConnection(url, userName, password);
            pst = con.prepareStatement(query);
            pst.setString(1, text);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            System.out.println("Exception in getApplication method\n" + e);
            return null;
        }
    }
    
    public boolean updateApplication(Application application) {
        try {
            con = DriverManager.getConnection(url, userName, password);
            String query = "Update application SET owner_nic=?,rate_payment_recipt_no=?,street_name=?,ward_no=?,survayor_plan_no=?,block_no=?,area_of_the_land=?,"
                    + "area_of_the_current_building=?,purpose_of_current_building=?,is_current_building_plan_approved=?,is_current_building_has_coc=?,type_of_the_new_building=?,"
                    + "proposed_use=?,effect_on_neihbours=?,address=?,area_covered_by_building=?,ground_floor_area=?,first_floor_area=?,second_floor_area=?,third_floor_area=?,"
                    + "under_ground_area=?,distance_from_road=?,distance_from_back_boader=?,distance_from_right_boader=?,distance_from_left_boader=?,completed_walls=?,completed_roof=?,"
                    + "completed_floor=?,width_of_the_entarence_road=?,type_of_the_road=?,survayor_plan=?,new_building_plan=?,exiting_building_plan=?,exiting_building_coc=?"
                    + " WHERE application_id = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, application.getApplicantNIC());
            pst.setString(2, application.getRatePaymentReceiptNo());
            pst.setString(3, application.getStreetName());
            pst.setString(4, application.getWardNo());
            pst.setString(5, application.getSurvayorPlanNo());
            pst.setString(6, application.getBlockNo());
            pst.setDouble(7, application.getAreaOfTheLand());
            pst.setDouble(8, application.getAreaOfCurrentBuilding());
            pst.setString(9, application.getPurposeOfCurrentBuilding());
            pst.setBoolean(10, application.getIsCurrentBuildingPlanApproved());
            pst.setBoolean(11, application.getIsCurrentBuildingHaveCOC());
            pst.setString(12, application.getTypeOfTheBuilding());
            pst.setString(13, application.getProposedUse());
            pst.setString(14, application.getEffectOnNeighbour());
            pst.setString(15, application.getAddress());
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
            pst.setString(35, application.getApplicationID());

            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("exception in updateApplication method\n" + e);
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

    public boolean removeApplication(String applicationID) {
        try {
            con = DriverManager.getConnection(url, userName, password);
            String query = "DELETE FROM application WHERE application_id = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, applicationID);
            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Exception in removeApplication method\n" + e);
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

    public boolean checkUserID(String employeeID) { // if employeeID founds then returns true , otherwise false.
        try {
            con = DriverManager.getConnection(url, userName, null);
            String query = "SELECT * FROM employee WHERE employee_id = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, employeeID);
            rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.out.println("Exception in checkUserID method\n" + e);
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

    public boolean addEmployee(Employee employee) {
        try {
            con = DriverManager.getConnection(url, userName, password);
            String query = "INSERT INTO employee VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            String designation = employee.getDesignation();
            pst = con.prepareStatement(query);
            pst.setString(1, employee.getUserID());
            pst.setString(2, employee.getInitName());
            pst.setString(3, employee.getLastName());
            pst.setString(4, employee.getAddress());
            pst.setString(5, employee.getNIC());
            pst.setString(6, employee.getPhone());
            pst.setString(7, employee.getEmail());
            pst.setString(8, designation);
            pst.setString(9, employee.getGovRegNo());
            pst.setString(10, employee.getGender());
            pst.setString(11, employee.getAllocatedWards());

            pst.executeUpdate();
            query = "INSERT INTO login_detail VALUES (?,?,?,?)";
            int user_level = 0;
            switch (designation) {
                case "Counter Clerk":
                    user_level = 2;
                    break;
                case "Management Assistant":
                    user_level = 3;
                    break;
                case "Technical Officer":
                    user_level = 4;
                    break;
                case "Subject Clerk":
                    user_level = 5;
                    break;
                case "Secretary":
                    user_level = 6;
                    break;

            }
            pst = con.prepareStatement(query);
            pst.setString(1, employee.getUserID());
            pst.setString(2, employee.getPassword());
            pst.setInt(3, user_level);
            pst.setBoolean(4, false);

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

    public ResultSet getEmployee(String text, int method) {
        try {
            con = DriverManager.getConnection(url, userName, password);
            String query;
            if (method == 0) { // get details using nic
                query = "SELECT * FROM employee WHERE nic = ?";
            } else if (method == 1) { // get details using initial name
                query = "SELECT * FROM employee WHERE init_name = ?";
            } else if (method == 2) { // get details using last name
                query = "SELECT * FROM employee WHERE last_name = ?";
            } else {
                query = "SELECT * FROM employee WHERE employee_id = ?";
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
    
    public boolean updateEmployee(Employee employee) {
        try {
            con = DriverManager.getConnection(url, userName, password);
            String query = "UPDATE employee SET init_name=?,last_name=?,address=?,contact_no=?,email=?,designation=?,"
                    + "gov_reg_no=?,gender=?,allocated_wards=? WHERE employee_id = ?";
            String designation = employee.getDesignation();
            pst = con.prepareStatement(query);
            pst.setString(1, employee.getInitName());
            pst.setString(2, employee.getLastName());
            pst.setString(3, employee.getAddress());
            pst.setString(4, employee.getPhone());
            pst.setString(5, employee.getEmail());
            pst.setString(6, designation);
            pst.setString(7, employee.getGovRegNo());
            pst.setString(8, employee.getGender());
            pst.setString(9, employee.getAllocatedWards());
            pst.setString(10, employee.getUserID());

            pst.executeUpdate();
            query = "UPDATE login_detail SET user_level=? WHERE user_id = ?";
            int user_level = 0;
            switch (designation) {
                case "Counter Clerk":
                    user_level = 2;
                    break;
                case "Management Assistant":
                    user_level = 3;
                    break;
                case "Technical Officer":
                    user_level = 4;
                    break;
                case "Subject Clerk":
                    user_level = 5;
                    break;
                case "Secretary":
                    user_level = 6;
                    break;

            }
            pst = con.prepareStatement(query);
            pst.setInt(1, user_level);
            pst.setString(2, employee.getUserID());

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

    public boolean removeEmployee(String employee_id) {
        try {
            con = DriverManager.getConnection(url, userName, password);
            String query = "DELETE FROM employee WHERE employee_id = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, employee_id);
            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Exception in removeApplicant method\n" + e);
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

    public boolean resetEmployeePass(String employee_id) {
        try {
            con = DriverManager.getConnection(url, userName, password);
            String query = "UPDATE login_detail SET user_password = ? WHERE user_id = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, "MahUr2017");
            pst.setString(2, employee_id);
            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Exception in resetEmployeePass method\n" + e);
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

    public ResultSet getStatusData(String user) {
        try {
            con = DriverManager.getConnection(url, userName, password);
            String query = "SELECT * FROM state WHERE current_state = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, user);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            System.out.println("Exception in getStatusData method\n" + e);
            return null;
        }

    }
    
    public ResultSet currentStatusData(String applicationID) {
        try {
            con = DriverManager.getConnection(url, userName, password);
            String query = "SELECT * FROM state WHERE application_id = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, applicationID);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            System.out.println("Exception in getStatusData method\n" + e);
            return null;
        }

    }
    
    public boolean initializeApplicationStatus(String applicationID){
        try {
            con = DriverManager.getConnection(url, userName, password);
            String query = "INSERT INTO state VALUES (?,?,?,null,null)";
            pst = con.prepareStatement(query);
            pst.setString(1, applicationID);
            pst.setString(2, "Counter Clerk");
            pst.setString(3, "Pending");

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
    
    public boolean updateApplicationStatus(String applicationID,String newState){
        try {
            con = DriverManager.getConnection(url, userName, password);
            String query = "UPDATE state SET current_state = ? WHERE application_id = ?";
            pst = con.prepareStatement(query);
            
            pst.setString(1, newState);
            pst.setString(2, applicationID);

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
    
    public boolean updateApplicationStatus(String applicationID,String newState,String status,String rejectedBy,String reason){
        try {
            con = DriverManager.getConnection(url, userName, password);
            String query = "UPDATE state SET current_state = ?,status = ?,rejected_by = ?,reason = ? WHERE application_id = ?";
            pst = con.prepareStatement(query);
            
            pst.setString(1, newState);
            pst.setString(2, status);
            pst.setString(3, rejectedBy);
            pst.setString(4, reason);
            pst.setString(5, applicationID);

            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("exception in updateApplicationStatus method\n" + e);
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

    public boolean addEvolutionReport(Evolution_Report report) {
        try {
            con = DriverManager.getConnection(url, userName, password);
            String query = "INSERT INTO evolution_report VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(query);
            pst.setInt(1, 0);
            pst.setString(2, report.getApplicationID());
            pst.setString(3, report.getNameOfTheSurvayor());
            pst.setBoolean(4, report.getIsIsSurvayorApprved());
            pst.setString(5, report.getAreaRatios());
            pst.setString(6, report.getPark());
            pst.setString(7, report.getCovesOfHolding());
            pst.setBoolean(8, report.getIsExisting_attachments());
            pst.setBoolean(9, report.isZonalization_accept());
            pst.setString(10, report.getDrainwater());
            pst.setString(11, report.getBuildingBasics());
            pst.setString(12, report.getIsCommercial());
            pst.setString(13, report.getToSummary());

            pst.executeUpdate();
            
            return true;
        } catch (Exception e) {
            System.out.println("exception in addEvolutionReport method\n" + e);
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
    
    public ResultSet getApprovedList(){
        try {
            con = DriverManager.getConnection(url, userName, password);
            String query = "SELECT * FROM state WHERE status = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, "Approved");
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            System.out.println("Exception in getApprovedList method\n" + e);
            return null;
        }
    
    }
}
