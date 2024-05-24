package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.bean.Item;

public class ItemDAO extends DAO {

	//単一検索メソッド（codeによる検索）
	public Item findByCode(int _code) throws DAOException {
		Item item = null;

		String sql = "SELECT code, category_code, name, price FROM item WHERE code = ?";

		try (
			//正常にDBに接続された時に利用できるリモコンcon
			//Connection con = DriverManager.getConnection(url, user, pass);
			Connection con = getConnect();
		) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);

			//プレースホルダの部分に値を設定する
			ps.setInt(1, _code);

			//SQLを実行して結果を取得する
			ResultSet rs = ps.executeQuery();

			if (rs.next() == true) { //レコードがあったら
				//レコードの列のデータを取得する
				int code = rs.getInt("code");                  //codeの列のデータを取得
				int categoryCode = rs.getInt("category_code"); //idの列のデータを取得
				String name = rs.getString("name");            //nameの列のデータを取得
				int price = rs.getInt("price");                //ageの列のデータを取得

				item = new Item(code, categoryCode, name, price);
			}

		} catch (Exception e) {
			throw new DAOException("データベース関連エラー");
			//System.out.println("データベース関連エラー");
			//e.printStackTrace();
		}

		return item;
	}
	
	//全件検索メソッド
	public List<Item> findAll() throws DAOException {
		List<Item> list = new ArrayList<>();

		String sql = "SELECT code, category_code, name, price FROM item";

		try (
			//正常にDBに接続された時に利用できるリモコンcon
			//Connection con = DriverManager.getConnection(url, user, pass);
			Connection con = getConnect();
		) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);

			//SQLを実行して結果を取得する
			ResultSet rs = ps.executeQuery();

			while (rs.next() == true) { //レコードがあったら
				//レコードの列のデータを取得する
				int code = rs.getInt("code");                  //codeの列のデータを取得
				int categoryCode = rs.getInt("category_code"); //idの列のデータを取得
				String name = rs.getString("name");            //nameの列のデータを取得
				int price = rs.getInt("price");                //ageの列のデータを取得
				
				list.add(new Item(code, categoryCode, name, price));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("データベース関連エラー");
		}

		return list;
	}
	
	//登録メソッド
	public boolean insert(int categoryCode, String name, int price) throws DAOException {
		boolean check = false;

		String sql = "INSERT INTO item(category_code, name, price) VALUES(?, ?, ?)";

		try (
			//正常にDBに接続された時に利用できるリモコンcon
			//Connection con = DriverManager.getConnection(url, user, pass);
			Connection con = getConnect();
		) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, categoryCode);
			ps.setString(2, name);
			ps.setInt(3, price);

			//SQLを実行して結果を取得する
			int row = ps.executeUpdate();
			
			if (row == 1) {
				check = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("データベース関連エラー");
		}

		return check;
	}
	
	//変更メソッド
	public boolean update(int code, int categoryCode, String name, int price) throws DAOException {
		boolean check = false;

		String sql = "UPDATE item SET category_code = ?, name = ?, price = ? WHERE code = ?";

		try (
			//正常にDBに接続された時に利用できるリモコンcon
			//Connection con = DriverManager.getConnection(url, user, pass);
			Connection con = getConnect();
		) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, categoryCode);
			ps.setString(2, name);
			ps.setInt(3, price);
			ps.setInt(4, code);

			//SQLを実行して結果を取得する
			int row = ps.executeUpdate();
			
			if (row == 1) {
				check = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("データベース関連エラー");
		}

		return check;
	}
	
	//削除メソッド
	public boolean delete(int code) throws DAOException {
		boolean check = false;

		String sql = "DELETE FROM item WHERE code = ?";

		try (
			//正常にDBに接続された時に利用できるリモコンcon
			//Connection con = DriverManager.getConnection(url, user, pass);
			Connection con = getConnect();
		) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, code);

			//SQLを実行して結果を取得する
			int row = ps.executeUpdate();
			
			if (row == 1) {
				check = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("データベース関連エラー");
		}

		return check;
	}

}
