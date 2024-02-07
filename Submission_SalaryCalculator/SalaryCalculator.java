import javax.swing.*;

public class SalaryCalculator{
    public static void main(String[] args) {   
        JFrame frame = new JFrame("Salary Calculator");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel hourRateLabel = new JLabel(" Hourly Rate:");
        hourRateLabel.setSize(100,10);
        hourRateLabel.setLocation(25,35);
        frame.add(hourRateLabel);

        JLabel hourWeekLabel = new JLabel("Hours/Week:");
        hourWeekLabel.setSize(100,10);
        hourWeekLabel.setLocation(25,55);
        frame.add(hourWeekLabel);

        JTextField hourRateTxt = new JTextField();
        hourRateTxt.setSize(100,20);
        hourRateTxt.setLocation(100,32);
        frame.add(hourRateTxt);

        JTextField hourWeekTxt = new JTextField();
        hourWeekTxt.setSize(100,20);
        hourWeekTxt.setLocation(100,52);
        frame.add(hourWeekTxt);

        JButton calcButton = new JButton("Calculate");
        frame.setVisible(true);
    }
}