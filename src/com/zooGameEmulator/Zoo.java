package com.zooGameEmulator;

public class Zoo {
    private final boolean penguin;

    public Zoo(TicketType ownedTicket) {
        if (ownedTicket == TicketType.ADULT_PENGUIN) {
            penguin = true;
        } else {
            penguin = false;
        }
    }

    public void enterZoo() {
        // this will be build soon. As for now, keep it empty.
    }
}
