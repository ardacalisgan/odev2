// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.motorSubsystem;


public class RobotContainer {
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public static motorSubsystem motorSubsystem = new motorSubsystem();

  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}