import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class UseDeckClass extends Applet
{
    VectorDeckClass Deck;
    Graphics g;
    // declares a graphics canvas for drawing

    public void init ()
    {
	//  set the size of the applet
	setSize (500, 300);
	// Place the body of the initialization method here
	g = getGraphics (); // gets canvas created by browser-

	// #3
	Deck = new VectorDeckClass ('s', 50, 50);
    }


    public void paint (Graphics g)
    {



	CardClass Card = new CardClass ();
	
	Card = Deck.dealCard (1);
	Card.draw (g);



    }
}


