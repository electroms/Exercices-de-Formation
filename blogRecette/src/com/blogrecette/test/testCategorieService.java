/**
 * 
 */
package com.blogrecette.test;

import static org.junit.Assert.assertNotEquals;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.blogrecette.model.Categorie;
import com.blogrecette.services.CategorieService;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author Pierre-Henry Barge
 *
 */
//D�claration de la classe
public class testCategorieService extends TestCase {
	//Affectation des attributs � null
	private static SessionFactory sessionFactory;
	private static CategorieService categorieService = null;
	private static Categorie categorieTest = null;
	//Cr�ation d'un constructeur vide
	public testCategorieService() {

	}
	//Cr�ation d'un nouveau constructeur
	public testCategorieService(String testName) {
		//Appel le constructeur du parent
		super(testName);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	//Creation du setup v�rifie si la connexion existe et retourne une erreur si elle n'existe pas
	public void setUp() throws Exception {
		categorieService = new CategorieService();

		if (categorieTest == null) {
			categorieTest = new Categorie(2, "dessert");
		}

	}	

	/**
	 * @throws java.lang.Exception
	 */
	@After
	//Creation du tearDown
	public void tearDown() throws Exception {

		categorieService = null;
	}
	//test de la m�thode createCategorie
	@Test
	public void testCreateCategorie() throws Exception {
		//Cr�� un jeu de test (Arrange)


		//Action (Act)
		categorieTest = categorieService.createCategorie(categorieTest);
		Categorie categorieCree = categorieService.getCategorieFromId(categorieTest.getId());

		//Assert v�rifie que le nom est bien �gal � la categorie de test
		assertNotEquals((double)0, (double)categorieTest.getId());
		assertEquals(categorieTest.getNom(), categorieCree.getNom());

	}
	//test de la m�thode updateCategorie
	@Test
	public void testUpdateCategorie() throws Exception {
		//Cree jeu de test (Arrange)
		Date newDate = new Date("2019/11/04");

		//membre.setId(4);
		categorieTest.setNom("nom");
		//Action (Act)

		categorieService.updateCategorie(categorieTest);
		Categorie categorieUpdate = categorieService.getCategorieFromId(categorieTest.getId());

		//Assert
		assertEquals(categorieUpdate.getNom(), categorieTest.getNom());

	}
	//test de la m�thode deleteCategorie
	@Test
	public void testDeleteCategorie() throws Exception {

		categorieService.deleteCategorie(categorieTest);
		categorieTest = categorieService.getCategorieFromId(categorieTest.getId());

		assertNull(categorieTest);
	}
	//D�claration de l'ordre d'�x�cution des tests
	public static junit.framework.Test suite() {

		TestSuite suite = new TestSuite("Suite TestCategorieService");

		suite.addTest(new testCategorieService("testCreateCategorie"));
		suite.addTest(new testCategorieService("testUpdateCategorie"));
		suite.addTest(new testCategorieService("testDeleteCategorie"));

		return suite;
	}

}
