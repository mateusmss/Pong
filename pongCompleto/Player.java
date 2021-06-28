import java.awt.*;

public class Player {
	private double cx;
	private double cy;
	private double width;
	private double height;
	private String id;
	private double speed;
	private Color color;
	private double [] v_limit;

	public Player(double cx, double cy, double width, double height, Color color, String id, double [] v_limit, double speed){
		this.cx = cx;
		this.cy = cy;
		this.id = id;
		this.width =  width;
		this.height = height;
		this.v_limit = v_limit;
		this.speed = speed;
		this.color = color;

	}

	public void draw(){
		GameLib.setColor(this.color);
		GameLib.fillRect(this.cx,this.cy,this.width,this.height);
	}


	public void moveUp(long delta){
		double movimento = this.speed * delta;
		if(((getCy() - (getHeight()/2)) - movimento) > v_limit[0]) {
				this.cy = getCy() - movimento;
			}else{
				this.cy = v_limit[0] + (getHeight()/2);
			}
			//v_limit[0] significa a parte de cime da área do jogo
	}

	public void moveDown(long delta){
		double movimento = this.speed * delta;
		if(((getCy() + (getHeight()/2)) + movimento) < v_limit[1]){
			this.cy = getCy() + movimento;
		}else{
			this.cy = v_limit[1] - (getHeight()/2);
		}
		//v_limit[1] significa a parte de baixo da área do jogo
	}

	public String getId() {
		return this.id;
	}

	public double getWidth() {
		return this.width;
	}

	public double getHeight() {
		return this.height;
	}

	public double getCx() {
		return this.cx;
	}

	public double getCy() {
		return this.cy;
	}
}
