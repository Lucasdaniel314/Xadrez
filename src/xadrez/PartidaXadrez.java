package xadrez;

import camadaTabuleiro.Peca;
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
	
	public PecaXadrez moverPeca(PosicaoXadrez origemPosicao, PosicaoXadrez destinoPosicao) {
		Posicao origem = origemPosicao.toPosicao();
		Posicao destino = destinoPosicao.toPosicao();
		posicaoOrigemValida(origem);
		posicaoDestinoValido(origem, destino);
		Peca pecaCapturada = movimento(origem, destino);
		return (PecaXadrez) pecaCapturada;
	}
	
	private Peca movimento(Posicao origem, Posicao destino) {
		Peca p = tabuleiro.removePeca(origem);
		Peca pecaCapturada = tabuleiro.removePeca(destino);
		tabuleiro.posicaoPeca(p, destino);
		return pecaCapturada;
	}
	
	private void posicaoOrigemValida(Posicao posicao) {
		if(!tabuleiro.temUmaPeca(posicao)) {
			throw new XadrezException("essa posicao nao tem peca!");
		} if (!tabuleiro.peca(posicao).temAlgumMovimentoPossivel()) {
			throw new XadrezException("nao existe movimentos possiveis para a peca escolhida!");
		}
	}
	
	private void posicaoDestinoValido(Posicao origem, Posicao destino) {
		if (!tabuleiro.peca(origem).movimentoPossivel(destino)) {
			throw new XadrezException("jogada invalida!");
		}
	}
	
	private void novaPecaXadrez(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.posicaoPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
	}
	
	private void partidaInicial() {
		novaPecaXadrez('c', 1, new Torre(tabuleiro, Cor.branco));
		novaPecaXadrez('c', 2, new Torre(tabuleiro, Cor.branco));
		novaPecaXadrez('d', 2, new Torre(tabuleiro, Cor.branco));
		novaPecaXadrez('e', 2, new Torre(tabuleiro, Cor.branco));
		novaPecaXadrez('e', 1, new Torre(tabuleiro, Cor.branco));
		novaPecaXadrez('d', 1, new Rei(tabuleiro, Cor.branco));

		novaPecaXadrez('c', 7, new Torre(tabuleiro, Cor.preto));
		novaPecaXadrez('c', 8, new Torre(tabuleiro, Cor.preto));
		novaPecaXadrez('d', 7, new Torre(tabuleiro, Cor.preto));
		novaPecaXadrez('e', 7, new Torre(tabuleiro, Cor.preto));
		novaPecaXadrez('e', 8, new Torre(tabuleiro, Cor.preto));
		novaPecaXadrez('d', 8, new Rei(tabuleiro, Cor.preto));
	}
}
