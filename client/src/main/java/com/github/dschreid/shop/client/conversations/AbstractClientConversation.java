package com.github.dschreid.shop.client.conversations;

import com.github.dschreid.shop.client.ClientApplication;
import com.github.dschreid.shop.client.util.IO;
import com.github.dschreid.shop.client.model.Conversation;
import com.github.dschreid.shop.client.service.WebService;

/**
 * Model for Abstract client conversation.
 *
 * @author dschreid
 */
public abstract class AbstractClientConversation implements Conversation {
    /**
     * The Application.
     */
    protected final ClientApplication application;
    /**
     * The Web service.
     */
    protected final WebService webService;
    /**
     * The Io.
     */
    protected final IO io;
    /**
     * The Last conversation.
     */
    protected final Conversation lastConversation;

    /**
     * Instantiates a new Abstract client conversation.
     *
     * @param application      the application
     * @param lastConversation the last conversation
     */
    public AbstractClientConversation(ClientApplication application, Conversation lastConversation) {
        this.application = application;
        this.webService = application.getWebService();
        this.io = application.getIo();
        this.lastConversation = lastConversation;
    }
}
