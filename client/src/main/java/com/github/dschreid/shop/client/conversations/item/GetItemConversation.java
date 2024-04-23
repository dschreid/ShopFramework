package com.github.dschreid.shop.client.conversations.item;

import com.github.dschreid.shop.client.ClientApplication;
import com.github.dschreid.shop.client.conversations.AbstractClientConversation;
import com.github.dschreid.shop.client.model.Conversation;
import com.github.dschreid.shop.server.dto.response.ItemInformationResponse;

/**
 * Model for Get item conversation.
 *
 * @author dschreid
 */
public class GetItemConversation extends AbstractClientConversation {
    /**
     * Instantiates a new Get item conversation.
     *
     * @param application      the application
     * @param lastConversation the last conversation
     */
    public GetItemConversation(ClientApplication application, Conversation lastConversation) {
        super(application, lastConversation);
    }

    @Override
    public Conversation make() {
        final int id = io.leseInt("Item Id: ");
        final ItemInformationResponse itemInformationResponse = application.makeCall(webService.getItem(id));
        if (itemInformationResponse == null) {
            return lastConversation;
        }

        io.gebeLineAus("Item: %s", itemInformationResponse);
        return lastConversation;
    }
}
