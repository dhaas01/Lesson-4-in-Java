package View;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

/*
it is the panel in charge of displaying the data
it has a row of buttons or labels to display the headers. This row should be graphically distinct from the lines below it. This can be done by using labels, and/or by using a different background and/or a different font.
it has also a number of lines to display the table data. These lines should be graphically distinct from the headers
it needs a layout, most likely a GridLayout
*/
public class CenterPanel extends JPanel
{
    private ArrayList<JButton> headerButtonsArray = new ArrayList();
    public CenterPanel() 
    { 
        super();
        
        setVisible(true);
        setBackground(Color.red);
    }
    
    /*JButton btn1 = new JButton("Hello World!");
        JButton btn2 = new JButton("Sample Text!");
        btn2.setBackground(Color.red);
        add(btn1);
        add(btn2);
        Jlabel lbl1 = new JLabel();
        Jlabel lbl1 = newJLabel("Label Text Goes Here");
        JTextField txt1 = new JTextField();
        JTextField txt 1 = new JTextField("Student ID");
        
        btn1.setText("Changed Button Text");
        btn1.getText();
    */
    public void gridPrep(int rows, int cols) 
    { 
        // loop through row
        for (int i = 0; i < rows; i++) 
        {
            //loop through col
            for (int j = 0; j < cols; j++) 
            { 
                //create JButton as variableName
                JButton btn = new JButton("row=" + i + ", col=" + j);
                //.add() variableName to new class array list variable
                headerButtonsArray.add(btn);
                //add() variableName to the form
                add(btn);
            }
        }
        validate();
    }
    
    public void row(ArrayList<String> data) 
    {
        for (int i = 0; i < data.size(); i++) 
        { 
            this.headerButtonsArray.get(i).setText(data.get(i));
        }
        validate();
    }
    
    public void table(ArrayList<ArrayList<String>> data) 
    { 
        //From a high level, my "table" loops through data and calls row to add() buttons to the panel.
        for (int i = 0; i < data.size(); i++) 
        {
            
            row(data.get(i));
        }
        validate();
    }
    
    //called from view class to determine how many rows and cols the grid will need
    public void setGridDimensions(int rows, int cols) 
    { 
        GridLayout grid = new GridLayout(rows,cols);
        setLayout(grid);
        validate();
    }

    /**
     * @return the headerButtonsArray
     */
    public ArrayList<JButton> getHeaderButtonsArray() {
        return headerButtonsArray;
    }

    /**
     * @param headerButtonsArray the headerButtonsArray to set
     */
    public void setHeaderButtonsArray(ArrayList<JButton> headerButtonsArray) {
        this.headerButtonsArray = headerButtonsArray;
    }
}
