package pcoPrimeiraFasePackage;

public class MetodosEvolucao {

	public static void evolucao(char[][] terreno, int[] ventoLimites, String ventoDir, int ventoForca) {

		espalhamento(terreno, vizinhosAfetados(ventoLimites, ventoForca), ventoDir);

	}

	public static int vizinhosAfetados(int[] ventoLimites, int ventoForca) {

		// qd força for <= ao int no array , o numero de terrenos afetados é o indice
		// desse int
		// devolve o nº de terrenos que vão ser afetados

		int vizinhos = 0;

		for (int i = 0; i < ventoLimites.length; i++)

			if (ventoForca <= ventoLimites[i]) {

				vizinhos = i;

				return vizinhos;

			}

		return vizinhos;

	}

	public static void espalhamento(char[][] terreno, int vizinhos, String ventoDir) {

		// recebe o número de terrenos afectados e a drieção do vento
		// MetodosEvolucao.espalhamento(terra1 , 2, "O");

		char[][] terrenoCopia = new char[terreno[0].length][terreno[0].length];

		for (int x = 0; x < terreno.length; x++)
			for (int y = 0; y < terreno[0].length; y++)

				terrenoCopia[x][y] = terreno[x][y];

		for (int i = 0; i < terreno.length; i++) {
			for (int j = 0; j < terreno[i].length; j++) {

				int k = 0;

				while (k < vizinhos && k >= 0) {

					k = k + 1;

					switch (ventoDir) {

					case ("O"): {

						if ((j + k) < terrenoCopia[i].length && terreno[i][j] == '*') {

							if (terrenoCopia[i][j + k] == 'x')

								k = -1;

							else {

								terreno[i][j + k] = '*';

							}
						}

						break;
					}

					case ("E"): {

						if ((j - k) >= 0 && terreno[i][j] == '*') {

							if (terrenoCopia[i][j - k] == 'x')

								k = -1;

							else {

								terreno[i][j - k] = '*';

							}
						}

						break;
					}

					case ("N"): {

						if ((i + k) < terreno.length && terreno[i][j] == '*') {

							if (terrenoCopia[i + k][j] == 'x')

								k = -1;

							else {

								terreno[i + k][j] = '*';
							}
						}

						break;
					}

					case ("S"): {
						if ((i - k) >= 0 && terreno[i][j] == '*') {

							if (terrenoCopia[i - k][j] == 'x')

								k = -1;

							else {

								terreno[i - k][j] = '*';
							}
						}

						break;
					}

					}
				}

			}
		}
	}
}