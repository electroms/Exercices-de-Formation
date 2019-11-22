package com.blogrecette.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blogrecette.model.Membre;
import com.blogrecette.services.MembreService;


/**
 * Servlet implementation class Inscription
 */
//D�claration du webServlets
@WebServlet(name="Inscription",urlPatterns= {"/inscription"})
//D�claration de la servlets
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	//On creer un constructeur vide
	public InscriptionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//On creer le DOGET
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//On creer un dispatcher pour rediriger vers la page souhait�e
		this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//On creer un DOPOST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Cr�ation de la session		
		HttpSession session = request.getSession();
		String erreur = "";
		Date dateInscription = new Date();

		//Cr�ation de l'objet nom		
		String nom = request.getParameter("nom");
		//Cr�ation des boucles pour v�rifier si le formulaire est compl�ter correctement
		if (nom.isEmpty()) {
			erreur += "Veuillez renseigner un nom<br>";
		}

		String pseudo =request.getParameter("pseudo");
		if (pseudo.isEmpty()) {
			erreur += "Veuillez renseigner un pseudo<br>";
		}
		String email = request.getParameter("email");
		if (email.isEmpty()) {
			erreur += "Veuillez renseigner un email valide<br>";
		}

		String mdp = request.getParameter("mdp");
		if (mdp.isEmpty()) {
			erreur += "Veuillez renseigner un MDP<br>";
		}

		//Cr�ation des fonctions de Membre		
		Membre membre = new Membre(nom, pseudo, mdp, email, new Date());


		//Si la condition est v�rifier renvoyer vers confirmation
		if (erreur.isEmpty()) {
			Connection connection = null;
			try {
				MembreService membreService = new MembreService();

				membre = membreService.createMembre(membre);
				session.setAttribute("membre",membre);
				response.sendRedirect("acceuil");


			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Si la condition n'est pas v�rifier renvoyer vers le formulaire
		else {
			request.setAttribute("erreur", erreur);

			//On creer un disptcher pour rediriger vers la page souhait�e
			this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
		}
	}

}
