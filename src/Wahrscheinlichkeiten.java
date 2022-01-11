
public class Wahrscheinlichkeiten {
	
	double wsl1 = (double)1/36;
	
	double[] wsl = {(double)1/36, (double)2/36, (double)3/36, (double)4/36, (double)5/36, (double)6/36, (double)5/36, (double)4/36, (double)3/36, (double)2/36, (double)1/36};
	
	public void wslrechnen(int wurf) {
		double wslgleich = wsl[wurf-2];
		double wslniedriger = 0;
		double wslhoeher = 0;

		for (int i = 0; i<wurf-2; i++) {
			wslniedriger += wsl[i];
		}
		
		for (int i = wurf-1; i<11; i++) {
			wslhoeher += wsl[i];
		}
		
		System.out.println(wslniedriger);
	
	}
}
