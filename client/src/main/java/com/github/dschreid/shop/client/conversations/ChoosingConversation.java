package com.github.dschreid.shop.client.conversations;

import com.github.dschreid.shop.client.ClientApplication;
import com.github.dschreid.shop.client.model.Conversation;

import java.util.ArrayList;
import java.util.List;

/**
 * Model for Choosing conversation.
 *
 * @author dschreid
 */
public class ChoosingConversation extends AbstractClientConversation {
    /**
     * The Choices.
     */
    protected final List<Conversation> choices;

    /**
     * Instantiates a new Choosing conversation.
     *
     * @param application      the application
     * @param lastConversation the last conversation
     */
    public ChoosingConversation(ClientApplication application, Conversation lastConversation) {
        super(application, lastConversation);
        this.choices = new ArrayList<>();
    }

    /**
     * Add choice.
     *
     * @param conversation the conversation
     */
    protected void addChoice(Conversation conversation) {
        this.choices.add(conversation);
    }

    @Override
    public Conversation make() {
        int min = 0;
        int max = choices.size() - 1;

        io.gebeAus("What would you like to do next?\n");
        for (int i = 0; i < choices.size(); i++) {
            io.gebeAus(" (%s) %s\n", i + 1, choices.get(i).getClass().getSimpleName());
        }

        final int next = io.leseInt("Next (%s - %s): ".formatted(min + 1, max + 1)) - 1;
        if (next < min || next > max) {
            io.gebeAus("Must choose between %s and %s", min, max);
            return this;
        }

        return choices.get(next);
    }
}
