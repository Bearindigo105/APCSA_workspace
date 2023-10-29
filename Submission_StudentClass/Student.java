/*
 * @author Subhash Muthu
 * StudentClass
 */

package Submission_StudentClass;

public class Student {
    
    private String name;
    private String address;
    private int gradeLevel;
    private double pointsEarned;
    private double pointsTotal;
    private int numAssignments;

    public Student(String name, String addr, int grLvl){
        this.name = name;
        this.address = addr;
        this.gradeLevel = grLvl;
        this.pointsEarned = 0;
        this.pointsTotal = 0;
        this.numAssignments = 0;
    }

    public Student(String nm, String addr, int grdLvl, double pntsErnd, double pntsTtl, int numAssgnmnts){
        this.name = nm;
        this.address = addr;
        this.gradeLevel = grdLvl;
        this.pointsEarned = pntsErnd;
        this.pointsTotal = pntsTtl;
        this.numAssignments = numAssgnmnts;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String newAddr){
        this.address = newAddr;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void incrementGradeLevel(){
        this.gradeLevel ++;
    }

    public double getPointsEarned() {
        return pointsEarned;
    }

    public double getPointsTotal() {
        return pointsTotal;
    }

    public int getNumAssignments() {
        return numAssignments;
    }

    public double getAverage(){
        return pointsEarned/pointsTotal;
    }

    public void addAssignment(double pntsErnd, double pntsTtl){
        this.pointsEarned += pntsErnd;
        this.pointsTotal += pntsTtl;
        this.numAssignments ++;
    }

    public void resetStudent(){
        this.pointsEarned = 0;
        this.pointsTotal = 0;
        this.numAssignments = 0;
    }

    @Override
    public String toString(){
        return "name: " + this.name + "\naddress: " + this.address + "\ngradeLevel: " + this.gradeLevel + "\npointsEarned: " + this.pointsEarned + "\npointsTotal: " + this.pointsTotal + "\nnumAssignments: " + this.numAssignments;
    }
}
