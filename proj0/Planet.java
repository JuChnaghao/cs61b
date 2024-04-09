public class Planet
{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	private static final double G = 6.67e-11;
	public Planet(double xP, double yP, double xV,double yV, double m, String img)
	{
		xxPos=xP;
		yyPos=yP;
		xxVel=xV;
		yyVel=yV;
		mass=m;
		imgFileName=img;
	}
	public Planet(Planet p)
	{
		xxPos=p.xxPos;
		yyPos=p.yyPos;
		xxVel=p.xxVel;
		yyVel=p.yyVel;
		mass=p.mass;
		imgFileName=p.imgFileName;
	}
	public double calcDistance(Planet p)
	{
		double r2;
		r2=(p.xxPos-this.xxPos)*(p.xxPos-this.xxPos)+(p.yyPos-this.yyPos)*(p.yyPos-this.yyPos);
		return Math.sqrt(r2);
	}
	public double calcForceExertedBy(Planet p)
	{
		double force;
		double distance;
		distance=calcDistance(p);
		force = G*mass*p.mass/(distance*distance);
		return force;
	}
	public double calcForceExertedByX(Planet p)
	{
		return this.calcForceExertedBy(p)*(p.xxPos-this.xxPos)/this.calcDistance(p);
	}
	public double calcForceExertedByY(Planet p)
	{
		return this.calcForceExertedBy(p)*(p.yyPos-this.yyPos)/this.calcDistance(p);
	}
	public double calcNetForceExertedByX(Planet[] p)
	{
		double netforce=0;
		for(Planet q:p)
		{
			if(!this.equals(q))
			{
				netforce=netforce+this.calcForceExertedByX(q);
			}
		}
		return netforce;
	}
	public double calcNetForceExertedByY(Planet[] p)
	{
		double netforce=0;
		for(Planet q:p)
		{
			if(!this.equals(q))
			{
				netforce=netforce+this.calcForceExertedByY(q);
			}
		}
		return netforce;
	}
	public void update(double dt,double fx,double fy)
	{
		double ax,ay;
		ax=fx/mass;
		ay=fy/mass;
		xxVel=xxVel+ax*dt;
		yyVel=yyVel+ay*dt;
		xxPos=xxPos+xxVel*dt;
		yyPos=yyPos+yyVel*dt;
	}
	public void draw()
	{
		StdDraw.picture(xxPos,yyPos,"images/" + imgFileName);
	}
}