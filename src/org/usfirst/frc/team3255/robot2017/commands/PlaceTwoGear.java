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
		
		double distance = -72.0;
		
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
		
		double distance = 55.0;
		
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
			angle = 90.0;
		}
		else {
			angle = -90.0;
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
		
		double distance = -36.0;
		
		return distance;
	}
	
	public double autoTwoGearDelay() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoTwoGearDelay();
		}
		
		if(AutoPreferences.doGear() == false) {
			return 0.0;
		}
		
		return 0.0;
	}
	
	public double autoTwoGearD4() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoTwoGearD2();
		}
		
		int lane = AutoPreferences.getLane();
		
		if((AutoPreferences.doTwoGear() == false || (lane == 0))) {
			return 0.0;
		}
		
		double distance = -40.0;
		
		return distance;
	}
	
    public PlaceTwoGear() {
    	addSequential(new DriveStraightDistanceSpeed("TwoGearD1", autoTwoGearD1(),0.7));
    	addSequential(new DoDelay(autoTwoGearDelay()));
    	addSequential(new GearDeployToPeg());
    	addParallel(new DoDelay(autoTwoGearDelay()));
    	addSequential(new DriveStraightDistanceSpeed("TwoGearD2", autoTwoGearD2(),0.7));
//    	addSequential(new GearRetract());
    	addSequential(new DriveAccurateRotate("TwoGearT1", autoTwoGearTurn()));
    	addParallel(new GearPickupFromFloor());
    	addSequential(new DriveStraightDistanceSpeed("TwoGearD3", autoTwoGearD3(), 0.7));
    	addParallel(new DoDelay(autoTwoGearDelay()));
    	addParallel(new GearRetract());
    	//reverse
    	addSequential(new DriveStraightDistanceSpeed("RevTwoGearD3", -autoTwoGearD3(), 0.7));
    	addSequential(new DriveAccurateRotate("RevTwoGearT1", -autoTwoGearTurn()));
    	addSequential(new DriveStraightDistanceSpeed("TwoGearD4", autoTwoGearD4(), 0.7));
    	addSequential(new GearDeployToPeg());
    	addParallel(new DoDelay(autoTwoGearDelay()));
    	addSequential(new DriveStraightDistanceSpeed("Backup", 12.0, 0.7));
    	addSequential(new GearRetract());
    }
}
