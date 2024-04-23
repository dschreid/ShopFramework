package com.github.dschreid.shop.client.service;

import com.github.dschreid.shop.client.model.Conversation;

/**
 * Model for Conversation service.
 *
 * @author dschreid
 */
public class ConversationServiceImpl implements ConversationService {
    @Override
    public void startConversation(Conversation conversation) {
        Conversation current = conversation;
        while (current != Conversation.END_OF_CONVERSATION) {
            current = current.make();
        }
    }
}
