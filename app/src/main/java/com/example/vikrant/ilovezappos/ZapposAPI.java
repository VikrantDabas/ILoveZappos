package com.example.vikrant.ilovezappos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Vikrant on 2/9/2017.
 */

public interface ZapposAPI {
    @GET("/Search?key=b743e26728e16b81da139182bb2094357c31d331")
    Call<OuterJson> getOuterJSON(@Query("term") String tags);
}
