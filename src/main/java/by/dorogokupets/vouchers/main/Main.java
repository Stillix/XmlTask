package by.dorogokupets.vouchers.main;


import by.dorogokupets.vouchers.entity.Voucher;
import by.dorogokupets.vouchers.parser.VouchersDomBuilder;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        String filename = "data_xml/TouristVouchers.xml";

        VouchersDomBuilder builder = new VouchersDomBuilder();
        builder.buildVouchers(filename);

        List<Voucher> vouchers = builder.getVouchers();
        for (Voucher voucher : vouchers) {
            System.out.println(voucher);
            System.out.println();
        }
    }
}