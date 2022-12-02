package actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Aluno;

public class AtualizarDados {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();

		Aluno aluno = new Aluno();
		Scanner scan = new Scanner(System.in);
		System.out.println("Informe o id do aluno(a) para alterar os dados: ");
		String id = scan.next();
	
		aluno = manager.find(Aluno.class, Long.parseLong(id));


		manager.getTransaction().begin();

		System.out.println("\nNome: ");
		scan.nextLine();
		aluno.setNome(scan.nextLine());
		System.out.println("\nE-mail: ");
		aluno.setEmail(scan.nextLine());
		System.out.println("\nCPF: ");
		aluno.setCpf(scan.nextLine());
		System.out.println("\nData de Nascimento: ");
		aluno.setDataNasc(scan.nextLine());
		System.out.println("\nNaturalidade: ");
		aluno.setNaturalidade(scan.nextLine());
		System.out.println("\nEndereço completo: ");
		aluno.setEndereco(scan.nextLine());
		manager.getTransaction().commit();

		System.out.println("Atualizado com sucesso!");
		manager.close();
		factory.close();
	}

}
