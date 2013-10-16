package stackm;

public class Main
{
	public static void main(String[] args)
	{
		// Sicherstellen das ein Eingabewort übergeben wurde
		if(args.length > 0)
		{
			new Stackmachine(args[0]);
		}
		else
		{
			System.out.println("Kein Eingabewort als Parameter übergeben! Fahre fort mit vorgegebenem Beispiel...");
			new Stackmachine("aba");
		}		
	}
}