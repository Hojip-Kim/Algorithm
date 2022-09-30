import java.time.LocalDate;
import java.time.temporal.ChronoField;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] arr = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        LocalDate Calender = LocalDate.of(2016, a, b);

        int month_Day_First = Calender.get(ChronoField.DAY_OF_WEEK); // 1이면 월요일, 7이면 일요일

        answer = arr[month_Day_First-1];


        return answer;
    }
}