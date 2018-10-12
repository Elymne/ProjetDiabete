package Main;
import controleur.StringMatcher;
public class MainTester {
    
    final static String nomvrai = "HA";
    final static String nomfaux = "HAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa";
    
    final static String jourvrai = "1";
    final static String jourfaux = "31";
    
    final static String moisfaux = "13";
    final static String moisvrai = "13";
    
    final static String anneefaux = "1478";
    final static String anneevrai = "2001";
    
    final static String codefaux = "01dddeeefg";
    final static String codevrai = "1111111111115";
    
    public static void main(String[] args) {
        
        System.out.println("-- TEST NAME REGEX --");
        System.out.println(controleur.StringMatcher.isWord(nomfaux));
        System.out.println(controleur.StringMatcher.isWord(nomvrai));
        
        System.out.println("-- TEST DAY REGEX --");
        System.out.println(controleur.StringMatcher.isDay(jourfaux));
        System.out.println(controleur.StringMatcher.isDay(jourvrai));
        
        System.out.println("-- TEST MONTH REGEX --");
        System.out.println(controleur.StringMatcher.isMonth(moisfaux));
        System.out.println(controleur.StringMatcher.isMonth(moisvrai));
        
        System.out.println("-- TEST YEAR REGEX --");
        System.out.println(controleur.StringMatcher.isYear(anneefaux));
        System.out.println(controleur.StringMatcher.isYear(anneevrai));
        
        System.out.println("-- TEST CODE REGEX --");
        System.out.println(controleur.StringMatcher.isCodeSecu(codefaux));
        System.out.println(controleur.StringMatcher.isCodeSecu(codevrai));
    }
    
}
