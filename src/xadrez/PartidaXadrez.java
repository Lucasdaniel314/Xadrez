package xadrez;

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
	
	private void posicaoXadrez(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.posicaoPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
	}
	
	private void partidaInicial() {
		posicaoXadrez('c', 1, new Torre(tabuleiro, Cor.branco));
		posicaoXadrez('c', 2, new Torre(tabuleiro, Cor.branco));
		posicaoXadrez('d', 2, new Torre(tabuleiro, Cor.branco));
		posicaoXadrez('e', 2, new Torre(tabuleiro, Cor.branco));
		posicaoXadrez('e', 1, new Torre(tabuleiro, Cor.branco));
		posicaoXadrez('d', 1, new Rei(tabuleiro, Cor.branco));

		posicaoXadrez('c', 7, new Torre(tabuleiro, Cor.preto));
		posicaoXadrez('c', 8, new Torre(tabuleiro, Cor.preto));
		posicaoXadrez('d', 7, new Torre(tabuleiro, Cor.preto));
		posicaoXadrez('e', 7, new Torre(tabuleiro, Cor.preto));
		posicaoXadrez('e', 8, new Torre(tabuleiro, Cor.preto));
		posicaoXadrez('d', 8, new Rei(tabuleiro, Cor.preto));
	}
}
