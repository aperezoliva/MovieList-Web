/**
* Alexander Perez Oliva - aperezoliva
* CIS175
* Oct 14, 2022
*/
package view;

import java.util.List;

import controller.ProductionCompanyHelper;
import model.ProductionCompany;

/**
 * @author krazy
 *
 */
public class ProductionCompanyViewer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ProductionCompany universalStudios = new ProductionCompany("Universal Studios");
		ProductionCompany disneyStudios = new ProductionCompany("Disney");

		ProductionCompanyHelper pc  = new ProductionCompanyHelper();
		
		pc.insertCompany(universalStudios);
		pc.insertCompany(disneyStudios);
		
		List<ProductionCompany> allCompanies = pc.showAllCompanies();
		for (ProductionCompany a: allCompanies) {
			System.out.println(a.toString());
		}

	}

}
