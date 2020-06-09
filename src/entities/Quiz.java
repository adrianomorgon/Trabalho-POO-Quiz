package entities;

import java.util.Arrays;

public class Quiz {
	private String pergunta;
	private String respostas[] = new String[4];
	private boolean correta[] = new boolean[4];
	
	public Quiz(String pergunta, String resp1, String resp2, String resp3, String resp4, char x) {
		this.pergunta = pergunta;
		respostas[0] = "A) " + resp1;
		respostas[1] = "B) " + resp2;
		respostas[2] = "C) " + resp3;
		respostas[3] = "D) " + resp4;
		switch (x) {
		case 'A':
			correta[0] = true;
			break;
		case 'B':
			correta[1] = true;
			break;
		case 'C':
			correta[2] = true;
			break;
		case 'D':
			correta[3] = true;
			break;
		}
	}
	
	

	public String getPergunta() {
		return pergunta;
	}


	public String[] getRespostas() {
		return respostas;
	}

	public boolean certaResposta(char x) {
		int y = (int)x;
		if(correta[y-65]) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Quiz [pergunta=" + pergunta + ", respostas=" + Arrays.toString(respostas) + ", correta="
				+ Arrays.toString(correta) + "]";
	}
	
	
}
