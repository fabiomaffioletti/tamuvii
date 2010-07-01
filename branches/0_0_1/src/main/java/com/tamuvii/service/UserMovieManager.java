package com.tamuvii.service;

import java.util.List;
import java.util.Map;

import com.tamuvii.exception.IllegalOperationException;
import com.tamuvii.model.UserMovie;
import com.tamuvii.pojo.MovieItem;
import com.tamuvii.pojo.ShelfItem;

public interface UserMovieManager {
	
	/**
	 * Ritorna la lista di tutti gli ShelfItem di uno username
	 * @param username Username dell'utente di cui si vuole vedere la lista
	 * @param from From paginazione
	 * @param to To paginazione
	 * @return Lista di ShelfItem
	 */
	public List<ShelfItem> getAll(String username, Integer from, Integer to);
	
	/**
	 * Ritorna la lista dei ShelfItem appartenenti alla shelf dell'utente
	 * @param filter Stringa per la ricerca di un film all'interno della lista
	 * @param Username dell'utente di cui si vuole vedere la lista
	 * @param from From paginazione
	 * @param to To paginazione
	 * @return Lista di ShelfItem della shelf
	 */
	public List<ShelfItem> getAllShelf(String filter, String username, Integer from, Integer to);
	
	/**
	 * Ritorna il conteggio di tutti gli elementi della shelf dell'utente
	 * @param filter Stringa per la ricerca di un film all'interno della lista
	 * @param Username dell'utente di cui si vuole vedere la lista
	 * @return Numero degli elementi della lista
	 */
	public Integer getAllShelfCount(String filter, String username);
	
	/**
	 * Ritorna la lista dei ShelfItem appartenenti alla wishlist dell'utente
	 * @param filter Stringa per la ricerca di un film all'interno della lista
	 * @param Username dell'utente di cui si vuole vedere la lista
	 * @param from From paginazione
	 * @param to To paginazione
	 * @return Lista di ShelfItem della wishlist
	 */
	public List<ShelfItem> getAllWishlist(String filter, String username, Integer from, Integer to);
	
	/**
	 * Ritorna il conteggio di tutti gli elementi della wishlist dell'utente
	 * @param filter Stringa per la ricerca di un film all'interno della lista
	 * @param Username dell'utente di cui si vuole vedere la lista
	 * @return Numero degli elementi della lista
	 */
	public Integer getAllWishlistCount(String filter, String username);
	
	/**
	 * Ritorna lo ShelfItem appartenente all'utente
	 * @param username Username dell'utente che ha quello ShelfItem
	 * @param movie ID del film
	 * @return ShelfItem relativo a username e movie
	 */
	public ShelfItem getUserMovieByMovieId(String username, Long movie);
	
	/**
	 * Aggiunge un record alla tabella user_movie
	 * @param userMovie
	 */
	public void saveUserMovie(UserMovie userMovie);
	
	/**
	 * Aggiunge un record alla tabella user_movie
	 * @param movie ID del film
	 * @param mark Voto del film
	 * @param wishlist Appartenenza alla wishlist
	 * @throws IllegalOperationException
	 */
	public void addUserMovie(Long movie, Integer mark, Integer wishlist) throws IllegalOperationException;
	
	/**
	 * Aggiorna un record della tabella user_movie
	 * @param movie ID del film
	 * @param mark Voto del film
	 * @param dateViewed Data in cui è stato visto
	 * @param reviewTitle Titolo della recensione
	 * @param reviewText Testo della recensione
	 * @throws IllegalOperationException
	 * @throws java.text.ParseException
	 */
	public void updateUserMovie(Long movie, Integer mark, String dateViewed, String reviewTitle, String reviewText) throws IllegalOperationException, java.text.ParseException;
	
	/**
	 * Elimina un record dalla tabella user_movie
	 * @param movie ID del film da eliminare
	 * @throws IllegalOperationException
	 */
	public void deleteUserMovieById(Long movie) throws IllegalOperationException;
	
	/**
	 * Sposta il film dalla wishlist alla shelf
	 * @param movie ID del film da spostare
	 * @throws IllegalOperationException
	 */
	public void moveToShelf(Long movie) throws IllegalOperationException;
	
	/**
	 * Confronta gli elementi della shelf/wishlist dell'utente first con quelli dell'utente second 
	 * @param first Username del primo utente
	 * @param second Username del secondo utente
	 * @param items Lista degli elementi da confrontare
	 * @return Una mappa contenente il confronto degli elementi, ovvero l'appartenenza degli elementi della shelf/wishlist del first con quelli del second
	 */
	public Map getShelfItemBelonging(String first, String second, List<ShelfItem> items);
	
	/**
	 * Confronta gli elementi della shelf/wishlist dell'utente con quelli derivati ad esempio da una ricerca globale, ovvero quando non è coinvolto un secondo utente
	 * @param username Username dell'utente
	 * @param items Lista dei film dell'utente
	 * @return Una mappa contenente il confronto degli elementi, ovvero l'appartenenza degli elementi della shelf/wishlist dell'utente con quelli derivati ad esempio da una ricerca globale
	 */
	public Map getMovieItemBelonging(String username, List<MovieItem> items);
	
	/**
	 * Stabilisce se il film appartiene alla shelf/wishlist dell'utente
	 * @param username Username dell'utente
	 * @param movie ID del film
	 * @return Intero rappresentante l'appartenenza del film alla shelf o alla wishlist
	 */
	public Integer getSingleMovieItemBelonging(String username, Long movie);
}