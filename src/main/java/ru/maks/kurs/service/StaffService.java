package ru.maks.kurs.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maks.kurs.dao.CurseDao;
import ru.maks.kurs.dao.StaffDao;
import ru.maks.kurs.entity.Staff;
import ru.maks.kurs.entity.enums.StaffStatus;
import ru.maks.kurs.web.dto.CurseStaffDto;
import ru.maks.kurs.web.dto.PurchasedCurseDto;
import ru.maks.kurs.web.dto.StaffDto;

import ru.maks.kurs.web.dto.StudentDto;
import ru.maks.kurs.web.dto.mapper.StaffMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StaffService {

    private final StaffDao staffDao;
    private final StaffMapper staffMapper;
    private final CurseDao curseDao;
    
    @Transactional
    public StaffDto save(final StaffDto staffDto){
        Staff staff;
        try {
            staff = staffMapper.toStaff(staffDto, curseDao);
            return staffMapper.toStaffDto(staffDao.save(staff));
        }catch (NoSuchElementException e){
            return null;
        }
    }

    public List<StaffDto> findAllByCurseName(String curseName) {
        List<StaffDto> staffs = findAll();
        List<StaffDto> staffCurse = new ArrayList<>();
        for(StaffDto staff : staffs){
            for(CurseStaffDto curseStaff : staff.getCurses())
                if(curseStaff.getCurse().getTitle().equals(curseName))
                    staffCurse.add(staff);
        }
        return staffCurse;
    }

//    public void deleteById() {
//        //todo удаление сотрудника по id
//    }
    @Transactional(readOnly = true)
    public StaffDto findById(Long id) {
        return staffMapper.toStaffDto((staffDao.findById(id).orElse(null)));
    }

//    public Staff findByStatus(Long status) {
//        //todo поиск по статусу сотрудник (0, 1)
//    }
//    
//    public Staff findByNumlb(Long numlb) {
//        //todo поиск по номеру трудовой
//    }

    @Transactional(readOnly = true)
    public StaffDto findByNumpas(Long numpas) {
        return staffMapper.toStaffDto((staffDao.findByNumPass(numpas).orElse(null)));
    }

    public List<StaffDto> findAll() {
        return staffDao.findAll().stream().map(staffMapper::toStaffDto).collect(Collectors.toList());
    }

    public List<StaffDto> findAllByPost(String post) {
        return staffDao.findAllByPost(post).stream().map(staffMapper::toStaffDto).collect(Collectors.toList());
    }

    public List<StaffDto> findAllByStatus(StaffStatus status) {return staffDao.findAllByStatus(status).stream()
            .map(staffMapper::toStaffDto).collect(Collectors.toList());
    }
}
