package db.model;

import javax.servlet.http.HttpServletRequest;

import db.dao.DAOException;

public interface IBean {
	public String execute(HttpServletRequest request) throws DAOException;
}
