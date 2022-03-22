package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {

	AutoGuma guma;

	@BeforeEach
	void setUp() throws Exception {
		guma = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		guma = null;
	}

	@Test
	void testAutoGuma() {
		guma = new AutoGuma();
		assertNotNull(guma);
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		guma = new AutoGuma("Michelin", 17, 205, 55);
		assertNotNull(guma);
		assertEquals("Michelin", guma.getMarkaModel());
		assertEquals(17, guma.getPrecnik());
		assertEquals(205, guma.getSirina());
		assertEquals(55, guma.getVisina());
	}

	@Test
	void testSetMarkaModel() {
		guma.setMarkaModel("Michelin");
		assertEquals("Michelin", guma.getMarkaModel());
	}
	
	@Test
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class, () -> guma.setMarkaModel(null));
	}
	
	@Test
	void testSetMarkaManjeOdTri() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> guma.setMarkaModel("Mi"));
	}

	@ParameterizedTest
	@CsvSource({"17", "21", "15"})
	void testSetPrecnik(int precnik) {
		guma.setPrecnik(precnik);
		assertEquals(precnik, guma.getPrecnik());
	}
	
	@Test
	void testSetPrecnikIzvanOpsegaManje() {
		assertThrows(java.lang.RuntimeException.class, () -> guma.setPrecnik(5));
	}
	
	@Test
	void testSetPrecnikIzvanOpsegaVece() {
		assertThrows(java.lang.RuntimeException.class, () -> guma.setPrecnik(25));
	}

	@ParameterizedTest
	@CsvSource({"250", "180", "140"})
	void testSetSirina(int sirina) {
		guma.setSirina(sirina);
		assertEquals(sirina, guma.getSirina());
	}
	
	@Test
	void testSetSirinaIzvanOpsegaManje() {
		assertThrows(java.lang.RuntimeException.class, () -> guma.setSirina(90));
	}
	
	@Test
	void testSetSirinaIzvanOpsegaVece() {
		assertThrows(java.lang.RuntimeException.class, () -> guma.setSirina(450));
	}

	@ParameterizedTest
	@CsvSource({"90", "30", "28"})
	void testSetVisina(int visina) {
		guma.setVisina(visina);
		assertEquals(visina, guma.getVisina());
	}
	
	@Test
	void testSetVisinaIzvanOpsegaManje() {
		assertThrows(java.lang.RuntimeException.class, () -> guma.setVisina(9));
	}
	
	@Test
	void testSetVisinaIzvanOpsegaVece() {
		assertThrows(java.lang.RuntimeException.class, () -> guma.setVisina(100));
	}

	@Test
	void testToString() {
		guma.setMarkaModel("Michelin");
		guma.setPrecnik(17);
		guma.setSirina(205);
		guma.setVisina(55);
		
		String s = guma.toString();
		assertTrue(s.contains("Michelin"));
		assertTrue(s.contains("17"));
		assertTrue(s.contains("205"));
		assertTrue(s.contains("55"));
	}

	@ParameterizedTest
	@CsvSource({
			"Michelin, 17, 205, 55, Michelin, 17, 205, 55, true",
			"Samson, 17, 205, 55, Michelin, 17, 205, 55, false",
			"Michelin, 18, 205, 55, Michelin, 17, 205, 55, false",
			"Michelin, 17, 210, 55, Michelin, 17, 205, 55, false",
			"Michelin, 17, 205, 60, Michelin, 17, 205, 55, false",
			"Samoson, 18, 210, 60, Michelin, 17, 205, 55, false"
	})
	void testEqualsObject(String markaModel1, int precnik1, int sirina1, int visina1,
			String markaModel2, int precnik2, int sirina2, int visina2, boolean tacno) {
		guma.setMarkaModel(markaModel1);
		guma.setPrecnik(precnik1);
		guma.setSirina(sirina1);
		guma.setVisina(visina1);

		AutoGuma g2 = new AutoGuma();
		g2.setMarkaModel(markaModel2);
		g2.setPrecnik(precnik2);
		g2.setSirina(sirina2);
		g2.setVisina(visina2);
		assertEquals(tacno, guma.equals(g2));
	}

}
