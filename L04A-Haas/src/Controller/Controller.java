package Controller;

import Model.Model;
import View.View;

import java.lang.Object;
import java.util.EventObject;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/* (first line)
Controller calls a method in View with the number of lines and columns to be displayed.
View will then call a method in CenterPanel passing the same parameters.
View has to access InitialFrame, and InitialPanel to call a method in CenterPanel
The parameters retrieved from Model are the number of lines and columns to be displayed.
This method in CenterPanel creates the header and line buttons in place, without any text yet.
*/
/* (second line)
Controller calls a method in view. This method sends the text to be displayed in the header and line buttons
View accesses InitialFrame and InitialPanel to call another method in CenterPanel
Now the parameters retrieved from Model are the text from the data tables.
*/
public class Controller
{

    Model model;
    View view;

    public Controller(View v, Model m)
    {
        model = m;
        view = v;
        
        view.CenterInitialSetup(model.getFpData().getLinesBeingDisplayed(), model.getFpData().getHeaders().size());
        view.CenterUpdate(model.getFpData().getLines(model.getFpData().getFirstLineToDisplay(), 
            model.getFpData().getLastLineToDisplay()), model.getFpData().getHeaders());
        this.addListeners();
// no changes needed in Controller
//The code below will work as it is if FootballPlayerData is implemented correctly
//
//=========used in L03B =====================================================
//        view.basicDisplay("------------------------------------------------------");
//        view.basicDisplay(model.getFpData().getHeaders());
//        view.basicDisplay("size of headers=" + model.getFpData().getHeaders().size());
//        view.basicDisplay("------------------------------------------------------");
//        view.basicDisplay(model.getFpData().getLine(100));
//        view.basicDisplay("------------------------------------------------------");
//        view.linesDisplay(model.getFpData().getLines(100,103));
//        view.basicDisplay("size of lines=" + model.getFpData().getLines(100,103).size());
//        view.basicDisplay("size of line 0=" + model.getFpData().getLines(100,103).get(0).size());
//        view.basicDisplay("------------------------------------------------------");

//=========used in L03A =====================================================
//        view.basicDisplay(model.getMembers().get(1).getAttributeName(3));
//        view.basicDisplay(model.getMembers().get(1).getAttribute(3));
//        view.basicDisplay(model.getMembers().get(1).getAttributeNames());
//        view.basicDisplay(model.getMembers().get(1).getAttributes());
//        view.basicDisplay("size of names=" + model.getMembers().get(1).getAttributeNames().size());
//        view.basicDisplay("size of attributes=" + model.getMembers().get(1).getAttributes().size());
    }
private void addListeners()
    { 
        view.getIframe().getIp().getCp().addMouseWheelListener(
            new MouseWheelListener()
        {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) 
            { 
                int units = e.getUnitsToScroll();
                //use "units" to update first and last line to display
                int firstLine = model.getFpData().getFirstLineToDisplay() + units;
                model.getFpData().setFirstLineToDisplay(firstLine);
                int lastLine = model.getFpData().getLinesBeingDisplayed() + firstLine;
                model.getFpData().setLastLineToDisplay(lastLine);
                
                //Then refresh the screen using CenterUpdate in View
               view.CenterUpdate(model.getFpData().getLines(firstLine, lastLine), model.getFpData().getLine(units));
            }
        }
        );
        
    /*The listening to the headers functionality will be implemented using the Interface ActionListener.

    It will be implemented as an inner listener
    check the lesson on inner listeners
    one ActionListener for each header button
    once the button is clicked it should be highlighted using a different color. All other buttons will then be reset to the standard color*/
        view.getIframe().getIp().getCp().getHeaderButtonsArray().get(0).addActionListener(
        new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            { 
                //Write the code for what it is needed when the button is clicked
                JButton b = (JButton) e.getSource();
                b.setBackground(Color.red);
            }
        }
        );
        
        view.getIframe().getIp().getCp().getHeaderButtonsArray().get(1).addActionListener(
        new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            { 
                JButton b = (JButton) e.getSource();
                b.setBackground(Color.pink);
            }
        }
        );
        
        view.getIframe().getIp().getCp().getHeaderButtonsArray().get(2).addActionListener(
        new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            { 
                JButton b = (JButton) e.getSource();
                b.setBackground(Color.blue);
            }
        }
        ); 
        
        view.getIframe().getIp().getCp().getHeaderButtonsArray().get(3).addActionListener(
        new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            { 
               JButton b = (JButton) e.getSource();
                b.setBackground(Color.green);
            }
        }
        );
        
        view.getIframe().getIp().getCp().getHeaderButtonsArray().get(4).addActionListener(
        new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            { 
                JButton b = (JButton) e.getSource();
                b.setBackground(Color.orange);
            }
        }
        );
        
        view.getIframe().getIp().getCp().getHeaderButtonsArray().get(5).addActionListener(
        new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            { 
                JButton b = (JButton) e.getSource();
                b.setBackground(Color.yellow);
            }
        }
        );
        
        view.getIframe().getIp().getCp().getHeaderButtonsArray().get(6).addActionListener(
        new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            { 
                JButton b = (JButton) e.getSource();
                b.setBackground(Color.white);
            }
        }
        );
    }
}
