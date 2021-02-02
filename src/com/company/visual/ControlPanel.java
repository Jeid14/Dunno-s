package com.company.visual;

import com.company.utils.ConstantString;

import javax.swing.*;

import java.awt.*;

public class ControlPanel extends JPanel {
    private JTextField textFieldId;
    private JTextField textFieldFirstName;
    private JTextField textFieldLastName;
    private JTextField textFieldAge;
    private JTextField textFieldCity;
    private JPanel panelControl;

    public ControlPanel(JTextField textFieldId,JTextField textFieldFirstName,JTextField textFieldLastName,JTextField textFieldAge, JTextField textFieldCity) {
          this.textFieldId = textFieldId;
          this.textFieldFirstName = textFieldFirstName;
          this.textFieldLastName = textFieldLastName;
          this.textFieldAge = textFieldAge;
          this.textFieldCity = textFieldCity;

    }

    public JPanel createControlPanel(){

          panelControl = new JPanel(new BorderLayout());
          panelControl.setBounds(700, 60, 300, 700);
          panelControl.setOpaque(false);

          textFieldId.setBounds(10, 50, 150, 25);
          textFieldFirstName.setBounds(10, 100, 150, 25);
          textFieldLastName.setBounds(10, 150, 150, 25);
          textFieldCity.setBounds(10, 200, 150, 25);
          textFieldAge.setBounds(10, 250, 150, 25);

         JButton buttonCreate = new JButton(ConstantString.CREATE);
         buttonCreate.setBounds(10, 290, 150, 25);
         JButton buttonUpdate = new JButton(ConstantString.UPDATE);
         buttonUpdate.setBounds(10, 325, 150, 25);
         JButton buttonDelete = new JButton(ConstantString.DELETE);
         buttonDelete.setBounds(10, 360, 150, 25);

          JLabel labelHead = new JLabel(ConstantString.HEAD_CONTROL_PANEL);
          labelHead.setBounds(30, 0, 130, 20);

          JLabel labelId = new JLabel(ConstantString.ENTER_ID);
          labelId.setBounds(10, 25, 150, 25);
          JLabel labelFirstName = new JLabel(ConstantString.ENTER_FIRST_NAME);
          labelFirstName.setBounds(10, 75, 150, 25);
          JLabel labelLastName = new JLabel(ConstantString.ENTER_LAST_NAME);
          labelLastName.setBounds(10, 125, 150, 25);
          JLabel labelCity = new JLabel(ConstantString.ENTER_CITY);
          labelCity.setBounds(10, 175, 150, 25);
          JLabel labelAge = new JLabel(ConstantString.ENTER_AGE);
          labelAge.setBounds(10, 225, 150, 25);

          panelControl.add(textFieldId);
          panelControl.add(textFieldFirstName);
          panelControl.add(textFieldLastName);
          panelControl.add(textFieldCity);
          panelControl.add(textFieldAge);

          panelControl.add(labelHead);
          panelControl.add(labelId);
          panelControl.add(labelFirstName);
          panelControl.add(labelLastName);
          panelControl.add(labelCity);
          panelControl.add(labelAge);
          panelControl.add(buttonCreate);
          panelControl.add(buttonDelete);
          panelControl.add(buttonUpdate);

          panelControl.setLayout(null);
          panelControl.setVisible(true);

        return panelControl;
    }

    public JTextField getTextFieldId() {
        return textFieldId;
    }

    public JTextField getTextFieldFirstName() {
        return textFieldFirstName;
    }

    public JTextField getTextFieldLastName() {
        return textFieldLastName;
    }

    public JTextField getTextFieldAge() {
        return textFieldAge;
    }

    public JTextField getTextFieldCity() {
        return textFieldCity;
    }

    public JPanel getPanelControl() {
        return panelControl;
    }
/*   public void setTextFieldId(JTextField textFieldId) {
        this.textFieldId = textFieldId;
    }*/

   /* public void setTextFieldFirstName(JTextField textFieldFirstName) {
        this.textFieldFirstName = textFieldFirstName;
    }

    public void setTextFieldLastName(JTextField textFieldLastName) {
        this.textFieldLastName = textFieldLastName;

    }

    public void setTextFieldAge(JTextField textFieldAge) {
        this.textFieldAge = textFieldAge;
    }

    public void setTextFieldCity(JTextField textFieldCity) {
        this.textFieldCity = textFieldCity;
    }
*/
    //для передачи текстовых полей в другой класс нужно создать геттеры.
    //в таблице передавать саму таблицу и контрольную панель.
    // а в листенере таблицы вызавать контрольную панель с геттерами для установления новых значений.

}