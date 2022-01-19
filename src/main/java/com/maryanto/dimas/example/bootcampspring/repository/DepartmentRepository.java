package com.maryanto.dimas.example.bootcampspring.repository;

import com.maryanto.dimas.example.bootcampspring.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@Repository
public class DepartmentRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    public List<Department> list() {
        return this.namedJdbcTemplate.query(
                "select * from department",
                new RowMapper<Department>() {
                    @Override
                    public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Department(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3));
                    }
                });
    }
}
