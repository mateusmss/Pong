import java.awt.*;

/**
	Esta classe representa um placar no jogo. A classe princial do jogo (Pong)
	instancia dois objeto deste tipo, cada um responsável por gerenciar a pontuação
	de um player, quando a execução é iniciada.
*/

public class Score {
	private String playerId;
	private int conta;
	private int i = 0;
	GameLib GameLib = new GameLib();
	/**
		Construtor da classe Score.

		@param playerId uma string que identifica o player ao qual este placar está associado.
	*/

	public Score(String playerId){
		this.playerId = playerId;
	}

	/**
		Método de desenho do placar.
	*/

	public void draw(){
		String conta1 = Integer.toString(this.conta);
        String conta2 = Integer.toString(this.conta);
		GameLib.drawText(conta1, 70, GameLib.ALIGN_LEFT);
        GameLib.drawText(conta2, 70, GameLib.ALIGN_RIGHT);
	}

	/**
		Método que incrementa em 1 unidade a contagem de pontos.
	*/

	public void inc(){
		this.conta++;
	}

	/**
		Método que devolve a contagem de pontos mantida pelo placar.

		@return o valor inteiro referente ao total de pontos.
	*/

	public int getScore(){
		return this.conta;
	}
}
