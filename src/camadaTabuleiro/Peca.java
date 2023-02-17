package camadaTabuleiro;

public abstract class Peca {
	//não é peca de pecado não ok? kkkkk, é peca de peça

	protected Posicao posicao;
	private Tabuleiro tabuleiro;
	
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		posicao = null;
	}

	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	
}
