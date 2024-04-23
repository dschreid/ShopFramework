package com.github.dschreid.shop.client.service;

import com.github.dschreid.shop.client.model.Conversation;

/**
 * The interface Conversation service.
 *
 * @author dschreid
 */
public interface ConversationService {
    /**
     * Blocking Operation
     *
     * @param conversation the conversation
     */
    void startConversation(Conversation conversation);
}
