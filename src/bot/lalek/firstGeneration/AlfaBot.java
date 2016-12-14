package bot.lalek.firstGeneration;

import java.awt.Color;

import bot.support.HelperBot;
import robocode.ScannedRobotEvent;

/**
 * ROBOT classe ALFA.
 * 
 * Usato per imparare il movimento, ripassare la trigonometria e capire come
 * muoversi sul campo.
 * Completamente INUTILE in un combattimento.
 * 
 * @author adelmo
 *
 */
public class AlfaBot extends _AGRootBot {
	@Override
	public void run() {
		setRootDefaultValues();
		while (true) {
				moveTo(centerx, centery, -1);
				moveTo(getBattleFieldWidth(), getBattleFieldHeight(), -1);
				moveTo(0, 0, -1);
				moveTo(getBattleFieldWidth(), TOLLERANCE, -1);
				moveTo(TOLLERANCE, getBattleFieldHeight(), -1);
		}
	}

	@Override
	public void onScannedRobot(ScannedRobotEvent e) {
		fire(1);
	}

	/**
	 * Scelta casuale di un colore fra 5 di base.
	 * 
	 * @return
	 */
	public Color randomColor() {
		return HelperBot.randomColor();

	}
}
