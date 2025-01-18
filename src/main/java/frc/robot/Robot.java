// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {
  public PWMTalonSRX frontRight;
  public PWMTalonSRX frontLeft;
  public PWMTalonSRX backLeft;
  public PWMTalonSRX backRight;
  public XboxController controller;
  public Joystick joystick;
  public final double deadzone = 0.07;
  public final double maxspeed = 0.5;


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  public Robot() {
    controller = new XboxController(0);
    joystick = new Joystick(1);
  
    frontRight = new PWMTalonSRX(0); 
    frontLeft = new PWMTalonSRX(7);
    backRight = new PWMTalonSRX(8);
    backLeft = new PWMTalonSRX(9);

    frontRight.addFollower(backRight);
    frontLeft.addFollower(backLeft);
    frontLeft.setInverted(true);

  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    //double leftPower = controller.getLeftY() + arcadeDrive.getX(controller.getLeftX(), true);
    //double rightPower = controller.getLeftY() + arcadeDrive.getX(controller.getLeftX(), false);
    double leftPower = joystick.getY() + arcadeDrive.getX(joystick.getX(), true);
    double rightPower = joystick.getY() + arcadeDrive.getX(joystick.getX(), false);
    leftPower = (Math.abs(leftPower) < deadzone)? 0 : leftPower;
    rightPower = (Math.abs(rightPower) < deadzone)? 0 : rightPower;
    frontLeft.set(leftPower*maxspeed);
    frontRight.set(rightPower*maxspeed);

  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {


  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}
}
