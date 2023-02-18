package aplicacao;

import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		
		while(true) {
			UI.imprimeTabuleiro(partidaXadrez.getPecas());
			System.out.println();
			System.out.print("origem: ");
			PosicaoXadrez origem = UI.lerPosicao(sc);
			
			System.out.print("destino: ");
			PosicaoXadrez destino = UI.lerPosicao(sc);
			PecaXadrez pecaCapturada = partidaXadrez.moverPeca(origem, destino);
		}
	}

}
