package org.usfirst.frc.team3255.robot2017.commands;

import org.usfirst.frc.team3255.robot2017.AutoPreferences;
import org.usfirst.frc.team3255.robot2017.RobotPreferences;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoPlaceGear extends CommandGroup {

	public double autoGearD1() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoGearD1();
		}
		
		int lane = AutoPreferences.getLane();
		
		//if there is no lane selected or the "do gear" button is not pressed, return 0.0 for Distance 1
		if((AutoPreferences.doGear() == false) || (lane == 0)) {
			return 0.0;
		}

		double distance = 0.0;
		
		if(lane == 1) {
			distance = -60.2;
		}
		
		if(lane == 2) {
			distance = 0.0;
		}
		
		if(lane == 3) {
			distance = -68.0;
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
				angle = -57;
			}
			else if(lane == 3) {
				angle = 58.0;
			}
		}
		else {
			if(lane == 1) {
				angle = 57;
			}
			else if(lane == 3) {
				angle = -58.0;
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
			distance = -81;
		}
		
		if(lane == 2) {
			distance = -80.0;
		}
		
		if(lane == 3) {
			distance = -69.0;
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
		
		return 0.0;
	}
	
    public AutoPlaceGear() {
    	addSequential(new DriveStraightDistanceSpeed("GearD1", autoGearD1(), 0.7));
    	addSequential(new DoDelay(RobotPreferences.autoDoDelay()));
    	addSequential(new DriveAccurateRotate("GearTurn", autoGearTurn()));
    	addSequential(new DoDelay(RobotPreferences.autoDoDelay()));
    	addSequential(new DriveStraightDistanceSpeed("GearD2", autoGearD2(), 0.65));
    	addSequential(new DoDelay(autoGearDelay()));
    	addSequential(new PlaceGearBackup());
    	addSequential(new GearRetract());
    }
}
