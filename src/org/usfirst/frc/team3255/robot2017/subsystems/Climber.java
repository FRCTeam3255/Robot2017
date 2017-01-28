package org.usfirst.frc.team3255.robot2017.subsystems;

import org.usfirst.frc.team3255.robot2017.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//CANTalons
	private CANTalon leftTalon = null;
	private CANTalon rightTalon = null;
	
	// Switches
	private DigitalInput touchpadSwitch = null;
	private DigitalInput enableSwitch = null;
	
	public Climber() {
		//CANTalons
		leftTalon = new CANTalon(RobotMap.CLIMBER_LEFT_TALON);
		rightTalon = new CANTalon(RobotMap.CLIMBER_RIGHT_TALON);
		
		leftTalon.setSafetyEnabled(false);
		rightTalon.setSafetyEnabled(false);	
		
		//DigitalInputs
		touchpadSwitch = new DigitalInput(RobotMap.CLIMBER_TOUCHPAD_SWITCH);
		enableSwitch = new DigitalInput(RobotMap.CLIMBER_ENABLE_SWITCH);
	}
	
	public void forward() {
		setClimberSpeed(1.0);
	}
	
	public void stop() {
		setClimberSpeed(0);		
	}
	
	private void setClimberSpeed(double speed) {
		leftTalon.set(speed);
		rightTalon.set(-speed);
	}
	
	public boolean isTouchpadSwitchClosed() {
		return touchpadSwitch.get();
	}
	
	public boolean isClimberEnabled() {
		return enableSwitch.get();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

