package File;

public class Cavalo {

	public int n = 8;
	public int m = 8;
	int inicio = 0;
	int[][] tabuleiro = new int[n][m];
	int[] dx = { 2, 1, -1, -2, -2, -1, 1, 2 };
	int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public Cavalo (int N, int M){
		this.n = N;
		this.m = M;
	}
	public Cavalo (){}
	
	public void Inicializar() {
		int x = 0, y = 0;
		inicio--;
		// determinar a casa inicial do cavalo
		for (x = 0; ((inicio >= 0) && (x < n)); x++) {
			for (y = 0; ((inicio >= 0) && (y < m)); y++) {
				inicio--;
			}
		}
		tabuleiro[x][y] = 1;
		// iniciar tentativa de movimentos
		Movimentar(2, x, y);
		imprime();
	}

	public int Movimentar(int i, int x, int y) {

		int u = 0, v = 0, k = 0, q;

		// executa movimentos
		if (i <= (n * m)) {
			for (k = 0; k < 8; k++) {
				u = x + dx[k];
				v = y + dy[k];
				// testa limites do tabuleiro
				if ((u >= 0 && u < n) && (v >= 0 && v < m)) {
					if (tabuleiro[u][v] == 0) { // posicao livre
						tabuleiro[u][v] = i; // registre o movimento
						q = Movimentar(i + 1, u, v);
						if (q == 0)
							tabuleiro[u][v] = 0; // se não alcançou todos
													// desfaça
						else
							return 1; // se alcançou todos, retorne 1
					}
				}
			}
		} else
			return 1;
		return 0;
	}

	public void imprime() {
		int i, j;

		for (i = 0; i < n; i++) {
			for (j = 0; j < m; j++) {
				System.out.printf("\t" + tabuleiro[i][j]);
			}
			System.out.println();
		}

		/*
		 * StringBuilder saida = new StringBuilder("<html><body>"); for (int[]
		 * linha : tabuleiro) { for (int valor : linha) { saida.append("\t" + valor +
		 * "\t").append(" "); } saida.append("<br>"); }
		 * JOptionPane.showInputDialog(null, saida.toString());
		 */
	}

}
