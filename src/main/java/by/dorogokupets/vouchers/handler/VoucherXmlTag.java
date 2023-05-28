package by.dorogokupets.vouchers.handler;

public enum VoucherXmlTag {
        TOURIST_VOUCHERS("TouristVouchers"),
        VOUCHER("Voucher"),
        VOUCHER_TYPE("VoucherType"),
        COUNTRY("Country"),
        TRANSPORT("Transport"),
        NUMBER_DAYS("NumberDays"),
        ARRIVAL_DATE("ArrivalDate"),
        HOTEL("Hotel"),
        BASIC_HOTEL_CHARACTERISTICS("BasicHotelCharacteristics"),
        NAME("Name"),
        STAR("Star"),
        FOOD("Food"),
        ROOM("Room"),
        TV("TV"),
        CONDITIONER("Conditioner"),
        ROOM_AMOUNT("RoomAmount"),
        COST("Cost"),
        EXCLUSIVE_CHARACTERISTICS("ExclusiveCharacteristics"),
        SERVICES("Services");

        private String value;

        VoucherXmlTag(String value) {
                this.value = value;
        }

        public String getValue() {
                return value;
        }
}
