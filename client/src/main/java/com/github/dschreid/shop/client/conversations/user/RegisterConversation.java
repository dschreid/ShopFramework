package com.github.dschreid.shop.client.conversations.user;

import com.github.dschreid.shop.client.ClientApplication;
import com.github.dschreid.shop.client.conversations.AbstractClientConversation;
import com.github.dschreid.shop.client.conversations.InitialConversation;
import com.github.dschreid.shop.client.model.Conversation;
import com.github.dschreid.shop.server.dto.request.RegisterRequest;

/**
 * Model for Register conversation.
 */
public class RegisterConversation extends AbstractClientConversation {

    /**
     * Instantiates a new Register conversation.
     *
     * @param application      the application
     * @param lastConversation the last conversation
     */
    public RegisterConversation(ClientApplication application, Conversation lastConversation) {
        super(application, lastConversation);
    }

    @Override
    public Conversation make() {
        final String username = io.leseString("Username: ");
        final String password = io.leseString("Password: ");
        final String email = io.leseString("Email: ");
        application.makeCall(webService.register(new RegisterRequest(username, password, email)));

        return new InitialConversation(application);
    }
}
