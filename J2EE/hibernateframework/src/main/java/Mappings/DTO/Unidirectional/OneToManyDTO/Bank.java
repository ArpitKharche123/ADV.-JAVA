package Mappings.DTO.Unidirectional.OneToManyDTO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank implements Serializable {
	@Id
	private int id;
	private String name;
	private String ifsc;

	@OneToMany // One Bank has multiple accounts
	private List<Account> accounts;
}
