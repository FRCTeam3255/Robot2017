package org.usfirst.frc.team3255.robot2017;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//CAN Talons
	public static final int DRIVETRAIN_LEFT_FRONT_TALON = 1;
	public static final int DRIVETRAIN_LEFT_BACK_TALON = 2;
	public static final int DRIVETRAIN_RIGHT_FRONT_TALON = 3;
	public static final int DRIVETRAIN_RIGHT_BACK_TALON = 4;
	

	public static final int SHOOTER_SHOOT_TALON = 5;
	public static final int SHOOTER_LOAD_TALON = 6;
	public static final int SHOOTER_HOPPER_TALON = 7;
	
	public static final int COLLECTOR_INTAKE_TALON = 8;
	
	public static final int CLIMBER_CLIMB_TALON = 9;

	//DigitalInputs
	public static final int CLIMBER_ENABLE_CLIMB_SWITCH = 0;
	public static final int CLIMBER_CLIMB_SWITCH = 1;
	public static final int SHOOTER_BALL_SWITCH = 2;
	
	//Solenoids
	public static final int DRIVETRAIN_SHIFT_UP = 0;
	public static final int DRIVETRAIN_SHIFT_DOWN = 1;
	
	//Joysticks
	public static final int JOYSTICK_DRIVER = 0;
	public static final int JOYSTICK_SHOOTER = 1;
	
	public static final int DRIVER_MOVE_AXIS = 1;
	public static final int DRIVER_ROTATE_AXIS = 2;
	
	public static final int SHOOTER_SPEED_AXIS = 3;
	
	//PCM
	public static final int ROBOT_PCM = 0;

}
