
package frc.robot.subsystems
import edu.wpi.first.wpilibj2.command.CommandBase
import edu.wpi.first.wpilibj2.command.SubsystemBase
import edu.wpi.first.math.controller.PIDController
import edu.wpi.first.math.filter.SlewRateLimiter
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import com.revrobotics.CANSparkMaxLowLevel.MotorType
import com.revrobotics.CANSparkMax.IdleMode
import frc.robot.wmlib.SparkMax
import com.revrobotics.CANSparkMax

class DriveSubsystem : SubsystemBase() {
    
    // Motor objects for left side of robot
    val motorOne: CANSparkMax = CANSparkMax(1, MotorType.kBrushless).apply{ setInverted(false); setIdleMode(IdleMode.kBrake); }
    val motorTwo: CANSparkMax = CANSparkMax(2, MotorType.kBrushless).apply{ setInverted(false); setIdleMode(IdleMode.kBrake); }
    val motorThree: CANSparkMax = CANSparkMax(3, MotorType.kBrushless).apply{ setInverted(false); setIdleMode(IdleMode.kBrake); }
    
    // Motor objects for right side of robot
    val motorFour: CANSparkMax = CANSparkMax(4, MotorType.kBrushless).apply{ setInverted(false); setIdleMode(IdleMode.kBrake); }
    val motorFive: CANSparkMax = CANSparkMax(5, MotorType.kBrushless).apply{ setInverted(false); setIdleMode(IdleMode.kBrake); }
    val motorSix: CANSparkMax = CANSparkMax(6, MotorType.kBrushless).apply{ setInverted(false); setIdleMode(IdleMode.kBrake); }
    
    // Left/right motor controller groups
    val leftMotors = MotorControllerGroup(motorOne, motorTwo, motorThree).apply{ setInverted(true); }
    val rightMotors = MotorControllerGroup(motorFour, motorFive, motorSix)

    // Input slew rate limiters
    val xSlew = SlewRateLimiter(5.0)
    val rSlew = SlewRateLimiter(7.0)
    
    // Drive controlling class, modifies motor speeds depending on inputs
    val differentialDrive = DifferentialDrive(leftMotors, rightMotors)

    // Calls when class is instantiated
    init{}

    override fun periodic(){}

    /*
    Drives the robot with a slew rate limiter on the inputs and calls to
    the differentialDrive object to control the motor speeds

    @parameter (xInput) (Double) The drive speed of the robot
    @parameter (rInput) (Double) The rotation speed of the robot
    */
    fun drive(xInput: Double, rInput: Double){
        differentialDrive.arcadeDrive(xSlew.calculate(xInput), rSlew.calculate(rInput)) 
    }

    fun stop(){
        leftMotors.set(0.0);
        rightMotors.set(0.0)
    }

}