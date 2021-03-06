package ch19.Ex19_02;

import ch19.Ex19_02.LinkedList;

/**
 * <code>LinkedList</code> は先頭から末尾への一方向にリンクしているリストを定義する。
 * 課題2-16で作成したLinkedListクラスにドキュメンテーションコメントを追加する。
 * 
 * @author Harufumi Nakazato
 * @version 1.0
 */
public class LinkedList {
	//nextListへの変更は許されるべきではない。したがって、setter methodは追加されるべきではない。
	/** 本体オブジェクト */
	private Object object;
	/** 末尾方向1つ隣のオブジェクト*/
	private  LinkedList nextList;
	/**
	 * 
	 * @param object	本体オブジェクト
	 */
	public LinkedList(Object object){
		this.object = object;
	}
	/**
	 * 
	 * @param object 本体オブジェクト
	 * @param nextlist　次のオブジェクト
	 */
	public LinkedList(Object object, LinkedList nextlist){
		this.object = object;
		this.nextList = nextlist;
	}
	/**
	 * 再帰計算を用いているため製品実装には不適。
	 * @return リンクしているオブジェクトの数
	 */
	public int size(){
		if(nextList == null){
			return 1;
		}else{
			return 1 + nextList.size();
		}
	}
	/**
	 * @return 本体オブジェクトの値の文字列型
	 */
	public String toString(){
		return "object = " + object;
	}
	/**
	 * 本体オブジェクトを取得する。
	 * @see #setObject(Object)
	 * @return 本体オブジェクト
	 */
	public Object getObject(){
		return object;
	}
	/**
	 * @see #getObject()
	 * @param object 本体オブジェクトに設定する変数
	 */
	public void setObject(Object object){
		this.object = object;
	}
	public LinkedList getnextList(){
		return nextList;
	}
}