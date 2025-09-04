// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class arcadeDrive extends SubsystemBase {
  /** Creates a new arcadeDrive. */
  private static double power;
  private static double negative;
  private static double deadzone = 0.07;
  public static double arcade(double forward, double turn, boolean left) {
    if (left) {
      negative = -1;
    } else {
      negative = 1;
    }
    power = forward + (turn * negative);
    power = (Math.abs(power) < deadzone)? 0 : power;
    return power;

  }
}