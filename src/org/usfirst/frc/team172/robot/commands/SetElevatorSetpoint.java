
package org.usfirst.frc.team172.robot.commands;

import org.usfirst.frc.team172.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetElevatorSetpoint extends Command {

	private final double m_setpoint;
	
    public SetElevatorSetpoint(double setpoint) {
        requires(Robot.elevator);
        m_setpoint = setpoint;
    }

    protected void initialize() {
    	Robot.elevator.setSetpoint(m_setpoint);
    }


    protected void execute() {
    }

    protected boolean isFinished() {
        return Robot.elevator.onTarget();
    }


    protected void end() {
    }


    protected void interrupted() {
    	end();
    }
}
