package com.util.mapper;

import com.dto.DetailSaleDto;
import com.dto.SaleDto;
import com.persistence.entity.DetailSale;
import com.persistence.entity.Sale;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-24T00:19:28-0300",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
public class SaleMapperImpl implements SaleMapper {

    private final DetailSaleMapper detailSaleMapper = Mappers.getMapper( DetailSaleMapper.class );

    @Override
    public Sale saleDtoToSale(SaleDto sale) {
        if ( sale == null ) {
            return null;
        }

        Sale sale1 = new Sale();

        sale1.setCanceled( sale.isCanceled() );
        sale1.setDate( sale.getDate() );
        sale1.setDetails( detailSaleDtoListToDetailSaleList( sale.getDetails() ) );
        sale1.setEstado( sale.getEstado() );
        sale1.setId( sale.getId() );
        sale1.setValor( sale.getValor() );

        return sale1;
    }

    @Override
    public SaleDto saleToSaledto(Sale sale) {
        if ( sale == null ) {
            return null;
        }

        LocalDate date = null;
        List<DetailSaleDto> details = null;
        String estado = null;
        Long id = null;
        double valor = 0.0d;

        date = sale.getDate();
        details = detailSaleListToDetailSaleDtoList( sale.getDetails() );
        estado = sale.getEstado();
        id = sale.getId();
        valor = sale.getValor();

        boolean isCanceled = false;

        SaleDto saleDto = new SaleDto( id, valor, date, isCanceled, estado, details );

        saleDto.setCanceled( sale.isCanceled() );

        return saleDto;
    }

    protected DetailSale detailSaleDtoToDetailSale(DetailSaleDto detailSaleDto) {
        if ( detailSaleDto == null ) {
            return null;
        }

        DetailSale detailSale = new DetailSale();

        detailSale.setCantProduct( detailSaleDto.getCantProduct() );

        return detailSale;
    }

    protected List<DetailSale> detailSaleDtoListToDetailSaleList(List<DetailSaleDto> list) {
        if ( list == null ) {
            return null;
        }

        List<DetailSale> list1 = new ArrayList<DetailSale>( list.size() );
        for ( DetailSaleDto detailSaleDto : list ) {
            list1.add( detailSaleDtoToDetailSale( detailSaleDto ) );
        }

        return list1;
    }

    protected List<DetailSaleDto> detailSaleListToDetailSaleDtoList(List<DetailSale> list) {
        if ( list == null ) {
            return null;
        }

        List<DetailSaleDto> list1 = new ArrayList<DetailSaleDto>( list.size() );
        for ( DetailSale detailSale : list ) {
            list1.add( detailSaleMapper.detailProductToDetailProductDto( detailSale ) );
        }

        return list1;
    }
}
