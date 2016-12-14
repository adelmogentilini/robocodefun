package bot.lalek.firstGeneration;

import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;

/**
 * 
 * @author adelmo
 *
 */
public class BetaBot extends _AGRootBot {
	double precx, precy;
	int actmeta=0;
	@Override
	public void run() {
		setRootDefaultValues();
		scan();
		actmeta=0;
		while (true) {
			while(isNotIn(corner[actmeta][0], corner[actmeta][1])){
				
				moveTo(corner[actmeta][0], corner[actmeta][1], 20);
				turnGunRight(180);
				//turnRadarRight(360);
				precy = getY();
				precx = getX();
			}
			actmeta++;
			actmeta= actmeta%4;
		}
	}

	@Override
	public void onScannedRobot(ScannedRobotEvent e) {
		if (e.getDistance() > centerx) {
			ahead(100);
		} else {
			fire(1);
		}
	}
	
	@Override
	public void onHitWall(HitWallEvent event) {
		turnLeft(45);
		ahead(100);
		actmeta++;
	}
}
