# PONG-
Pong-Spiel JavaFx.
Es wird das Spiel ´PONG´ implementiert. Dazu braucht das Programm ein Menü mit 3 Hauptmenüpunkten. Die Spieler sollen hier ein neues Spiel über die Tastatur sowohl als auch über die Maus das
Spiel starten oder konfigurieren.
Die Eigenart dieses Spieles ist die Einrichtung von Action-Taste. Wird diese Taste während des Spiels
zur richtigen Zeit gedrückt, kann das z.B. zur Beschleunigung des Balles führen.
Das Spiel besteht aus drei Sätzen mit jeweils 15 Punkten und enthält eine Pause-Funktion.
Zum Satzgewinn muss ein Spieler 15 Punkte und einen Vorsprung von 2 Punkten erzielen. Hat ein
Spieler 21 Punkte erreicht, gewinnt er das Spiel unabhängig vom Punktestand des Gegners. Das Programm besitzt eine Rangliste zum beweisen der Spielergebnisse.
Sobald das Programm auf dem Rechner funktioniert, wird das Spiel Netzwerkfähig gemacht. Es muss
möglich sein, dass zwei Spieler an zwei verschiedenen Computern gegeneinander spielen.

Vorgehensweise

Um das Programm richtig zu gliedern, habe ich mir einen Plan erstellt.
Das Programm startet ab dem schwarzen Punkt. Man gelangt als erstes ins Hauptmenü. Vom Hauptmenü gelangt man in alle Untermenüs. Das Programm lässt sich direkt vom Hauptmenü oder vom Spieltisch schließen. Um ins ’Music-Untermenü’ zu gelangen, muss man erst an das ’Option-Untermenü’ vorbei und umgekehrt ebenso. Man kann von ’Control-Untermenü’ nicht direkt ins ’Playlocal-Untermenü’
gelangen, ohne vorher zurück zum Hauptmenü zukommen.
Die Logik des Spiels für den lokalen Spieler unterscheidet sich nicht von der Logik für das Spielen über
das Netzwerk, der Unterschied liegt nur im Zugriff auf das Spielfeld.![Screenshot 2022-12-14 022002](https://user-images.githubusercontent.com/57080354/207481369-dfc19f3d-72ac-4ec6-9c8f-28bd5d4e9e7f.jpg)

 Softwaredesign
 
 Ein Klassendiagramm wurde gezeichnet, um zu verdeutlichen, wie die Fachlogik und GUI sich miteinander verknüpfen, ohne durcheinander zu gelangen.
 
 ![Screenshot 2022-12-14 022106](https://user-images.githubusercontent.com/57080354/207481519-1a257808-e25e-49e1-b187-27c43304a7fa.jpg)

 Um den Plan fertig zu stellen, konzentriere ich mich auf die notwendigen Methoden und Attribute, die
vorhanden sein müssen, damit das Programm richtig funktioniert.
Im letzten Schritt, bevor ich die Implementierung starte, habe ich ein UML-Diagramm erstellt und darin alle Attribute und Methoden eingefügt, die verwenden werden. Die Beziehungen zu den einzelnen
Klassen wurde klar erklärt, um das Diagramm richtig zu verstehen.

UML-Diagram

![Screenshot 2022-12-14 022329](https://user-images.githubusercontent.com/57080354/207481923-81c84831-fce4-4837-b627-05f326c1f7c3.jpg)


Entwurf:

1- Button
• Die MenuButton-Klasse erbt von der Klasse StackPane, wodurch sie die Schaltflächen die im Menü des Spiels sind repräsentiert. Die Schaltflächen sind Rechtecke mit einer Länge von 50 Pixeln
und einer Breite von 250 Pixeln.Diese Schaltflächen haben mehrere Eigenschaften, einschließlich
halbtransparenter Schaltflächen mit der Möglichkeit,sie nach Bedarf ein- und auszuschalten, auf
diesen Schaltflächen gibt es dynamische und visuelle Effekte.
• Die TextFieldButton-Klasse erbt alle Eigenschaften von der Klasse MenuButton. Diese Klasse
stellt ein Typfeld mit einer Bestätigungsschaltfläche dar. Die Klasse enthält eine Instanz der Klasse
’User’ und wird innerhalb der Methode textDesgin() initialisiert, sobald der Benutzer den Namen
eingibt und auf die Schaltfläche „Accept“ klickt.
• Die RadioButtonsLevel-Klasse erbt ebenso von der Klasse MenuButton und repräsentiert ein Auswahlknopf, dadurch wird die Ballgeschwindigkeit in drei Stufen bestimmt. Abgesehen davon enthält diese Klasse eine Instanz der Klasse ToggleGroup, um zu verhindern, dass der Benutzer nicht
mehr als eine Option auswählen kann.
• Die RadioButtenControler-Klasse ähnelt der RadioButtonsLevel-Klasse, bezieht sich jedoch auf
die Art und Weise, wie das Spiel gesteuert wird, und ermöglicht dem Benutzer, zwischen Maus
und Tastatur zu wählen.
• Die SlideButton-Klasse repräsentiert ein Schieberegler, über den der Benutzer die Lautstärke
steuern kann.

![pongguibutton](https://user-images.githubusercontent.com/57080354/207482106-b25b4159-8c43-45e3-a46e-e2d6d9d81504.png)

2- GUI
• Die GameMenu-Klasse repräsentiert das Haupt und Untermenü des Spiel und implementiert das
Interface ’Konstante’ . Die Länge und Breite der Pane werden im Konstruktor festgelegt. Außerdem
wird das Bild im Hintergrund des Menüs in einer Methode innerhalb der Klasse namens image()
erstellt. Diese Methode wird innerhalb des Konstruktors aufgerufen. Die Menüs sind VBoxes mit
Schaltflächen. Durch Instanzen der TranslateTansition-Klasse kann diese VBox verschoben werden, was einen Animationseffekt zum Wechseln zwischen den Menüs erzeugt.
• Die Tisch-Klasse erbt von der Klasse Scene, implementiert das Interface Konstante und stellt
den Spieltisch dar. In dem Konstruktor wird ein Instanz der Klasse Canvas initialisiert, der mit der
Größe 900 x 500 angelegt ist dann wird die Methode getGraphicsContext2D() mithilfe der Instanz
von Canvas aufgerufen, um die Grafik auf dem Canvas zu zeichnen. Der Instanz der Klasse
StackPane wird im Konstruktor initialisiert um das Canvas auf der Pane hinzuzufügen. Die TischKlasse ist dafür verantwortlich die grafischen Schnittstellen darzustellen, die Im Spiel erscheinen,
wie Schläger, Punkte und ihre Farben den Starttext des Spiels und die Anzeige der Ergebnisse.

![Screenshot 2022-12-14 022646](https://user-images.githubusercontent.com/57080354/207482289-4a86eb87-a578-4f42-80f7-d6b67754c130.jpg)

3- Fachlogik
• Die Controller-Klasse ist für die Steuerung des Spiels entweder per Maus oder Tastatur zuständig,
dies wird vom Benutzer bestimmt.
• Die Collision-Klasse ist für den Aufprall zuständig. Innerhalb dieser Klasse findet man die colis()-
Methode, die dafür verantwortlich ist, die Geschwindigkeit des Balls umzukehren, wenn sie die
Ober bzw. Unterseite berührt oder Schläger trifft. Diese Methode wird in der Methode run() in der
Klasse TischLogik aufgerufen.
• Die User-Klasse ist für die Eigenschaften der Spieler zuständig.
• Die Score-Klasse ist für die Berechnung der Punkte für jeden Spieler, und besitzt drei Methoden. Die erste Methode berechnet die Punkte. Die zweite Methode beendet die Runde, wenn die
Punktzahl eines der Spieler 15 erreicht und der Spieler zwei Punkte mehr als der zweite Spieler
hat. Die dritte Methode beendet die Runde, wenn die Anzahl der Punkte für einen der Spieler 21
ist, unabhängig von der Anzahl der Punkte für den anderen Spieler.
• Die Ball-Klasse ist für die Position und die Geschwindigkeit des Balls auf der x-Achse und y-Achse
entscheidend.
• Die TischLogik-Klasse gilt als eine der Hauptklassen, durch die der Benutzer das Spiel starten und
beenden kann. Sie enthält mehrere Methoden, einschließlich Action(), die es dem Spieler unter
bestimmten Bedingungen ermöglicht, einen Effekt auf den Ball anzuwenden, der die Geschwindigkeit des Balls erhöht, indem man eine bestimmte Taste drückt. Oder die Pause() Methode, die
es dem Benutzer ermöglicht, das Spiel zu unterbrechen. Und die gewinner() Methode, die das
Endergebnis der Spieler in den drei Runden berechnet und den Gewinner ermittelt.

![Screenshot 2022-12-14 022809](https://user-images.githubusercontent.com/57080354/207482453-6a84cad3-4be0-4009-a7b0-6b55437f523c.jpg)

Menü und Design
Hauptmenü

Im Hauptmenü gibt es wie unten abgebildet Abbildung 13 vier verschiedene Rechteck, die jeweils einen
Titel enthalten.
• Das erste Rechteck stellt eine Schaltfläche dar. Wenn der Benutzer mit der Maus darauf klickt,
wechselt es zum Untermenü, dass für das lokale Spiel verantwortlich ist.
• Das zweite Rechteck repräsentiert eine Schaltfläche, um ins Netzwerk-Spiel zu gelangen.
• Das dritte Rechteck stellt die Schaltfläche ’Option’ dar.
• Das vierte und letzte Rechteck ist für ’Exit’ zuständig.

![Hauptmenü](https://user-images.githubusercontent.com/57080354/207482649-e79ebe4c-50fa-4ecf-bb11-bb9d54559102.jpg)

Tasteneffekt
Bevor ich die Menüs weiter erkläre, möchte ich das Design hervorheben. Es fällt auf, dass diese Rechtecke, die die Tasten darstellen, wie übereinander gelegte halbtransparente Glasstücke aussehen.
Wenn der Benutzer die Maus eines dieser Rechtecke berührt, wird das Rechteck auf der x-Achse um
einen Wert von 10 Pixel in die positive Richtung verschoben.
Die Schaltfläche leuchtet in einem sehr hellen Gelb und die Farbe der Schrift ändert sich von hellgelb
zu schwarz. Wird die Maus vom Benutzer entfernt, kehrt das Rechteck zur Standardposition zurück und
der Effekt ist weg ’ Abbildung 14’.
![Hauptmenüeffekt](https://user-images.githubusercontent.com/57080354/207482716-d255b3b1-8b20-47bd-ace8-d543a171b589.jpeg)
Beim klick auf die Schaltfläche leuchtet das gewünschte Rechteck heller auf, solange bis der Klick
aufgehoben wird.
Wenn der Benutzer auf eine der Schaltflächen klickt, wird das Menü um 100 Pixel in negativer Richtung
der x-Achse verschoben, der Verschiebungseffekt ergibt sich in einer sehr kurzen Zeit und man gelangt
ins Untermenü. Das Untermenü erscheint in dem Moment von der positiven Richtung der x-Achse. Für
den Fall, dass man auf die Schaltfläche zurück klickt, erfolgt der gleiche Vorgang, jedoch in umgekehrter
Richtung.

Playlocal Untermenü
Klickt der Benutzer auf die Schaltfläche ’Playlocal’ gelangt er zum Untermenü ’Playlocal’. In diesem Menü gibt es zwei Felder, um die Namen der Spieler einzugeben. Das erster Feld repräsentiert der Spieler
auf der rechten Seite und das zweite Feld steht für den Spieler auf der linken Seite. Die Schaltfläche
’Play’ kann erst angeklickt werden, wenn die Namen der beiden Spieler eingegeben wurden. Mit der
Schaltfläche ’Back’ gelangt man wieder ins Hauptmenü.
![PlayLocal](https://user-images.githubusercontent.com/57080354/207482760-48211a5a-d04c-43ce-b981-cf159e42fe7b.jpg)

 Multyplay Untermenü
Bei ’Multyplay’ ist es im Prinzip sowie bei ’Play’, der Unterschied besteht nur darin, dass es nur ein
Feld für den Benutzernamen gibt. Dieses Feld erscheint bei jeden Benutzer und die Schaltfläche Play
kann nicht angeklickt werden bis der Benutzername eingegeben wurde. Nach der Eingabe erscheint
ein ’Popup-Bildschirm’ mit der Frage ’Möchten Sie den Server ausführen?’.
• Bei der Antwort ’Ja’ wartet der Benutzer auf den Gegner
• Bei der Antwort ’Nein’ ist in diesem Fall der Benutzer Gegner
• Bei ’Abbrechen’ wird der ’Popup-Bildschirm’ geschlossen und der Benutzer kehrt zu Untermenü
’Multyplay’ zurück
![Multiplay](https://user-images.githubusercontent.com/57080354/207482874-07630fed-fe55-483b-b132-9f0cd29c260d.jpg)

 Option Untermenü
Wenn man auf das Untermenü ’Option’ klickt wechselt der Benutzer zu einem Untermenü, dass drei
Schaltflächen (Sound, Level, Control) und eine ’Back’ Schaltfläche enthält.
![Option](https://user-images.githubusercontent.com/57080354/207482940-d02af2fe-47cf-40b9-bbbf-52d2b3928fe7.jpg)

Sound Untermenü
Die erste Schaltfläche enthält das Untermenü ’Sound’. Klickt der Benutzer darauf, kann er so die gewünschte Lautstärke auswählen. Die Lautstärke beträgt im Standardfall 40 etwas weniger als die Hälfte
der Gesamtlautstärke.
![Sound](https://user-images.githubusercontent.com/57080354/207482990-8bc0b75c-d044-4f13-88c5-0c8198848c19.jpg)

 Level Untermenü
Die zweite Schaltfläche enthält das Untermenü ’Level’. Klickt der Benutzer darauf, kann er zwischen 3
Stufen der Ballgeschwindigkeit wählen (Easy, Medium, Hard). Die Stufe beträgt im Standardfall ’Easy’.
![Level](https://user-images.githubusercontent.com/57080354/207483034-335fe77e-b2c2-4288-817e-7ca33eaabcf0.jpg)

Control Untermenü
Die dritte Schaltfläche enthält das Untermenü ’Control’. Klickt der Benutzer darauf, so kann er zur
Steuerung zwischen Maus und Tastatur wählen. Im Standardfall erfolgt die Steuerung über die Tastatur.
![Control](https://user-images.githubusercontent.com/57080354/207483076-6145ecc4-0e8b-403a-8af8-b7bbca5f9687.jpg)
*********************************************************************************************************************************************************************
Der Spieltisch
Wenn der Benutzer im Untermenü ’Playlocal’ auf ’Play’ klickt erscheint ein weiterer Bildschirm (Spieltisch) in einer sehr dunkelroten Farbe. In der Mitte des Bildschirms steht ein Text mit der Aufschrift ’Klick
oder Enter’. Gibt der Benutzer ’Enter’ auf der Tastatur oder ’Klick’ mit der Maus ein, startet das Spiel.
Beim Spielbeginn befindet sich oben rechts auf dem Bildschirm der Name sowie der Punktezähler des
Spieler ’1’. Auf der linken Seite befinden sich Name und Punktezähler von Spieler ’2’. In der Mitte oben
wird ein Zähler für die Runden mit der aktuellen Rundenzahl angezeigt.

Tor
Sobald einer der Spieler ein Tor schießt, wird neben seinem Namen ein kleiner grüner Punkt erscheinen.
• Bei dem Spieler mit den meisten Punkten, wird der Name und die Punktzahl grün angezeigt.
• Der Spieler mit den niedrigen Punkten bekommt die Farbe rot.
• Bei Gleichstand sind die Namen sowohl als auch der Punktestand beider Spieler gelb.
![Tur](https://user-images.githubusercontent.com/57080354/207483314-eeee2f86-74e2-4f5e-a8c1-aaff1874ff98.jpg)
Angenommen ein Spieler erzielt ein Tor so gelangt er zum Bildschirm ’Start Spiel’Abbildung 21.
Wenn einer der Spieler 15 Punkte erzielt und den zweiten Spieler um 2 Punkte übertrifft oder sein Punktestand 21 (unabhängig vom Gegner) ist, so ist die Runde beendet.
![Runden](https://user-images.githubusercontent.com/57080354/207483384-14dad5e4-f00b-4a3f-b85b-911b2456f858.jpg)

Action-Taste
Die Eigenart dieses Spieles ist die Einrichtung von Action-Taste. Wird diese Taste während des Spiels
zur richtigen Zeit gedrückt, kann das z.B. zur Beschleunigung des Balles führen. Um die Action-Taste
zu aktivieren, muss der Spieler 3 Bedingungen erfüllen.
• Der Spieler muss sich in den zweiten Runde befinden.
• Der Spieler muss zwei Punkte Vorsprung zu seinem Gegner haben.
• Die Punktzahl des Gegners darf nicht weniger als 5 sein.
![Screenshot 2022-12-14 023707](https://user-images.githubusercontent.com/57080354/207483613-ab6eda22-7885-45df-a25b-31ef11383c73.jpg)

Pause-Funktion
Der Spieler kann zu jeder Zeit die Pausefunktion betätigen, in dem er mit der Maus scrollt oder die
Taste ’p’ auf der Tastatur eingibt. Um das Spiel fortzufahren muss der Spieler ’Enter’ oder ’Mausklick’
benutzen.
![Pause](https://user-images.githubusercontent.com/57080354/207483674-9cfe1497-e2ed-4bcb-854b-6022abb3bd12.jpg)

Rangliste
Nach der dritten Runde erscheint die Rangliste mit dem Namen des Gewinners in grün auf dem Bildschirm. Somit ist das Spiel beendet, bei ’Klick’ der Maustaste oder ’Enter’ auf der Tastatur wird das
Spiel geschlossen und das Programm beendet.
![Ergebnis](https://user-images.githubusercontent.com/57080354/207483724-6a1d85e6-c0a6-498f-a19e-471b66a67b80.jpg)

 Logik des Spiels
Das Spiel ’PONG’ ist sehr mit dem Tischtennis zu vergleichen, deshalb habe ich die selben Verhältnisse
verwendet (9/5, Breite und Länge). Die Grundlage des Spiels besteht darin, dass zwei Spieler mit
jeweils einem Schläger versuchen den Ball ins gegnerische Tor zu schlagen, wobei die Schläger sich
nur nach Oben oder nach Unten bewegen. Bei jedem Aufprall beschleunigt sich die Geschwindigkeit
des Balles. Und bei jedem Tor bekommt der Spieler einen Punkt. Das Spiel besteht aus drei Runden mit
jeweils 15 Punkten für jeden Spieler. Die Runde wird aber erst dann als beendet erklärt, wenn einer der
Spieler zum Satzende 2 Punkte mehr als sein Gegner hat z.B. (19-17). Beim erreichen von 21 Punkten
unabhängig vom Gegner, ist der Satz beendet. Ab der zweiten Runde gibt es die sogenannte ’ActionTaste’, die dazu dient, dass der Spieler mit Punktvorsprung die Taste bedienen kann, um den Ball zu
beschleunigen. Jedoch darf der Gegner in diesem Satz nicht weniger als 5 Punkte haben, sonst kann
die Taste nicht aktiviert werden.


