package db.model;

import javax.servlet.http.HttpServletRequest;

import db.bean.Item;
import db.dao.DAOException;
import db.dao.ItemDAO;

public class ItemDeleteExecBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {
		//リクエスト・パラメータを取得
		int code = Integer.parseInt(request.getParameter("code"));
		
		//UserDAOのインスタンスを生成
		ItemDAO dao = new ItemDAO();
		
		Item item = dao.findByCode(code);
		
		if (item == null) {
			throw new DAOException("指定したコードのアイテムが見つかりません");
		}
		
		boolean check = dao.delete(code);
		
		if (check == false) {
			throw new DAOException("削除に失敗しました");
		}
		
		return "/control?action=list";

//		List<User> list = dao.findAll();
//		
//		//リクエストスコープに記憶させる
//		request.setAttribute("list", list);
//		
//		return "/db/user_list.jsp"; //表示するページを返す
	}

}
