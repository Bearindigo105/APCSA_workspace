import java.util.ArrayList;

public class Average {
    public static double getAverage(ArrayList<Measurable> arrayList){
        int sum = 0;
        for (Measurable measurable : arrayList) {
            sum += measurable.getMeasure();
        }
        return ((double)sum) / arrayList.size();
    }
}
