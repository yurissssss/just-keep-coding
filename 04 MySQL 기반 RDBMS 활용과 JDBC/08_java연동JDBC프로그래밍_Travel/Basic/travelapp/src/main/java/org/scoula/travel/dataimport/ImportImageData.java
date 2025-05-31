package org.scoula.travel.dataimport;

import org.scoula.database.JDBCUtil;
import org.scoula.travel.dao.TravelDao;
import org.scoula.travel.dao.TravelDaoImpl;
import org.scoula.travel.domain.TravelImageVO;

import java.io.File;

// TravelDao 이용하여 관광지 이미지 정보를 tbl_travel_image에 저장
public class ImportImageData {
    public static void main(String[] args) {
        TravelDao dao = new TravelDaoImpl();

        // 파일 경로가 "../travel-image"로 설정 시 오류 -> "travel-image"로
        File dir = new File("travel-image");
        File[] files = dir.listFiles();
        for (File file : files) {
            String filename = file.getName();
            long travelNo = Long.parseLong(filename.split("-")[0]);  // 관광지 no

            TravelImageVO image = TravelImageVO.builder()
                    .filename(filename)
                    .travelNo(travelNo)
                    .build();

            System.out.println(image);
            dao.insertImage(image);
        }
        JDBCUtil.close();
    }
}
