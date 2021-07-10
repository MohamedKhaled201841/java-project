package betterString;

public class betterString {
    public static void main(String[] args) {
        String string1="mohamed";
        String string2="khaled" ;
        String longer =new String();
        String first=new String();
        longer=StringUtils.betterString(string1,string2,(s1, s2) -> s1.length() > s2.length());
        first=StringUtils.betterString(string1,string2,(s1, s2) -> true);
        System.out.println(longer);
        System.out.println(first);
    }
}
