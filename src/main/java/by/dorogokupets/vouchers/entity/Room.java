package by.dorogokupets.vouchers.entity;

public class Room {
    private boolean balcony;
    private boolean wifi;
    private boolean tv;
    private boolean conditioner;
    private int roomAmount;

    // Constructors, getters, and setters

    public Room() {
    }

    public Room(boolean balcony, boolean wifi, boolean tv, boolean conditioner, int roomAmount) {
        this.balcony = balcony;
        this.wifi = wifi;
        this.tv = tv;
        this.conditioner = conditioner;
        this.roomAmount = roomAmount;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isConditioner() {
        return conditioner;
    }

    public void setConditioner(boolean conditioner) {
        this.conditioner = conditioner;
    }

    public int getRoomAmount() {
        return roomAmount;
    }

    public void setRoomAmount(int roomAmount) {
        this.roomAmount = roomAmount;
    }

    @Override
    public String toString() {
        return "Room{" +
                "balcony=" + balcony +
                ", wifi=" + wifi +
                ", tv=" + tv +
                ", conditioner=" + conditioner +
                ", roomAmount=" + roomAmount +
                '}';
    }
}
