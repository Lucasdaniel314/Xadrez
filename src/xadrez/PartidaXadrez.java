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
	
	private void posicaoNovaPeca(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.posicaoPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
	}
	
	private void partidaInicial() {
		posicaoNovaPeca('a' , 6, new Torre(tabuleiro, Cor.preto));
		posicaoNovaPeca('h', 5 , new Torre(tabuleiro, Cor.branco));
		posicaoNovaPeca('e', 1, new Rei(tabuleiro, Cor.preto));
		posicaoNovaPeca('e', 8, new Rei(tabuleiro, Cor.branco));
	}
}
