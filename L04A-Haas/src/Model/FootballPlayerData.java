package Model;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

public class FootballPlayerData implements TableData, Displayable
{

    private ArrayList<TableMember> players;
    private int firstLine;
    private int highlightedLine;
    private int lastLine;
    private int numberOfLines;

    public FootballPlayerData()
    {
        players = new ArrayList<>();
        loadTable();
    }

    @Override
    public void loadTable()
    {
        ReadPlayersFromXML();
    }

    public void ReadPlayersFromXML()
    {
        try
        {
            FootballPlayer fp;
            XMLDecoder decoder;
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("FootballPlayerTable.xml")));
            fp = new FootballPlayer();
            while (fp != null)
            {
                try
                {
                    fp = (FootballPlayer) decoder.readObject();
                    players.add(fp);

                } catch (ArrayIndexOutOfBoundsException theend)
                {
                    //System.out.println("end of file");
                    break;
                }
            }
            decoder.close();
        } catch (Exception xx)
        {
            xx.printStackTrace();
        }
    }
    
    //Returns the full table of data.
    @Override
    public ArrayList<TableMember> getTable()
    { 
        ArrayList<TableMember> table = players;
        return this.players;        
    }
    
    //The method will return an ArrayList of Strings with the names of the FootballPlayer fields (the "headers").
    @Override
    public ArrayList<String> getHeaders() 
    { 
        ArrayList<String> arr = new ArrayList();
        for (int i = 0; i <= 6; i++) 
        { 
            arr = this.players.get(i).getAttributeNames();
        }
        return arr;       
    }
    
    //The method will return an ArrayList of Strings with the values of the FootballPlayer object in a chosen line "n" in the table.
    @Override
    public ArrayList<String> getLine(int line) 
    { 
        return this.players.get(line).getAttributes(); 
    }
    
    //This methods used the getLine( ) method. It gets a set of lines (each one of them an array of Strings) from getLine(int n) and adds them to an array of arrays. It returns this array of arrays.
    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) 
    {
        ArrayList<ArrayList<String>> linesArr  = new ArrayList();
        for (int lines = firstLine; lines < lastLine; lines++) 
        { 
            linesArr.add(getLine(lines));
        }
        return linesArr;
    }
    
    
    //number of rows depends on the size of getHeaders()
    //number of lines depends on linesBeingDisplayed
    @Override
    public int getFirstLineToDisplay() 
    {
       firstLine = 0;
       return firstLine; 
    }
    @Override
    public int getLineToHighlight()
    { 
        return highlightedLine;
    }
    @Override
    public int getLastLineToDisplay() 
    { 
        /*for (int i = firstLine; i < players.size(); i++) 
        { 
            lastLine++;
        }*/
        lastLine = 15;
        return lastLine;
    }
    @Override
    public int getLinesBeingDisplayed() 
    { 
        for (int i = firstLine; i < lastLine; i++) 
        { 
            numberOfLines++;
        }
        return numberOfLines;
    }
    @Override
    public void setFirstLineToDisplay(int firstLine) 
    { 
        this.players.get(firstLine).getAttributes();
    }
    @Override
    public void setLineToHighlight(int highlightedLine) 
    { 
        this.players.get(highlightedLine).getAttributes();
    }
    @Override
    public void setLastLineToDisplay(int lastLine) 
    { 
        this.players.get(lastLine).getAttributes();
    }
    @Override
    public void setLinesBeingDisplayed(int numberOfLines) 
    { 
        this.players.get(numberOfLines).getAttributes();
    }
    
}
