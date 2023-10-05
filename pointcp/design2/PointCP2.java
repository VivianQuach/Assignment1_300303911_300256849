package design2;
import design5.PointCP5; 
import java.lang.Math;


// @author Amr Bakouban 300256849


// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com
/**
 * This class contains instances of coordinates in either polar or
 * cartesian format. It also provides the utilities to convert
 * them into the other type. It is not an optimal design, it is used
 * only to illustrate some design issues.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @version July 2000
 */
public class PointCP2 extends PointCP5{
  // Instance variables ************************************************
  /**
   * Contains the current value of X or RHO depending on the type
   * of coordinates.
   */
  private double rho;
  /**
   * Contains the current value of Y or THETA value depending on the
   * type of coordinates.
   */
  private double theta;
  // Constructors ******************************************************
  /**
   * Constructs a coordinate object, with a type identifier.
   */
  public PointCP2(double rho, double theta) {
    this.rho = rho;
    this.theta = theta;
  }
  // Instance methods **************************************************
  public double getX() {
   
    return rho * Math.cos(theta);
    
  }
  public double getY() {
    
    return rho * Math.sin(theta);
 
  }
  public double getRho() {
    return this.rho;

  }
  public double getTheta() {
  
    return this.theta;
  }
  /**
   * Calculates the distance in between two points using the Pythagorean
   * theorem (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
   *
   * @param pointB The second point.
   * @return The distance between the two points.
   */
  public double getDistance(PointCP2 pointB) {
    // Obtain differences in X and Y, sign is not important as these values
    // will be squared later.
    double deltaX = getX() - pointB.getX();
    double deltaY = getY() - pointB.getY();
    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
  }
  /**
   * Rotates the specified point by the specified number of degrees.
   * Not required until E2.30
   *
   * @param rotation The number of degrees to rotate the point.
   * @return The rotated image of the original point.
   */
  public PointCP2 rotatePoint(double rotation) {
    return new PointCP2(rho, theta + Math.toRadians(rotation) % (2 * Math.PI));
  }
  /**
   * Returns information about the coordinates.
   *
   * @return A String containing information about the coordinates.
   */
  public String toString() {

  return "Stored as Polar ["+ getRho()+ ','+ getTheta()+ "]"+ "\n"+ "Computed as Cartesian ["+ getX()+ ','+ getY()+ "]";
  }
  @Override
  public double getDistance(PointCP5 p) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getDistance'");
  }
}
