package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

public class VulkanizerskaRadnjaTest extends RadnjaTest {

	@BeforeEach
	void setUp() throws Exception {
		super.setUp();
		radnja = new VulkanizerskaRadnja();
	}

	@AfterEach
	void tearDown() throws Exception {
		radnja = null;
		guma=null;
	}

}
