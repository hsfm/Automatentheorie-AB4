/* 
	Diese Klasse repräsentiert eine Stackkonfiguration
	Die Zustände auf diesem Stack sind in "states" gespeichert
	Damit die Ausgabe einfacher zu realisieren ist wurde eine ArrayList statt eines echten Stacks verwendet
*/

package stackm;

import java.util.*;

public class CompoundState
{
	private ArrayList<State> states;
	private String word;
	
	public CompoundState()
	{
		states = new ArrayList<State>();
	}
	
	/* Kopierkonstruktor */
	public CompoundState(CompoundState cs)
	{
		states = new ArrayList<State>();
		states.addAll(cs.states);
		this.word = cs.word;
	}
	
	public void add_state(State s)
	{	
		// Immer oben einfügen da wir einen Stack imitieren
		states.add(0, s);
	}
		
	public State get_state()
	{
		if (is_empty())
		{
			return new Empty();
		}
		return states.get(0);
	}
	
	public void remove_state()
	{
		if (!is_empty())
		{
			// Oben, Stack etc.
			states.remove(0);
		}		
	}	
	
	public void show()
	{		
		for (State i : this.states)
		{
			System.out.print(i);
		}		
	}
	
	public boolean is_empty()
	{		
		return states.isEmpty();
	}
	
	public String get_word()
	{
		return word;
	}
	
	public void set_word(String s)
	{
		word = s;
	}
}