package org.azkfw.persistence.profile;

import java.io.IOException;
import java.nio.charset.Charset;

import org.azkfw.persistence.AbstractTestCase;
import org.junit.Test;

/**
 * このクラスは、{@link IniFile}クラスのユニットテストを行うクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.1 2014/06/06
 * @author Kawakicchi
 */
public class IniFileTest extends AbstractTestCase {

	@Test
	public void testRead() {
		IniFile ini = new IniFile();
		try {
			ini.read(getResourceAsFile("IniFiles/SJIS.ini"), Charset.forName("SJIS"));

			assertEquals("SJIS", ini.get("global", "文字コード", ""));

			ini.read(getResourceAsFile("IniFiles/UTF8.ini"), Charset.forName("UTF8"));

			assertEquals("UTF8", ini.get("global", "文字コード", ""));

		} catch (IOException ex) {
			ex.printStackTrace();
			fail();
		}
	}

	@Test
	public void testWrite() {
		IniFile ini = new IniFile();
		try {

			ini.put("global", "文字コード", "UTF8");

			ini.write(getResourceAsFile("test.ini"), Charset.forName("UTF8"));

		} catch (IOException ex) {
			ex.printStackTrace();
			fail();
		}
	}

	@Test
	public void testGetType() {
		IniFile ini = new IniFile();
		try {
			ini.read(getResourceAsFile("IniFiles/type.ini"), Charset.forName("UTF8"));

			// String
			assertEquals("ABC", ini.get("string", "value1", "DEFAULT"));

			// Integer
			assertEquals(Integer.valueOf(1), ini.get("integer", "value1", Integer.valueOf(-1)));

			// Long
			assertEquals(Long.valueOf(2), ini.get("long", "value1", Long.valueOf(-1)));

			// Float
			assertEquals(Float.valueOf(0.1f), ini.get("float", "value1", Float.valueOf(-1)));

			// Double
			// assertEquals(Double.valueOf(0.2f), ini.get("double", "value1", Double.valueOf(-1)));

			// Boolean
			assertTrue(ini.get("boolean", "value1", Boolean.FALSE));
			assertFalse(ini.get("boolean", "value2", Boolean.TRUE));
			assertTrue(ini.get("boolean", "value3", Boolean.FALSE));
			assertFalse(ini.get("boolean", "value4", Boolean.TRUE));
			assertTrue(ini.get("boolean", "value5", Boolean.FALSE));
			assertFalse(ini.get("boolean", "value6", Boolean.TRUE));

		} catch (IOException ex) {
			ex.printStackTrace();
			fail();
		}
	}
}
