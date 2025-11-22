package Mappings.DAO.Unidirectional.OneToMany.BankToAccountDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Mappings.DTO.Unidirectional.OneToManyDTO.Account;
import Mappings.DTO.Unidirectional.OneToManyDTO.Bank;

public class FindBankAndAccount {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("one_to_many");
		EntityManager em = emf.createEntityManager();

//		//Find by id
//		Bank bank=em.find(Bank.class, 101);
//		System.out.println("Bank Details: ");
//		System.out.println(
//				bank.getId()+" "
//				+bank.getName()+" "
//				+bank.getIfsc()+" "
//				);
//		List<Account> accounts=bank.getAccounts();
//		System.out.println("Account Details: ");
//		for(Account account:accounts) {
//			System.out.println("------------");
//			System.out.println(account.getId());
//			System.out.println(account.getAccno());
//			System.out.println(account.getHolderName());
//		}

		// Find all

		Query query = em.createQuery("Select b from Bank b");

		List<Bank> banks = query.getResultList();

		for (Bank bankk : banks) {
			System.out.println(bankk.getId() + " " + bankk.getName() + " " + bankk.getIfsc() + " ");
			List<Account> accs = bankk.getAccounts();
			System.out.println("Account Details of " + bankk.getName());
			for (Account acc : accs) {
				System.out.println(acc.getId());
				System.out.println(acc.getAccno());
				System.out.println(acc.getHolderName());
				System.out.println("------------");
			}
		}

	}

}
