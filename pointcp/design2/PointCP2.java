package pointcp.design2;
import java.io.IOException;
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
public class PointCP2 {
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
   
    return (Math.cos(Math.toRadians(this.theta)) * this.rho);
 
  }
  public double getY() {
    
    return (Math.sin(Math.toRadians(this.theta)) * this.rho);
 
  }
  public double getRho() {
    return this.rho;

  }
  public double getTheta() {
  
    return this.theta;
  }
  /**
   * Converts Cartesian coordinates to Polar coordinates.
   */
  public void convertStorageToPolar() {
    return;
  }
  /**
   * Converts Polar coordinates to Cartesian coordinates.
   */
  public PointCP3 convertStorageToCartesian() {
    PointCP3 conversion = new PointCP3(getX(), getY());
    return conversion;
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
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();
    return new PointCP3(
        (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
        (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y))
        .convertStorageToPolar();
  }
  /**
   * Returns information about the coordinates.
   *
   * @return A String containing information about the coordinates.
   */
  public String toString() {

  return "Stored as Polar ["+ getRho()+ ','+ getTheta()+ "]"+ "\n"+ "Computed as Cartesian ["+ getX()+ ','+ getY()+ "]";
  }
}
