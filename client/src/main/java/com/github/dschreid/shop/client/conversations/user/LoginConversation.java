package com.github.dschreid.shop.client.conversations.user;

import com.github.dschreid.shop.client.ClientApplication;
import com.github.dschreid.shop.client.conversations.AbstractClientConversation;
import com.github.dschreid.shop.client.conversations.ChoosingActionConversation;
import com.github.dschreid.shop.client.conversations.InitialConversation;
import com.github.dschreid.shop.client.model.Conversation;
import com.github.dschreid.shop.server.dto.request.LoginRequest;
import com.github.dschreid.shop.server.dto.response.AuthResponse;

/**
 * Model for Login conversation.
 */
public class LoginConversation extends AbstractClientConversation {

    /**
     * Instantiates a new Login conversation.
     *
     * @param application      the application
     * @param lastConversation the last conversation
     */
    public LoginConversation(ClientApplication application, Conversation lastConversation) {
        super(application, lastConversation);
    }

    @Override
    public Conversation make() {
        final String username = io.leseString("Username: ");
        final String password = io.leseString("Password: ");
        final AuthResponse authResponse = application.makeCall(webService.login(new LoginRequest(username, password)));

        if (authResponse == null) return new InitialConversation(application);

        io.gebeLineAus("Login Success (Level: %s, Token: %s)", authResponse.getUserInformation().getPermissionLevel(), authResponse.getToken());
        application.setSessionToken(authResponse.getToken());
        application.setPermissionLevel(authResponse.getUserInformation().getPermissionLevel());
        return new ChoosingActionConversation(application);
    }
}
