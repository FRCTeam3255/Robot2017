package org.usfirst.frc.team3255.robot2017.subsystems;

import org.usfirst.frc.team3255.robot2017.RobotMap;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//CANTalons
	private WPI_TalonSRX leftTalon = null;
	private WPI_TalonSRX rightTalon = null;

	public Climber() {
		//CANTalons
		leftTalon = new WPI_TalonSRX(RobotMap.CLIMBER_LEFT_TALON);
		rightTalon = new WPI_TalonSRX(RobotMap.CLIMBER_RIGHT_TALON);
		
		leftTalon.setNeutralMode(NeutralMode.Brake);
		rightTalon.setNeutralMode(NeutralMode.Brake);
		
		leftTalon.setSafetyEnabled(false);
		rightTalon.setSafetyEnabled(false);	
	}
	
	public void forwardLowSpeed() {
		setClimberSpeed(-0.5);
	}
	
	public void forwardHighSpeed() {
		setClimberSpeed(-1.0);
	}
	
	public void stop() {
		setClimberSpeed(0);		
	}
	
	private void setClimberSpeed(double speed) {
		leftTalon.set(speed);
		rightTalon.set(speed);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

