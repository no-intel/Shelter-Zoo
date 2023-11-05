package com.noint.shelterzoo.service.abandoned;

import com.noint.shelterzoo.domain.abandoned.dto.req.AbandonedListRequestDTO;
import com.noint.shelterzoo.domain.abandoned.repository.AbandonedRepository;
import com.noint.shelterzoo.domain.abandoned.service.AbandonedService;
import com.noint.shelterzoo.domain.abandoned.vo.req.AbandonedListRequestVO;
import com.noint.shelterzoo.domain.abandoned.vo.res.AbandonedListResponseVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest(classes = {AbandonedService.class})
public class AbandonedServiceUnitTest {
    @Autowired
    AbandonedService abandonedService;

    @MockBean
    AbandonedRepository abandonedRepository;

    @Test
    @DisplayName("유기동물 리스트")
    void getAbandonedList(){
        // given
        long userSeq = 17;
        AbandonedListRequestDTO request = new AbandonedListRequestDTO();
        request.setLocation("서울");
        request.setKind("전체");
        request.setGender("전체");
        request.setNeuter("중성화");

        AbandonedListResponseVO hopeValue = new AbandonedListResponseVO();
        hopeValue.setSeq(955);
        hopeValue.setThumbnail("http://www.animal.go.kr/files/shelter/2023/07/202310131510115_s.jpg");
        hopeValue.setKind("고양이");
        hopeValue.setKindDetail("스코티시폴드");
        hopeValue.setBirth("2018(년생)");
        hopeValue.setGender("M");
        hopeValue.setNeuter("Y");
        hopeValue.setNoticeEnd("2023-10-23 00:00:00");
        hopeValue.setPin(true);

        List<AbandonedListResponseVO> hopeValueList = new ArrayList<>();
        hopeValueList.add(hopeValue);

        // when
        when(abandonedRepository.getAbandonedList(AbandonedListRequestVO.create(userSeq, request))).thenReturn(hopeValueList);

        // then
        abandonedService.getAbandonedList(userSeq, request);
    }
}
