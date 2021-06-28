import java.awt.*;
import java.util.*;
import java.util.Random;

public class Ball {
	private double cx;
	private double cy;
	private double width;
	private double height;
	private double speed;
	private double direcaoX;
	private double direcaoY;
	private Color color;


	public Ball(double cx, double cy, double width, double height, Color color, double speed){
		this.cx = cx;
		this.cy = cy;
		this.height = height;
		this.width = width;
		this.speed = speed;
		this.color = color;
		this.direcaoX = this.direcaoRandom();
		this.direcaoY = this.direcaoRandom();

	}
	public double direcaoRandom(){
		Random random = new Random();
		int randomINt = random.nextInt(2);
		if(randomINt == 0){
			return -(Math.abs(this.speed));
		}else{
			return (Math.abs(this.speed));
		}
	}

	public void draw(){
		GameLib.setColor(this.color);
		GameLib.fillRect(this.cx, this.cy, this.width, this.height);
	}


	public void update(long delta){
		this.cx += delta * this.direcaoX;
		this.cy += delta * this.direcaoY;
	}

	public void onPlayerCollision(String playerId){
		if(playerId.equals("Player 1")){
			this.direcaoX = Math.abs(this.speed);
		}else if(playerId.equals("Player 2")){
			this.direcaoX = 0 - Math.abs(this.speed);
		}
	}

	/**
		Método chamado quando detecta-se uma colisão da bola com uma parede.
		Aqui vamos verificar se o player está colidindo com a bola e caso verdadeira atualizamos a velocidade da bola
		de maneira positiva, caso contrário de maneira negativa.
		@param wallId uma string cujo conteúdo identifica uma das paredes da quadra.
	*/

	public void onWallCollision(String wallId)
	{
		switch (wallId)
		{
			case "Top":
				this.direcaoY = Math.abs(this.speed);
			case "Bottom":
				this.direcaoY = - Math.abs(this.speed);
			case "Left":
				this.direcaoX = Math.abs(this.speed);
			case "Right":
				this.direcaoX = - Math.abs(this.speed);
		}
	}

	/**
		Método que verifica se houve colisão da bola com uma parede.

		@param wall referência para uma instância de Wall contra a qual será verificada a ocorrência de colisão da bola.
		@return um valor booleano que indica a ocorrência (true) ou não (false) de colisão.
	*/

	public boolean checkCollision(Wall wall){
		String id;
		Double Wx, Wy, Height, Width;
		id = wall.getId();
		Wx = wall.getCx(); Wy = wall.getCy();
		Height = wall.getHeight(); Width = wall.getWidth();

		switch (id)
		{
			case "Bottom":
				double bottom = this.cy + (this.height / 2);
				double wTop = wall.getCy() - (wall.getHeight() / 2);
				if(bottom >= wTop)
					return true;

			case "Top":
				double top = this.cy - (this.height / 2);
				double wBottom = wall.getCy() + (wall.getHeight() / 2);
				if(top <= wBottom)
					return true;

			case "Right":
				double right = this.cx + (this.width / 2);
				double wLeft = wall.getCx() - (wall.getWidth() / 2);
				if(right >= wLeft)
					return true;

			case "Left":
				double left = this.cx - (this.height / 2);
				double wRight = wall.getCx() + (wall.getWidth() / 2);
				if(left <= wRight)
					return true;
		}

		//verificar a posiç�o e calcular a presença ou n�o da bola dentro do espaço ocupado pela parede

		return false;*/
	}

	public boolean checkCollision(Player player){
		double top, bottom, left, right;
		double pTop, pBottom, pLeft, pRight;

		boolean rCollision, lCollision, checkMATE;

		pTop = player.getCy() - (player.getHeight() / 2);
		pBottom = player.getCy() + (player.getHeight() / 2);
		pLeft = player.getCx() - (player.getWidth() / 2);
		pRight = player.getCx() + (player.getHeight() / 2);
		top = this.cy - (this.height / 2);
		bottom = this.cy + (this.height / 2);
		left = this.cx - (this.width / 2);
		right = this.cx + (this.width / 2);

		if(left <= pRight)
			rCollision = true;
		else rCollision = false;
		if(right >= pLeft)
			lCollision = true;
		else lCollision = false;

		if(top <= pBottom && bottom >= pTop)
			checkMATE = true;
		else checkMATE = false;

		if(rCollision && lCollision && checkMATE)
			return true;

		return false;
	}

	public double getCx(){

		return this.cx;
	}

	public double getCy(){

		return this.cy;
	}

	public double getSpeed(){

		return this.speed;
	}
/**
Vídeos utilizados para fazer o algoritmo
https://www.youtube.com/watch?v=EeYJCV-A2hw
https://youtu.be/oLirZqJFKPE
*/
}
