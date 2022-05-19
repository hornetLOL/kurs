package ru.maks.kurs.web.dto.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import ru.maks.kurs.dao.StaffDao;
import ru.maks.kurs.dao.CurseDao;
import ru.maks.kurs.entity.Staff;
import ru.maks.kurs.entity.Staff;
import ru.maks.kurs.entity.Curse;
import ru.maks.kurs.web.dto.StaffDto;
import ru.maks.kurs.web.dto.StaffDto;
import ru.maks.kurs.web.dto.CurseDto;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(uses = StaffMapper.class)
public interface StaffMapper {

	Staff toStaff(StaffDto staffDto, @Context CurseDao curseDao);

	StaffDto toStaffDto(Staff staff);

//	default Staff getStaff(String staff, @Context CurseDao curseDao) {
//		return curseDao.findByTitle(staff).orElseThrow(
//				() -> new NoSuchElementException("There isn't manufacturer with name " + staff));
//	}

//	default String getStaff(Staff staff) {
//		return staff.getTitle();
//	}

	default Set<Curse> curseDtoSetToCurseSet(Set<CurseDto> curses, @Context CurseDao curseDao) {
		return curses.stream().map(c -> curseDao.findById(c.getId())
						.orElseThrow(
								() -> new NoSuchElementException("There isn't curse with id + " + c.getId()))
				)
				.collect(Collectors.toSet());
	}
	
}
