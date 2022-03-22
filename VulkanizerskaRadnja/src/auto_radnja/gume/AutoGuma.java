package auto_radnja.gume;

/**
 * Klasa koja predstavlja gumu za automobil.
 * Guma za automobil ima atribute marka modela, precnik, sirinu i visinu gume.
 * 
 * @author Lasa
 * @version 1.0
 *
 */

public class AutoGuma {
	
	/**
	 * Naziv marke modela gume 
	 */
	private String markaModel = null;
	/**
	 * Precnik gume 
	 */
	private int precnik = -1;
	/**
	 * Sirina gume
	 */
	private int sirina = -1;
	/**
	 * Visina gume 
	 */
	private int visina = -1;

	/**
	 * Konstruktor kojim se inicijalizuje novi objekat klase AutoGuma
	 */
	public AutoGuma() {
	}
	/**
	 * Parametrizovani konstruktor kojim se inicijalizuje novi objekat klase AutoGuma 
	 * i postavljaju se vrednosti za atribute markaModel, precnik, sirina i visina gume
	 * 
	 * @param markaModel novi naziv marke modela gume
	 * @param precnik novi precnik gume
	 * @param sirina nova sirina gume
	 * @param visina nova visina gume
	 */

	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}
	
	/**
	 * Vraca naziv marke modela gume
	 * 
	 * @return naziv marke modela kao String
	 */
	public String getMarkaModel() {
		return markaModel;
	}

	/**
	 * Postavlja novu vrednost za atribut markaModel
	 * 
	 * @param markaModel novi naziv marke modela
	 * @throws java.lang.NullPointerException ako je uneti naziv marke null
	 * @throws java.lang.IllegalArgumentException ako je uneti naziv String duzine manje od 3 znaka
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length() < 3)
			throw new IllegalArgumentException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}

	/**
	 * Vraca precnik gume 
	 * 
	 * @return precnik gume kao integer
	 */
	public int getPrecnik() {
		return precnik;
	}

	/**
	 * Postavlja novu vrednost za atribut precnik 
	 * 
	 * @param precnik novi precnik gume
	 * @throws java.lang.IllegalArgumentException ako je uneti precnik integer izvan datog opsega
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 || precnik > 22)
			throw new IllegalArgumentException("Precnik van opsega");
		this.precnik = precnik;
	}

	/**
	 * Vraca sirinu gume
	 * 
	 * @return sirina gume kao integer
	 */
	public int getSirina() {
		return sirina;
	}

	/**
	 * Postavlja novu vrednost za atribut sirina
	 * 
	 * @param sirina nova sirina gume
	 * @throws java.lang.IllegalArgumentException ako je uneta sirina integer izvan datog opsega
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 || sirina > 355)
			throw new IllegalArgumentException("Sirina van opsega");
		this.sirina = sirina;
	}

	/**
	 * Vraca visinu gume
	 * 
	 * @return visina gume kao integer
	 */
	public int getVisina() {
		return visina;
	}

	/**
	 * Postavlja novu vrednost za atribut visina
	 * 
	 * @param visina nova visina gume
	 * @throws java.lang.IllegalArgumentException ako je uneta visina integer izvan opsega, odnosno manji od 25 ili veci od 95
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new IllegalArgumentException("Visina van opsega");
		this.visina = visina;
	}

	/**
	 * Vraca sve podatke o auto gumi u jednom String-u
	 * 
	 * @return String sa svim atributima klase AutoGuma
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina="
				+ visina + "]";
	}

	/**
	 *  Poredi dve auto gume po svim njihovim atributima
	 *  
	 *  @return
	 * <ul>
	 * <li>vraca vrednost true ako su objekti klase AutoGuma isti po nazivu marke, sirini, precniku i visini</li>
	 * <li>vraca vrednost false ako to nije slucaj</li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}
}
