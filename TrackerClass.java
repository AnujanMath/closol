// The "Tracker" class.

import java.util.*;
import java.awt.*;

public class TrackerClass
{
    int cx = 100;
    int cy = 200;
    int ctr = 0;

    public TrackerClass ()
    {
    }


    public TrackerClass (char value, int x, int y)
    {
	cx = x;
	cy = y;
	if (value == 'Q')
	{
	    CardClass queen = new CardClass (1, 12, 100, cx, cy);
	    queen.setisUp (true);

	}
    }
}
