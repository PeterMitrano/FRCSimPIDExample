
package org.usfirst.frc.team172.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Elevator extends PIDSubsystem {
    

	private final Talon motor;
	private final Encoder encoder;
	
    public Elevator() {
		super("elevator", 0, 0, 0);
		encoder = new Encoder(0,1);
		motor = new Talon(6);
		getPIDController().setContinuous(false);
		
		LiveWindow.addActuator("elevator", "elevator_pid", getPIDController());
	}

	public void initDefaultCommand() {
    }

	@Override
	protected double returnPIDInput() {
		return encoder.pidGet();
	}

	@Override
	protected void usePIDOutput(double output) {
		if (!Double.isNaN(output)){
			motor.set(output);
		}
	}
}

