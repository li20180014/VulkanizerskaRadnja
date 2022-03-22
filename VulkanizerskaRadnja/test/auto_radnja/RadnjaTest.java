package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {

	protected Radnja radnja;
	protected AutoGuma guma;

	@BeforeEach
	void setUp() throws Exception {
		guma = new AutoGuma();
		guma.setMarkaModel("Michelin");
		guma.setPrecnik(17);
		guma.setSirina(205);
		guma.setVisina(55);
	}

	@AfterEach
	void tearDown() throws Exception {
		guma = null;
	}

	@Test
	void testDodajGumu() {

		radnja.dodajGumu(guma);

		assertEquals(1, radnja.vratiSveGume().size());
		assertEquals(guma, radnja.vratiSveGume().get(0));
	}

	@Test
	void testDodajGumuViseGuma() {

		AutoGuma g2 = new AutoGuma();
		g2.setMarkaModel("Samson");
		g2.setPrecnik(16);
		g2.setSirina(200);
		g2.setVisina(60);

		radnja.dodajGumu(guma);
		radnja.dodajGumu(g2);

		assertEquals(2, radnja.vratiSveGume().size());
		assertTrue(radnja.vratiSveGume().contains(guma));
		assertTrue(radnja.vratiSveGume().contains(g2));
	}

	@Test
	void testDodajGumuDuplikat() {

		AutoGuma g2 = new AutoGuma();
		g2.setMarkaModel("Michelin");
		g2.setPrecnik(17);
		g2.setSirina(205);
		g2.setVisina(55);

		radnja.dodajGumu(guma);

		assertThrows(java.lang.RuntimeException.class, () -> radnja.dodajGumu(g2));
	}

	@Test
	void testDodajGumuNull() {
		assertThrows(java.lang.NullPointerException.class, () -> radnja.dodajGumu(null));
	}

	@Test
	void testPronadjiGumu() {

		radnja.dodajGumu(guma);

		List<AutoGuma> lista = radnja.pronadjiGumu("Michelin");

		assertEquals(1, lista.size());
		assertTrue(lista.contains(guma));

	}

	@Test
	void testPronadjiGumuNemaRezultata() {

		radnja.dodajGumu(guma);
		AutoGuma g2 = new AutoGuma();
		g2.setMarkaModel("Samson");
		g2.setPrecnik(15);
		g2.setSirina(200);
		g2.setVisina(65);

		radnja.dodajGumu(g2);

		List<AutoGuma> lista = radnja.pronadjiGumu("Tigar");

		assertEquals(0, lista.size());
	}

	@Test
	void testPronadjiGumuViseGuma() {

		radnja.dodajGumu(guma);

		AutoGuma g2 = new AutoGuma();
		g2.setMarkaModel("Michelin");
		g2.setPrecnik(15);
		g2.setSirina(200);
		g2.setVisina(65);

		radnja.dodajGumu(g2);

		List<AutoGuma> lista = radnja.pronadjiGumu("Michelin");

		assertEquals(2, lista.size());
		assertTrue(lista.contains(guma));
		assertTrue(lista.contains(g2));
	}

	@Test
	void testPronadjiGumuNull() {

		radnja.dodajGumu(guma);

		AutoGuma g2 = new AutoGuma();
		g2.setMarkaModel("Samson");
		g2.setPrecnik(17);
		g2.setSirina(205);
		g2.setVisina(55);

		radnja.dodajGumu(g2);

		List<AutoGuma> lista = radnja.pronadjiGumu(null);

		assertEquals(null, lista);
	}

	@Test
	void testVratiSveGume() {

		radnja.dodajGumu(guma);

		assertEquals(1, radnja.vratiSveGume().size());
		assertTrue(radnja.vratiSveGume().contains(guma));
	}

}
