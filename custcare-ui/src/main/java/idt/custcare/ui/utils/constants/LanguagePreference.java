package idt.custcare.ui.utils.constants;

/**
 * Represents language preferences.
 */
public enum LanguagePreference {
    ENGLISH("en-US"),
    SPANISH("es-US"),
    FRENCH("fr-US");

    private final String language;

    /**
     * Private constructor.
     *
     * @param language as String.
     */
    LanguagePreference(final String language) {
        this.language = language;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String toString() {
        return language;
    }
}
