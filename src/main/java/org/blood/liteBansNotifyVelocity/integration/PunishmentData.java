package org.blood.liteBansNotifyVelocity.integration;

public final class PunishmentData {

    private final String type;
    private final String player;
    private final String executor;
    private final long startMillis;
    private final long endMillis;
    private final String reason;
    private final String scope;

    public PunishmentData(String type, String player, String executor, long startMillis, long endMillis, String reason, String scope) {
        this.type = type;
        this.player = player;
        this.executor = executor;
        this.startMillis = startMillis;
        this.endMillis = endMillis;
        this.reason = reason;
        this.scope = scope;
    }

    public String type() {
        return type;
    }

    public String player() {
        return player;
    }

    public String executor() {
        return executor;
    }

    public long startMillis() {
        return startMillis;
    }

    public long endMillis() {
        return endMillis;
    }

    public String reason() {
        return reason;
    }

    public String scope() {
        return scope;
    }
}

