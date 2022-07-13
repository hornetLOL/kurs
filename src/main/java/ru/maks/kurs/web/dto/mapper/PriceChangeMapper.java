package ru.maks.kurs.web.dto.mapper;

import org.mapstruct.Mapper;
import ru.maks.kurs.entity.PriceChange;
import ru.maks.kurs.web.dto.PriceChangeDto;

@Mapper
public interface PriceChangeMapper {

	PriceChange toPriceChange(PriceChangeDto priceChangeDto);

	PriceChangeDto toPriceChangeDto(PriceChange priceChange);
}
