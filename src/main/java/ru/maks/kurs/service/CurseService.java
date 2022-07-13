package ru.maks.kurs.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.maks.kurs.dao.*;
import ru.maks.kurs.dao.CurseDao;
import ru.maks.kurs.entity.*;
import ru.maks.kurs.entity.Curse;
import ru.maks.kurs.entity.relationTables.PurchasedCurse;
import ru.maks.kurs.web.dto.CurseDto;
import ru.maks.kurs.web.dto.PriceChangeDto;
import ru.maks.kurs.web.dto.StaffDto;
import ru.maks.kurs.web.dto.CurseDto;
import ru.maks.kurs.web.dto.mapper.CurseMapper;
import ru.maks.kurs.web.dto.mapper.CurseMapper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CurseService {

    private final CurseDao curseDao;
    private final CurseMapper curseMapper;
    private final StudentDao studentDao;
    private final StaffDao staffDao;
    private final SubjectDao subjectDao;
    private final PriceChangeService priceChangeService;

    @Transactional
    public CurseDto save(final CurseDto curseDto){
        Curse curseNew;
        Curse curseOld;
        try {
            curseNew = curseMapper.toCurse(curseDto, subjectDao, studentDao, staffDao);
            curseOld = curseDao.getById(curseDto.getId());
            if(curseNew.getId() != null && !Objects.equals(curseNew.getPrice(), curseOld.getPrice())){
                PriceChangeDto pcdto = PriceChangeDto.builder()
                        .curseId(curseDto.getId())
                        .oldPrice(curseOld.getPrice())
                        .date(LocalDate.now())
                        .build();
                priceChangeService.save(pcdto);
            }
            return curseMapper.toCurseDto(curseDao.save(curseNew));
        }catch (NoSuchElementException e){
            return null;
        }
    }
//    public void deleteById() {
//        //todo удаление курса по id
//    }
    
    @Transactional(readOnly = true)
    public CurseDto findById(Long id) {
        return curseMapper.toCurseDto((curseDao.findById(id).orElse(null)));
    }

    public List<CurseDto> findAllByPriceLower(Long price) {
        return curseDao.findAllByPriceLessThan(new BigDecimal(price)).stream()
                .map(curseMapper::toCurseDto).collect(Collectors.toList());
    }

    public List<CurseDto> findAllByPriceGreater(Long price) {
        return curseDao.findAllByPriceGreaterThan(new BigDecimal(price)).stream()
                .map(curseMapper::toCurseDto).collect(Collectors.toList());
    }

    public List<CurseDto> findAll(){
        return curseDao.findAll().stream().map(curseMapper::toCurseDto).collect(Collectors.toList());
    }
    
    public List<CurseDto> findAllByTargetGroup(String targetGroup){
        return curseDao.findAllByTargetGroup(targetGroup).stream().map(curseMapper::toCurseDto).collect(Collectors.toList());
    }
    
    public List<CurseDto> findAllBySubject(String subject){
        List<CurseDto> curses = findAll();
        List<CurseDto> curseSubject = new ArrayList<>();
        for(CurseDto curse : curses){
            if(curse.getSubject().getTitle().equals(subject))
                curseSubject.add(curse);
        }
        return curseSubject;
    }
}
