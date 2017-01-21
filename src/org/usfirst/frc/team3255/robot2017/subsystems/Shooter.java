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
	private CANTalon shootTalon = null;
	private CANTalon loadTalon = null;
	
	
	public Shooter() {
		//CANTalons
		shootTalon = new CANTalon(RobotMap.SHOOTER_SHOOT_TALON);
		loadTalon = new CANTalon(RobotMap.SHOOTER_LOAD_TALON);
		
		shootTalon.setSafetyEnabled(false);
		loadTalon.setSafetyEnabled(false);
	}
	
	public void setShooterSpeed(double speed) {
		shootTalon.set(speed);
	}
	
	public double getShooterSpeed() {
		return shootTalon.get();
	}
	
	public void setLoadSpeed(double speed) {
		loadTalon.set(speed);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new SetShooterSpeed());
    }
}

