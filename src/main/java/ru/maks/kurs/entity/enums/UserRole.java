package ru.maks.kurs.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserRole {
	ADMIN("Админ"),
	TEACHER("Учитель"),
	STUDENT("Ученик");

	private final String title;
}
