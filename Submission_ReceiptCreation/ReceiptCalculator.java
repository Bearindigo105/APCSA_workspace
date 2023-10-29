/*
 * @author Subhash Muthu
 * Receipt Calculator
 * https://gvsd.instructure.com/courses/15378/assignments/385097?module_item_id=844683
 */

public class ReceiptCalculator{
    
    public static float calcSubtotal(float appPrice, float entreePrice, float drinkPrice, float dessertPrice){
        return appPrice + entreePrice + drinkPrice + dessertPrice;
    }
    
    public static float calcTax(float subTotal, int salesTaxPercent){
        return subTotal * (float)salesTaxPercent / 100;
    }
    
    public static float calcTax(float subTotal, float salesTaxDecimal){
        return subTotal * salesTaxDecimal;
    }
}