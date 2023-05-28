package by.dorogokupets.vouchers.entity;

public class Hotel {
    private BasicHotelCharacteristics basicCharacteristics;
    private ExclusiveCharacteristics exclusiveCharacteristics;
    private String name;
    private int star;
    private String food;
    private Room room;
    private String services;

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Hotel() {
    }

    public Hotel(BasicHotelCharacteristics basicCharacteristics, ExclusiveCharacteristics exclusiveCharacteristics) {
        this.basicCharacteristics = basicCharacteristics;
        this.exclusiveCharacteristics = exclusiveCharacteristics;
    }

    public BasicHotelCharacteristics getBasicCharacteristics() {
        return basicCharacteristics;
    }

    public void setBasicCharacteristics(BasicHotelCharacteristics basicCharacteristics) {
        this.basicCharacteristics = basicCharacteristics;
    }

    public ExclusiveCharacteristics getExclusiveCharacteristics() {
        return exclusiveCharacteristics;
    }

    public void setExclusiveCharacteristics(ExclusiveCharacteristics exclusiveCharacteristics) {
        this.exclusiveCharacteristics = exclusiveCharacteristics;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hotel Name : ").append(name).append("\n");
        sb.append("Star : ").append(star).append("\n");
        sb.append("Food : ").append(food).append("\n");
        sb.append("Room : ").append(room);
        return sb.toString();
    }
}
