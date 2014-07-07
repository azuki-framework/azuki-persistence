/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.azkfw.persistence.profile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.azkfw.util.StringUtility;

/**
 * このクラスは、iniファイルの読み書きを行うクラスです。
 * 
 * @since 1.2.0
 * @version 1.2.0 2014/07/07
 * @author Kawakicchi
 */
public class IniFile implements Profile {

	/** データ */
	private Map<String, Map<String, String>> data;

	/**
	 * コンストラクタ
	 */
	public IniFile() {
		data = new HashMap<String, Map<String, String>>();
	}

	/**
	 * iniファイルを読み込む。
	 * 
	 * @param aFile iniファイル
	 * @throws IOException IO操作に起因する問題が発生した場合
	 */
	public void read(final String aFile) throws IOException {
		read(aFile, System.getProperty("file.encoding"));
	}

	/**
	 * iniファイルを読み込む。
	 * 
	 * @param aFile iniファイル
	 * @throws IOException IO操作に起因する問題が発生した場合
	 */
	public void read(final File aFile) throws IOException {
		read(aFile, System.getProperty("file.encoding"));
	}

	/**
	 * iniファイルを読み込む。
	 * 
	 * @param aFile iniファイル
	 * @param aCharset 文字コード
	 * @throws IOException IO操作に起因する問題が発生した場合
	 */
	public void read(final String aFile, final String aCharset) throws IOException {
		read(aFile, Charset.forName(aCharset));
	}

	/**
	 * iniファイルを読み込む。
	 * 
	 * @param aFile iniファイル
	 * @param aCharset 文字コード
	 * @throws IOException IO操作に起因する問題が発生した場合
	 */
	public void read(final File aFile, final String aCharset) throws IOException {
		read(aFile, Charset.forName(aCharset));
	}

	/**
	 * iniファイルを読み込む。
	 * 
	 * @param aFile iniファイル
	 * @param aCharset 文字コード
	 * @throws IOException IO操作に起因する問題が発生した場合
	 */
	public void read(final String aFile, final Charset aCharset) throws IOException {
		read(new File(aFile), aCharset);
	}

	/**
	 * iniファイルを読み込む。
	 * 
	 * @param aFile iniファイル
	 * @param aCharset 文字コード
	 * @throws IOException IO操作に起因する問題が発生した場合
	 */
	public void read(final File aFile, final Charset aCharset) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(aFile), aCharset));

			String section = null;
			String line = null;
			while (null != (line = reader.readLine())) {
				line = StringUtility.trim(line);
				if (StringUtility.isEmpty(line)) {
					// empty
				} else if (line.startsWith(";")) {
					// comment
				} else if (line.startsWith("[") && line.endsWith("]")) {
					// section
					String sec = line.substring(1, line.length() - 1);
					section = StringUtility.trim(sec);
					//System.out.println("SECTION : " + section);
				} else {
					int index = line.indexOf("=");
					if (-1 == index) {
						// illegal
					} else {
						String name = line.substring(0, index);
						String value = line.substring(index + 1);
						name = StringUtility.trim(name);
						value = StringUtility.trim(value);

						if (null != section) {
							Map<String, String> values = null;
							if (data.containsKey(section)) {
								values = data.get(section);
							} else {
								values = new HashMap<String, String>();
								data.put(section, values);
							}
							values.put(name, value);
							//System.out.println(name + " = " + value);
						}
					}
				}
			}

		} finally {
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException ex) {
					// none
				}
			}
		}
	}

	/**
	 * iniファイルに書き出す。
	 * 
	 * @param aFile iniファイル
	 * @throws IOException IO操作に起因する問題が発生した場合
	 */
	public void write(final String aFile) throws IOException {
		write(aFile, System.getProperty("file.encoding"));
	}

	/**
	 * iniファイルに書き出す。
	 * 
	 * @param aFile iniファイル
	 * @throws IOException IO操作に起因する問題が発生した場合
	 */
	public void write(final File aFile) throws IOException {
		write(aFile, System.getProperty("file.encoding"));
	}

	/**
	 * iniファイルに書き出す。
	 * 
	 * @param aFile iniファイル
	 * @param aCharset 文字コード
	 * @throws IOException IO操作に起因する問題が発生した場合
	 */
	public void write(final String aFile, final String aCharset) throws IOException {
		write(aFile, Charset.forName(aCharset));
	}

	/**
	 * iniファイルに書き出す。
	 * 
	 * @param aFile iniファイル
	 * @param aCharset 文字コード
	 * @throws IOException IO操作に起因する問題が発生した場合
	 */
	public void write(final File aFile, final String aCharset) throws IOException {
		write(aFile, Charset.forName(aCharset));
	}

	/**
	 * iniファイルに書き出す。
	 * 
	 * @param aFile iniファイル
	 * @param aCharset 文字コード
	 * @throws IOException IO操作に起因する問題が発生した場合
	 */
	public void write(final String aFile, final Charset aCharset) throws IOException {
		write(new File(aFile), aCharset);
	}

	/**
	 * iniファイルに書き出す。
	 * 
	 * @param aFile iniファイル
	 * @param aCharset 文字コード
	 * @throws IOException IO操作に起因する問題が発生した場合
	 */
	public void write(final File aFile, final Charset aCharset) throws IOException {
		String lineSeparator = "\n";
		try {
			lineSeparator = System.getProperty("line.separator");
		} catch (SecurityException ex) {
		}

		BufferedWriter writer = null;
		try {
			StringBuffer s = new StringBuffer();
			for (String section : data.keySet()) {
				s.append(String.format("[ %s ]", section));
				s.append(lineSeparator);

				Map<String, String> map = data.get(section);
				for (String name : map.keySet()) {
					String value = map.get(name);
					s.append(String.format("%s = %s", name, value));
					s.append(lineSeparator);
				}
			}

			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aFile), aCharset));
			writer.write(s.toString());

		} finally {
			if (null != writer) {
				try {
					writer.close();
				} catch (IOException ex) {
					// none
				}
			}
		}
	}

	@Override
	public String get(final String aSection, final String aName, final String aDefault) {
		String value = aDefault;
		if (data.containsKey(aSection)) {
			Map<String, String> map = data.get(aSection);
			if (map.containsKey(aName)) {
				value = map.get(aName);
			}
		}
		return value;
	}

	@Override
	public Integer get(final String aSection, final String aName, final Integer aDefault) {
		Integer value = aDefault;
		String s = get(aSection, aName, (String) null);
		if (StringUtility.isNotEmpty(s)) {
			try {
				value = Integer.parseInt(s);
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}
		return value;
	}

	@Override
	public Long get(final String aSection, final String aName, final Long aDefault) {
		Long value = aDefault;
		String s = get(aSection, aName, (String) null);
		if (StringUtility.isNotEmpty(s)) {
			try {
				value = Long.parseLong(s);
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}
		return value;
	}

	@Override
	public Float get(final String aSection, final String aName, final Float aDefault) {
		Float value = aDefault;
		String s = get(aSection, aName, (String) null);
		if (StringUtility.isNotEmpty(s)) {
			try {
				value = Float.parseFloat(s);
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}
		return value;
	}

	@Override
	public Double get(final String aSection, final String aName, final Double aDefault) {
		Double value = aDefault;
		String s = get(aSection, aName, (String) null);
		if (StringUtility.isNotEmpty(s)) {
			try {
				value = Double.parseDouble(s);
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}
		return value;
	}

	@Override
	public Boolean get(final String aSection, final String aName, final Boolean aDefault) {
		Boolean value = aDefault;
		String s = get(aSection, aName, (String) null);
		if (StringUtility.isNotEmpty(s)) {
			s = s.toLowerCase();
			if ("true".equals(s) || "on".equals(s) || "1".equals(s)) {
				value = true;
			} else if ("false".equals(s) || "off".equals(s) || "0".equals(s)) {
				value = false;
			}
		}
		return value;
	}

	@Override
	public void put(final String aSection, final String aName, final String aValue) {
		String section = StringUtility.trim(aSection);
		String name = StringUtility.trim(aName);
		String value = StringUtility.trim(aValue);

		Map<String, String> map = null;
		if (data.containsKey(section)) {
			map = data.get(section);
		} else {
			map = new HashMap<String, String>();
			data.put(section, map);
		}
		map.put(name, value);
	}

	@Override
	public void put(final String aSection, final String aName, final Integer aValue) {
		put(aSection, aName, Integer.toString(aValue));
	}

	@Override
	public void put(final String aSection, final String aName, final Long aValue) {
		put(aSection, aName, Long.toString(aValue));
	}

	@Override
	public void put(final String aSection, final String aName, final Float aValue) {
		put(aSection, aName, Float.toString(aValue));
	}

	@Override
	public void put(final String aSection, final String aName, final Double aValue) {
		put(aSection, aName, Double.toString(aValue));
	}

	@Override
	public void put(final String aSection, final String aName, final Boolean aValue) {
		put(aSection, aName, ((aValue) ? "true" : "false"));
	}

	@Override
	public void remove(final String aSection, final String aName) {
		if (data.containsKey(aSection)) {
			Map<String, String> map = data.get(aSection);
			map.remove(aName);
		}
	}

	@Override
	public void remove(final String aSection) {
		data.remove(aSection);
	}

}
