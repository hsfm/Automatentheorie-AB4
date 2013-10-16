package stackm;

import java.util.*;

public class S extends State
{	
	public ArrayList<CompoundState> transition_a(CompoundState cs)
	{
		// Entferne oberstes Element im Stack, da es benutzt wurde
		cs.remove_state();
		// Temporäre Liste enthält alle ergebnisse von "Zustand mit Eingabesymbol"
		ArrayList<CompoundState> t = new ArrayList<CompoundState>();		
		
		// Scheint so zu funktionieren, sicher nicht die beste Lösung
		CompoundState cs3 = new CompoundState(cs);
		cs3.add_state(new B());
		t.add(cs3);						
		
		CompoundState cs2 = new CompoundState(cs);		
		cs2.remove_state();
		t.add(cs2);				
				
		CompoundState cs1 = new CompoundState(cs);		
		cs1.add_state(new A());
		cs1.add_state(new A());
		t.add(cs1);
			
		return t;
	}	
}