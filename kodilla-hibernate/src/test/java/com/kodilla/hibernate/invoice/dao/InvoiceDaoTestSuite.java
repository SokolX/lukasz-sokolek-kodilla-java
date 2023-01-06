package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {
        //given
        Product milk = new Product("Milk");
        Product butter = new Product("Butter");
        Item item1 = new Item(milk, new BigDecimal(4.99), 1, new BigDecimal(4.99));
        Item item2 = new Item(butter, new BigDecimal(4.99), 1, new BigDecimal(4.99));
        Invoice invoice = new Invoice("F1/01/2022");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);

        //when
        invoiceDao.save(invoice);
        int idInvoice = invoice.getId();
        long sum = invoiceDao.count();

        //then
        assertNotNull(idInvoice);
        assertEquals(1L, sum);

        //cleanup
        invoiceDao.deleteById(idInvoice);
    }
}