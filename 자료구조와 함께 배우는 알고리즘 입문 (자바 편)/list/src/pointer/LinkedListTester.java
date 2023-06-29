package pointer;

import domain.Data;
import domain.Menu;

import java.util.Scanner;

public class LinkedListTester {

    static Scanner stdIn = new Scanner(System.in);
    static final int NO = 1;
    static final int NAME = 2;

    static Menu selectMenu() {
        int key;

        do {
            for (Menu m : Menu.values()) {
                System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());

                if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.TERMINATE.ordinal()) {
                    System.out.println();
                }
            }

            System.out.print(" : ");
            key = stdIn.nextInt();
        } while (key < Menu.ADD_FIRST.ordinal() || key > Menu.TERMINATE.ordinal());

        return Menu.menuAt(key);
    }

    static void scanData(String guide, Data data, int sw) {
        System.out.println(guide + "할 데이터를 입력하세요.");

        if ((sw & NO) == NO) {
            System.out.print("번호: ");
            data.setNo(stdIn.nextInt());
        }
        if ((sw & NAME) == NAME) {
            System.out.print("이름: ");
            data.setName(stdIn.next());
        }
    }

    public static void main(String[] args) {
        Menu menu;
        Data data;
        Data ptr;
        Data temp = new Data();

        LinkedList<Data> list = new LinkedList<>();

        do {
            switch (menu = selectMenu()) {

                case ADD_FIRST :                           // 머리노드 삽입
                    data = new Data();
                    scanData("머리에 삽입", data, NO | NAME);
                    list.addFirst(data);
                    break;

                case ADD_LAST :                           // 꼬리 노드 삽입
                    data = new Data();
                    scanData("꼬리에 삽입", data, NO | NAME);
                    list.addLast(data);
                    break;

                case RMV_FIRST :                          // 머리 노드 삭제
                    list.removeFirst();
                    break;

                case RMV_LAST :                           // 꼬리 노드 삭제
                    list.removeLast();
                    break;

                case RMV_CRNT :                           // 선택 노드 삭제
                    list.removeCurrentNode();
                    break;

                case SEARCH_NO :                           // 회원 번호 검색
                    scanData("검색", temp, NO);
                    ptr = list.search(temp, Data.NO_ORDER);
                    if (ptr == null)
                        System.out.println("그 번호의 데이터가 없습니다.");
                    else
                        System.out.println("검색 성공: " + ptr);
                    break;

                case SEARCH_NAME :                       // 이름 검색
                    scanData("검색", temp, NAME);
                    ptr = list.search(temp, Data.NAME_ORDER);
                    if (ptr == null)
                        System.out.println("그 이름의 데이터가 없습니다.");
                    else
                        System.out.println("검색 성공: " + ptr);
                    break;

                case NEXT :                                   // 선택 노드를 뒤쪽으로 진행
                    list.next();
                    break;

                case PRINT_CRNT :                             // 선택 노드의 데이터를 표시
                    list.printCurrentNode();
                    break;

                case DUMP :                                   // 전체 노드를 리스트 순서대로 표시
                    list.dump();
                    break;

                case CLEAR :                                  // 전체 노드를 삭제
                    list.clear();
                    break;
            }
        } while (menu != Menu.TERMINATE);
    }
}
