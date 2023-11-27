package com.example.software.RowMapper;

import com.example.software.Entity.Guides;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GuidesRowMapper implements RowMapper<Guides>{

    @Override
    public Guides mapRow(ResultSet rs, int rowNum) throws SQLException {

        Guides obj = new Guides();

        obj.setGuideUsersID(rs.getInt("guideUsersID"));
        obj.setFirstName(rs.getString("firstName"));
        obj.setLastName(rs.getString("lastName"));
        obj.setEmail(rs.getString("email"));
        obj.setPhoneNumber(rs.getInt("phoneNumber"));
        obj.setGuide_Picture(rs.getString("Guide_Picture"));

        return obj;
    }
}
