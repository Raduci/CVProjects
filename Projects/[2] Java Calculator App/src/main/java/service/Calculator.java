package service;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton,subButton,multiplyButton,divideButton;
    JButton decimalButton, equalsButton, deleteButton, clearButton;
    JPanel panel;

    Font myFont = new Font("Arial", Font.BOLD,30);


    double num1 = 0;
    double num2 = 0;
    double result = 0;
    char operator;


    public Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        multiplyButton = new JButton("x");
        divideButton = new JButton("/");
        equalsButton = new JButton("=");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        decimalButton = new JButton(".");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multiplyButton;
        functionButtons[3] = divideButton;
        functionButtons[4] = equalsButton;
        functionButtons[5] = clearButton;
        functionButtons[6] = decimalButton;
        functionButtons[7] = deleteButton;

        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        deleteButton.setBounds(50,430,145,50);
        clearButton.setBounds(205,430,145,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4, 10,10));
//        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiplyButton);
        panel.add(decimalButton);
        panel.add(numberButtons[0]);
        panel.add(equalsButton);
        panel.add(divideButton);

        frame.add(panel);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(textfield);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++){
            if(e.getSource() == numberButtons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decimalButton){
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == addButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (e.getSource() == multiplyButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if(e.getSource() == divideButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if (e.getSource() == equalsButton){
            num2 = Double.parseDouble(textfield.getText());

            switch(operator){
                case'+':
                    result = num1+num2;
                    break;
                    case'-':
                    result = num1-num2;
                    break;
                    case'/':
                    result = num1/num2;
                    break;
                    case'*':
                    result = num1*num2;
                    break;

            }
            textfield.setText(String.valueOf(result));
        }
        if (e.getSource() == clearButton){
            textfield.setText("");
        }
        if (e.getSource() == deleteButton){
            String str = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < str.length()-1; i++) {
                textfield.setText(textfield.getText() + str.charAt(i));
            }


        }
    }
}
