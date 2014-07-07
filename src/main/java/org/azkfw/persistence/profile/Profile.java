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
	 * @param aSection セクション
	 * @param aName 名前
	 * @param aDefault デフォルト値
	 * @return 値
	 */
	public String get(final String aSection, final String aName, final String aDefault);

	/**
	 * プロファイルから値を読み込む。
	 * 
	 * @param aSection セクション
	 * @param aName 名前
	 * @param aDefault デフォルト値
	 * @return 値
	 */
	public Integer get(final String aSection, final String aName, final Integer aDefault);

	/**
	 * プロファイルから値を読み込む。
	 * 
	 * @param aSection セクション
	 * @param aName 名前
	 * @param aDefault デフォルト値
	 * @return 値
	 */
	public Long get(final String aSection, final String aName, final Long aDefault);

	/**
	 * プロファイルから値を読み込む。
	 * 
	 * @param aSection セクション
	 * @param aName 名前
	 * @param aDefault デフォルト値
	 * @return 値
	 */
	public Float get(final String aSection, final String aName, final Float aDefault);

	/**
	 * プロファイルから値を読み込む。
	 * 
	 * @param aSection セクション
	 * @param aName 名前
	 * @param aDefault デフォルト値
	 * @return 値
	 */
	public Double get(final String aSection, final String aName, final Double aDefault);

	/**
	 * プロファイルから値を読み込む。
	 * 
	 * @param aSection セクション
	 * @param aName 名前
	 * @param aDefault デフォルト値
	 * @return 値
	 */
	public Boolean get(final String aSection, final String aName, final Boolean aDefault);

	/**
	 * プロファイルに値を書き出す。
	 * 
	 * @param aSection セクション
	 * @param aName 名前
	 * @param aValue 値
	 */
	public void put(final String aSection, final String aName, final String aValue);

	/**
	 * プロファイルに値を書き出す。
	 * 
	 * @param aSection セクション
	 * @param aName 名前
	 * @param aValue 値
	 */
	public void put(final String aSection, final String aName, final Integer aValue);

	/**
	 * プロファイルに値を書き出す。
	 * 
	 * @param aSection セクション
	 * @param aName 名前
	 * @param aValue 値
	 */
	public void put(final String aSection, final String aName, final Long aValue);

	/**
	 * プロファイルに値を書き出す。
	 * 
	 * @param aSection セクション
	 * @param aName 名前
	 * @param aValue 値
	 */
	public void put(final String aSection, final String aName, final Float aValue);

	/**
	 * プロファイルに値を書き出す。
	 * 
	 * @param aSection セクション
	 * @param aName 名前
	 * @param aValue 値
	 */
	public void put(final String aSection, final String aName, final Double aValue);

	/**
	 * プロファイルに値を書き出す。
	 * 
	 * @param aSection セクション
	 * @param aName 名前
	 * @param aValue 値
	 */
	public void put(final String aSection, final String aName, final Boolean aValue);

	/**
	 * プロファイルから値を削除する。
	 * 
	 * @param aSection セクション
	 * @param aName 名前
	 */
	public void remove(final String aSection, final String aName);

	/**
	 * プロファイルからセクションを削除する。
	 * 
	 * @param aSection セクション
	 */
	public void remove(final String aSection);
}
