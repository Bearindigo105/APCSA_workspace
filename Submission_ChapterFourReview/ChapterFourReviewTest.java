/*
 * @author Mr. Ellis
 */

package Submission_ChapterFourReview;

public class ChapterFourReviewTest{
    public static void main(String[] args){
    ChapterFourReview objOne = new ChapterFourReview("Test One");
    ChapterFourReview objTwo = new ChapterFourReview("Test Two!",0);
    boolean pass = true;
    
        if(objOne.getMyInt() != 10){
            System.out.println("Failed on getMyInt/constructor");
            pass = false;
        }
        
        if(objTwo.getMyInt() != 0){
            pass = false;
            System.out.println("Failed on second getMyInt/constructor");
        }
        String half;

        half = objOne.getFirstHalf();
        if(!half.equals("Test")){
            pass = false;
            System.out.print("failed first half");
        }
        half = objOne.getSecondHalf();
        if(!half.equals(" One")){
            pass = false;
            System.out.print("fails second half");
        }
        half = objTwo.getSecondHalf();
        if(!half.equals(" Two!")){
            pass = false;
            System.out.print("fails third half");
        }
        char last = objOne.getLastLetter();
        if(last!='e'){
            pass = false;
            System.out.print("fails last letter");
        } 
        objOne.setMyInt(33);
        if(objOne.getMyInt()!=33){
            pass = false;
            System.out.print("fails set int");
        }
        System.out.println(pass);
    }
}