package com.example.moim.auth.acceptance;

import com.example.moim.AcceptanceTest;
import com.example.moim.auth.dto.TokenRequest;
import com.example.moim.member.domain.Gender;
import com.example.moim.member.dto.ParticipantRequest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.time.LocalDate;
import java.util.List;

import static com.example.moim.member.acceptance.MemberAcceptanceTest.참여자_회원가입_요청;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class AuthAcceptanceTest extends AcceptanceTest {

    /**
     * GIVEN 아이디와 비밀번호가 유효하고
     * WHEN 로그인을 요청하면
     * THEN 토큰을 반환한다
     */
    @Test
    void 로그인_성공() {
        ParticipantRequest request = new ParticipantRequest(
                "참여자", LocalDate.now(), Gender.MALE, "test-id",
                "test-password", "weno@next.com", List.of("후추", "돼지고기"), "안녕하세요"
        );
        참여자_회원가입_요청(request);

        String memberId = "test-id";
        String password = "test-password";
        TokenRequest tokenRequest = new TokenRequest(memberId, password);

        ExtractableResponse<Response> response = 토큰_요청(tokenRequest);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getString("accessToken")).isNotBlank();
    }

    public static ExtractableResponse<Response> 토큰_요청(TokenRequest tokenRequest) {
        ExtractableResponse<Response> response = given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(tokenRequest)
                .when().post("/login/token")
                .then().log().all()
                .extract();
        return response;
    }
}
