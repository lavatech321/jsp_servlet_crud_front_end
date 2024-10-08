package com.newtest.utility;

import java.text.ParseException;
import java.util.Date;

public class DataValidator {

	  public static boolean isFname(String val) {
	    String name = "^[A-Za-z ]*$";
	    if (val.matches(name) && val != null && val.length() !=0 ) {
	      return true;
	    } 
	    else {
	      return false;
	    }
	  }
  
	  public static boolean isLname(String val) {
		String name = "^[A-Za-z ]*$";
		if (val.matches(name) && val != null && val.length() !=0 ) {
		   return true;
		}
		else {
		   return false;
		}
	  }
	  
	  public static boolean isUsername(String val) {
			String name = "^[A-Za-z ]*$";
			if (val.matches(name) && val != null && val.length() !=0 ) {
			   return true;
			} 
			else {
			   return false;
			}
	  }
  
	  public static boolean isZip(int zip) {
		String val = String.valueOf(zip);
        String passregex = "^[0-9]{6}$";
	    if (val.matches(passregex) && val != null && val.length() !=0 ) {
	      return true;
	    } else {
	      return false;
	    }
	  }
	  
	  public static boolean isPassword(String val) {
	    String passregex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[\\S])[A-Za-z0-9\\S]{6,12}$";
	    if (val.matches(passregex) && val != null && val.length() !=0) {
	      return true;
	    } else {
	      return false;
	    }
	  }
  
	  public static boolean isPhno(String val) {
	    String regex = "^[7-9][0-9]{9}$";
	    if (val.matches(regex) && val != null && val.length() !=0 ) {
	      return true;
	    } else {
	      return false;
	    }
	  }
  
	  public static boolean isNull(String val) {
	    if (val == null || val.trim().length() == 0) {
	      return true;
	    } else {
	      return false;
	    }
	  }
  
	  public static boolean isNotNull(String val) {
	    return !isNull(val);
	  }
  
	  public static boolean isInteger(String val) {
	    if (isNotNull(val)) {
	      try {
	        int i = Integer.parseInt(val);
	        return true;
	      } catch (NumberFormatException e) {
	        return false;
	      }
	    } else {
	      return false;
	    }
	  }
  
	  public static boolean isLong(String val) {
	    if (isNotNull(val)) {
	      try {
	        long i = Long.parseLong(val);
	        return true;
	      } catch (NumberFormatException e) {
	        return false;
	      }
	    } else {
	      return false;
	    }
	  }
  
	  public static boolean isEmail(String val) {
	    String emailreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	    if (isNotNull(val) && val != null && val.length() !=0) {
	      try {
	        return val.matches(emailreg);
	      } catch (NumberFormatException e) {
	        return false;
	      }
	    } else {
	      return false;
	    }
	  }
  
	 /* public static boolean isDate(String val) {
	    Date d = null;
	    if (isNotNull(val)) {
	      d = DataUtility.getDate(val);
	    }
	    return d != null;
	  } 
	 */
  
}