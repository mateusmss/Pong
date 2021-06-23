import java.awt.*;
import java.util.*;
/**
	Esta classe representa a bola usada no jogo. A classe princial do jogo (Pong)
	instancia um objeto deste tipo quando a execução é iniciada.
*/

public class Ball {
	private double cx;
	private double cy;
	private double width;
	private double height;
	private double speed;
	private long delta;
	private double direcaoX;
	private double direcaoY;
	GameLib GameLib = new GameLib();
	java.awt.Color color = new Color(2);
	Random random = new Random();




	/**
		Construtor da classe Ball. Observe que quem invoca o construtor desta classe define a velocidade da bola
		(em pixels por millisegundo), mas não define a direção deste movimento. A direção do movimento é determinada
		aleatóriamente pelo construtor.

		@param cx coordenada x da posição inicial da bola (centro do retangulo que a representa).
		@param cy coordenada y da posição inicial da bola (centro do retangulo que a representa).
		@param width largura do retangulo que representa a bola.
		@param height altura do retangulo que representa a bola.
		@param color cor da bola.
		@param speed velocidade da bola (em pixels por millisegundo).
	*/

	public Ball(double cx, double cy, double width, double height, Color color, double speed){
		this.cx = cx;
		this.cy = cy;
		this.height = height;
		this.width = width;
		this.speed = speed;
		this.color = color;
		this.direcaoX = this.direcaoRandom();
		this.direcaoY = this.direcaoRandom();
		draw();


	}
	public double direcaoRandom(){
		int randomINt = random.nextInt(2);
		if(randomINt == 0){
			return -(Math.abs(this.speed));
		}else{
			return (Math.abs(this.speed));
		}
	}
	/**
	Aqui estamos gerando posições aleatórias para os eixos X e Y
	*/
	/**
		Método chamado sempre que a bola precisa ser (re)desenhada.
	*/

	public void draw(){
		GameLib.setColor(this.color);
		GameLib.fillRect(this.cx, this.cy, this.width, this.height);
	}

	/**
		Método chamado quando o estado (posição) da bola precisa ser atualizado.

		@param delta quantidade de millisegundos que se passou entre o ciclo anterior de atualização do jogo e o atual.
	*/

	public void update(long delta){

		this.cx += delta * this.direcaoX;
		this.cy += delta * this.direcaoY;
	}

	/**
		Método chamado quando detecta-se uma colisão da bola com um jogador.
		Neste método vamos atualizar a posição da bola com as direções primeiramente feitas de maneira aleatória e
		indo atualizando a cada chamada do método.

		@param playerId uma string cujo conteúdo identifica um dos jogadores.
	*/

	public void onPlayerCollision(String playerId){
		if(playerId = "Player 1"){
			this.direcaoX = Math.abs(this.speed);
		}
		if(playerId != "Player 2"){
			this.direcaoY = -Math.abs(this.speed);
		}
	}

	/**
		Método chamado quando detecta-se uma colisão da bola com uma parede.
		Aqui vamos verificar se o player está colidindo com a bola e caso verdadeira atualizamos a velocidade da bola
		de maneira positiva, caso contrário de maneira negativa.
		@param wallId uma string cujo conteúdo identifica uma das paredes da quadra.
	*/

	public void onWallCollision(String wallId){

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

		return false;
	}

	/**
		Método que verifica se houve colisão da bola com um jogador.

		@param player referência para uma instância de Player contra o qual será verificada a ocorrência de colisão da bola.
		@return um valor booleano que indica a ocorrência (true) ou não (false) de colisão.
	*/

	public boolean checkCollision(Player player){

		return false;
	}

	/**
		Método que devolve a coordenada x do centro do retângulo que representa a bola.
		@return o valor double da coordenada x.
	*/

	public double getCx(){

		return this.cx;
	}

	/**
		Método que devolve a coordenada y do centro do retângulo que representa a bola.
		@return o valor double da coordenada y.
	*/

	public double getCy(){

		return this.cy;
	}

	/**
		Método que devolve a velocidade da bola.
		@return o valor double da velocidade.

	*/

	public double getSpeed(){

		return this.speed;
	}
/**
Vídeos utilizados para fazer o algoritmo
https://www.youtube.com/watch?v=EeYJCV-A2hw
https://youtu.be/oLirZqJFKPE
*/
}
