package com.hecy.sourceBorn.mybatis.bean;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: hecy
 * @Date: 2019/10/17 10:40
 * @Version 1.0
 */
public class StringTypeHandleTestCase implements TypeHandler<String> {
    @Override
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        System.out.println("my StringTypeHandleTestCase" + parameter);
        ps.setString(i,parameter);
    }

    @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {
        System.out.println("my StringTypeHandleTestCase getResult： " + columnName);

        return rs.getString(columnName);
    }

    @Override
    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        System.out.println("my StringTypeHandleTestCase getResult： " + columnIndex);

        return rs.getString(columnIndex);
    }

    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        System.out.println("my StringTypeHandleTestCase getResult： " + columnIndex);
        return null;
    }
}
