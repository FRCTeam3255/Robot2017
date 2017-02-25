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
		
		if((AutoPreferences.doShot() == false) || (AutoPreferences.getLane() == 0)) {
			return 0.0;
		}
		
		int lane = AutoPreferences.getLane();
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
		
		if((AutoPreferences.doShot() == false) || (AutoPreferences.getLane() == 0)) {
			return 0.0;
		}
		
		double angle = 0;
		int lane = AutoPreferences.getLane();
		
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
		
		if((AutoPreferences.doShot() == false) || (AutoPreferences.getLane() == 0)) {
			return 0.0;
		}
		
		int lane = AutoPreferences.getLane();
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
		return RobotPreferences.autoShotTime();
	}
	
    public AutoShot() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new DriveStraightDistance("ShotD1", autoShotD1()));
    	addSequential(new DoDelay(RobotPreferences.autoDoDelay()));
    	addSequential(new DriveRotate("ShotTurn", autoShotTurn()));
    	addSequential(new DoDelay(RobotPreferences.autoDoDelay()));
    	addSequential(new DriveStraightDistance("ShotD2", autoShotD2()));
    	addSequential(new CollectorShoot());
    	addSequential(new DoDelay(autoShotTime()));
    	addSequential(new CollectorStop());
    }
}
