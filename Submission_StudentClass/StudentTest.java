/*
 * @author Subhash Muthu
 * Test program for the Student Class.
 */

package Submission_StudentClass;

public class StudentTest {
    public static void main(String[] args){
        
        Student student1 = new Student("Ting Wu", "6699 Foobar Ave", 420);
        Student student2 = new Student("Big Boy Arpit", "8912 Barfoo Rd", 6903);

        System.out.println(student1.getPointsTotal());
        System.out.println(student1.getName());
        System.out.println(student1.getNumAssignments());
        System.out.println(student1.getGradeLevel());

        student2.addAssignment(1234, 4567);

        System.out.println();//blank newline
        System.out.println(student2.getAverage());
        System.out.println(student2.getNumAssignments());
        System.out.println(student2.getPointsEarned());

        System.out.println(student1.getGradeLevel());
        student1.incrementGradeLevel();
        System.out.println(student1.getGradeLevel());

        System.out.println();//blank newline
        System.out.println(student1.getAddress());
        student1.setAddress("7324 Jawnboo Dr");
        System.out.println(student1.getAddress());

        System.out.println();//blank newline
        System.out.println(student2);
        student2.resetStudent();
        System.out.println("\n"  + student2);
    }
}
