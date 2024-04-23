package com.github.dschreid.shop.client.conversations.item;

import com.github.dschreid.shop.client.ClientApplication;
import com.github.dschreid.shop.client.conversations.AbstractClientConversation;
import com.github.dschreid.shop.client.model.Conversation;
import com.github.dschreid.shop.server.dto.response.ItemInformationResponse;
import com.github.dschreid.shop.server.model.Role;

/**
 * Model for Add item conversation.
 *
 * @author dschreid
 */
public class AddItemConversation extends AbstractClientConversation {
    /**
     * Instantiates a new Add item conversation.
     *
     * @param application      the application
     * @param lastConversation the last conversation
     */
    public AddItemConversation(ClientApplication application, Conversation lastConversation) {
        super(application, lastConversation);
    }

    @Override
    public Conversation make() {
        if (!Role.STAFF.is(application.getPermissionLevel())) {
            io.gebeLineAus("Not permitted");
            return lastConversation;
        }

        ItemInformationResponse item = new ItemInformationResponse();
        item.setTitle(io.leseString("Title: "));
        item.setDescription(io.leseString("Description: "));
        item.setCategory(io.leseString("Category: "));
        item.setPrice(io.leseInt("Price: "));
        item.setQuantity(io.leseInt("Quantity: "));

        application.makeCall(webService.addItem(item));

        return lastConversation;
    }
}
