// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.SnowPlowSubsystem;
import static frc.robot.Constants.SnowPlowConstants;

public class EjectCommand extends Command {
 
  SnowPlowSubsystem m_intake;

  public EjectCommand(SnowPlowSubsystem intake) {
    addRequirements(intake);
    this.m_intake = intake;
  }

  // Called when the command is initially scheduled. Set the rollers to the
  // appropriate values for ejecting
  @Override
  public void initialize() {
    m_intake
        .setIntakeLauncherRoller(
            -1 * SmartDashboard.getNumber("Intaking intake roller value", SnowPlowConstants.kIntakingIntakeVoltage));
    m_intake
        .setFeederRoller(-1 * SmartDashboard.getNumber("Intaking feeder roller value", SnowPlowConstants.kIntakingFeederVoltage));
  }

  // Called every time the scheduler runs while the command is scheduled. This
  // command doesn't require updating any values while running
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted. Stop the rollers
  @Override
  public void end(boolean interrupted) {
    m_intake.setIntakeLauncherRoller(0);
    m_intake.setFeederRoller(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
