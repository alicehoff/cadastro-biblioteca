package firstpackage;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.swing.JOptionPane;

public class cadastro {

	public static void main(String[] args) throws IOException {
		
		String identifica = "";
		String numero = "";
		int num = 0;

		do {
			identifica = JOptionPane.showInputDialog("Digite a identificação do colaborador: ");
			if (!identifica.matches("^[0-9]+$")) {
				System.out.println("Por favor, digite um número válido");
			}
		} while (!identifica.matches("^[0-9]+$"));
		
// =======================================================================================================================================
		// C L I E N T E S
		String cpf = "";
		String nome = "";
		String email = "";
		
		if (identifica.equals("495874")) {
			OutputStream os = new FileOutputStream("Cadastro de Clientes.txt");
			Writer wr = new OutputStreamWriter(os);
			BufferedWriter br = new BufferedWriter(wr);
			
			do {
				numero = JOptionPane.showInputDialog("Digite quantos clientes deseja cadastrar: ");
				if (numero.isEmpty()) {
					System.out.println("Por favor, digite um número válido");
				}
			} while (numero.isEmpty());

			num = Integer.parseInt(numero);

			String info[][] = new String[num][3];

			for (int lin = 0; lin < info.length; lin++) {
				do {
					cpf = JOptionPane.showInputDialog("Digite o CPF do colaborador: ");
				} while (!cpf.matches("^[0-9]+$"));

				if (cpf.equals("9999")) {
					break;
				}

				info[lin][0] = cpf;
				do {
					nome = JOptionPane.showInputDialog("Digite o nome do colaborador: ");
					info[lin][1] = nome;
				} while (nome.isEmpty());

				do {
					email = JOptionPane.showInputDialog("Digite o email do colaborador: ");
					info[lin][2] = email;
				} while (email.isEmpty());
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!","", JOptionPane.INFORMATION_MESSAGE);
			}

			int resposta = 0;
			resposta = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Deseja somente encerrar [1] ou criar arquivo [2]?", "", JOptionPane.PLAIN_MESSAGE));
			if (resposta == 2) {
				br.write("CADASTRO DE CLIENTES");
				br.newLine();
				br.write("===================================================");
				br.newLine();
				for (int lin = 0; lin < info.length; lin++) {
					br.write("CPF: " + info[lin][0] + " | ");
					br.write("Nome: " + info[lin][1] + " | ");
					br.write("Email: " + info[lin][2]);
					br.newLine();
					br.write("===================================================");
					br.newLine();
				}
			}
			br.close();
		}
// =======================================================================================================================================
		// L I V R O S
		String id = "";
		String livro = "";
		String autor = "";

		if (identifica.equals("a")) {
			OutputStream os = new FileOutputStream("Cadastro de Livros.txt");
			Writer wr = new OutputStreamWriter(os);
			BufferedWriter br = new BufferedWriter(wr);
			
			do {
				numero = JOptionPane.showInputDialog("Digite quantos livros deseja cadastrar: ");
				if (numero.isEmpty()) {
					System.out.println("Por favor, digite um número válido");
				}
			} while (numero.isEmpty());

			num = Integer.parseInt(numero);

			String info[][] = new String[num][3];

			for (int lin = 0; lin < info.length; lin++) {
				do {
					id = JOptionPane.showInputDialog("Digite o ID do livro: ");
				} while (!id.matches("^[0-9]+$"));

				if (id.equals("9999")) {
					break;
				}

				info[lin][0] = id;
				do {
					livro = JOptionPane.showInputDialog("Digite o nome do livro: ");
					info[lin][1] = livro;
				} while (livro.isEmpty());

				do {
					autor = JOptionPane.showInputDialog("Digite o nome do autor: ");
					info[lin][2] = autor;
				} while (autor.isEmpty());
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!","", JOptionPane.INFORMATION_MESSAGE);
			}

			int resposta = 0;
			resposta = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Deseja somente encerrar [1] ou criar arquivo [2]?", "", JOptionPane.PLAIN_MESSAGE));
			if (resposta == 2) {
				br.write("CADASTRO DE LIVROS");
				br.newLine();
				br.write("===================================================");
				br.newLine();
				for (int lin = 0; lin < info.length; lin++) {
					br.write("ID: " + info[lin][0] + " | ");
					br.write("Nome do livro: " + info[lin][1] + " | ");
					br.write("Autor: " + info[lin][2]);
					br.newLine();
					br.write("===================================================");
					br.newLine();
				}
			}
			br.close();	
		}
	}

}
