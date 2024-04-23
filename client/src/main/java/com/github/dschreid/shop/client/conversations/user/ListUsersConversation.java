package com.github.dschreid.shop.client.conversations.user;

import com.github.dschreid.shop.client.ClientApplication;
import com.github.dschreid.shop.client.conversations.AbstractClientConversation;
import com.github.dschreid.shop.client.model.Conversation;
import com.github.dschreid.shop.server.model.Role;
import com.github.dschreid.shop.server.model.User;

import java.util.List;

/**
 * Model for List users conversation.
 */
public class ListUsersConversation extends AbstractClientConversation {

    /**
     * Instantiates a new List users conversation.
     *
     * @param application      the application
     * @param lastConversation the last conversation
     */
    public ListUsersConversation(ClientApplication application, Conversation lastConversation) {
        super(application, lastConversation);
    }

    @Override
    public Conversation make() {
        if (!Role.ADMIN.is(application.getPermissionLevel())) {
            io.gebeLineAus("Not permitted");
            return lastConversation;
        }

        final List<User> userInformationResponses = application.makeCall(webService.getUsers());
        if (userInformationResponses == null) return lastConversation;

        for (User user : userInformationResponses) {
            io.gebeLineAus("%s", user);
        }
        return lastConversation;
    }
}
