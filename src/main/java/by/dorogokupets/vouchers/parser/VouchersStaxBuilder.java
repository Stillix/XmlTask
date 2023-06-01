package by.dorogokupets.vouchers.parser;

import by.dorogokupets.vouchers.entity.Hotel;
import by.dorogokupets.vouchers.entity.Room;
import by.dorogokupets.vouchers.entity.Voucher;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VouchersStaxBuilder {
    private List<Voucher> vouchers;
    private XMLInputFactory inputFactory;

    public VouchersStaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
        vouchers = new ArrayList<>();
    }

    public List<Voucher> getVouchers() {
        return vouchers;
    }

    public void buildVouchers(String filename) {
        XMLStreamReader reader;
        String elementName;
        try (FileInputStream inputStream = new FileInputStream(new File(filename))) {
            reader = inputFactory.createXMLStreamReader(inputStream);

            Voucher voucher = null;
            Hotel hotel = null;
            Room room = null;

            while (reader.hasNext()) {
                int eventType = reader.next();
                switch (eventType) {
                    case XMLStreamConstants.START_ELEMENT:
                        elementName = reader.getLocalName();
                        switch (elementName) {
                            case "Voucher":
                                voucher = new Voucher();
                                voucher.setId(reader.getAttributeValue(null, "id"));
                                break;
                            case "VoucherType":
                                voucher.setVoucherType(reader.getElementText());
                                break;
                            case "Country":
                                voucher.setCountry(reader.getElementText());
                                break;
                            case "Transport":
                                voucher.setTransport(reader.getElementText());
                                break;
                            case "NumberDays":
                                voucher.setNumberDays(Integer.parseInt(reader.getElementText()));
                                break;
                            case "ArrivalDate":
                                voucher.setArrivalDate(reader.getElementText());
                                break;
                            case "Hotel":
                                hotel = new Hotel();
                                break;
                            case "Name":
                                hotel.setName(reader.getElementText());
                                break;
                            case "Star":
                                hotel.setStar(Integer.parseInt(reader.getElementText()));
                                break;
                            case "Food":
                                hotel.setFood(reader.getElementText());
                                break;
                            case "Room":
                                room = new Room();
                                room.setBalcony(Boolean.parseBoolean(reader.getAttributeValue(null, "Balcony")));
                                room.setWifi(Boolean.parseBoolean(reader.getAttributeValue(null, "WIFI")));
                                break;
                            case "TV":
                                room.setTv(Boolean.parseBoolean(reader.getElementText()));
                                break;
                            case "Conditioner":
                                room.setConditioner(Boolean.parseBoolean(reader.getElementText()));
                                break;
                            case "RoomAmount":
                                room.setRoomAmount(Integer.parseInt(reader.getElementText()));
                                break;
                            case "Cost":
                                voucher.setCost(reader.getElementText());
                                break;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        elementName = reader.getLocalName();
                        if (elementName.equals("Voucher")) {
                            vouchers.add(voucher);
                            voucher = null;
                        } else if (elementName.equals("Hotel")) {
                            hotel.setRoom(room);
                            voucher.setHotel(hotel);
                            hotel = null;
                            room = null;
                        }
                        break;
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
