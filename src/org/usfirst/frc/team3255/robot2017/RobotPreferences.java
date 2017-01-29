package org.usfirst.frc.team3255.robot2017;

import edu.wpi.first.wpilibj.Preferences;

public class RobotPreferences {

	//Drivetrain
	public static double drivetrainPulsesPerFoot() {
		return Preferences.getInstance().getDouble("DrivePulsePerFoot", 1.0);
	}

	//Climber
	public static double climberPulsesPerFoot() {
		return Preferences.getInstance().getDouble("ClimberPulsePerFoot", 1.0);
	}

	//Shooter
	public static double shooterMaxHighSpeed() {
		return Preferences.getInstance().getDouble("ShooterMaxHighSpeed", 1.0);
	}
	public static double shooterMaxLowSpeed() {
		return Preferences.getInstance().getDouble("ShooterMaxLowSpeed", 0.6);
	}
}
