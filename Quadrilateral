
/*=================================================================
Program name - Quadrilaterals
Author - Avery Chiu 
Date - 2018/11/19
Programming Language, version number - Java 9
=================================================================
 */

public abstract class Quadrilateral {
	private static int numQ = 0;

	Quadrilateral() {
		numQ++;
	}

	public static int getNumQ() {
		return numQ;
	}

	public abstract String getKey();

	public abstract double findArea();

	public abstract double findPerimeter();

}// End of Quadrilateral class

class Square extends Quadrilateral {
	private double sideLength;
	private static int numSquareCount = 0;
	private String key;

	public Square() {
		super();
		sideLength = 1;
		if (getClass().equals(Square.class)) {
			numSquareCount++;
			key = "squ" + numSquareCount;
		}
	}

	public Square(double sideLength) {
		super();
		this.sideLength = sideLength;
		if (getClass().equals(Square.class))
			numSquareCount++;
		key = "squ" + numSquareCount;
	}

	@Override
	public String getKey() {
		return key;
	}

	public double getSideLength() {
		return sideLength;
	}

	public void setSideLength(double sideLength) {
		this.sideLength = sideLength;
	}

	public static int getNumSquareCount() {
		return numSquareCount;
	}

	@Override
	public double findArea() {
		return sideLength * sideLength;
	}

	@Override
	public double findPerimeter() {
		return sideLength * 4;
	}

	@Override
	public String toString() {
		return "Square key= " + key + " sideLength=" + sideLength + " units, Perimeter=" + findPerimeter()
				+ " units, Area=" + findArea() + " units^2";
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Square) {
			Square c = (Square) o;
			return (this.sideLength == c.sideLength);

		}
		return false;

	}

}// End of Square class

class Rectangle extends Square {
	private double width;
	private static int numRectangleCount = 0;
	private String key;

	public Rectangle() {
		super();
		width = 1;
		if (getClass().equals(Rectangle.class))
			numRectangleCount++;
		key = "rec" + numRectangleCount;
	}

	public Rectangle(double sideLength, double width) {
		super(sideLength);
		this.width = width;
		if (getClass().equals(Rectangle.class))
			numRectangleCount++;
		key = "rec" + numRectangleCount;
	}

	@Override
	public String getKey() {
		return key;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public static int getNumRectangleCount() {
		return numRectangleCount;
	}

	@Override
	public double findArea() {
		return getSideLength() * width;
	}

	@Override
	public double findPerimeter() {
		return 2 * (getSideLength() + width);
	}

	@Override
	public String toString() {
		return "Rectangle key= " + key + " sidelength=" + getSideLength() + " units, width=" + width
				+ " units, Perimeter=" + findPerimeter() + " units Area=" + findArea() + " units^2";
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Rectangle) {
			Rectangle c = (Rectangle) o;
			return (getSideLength() == c.getSideLength() && this.width == c.width);

		}
		return false;

	}
}// End of Rectangle class

class Parallelogram extends Rectangle {
	private double height;
	private static int numParallelogramCount = 0;
	private String key;

	public Parallelogram() {
		super();
		height = 1;
		if (getClass().equals(Parallelogram.class))
			numParallelogramCount++;
		key = "par" + numParallelogramCount;
	}

	public Parallelogram(double sideLength, double width, double height) {
		super(sideLength, width);
		this.height = height;
		if (getClass().equals(Parallelogram.class))
			numParallelogramCount++;
		key = "par" + numParallelogramCount;
	}

	@Override
	public String getKey() {
		return key;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

	public static int getNumParallelogramCount() {
		return numParallelogramCount;
	}

	@Override
	public double findArea() {
		return (getWidth() * height) / 2;
	}

	@Override
	public double findPerimeter() {
		return 2 * (getSideLength() + getWidth());
	}

	@Override
	public String toString() {
		return "Parallelogram key= " + key + " sidelength= " + getSideLength() + " units, width=" + getWidth()
				+ " units,  height=" + height + " units, Perimeter=" + findPerimeter() + " units, Area=" + findArea()
				+ " units^2";
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Parallelogram) {
			Parallelogram c = (Parallelogram) o;
			return (getSideLength() == c.getSideLength() && getWidth() == c.getWidth() && this.height == c.height);
		}
		return false;

	}
}// End of Parallelogram class

class Trapezoid extends Parallelogram {
	private double topBase;
	private static int numTrapezoidCount = 0;
	private String key;

	public Trapezoid() {
		super();
		topBase = 1;
		if (getClass().equals(Trapezoid.class))
			numTrapezoidCount++;
		key = "tra" + numTrapezoidCount;
	}

	public Trapezoid(double sideLength, double width, double height, double topBase) {
		super(sideLength, width, height);
		this.topBase = topBase;
		if (getClass().equals(Trapezoid.class))
			numTrapezoidCount++;
		key = "tra" + numTrapezoidCount;
	}

	@Override
	public String getKey() {
		return key;
	}

	public void setTopBase(double topBase) {
		this.topBase = topBase;
	}

	public double getTopBase() {
		return topBase;
	}

	public static int getNumTrapezoidCount() {
		return numTrapezoidCount;
	}

	@Override
	public double findArea() {
		return ((topBase + getWidth()) * getHeight()) / 2;
	}

	@Override
	public double findPerimeter() {
		return 2 * getSideLength() + getWidth() + topBase;
	}

	@Override
	public String toString() {
		return "Trapezoid key= " + key + " sidelength=" + getSideLength() + " units ,width=" + getWidth()
				+ " units ,height=" + getHeight() + " units ,topBase=" + topBase + " units, Perimeter="
				+ findPerimeter() + "units, Area=" + findArea() + " units^2";
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Trapezoid) {
			Trapezoid c = (Trapezoid) o;
			return (getSideLength() == c.getSideLength() && getWidth() == c.getWidth() && getHeight() == c.getHeight()
					&& this.topBase == c.topBase);
		}
		return false;

	}
}// end of Trapezoid class

class Rhombus extends Square {
	private double diagonal1;
	private double diagonal2;
	private static int numRhombusCount = 0;
	private String key;

	public Rhombus() {
		super();
		diagonal1 = 1;
		diagonal2 = 1;
		if (getClass().equals(Rhombus.class))
			numRhombusCount++;
		key = "rho" + numRhombusCount;
	}

	public Rhombus(double sideLength, double diagonal1, double diagonal2) {
		super(sideLength);
		this.diagonal1 = diagonal1;
		this.diagonal2 = diagonal2;
		if (getClass().equals(Rhombus.class))
			numRhombusCount++;
		key = "rho" + numRhombusCount;
	}

	@Override
	public String getKey() {
		return key;
	}

	public void setDiagonal1(double diagonal1) {
		this.diagonal1 = diagonal1;
	}

	public double getDiagonal1() {
		return diagonal1;
	}

	public void setDiagonal2(double diagonal2) {
		this.diagonal2 = diagonal2;
	}

	public double getDiagonal2() {
		return diagonal2;
	}

	public static int getNumRhombusCount() {
		return numRhombusCount;
	}

	@Override
	public double findArea() {
		return (diagonal1 * diagonal2) / 2;
	}

	@Override
	public double findPerimeter() {
		return getSideLength() * 4;
	}

	@Override
	public String toString() {
		return "Rhombus key= " + key + " sideLength=" + getSideLength() + " units ,diagonal1=" + diagonal1
				+ " units ,diagonal2=" + diagonal2 + "units, Perimeter=" + findPerimeter() + " units, Area="
				+ findArea() + " units^2";
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Rhombus) {
			Rhombus c = (Rhombus) o;
			return (getSideLength() == c.getSideLength() && this.diagonal1 == c.diagonal1
					&& this.diagonal2 == c.diagonal2);

		}
		return false;

	}
}// End of Rhombus class

class Kite extends Rhombus {
	private double otherSide;
	private static int numKiteCount = 0;
	private String key;

	public Kite() {
		super();
		otherSide = 1;
		if (getClass().equals(Kite.class))
			numKiteCount++;
		key = "kit" + numKiteCount;
	}

	public Kite(double sideLength, double diagonal1, double diagonal2, double otherSide) {
		super(sideLength, diagonal1, diagonal2);
		this.otherSide = otherSide;
		if (getClass().equals(Kite.class))
			numKiteCount++;
		key = "kit" + numKiteCount;
	}

	@Override
	public String getKey() {
		return key;
	}

	public void setOtherSide(double otherSide) {
		this.otherSide = otherSide;
	}

	public double getOtherSide() {
		return otherSide;
	}

	public static int getNumKiteCount() {
		return numKiteCount;
	}

	@Override
	public double findArea() {
		return (getDiagonal1() * getDiagonal2()) / 2;
	}

	@Override
	public double findPerimeter() {
		return 2 * (otherSide + getSideLength());
	}

	@Override
	public String toString() {
		return "Kite key= " + key + " sideLength=" + getSideLength() + " units ,diagonal1= " + getDiagonal1()
				+ " units ,diagonal2=" + getDiagonal2() + " units ,other adjacent side=" + otherSide
				+ " units Perimeter=" + findPerimeter() + " units Area=" + findArea() + " units^2";
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Kite) {
			Kite c = (Kite) o;
			return (getSideLength() == c.getSideLength() && getDiagonal1() == c.getDiagonal1()
					&& getDiagonal2() == c.getDiagonal2() && this.otherSide == c.otherSide);
		}
		return false;
	}

}// End of Kite class
