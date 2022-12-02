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
		Scanner scan = new Scanner (System.in);
		System.out.println("Informe o id do aluno(a) para alterar os dados: ");
		String id = scan.next();
	
		aluno = manager.find(Aluno.class, Long.parseLong(id));
		System.out.println("\nNome: ");
		String nome = scan.nextLine();

		
		manager.getTransaction().begin();
		aluno.setNome(scan.nextLine());
		manager.getTransaction().commit();
		
		System.out.println("Atualizado com sucesso!");
		manager.close();
		factory.close();
	}

}
