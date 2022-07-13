package ru.maks.kurs.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maks.kurs.dao.PriceChangeDao;
import ru.maks.kurs.entity.PriceChange;
import ru.maks.kurs.web.dto.PriceChangeDto;
import ru.maks.kurs.web.dto.mapper.PriceChangeMapper;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PriceChangeService {

	private final PriceChangeDao priceChangeDao;
	private final PriceChangeMapper priceChangeMapper;

	@Transactional
	public PriceChangeDto save(final PriceChangeDto priceChangeDto){
		PriceChange priceChange;
		try {
			priceChange = priceChangeMapper.toPriceChange(priceChangeDto);
			return priceChangeMapper.toPriceChangeDto(priceChangeDao.save(priceChange));
		}catch (NoSuchElementException e){
			return null;
		}
	}
	public void deleteById() {
		//todo удаление предмета по id
	}
	@Transactional(readOnly = true)
	public PriceChangeDto findById(Long id) {
		return priceChangeMapper.toPriceChangeDto((priceChangeDao.findById(id).orElse(null)));
	}

	public List<PriceChangeDto> findAll() {
		return priceChangeDao.findAll().stream().map(priceChangeMapper::toPriceChangeDto).collect(Collectors.toList());
	}
}
