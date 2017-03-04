package org.usfirst.frc.team3255.robot2017.commands;

import org.usfirst.frc.team3255.robot2017.AutoPreferences;
import org.usfirst.frc.team3255.robot2017.RobotPreferences;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoShot extends CommandGroup {
	
	public double autoShotD1() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoShotD1();
		}
		
		int lane = AutoPreferences.getLane();
		
		if((AutoPreferences.doShot() == false) || (lane == 0)) {
			return 0.0;
		}
		
		double distance = 0.0;
		
		if((AutoPreferences.doGear() == false) && lane == 1) {
			distance = -41;
		}
		
		if((AutoPreferences.doGear() == false) && lane == 2) {
			distance = -13;
		}
		
		if((AutoPreferences.doGear() == false) && lane == 3) {
			distance = -13;
		}
		
		if((AutoPreferences.doGear() == true) && lane == 1) {
			distance = 66;
		}
		
		if((AutoPreferences.doGear() == true) && lane == 2) {
			distance = 14;
		}
		
		if((AutoPreferences.doGear() == true) && lane == 3) {
			distance = 61;
		}

		return distance;
	}
	
	public double autoShotTurn() {
		if (AutoPreferences.isDebug()) {
			return RobotPreferences.autoShotTurn();
		}
		
		int lane = AutoPreferences.getLane();
		
		if((AutoPreferences.doShot() == false) || (lane == 0)) {
			return 0.0;
		}
		
		double angle = 0;
		
		if(AutoPreferences.isRedAlliance() == true) {
			if((AutoPreferences.doGear() == false) && lane == 1) {
				angle = -46.2;
		 	}
			
			if((AutoPreferences.doGear() == false) && lane == 2) {
				angle = -90;
			}
			
			if((AutoPreferences.doGear() == false) && lane == 3) {
				angle = -90;
			}
			
			if((AutoPreferences.doGear() == true) && lane == 1) {
				angle = 17;
			}
			
			if((AutoPreferences.doGear() == true) && lane == 2) {
				angle = -69;
			}
			
			if((AutoPreferences.doGear() == true) && lane == 3) {
				angle = -137;
			}
		}
		
		else {
			if((AutoPreferences.doGear() == false) && lane == 1) {
				angle = 46.2;
			}
			
			if((AutoPreferences.doGear() == false) && lane == 2) {
				angle = 90;
			}
			
			if((AutoPreferences.doGear() == false) && lane == 3) {
				angle = 90;
			}
			
			if((AutoPreferences.doGear() == true) && lane == 1) {
				angle = -17;
			}
			
			if((AutoPreferences.doGear() == true) && lane == 2) {
				angle = 69;
			}
			
			if((AutoPreferences.doGear() == true) && lane == 3) {
				angle = 137;
			}
		}
		
		return angle;
	}

	public double autoShotD2() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoShotD2();
		}
		
		int lane = AutoPreferences.getLane();
		
		if((AutoPreferences.doShot() == false) || (lane == 0)) {
			return 0.0;
		}

		double distance = 0.0;
		
		if((AutoPreferences.doGear() == false) && lane == 1) {
			distance = 40;
		}
		
		if((AutoPreferences.doGear() == false) && lane == 2) {
			distance = 162;
		}
		
		if((AutoPreferences.doGear() == false) && lane == 3) {
			distance = 287;
		}
		
		if((AutoPreferences.doGear() == true) && lane == 1) {
			distance = 64;
		}
		
		if((AutoPreferences.doGear() == true) && lane == 2) {
			distance = 148;
		}
		
		if((AutoPreferences.doGear() == true) && lane == 3) {
			distance = 257;
		}

		return distance;
	}
	
	public double autoShotTime() {
		if(AutoPreferences.isDebug() == true) {
			return(RobotPreferences.autoShotTime());
		}
		
		if(AutoPreferences.doShot() == false) {
			return 0.0;
		}
		
		return 5.0;
	}
	
    public AutoShot() {
    	addSequential(new DriveStraightDistance("ShotD1", autoShotD1()));
    	addSequential(new DoDelay(RobotPreferences.autoDoDelay()));
    	addSequential(new DriveAccurateRotate("ShotTurn", autoShotTurn()));
    	addSequential(new DoDelay(RobotPreferences.autoDoDelay()));
    	addSequential(new DriveStraightDistance("ShotD2", autoShotD2()));
    	addSequential(new CollectorShoot());
    	addSequential(new DoDelay(autoShotTime()));
    	addSequential(new CollectorStop());
    }
}
