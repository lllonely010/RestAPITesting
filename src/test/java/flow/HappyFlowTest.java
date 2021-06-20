package flow;

import base.BaseTest;
import funs.PostsFun;
import objects.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import funs.*;
import java.util.List;
import java.util.Arrays;

@RunWith(JUnitPlatform.class)
public class HappyFlowTest extends BaseTest {

    public int userId;
    public List<Post> postslist;
    public List<Comment> commentslist;

    @BeforeEach public void
    start() {
        LOGGER.info("Start to run a happy flow");
        userId = UserFun.getUserIDByName("Delphine", USERURL);
        postslist =  Arrays.asList(PostsFun.getPostsByUserID(userId,POSTSURL).getBody().as(Post[].class));
    }
    @Test public void
    testSearchPostSucceedFromValidUserName() {
        LOGGER.info("Test Search post by userId and check all posts");
        if(postslist.size() > 0) {
            postslist.forEach(post -> Assertions.assertEquals(post.getUserId(), userId));
            Assertions.assertEquals(10, postslist.size());
        }else{
            Assertions.fail("Post not found when username = Delphine" );
        }

    }

    @Test public void
    testCheckCommentsMailFormat() {
        LOGGER.info("Test Search comments by postId and check all mail address format");
        postslist.forEach(post -> {
            int postId = post.getId();
            commentslist = Arrays.asList(CommentsFun.getCommentByPostID(postId,COMMENTURL).getBody().as(Comment[].class));
            commentslist.forEach(comment -> Assertions.assertTrue(comment.getEmail().matches("^(.+)@(.+)$")));
        });
    }

}
