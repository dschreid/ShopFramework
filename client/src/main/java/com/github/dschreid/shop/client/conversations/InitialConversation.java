package com.github.dschreid.shop.client.conversations;

import com.github.dschreid.shop.client.ClientApplication;
import com.github.dschreid.shop.client.conversations.user.LoginConversation;
import com.github.dschreid.shop.client.conversations.user.RegisterConversation;

/**
 * Model for Initial conversation.
 *
 * @author dschreid
 */
public class InitialConversation extends ChoosingConversation {
    /**
     * Instantiates a new Initial conversation.
     *
     * @param application the application
     */
    public InitialConversation(ClientApplication application) {
        super(application, null);

        this.addChoice(new LoginConversation(application, this));
        this.addChoice(new RegisterConversation(application, this));
    }
}
