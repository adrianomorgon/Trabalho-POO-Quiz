package entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Quiz> quiz = new ArrayList();
		Scanner sc = new Scanner(System.in);
		
		int opc = 0;
		int pontuacao = 0;
		String pergunta;
		String[] respostas = new String[4];
		char aux = 'A';
		
		while(opc != 9) {
			System.out.println("1. Adicionar Questão");
			System.out.println("2. Responder ao quiz");
			System.out.println("3. Numero de perguntas no quiz");
			System.out.println("4. Remover questao");
			System.out.println("5. Visualizar questoes");
			System.out.println("9. Sair");
			System.out.println("Digite sua opcao");
			opc = sc.nextInt();
			sc.nextLine();
			switch(opc) {
			case 1:
				System.out.println();
				System.out.println("Digite a pergunta");
				pergunta = sc.nextLine();
				
				aux = 'A';
				for(int i=0; i<4; i++) {
					System.out.println("Digite a resposta para alternativa " + aux);
					respostas[i] = sc.nextLine();
					aux += 1;
				}
				
				System.out.println("Digite a alternativa correta (A, B, C ou D): ");
				aux = sc.next().charAt(0);
				
				Quiz temp = new Quiz(pergunta, respostas[0], respostas[1], respostas[2], respostas[3], aux);
				quiz.add(temp);
				System.out.println();
				break;
			case 2:
				System.out.println();
				pontuacao = 0;
				for(Quiz q : quiz) {
					System.out.println("Pergunta: " + q.getPergunta());
					
					System.out.println("Alternativas: ");
					for(String u: q.getRespostas()) {
						System.out.println(u);
					}
					
					System.out.println("Digite a alternativa correta: ");
					aux = sc.next().charAt(0);
					boolean certaResposta = q.certaResposta(aux);
					if(certaResposta) {
						System.out.println("Certa resposta!");
						pontuacao++;
					}else {
						System.out.println("ERROOOOOOOOOOOU!");
					}
				}
				System.out.println("MA OEEEE VOCE ACERTOU " + pontuacao + " DE " + quiz.size() + " PERGUNTAS!");
				System.out.println();
				System.out.println();
				break;
			case 3:
				System.out.println();
				System.out.println("Numero de Perguntas no FastQuiz: " + quiz.size());
				System.out.println();
				System.out.println();
				break;
			case 4:
				System.out.println();
				int indice = 0;
				for(Quiz q: quiz) {
					System.out.println("Indice (" + indice + ") " + q.toString());
					indice++;
				}
				System.out.println("Digite o indice que deseja remover: ");
				int ind = Integer.parseInt(sc.nextLine());
				quiz.remove(ind);
			case 5:
				System.out.println();
				for(Quiz q: quiz) {
					System.out.println(q.toString());
					System.out.println();
				}
				System.out.println();
				break;
			case 9:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opcao invalida");
				break;
			}
		}
		
		System.out.println("Programa terminado!");
		sc.close();

	}

}
