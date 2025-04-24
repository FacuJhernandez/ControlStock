package com.util.mapper;

import com.dto.DetailSaleDto;
import com.persistence.entity.DetailSale;
import com.persistence.entity.Product;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-24T00:19:27-0300",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
public class DetailSaleMapperImpl implements DetailSaleMapper {

    @Override
    public DetailSaleDto detailProductToDetailProductDto(DetailSale detail) {
        if ( detail == null ) {
            return null;
        }

        Long productId = null;
        String productName = null;
        double unitPrice = 0.0d;
        int cantProduct = 0;

        productId = detailProductId( detail );
        productName = detailProductName( detail );
        unitPrice = detailProductCost( detail );
        cantProduct = detail.getCantProduct();

        DetailSaleDto detailSaleDto = new DetailSaleDto( productId, productName, cantProduct, unitPrice );

        return detailSaleDto;
    }

    private Long detailProductId(DetailSale detailSale) {
        if ( detailSale == null ) {
            return null;
        }
        Product product = detailSale.getProduct();
        if ( product == null ) {
            return null;
        }
        Long id = product.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String detailProductName(DetailSale detailSale) {
        if ( detailSale == null ) {
            return null;
        }
        Product product = detailSale.getProduct();
        if ( product == null ) {
            return null;
        }
        String name = product.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private double detailProductCost(DetailSale detailSale) {
        if ( detailSale == null ) {
            return 0.0d;
        }
        Product product = detailSale.getProduct();
        if ( product == null ) {
            return 0.0d;
        }
        double cost = product.getCost();
        return cost;
    }
}
