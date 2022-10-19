/**
* Alexander Perez Oliva - aperezoliva
* CIS175
* Oct 13, 2022
*/
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author krazy
 *
 */
@Entity
@Table(name="companies")
public class ProductionCompany {
	@Id
	@GeneratedValue
	private int id;
	private String companyName;
	
	public ProductionCompany() {
		super();
	}
	
	public ProductionCompany(int id, String companyName) {
		super();
		this.id = id;
		this.companyName = companyName;
	}
	
	public ProductionCompany(String companyName) {
		super();
		this.companyName = companyName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Override
	public String toString() {
		return "Production Company [id=" + id + ", companyName=" + companyName +"]"; 
	}
}
