package study.haxagonal.library.application.domain;


/*
 * 카테고리 타입 Enum
 * 추후 카테고리 값에 따라 비즈니스 로직에 영향을 줄 수 있다고 판단해, Domain 패키지에 위치
 */
public enum Category {

    FICTION,
    NON_FICTION,
    SCIENCE,
    HISTORY,
    FANTASY;

    public static boolean isValid(String category) {
        for (Category c : Category.values()) {
            if (c.name().equalsIgnoreCase(category)) {
                return true;
            }
        }
        return false;
    }

}
