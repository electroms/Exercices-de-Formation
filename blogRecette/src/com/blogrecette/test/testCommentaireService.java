/**
 * 
 */
package com.blogrecette.test;

import java.sql.Connection;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.blogrecette.model.Commentaire;
import com.blogrecette.services.CommentaireService;

import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * @author Pierre-Henry Barge
 *
 */
//D�claration de la classe
public class testCommentaireService extends TestCase {
	//Affectation des attributs � null
	private static CommentaireService commentaireService = null;
	private static Commentaire commentaireTest = null;

	/**
	 * @throws java.lang.Exception
	 */
	//Cr�ation d'un constructeur vide
	public testCommentaireService() {

	}
	//Cr�ation d'un nouveau constructeur
	public testCommentaireService(String testName) {
		super(testName);
	}
	//Creation du setup
	@Before
	public void setUp() throws Exception {


		commentaireService = new CommentaireService();
		if (commentaireTest == null) {
			commentaireTest = new Commentaire("Aur�lien", "test", 2, new Date());
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	//Creation du tearDown
	public void tearDown() throws Exception {
		commentaireService = null;
	}
	//test de la m�thode createCommentaire
	@Test
	public void testCreateCommentaire() throws Exception {
		//Cr�� un jeu de test (Arrange)


		//Action (Act)
		commentaireTest = commentaireService.createCommentaire(commentaireTest);
		Commentaire CommentaireCree = commentaireService.getCommentaireFromId(commentaireTest.getId());

		//Assert
		assertEquals(commentaireTest.getAuteur(), CommentaireCree.getAuteur());
		assertEquals(commentaireTest.getContenu(), CommentaireCree.getContenu());
		assertEquals(commentaireTest.getNote(), CommentaireCree.getNote());
		assertEquals(commentaireTest.getDateCreation().getDate(), CommentaireCree.getDateCreation().getDate());

	}
	//test de la m�thode updateCommentaire
	@Test
	public void testUpdateCommentaire() throws Exception {
		//Cree jeu de test (Arrange)
		Date newDate = new Date("2019/11/06");


		commentaireTest.setAuteur("Pierre-Henry");
		commentaireTest.setContenu("Ceci est un commentaire");
		commentaireTest.setNote(0);
		commentaireTest.setDateCreation(newDate);

		//Action (Act)

		commentaireService.updateCommentaire(commentaireTest);
		Commentaire commentaireUpdate = commentaireService.getCommentaireFromId(commentaireTest.getId());

		//Assert
		assertEquals(commentaireUpdate.getAuteur(), commentaireTest.getAuteur());
		assertEquals(commentaireUpdate.getContenu(), commentaireTest.getContenu());
		assertEquals(commentaireUpdate.getNote(), commentaireTest.getNote());
		assertEquals(commentaireUpdate.getDateCreation().getDate(), commentaireTest.getDateCreation().getDate());

	}
	//test de la m�thode deleteCommentaire
	@Test
	public void testDeleteCommentaire() throws Exception {

		commentaireService.deleteCommentaire(commentaireTest);
		commentaireTest = commentaireService.getCommentaireFromId(commentaireTest.getId());

		assertNull(commentaireTest);
	}
	//D�claration de l'ordre d'�x�cution des tests
	public static junit.framework.Test suite() {

		TestSuite suite = new TestSuite("Suite TestCommentaireService");

		suite.addTest(new testCommentaireService("testCreateCommentaire"));
		suite.addTest(new testCommentaireService("testUpdateCommentaire"));
		suite.addTest(new testCommentaireService("testDeleteCommentaire"));

		return suite;
	}
}

