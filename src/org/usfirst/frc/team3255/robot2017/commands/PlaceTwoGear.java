package org.usfirst.frc.team3255.robot2017.commands;

import org.usfirst.frc.team3255.robot2017.AutoPreferences;
import org.usfirst.frc.team3255.robot2017.RobotPreferences;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PlaceTwoGear extends CommandGroup {

	public double autoTwoGearD1() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoTwoGearD1();
		}
		
		int lane = AutoPreferences.getLane();
		
		if((AutoPreferences.doTwoGear() == false) || (lane == 0)) {
			return 0.0;
		}
		
		
		return distance;
	}

	
	public double autoTwoGearD2() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoTwoGearD2();
		}
		
		int lane = AutoPreferences.getLane();
		
		if((AutoPreferences.doTwoGear() == false || (lane == 0))) {
			return 0.0;
		}
		
		
		return distance;
	}
	
	public double autoTwoGearTurn() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoTwoGearTurn();
		}
		
		int lane = AutoPreferences.getLane();
		
		if((AutoPreferences.doTwoGear() == false || (lane == 0))) {
			return 0.0;
		}
		
		double angle = 0.0;
		
		if(lane == 2) {
			return 0.0;
		}
		
		if(lane == 1) {
			angle = -90.0;
		}
		else {
			angle = 90.0;
		}
		
		if(AutoPreferences.isRedAlliance() == false) {
			angle *= -1;
		}
		
		return angle;
	}
	
	public double autoTwoGearD3() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoTwoGearD3();
		}
		
		int lane = AutoPreferences.getLane();
		
		if((AutoPreferences.doTwoGear() == false) || (lane == 0)) {
			return 0.0;
		}
		
		double distance = -24.0;
		
		return distance;
	}
	
	public double autoTwoGearDelay() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoTwoGearDelay();
		}
		
		if(AutoPreferences.doGear() == false) {
			return 0.0;
		}
		
		return 1.0;
	}
	
    public PlaceTwoGear() {
    	addSequential(new DriveStraightDistance("TwoGearD1", autoTwoGearD1()));
    	addSequential(new DoDelay(autoTwoGearDelay()));
    	addSequential(new GearDeployToPeg());
    	addSequential(new DoDelay(autoTwoGearDelay()));
    	addSequential(new DriveStraightDistance("TwoGearD2", autoTwoGearD2()));
    	addSequential(new GearRetract());
    	addSequential(new DriveAccurateRotate("TwoGearT1", autoTwoGearTurn()));
    	addSequential(new DoDelay(autoTwoGearDelay()));
    	addSequential(new GearRetract());
    	//reverse
    	addSequential(new DriveStraightDistance("TwoGearD4", -autoTwoGearD3()));
    	addSequential(new DriveAccurateRotate("TwoGearT2", -autoTwoGearTurn()));
    	addSequential(new DriveStraightDistance("TwoGearD5", -autoTwoGearD2()));
    	addSequential(new GearDeployToPeg());
    	addSequential(new DoDelay(autoTwoGearDelay()));
    	addSequential(new DriveDistance("Backup", 12.0));
    	addSequential(new GearRetract());
    }
}
