package actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Aluno;

public class RemoverDados {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		Aluno aluno = new Aluno();
		Scanner scan = new Scanner (System.in);
		System.out.println("Informe o id do aluno(a) que deseja remover:  ");
		String id = scan.next();
	
		aluno = manager.find(Aluno.class, Long.parseLong(id));
		
		manager.getTransaction().begin();
		manager.remove(aluno);
		manager.getTransaction().commit();
		
		System.out.println("Removido com sucesso!");
		manager.close();
		factory.close();
	}

}
