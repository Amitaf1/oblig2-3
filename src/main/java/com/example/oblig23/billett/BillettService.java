package com.example.oblig23.billett;

import java.util.List;

public interface BillettService {

    Billett createBillett(BillettRequest request);
    Billett updateBillett(Integer id, BillettRequest request);
    Billett getBillettById(Integer id);
    void slettAlleBilletter();

    List<Billett> getAllBilletter();
}


