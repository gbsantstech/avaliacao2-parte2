package actions;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Aluno;

public class ListarAluno {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Letra do nome do aluno(a): ");
		String letra = scan.next();

		
		Query consulta = manager.createQuery("select aluno from Aluno aluno where nome like concat(:pletra, '%')");
		consulta.setParameter("pletra", letra);
		
		List<Aluno> alunos = consulta.getResultList();
		
		for(Aluno aluno : alunos) {
			System.out.println("Aluno: "+aluno.getNome());
			System.out.println("E-mail: " +aluno.getEmail());
			System.out.println("CPF: " +aluno.getCpf());
			System.out.println("Nascimento: " +aluno.getDataNasc());
			System.out.println("Naturalidade: " +aluno.getNaturalidade());
			System.out.println("Endereço: " +aluno.getEndereco());
		}
		manager.close();
		factory.close();
	}
}
