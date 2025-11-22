package Mappings.DAO.Bi.O2M2O.BankAccountDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Mappings.DTO.Bi.O2M2O.BankAccountDTO.Account2;
import Mappings.DTO.Bi.O2M2O.BankAccountDTO.Bank2;

public class FindBank2Account2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("one_to_many_to_one_bi");
		EntityManager em = emf.createEntityManager();

		Query fetchBanks = em.createQuery("Select b from Bank2 b");

		System.out.println("Bank details: \n");
		List<Bank2> banks = fetchBanks.getResultList();
		for (Bank2 bank : banks) {
			System.out.println(bank.getId() + " " + bank.getName() + " " + bank.getIfsc() + " ");
			System.out.println("Accounts in " + bank.getName() + " :");
			List<Account2> accounts = bank.getAccounts();
			for (Account2 account : accounts) {
				System.out
						.println(account.getId() + " " + account.getAccnumber() + " " + account.getHolderName() + " ");
			}
		}

	}
}
