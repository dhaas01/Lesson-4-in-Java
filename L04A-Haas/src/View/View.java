package View;

import java.util.ArrayList;

//View creates the InitialFrame, the first and enclosing Frame.
//View will then call a method in CenterPanel passing the same parameters.
//View has to access InitialFrame, and InitialPanel to call a method in CenterPanel
public class View
{

    /**
     * @return the iframe
     */
    public InitialFrame getIframe() {
        return iframe;
    }

    /**
     * @param iframe the iframe to set
     */
    public void setIframe(InitialFrame iframe) {
        this.iframe = iframe;
    }
    private InitialFrame iframe;
    public View()
    {
        iframe = new InitialFrame();
    }

    public void basicDisplay(String s)
    {
        System.out.println(s);
    }

    public void basicDisplay(ArrayList<String> arr)
    {
        for (String s : arr)
        {
            System.out.print(s + " ");
        }
        System.out.print("\n");
    }

    public void linesDisplay(ArrayList<ArrayList<String>> arr) 
    {
        for (ArrayList<String> s : arr) 
        {
            basicDisplay(s);
        }
    }
    
    //send row and column counts from CenterPanel, information comes from FootballPlayerData getLines being displayed and size method from the output in getHeaders.
    //set panel up and fill it with data
    public void CenterInitialSetup(int rows, int cols) 
    { 
        iframe.getIp().getCp().setGridDimensions(rows, cols);
    }
    
    public void CenterUpdate(ArrayList<ArrayList<String>> table, ArrayList<String> headers) 
    { 
        iframe.getIp().getCp().row(headers);
        iframe.getIp().getCp().table(table);
    }
}
   
