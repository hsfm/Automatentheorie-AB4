package stackm;

import java.util.*;

public class B extends State
{
	public ArrayList<CompoundState> transition_b(CompoundState cs)
	{
		cs.remove_state();
		ArrayList<CompoundState> t = new ArrayList<CompoundState>();		
		
		CompoundState cs1 = new CompoundState(cs);		
		cs1.add_state(new S());
		t.add(cs1);
		
		CompoundState cs2 = new CompoundState(cs);		
		cs2.add_state(new B());
		cs2.add_state(new B());
		t.add(cs2);

		return t;
	}
}