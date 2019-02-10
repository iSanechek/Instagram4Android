package dev.niekirk.com.instagram4android.requests;

import dev.niekirk.com.instagram4android.requests.payload.UserInfoResult;

public class InstagramUserSelfInfoRequest extends InstagramGetRequest<UserInfoResult> {
    @Override
    public String getUrl() {
        return "accounts/current_user/";
    }

//    @Override
//    public String getPayload() {
//        Map<String, Object> infoMap = new LinkedHashMap<>();
//        infoMap.put("edit", true);
//
//        ObjectMapper mapper = new ObjectMapper();
//        String payloadJson = mapper.writeValueAsString(infoMap);
//        return  payloadJson;
//    }

    @Override
    public UserInfoResult parseResult(int resultCode, String content) {
        return parseJson(resultCode, content, UserInfoResult.class);
    }
}
