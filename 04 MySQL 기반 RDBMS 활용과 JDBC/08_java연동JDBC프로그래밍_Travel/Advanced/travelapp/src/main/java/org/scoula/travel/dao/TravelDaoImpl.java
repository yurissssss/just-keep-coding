package org.scoula.travel.dao;

import org.scoula.database.JDBCUtil;
import org.scoula.travel.domain.TravelImageVO;
import org.scoula.travel.domain.TravelVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TravelDaoImpl implements TravelDao {
    Connection conn = JDBCUtil.getConnection();

    // TravelVO 테이블에 저장
    @Override
    public void insert(TravelVO travel) {
        String sql = "insert into tbl_travel(no, district, title, description, address, phone) values(?,?,?,?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, travel.getNo());
            pstmt.setString(2, travel.getDistrict());
            pstmt.setString(3, travel.getTitle());
            pstmt.setString(4, travel.getDescription());
            pstmt.setString(5, travel.getAddress());
            pstmt.setString(6, travel.getPhone());

            int count = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // TraveImagelVO 테이블에 저장
    @Override
    public void insertImage(TravelImageVO image) {
        String sql = "insert into tbl_travel_image(filename, travel_no) values(?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, image.getFilename());
            pstmt.setLong(2, image.getTravelNo());

            int count = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 전체 데이터 건수 얻기
    @Override
    public int getTotalCount() {
        String sql = "select count(*) from tbl_travel";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 권역 목록 얻기
    @Override
    public List<String> getDistricts() {
        List<String> districts = new ArrayList<>();
        String sql = "select distinct(district) from tbl_travel order by district";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                districts.add(rs.getString("district"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return districts;
    }

    private TravelVO map(ResultSet rs) throws SQLException {
        return TravelVO.builder()
                .no(rs.getLong("no"))
                .district(rs.getString("district"))
                .title(rs.getString("title"))
                .description(rs.getString("description"))
                .address(rs.getString("address"))
                .phone(rs.getString("phone"))
                .build();
    }

    // 목록 얻기
    @Override
    public List<TravelVO> getTravels() {
        List<TravelVO> travels = new ArrayList<>();
        String sql = "select * from tbl_travel order by district, title";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                TravelVO travel = map(rs);
                travels.add(travel);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return travels;
    }

    // 페이지별 목록 얻기
    @Override
    public List<TravelVO> getTravels(int page) {
        List<TravelVO> travels = new ArrayList<>();
        String sql = "select * from tbl_travel order by district, title limit ?,?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int count = 10;
            int start = (page - 1) * count;
            pstmt.setInt(1, start);
            pstmt.setInt(2, count);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return travels;
    }

    // 해당 권역의 목록 얻기
    @Override
    public List<TravelVO> getTravels(String district) {
        List<TravelVO> travels = new ArrayList<>();
        String sql = "select * from tbl_travel where district = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, district);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    TravelVO travel = map(rs);
                    travels.add(travel);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return travels;
    }

    private TravelImageVO mapImage(ResultSet rs) throws SQLException {
        return TravelImageVO.builder()
                .no(rs.getLong("tino"))
                .filename(rs.getString("filename"))
                .travelNo(rs.getLong("travel_no"))
                .build();
    }

    // 특정 관광지 정보 얻기
    @Override
    public Optional<TravelVO> getTravel(Long no) {
        TravelVO travel = null;
        String sql = """
                select t.*, ti.no as tino, ti.filename, ti.travel_no
                from tbl_travel t
                    inner join tbl_travel_image ti
                        on t.no = ti.travel_no
                where t.no = ?;
                """;
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, no);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    travel = map(rs);
                    List<TravelImageVO> images = new ArrayList<>();
                    try {
                        do {
                            TravelImageVO image = mapImage(rs);
                            images.add(image);
                        } while (rs.next());
                    } catch (SQLException e) {
                        // 이미지가 없는 경우 발생
                        // -> 무시
                    }
                    travel.setImages(images);
                    return Optional.of(travel);
                } else {
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
