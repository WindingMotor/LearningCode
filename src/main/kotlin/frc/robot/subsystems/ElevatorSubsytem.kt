package frc.robot.subsystems

import edu.wpi.first.wpilibj2.command.CommandBase
import edu.wpi.first.wpilibj2.command.SubsystemBase
import edu.wpi.first.math.controller.PIDController
import edu.wpi.first.math.filter.SlewRateLimiter
import frc.robot.wmlib.SparkMax

class ElevatorSubsystem : SubsystemBase() {

    val elevatorOneMotor = SparkMax(8, false, 1.0, 1.0)
    val elevatorTwoMotor = SparkMax(9, false, 1.0, 1.0)

    val elevatorOnePID = PIDController(10.0, 15.12, 3.0)
    val elevatorTwoPID = PIDController(10.0, 15.12, 3.0)

    val elevatorOneSlew = SlewRateLimiter(5.0)
    val elevatorTwoSlew = SlewRateLimiter(5.0)

    
    fun init(){     }

    override fun periodic(){    }

    fun elevatorOneSetSpeed(speed: Double){
        elevatorOneMotor.set(   elevatorOneSlew.calculate(elevatorOnePID.calculate(elevatorOneMotor.encoder.getPosition(), speed))  )
    }
        
    fun elevatorTwoSetSpeed(speed: Double) {
        elevatorTwoMotor.set(   elevatorTwoSlew.calculate(elevatorTwoPID.calculate(elevatorOneMotor.encoder.getPosition(), speed))  )
    }


}
