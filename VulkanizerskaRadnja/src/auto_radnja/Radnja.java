package auto_radnja;

import java.util.List;
import auto_radnja.gume.AutoGuma;

/**
 * Predstavlja radnju koja prodaje gume. 
 * 
 * Ima osnovne operacije dodavanja, pretrage i daje uvid u sve postojece gume.
 * @author Lasa
 * @version 1.0
 */
public interface Radnja {
	
	/**
	 * Dodaje novu gumu u radnju.
	 * 
	 * Dodaje gumu u radnju samo ako guma vec ne postoji u radnji i ako nije null.
	 * Nisu dozvoljeni duplikati guma u radnji.
	 * 
	 * @param guma guma koju treba dodati u radnju
	 * @throws java.lang.NullPointerException ako je uneta guma null
	 * @throws java.lang.RuntimeException ako uneta guma vec postoji u radnji
	 * @see auto_radnja.gume.AutoGuma
	 */
	void dodajGumu(AutoGuma a);

	/**
	 * Vrsi pretragu i vraca listu guma iz radnje koje zadovoljavaju date uslove pretrage.
	 * 
	 * Pretraga se vrsi prema nazivu marke modela gume. Pretraga se vrsi ukoliko uslov nije null. Naziv marke modela mora
	 * biti tacan i pretraga je osetljiva na velika i mala slova. 
	 * 
	 * @param markaModel naziv marke modela guma.
	 * @return
	 * <ul>
	 * <li>Lista koja sadrzi sve gume koji odgovaraju uslovima pretrage.</li>
	 * <li>null ako je uslov pretrage null</li>
	 * </ul>
	 */
	List<AutoGuma> pronadjiGumu(String markaModel);

	/**
	 * Vraca sve automobilske gume iz radnje.
	 *  
	 * @return Lista sa svim gumama iz radnje.
	 */
	List<AutoGuma> vratiSveGume();
}