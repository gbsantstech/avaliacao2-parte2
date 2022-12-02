package actions;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Aluno;

public class ListarDados {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		Query consulta = manager.createQuery("select aluno from Aluno aluno");
		
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
