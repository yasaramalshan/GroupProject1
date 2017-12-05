
package groupproject;


/**
 *
 * @author Yasara JLP
 */
public class Log {
    private String userPassword;
    private int userLevel,userStatus;
    public Log(String userPassword,int userLevel,int userStatus){
        this.userPassword = userPassword;
        this.userLevel = userLevel;
        this.userStatus = userStatus;
    }

    /**
     * @return the userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @return the userLevel
     */
    public int getUserLevel() {
        return userLevel;
    }

    /**
     * @return the userStatus
     */
    public int getUserStatus() {
        return userStatus;
    }
    
}
