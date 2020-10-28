package com.hecy.sourceBorn.mybatis.bean;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: hecy
 * @Date: 2019/10/17 16:23
 * @Version 1.0
 */
@MappedTypes(Integer.class)
@MappedJdbcTypes(JdbcType.INTEGER)
public class MyIntegerTypeHandleTestCase implements TypeHandler<Integer> {
    @Override
    public void setParameter(PreparedStatement ps, int i, Integer parameter, JdbcType jdbcType) throws SQLException {
        System.out.println("my MyIntegerTypeHandleTestCase setParameter: " + parameter);

        ps.setInt(i,parameter);
    }

    @Override
    public Integer getResult(ResultSet rs, String columnName) throws SQLException {
        System.out.println("my MyIntegerTypeHandleTestCase getResult: " + columnName);

        return rs.getInt(columnName);
    }

    @Override
    public Integer getResult(ResultSet rs, int columnIndex) throws SQLException {
        System.out.println("my MyIntegerTypeHandleTestCase getResult: " + columnIndex);
        return rs.getInt(columnIndex);
    }

    @Override
    public Integer getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
