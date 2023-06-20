package frc.robot.subsystems

import edu.wpi.first.wpilibj2.command.CommandBase
import edu.wpi.first.wpilibj2.command.SubsystemBase
import edu.wpi.first.math.controller.PIDController
import frc.robot.wmlib.SparkMax

/** Creates a new ExampleSubsystem.  */
class ExampleSubsystem : SubsystemBase() {


    val motorOne = SparkMax(1, false)


    
    fun exampleMethodCommand(): CommandBase {
        // Inline construction of command goes here.
        // runOnce implicitly requires this subsystem.
        return runOnce {}
    }

    fun exampleCondition(): Boolean {
        // Query some boolean state, such as a digital sensor.
        return false
    }

    /** This method will be called once per scheduler run  */
    override fun periodic() {
        
    }

    /** This method will be called once per scheduler run during simulation  */
    override fun simulationPeriodic() {
    }


}
