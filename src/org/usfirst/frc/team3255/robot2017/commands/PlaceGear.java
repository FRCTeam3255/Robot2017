package org.usfirst.frc.team3255.robot2017.commands;

import org.usfirst.frc.team3255.robot2017.AutoPreferences;
import org.usfirst.frc.team3255.robot2017.RobotPreferences;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PlaceGear extends CommandGroup {

	public double autoGearD1() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoGearD1();
		}
		
		int lane = AutoPreferences.getLane();
		
		if((AutoPreferences.doGear() == false) || (lane == 0)) {
			return 0.0;
		}

		double distance = 0.0;
		
		if(lane == 1) {
//			SD Values
//			distance = -60.2;
			distance = -50.0;
		}
		
		if(lane == 2) {
			distance = -80.0;
		}
		
		if(lane == 3) {
			distance = -64.4;
		}

		return distance;
	}
	
	public double autoGearTurn() {
		if (AutoPreferences.isDebug()) {
			return RobotPreferences.autoGearTurn();
		}
		
		int lane = AutoPreferences.getLane();

		
		if((AutoPreferences.doGear() == false) || (lane == 0)) {
			return 0.0;
		}
		
		double angle = 0;

		if(AutoPreferences.isRedAlliance()) {
			if(lane == 1) {
				angle = -54;
			}
			else if(lane == 3) {
				angle = 60;
			}
		}
		else {
			if(lane == 1) {
				angle = 54;
			}
			else if(lane == 3) {
				angle = -60;
			}			
		}
		
		return angle;
	}
	
	public double autoGearD2() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoGearD2();
		}
		
		int lane = AutoPreferences.getLane();
		
		if((AutoPreferences.doGear() == false) || (lane == 0)) {
			return 0.0;
		}

		double distance = 0.0;
		
		if(lane == 1) {
	//		SD Values
	//		distance = -81;
			distance = -68.0;
		}
		
		if(lane == 2) {
			distance = 0;
		}
		
		if(lane == 3) {
			distance = -66.4;
		}

		return distance;
	}
	
	public double autoGearDelay() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoGearDelay();
		}
		
		if(AutoPreferences.doGear() == false) {
			return 0.0;
		}
		
		return 1.0;
	}
	
    public PlaceGear() {
    	addSequential(new DriveStraightDistance("GearD1", autoGearD1()));
    	addSequential(new DoDelay(RobotPreferences.autoDoDelay()));
    	addSequential(new DriveAccurateRotate("GearTurn", autoGearTurn()));
    	addSequential(new DoDelay(RobotPreferences.autoDoDelay()));
    	addSequential(new DriveStraightDistance("GearD2", autoGearD2()));
    	addSequential(new DoDelay(autoGearDelay()));
    	addSequential(new GearDeployToPeg());
    	addSequential(new DoDelay(autoGearDelay()));
    	addSequential(new DriveDistance("Backup", 12.0));
    	addSequential(new GearRetract());
    }
}
