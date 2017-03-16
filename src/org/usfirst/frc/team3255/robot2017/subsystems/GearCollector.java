package org.usfirst.frc.team3255.robot2017.subsystems;

import org.usfirst.frc.team3255.robot2017.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearCollector extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon gearTalon = null;
	
	private DoubleSolenoid gearSolenoid = null;
	
	public GearCollector() {
		//CANTalons
		gearTalon = new CANTalon(RobotMap.GEAR_COLLECTOR_TALON);
		
		gearTalon.setSafetyEnabled(false);
		
		//Solenoids
		gearSolenoid = new DoubleSolenoid(RobotMap.GEAR_SHIFT_UP, RobotMap.GEAR_SHIFT_DOWN);
	}
	
	//CANTalons
	public void intakeRelease() {
		setGearSpeed(-1.0);	
	}
		
	public void setGearSpeed(double speed) {
		gearTalon.set(speed);
	}
	
	//Solenoids
	public void deployPiston() {
		gearSolenoid.set(Value.kForward);
	}
		
	public void retractPiston() {
		gearSolenoid.set(Value.kReverse);
	}	
		
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
