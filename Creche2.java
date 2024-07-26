package creche2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class Creche2 {

    public static void main(String[] args) {

        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setTitle("CRECHE 4 YOUR KIDDIE");
        frame.setLayout(null);
        
        ArrayList<String>details=new ArrayList();
        
        //Prompting the user the Name
        JLabel nameLabel=new JLabel("Name:");
        nameLabel.setBounds(10, 10, 50, 50);
        JTextField nameField=new JTextField(20);
        nameField.setBounds(50, 23, 150, 25);
        
        //prompting the user the Gender
        JLabel gender=new JLabel("Gender:");
        gender.setBounds(10, 60, 60, 30);
        JRadioButton male=new JRadioButton("Male");
        male.setBounds(60, 62, 60, 30);
        JRadioButton female=new JRadioButton("female");
        female.setBounds(120, 62, 90, 30);
        
        ButtonGroup buttonGro=new ButtonGroup();
        buttonGro.add(male);
        buttonGro.add(female);
        
        //adding the buttons to the frame
        JButton register=new JButton("Register kiddie");
        register.setBounds(10, 120, 140, 20);
        JButton display=new JButton("Display kiddie");
        display.setBounds(180, 120, 140, 20);
        
        
        //Adding the text area to the frame with scrollPane
        JTextArea textArea=new JTextArea();
        JScrollPane scrollPane=new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 150, 400, 150);
        
        register.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

               String name=nameField.getText();
               String gender=male.isSelected()?"Male":female.isSelected()?"female" :"";

                if(!name.isEmpty() && !gender.isEmpty())
                {
                    details.add("Name: "+name+"\nGender: "+gender);
                    nameField.setText("");
                    buttonGro.clearSelection();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Fill all the details");
                }
                
            }
        });
        display.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                for(int i=0;i<details.size();i++)
                {
                    textArea.append(details+"\n");
                }
            }
        });
        
        
        
        
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(gender);
        frame.add(male);
        frame.add(female);
        frame.add(register);
        frame.add(display);
        frame.add(scrollPane);
        frame.setVisible(true);
    }
    
}
