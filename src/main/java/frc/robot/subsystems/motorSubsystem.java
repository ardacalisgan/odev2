// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class motorSubsystem extends SubsystemBase {
  
  final TalonFX motor = new TalonFX(10);
  final SparkMax motor2 = new SparkMax(11, MotorType.kBrushless);

  final VoltageOut voltageOut = new VoltageOut(0);

  public motorSubsystem() {}

  public void krakenMotor(double volt){
    motor.setControl(voltageOut.withOutput(volt));
  }

  public void neoMotor (double volt){
    motor2.setVoltage(volt);
  }

  @Override
  public void periodic() {
    
  }
}
