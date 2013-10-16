package stackm;

import java.util.*;

public class Stackmachine
{
	// Enthält Stackkonfigurationen
	private Stack<CompoundState> stack_configs;

	public Stackmachine(String s)
	{
		stack_configs = new Stack<CompoundState>();
		
		// Erstelle neuen Zusammengesetzen Zustand mit S
		CompoundState cs = new CompoundState();
		cs.add_state(new S());
		stack_configs.push(cs);		
		try
		{
			delta(s);
		}		
		catch (WortErkanntException e)
		{
		}	
		// Falls stack_configs leer ist
		catch (java.util.EmptyStackException e)
		{
		}
	}		
		
	public void delta(String word) throws WortErkanntException, java.util.EmptyStackException
	{		
		// Optionale Ausgabe	
		System.out.print("[");
		stack_configs.peek().show();			
		System.out.print("]");
		System.out.println(" mit (" + word + ")");			
		
		// Ist das Eingabewort zu Ende?
		if (word.length() <= 0)
		{						
			// Wort erkannt (Aktueller Stack leer)
			if (stack_configs.peek().is_empty())
			{
				throw new WortErkanntException();				
			}
			// Wort nicht erkannt (Aktueller Stack nicht leer)			
			else
			{
				try
				{				
					throw new StackNotEmptyException();
				}
				catch (StackNotEmptyException e)
				{
					stack_configs.pop();
					delta(stack_configs.peek().get_word());
				}
			}
		}
		// Temp. Liste für Rückgabewerte
		ArrayList<CompoundState> a = new ArrayList<CompoundState>();		
		try
		{															
			CompoundState current = stack_configs.pop();
			current.set_word(word.substring(1));			
			switch (word.charAt(0))
			{			
				case 'a':					
					a.addAll(current.get_state().transition_a(current));
					break;			
				case 'b':
					a.addAll(current.get_state().transition_b(current));
					break;		
				default:
					System.out.println("Falsches Eingabesymbol!");
					System.exit(0);
					break;
			}					
		}			
		catch (IllegalStackSymbolException e)
		{			
			delta(stack_configs.peek().get_word());
		}
		catch (EmptyStackException e)
		{			
			delta(stack_configs.peek().get_word());
		}						
		
		// Alle zurückgegebenen Konfiguration auf dem Stack speichern
		for (CompoundState i : a)
		{
			stack_configs.push(i);
		}
		
		// Optionale Ausgabe
		System.out.print("--> [");
		stack_configs.peek().show();	
		System.out.println("]");		
		System.out.println();
		
		// Rekursion etc.
		delta(word.substring(1));
	}		
}