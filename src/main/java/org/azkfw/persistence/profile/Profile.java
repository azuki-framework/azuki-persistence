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

/**
 * このインターフェースは、プロファイルを保持する機能を定義したインターフェースです。
 * 
 * @since 1.2.0
 * @version 1.2.0 2014/07/07
 * @author Kawakicchi
 */
public interface Profile {

	/**
	 * プロファイルから値を読み込む。
	 * 
	 * @param section セクション
	 * @param name 名前
	 * @param def デフォルト値
	 * @return 値
	 */
	public String get(final String section, final String name, final String def);

	/**
	 * プロファイルから値を読み込む。
	 * 
	 * @param section セクション
	 * @param name 名前
	 * @param def デフォルト値
	 * @return 値
	 */
	public Integer get(final String section, final String name, final Integer def);

	/**
	 * プロファイルから値を読み込む。
	 * 
	 * @param section セクション
	 * @param name 名前
	 * @param def デフォルト値
	 * @return 値
	 */
	public Long get(final String section, final String name, final Long def);

	/**
	 * プロファイルから値を読み込む。
	 * 
	 * @param section セクション
	 * @param name 名前
	 * @param default デフォルト値
	 * @return 値
	 */
	public Float get(final String section, final String name, final Float def);

	/**
	 * プロファイルから値を読み込む。
	 * 
	 * @param section セクション
	 * @param name 名前
	 * @param default デフォルト値
	 * @return 値
	 */
	public Double get(final String section, final String name, final Double def);

	/**
	 * プロファイルから値を読み込む。
	 * 
	 * @param section セクション
	 * @param name 名前
	 * @param def デフォルト値
	 * @return 値
	 */
	public Boolean get(final String section, final String name, final Boolean def);

	/**
	 * プロファイルに値を書き出す。
	 * 
	 * @param section セクション
	 * @param name 名前
	 * @param value 値
	 */
	public void put(final String section, final String name, final String value);

	/**
	 * プロファイルに値を書き出す。
	 * 
	 * @param section セクション
	 * @param name 名前
	 * @param value 値
	 */
	public void put(final String section, final String name, final Integer value);

	/**
	 * プロファイルに値を書き出す。
	 * 
	 * @param section セクション
	 * @param name 名前
	 * @param value 値
	 */
	public void put(final String section, final String name, final Long value);

	/**
	 * プロファイルに値を書き出す。
	 * 
	 * @param section セクション
	 * @param name 名前
	 * @param value 値
	 */
	public void put(final String section, final String name, final Float value);

	/**
	 * プロファイルに値を書き出す。
	 * 
	 * @param section セクション
	 * @param name 名前
	 * @param value 値
	 */
	public void put(final String section, final String name, final Double value);

	/**
	 * プロファイルに値を書き出す。
	 * 
	 * @param section セクション
	 * @param name 名前
	 * @param value 値
	 */
	public void put(final String section, final String name, final Boolean value);

	/**
	 * プロファイルから値を削除する。
	 * 
	 * @param section セクション
	 * @param name 名前
	 */
	public void remove(final String section, final String name);

	/**
	 * プロファイルからセクションを削除する。
	 * 
	 * @param section セクション
	 */
	public void remove(final String section);
}
