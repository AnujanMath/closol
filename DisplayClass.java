import javax.swing.JOptionPane;

public class DisplayClass
{

    public static void infoBox (String infoMessage, String titleBar)
    {
	JOptionPane.showMessageDialog (null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
