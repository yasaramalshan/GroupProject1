/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 *
 * @author Yasara JLP
 */
public class Extra {

    public static String capitalizer(String str) { // to capitalize First letter in each word of a String eg:- Yasara Jayaweera
        str = str.toLowerCase();
        String[] words = str.split(" ");
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < words.length; i++) {
            sb.append(Character.toUpperCase(words[i].charAt(0)))
                    .append(words[i].substring(1)).append(" ");
        }
        return sb.toString().trim();
    }
    
    
    public static boolean isValidEmail(String email){
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"; // tyhe pattern
        Pattern pattern = Pattern.compile(regex); // create the pattern block
        
        return pattern.matcher(email).matches(); // create a matcher & check is it matches
    }
    
    
    public static boolean isValidPhoneNumber(String pNo){
        String[] areaCodes = {"063","025","036","055","057","065","032","011","091","033","047","051","021","067","034","081",
            "035","037","023","066","041","054","031","052","038","027","045","026","024","070","071","072","075","076","077","078"
        };
        
        if (pNo.matches("\\d{10}") && Arrays.asList(areaCodes).contains(pNo.substring(0,3))) {
            return true;
        }else{
            return false;
        }
        
    }
    
    
    public static boolean isValidNIC(String nic){
        nic = nic.toLowerCase();
        if (nic.matches("\\d{9}v")) { // \\d{} mans 9 number of digits..\\d{minimum_number_of_digits,maximum_number_of_digits}
            return true;
        }else{
            return false;
        }
    
    }
}
