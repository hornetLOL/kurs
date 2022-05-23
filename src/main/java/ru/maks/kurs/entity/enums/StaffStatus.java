package ru.maks.kurs.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum StaffStatus {
	active("active"), not_active("not_active");

	private final String title;
}
