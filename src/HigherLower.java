import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class HigherLower {

	public void higherlower() throws InterruptedException {
		// Deklarieren der Variablen und Instanzen von benötigten Klassen
		int credits = 100;
		boolean weiterspielen = true;
		Wahrscheinlichkeiten wsl = new Wahrscheinlichkeiten();
		Wuerfel w = new Wuerfel();
		Scanner scan = new Scanner(System.in);
		int wurf1 = w.wuerfeln() + w.wuerfeln();
		int wurf2 = 0;
		
		// Ein Durchlauf der Schleife stellt eine Runde im Spiel dar
		// Die Schleife läuft bis der Spieler keine Leben mehr hat
		while (weiterspielen) {
			
			wsl.wslrechnen(wurf1);
			
			System.out.println("Sie haben noch " + credits + " Credits.");
			System.out.println("Die Augenzahl beträgt " + wurf1 + ", glauben Sie der nächste Wurf ist höher, niedriger oder gleich?");
			
			String userInput = scan.nextLine();
			wurf2 = w.wuerfeln() + w.wuerfeln();
			
			boolean equal = wurf2==wurf1;
			boolean higher = wurf2>wurf1;
			boolean lower = wurf2<wurf1;
						
			// Spiellogik
			if (userInput.equals("gleich")) {
				if (equal) {
					System.out.println("Gewonnen! Sie haben meine Liebe gebonen! Die zweite Augenzahl betrug " + wurf2);
					credits += 10;
				} else if (!equal) {
					credits -= 10;
					System.out.println("Verloren :[ Die zweite Augenzahl betrug " + wurf2);
				}
			}	else if (userInput.equals("höher")) {
					if (higher) {
						System.out.println("Gewonnen! Sie haben meine Liebe gebonen! Die zweite Augenzahl betrug " + wurf2);
						credits += 10;
					} else if (lower) {
						credits -= 10;
						System.out.println("Verloren :[ Die zweite Augenzahl betrug " + wurf2);
					}
				} else if (userInput.equals("niedriger")) {
					if (lower) {
						System.out.println("Gewonnen! Sie haben meine Liebe gebonen! Die zweite Augenzahl betrug " + wurf2);
						credits += 10;
					} else if (higher) {
						credits -= 10;
						System.out.println("Verloren :[ Die zweite Augenzahl betrug " + wurf2);
					}
				} else if (userInput.equals("aussteigen")) {
					weiterspielen = false;
					System.out.println("Sie haben das Spiel beendet - Sie Penis!");
					break;
				} else {
					System.out.println("Sie haben sich wohl vertippt, Sie Narr ahahaha!!1111!!!11!");
				}
			
			// wurf2 wird an wurf1 weitergegeben, um den zweiten Wurf für die nächste Runde zu behalten
			wurf1 = wurf2;
			
			// Ladebalken
			System.out.print("\n[");
			for (int i = 0; i<100; i++) {
				System.out.print("=");
				TimeUnit.MILLISECONDS.sleep(10);
			}
			System.out.print("]\n\n");
		
			if (credits < 1) {
				weiterspielen = false;
				System.out.println("Sie haben all Ihre Credits verloren - Sie Penis!");
			}
			
		}
		
		scan.close();
	}
	 
}
