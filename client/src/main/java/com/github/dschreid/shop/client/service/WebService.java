package com.github.dschreid.shop.client.service;

import com.github.dschreid.shop.server.dto.request.LoginRequest;
import com.github.dschreid.shop.server.dto.request.RegisterRequest;
import com.github.dschreid.shop.server.dto.response.AuthResponse;
import com.github.dschreid.shop.server.dto.response.ItemInformationResponse;
import com.github.dschreid.shop.server.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

/**
 * The interface Web service.
 *
 * @author dschreid
 */
public interface WebService {
    /**
     * Ping call.
     *
     * @return the call
     */
    @GET("/services/ping")
    Call<Boolean> ping();

    /**
     * Login call.
     *
     * @param loginRequest the login request
     * @return the call
     */
    @POST("/services/auth/login")
    Call<AuthResponse> login(@Body LoginRequest loginRequest);

    /**
     * Logout call.
     *
     * @return the call
     */
    @POST("/services/auth/logout")
    Call<Boolean> logout();

    /**
     * Register call.
     *
     * @param registerRequest the register request
     * @return the call
     */
    @POST("/services/user/register")
    Call<Boolean> register(@Body RegisterRequest registerRequest);

    /**
     * Gets users.
     *
     * @return the users
     */
    @GET("/services/user/all")
    Call<List<User>> getUsers();

    /**
     * Add item call.
     *
     * @param item the item
     * @return the call
     */
    @POST("/services/item/add")
    Call<Boolean> addItem(@Body ItemInformationResponse item);

    /**
     * Gets item.
     *
     * @param item the item
     * @return the item
     */
    @GET("/services/item/{item}")
    Call<ItemInformationResponse> getItem(@Path("item") int item);

    /**
     * Gets items.
     *
     * @return the items
     */
    @GET("/services/item/all")
    Call<List<ItemInformationResponse>> getItems();
}
