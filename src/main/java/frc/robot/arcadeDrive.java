// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class arcadeDrive extends SubsystemBase {
  /** Creates a new arcadeDrive. */
  public arcadeDrive() {

  }

  public static double getX(double x, boolean left) {
    boolean giveback = false;
    //if right wheels control and trying to turn left
    if (x<0 && !left) {
      giveback = true;
      x*=1; //go backwards
    } else if (x>0 && left) {
      giveback = true;
      x*=-1;
    } else {
      x = 0;
    }
    if (!giveback) {
        x = 0;
    }
    return x;
  }

  public static double getXWeird(double x) {
    double newX = 0;
    double neg;
    
    if (x<0) {
      neg = -1;
    } else {
      neg = 1;
    }

    x*=neg;
    x/=2;

    return newX;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
