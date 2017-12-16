/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import groupproject.DBOperations;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;
import javax.swing.JFrame;

/**
 *
 * @author Yasara JLP
 */
public class Extra {

    public static String capitalizer(String str) { // to capitalize First letter in each word of a String eg:- Yasara Jayaweera
        str = str.toLowerCase().trim();
        if (str.equals("")) {
            return "";
        } else {
            String[] words = str.split(" ");
            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < words.length; i++) {
                sb.append(Character.toUpperCase(words[i].charAt(0)))
                        .append(words[i].substring(1)).append(" ");
            }
            return sb.toString().trim();
        }

    }

    public static boolean isValidEmail(String email) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"; // tyhe pattern
        Pattern pattern = Pattern.compile(regex); // create the pattern block

        return pattern.matcher(email).matches(); // create a matcher & check is it matches
    }

    public static boolean isValidPhoneNumber(String pNo) {
        String[] areaCodes = {"063", "025", "036", "055", "057", "065", "032", "011", "091", "033", "047", "051", "021", "067", "034", "081",
            "035", "037", "023", "066", "041", "054", "031", "052", "038", "027", "045", "026", "024", "070", "071", "072", "075", "076", "077", "078"
        };

        if (pNo.matches("\\d{10}") && Arrays.asList(areaCodes).contains(pNo.substring(0, 3))) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean isValidNIC(String nic) {
        nic = nic.toLowerCase();
        if (nic.matches("\\d{9}v")) { // \\d{} mans 9 number of digits..\\d{minimum_number_of_digits,maximum_number_of_digits}
            return true;
        } else {
            return false;
        }

    }

    public static boolean isValidApplcationID(String applicationID) {
        applicationID = applicationID.toLowerCase();
        if (applicationID.matches("\\d{12}")) { // \\d{} mans 12 number of digits..\\d{minimum_number_of_digits,maximum_number_of_digits}
            return true;
        } else {
            return false;
        }

    }

    public static String applicationIDGenerator(JFrame parent) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1; // b/c that method gives month in zero based indexes
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int rand = new Random().nextInt(50);

        if (parent instanceof CounterClerk.CounterClerk_Main) {
            return Integer.toString(year).substring(2) + String.format("%02d", month) + String.format("%02d", day)
                    + String.format("%02d", hour) + String.format("%02d", minute) + String.format("%02d", rand);
        } else {
            return Integer.toString(year).substring(2) + String.format("%02d", month) + String.format("%02d", day)
                    + String.format("%02d", hour) + String.format("%02d", minute) + String.format("%02d", rand + 50);
        }

    }

    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isName_Spaces(String name) {
        if (name.matches("[a-zA-Z ]+")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isInitName(String name) {
        if (name.matches("[a-zA-Z .]+")) {
            return true;
        } else {
            return false;
        }
    }

    public static void smoothExitWindow(JFrame window) {
        float i = 1.0f;
        while (i > 0.0) {
            window.setOpacity(i);
            i -= .01;
            for (int j = 0; j < 1000; j++) {
                for (int k = 0; k < 1000; k++) {
                    for (int l = 0; l < 100; l++) {

                    }
                }
            }
        }

    }

    public static void smoothExitLoginWindow(JFrame window) {
        float i = 0.0f;
        while (i > 0.0) {
            window.setOpacity(i);
            i += .01;
            for (int j = 0; j < 10000; j++) {
                for (int k = 0; k < 1000; k++) {
                    for (int l = 0; l < 100; l++) {

                    }
                }
            }
        }

    }

    public static String employeeIDGenerator() {
        String empId;
        DBOperations dbops = new DBOperations();
        do {
            empId = "10" + String.format("%04d", new Random().nextInt(10000));
        } while (dbops.checkUserID(empId));
        return empId;

    }

    public static String isCorrectWards(String input) {
        String wards[] = input.split("/");
        String newString = "";
        int num;
        for (String wardNo : wards) {
            try {
                num = Integer.parseInt(wardNo);
                if (num > 0 && num < 26) {
                    newString += Integer.toString(num) + "/";

                } else {
                    return null;
                }
            } catch (Exception e) {
                return null;
            }
        }
        return newString;
    }

    public static String isProperPassword(String userID, String password) {
        /*
         * Password should be less than 15 and more than 8 characters in length.
         * Password should contain at least one upper case and one lower case alphabet.    
         * Password should contain at least one number. 
         * Password should contain at least one special character.
         */
        String upperCaseChars = "(.*[A-Z].*)";
        String lowerCaseChars = "(.*[a-z].*)";
        String numbers = "(.*[0-9].*)";
        String specialChars = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";

        if (password.length() > 16 || password.length() < 5) {
            return "Password should be less than 16 and more than 5 characters in length..!";
        } else if (password.indexOf(userID) > -1) {
            return "Password Should not be same as user name..!";
        } else if (!password.matches(upperCaseChars)) {
            return "Password should contain atleast one upper case alphabet..!";
        }
        if (!password.matches(lowerCaseChars)) {
            return "Password should contain atleast one lower case alphabet..!";
        } else if (!password.matches(numbers)) {
            return "Password should contain atleast one number..!";
        } else if (!password.matches(specialChars)) {
            return "Password should contain atleast one special character..!";
        } else {
            return "";
        }
    }

    ///////////////////////////////////////////////////////////
    /*
    File image = new File(path);
    FileInputStream fis = new FileInputStream(image);

    String sql = "insert into imgtst (username,image) values (?, ?)";
    pst  = con.prepareStatement(sql);

    pst.setString (

    1, user);
    pst.setBinaryStream (
    2, fis, (int

    ) file.length ()

    );*/
}
