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
		gearSolenoid = new DoubleSolenoid(RobotMap.GEAR_DEPLOY, RobotMap.GEAR_RETRACT);
	}
	
	//CANTalons
	
	public void setGearSpeed(double speed) {
		gearTalon.set(speed);
	}
	
	public void intakeCollect() {
		setGearSpeed(0.4);
	}
	
	public void intakeRelease() {
		setGearSpeed(-0.3);
	}
	
	public void intakeStop() {
		setGearSpeed(0.0);
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

