package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.AccountBean;

@Repository
public class AccountDao {

	@Autowired
	JdbcTemplate pstmt;

	public void addAccount(AccountBean accountBean) {
		pstmt.update("insert into accounts (account_type,account_balance,upi_id,card_number,userid) values (?,?,?,?,?)",
				accountBean.getAccount_type(), accountBean.getAccount_balance(), accountBean.getUpi_id(),
				accountBean.getCard_number(), accountBean.getUserId());
		if (accountBean.getAccount_type().contains("paytm")) {
			pstmt.update("insert into paytm (userid,account_type,account_balance,upi_id) values(?,?,?,?)",
					accountBean.getUserId(), accountBean.getAccount_type(), accountBean.getAccount_balance(),
					accountBean.getUpi_id());
		} else if (accountBean.getAccount_type().contains("cash")) {
			pstmt.update("insert into cash (userid,account_type,account_balance) values(?,?,?)",
					accountBean.getUserId(), accountBean.getAccount_type(), accountBean.getAccount_balance());
		} else if (accountBean.getAccount_type().contains("card")) {
			pstmt.update("insert into card (userid,account_type,account_balance,card_number) values(?,?,?,?)",
					accountBean.getUserId(), accountBean.getAccount_type(), accountBean.getAccount_balance(),
					accountBean.getCard_number());
		}
		/*
		 * pstmt.
		 * update("insert into accounts (account_type,account_balance,upi_id,card_number,userid) values (?,?,?,?,?)"
		 * , accountBean.getAccount_type(), accountBean.getAccount_balance(),
		 * accountBean.getUpi_id(), accountBean.getCard_number(),
		 * accountBean.getUserId());
		 */
	}

	public ArrayList<List<AccountBean>> getAllAccountsByUserId(int userId) {

		List<AccountBean> account = pstmt.query("select * from paytm where userid=?",
				new BeanPropertyRowMapper<AccountBean>(AccountBean.class), userId);
		List<AccountBean> account1 = pstmt.query("select * from cash where userid=?",
				new BeanPropertyRowMapper<AccountBean>(AccountBean.class), userId);
		List<AccountBean> account2 = pstmt.query("select * from card where userid=?",
				new BeanPropertyRowMapper<AccountBean>(AccountBean.class), userId);
		ArrayList<List<AccountBean>> arr = new ArrayList<>();
		arr.add(account);
		arr.add(account1);
		arr.add(account2);
		return arr;

	}
}