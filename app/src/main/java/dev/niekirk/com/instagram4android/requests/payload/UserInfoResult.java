package dev.niekirk.com.instagram4android.requests.payload;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by isanechek on 10/02/19.
 */

@Getter
@Setter
@ToString(callSuper = true)
public class UserInfoResult {
    private Object megaphone;
    private InstagramUser user;
}
