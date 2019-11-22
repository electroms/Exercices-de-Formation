/**
 * 
 */
package com.blogrecette.test;

import java.sql.Connection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.blogrecette.model.Ingredient;
import com.blogrecette.services.IngredientService;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author Pierre-Henry Barge
 *
 */
//D�claration de la classe
public class testIngredientService extends TestCase {
	//Affectation des attributs � null
	private static Connection connection = null;
	private static IngredientService ingredientService = null;
	private static Ingredient ingredientTest = null;


	/**
	 * @throws java.lang.Exception
	 */
	//Cr�ation d'un constructeur vide
	public testIngredientService() {

	}
	//Cr�ation d'un nouveau constructeur
	public testIngredientService(String testName) {
		super(testName);
	}
	//Creation du setup
	@Before
	public void setUp() throws Exception {

		ingredientService = new IngredientService();
		if (ingredientTest == null) {
			ingredientTest = new Ingredient("nom_ingredient", 750, "g");
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	//Creation du tearDown
	public void tearDown() throws Exception {
		ingredientService = null;
	}
	//test de la m�thode createIngredient
	@Test
	public void testCreateIngredient() throws Exception {
		//Cr�� un jeu de test (Arrange)


		//Action (Act)
		ingredientTest = ingredientService.createIngredient(ingredientTest);
		Ingredient IngredientCree = ingredientService.getIngredientFromId(ingredientTest.getId());

		//Assert
		assertEquals(ingredientTest.getNom(), IngredientCree.getNom());
		assertEquals(ingredientTest.getQuantite(), IngredientCree.getQuantite());
		assertEquals(ingredientTest.getUnit(), IngredientCree.getUnit());

	}
	//test de la m�thode updateIngredient
	@Test
	public void testUpdateIngredient() throws Exception {
		//Cree jeu de test (Arrange)



		ingredientTest.setNom("poulet");
		ingredientTest.setQuantite(800);
		ingredientTest.setUnit("g");


		//Action (Act)

		ingredientService.updateIngredient(ingredientTest);
		Ingredient ingredientUpdate = ingredientService.getIngredientFromId(ingredientTest.getId());

		//Assert
		assertEquals(ingredientUpdate.getNom(), ingredientTest.getNom());
		assertEquals(ingredientUpdate.getQuantite(), ingredientTest.getQuantite());
		assertEquals(ingredientUpdate.getUnit(), ingredientTest.getUnit());
	}
	//test de la m�thode deleteIngredient
	@Test
	public void testDeleteIngredient() throws Exception {

		ingredientService.deleteIngredient(ingredientTest);
		ingredientTest = ingredientService.getIngredientFromId(ingredientTest.getId());

		assertNull(ingredientTest);
	}
	//D�claration de l'ordre d'�x�cution des tests
	public static junit.framework.Test suite() {

		TestSuite suite = new TestSuite("Suite TestIngredientService");

		suite.addTest(new testIngredientService("testCreateIngredient"));
		suite.addTest(new testIngredientService("testUpdateIngredient"));
		suite.addTest(new testIngredientService("testDeleteIngredient"));

		return suite;
	}
}
