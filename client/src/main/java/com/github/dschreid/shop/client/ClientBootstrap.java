package com.github.dschreid.shop.client;

import com.github.dschreid.shop.client.service.WebService;
import com.github.dschreid.shop.client.util.TokenInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;


/**
 * Launches the application
 *
 * @author dschreid
 */
public class ClientBootstrap {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {
        final OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(new TokenInterceptor()).build();

        Retrofit client = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();

        final WebService webService = client.create(WebService.class);
        new ClientApplication(client, webService).start();
    }
}
