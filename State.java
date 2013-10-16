package stackm;

import java.util.*;

public abstract class State
{		
	public ArrayList<CompoundState> transition_a(CompoundState cs) throws IllegalStackSymbolException, EmptyStackException
	{
		if (cs.is_empty())
		{
			throw new EmptyStackException();
		}
		else
		{
			throw new IllegalStackSymbolException();
		}		
	}
	
	public ArrayList<CompoundState> transition_b(CompoundState cs) throws IllegalStackSymbolException, EmptyStackException
	{		
		if (cs.is_empty())
		{
			throw new EmptyStackException();
		}
		else
		{
			throw new IllegalStackSymbolException();
		}			
	}	
	
	public String toString()
	{
		return this.getClass().getSimpleName();
	}
}