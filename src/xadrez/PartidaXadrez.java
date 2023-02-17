package xadrez;

import camadaTabuleiro.Posicao;
import camadaTabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {

	private Tabuleiro tabuleiro;
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		partidaInicial();
	}
	
	public PecaXadrez[][] getPecas(){
		PecaXadrez[][] matriz = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for(int i = 0 ; i < tabuleiro.getLinhas() ; i++) {
			for(int j = 0 ; j < tabuleiro.getColunas() ; j++) {
				matriz[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
			}
		}
		return matriz;
	}
	
	private void partidaInicial() {
		tabuleiro.posicaoPeca(new Torre(tabuleiro, Cor.branco), new Posicao(1, 0));
		tabuleiro.posicaoPeca(new Torre(tabuleiro, Cor.branco), new Posicao(1, 7));
		tabuleiro.posicaoPeca(new Rei(tabuleiro, Cor.preto), new Posicao(0, 4));
		tabuleiro.posicaoPeca(new Rei(tabuleiro, Cor.branco), new Posicao(7, 4));
	}
}
