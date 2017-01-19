package org.usfirst.frc.team3255.robot2017.subsystems;

import org.usfirst.frc.team3255.robot2017.commands.DriveResetEncoder;
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
		SmartDashboard.putNumber("Drivetrain Encoder Position", Robot.drivetrain.getEncoderPosition());
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

