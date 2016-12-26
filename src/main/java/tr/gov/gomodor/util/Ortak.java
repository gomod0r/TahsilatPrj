package tr.gov.gomodor.util;

import java.text.SimpleDateFormat;

public class Ortak {
    
    public static java.util.Date sistemTarihiGetirUtilDate(){
        
        return new java.util.Date();
        
    }
    
    public static java.util.Date sistemTarihiGetirSqlDate(){
        
        java.sql.Date tarih = new java.sql.Date(new java.util.Date().getTime());
        
        return tarih;
        
    }
    
    public static String sistemTarihiGetirStringDate(String p_format){
        
        SimpleDateFormat sdf = new SimpleDateFormat(p_format);
        
        return sdf.format(new java.util.Date());
        
    }
    
}
