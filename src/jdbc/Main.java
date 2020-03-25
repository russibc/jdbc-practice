package jdbc;

import java.util.List;
/**
 * 
 * @author Bruna C.R.
 *
 */
public class Main {

	public static void imprimir(List<Pessoa> lista) {
		System.out.println("Imprimindo lista...");
		for (Pessoa pe : lista) {
			System.out.print(pe.getId() + " ");
			System.out.print(pe.getPrimeiroNome() + " ");
			System.out.print(pe.getUltimoNome() + " ");
			System.out.print(pe.getIdade() + " ");
			System.out.println(pe.getProfissao());
		}
		System.out.println("");
	}

	public static void imprimirPessoa(Pessoa p) {
		System.out.println("Imprimindo pessoa...");
		System.out.println(p.getId());
		System.out.println(p.getPrimeiroNome());
		System.out.println(p.getUltimoNome());
		System.out.println(p.getIdade());
		System.out.println(p.getProfissao());
		System.out.println("");
	}

	public static void main(String[] args) {

		Banco banco = new Banco();

		Pessoa p3 = banco.findByID(4);
		p3.setIdade(40);
		banco.atualizar(p3);

		Pessoa p4 = banco.findByID(6);
		p4.setIdade(39);
		banco.atualizar(p4);

		List<Pessoa> lista = banco.listar();
		imprimir(lista);

		Pessoa p1 = new Pessoa();
		p1.setId(11);
		p1.setPrimeiroNome("Cris");
		p1.setProfissao("Jogador");
		p1.setUltimoNome("Ronaldo");
		p1.setIdade(30);
		banco.salvar(p1);

		Pessoa p2 = banco.findByID(11);
		imprimirPessoa(p2);

		p2.setPrimeiroNome("Cristiano");
		banco.atualizar(p2);

		imprimirPessoa(banco.findByID(11));

		lista = banco.listar();
		imprimir(lista);

		banco.remover(p2);

		lista = banco.listar();
		imprimir(lista);

	}

}