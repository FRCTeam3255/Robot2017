package org.usfirst.frc.team3255.robot2017.subsystems;

import org.usfirst.frc.team3255.robot2017.commands.DriveResetEncoder;
import org.usfirst.frc.team3255.robot2017.commands.TelemetryUpdate;
import org.usfirst.frc.team3255.robot2017.Robot;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Telemetry extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Telemetry() {
		update();
		SmartDashboard.putData("Drive Reset Encoders", new DriveResetEncoder());
	}
	
	public void update() {
		//Shooter
		SmartDashboard.putNumber("Shooter Speed", Robot.shooter.getShooterSpeed());
		
		//Drivetrain
		SmartDashboard.putNumber("Drivetrain Encoder Position", Robot.drivetrain.getEncoderPosition());
		
		//Climber
		SmartDashboard.putBoolean("Climber Switch Closed", Robot.climber.isClimberSwitchClosed());
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TelemetryUpdate());
    }
}

