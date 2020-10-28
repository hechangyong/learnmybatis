package com.hecy.sourceBorn.mybatis.bean;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: hecy
 * @Date: 2019/10/17 11:30
 * @Version 1.0
 */
@MappedTypes(String.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class MyAnTypeHandleTestCase implements TypeHandler<String> {

    @Override
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        System.out.println("my MyAnTypeHandleTestCase setParameter" + parameter);
        ps.setString(i,parameter);
    }

    @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {
        System.out.println("my MyAnTypeHandleTestCase getResult： " + columnName);

        return rs.getString(columnName);
    }

    @Override
    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        System.out.println("my MyAnTypeHandleTestCase getResult： " + columnIndex);

        return rs.getString(columnIndex);
    }

    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        System.out.println("my MyAnTypeHandleTestCase getResult： " + columnIndex);
        return null;
    }
}
