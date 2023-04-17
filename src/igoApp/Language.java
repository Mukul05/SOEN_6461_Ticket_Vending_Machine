package igoApp;

public abstract class Language {
	private static Language language;

	public static Language getInstance() {

		if (language == null) {
			language = EnglishLanguage.getInstance();
		}

		return language;
	}

	public static void setLanguageType(LanguageEnum languageEnum) {
		if (languageEnum == LanguageEnum.ENGLISH) {
			language = EnglishLanguage.getInstance();
		} else if (languageEnum == LanguageEnum.FRENCH) {
			language = FrenchLanguage.getInstance();
		}
	}

	public abstract String getTextString(String property);

}
