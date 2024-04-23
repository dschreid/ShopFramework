package com.github.dschreid.shop.client;

import com.github.dschreid.shop.client.service.ConversationService;
import com.github.dschreid.shop.client.conversations.InitialConversation;
import com.github.dschreid.shop.client.service.ConversationServiceImpl;
import com.github.dschreid.shop.client.service.WebService;
import com.github.dschreid.shop.client.util.IO;
import lombok.Data;
import lombok.Getter;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

/**
 * Client application.
 *
 * @author dschreid
 */
@Data
public class ClientApplication {
    @Getter
    private static ClientApplication instance;
    private final Retrofit webClient;
    private final WebService webService;
    private final ConversationService conversationService;
    private final IO io;
    private String sessionToken;
    private Integer permissionLevel;

    /**
     * Instantiates a new Client application.
     *
     * @param webClient  the web client
     * @param webService the web service
     */
    public ClientApplication(Retrofit webClient, WebService webService) {
        ClientApplication.instance = this;
        this.webClient = webClient;
        this.webService = webService;
        this.io = new IO();
        this.conversationService = new ConversationServiceImpl();
    }

    /**
     * Start.
     *
     * @throws IOException the io exception
     */
    public void start() throws IOException {
        this.testConnection();
        conversationService.startConversation(new InitialConversation(this));
    }

    private void testConnection() throws IOException {
        final Response<Boolean> execute = webService.ping().execute();
        if (!execute.isSuccessful()) throw new IOException();
        if (Boolean.FALSE.equals(execute.body())) throw new IOException();
    }

    /**
     * Make call t.
     *
     * @param <T>  the type parameter
     * @param call the call
     * @return the t
     */
    public <T> T makeCall(Call<T> call) {
        try {
            final Response<T> execute = call.execute();
            if (!execute.isSuccessful()) {
                io.gebeAus("Error During Call: [Status: %s], [Message: %s]%n", execute.code(), execute.errorBody().string());
                return null;
            }
            return execute.body();
        } catch (Exception exception) {
            return null;
        }
    }
}
