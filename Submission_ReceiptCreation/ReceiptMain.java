/*
 * @author Subhash Muthu
 * Receipt Main
 * https://gvsd.instructure.com/courses/15378/assignments/385097?module_item_id=844683
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class ReceiptMain{

    public static void main(String[] args){
        
        Scanner inputScanner = new Scanner(System.in);
        
        String[] dishTypes = {"Appetizer", "Entree", "Drink", "Dessert"};
        List<String> dishNames = new ArrayList<String>();
        List<Float> dishPrices = new ArrayList<Float>();
        
        final int salesTaxPercent = 6;

        for (int index = 0; index < dishTypes.length; index++) {
            System.out.print(dishTypes[index] + ": ");
            dishNames.add(inputScanner.nextLine());
            System.out.print(dishTypes[index] + " price: ");
            dishPrices.add(inputScanner.nextFloat());
            inputScanner.nextLine();
        }
        
        float subTotal = ReceiptCalculator.calcSubtotal(dishPrices.get(0), dishPrices.get(1), dishPrices.get(2), dishPrices.get(3));
        float taxTotal = ReceiptCalculator.calcTax(subTotal, salesTaxPercent);
        float total = subTotal + taxTotal;
        System.out.println("\nI LOVE FOOD CAFE\n");
        System.out.printf("%s:", dishNames.get(0));
        System.out.printf("\t%21.2f\n", dishPrices.get(0));
        System.out.printf("%s:", dishNames.get(1));
        System.out.printf("\t%21.2f\n", dishPrices.get(1));
        System.out.printf("%s:", dishNames.get(2));
        System.out.printf("\t%21.2f\n", dishPrices.get(2));
        System.out.printf("%s:", dishNames.get(3));
        System.out.printf("\t%21.2f\n", dishPrices.get(3));
        System.out.print("Subtotal:");
        System.out.printf("\t%21.2f\n", subTotal);
        System.out.printf("Tax(%d%%):", salesTaxPercent);
        System.out.printf("\t%21.2f", taxTotal);         
        System.out.println("\n**************************");
        System.out.print("Total:");
        System.out.printf("\t%21.2f", total);
        System.out.print("\nCard Holder Name: Mr.Ellis\nCard Number:  ********1234\n\nTHANK YOU FOR BUYING FROM\nI LOVE FOOD CAFE.\n\nplease tip the cashier.");
        
        inputScanner.close();
    }
}