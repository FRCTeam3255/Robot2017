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
	private CANTalon loadTalon = null;
	
	private CANTalon hopperTalon = null;
	
	private DigitalInput ballSwitch = null;
	
	public Shooter() {
		//CANTalons
		shootTalon = new CANTalon(RobotMap.SHOOTER_SHOOT_TALON);
		loadTalon = new CANTalon(RobotMap.SHOOTER_LOAD_TALON);
		hopperTalon = new CANTalon(RobotMap.SHOOTER_HOPPER_TALON);
		//LimitSwitch
		ballSwitch = new DigitalInput(RobotMap.SHOOTER_BALL_SWITCH);
		
		shootTalon.setSafetyEnabled(false);
		loadTalon.setSafetyEnabled(false);
		hopperTalon.setSafetyEnabled(false);
	}
	
	public void loaderEnable() {
		loadTalon.set(0.6);
		hopperTalon.set(0.6);
	}
	
	public void loaderDisable() {
		loadTalon.set(0.0);
		hopperTalon.set(0.0);
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

