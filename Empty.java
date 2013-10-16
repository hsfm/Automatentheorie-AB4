/* 
	Damit wir nicht null zurückgeben falls der Stack leer ist
	geben wir ein Objekt dieser Klasse zurück
*/	
package stackm;

import java.util.*;

public class Empty extends State
{
	public boolean is_empty()
	{
		return true;
	}
}