//นายอภิวัฒน์ ผ่านคำ 6530301089 เลขที่47

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Utility extends JFrame implements ActionListener {

    //Declare the class and variables as follows
    private JPanel homePanel, bmiPanel, taxPanel;
    private JButton bmiButton, backButton;
    private JLabel weightLabel, heightLabel, bmiLabel,salary,cost,taxdeduction,income,youtax,Otherincome;
    private JTextField weightField, heightField, bmiField,salaryField,costField,taxdeductionField,incomeField,youtaxField,OtherincomeField;
    private JButton calculateBMIButton, calculatetaxButton,calculateButton;
    private CardLayout cardLayout;

    int otherincome, totalincome = 0;
    //สร้างObjectที่มีชื่อว่า Utility
    public Utility() {
        //สร้างหน้าต่างโปรแกรมชื่อUtility App
        super("Utility App");
        // สร้างการจัดเรียงหน้าต่างแบบ Card Layout และตั้งเป็นเนื้อหาหลัก
        cardLayout = new CardLayout();
        JPanel contentPane = new JPanel(cardLayout);
        setContentPane(contentPane);

        // สร้างPanelที่มีชื่อว่า homePanel
        homePanel = new JPanel(new GridLayout(1, 2));
        contentPane.add(homePanel,"Home");
        // สร้างButtonที่มีชื่อว่าbmiButton และเอาไปใส่ในhomePanel
        bmiButton = new JButton("BMI");
        bmiButton.addActionListener(this);
        homePanel.add(bmiButton);
        // ตั้งค่าสีbmiButton
        bmiButton.setBackground(Color.decode("#ADE8D9"));
        // สร้างButtonที่มีชื่อว่าTax และเอาไปใส่ในhomePanel
        calculateButton = new JButton("Tax");
        calculateButton.addActionListener(this);
        homePanel.add(calculateButton);
        // ตั้งค่าสีcalculateButton
        calculateButton.setBackground(Color.decode("#ADD8E6"));
        // สร้างPanel ชื่อbmiPanelโดยว่างLayoutเป็นขนาด4x2เข้าไปใน contentPane และถูกตั้งชื่อว่า "BMI"
        bmiPanel = new JPanel(new GridLayout(4, 2));
        contentPane.add(bmiPanel, "BMI");

        // สร้างJLableที่มีชื่อว่าweightLableและJTextFieldที่มีชื่อว่าweightField
        // เพื่อสร้างช่องไว้สำหรับรับค่าจากผู้ใช้งาน
        weightLabel = new JLabel("Enter you Weight (kg): ");
        bmiPanel.add(weightLabel);
        weightField = new JTextField();
        // กำหนดสีให้weightField
        weightField.setBackground(Color.decode("#D1EDD0"));
        bmiPanel.add(weightField);

        // สร้างJLableที่มีชื่อว่าheightLableและJTextFieldที่มีชื่อว่าheightField
        // เพื่อสร้างช่องไว้สำหรับรับค่าจากผู้ใช้งาน
        heightLabel = new JLabel("Enter you Height (m): ");
        bmiPanel.add(heightLabel);
        heightField = new JTextField();
        heightField.setBackground(Color.decode("#D1EDD0"));
        bmiPanel.add(heightField);

        // สร้างJLableที่มีชื่อว่าbmiLableและJTextFieldที่มีชื่อว่าbmiField
        // เพื่อสร้างช่องแสดงbmiของผู้ใช้งาน
        bmiLabel = new JLabel("BMI: ");
        bmiPanel.add(bmiLabel);
        bmiField = new JTextField();
        // สร้างเพื่อให้ผู้ใช้ ไม่สามารถแก้ไขข้อมูลที่อยู่ใน TextField ได้
        bmiField.setEditable(false);
        // กำหนดสีให้bmiField
        bmiField.setBackground(Color.decode("#D1EDD0"));
        bmiPanel.add(bmiField);

        // สร้างButton calculateBMIButtonเมื่อเป็นกดสำหรับคำนวณค่าbmi
        calculateBMIButton = new JButton("Calculate BMI");
        calculateBMIButton.addActionListener(this);
        bmiPanel.add(calculateBMIButton);
        calculateBMIButton.setBackground(Color.decode("#ADE8D9"));
        // สร้างTax panel
        taxPanel = new JPanel(new GridLayout(7, 2));
        contentPane.add(taxPanel, "Tax");

        // เพิ่มLable salary,cost,taxdeduction,income,Oherincome,youtaxลงในtax Panelที่สร้างเอาไว้
        salary = new JLabel("Enter Salary ");
        taxPanel.add(salary);
        cost = new JLabel("Enter Year Cost ");
        taxPanel.add(cost);
        taxdeduction = new JLabel("Enter Tax deduction ");
        taxPanel.add(taxdeduction);
        income = new JLabel("You have other income? ");
        taxPanel.add(income);
        Otherincome = new JLabel("Input you income ");
        taxPanel.add(Otherincome);
        youtax = new JLabel("You tax is ");
        taxPanel.add(youtax);

        // กำหนดฟอนต์และขนาดดัวอักษรต่างๆและเพิ่มสีในJTextField
        Font font = new Font("Arial", Font.BOLD, 14);
        salaryField = new JTextField(15);
        salaryField.setFont(font);
        salaryField.setBackground(Color.decode("#90EE90"));
        costField = new JTextField(15);
        costField.setFont(font);
        costField.setBackground(Color.decode("#90EE90"));
        taxdeductionField = new JTextField(15);
        taxdeductionField.setFont(font);
        taxdeductionField.setBackground(Color.decode("#90EE90"));
        incomeField = new JTextField(15);
        incomeField.setFont(font);
        incomeField.setBackground(Color.decode("#90EE90"));
        OtherincomeField = new JTextField(15);
        OtherincomeField.setFont(font);
        OtherincomeField.setBackground(Color.decode("#90EE90"));
        youtaxField = new JTextField(15);
        youtaxField.setFont(font);
        youtaxField.setBackground(Color.decode("#90EE90"));
        youtaxField.setEditable(false);

        // เพิ่มปุ่มคำนวณภาษี(Calculate you tax) ในJButton
        calculatetaxButton = new JButton("Calculate you tax");
        calculatetaxButton.addActionListener(this);
        calculatetaxButton.setBackground(Color.decode("#ADD8E6"));

        //เอาFieldที่สร้างไว้เพิ่มในtaxPanel
        taxPanel.add(salary);
        taxPanel.add(salaryField);
        taxPanel.add(salary);
        taxPanel.add(salaryField);
        taxPanel.add(cost);
        taxPanel.add(costField);
        taxPanel.add(taxdeduction);
        taxPanel.add(taxdeductionField);
        taxPanel.add(income);
        taxPanel.add(incomeField);
        taxPanel.add(Otherincome);
        taxPanel.add(OtherincomeField);
        taxPanel.add(youtax);
        taxPanel.add(youtaxField);
        taxPanel.add(calculatetaxButton);

        // เพิ่มปุ่ม Back ในJButton
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        contentPane.add(buttonPanel, "Back");

        // กำหนดขนาดหน้าต่างJFrame
        setSize(400, 400);
        // กำหนดให้JFrameแสดงผลทางหน้าจอ
        setVisible(true);
        // กำหนดการปิดJFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // กำหนดให้JFrameอยู่กลางหน้าจอ
        setLocationRelativeTo(null);
    }
    public void actionPerformed(ActionEvent event) {
        //โค้ดนี้เป็นการตรวจสอบว่าผู้ใช้กดปุ่มไหน โดยใช้ event.getSource()โดยเมื่อกดBMIก็จะไปหน้าBMI
        //ถ้ากดTaxก็จะไปยังหน้าTax
        if (event.getSource() == bmiButton) {
            cardLayout.show(getContentPane(), "BMI");
        } else if (event.getSource() == calculateButton) {
            cardLayout.show(getContentPane(), "Tax");
        } else if (event.getSource() == calculateBMIButton) {
            //เมื่อกดButtonที่ชื่อcalculateBMIButtonจะทำการคำนวณbmiโดยใช้วิธีด้านล่างนี้โดยที่ข้อความที่ใช้แสดงผลออกทางหน้าจอโดยใช้
            // JOptionPane.showMessageDialog(parentComponent,message);
            //ใช้try catchเพื่อดักจับและตรวจสอบว่ามีข้อผิดพลาดระวังรันโปรแกรมหรือไม่
            try{
                double weight = Double.parseDouble(weightField.getText());
                double height = Double.parseDouble(heightField.getText());
                double bmiResult = (weight / (height * height))*10000;
                bmiField.setText(String.format("%.2f", bmiResult));
                if (bmiResult >= 30) {
                    JOptionPane.showMessageDialog(null, "You are obese. \nYou bmi is " + String.format("%.2f", bmiResult));
                } else if (bmiResult >= 25 && bmiResult <= 29.9) {
                    JOptionPane.showMessageDialog(null, "You are overweight. \nYou bmi is " +  String.format("%.2f", bmiResult));
                } else if (bmiResult >= 18.6 && bmiResult <= 24.9) {
                    JOptionPane.showMessageDialog(null, "You are normal weight. \nYou bmi is " + String.format("%.2f", bmiResult));
                } else {
                    JOptionPane.showMessageDialog(null, "You are underweight.\nYou bmi is " + String.format("%.2f", bmiResult));
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Please enter your weight or height in numbers.");
            }
            cardLayout.show(getContentPane(), "Back");
        } else if (event.getSource() == calculatetaxButton) {
            // เมื่อกดButtonที่ชื่อcalculatetaxButtonจะทำการคำนวณtaxโดยใช้วิธีด้านล่างนี้โดยที่ข้อความที่ใช้แสดงผลจะออกทางหน้าจอโดยใช้
            // JOptionPane.showMessageDialog(parentComponent,message);
            // ใช้try catchเพื่อดักจับและตรวจสอบว่ามีข้อผิดพลาดระวังรันโปรแกรมหรือไม่
            try{
                int salary = Integer.parseInt(salaryField.getText());
                int cost = Integer.parseInt(costField.getText());
                int deduction = Integer.parseInt(taxdeductionField.getText());
                int otherincome = Integer.parseInt(OtherincomeField.getText());
                int totalincome ;
                //check income
                String income = incomeField.getText();
                char c = income.charAt(0);
                int sum=0;

                if(c=='Y'){
                    totalincome = (salary*12)-cost-deduction+otherincome;
                }else{totalincome = (salary*12)-cost-deduction;}
                if(totalincome >= 5000000)
                {
                    int step7 = (totalincome-5000000)*35/100;
                    int step6 = (3000000*30/100);
                    int step5 = (1000000*25/100);
                    int step4 = (250000*20/100);
                    int step3 = (250000*15/100);
                    int step2 = (200000*10/100);
                    int step1 = (150000*5/100);
                    sum+=step7+step6+step5+step4+step3+step2+step1;
                    JOptionPane.showMessageDialog(null,"You tax is "+ sum + "Bath");
                    youtaxField.setText(String.format("" +sum));
                }else if(totalincome >= 2000000)
                {
                    int stepб = (totalincome-2000000)*30/100;
                    int step5 = (1000000*25/100);
                    int step4 = (250000*20/100);
                    int step3 = (250000*15/100);
                    int step2 = (200000*10/100);
                    int step1 = (150000*5/100);
                    sum+= stepб+step5+step4+step3+step2+step1;
                    JOptionPane.showMessageDialog(null,"You tax is "+ sum+ " Bath");
                    youtaxField.setText(String.format("" +sum));
                }else if(totalincome >= 1000000)
                {
                    int step5 = (totalincome-1000000)*25/100;
                    int step4 = (250000*20/100);
                    int step3 = (250000*15/100);
                    int step2 = (200000*10/100);
                    int step1 = (150000*5/100);
                    sum+=step5+step4+step3+step2+step1 ;
                    JOptionPane.showMessageDialog(null,"You tax is "+ sum + " Bath");
                    youtaxField.setText(String.format("" +sum));
                }else if(totalincome >= 750000)
                {
                    int step4 = (totalincome-750000)*20/100;
                    int step3 = (250000*15/100);
                    int step2 = (200000*10/100);
                    int step1 = (150000*5/100);
                    sum+=step4+step3+step2+step1;
                    JOptionPane.showMessageDialog(null,"You tax is "+ sum + " Bath");
                    youtaxField.setText(String.format("" +sum));
                }else if(totalincome >= 500000)
                {
                    int step3 = (totalincome-500000)*15/100;
                    int step2 = (200000*10/100);
                    int step1 = (150000*5/100);
                    sum+=step3+step2+step1;
                    JOptionPane.showMessageDialog(null,"You tax is "+sum + " Bath");
                    youtaxField.setText(String.format("" + sum));
                }else if(totalincome >= 300000)
                {
                    int step2 = (totalincome-300000)*10/100;
                    int step1 = (150000*5/100);
                    sum+=step2+step1;
                    JOptionPane.showMessageDialog(null,"You tax is "+ sum+ " Bath");
                    youtaxField.setText(String.format("" + step2+step1));
                }else if(totalincome >= 150000)
                {
                    int step1 = (totalincome-150000)*5/100;
                    sum+=step1;
                    JOptionPane.showMessageDialog(null,"You tax is "+ sum + " Bath");
                    youtaxField.setText(String.format(""+step1));
                }else{
                    JOptionPane.showMessageDialog(null," Tax is 0% \n You Tax = Free Tax ");
                    youtaxField.setText(String.format("Free"));
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Please enter numerical information");
            }
            //และเมื่อผู้ใช้กดBack จะกลับไปยังหน้าhomePanelที่ใช้ไว้ในชื่อHome
            cardLayout.show(getContentPane(), "Back");
        } else if (event.getSource() == backButton) {
            cardLayout.show(getContentPane(), "Home");
        }
    }
    //เป็นการเริ่มต้นการทำงานของโปรแกรม Utility โดยสร้าง Object ของคลาส Utility แล้วเรียกใช้ constructor ของคลาส Utility()
    //เพื่อเปิดหน้าต่าง GUI ของโปรแกรม Utility ขึ้นมาให้ผู้ใช้งานใช้งานได้
    public static void main(String[] args) {
        new Utility();
    }
}