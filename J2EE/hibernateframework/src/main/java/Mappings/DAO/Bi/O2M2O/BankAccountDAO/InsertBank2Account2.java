package Mappings.DAO.Bi.O2M2O.BankAccountDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Mappings.DTO.Bi.O2M2O.BankAccountDTO.Account2;
import Mappings.DTO.Bi.O2M2O.BankAccountDTO.Bank2;

public class InsertBank2Account2 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("one_to_many_to_one_bi");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		// Setting the data
		Bank2 bank = new Bank2();
		bank.setId(1);
		bank.setName("CBI");
		bank.setIfsc("IFSC310192");

		Account2 account1 = new Account2();
		account1.setId(1);
		account1.setAccnumber(988567);
		account1.setHolderName("john");

		Account2 account2 = new Account2();
		account2.setId(2);
		account2.setAccnumber(788677);
		account2.setHolderName("Michael");

		Account2 account3 = new Account2();
		account3.setId(3);
		account3.setAccnumber(568097);
		account3.setHolderName("Alex");

		List<Account2> accounts = new ArrayList<Account2>();

		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);

		// setting bank to accounts
		for (Account2 accs : accounts) {
			accs.setBank(bank);
		}

		// setting accounts to bank
		bank.setAccounts(accounts);

		// Inserting the data

		try {
			et.begin();
			for (Account2 accs : accounts) {
				em.persist(accs);
			}
			em.persist(bank);
			et.commit();
		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}
		}

	}

}
