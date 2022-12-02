package actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Aluno;

public class InserirDados {

	public static void main(String[] args) {

		Aluno aluno = new Aluno();
		System.out.println("Informe os dados do aluno(a):");
		Scanner scan = new Scanner(System.in);
		System.out.println("\nNome: ");
		String nome = scan.nextLine();
		aluno.setNome(nome);
		System.out.println("\nE-mail: ");
		String email = scan.nextLine();
		aluno.setEmail(email);
		System.out.println("\nCPF: ");
		String cpf = scan.nextLine();
		aluno.setCpf(cpf);
		System.out.println("\nData de Nascimento: ");
		String dataNasc = scan.nextLine();
		aluno.setDataNasc(dataNasc);
		System.out.println("\nNaturalidade: ");
		String naturalidade = scan.nextLine();
		aluno.setNaturalidade(naturalidade);
		System.out.println("\nEndereço completo: ");
		String endereco = scan.nextLine();
		aluno.setEndereco(endereco);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(aluno);
		manager.getTransaction().commit();
		
		System.out.println("Dados gravados com sucesso! ");
		manager.close();
		factory.close();
	}

}
