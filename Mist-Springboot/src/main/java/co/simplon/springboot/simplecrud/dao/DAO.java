package co.simplon.springboot.simplecrud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import co.simplon.springboot.simplecrud.model.Affaire;

public interface DAO<T> {

	/**
	 * Méthode de création
	 * 
	 * @param obj
	 * @return boolean
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public abstract Affaire create(T obj) throws SQLException, ClassNotFoundException;

	/**
	 * Méthode pour effacer
	 * 
	 * @param obj
	 * @return boolean
	 */
	public abstract Affaire delete(T obj);

	/**
	 * Méthode de mise à jour
	 * 
	 * @param obj
	 * @return boolean
	 */
	public abstract Affaire update(T obj);

	/**
	 * Méthode de recherche des informations
	 * 
	 * @param id
	 * @return T
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public abstract T findOne(long id) throws SQLException, ClassNotFoundException;
	
	/**
	 * Méthode de recherche des informations
	 * 
	 * @param id
	 * @return List<T>
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public abstract List<Affaire> findAll() throws SQLException, ClassNotFoundException;

}
