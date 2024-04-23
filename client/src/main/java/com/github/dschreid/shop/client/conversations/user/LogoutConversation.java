package com.github.dschreid.shop.client.conversations.user;

import com.github.dschreid.shop.client.ClientApplication;
import com.github.dschreid.shop.client.conversations.AbstractClientConversation;
import com.github.dschreid.shop.client.conversations.InitialConversation;
import com.github.dschreid.shop.client.model.Conversation;

/**
 * Model for Logout conversation.
 */
public class LogoutConversation extends AbstractClientConversation {

    /**
     * Instantiates a new Logout conversation.
     *
     * @param application      the application
     * @param lastConversation the last conversation
     */
    public LogoutConversation(ClientApplication application, Conversation lastConversation) {
        super(application, lastConversation);
    }

    @Override
    public Conversation make() {
        application.makeCall(webService.logout());

        application.setSessionToken(null);
        application.setPermissionLevel(0);
        return new InitialConversation(application);
    }
}
