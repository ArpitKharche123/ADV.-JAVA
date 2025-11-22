package Mappings.DTO.Bi.O2M2O.BankAccountDTO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account2 implements Serializable {
	@Id
	private int id;
	private long accnumber;
	private String holderName;

	// @ManyToOne

	@ManyToOne
	@JoinColumn
	private Bank2 bank;

}
