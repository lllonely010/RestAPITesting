package func;

import static io.restassured.RestAssured.given;

import base.BaseFunc;
import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.api.Assertions;


import java.util.List;
import java.util.Map;

public class UserFunc extends BaseFunc {

    public static Integer getUserIDByName(String username, String url){
        int userId = 0;
        List<Map<String, Object>> user = given().param("username",username).expect().statusCode(200).when().get(url).as(new TypeRef<List<Map<String, Object>>>() {});
        if(user.size()>0) {
            LOGGER.info("Get userId by username = " + username);
            userId = (int) user.get(0).get("id");
        }else{
            Assertions.fail("User not found when username = " + username);
        }
        return userId;
    }

}
