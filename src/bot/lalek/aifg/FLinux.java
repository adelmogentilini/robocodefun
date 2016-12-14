package bot.lalek.aifg;
import java.awt.Color;

import robocode.AdvancedRobot;
import robocode.BulletMissedEvent;
import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;

/**
 * FLinux - a robot by (your name here)
 */
public class FLinux extends AdvancedRobot
{
	
	public void run() {
		setBodyColor(Color.black);
		setGunColor(Color.blue);
		setRadarColor(Color.yellow);
 
		setAdjustGunForRobotTurn(true);
		//setAdjustRadarForGunTurn(true);
		setTurnGunRightRadians(Double.POSITIVE_INFINITY);
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		fire(2);
		//setTurnGunRightRadians(0);
	}

	@Override
	public void onBulletMissed(BulletMissedEvent event) {
		setAhead(100);
	}
	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		// back(150);
		setBack(100);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		// ahead(200);
		setAhead(200);
		turnRight(Math.random()*100);
	}	
}
