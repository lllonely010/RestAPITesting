package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import support.PropertyManager;

public abstract class Base {

    protected static final String POSTSURL = PropertyManager.getInstance().getPostsUri();
    protected static final String USERURL = PropertyManager.getInstance().getUsersUri();
    protected static final String COMMENTURL = PropertyManager.getInstance().getCommentsUri();

    public static RequestSpecification requestSpec = new RequestSpecBuilder()
            .addHeader("Content-Type", "application/json")
            .build();

}
