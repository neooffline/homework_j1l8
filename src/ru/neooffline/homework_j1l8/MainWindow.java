package ru.neooffline.homework_j1l8;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainWindow extends JFrame {
    JPanel jPanelBottom = new JPanel(new FlowLayout());
    JPanel jPanelTop = new JPanel(new BorderLayout(3,3));
    JLabel jLabel = new JLabel("Введите значение, выбериите критерий и нажмите \"ОК\"");
    private JTextArea textArea = new JTextArea(25,50);
    private JScrollPane jScrollPane = new JScrollPane(textArea);
    private JTextArea criterea = new JTextArea(1,10);
    private String[] strings = {"Возраст","Зарплата"};
    private JComboBox comboBox = new JComboBox(strings);
    private JButton button = new JButton("OK");
    public MainWindow(HashMap<String,Persona> hashMap){
        drawWindow();
        criterea.setText("15");
//        textArea.setText("sdd");
        textArea.setText(makeStrings(hashMap));
        add(jPanelTop,BorderLayout.NORTH);
        add(jPanelBottom,BorderLayout.CENTER);
        jPanelTop.add(jLabel,BorderLayout.PAGE_START);
        jPanelTop.add(criterea,BorderLayout.LINE_START);
        jPanelTop.add(comboBox,BorderLayout.CENTER);
//        button.setPreferredSize(new Dimension(10,15));
        jPanelTop.add(button,BorderLayout.LINE_END);
        button.addActionListener(e -> {
            textArea.setText(
            makeStrings(hashMap,comboBox.getSelectedItem().toString(),
                    Integer.parseInt(criterea.getText())));
        });
        System.out.println(comboBox.getSelectedItem().toString());
        System.out.println(Integer.parseInt(criterea.getText()));
        jPanelBottom.add(jScrollPane);
        setVisible(true);
    }

    private String makeStrings(HashMap<String, Persona> hashMap) {
        StringBuilder str = new StringBuilder();
        for (Map.Entry<String,Persona> entry:hashMap.entrySet()) {
            str.append(entry.getValue().dataToString(entry.getValue()));
        }
        return str.toString();
    }

    private String makeStrings(HashMap<String, Persona> hashMap, String stCrit, int intCrit) {
        StringBuilder str = new StringBuilder();
        int choise;
        for (Map.Entry<String,Persona> entry:hashMap.entrySet()) {
            switch (stCrit){
                case "Возраст": {
                    choise = entry.getValue().getAge();
                    break;
                }
                case "Зарплата": {
                    choise = entry.getValue().getWorkCost();
                    break;
                }
                default:{
                    choise = 0;
                    break;
                }
            }
            if(choise >= intCrit){
                str.append(entry.getValue().dataToString(entry.getValue()));
            }
        }
        return str.toString();
    }


    private void drawWindow() {
        setBounds(500,500,600,500);
        setTitle("Список сотрудников");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        JPanel jPanelTop = new JPanel(new GridLayout());
    }

}
