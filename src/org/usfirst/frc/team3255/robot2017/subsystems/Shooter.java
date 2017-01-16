package org.usfirst.frc.team3255.robot2017.subsystems;

import org.usfirst.frc.team3255.robot2017.RobotMap;
import org.usfirst.frc.team3255.robot2017.commands.SetShooterSpeed;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon leftTalon = null;
	private CANTalon rightTalon = null;
	
	
	public Shooter() {
		//CANTalons
		leftTalon = new CANTalon(RobotMap.SHOOTER_LEFT_TALON);
		rightTalon = new CANTalon(RobotMap.SHOOTER_RIGHT_TALON);
		
		leftTalon.setSafetyEnabled(false);
		rightTalon.setSafetyEnabled(false);
	}
	
	public void setShooterSpeed(double speed) {
		leftTalon.set(speed);
		rightTalon.set(-speed);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new SetShooterSpeed());
    }
}

