// The "SolitaireApplet" class.

import java.applet.Applet;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import javax.swing.JOptionPane;

import javax.imageio.*;

public class SolitaireApplet extends Applet implements ActionListener, MouseListener, MouseMotionListener


{
    // instance variables
    Graphics g;
    boolean OKtoMove = false; //Assignment 2 for mouse dragging of diamond object
    CardClass Card = new CardClass ();
    boolean drawFlag = true;
    int setx = 250;
    int sety = 250;
    Graphics bufferGraphics;
    Image offscreen;
    Dimension dim;
    //  private Image offScreenImage;
    //private Graphics offScreenGraphics;


    int losectr = 0;
    DisplayClass display = new DisplayClass ();
    VectorDeckClass deck; // deck of 52 cards
    CardClass[] array;  //ARRAY
    {
	array = new CardClass [13];



	array [0] = new CardClass (3, 1, 20, 305, 135, 3);
	array [1] = new CardClass (3, 2, 20, 360, 185, 3);
	array [2] = new CardClass (3, 3, 20, 400, 250, 3);
	array [3] = new CardClass (3, 4, 20, 360, 315, 3);
	array [4] = new CardClass (3, 5, 20, 305, 360, 3);
	array [5] = new CardClass (3, 6, 20, 250, 395, 3);
	array [6] = new CardClass (3, 7, 20, 195, 360, 3);
	array [7] = new CardClass (3, 8, 20, 140, 315, 3);
	array [8] = new CardClass (3, 9, 20, 110, 250, 3);
	array [9] = new CardClass (3, 10, 20, 140, 185, 3);
	array [10] = new CardClass (3, 11, 20, 195, 135, 3);
	array [11] = new CardClass (3, 12, 20, 250, 100, 3);
	array [12] = new CardClass (3, 13, 20, 250, 250, 3);
    }


    // TrackerClass queen;
    // BufferedImage bgImg; // background image


    public void init ()
    {
	g = getGraphics ();
	deck = new VectorDeckClass ('s', 250, 250); // initializes a deck of 52 unique cards
	setSize (500, 500);
	//  queen = new TrackerClass (12, 250, 280);
	setBackground (new Color (12, 152, 31));
	dim = getSize ();
	offscreen = createImage (dim.width, dim.height);
	bufferGraphics = offscreen.getGraphics ();
	addMouseListener (this);
	CardClass Card = new CardClass ();


	deck.shuffle ();

	// try // gets background image
	// {
	//    URL url = new URL (getCodeBase (), "BackgroundImage.jpg");
	//   bgImg = ImageIO.read (url);
	//  }
	// catch (IOException e)
	//  {
	// }
	addMouseListener (this);
	addMouseMotionListener (this);
    } // init method


    public void update (Graphics g)
    {
	paint (bufferGraphics);
	g.drawImage (offscreen, 0, 0, this);
    }


    public void paint (Graphics g)
    {
	//g.drawImage (bgImg, 0, 0, null); // draw background

	bufferGraphics.clearRect (0, 0, dim.width, dim.width);
	if (drawFlag == true)
	{

	    Card = deck.dealCard (1);


	    if (losectr == 4)
	    {
		display.infoBox ("You Lose", "Defeat");

	    }
	    for (int i = 0 ; i < 13 ; i++)
	    {
		array [i].draw (g);
		Card.draw (g);
	    }
	    /*    else
		{
		    Card.erase (g);
		}
		g.setColor (Color.white); // sets the drawing color to white */
	}
    } // SolitaireApplet class


    public boolean action (Event e, Object o)

    {

	//  This was put into the actionPerformed method above
	// //  The button code is rewritten later in assignment 2 see above
	// if (e.target instanceof Button)
	// {
	//     if (e.target == buttonDraw)
	//     {
	//         drawFlag = true;
	//         textFieldAction.setText ("Draw");
	//     }
	//     if (e.target == buttonErase)
	//     {
	//         drawFlag = false;
	//         textFieldAction.setText ("Erase");
	//     }
	// }


	repaint ();
	return true;


    }


    public int getlosectr ()
    {
	return losectr;
    }


    public void mouseClicked (MouseEvent e)
    {
    }


    public void mouseEntered (MouseEvent e)
    {
    }


    public void mouseExited (MouseEvent e)
    {
    }


    public void actionPerformed (ActionEvent e)
    {
    }


    public void mousePressed (MouseEvent e)
    {

	if (Card.isPointInside (e.getX (), e.getY ()) == true)
	{
	    OKtoMove = true;


	    Card.setCentre (e.getX (), e.getY ());

	    Card.draw (g);
	    repaint ();
	}

    }


    public void mouseReleased (MouseEvent e)

    {

	if (setx != Card.getCenterX () && sety != Card.getCenterY ())
	{
	    Card.setCentre (setx, sety);
	    OKtoMove = false;
	    repaint ();
	}

    }


    public class DisplayClass
    {

	public void infoBox (String infoMessage, String titleBar)
	{
	    JOptionPane.showMessageDialog (null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	}
    }


    public void mouseDragged (MouseEvent e)
    {
	if (OKtoMove == true)
	{

	    deck.setCentre (e.getX (), e.getY ());
	    for (int i = 0 ; i < 13 ; i++)
		if (array [i].getValue () == Card.getValue () && array [i].getCenterX () == e.getX () && array [i].getCenterY () == e.getY ())
		{
		    array [i].setCtr ();
		    if (array [i].getCtr () > 3)
		    {
			array [i].setisUp (true);
		    }
		    Color ocolor = Color.red;
		    Card.setColor (Color.white);
		    Card.draw (g);
		    Card.setColor (ocolor);
		    if (Card.getValue () == 13)
		    {
			losectr += 1;
		    }
		    deck.deleteCard (1);
		    deck.shuffle ();

		    Card = deck.dealCard (2);
		    repaint ();




		}
	    //d1.draw (g);
	    repaint ();
	}

    }


    public void mouseMoved (MouseEvent e)
    {

    }
}


