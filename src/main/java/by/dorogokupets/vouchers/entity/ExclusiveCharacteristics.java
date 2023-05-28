package by.dorogokupets.vouchers.entity;

public class ExclusiveCharacteristics {
    private String name;
    private int star;
    private String food;
    private Room room;
    private String services;

    // Constructors, getters, and setters

    public ExclusiveCharacteristics() {
    }

    public ExclusiveCharacteristics(String name, int star, String food, Room room, String services) {
        this.name = name;
        this.star = star;
        this.food = food;
        this.room = room;
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

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "ExclusiveCharacteristics{" +
                "name='" + name + '\'' +
                ", star=" + star +
                ", food='" + food + '\'' +
                ", room=" + room +
                ", services='" + services + '\'' +
                '}';
    }
}
