package com.github.dschreid.shop.server;

/**
 * Launches the application
 *
 * @author dschreid
 */
public class ServerBootstrap {
    public static void main(String[] args) {
        ServerApplication server = new ServerApplication();
        server.start(args);
    }
}
