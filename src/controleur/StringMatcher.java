package controleur;

/**
 *
 * @author Djurdjevic Sacha
 */
public class StringMatcher {
    
    public static boolean isWord(String s){
        return s.matches("(?i)[a-z]([- ',.a-z]{0,23}[a-z])?");
    }
    
    public static boolean isDay(String s){
        return s.matches("0[1-9]|[12]\\d|3[01]");
    }
    
    public static boolean isMonth(String s){
        return s.matches("0[1-9]|1[012]");
    }
    
    public static boolean isYear(String s){
        return s.matches("19[0-9][0-9]|20[01][0-9]");
    }
    
    public static boolean is2000(String s){
        return s.matches("19[0-9][0-9]|20[01][1-9]");
    }
    
    public static boolean isCodeSecu(String s){
        return s.matches("\\d{13}+");
    }
    
    public static boolean isTourdeTailleValid(String s){
        return s.matches("\\d{3}");
    }
    
    public static boolean isIMCValid(String s){
        return s.matches("\\d{2}");
    }
    
}
