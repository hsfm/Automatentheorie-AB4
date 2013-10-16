package stackm;

import java.util.*;

public class A extends State
{
	public ArrayList<CompoundState> transition_a(CompoundState cs)
	{
		cs.remove_state();
		ArrayList<CompoundState> t = new ArrayList<CompoundState>();
		
		CompoundState cs1 = new CompoundState(cs);
		cs.remove_state();
		t.add(cs1);
		
		return t;
	}	
}