 package com.nadhem.products.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nadhem.products.entities.Categorie;
import com.nadhem.products.entities.Produit;
import com.nadhem.products.repos.ProduitRepository;
import com.nadhem.produits.dto.ProduitDTO;
@Service
public class ProduitServiceImpl implements ProduitService {
	 
	 @Autowired
	 ProduitRepository produitRepository;
	 public ProduitDTO saveProduit(Produit p) {
		 
		 return convertEntityToDto( produitRepository.save(p));
	 }
	 @Override
	 public Produit updateProduit(Produit p) {
	 return produitRepository.save(p);
	 }
	 @Override
	 public void deleteProduit(Produit p) {
	 produitRepository.delete(p);
	 }
	 @Override
	 public void deleteProduitById(Long id) {
	 produitRepository.deleteById(id);
	 }
	 @Override
	 public ProduitDTO getProduit(Long id) {
		 return convertEntityToDto( produitRepository.findById(id).get());
	 }
	  @Override
	 public List<ProduitDTO> getAllProduits() {
		  return produitRepository.findAll().stream()
				  .map(this::convertEntityToDto)
				  .collect(Collectors.toList());
				  //OU BIEN
				  /*List<Produit> prods = produitRepository.findAll();
				  List<ProduitDTO> listprodDto = new ArrayList<>(prods.size());
				  for (Produit p : prods)
				  listprodDto.add(convertEntityToDto(p));
				  return listprodDto;*/
	 }
	 @Override
	 public List<Produit> findByNomProduit(String nom) {
	 return produitRepository.findByNomProduit(nom);
	 }
	 @Override
	 public List<Produit> findByNomProduitContains(String nom) {
	 return produitRepository.findByNomProduitContains(nom);
	 }
	 @Override
	 public List<Produit> findByNomPrix(String nom, Double prix) {
		 return produitRepository.findByNomPrix(nom, prix);
	 }
	 @Override
	 public List<Produit> findByCategorie(Categorie categorie) {
	 return produitRepository.findByCategorie(categorie);
	 }
	 @Override
	 public List<Produit> findByCategorieIdCat(Long id) {
	 return produitRepository.findByCategorieIdCat(id);
	 }
	 @Override
	 public List<Produit> findByOrderByNomProduitAsc() {
	 return produitRepository.findByOrderByNomProduitAsc();
	 }
	 @Override
	 public List<Produit> trierProduitsNomsPrix() {
	 return produitRepository.trierProduitsNomsPrix();
	 }
	 
	 
	 
	 @Override
	 public ProduitDTO convertEntityToDto(Produit produit) {
	 ProduitDTO produitDTO = new ProduitDTO();
	 produitDTO.setIdProduit(produit.getIdProduit());
	 produitDTO.setNomProduit(produit.getNomProduit());
	 produitDTO.setPrixProduit(produit.getPrixProduit());
	 produitDTO.setDateCreation(p.getDateCreation());
	 produitDTO.setCategorie(produit.getCategorie());
	 return produitDTO;
	 /*return ProduitDTO.builder()
	 .idProduit(produit.getIdProduit())
	 .nomProduit(produit.getNomProduit())
	 .prixProduit(produit.getPrixProduit())
	 .dateCreation(p.getDateCreation())
	 .categorie(produit.getCategorie())
	 .build();*/
	 }
	 
	 
	 @Override
	 public Produit convertDtoToEntity(ProduitDTO produitDto) {
	 Produit produit = new Produit();
	 produit.setIdProduit(produitDto.getIdProduit());
	 produit.setNomProduit(produitDto.getNomProduit());
	 produit.setPrixProduit(produitDto.getPrixProduit());
	 produit.setDateCreation(produitDto.getDateCreation());
	 produit.setCategorie(produitDto.getCategorie());
	 return produit;
	 }
	 
	 

 }
	