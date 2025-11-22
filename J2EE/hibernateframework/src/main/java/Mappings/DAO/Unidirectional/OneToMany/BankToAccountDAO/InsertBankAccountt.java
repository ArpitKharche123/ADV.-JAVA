package Mappings.DAO.Unidirectional.OneToMany.BankToAccountDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Mappings.DTO.Unidirectional.OneToManyDTO.Account;
import Mappings.DTO.Unidirectional.OneToManyDTO.Bank;

public class InsertBankAccountt {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("one_to_many");
		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		Account account1 = new Account(1, 98889728345l, "Rakesh"), account2 = new Account(2, 98889728323l, "Ganesh"),
				account3 = new Account(3, 98889728367l, "Suresh");

		List<Account> accounts1 = new ArrayList<>();
		accounts1.add(account1);
		accounts1.add(account2);
		accounts1.add(account3);

		Bank bank = new Bank(101, "SBI", "IFSC23321", accounts1);

		// Using Setters

		Account account4 = new Account();
		account4.setId(4);
		account4.setAccno(987756958l);
		account4.setHolderName("Brijesh");

		Account account5 = new Account();
		account5.setId(5);
		account5.setAccno(986736958l);
		account5.setHolderName("Minal");

		List<Account> accounts2 = new ArrayList<>();
		accounts2.add(account4);
		accounts2.add(account5);

		Bank bank2 = new Bank();
		bank2.setId(102);
		bank2.setName("CBI");
		bank2.setIfsc("IFSC77645");
		bank2.setAccounts(accounts2);

		try {
			et.begin();

			// Saving banks
			em.persist(bank);
			em.persist(bank2);

			// Saving all accounts
			for (Account account : accounts1) {
				em.persist(account);
			}
			for (Account account : accounts2) {
				em.persist(account);
			}

			et.commit();
		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}
			e.printStackTrace();
		}
	}

}
