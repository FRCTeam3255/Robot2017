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
	private CANTalon climbTalon = null;
	
	// Switches
	private DigitalInput climberSwitch = null;
	private DigitalInput climberEnableSwitch = null;
	
	public Climber() {
		//CANTalons
		climbTalon = new CANTalon(RobotMap.CLIMBER_CLIMB_TALON);
		
		climbTalon.setSafetyEnabled(false);
		
		//DigitalInputs
		climberSwitch = new DigitalInput(RobotMap.CLIMBER_CLIMB_SWITCH);
		climberEnableSwitch = new DigitalInput(RobotMap.CLIMBER_ENABLE_CLIMB_SWITCH);
	}
	
	public void setClimberSpeed(double speed) {
		climbTalon.set(speed);
	}
	
	public boolean isClimberSwitchClosed() {
		return climberSwitch.get();
	}
	
	public boolean isClimberEnabled() {
		return climberEnableSwitch.get();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

