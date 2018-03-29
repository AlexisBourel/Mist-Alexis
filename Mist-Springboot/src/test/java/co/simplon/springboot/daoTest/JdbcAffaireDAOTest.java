package co.simplon.springboot.daoTest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.simplon.springboot.model.Affaire;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcAffaireDAOTest {

	@Test
	public List<Affaire> listAffaires() throws Exception {
		return null;}

	public Affaire getAffaire(Long id) throws Exception {
		return null;}

	public Affaire insertAffaire(Affaire affaire) throws Exception {
		return affaire;}

	public Affaire updateAffaire(Affaire affaire) throws Exception {
		return affaire;}

	public void deleteAffaire(Long id) throws Exception {}

	Affaire getAffaireFromResultSet(ResultSet rs) throws SQLException {
		return null;} 
	
}


