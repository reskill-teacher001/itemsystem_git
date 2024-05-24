package db.bean;

import java.io.Serializable;

public class Item implements Serializable {
	//フィールド
	private int code;            //コード
	private int categoryCode;    //カテゴリ・コード
	private String name;         //商品名
	private int price;           //単価
	
	//コンストラクタ
	public Item() {

	}

	public Item(int code, int categoryCode, String name, int price) {
		this.code = code;
		this.categoryCode = categoryCode;
		this.name = name;
		this.price = price;
	}

	//セッタ＆ゲッタ
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}	
}
