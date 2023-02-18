package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;
import xadrez.XadrezException;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		
		while(true) {
			try {
				UI.limpaTela();
				UI.imprimeTabuleiro(partidaXadrez.getPecas());
				System.out.println();
				System.out.print("origem: ");
				PosicaoXadrez origem = UI.lerPosicao(sc);
				
				System.out.print("destino: ");
				PosicaoXadrez destino = UI.lerPosicao(sc);
				PecaXadrez pecaCapturada = partidaXadrez.moverPeca(origem, destino);
			} catch (XadrezException e) {
				System.out.println("erro: " + e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("erro: " + e.getMessage());
				sc.nextLine();
			}
		}
	}

}
