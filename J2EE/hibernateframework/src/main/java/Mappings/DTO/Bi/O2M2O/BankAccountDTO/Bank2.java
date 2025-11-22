package Mappings.DTO.Bi.O2M2O.BankAccountDTO;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bank2 {
	@Id
	private int id;
	private String name;
	private String ifsc;

	// @OneToMany

	@OneToMany(mappedBy = "bank")
	private List<Account2> accounts;

}
