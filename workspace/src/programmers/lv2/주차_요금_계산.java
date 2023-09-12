//https://velog.io/@roycewon/Java%EB%A1%9C-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A3%BC%EC%B0%A8-%EC%9A%94%EA%B8%88-%EA%B3%84%EC%82%B0

package programmers.lv2;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 주차_요금_계산 {

    private static Map<String, Car> carMap = new HashMap<>();

    public static int[] solution(int[] fees, String[] records) {
        for (String record : records) {
            String[] recordInfo = record.split(" ");
            String time = recordInfo[0];
            String number = recordInfo[1];
            String action = recordInfo[2]; // IN, OUT

            Car car = carMap.getOrDefault(number, new Car(number, 0, false));
            if (action.equals("IN")) {
                car.parking(time);
            } else {
                car.exit(time);
            }

            carMap.put(number, car); //변경된 상태 저장
        }

        List<Car> cars = new ArrayList<>();
        for (String number : carMap.keySet()) {
            cars.add(carMap.get(number)); //정렬을 위한 리스트로 변환
        }

        Collections.sort(cars);

        int[] answer = new int[cars.size()];
        int i = 0;
        for (Car car : cars) {
            car.calculateParkingFee(fees);
            answer[i++] = car.parkingFee;
        }

        return answer;
    }

    static class Car implements Comparable<Car> {
        String number;
        int parkingAmount;
        LocalTime parkedAt;
        boolean isParking;

        int parkingFee; //총 주차요금

        public Car(String number, int parkingAmount, boolean isParking) {
            this.number = number;
            this.parkingAmount = parkingAmount;
            this.isParking = isParking;
        }

        public void parking(String time) { //주차
            isParking = true;
            parkedAt = LocalTime.parse(time);
        }

        public void exit(String time) { //출차
            isParking = false;
            LocalTime exitAt = LocalTime.parse(time);
            parkingAmount += (int) Duration.between(parkedAt, exitAt).toMinutes();
        }

        public void calculateParkingFee(int[] fees) { //요금 계산
            int basicTime = fees[0];
            int basicPrice = fees[1];
            int unitTime = fees[2];
            int unitPrice = fees[3];

            if (isParking) {
                exit("23:59");
            }

            parkingFee += basicPrice;
            parkingAmount -= basicTime;

            if (parkingAmount > 0) {
                int units = parkingAmount / unitTime;
                parkingFee += units * unitPrice;
                if (parkingAmount % unitTime != 0) {
                    parkingFee += unitPrice;
                }
            }
        }

        @Override
        public int compareTo(Car o) {
            return this.number.compareTo(o.number);
        }
    }

    public static void main(String[] args) {
        //[14600, 34400, 5000]
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(Arrays.toString(solution(fees, records)));

        //[0, 591]
        carMap = new HashMap<>();
        fees = new int[]{120, 0, 60, 591};
        records = new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
        System.out.println(Arrays.toString(solution(fees, records)));

        //[14841]
        carMap = new HashMap<>();
        fees = new int[]{1, 461, 1, 10};
        records = new String[]{"00:00 1234 IN"};
        System.out.println(Arrays.toString(solution(fees, records)));
    }
}
