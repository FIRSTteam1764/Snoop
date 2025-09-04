// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class tankDrive extends SubsystemBase {
  /** Creates a new tankDrive. */
  public static double tank(double leftY, double rightY, boolean left) {
    if (left) {
      return leftY;
    } else {
      return rightY;
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
