import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SalaryCalculator{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Salary Calculator");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel hourRateLabel = new JLabel("Hourly Rate:");
        hourRateLabel.setSize(100,20);
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

        JLabel annualSalaryLbl = new JLabel("Annual Salary: $");
        annualSalaryLbl.setSize(300,20);
        annualSalaryLbl.setLocation(120,95);
        frame.add(annualSalaryLbl);

        JButton calcButton = new JButton("Calculate");
        calcButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(isDouble(hourWeekTxt.getText()) && isDouble(hourRateTxt.getText())){
                    double annualSalaryDouble = Double.parseDouble(hourRateTxt.getText()) * Double.parseDouble(hourWeekTxt.getText()) * 52;
                    annualSalaryLbl.setText(String.format("Annual Salary: $%,.2f", annualSalaryDouble));
                    }else{
                    annualSalaryLbl.setText("Invalid Params!");
                }
            }
        });
        calcButton.setSize(90,20);
        calcButton.setLocation(25,95);
        frame.add(calcButton);

        JCheckBox fullTimeChkBox = new JCheckBox("Full Time");
        fullTimeChkBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (fullTimeChkBox.isSelected()) {
                    hourWeekTxt.setEnabled(false);
                    hourWeekTxt.setText("40");
                }else{
                    hourWeekTxt.setEnabled(true);
                    hourWeekTxt.setText("");
                }
            }
        });
        fullTimeChkBox.setSize(100,20);
        fullTimeChkBox.setLocation(25,75);
        frame.add(fullTimeChkBox);

        frame.setVisible(true);
    }

    private static boolean isDouble(String str){
     try{
             Double.parseDouble(str);
             return true;
     }
     catch(NumberFormatException e)
     {
          return false;
     }
}

}