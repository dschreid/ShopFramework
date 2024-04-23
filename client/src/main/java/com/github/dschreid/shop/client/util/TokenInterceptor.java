package com.github.dschreid.shop.client.util;

import com.github.dschreid.shop.client.ClientApplication;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;


/**
 * Model for Token interceptor.
 *
 * @author dschreid
 */
public class TokenInterceptor implements Interceptor {
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        final ClientApplication application = ClientApplication.getInstance();
        if (application == null) return chain.proceed(chain.request());
        final String sessionToken = application.getSessionToken() == null ? "" : application.getSessionToken();
        final Request request = chain.request().newBuilder().addHeader("session-token", sessionToken).build();
        return chain.proceed(request);
    }
}
