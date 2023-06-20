
package frc.robot.subsystems
import edu.wpi.first.wpilibj2.command.CommandBase
import edu.wpi.first.wpilibj2.command.SubsystemBase
import edu.wpi.first.math.controller.PIDController
import frc.robot.wmlib.SparkMax
import com.revrobotics.CANSparkMax

// intake run full ; intake stop ; intake setSpeed (passed variable)
class IntakeSubsystem : SubsystemBase() {

    
    val motor = SparkMax(7, false)

    init{
    
    }

    override fun periodic() {
        
    }

fun IntakeRun(speed: Double) {
    motor.set(speed);
}

}