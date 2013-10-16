Implementierung der Stackmaschine von Arbeitsblatt 4.

Folgende Dateien gehören zum Projekt:

	Main.java
	Stackmachine.java
	CompoundState.java
	State.java
	B.java
	A.java
	S.java
	Empty.java
	IllegalStackSymbolException.java
	WortErkanntException.java
	StackNotEmptyException.java
	EmptyStackException.java

	
Die generelle Ausgabe des Programms ist:

	["Stack"] mit ("Eingabewort")
	--> ["ErgebnisStack"]
	
	
Lösung zu 10b:
	
	a		(Nein, der bester Fall wäre direkte Erkennung des Wortes, AA wird aber zuerst bearbeitet)
	aaa		(Ja, es wird direkt der einzig richtige Pfad bearbeitet)
	aba		(Nein, es wird jeder nur mögliche Falsche Pfad zuerst gewählt)
	abba	(Nein, Backtracking wird mehrmals angwendet)