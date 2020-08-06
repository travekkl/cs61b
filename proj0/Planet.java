public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

    public static final double G = 6.67e-11;

	public Planet(double xP, double yP, double xV,
		          double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass  = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p) {
		double xDistance = xxPos - p.xxPos;
		double yDistance = yyPos - p.yyPos;
		return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
	}

	public double calcForceExertedBy(Planet p) {
		double r;
		r = this.calcDistance(p);
        return (this.G * this.mass * p.mass / r / r); 
	}

	public double calcForceExertedByX(Planet p) {
        return (this.calcForceExertedBy(p) * (p.xxPos - this.xxPos)
                      / this.calcDistance(p)); 
	}

	public double calcForceExertedByY(Planet p) {
        return (this.calcForceExertedBy(p) * (p.yyPos - this.yyPos)
                      / this.calcDistance(p)); 
	}

	public double calcNetForceExertedByX(Planet[] a) {
		double forceX = 0;
		for (Planet planetItem: a) {
			if (this.equals(planetItem)) {
				continue;
			}
            forceX += (this.calcForceExertedBy(planetItem) * (planetItem.xxPos - this.xxPos)
                      / this.calcDistance(planetItem));
		}
		return forceX;
	}

	public double calcNetForceExertedByY(Planet[] a) {
	    double forceY = 0;
		for (Planet planetItem: a) {
			if (this.equals(planetItem)) {
				continue;
			}
	        forceY += (this.calcForceExertedBy(planetItem) * (planetItem.yyPos - this.yyPos)
	                  / this.calcDistance(planetItem));
		}
		return forceY;
	}

	public boolean equals(Planet p) {
		if ((this.xxPos != p.xxPos) || (this.yyPos != p.yyPos)) {
			return false;
		}

		if ((this.xxVel != p.xxVel) || (this.yyVel != p.yyVel)) {
			return false;
		}

		if((this.mass != p.mass) || (this.imgFileName != p.imgFileName)) {
			return false;
		}
		return true;

	}

	public void update(double dt, double fX, double fY) {
        double aNetX = fX / this.mass;
        double aNetY = fY / this.mass;
        this.xxVel += dt * aNetX;
        this.yyVel += dt * aNetY;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
	}

	public void draw() {
		StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
	}
}