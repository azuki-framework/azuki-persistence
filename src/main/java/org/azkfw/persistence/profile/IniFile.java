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
	 * @param file iniファイル
	 * @throws IOException IO操作に起因する問題が発生した場合
	 */
	public void read(final String file) throws IOException {
		read(file, System.getProperty("file.encoding"));
	}

	/**
	 * iniファイルを読み込む。
	 * 
	 * @param file iniファイル
	 * @throws IOException IO操作に起因する問題が発生した場合
	 */
	public void read(final File file) throws IOException {
		read(file, System.getProperty("file.encoding"));
	}

	/**
	 * iniファイルを読み込む。
	 * 
	 * @param file iniファイル
	 * @param charset 文字コード
	 * @throws IOException IO操作に起因する問題が発生した場合
	 */
	public void read(final String file, final String charset) throws IOException {
		read(file, Charset.forName(charset));
	}

	/**
	 * iniファイルを読み込む。
	 * 
	 * @param file iniファイル
	 * @param charset 文字コード
	 * @throws IOException IO操作に起因する問題が発生した場合
	 */
	public void read(final File file, final String charset) throws IOException {
		read(file, Charset.forName(charset));
	}

	/**
	 * iniファイルを読み込む。
	 * 
	 * @param file iniファイル
	 * @param charset 文字コード
	 * @throws IOException IO操作に起因する問題が発生した場合
	 */
	public void read(final String file, final Charset charset) throws IOException {
		read(new File(file), charset);
	}

	/**
	 * iniファイルを読み込む。
	 * 
	 * @param file iniファイル
	 * @param charset 文字コード
	 * @throws IOException IO操作に起因する問題が発生した場合
	 */
	public void read(final File file, final Charset charset) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));

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
	 * @param file iniファイル
	 * @throws IOException IO操作に起因する問題が発生した場合
	 */
	public void write(final String file) throws IOException {
		write(file, System.getProperty("file.encoding"));
	}

	/**
	 * iniファイルに書き出す。
	 * 
	 * @param file iniファイル
	 * @throws IOException IO操作に起因する問題が発生した場合
	 */
	public void write(final File file) throws IOException {
		write(file, System.getProperty("file.encoding"));
	}

	/**
	 * iniファイルに書き出す。
	 * 
	 * @param file iniファイル
	 * @param charset 文字コード
	 * @throws IOException IO操作に起因する問題が発生した場合
	 */
	public void write(final String file, final String charset) throws IOException {
		write(file, Charset.forName(charset));
	}

	/**
	 * iniファイルに書き出す。
	 * 
	 * @param file iniファイル
	 * @param charset 文字コード
	 * @throws IOException IO操作に起因する問題が発生した場合
	 */
	public void write(final File file, final String charset) throws IOException {
		write(file, Charset.forName(charset));
	}

	/**
	 * iniファイルに書き出す。
	 * 
	 * @param file iniファイル
	 * @param charset 文字コード
	 * @throws IOException IO操作に起因する問題が発生した場合
	 */
	public void write(final String file, final Charset charset) throws IOException {
		write(new File(file), charset);
	}

	/**
	 * iniファイルに書き出す。
	 * 
	 * @param file iniファイル
	 * @param charset 文字コード
	 * @throws IOException IO操作に起因する問題が発生した場合
	 */
	public void write(final File file, final Charset charset) throws IOException {
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

			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
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
	public String get(final String section, final String name, final String def) {
		String value = def;
		if (data.containsKey(section)) {
			Map<String, String> map = data.get(section);
			if (map.containsKey(name)) {
				value = map.get(name);
			}
		}
		return value;
	}

	@Override
	public Integer get(final String section, final String name, final Integer def) {
		Integer value = def;
		String s = get(section, name, (String) null);
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
	public Long get(final String section, final String name, final Long def) {
		Long value = def;
		String s = get(section, name, (String) null);
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
	public Float get(final String section, final String name, final Float def) {
		Float value = def;
		String s = get(section, name, (String) null);
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
	public Double get(final String section, final String name, final Double def) {
		Double value = def;
		String s = get(section, name, (String) null);
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
	public Boolean get(final String section, final String name, final Boolean def) {
		Boolean value = def;
		String s = get(section, name, (String) null);
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
	public void put(final String section, final String name, final String value) {
		String bufSection = StringUtility.trim(section);
		String bufName = StringUtility.trim(name);
		String bufValue = StringUtility.trim(value);

		Map<String, String> map = null;
		if (data.containsKey(bufSection)) {
			map = data.get(bufSection);
		} else {
			map = new HashMap<String, String>();
			data.put(bufSection, map);
		}
		map.put(bufName, bufValue);
	}

	@Override
	public void put(final String section, final String name, final Integer value) {
		put(section, name, Integer.toString(value));
	}

	@Override
	public void put(final String section, final String name, final Long value) {
		put(section, name, Long.toString(value));
	}

	@Override
	public void put(final String section, final String name, final Float value) {
		put(section, name, Float.toString(value));
	}

	@Override
	public void put(final String section, final String name, final Double value) {
		put(section, name, Double.toString(value));
	}

	@Override
	public void put(final String section, final String name, final Boolean value) {
		put(section, name, ((value) ? "true" : "false"));
	}

	@Override
	public void remove(final String section, final String name) {
		if (data.containsKey(section)) {
			Map<String, String> map = data.get(section);
			map.remove(name);
		}
	}

	@Override
	public void remove(final String section) {
		data.remove(section);
	}

}
