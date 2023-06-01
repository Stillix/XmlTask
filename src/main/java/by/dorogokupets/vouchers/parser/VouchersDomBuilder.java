package by.dorogokupets.vouchers.parser;

import by.dorogokupets.vouchers.entity.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VouchersDomBuilder {
    private List<Voucher> vouchers;
    private DocumentBuilder docBuilder;

    public VouchersDomBuilder() {
        vouchers = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public List<Voucher> getVouchers() {
        return vouchers;
    }

    public void buildVouchers(String filename) {
        Document doc;
        try {
            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();
            NodeList voucherList = root.getElementsByTagName("Voucher");
            for (int i = 0; i < voucherList.getLength(); i++) {
                Element voucherElement = (Element) voucherList.item(i);
                Voucher voucher = buildVoucher(voucherElement);
                vouchers.add(voucher);
            }
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private Voucher buildVoucher(Element voucherElement) {
        Voucher voucher = new Voucher();
        voucher.setId(voucherElement.getAttribute("id"));
        voucher.setVoucherType(getElementTextContent(voucherElement, "VoucherType"));
        voucher.setCountry(getElementTextContent(voucherElement, "Country"));
        voucher.setTransport(getElementTextContent(voucherElement, "Transport"));
        voucher.setNumberDays(Integer.parseInt(getElementTextContent(voucherElement, "NumberDays")));
        voucher.setArrivalDate(getElementTextContent(voucherElement, "ArrivalDate"));
        voucher.setHotel(buildHotel(voucherElement));
        voucher.setCost(getElementTextContent(voucherElement, "Cost"));
        return voucher;
    }

    private Hotel buildHotel(Element voucherElement) {
        Hotel hotel = new Hotel();
        Element hotelElement = (Element) voucherElement.getElementsByTagName("Hotel").item(0);
        if (hotelElement != null) {
            Element basicCharacteristicsElement = (Element) hotelElement.getElementsByTagName("BasicHotelCharacteristics").item(0);
            if (basicCharacteristicsElement != null) {
                hotel.setName(getElementTextContent(basicCharacteristicsElement, "Name"));
                hotel.setStar(Integer.parseInt(getElementTextContent(basicCharacteristicsElement, "Star")));
                hotel.setFood(getElementTextContent(basicCharacteristicsElement, "Food"));
                hotel.setRoom(buildRoom(basicCharacteristicsElement));
            } else {
                Element exclusiveCharacteristicsElement = (Element) hotelElement.getElementsByTagName("ExclusiveCharacteristics").item(0);
                if (exclusiveCharacteristicsElement != null) {
                    hotel.setName(getElementTextContent(exclusiveCharacteristicsElement, "Name"));
                    hotel.setStar(Integer.parseInt(getElementTextContent(exclusiveCharacteristicsElement, "Star")));
                    hotel.setFood(getElementTextContent(exclusiveCharacteristicsElement, "Food"));
                    hotel.setRoom(buildRoom(exclusiveCharacteristicsElement));
                    hotel.setServices(getElementTextContent(exclusiveCharacteristicsElement, "Services"));
                }
            }
        }
        return hotel;
    }

    private Room buildRoom(Element characteristicsElement) {
        Room room = new Room();
        NodeList roomList = characteristicsElement.getElementsByTagName("Room");
        if (roomList.getLength() > 0) {
            Element roomElement = (Element) roomList.item(0);
            room.setWifi(Boolean.parseBoolean(roomElement.getAttribute("WIFI")));
            room.setBalcony(Boolean.parseBoolean(roomElement.getAttribute("Balcony")));
            room.setTv(Boolean.parseBoolean(getElementTextContent(roomElement, "TV")));
            room.setConditioner(Boolean.parseBoolean(getElementTextContent(roomElement, "Conditioner")));
            room.setRoomAmount(Integer.parseInt(getElementTextContent(roomElement, "RoomAmount")));
        }
        return room;
    }

    private String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        String textContent = node.getTextContent();
        return textContent;
    }
}
