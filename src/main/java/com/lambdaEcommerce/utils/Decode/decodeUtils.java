package com.lambdaEcommerce.utils.Decode;

import java.util.Base64;

public class decodeUtils {

     private decodeUtils(){}

     public static String getDecodedString(String encodedString){
         //return new String(Base64.getDecoder().decode(encodedString.getBytes()));
         return new String(Base64.getMimeDecoder().decode(encodedString.getBytes()));
     }
}
