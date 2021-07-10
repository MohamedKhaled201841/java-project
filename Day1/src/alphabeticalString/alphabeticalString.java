package alphabeticalString;

public class alphabeticalString {
    public static void main(String[] args) {
        String s1="ABC";
        String s2="ABC1";
        System.out.println(isalphabeticalString(s1));
        System.out.println(isalphabeticalString(s2));


    }
    public static   boolean isalphabeticalString (String s){
        if(s.isEmpty() || s=="null")return false;
        if(s.chars().allMatch(Character::isLetter))return true;
        return false;




    }
}
