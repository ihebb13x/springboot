package com.nadhem.products.service;

import java.util.List;

import com.nadhem.products.entities.Categorie;
import com.nadhem.products.entities.Produit;
import com.nadhem.produits.dto.ProduitDTO;

public interface ProduitService {
	
	ProduitDTO saveProduit(Produit p);
	Produit updateProduit(Produit p);
	void deleteProduit(Produit p);
	void deleteProduitById(Long id);
	ProduitDTO getProduit(Long id);
	List<ProduitDTO> getAllProduits();
	List<Produit> findByNomProduit(String nom);
	List<Produit> findByNomProduitContains(String nom);
	List<Produit> findByNomPrix (String nom, Double prix);
	List<Produit> findByCategorie (Categorie categorie);
	List<Produit> findByCategorieIdCat(Long id);
	List<Produit> findByOrderByNomProduitAsc();
	List<Produit> trierProduitsNomsPrix();
	ProduitDTO convertEntityToDto (Produit produit);

	Produit convertDtoToEntity(ProduitDTO produitDto);


}
