package com.github.dschreid.shop.client.conversations.item;

import com.github.dschreid.shop.client.ClientApplication;
import com.github.dschreid.shop.client.conversations.AbstractClientConversation;
import com.github.dschreid.shop.client.model.Conversation;
import com.github.dschreid.shop.server.dto.response.ItemInformationResponse;

import java.util.List;

/**
 * Model for List items conversation.
 *
 * @author dschreid
 */
public class ListItemsConversation extends AbstractClientConversation {
    /**
     * Instantiates a new List items conversation.
     *
     * @param application      the application
     * @param lastConversation the last conversation
     */
    public ListItemsConversation(ClientApplication application, Conversation lastConversation) {
        super(application, lastConversation);
    }

    @Override
    public Conversation make() {
        final List<ItemInformationResponse> items = application.makeCall(webService.getItems());
        if (items == null)
            return lastConversation;

        for (ItemInformationResponse item : items) {
            io.gebeLineAus("Item: %s", item);
        }
        return lastConversation;
    }
}
