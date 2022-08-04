package com.example.moim.auth.acceptance;

import com.example.moim.AcceptanceTest;
import com.example.moim.auth.dto.TokenRequest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

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
        String userId = "test-id";
        String password = "test-password";

        TokenRequest tokenRequest = new TokenRequest(userId, password);

        ExtractableResponse<Response> response = given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(tokenRequest)
                .when().post("/login/token")
                .then().log().all()
                .extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getString("accessToken")).isNotBlank();
    }
}
