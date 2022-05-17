package ru.maks.kurs.web.dto.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import ru.maks.kurs.entity.Student;
import ru.maks.kurs.web.dto.StudentDto;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface StudentMapper {
    Student toStudent(StudentDto studentDto);

    StudentDto toStudentDto(Student student);

//    default Manufacturer getManufacturer(String manufacturer, @Context ManufacturerDao manufacturerDao) {
//        return manufacturerDao.findByName(manufacturer).orElseThrow(
//                () -> new NoSuchElementException("There isn't manufacturer with name " + manufacturer));
//    }
//
//    default String getManufacturer(Manufacturer manufacturer) {
//        return manufacturer.getName();
//    }
//
//    default Set<Category> categoryDtoSetToCategorySet(Set<CategoryDto> categories, @Context CategoryDao categoryDao) {
//        return categories.stream().map(c -> categoryDao.findById(c.getId())
//                        .orElseThrow(
//                                () -> new NoSuchElementException("There isn't category with id + " + c.getId()))
//                )
//                .collect(Collectors.toSet());
//    }

}