package by.itClass.model.enums;

import by.itClass.constants.Constants;

public class EnumManager {
	
	public static SectionConf getKindSectionConf(String section) {
		if (section == null) {
			section = Constants.SECTION_TODAY;
		}
		try {
			return SectionConf.valueOf(section.toUpperCase());
		} catch (IllegalArgumentException e) {
			return SectionConf.TODAY;
		}
	}
	
	public static Operations getKindOperation(String operation) {
		return Operations.valueOf(operation.toUpperCase());
	}
	
}
