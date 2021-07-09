package com.example.util;

import org.apache.commons.lang3.StringUtils;

public class MobileNoEditor {


    public static String editMobileNo(String mobile_no){
        mobile_no = StringUtils.replace(mobile_no,"+","");
        mobile_no = StringUtils.replace(mobile_no,"-","");
        mobile_no = StringUtils.replace(mobile_no," ","");
        if (mobile_no.charAt(0) == '6'){
            mobile_no = mobile_no.substring(1,mobile_no.length());
        }
        return mobile_no;
    }
}
