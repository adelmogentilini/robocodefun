package support;

import java.awt.Color;

public class HelperBot {
	/**
	 * Scelta casuale di un colore fra 5 di base.
	 * 
	 * @return il colore scelto random fra 5 colori base.
	 */
	public static Color randomColor() {
		Double r = Math.random() * 4.0;
		int i = r.intValue();
		switch (i) {
		case 1:
			return Color.yellow;
		case 2:
			return Color.red;
		case 3:
			return Color.blue;
		case 4:
			return Color.black;
		default:
			return Color.cyan;
		}

	}
}
