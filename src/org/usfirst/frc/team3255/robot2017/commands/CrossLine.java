package org.usfirst.frc.team3255.robot2017.commands;

import org.usfirst.frc.team3255.robot2017.AutoPreferences;
import org.usfirst.frc.team3255.robot2017.RobotPreferences;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrossLine extends CommandGroup {
	
	public double autoCrossD1() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoCrossD1();
		}
		
		if((AutoPreferences.doCross() == false || (AutoPreferences.getLane() == 0))) {
			return 0.0;
		}
		
		int lane = AutoPreferences.getLane();
		double distance = 0.0;
		
		if(AutoPreferences.doShot() == true) {
			distance = -40;
		}
		else {
			if(AutoPreferences.doGear() == false) {
				if(lane == 1) {
					distance = -140;
				}
				if(lane == 2) {
					distance = -32;
				}
				if(lane == 3) {
					distance = -144;
				}
			}
			else {
				if(lane == 1) {
					distance = 24;
				}
				if(lane == 2) {
					distance = 52;
				}
				if(lane == 3) {
					distance = 25;
				}
			}
		}
		
		return distance;
	}
	
	public double autoCrossTurn() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoCrossTurn();
		}
		
		if((AutoPreferences.doCross() == false) || (AutoPreferences.getLane() == 0)) {
			return 0.0;
		}
		
		int lane = AutoPreferences.getLane();
		double angle = 0.0;
		
		if(AutoPreferences.doShot() == true) {
			angle = 46.2;
		}
		else {
			if(AutoPreferences.doGear() == false) {
				if(lane == 1) {
					angle = -45;
				}
				if(lane == 2) {
					angle = -48;
				}
				if(lane == 3) {
					angle = -45;
				}
			}
			else {
				if(lane == 1) {
					angle = 90;
				}
				if(lane == 2) {
					angle = -45;
				}
				if(lane == 3) {
					angle = -103;
				}
			}
		}
		
		if(AutoPreferences.isRedAlliance() == false) {
			angle = -angle;
		}
		
		return angle;
	}
	
	public double autoCrossD2() {
		if(AutoPreferences.isDebug()) {
			return RobotPreferences.autoCrossD2();
		}
		
		if((AutoPreferences.doCross() == false || (AutoPreferences.getLane() == 0))) {
			return 0.0;
		}
		
		int lane = AutoPreferences.getLane();
		double distance = 0.0;
		
		if(AutoPreferences.doShot() == true) {
			distance = -90;
		}
		else {
			if(AutoPreferences.doGear() == false) {
				if(lane == 1) {
					distance = 0;
				}
				if(lane == 2) {
					distance = -204;
				}
				if(lane == 3) {
					distance = -51;
				}
			}
			else {
				if(lane == 1) {
					distance = -48;
				}
				if(lane == 2) {
					distance = -207;
				}
				if(lane == 3) {
					distance = -109.6;
				}
			}
		}
		
		return distance;
	}

    public CrossLine() {
    	addSequential(new DriveDistance("CrossD1Inaccurate", autoCrossD1()));
    	addSequential(new DoDelay(RobotPreferences.autoDoDelay()));
    	addSequential(new DriveRotate("CrossTurnInaccurate", autoCrossTurn()));
    	addSequential(new DoDelay(RobotPreferences.autoDoDelay()));
    	addSequential(new DriveDistance("CrossD2Inaccurate", autoCrossD2()));
    }
}
