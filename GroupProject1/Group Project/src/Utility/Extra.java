/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;

/**
 *
 * @author Yasara JLP
 */
public class Extra {

    public static String capitalizer(String str) { // to capitalize First letter in each word of a String eg:- Yasara Jayaweera
        str = str.toLowerCase().trim();
        if(str.equals("")){
            return "";
        }else{
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

    public static String applicationIDGenerator() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1; // b/c that method gives month in zero based indexes
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int rand = new Random().nextInt(100);

        return Integer.toString(year).substring(2) + String.format("%02d", month) + String.format("%02d", day)
                + String.format("%02d", hour) + String.format("%02d", minute) + Integer.toString(rand);

    }

    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
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
