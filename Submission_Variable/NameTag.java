/*
 * @author Subhash Muthu
 * NameTag
 */

package Submission_Variable;

public class NameTag{
    public static void main(String[] args){
        String name = "Subhash Muthu";
        byte age = 15;
        String favoriteSubject = "AP Computer Science Principles >:)";

        System.out.printf("My name is %s\n\t\tage: %2$d\n\t\tfavorite subject: %3$s" ,name ,age ,favoriteSubject);
    }
}