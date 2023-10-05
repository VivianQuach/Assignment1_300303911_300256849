package design5; 


public abstract class PointCP5 {
    public abstract double getX();
	public abstract double getY();
	public abstract double getRho();
	public abstract double getTheta();
	public abstract double getDistance(PointCP5 p);
	public abstract PointCP5 rotatePoint(double d);
}
