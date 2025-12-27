// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private final RobotContainer m_robotContainer;
  Joystick driverJoystick = new Joystick(0);
  public Robot() {
    m_robotContainer = new RobotContainer();
  }

  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();


    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    if(driverJoystick.getRawButton(1)){
      RobotContainer.motorSubsystem.krakenMotor(6);
    }
    else if(driverJoystick.getRawButton(2)){
      RobotContainer.motorSubsystem.krakenMotor(-6);
    }
    else if(driverJoystick.getRawButton(3)){
      RobotContainer.motorSubsystem.neoMotor(6);
    }
    else if(driverJoystick.getRawButton(4)){
      RobotContainer.motorSubsystem.neoMotor(-6);
    }
    else{
      RobotContainer.motorSubsystem.krakenMotor(0);
      RobotContainer.motorSubsystem.neoMotor(0);
    }
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
