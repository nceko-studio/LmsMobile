package com.example.lmspoltekgo.api;

import com.example.lmspoltekgo.data.KursusData;
import com.example.lmspoltekgo.data.UserData;
import com.example.lmspoltekgo.response.LoginResponse;
import com.example.lmspoltekgo.response.SubmitResponse;
import com.example.lmspoltekgo.response.TugasResponse;
import com.example.lmspoltekgo.response.UploadResponse;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;

public interface ServerInterface {
    @GET("login/token.php")
    Call<LoginResponse> login(
            @Query("username") String username,
            @Query("password") String password,
            @Query("service") String service
    );

    @FormUrlEncoded
    @POST("webservice/rest/server.php")
    Call<List<UserData>> getUserData(
            @Field("wstoken") String token,
            @Field("wsfunction") String function,
            @Field("moodlewsrestformat") String format,
            @Field("values[0]") String value,
            @Field("field") String field
    );

    @FormUrlEncoded
    @POST("webservice/rest/server.php")
    Call<List<KursusData>> getKursus(
            @Field("wstoken") String token,
            @Field("wsfunction") String function,
            @Field("moodlewsrestformat") String format,
            @Field("userid") int userid
    );

    @FormUrlEncoded
    @POST("webservice/rest/server.php")
    Call<TugasResponse> getTugas(
            @Field("wstoken") String token,
            @Field("wsfunction") String function,
            @Field("moodlewsrestformat") String format,
            @Field("courseids[0]") int courseid
    );

    @Multipart
    @POST("webservice/upload.php")
    Call<List<UploadResponse>> uploadFile(
            @Part MultipartBody.Part file,
            @PartMap Map<String, RequestBody> params
    );

    @FormUrlEncoded
    @POST("webservice/rest/server.php")
    Call<List<SubmitResponse>> submitTugas(
            @Field("wstoken") String token,
            @Field("wsfunction") String function,
            @Field("moodlewsrestformat") String format,
            @Field("assignmentid") int assignmentid,
            @Field("plugindata[onlinetext_editor][text]") String texas,
            @Field("plugindata[onlinetext_editor][format]") int formatEditor,
            @Field("plugindata[onlinetext_editor][itemid]") int itemid,
            @Field("plugindata[files_filemanager]") int filesFilemanager
    );
}
