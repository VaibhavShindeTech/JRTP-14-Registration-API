package com.vaibhavshindetech.idgenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UserIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String prefix="AR";
		String suffix="";
		try {
			Connection connection = session.connection();
			Statement createStatement = connection.createStatement();
			String sql="select User_Id_SEQUENCE.nextVal from dual";
			ResultSet resultSet = createStatement.executeQuery(sql);
			if(resultSet.next()) {
				int seqNum = resultSet.getInt(1);
				suffix=String.valueOf(seqNum);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prefix+suffix;
	}

}
