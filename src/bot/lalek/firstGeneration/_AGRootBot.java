package bot.lalek.firstGeneration;

import bot.support.HelperBot;
import robocode.Robot;

/**
 * Classe astratta che è la radice dei robot AG.
 * 
 * @author adelmo
 *
 */
public abstract class _AGRootBot extends Robot {

	protected int TOLLERANCE;
	protected double centerx;
	protected double centery;

	protected int[][] corner;

	public _AGRootBot() {
		super();
		corner = new int[4][2];

	}

	/**
	 * @return true se il carrarmatino non è nel centro
	 */
	protected boolean isNotCentre() {
		return isNotIn(centerx, centery);
	}

	/**
	 * @return true se il carrarmatino non è in uno degli angoli
	 */
	protected boolean isNotCorner() {
		boolean notInCorner = true;

		// for(int i=0; i<4; i++){
		// notInCorner = notInCorner && isNotIn(corner[i][0],corner[i][1]);
		// }
		return notInCorner;
	}

	/**
	 * Verifica che il carretto non sia in prossimita' di un dato punto.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	boolean isNotIn(double x, double y) {
		if (Math.abs(getX() - x) < TOLLERANCE && Math.abs(getY() - y) < TOLLERANCE) {
			return false;
		}
		return true;
	}

	/**
	 * Valori di default che colorano in maniera random i carrarmatini e
	 * impostano tolleranza per i controlli di prossimita e fissano il centro
	 * del tavolo da gioco.
	 */
	protected void setRootDefaultValues() {
		TOLLERANCE = Math.max(((Double) getHeight()).intValue(), ((Double) getWidth()).intValue());
		// Set colors: random color for individuality :-)
		setBodyColor(HelperBot.randomColor());
		setGunColor(HelperBot.randomColor());
		setRadarColor(HelperBot.randomColor());
		setScanColor(HelperBot.randomColor());
		setBulletColor(HelperBot.randomColor());
		centerx = getBattleFieldWidth() / 2;
		centery = getBattleFieldHeight() / 2;

		corner[0][0] = 0;
		corner[0][1] = 0;
		corner[1][0] = ((Double) getBattleFieldWidth()).intValue();
		corner[1][1] = 0;
		corner[2][0] = ((Double) getBattleFieldWidth()).intValue();
		corner[2][1] = ((Double) getBattleFieldHeight()).intValue();
		corner[3][0] = 0;
		corner[3][1] = ((Double) getBattleFieldHeight()).intValue();
	}

	/**
	 * Gira il robot verso il punto x, y
	 * 
	 * @param x
	 * @param y
	 */
	protected void turnAroundXY(double x, double y) {
		double a, b, angoloDirezione;
		int quadrante = 0;
		b = y - getY();
		a = x - getX();
		if (a >= 0 && b > 0)
			quadrante = 4;
		if (a <= 0 && b >= 0)
			quadrante = 3;
		if (a < 0 && b < 0)
			quadrante = 2;
		if (a > 0 && b < 0)
			quadrante = 1;

		b = Math.abs(b);
		a = Math.abs(a);

		double deltaAngolo;
		if (a > 0) {
			deltaAngolo = Math.toDegrees(Math.atan(b / a));
		} else {
			deltaAngolo = 90;
		}

		switch (quadrante) {
		case 1:
			angoloDirezione = 90 + deltaAngolo;
			break;
		case 2:
			angoloDirezione = 270 - deltaAngolo;
			break;
		case 3:
			angoloDirezione = 270 + deltaAngolo;
			break;
		case 4:
			angoloDirezione = 90 - deltaAngolo;
			break;
		default:
			angoloDirezione = 45;
		}

		if (getHeading() > angoloDirezione) {
			turnLeft(getHeading() - angoloDirezione);
		} else {
			turnRight(angoloDirezione - getHeading());
		}
	}

	/**
	 * Muove li robot al punto x, y girandolo e muovendolo in avanti.
	 * 
	 * @param x
	 * @param y
	 */
	protected void moveTo(double x, double y, int step) {
		turnAroundXY(x, y);
		if (step > 0) {
			ahead(step);
		} else {
			double distance = distance(x, y);
			ahead(distance);
		}
	}

	private double distance(double x, double y) {
		double distance, a, b;
		b = Math.abs(y - getY());
		a = Math.abs(x - getX());
		distance = Math.sqrt(a * a + b * b);
		return distance;
	}

}