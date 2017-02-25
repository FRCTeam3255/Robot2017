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
					distance = 75;
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
			angle = -46.2;
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
					angle = 60;
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
					distance = -80;
				}
				if(lane == 2) {
					distance = -117;
				}
				if(lane == 3) {
					distance = -109.6;
				}
			}
		}
		
		return distance;
	}

    public CrossLine() {
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
    	addSequential(new DriveStraightDistance("CrossD1", autoCrossD1()));
    	addSequential(new DoDelay(RobotPreferences.autoDoDelay()));
    	addSequential(new DriveRotate("CrossTurn", autoCrossTurn()));
    	addSequential(new DoDelay(RobotPreferences.autoDoDelay()));
    	addSequential(new DriveStraightDistance("CrossD2", autoCrossD2()));
    }
}
