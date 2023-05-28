package by.dorogokupets.vouchers.entity;

import java.time.LocalDateTime;

public class Voucher {
        private String id;
        private String voucherType;
        private String country;
        private String transport;
        private int numberDays;
        private String arrivalDate;
        private Hotel hotel;
        private String cost;

        // Constructors, getters, and setters

        public Voucher() {
        }

        public Voucher(String id, String voucherType, String country, String transport, int numberDays, String arrivalDate, Hotel hotel, String cost) {
            this.id = id;
            this.voucherType = voucherType;
            this.country = country;
            this.transport = transport;
            this.numberDays = numberDays;
            this.arrivalDate = arrivalDate;
            this.hotel = hotel;
            this.cost = cost;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getVoucherType() {
            return voucherType;
        }

        public void setVoucherType(String voucherType) {
            this.voucherType = voucherType;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getTransport() {
            return transport;
        }

        public void setTransport(String transport) {
            this.transport = transport;
        }

        public int getNumberDays() {
            return numberDays;
        }

        public void setNumberDays(int numberDays) {
            this.numberDays = numberDays;
        }

        public String getArrivalDate() {
            return arrivalDate;
        }

        public void setArrivalDate(String arrivalDate) {
            this.arrivalDate = arrivalDate;
        }

        public Hotel getHotel() {
            return hotel;
        }

        public void setHotel(Hotel hotel) {
            this.hotel = hotel;
        }

        public String getCost() {
            return cost;
        }

        public void setCost(String cost) {
            this.cost = cost;
        }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Voucher id : ").append(id).append("\n");
        sb.append("VoucherType : ").append(voucherType).append("\n");
        sb.append("Country : ").append(country).append("\n");
        sb.append("Transport : ").append(transport).append("\n");
        sb.append("NumberDays : ").append(numberDays).append("\n");
        sb.append("ArrivalDate : ").append(arrivalDate).append("\n");
        sb.append("Hotel : ").append(hotel).append("\n");
        sb.append("Cost : ").append(cost);
        return sb.toString();
    }
}

