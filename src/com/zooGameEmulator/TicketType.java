package com.zooGameEmulator;

enum TicketType {
    ADULT_BASIC(100),
    ADULT_PENGUIN(165),
    SPECIAL_VISITOR(350),
    KID(25);

    private final int ticketPrice;

    TicketType(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }
}
