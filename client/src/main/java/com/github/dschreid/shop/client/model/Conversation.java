package com.github.dschreid.shop.client.model;

/**
 * The interface Conversation.
 *
 * @author dschreid
 */
public interface Conversation {
    /**
     * The constant END_OF_CONVERSATION.
     */
    Conversation END_OF_CONVERSATION = null;

    /**
     * Make the conversation and return the next step of the conversation
     *
     * @return next conversation
     */
    Conversation make();
}
