package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProfileTest {

	@Test
	public void testLoadDbConfig() {
		var props = Profile.getProperties("db");
		assertNotNull(props);

		var dbName = props.getProperty("database");

		assertEquals("swingdb", dbName);

	}
}
