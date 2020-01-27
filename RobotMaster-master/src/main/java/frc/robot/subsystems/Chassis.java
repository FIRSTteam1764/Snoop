/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Chassis extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Spark left1 = new Spark(1);
  Spark left2 = new Spark(0);
  Spark right1 = new Spark(8);
  Spark right2 = new Spark(9);

  public void setLeft(double _speed, double _throttle){
    left1.set(inDeadZone(-_speed*_throttle)  ? positiveOrNegative(-_speed*_throttle) : -_speed*_throttle);
    left2.set(inDeadZone(-_speed*_throttle) ? positiveOrNegative(-_speed*_throttle) : -_speed*_throttle);
  }

  public void setRight(double _speed, double _throttle){
    right1.set(inDeadZone(_speed*_throttle) ? positiveOrNegative(_speed*_throttle) : _speed*_throttle);
    right2.set(inDeadZone(_speed*_throttle) ? positiveOrNegative(_speed*_throttle) : _speed*_throttle);
  }

  public boolean inDeadZone(double speed){
    return speed>.75 || speed<-.75;
  }

  public double positiveOrNegative(double speed){
    if(speed>0){
      return .75;
    }

     return -.75;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    
  }
}
