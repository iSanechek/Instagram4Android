package dev.niekirk.com.instagram4android.requests;

import dev.niekirk.com.instagram4android.requests.payload.UserInfoResult;

public class InstagramUserSelfInfoRequest extends InstagramGetRequest<UserInfoResult> {
    @Override
    public String getUrl() {
        return "accounts/current_user/";
    }

    @Override
    public UserInfoResult parseResult(int resultCode, String content) {
        return parseJson(resultCode, content, UserInfoResult.class);
    }
}
