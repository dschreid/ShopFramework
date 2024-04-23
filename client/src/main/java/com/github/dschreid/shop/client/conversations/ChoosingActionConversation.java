package com.github.dschreid.shop.client.conversations;

import com.github.dschreid.shop.client.ClientApplication;
import com.github.dschreid.shop.client.conversations.user.ListUsersConversation;
import com.github.dschreid.shop.client.conversations.user.LogoutConversation;
import com.github.dschreid.shop.client.conversations.item.AddItemConversation;
import com.github.dschreid.shop.client.conversations.item.GetItemConversation;
import com.github.dschreid.shop.client.conversations.item.ListItemsConversation;

/**
 * Model for Choosing action conversation.
 *
 * @author dschreid
 */
public class ChoosingActionConversation extends ChoosingConversation {
    /**
     * Instantiates a new Choosing action conversation.
     *
     * @param application the application
     */
    public ChoosingActionConversation(ClientApplication application) {
        super(application, null);

        this.addChoice(new ListUsersConversation(application, this));
        this.addChoice(new LogoutConversation(application, this));

        this.addChoice(new AddItemConversation(application, this));
        this.addChoice(new GetItemConversation(application, this));
        this.addChoice(new ListItemsConversation(application, this));
    }
}
