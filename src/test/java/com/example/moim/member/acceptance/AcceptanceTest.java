package com.example.moim.member.acceptance;

import com.example.moim.utils.DatabaseCleanup;
import com.example.moim.member.domain.Gender;
import com.example.moim.member.dto.HostRequest;
import com.example.moim.member.dto.ParticipantRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.time.LocalDate;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AcceptanceTest {
    @LocalServerPort
    private int port;

    @Autowired
    private DatabaseCleanup databaseCleanup;

    @BeforeEach
    void setUp() {
        if (RestAssured.port == RestAssured.UNDEFINED_PORT) {
            RestAssured.port = port;
            databaseCleanup.afterPropertiesSet();
        }
        databaseCleanup.execute();
    }

    /**
     * WHEN 주최자가 회원정보를 요청하면
     * THEN 저장한다
     */
    @Test
    void 주최자_회원_가입() {
        HostRequest request = new HostRequest(
                "주최자", LocalDate.now(), Gender.MALE, "host",
                "password", "weno@next.com", "next"
        );

        ExtractableResponse<Response> response = given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when().post("/host")
                .then().log().all()
                .extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    /**
     * WHEN 참여자가 회원정보를 요청하면
     * THEN 저장한다
     */
    @Test
    void 참여자_회원_가입() {
        ParticipantRequest request = new ParticipantRequest(
                "참여자", LocalDate.now(), Gender.MALE, "participant",
                "password", "weno@next.com", List.of("후추", "돼지고기"), "안녕하세요"
        );

        ExtractableResponse<Response> response = given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when().post("/participant")
                .then().log().all()
                .extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }
}