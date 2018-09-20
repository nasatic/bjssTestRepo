package Utility;

public class PayLoad {

    public String putPayLoad(){
        String put = "{\"name\": \"morpheus\",\"job\": \"Glasgowegian\"}";
        return put;
    }

    public String patchPayLoad(){
        String patch = "{\"name\": \"IbeOkoro\",\"job\": \"zion resident\"}";
        return patch;
    }

    public String postRegSuccess(){
        String regSuccess = "{\"email\": \"sydney@fife\",\"password\": \"pistol\"}";
        return regSuccess;
    }

    public String postRegFailure(){
        String regFail = "{\"email\": \"sydney@fife\"}";
        return regFail;
    }

    public String postLoginSuccess(){
        String loginSuccess = "{\"email\": \"peter@klaven\",  \"password\": \"cityslicka\"}";
        return loginSuccess;
    }

    public String postLoginFailure(){
        String regFail = "{\"email\": \"peter@klaven\"}";
        return regFail;
    }

    public String postCreateUser(){
        String postCreate = "{\"name\": \"nasatic\",\"job\": \"leader\"}";
        return postCreate;
    }
}
