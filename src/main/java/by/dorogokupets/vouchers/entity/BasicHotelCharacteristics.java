package by.dorogokupets.vouchers.entity;

public class BasicHotelCharacteristics {
    private String name;
    private int star;
    private String food;
    private Room room;



    public BasicHotelCharacteristics() {
    }

    public BasicHotelCharacteristics(String name, int star, String food, Room room) {
        this.name = name;
        this.star = star;
        this.food = food;
        this.room = room;
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

    @Override
    public String toString() {
        return "BasicHotelCharacteristics{" +
                "name='" + name + '\'' +
                ", star=" + star +
                ", food='" + food + '\'' +
                ", room=" + room +
                '}';
    }
}
