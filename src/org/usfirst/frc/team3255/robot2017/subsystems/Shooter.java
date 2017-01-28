package org.usfirst.frc.team3255.robot2017.subsystems;

import org.usfirst.frc.team3255.robot2017.RobotMap;
import org.usfirst.frc.team3255.robot2017.commands.SetShooterSpeed;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon shootTalon = null;

	private DigitalInput ballSwitch = null;
	
	public Shooter() {
		//CANTalons
		shootTalon = new CANTalon(RobotMap.SHOOTER_SHOOT_TALON);
		
		shootTalon.setSafetyEnabled(false);
		
		//LimitSwitch
		ballSwitch = new DigitalInput(RobotMap.SHOOTER_BALL_SWITCH);
	}
	
	public double getShooterSpeed() {
		return shootTalon.get();
	}
	
	public void setShooterSpeed(double speed) {
		shootTalon.set(speed);
	}
	
	public boolean isBallDetected() {
		return ballSwitch.get();
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new SetShooterSpeed());
    }
}

