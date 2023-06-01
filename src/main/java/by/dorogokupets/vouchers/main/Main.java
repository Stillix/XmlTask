package by.dorogokupets.vouchers.main;


import by.dorogokupets.vouchers.entity.Hotel;
import by.dorogokupets.vouchers.entity.Room;
import by.dorogokupets.vouchers.entity.Voucher;
import by.dorogokupets.vouchers.parser.VouchersStaxBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        VouchersStaxBuilder staxBuilder = new VouchersStaxBuilder();
        staxBuilder.buildVouchers("data_xml/TouristVouchers.xml");
        System.out.println(staxBuilder.getVouchers());
            }
        }



