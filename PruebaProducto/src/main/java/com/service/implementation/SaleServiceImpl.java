package com.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.DetailSaleDto;
import com.dto.SaleDto;
import com.exception.NotFoundSaleException;
import com.persistence.entity.DetailSale;
import com.persistence.entity.Product;
import com.persistence.entity.Sale;
import com.persistence.repository.SaleRepository;
import com.service.InvoiceService;
import com.service.ProductService;
import com.service.SaleService;
import com.util.mapper.ProductMapper;
import com.util.mapper.SaleMapper;

@Service
public class SaleServiceImpl implements SaleService {



    @Autowired
    private InvoiceService invoiceService;


    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProductService productService;

    @Override
    public SaleDto getSale(Long id) {
        Sale response = saleRepository.findById(id).orElseThrow(()-> new NotFoundSaleException());
        return SaleMapper.mapper.saleToSaledto(response);
    }


    @Override
    public List<SaleDto> getSaleAll() {
        List<SaleDto> response = saleRepository.findAll().stream()
                                    .map(sale -> SaleMapper.mapper.saleToSaledto(sale))
                                    .collect(Collectors.toList());

        return response;
    }

    @Override
    public SaleDto saveSale(SaleDto sale) {
        Sale saleResponse = new Sale();
        saleResponse.setDate(sale.getDate());
        saleResponse.setId(sale.getId());
        saleResponse.setValor(sale.getValor());
        saleResponse.setCanceled(false);
        saleResponse.setEstado("Pendiente por falta de stock");
        List<DetailSale> details = new ArrayList<DetailSale>();
        
        for(DetailSaleDto detailReceived: sale.getDetails()){
            Product product = ProductMapper.mapper.productDtoToproduct(productService.getProduct(detailReceived.getProductId()));
            if(product.getCant() - detailReceived.getCantProduct() < 0 ){
                saleResponse.setEstado("Pendiente por falta de stock");
            }
            else{
                productService.descontStock(product.getId(),detailReceived.getCantProduct());
                saleResponse.setEstado("Finalizada");

            }

            DetailSale detail = new DetailSale(
                detailReceived.getCantProduct(),
                product,
                saleResponse
            );

            details.add(detail);
        }


        saleResponse.setDetails(details);

        saleRepository.save(saleResponse);
        invoiceService.saveInvoice(saleResponse);
        return SaleMapper.mapper.saleToSaledto(saleResponse);
    }



    @Override
    public void deleteSale(Long id) {
        saleRepository.delete(saleRepository.findById(id).orElseThrow(() -> new NotFoundSaleException()));
    }

    @Override
    public void cancelSale(Long id) {
        Sale sale = saleRepository.findById(id).orElseThrow(()-> new NotFoundSaleException());
        sale.setCanceled(true);
        saleRepository.save(sale);
    }

    @Override
    public void descancelSale(Long id) {
        Sale sale = saleRepository.findById(id).orElseThrow(()-> new NotFoundSaleException());
        sale.setCanceled(false);
        saleRepository.save(sale);
    }
    
}
 