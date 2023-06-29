package domain;

public enum Menu {
    ADD_FIRST(  "머리 노드 삽입"),
    ADD_LAST(   "꼬리 노드 삽입"),
    RMV_FIRST(  "머리 노드 삭제"),
    RMV_LAST(   "꼬리 노드 삭제"),
    RMV_CRNT(   "선택 노드 삭제"),
    CLEAR(      "전체 노드 삭제"),
    SEARCH_NO(  "번호 검색"),
    SEARCH_NAME("이름 검색"),
    NEXT(       "선택 노드를 하나 뒤쪽으로 진행"),
    PRINT_CRNT( "선택 노드 표시"),
    DUMP(       "전체 노드 표시"),
    TERMINATE(  "종료");

    private final String message;

    Menu(String message) {
        this.message = message;
    }

    //순서가 idx인 열거를 반환
    public static Menu menuAt(int idx) {
        for (Menu m : Menu.values()) {
            if (m.ordinal() == idx) {
                return m;
            }
        }

        return null;
    }

    public String getMessage() {
        return message;
    }
}
