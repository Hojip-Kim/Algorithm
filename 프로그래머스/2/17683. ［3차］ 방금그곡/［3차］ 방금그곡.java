import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";

        Map<String, List<String>> musicMap = new HashMap<>();

        Map<String, Long> timeMap = new HashMap<>();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime startLocalTime;
        LocalTime endLocalTime;
        Duration duration;
        String[] musicNameArr = new String[musicinfos.length];

        int index = 0;

        for(String musicinfo : musicinfos) {
            String[] infos = musicinfo.split(",");
            String startTime = infos[0];
            String endTime = infos[1];
            String musicTitle = infos[2];
            String sheetInfo = infos[3];

            startLocalTime = LocalTime.parse(startTime, dateFormat);
            endLocalTime = LocalTime.parse(endTime, dateFormat);
            duration = Duration.between(startLocalTime, endLocalTime);
            long playTime = duration.getSeconds() / 60;

            List<String> sheetList = sheetToList(sheetInfo);

            musicMap.put(musicTitle, sheetList);
            timeMap.put(musicTitle, playTime);

            musicNameArr[index++] = musicTitle;
        }

        List<String> givenSheetList = sheetToList(m);

        StringBuilder sbOrigin = new StringBuilder();
        for (int i = 0; i < givenSheetList.size(); i++) {
            sbOrigin.append(givenSheetList.get(i));
        }

        long maxTime = -1;
        for(int i = 0; i < musicNameArr.length; i++) {
            String musicName = musicNameArr[i];

            List<String> sheet = musicMap.get(musicName);
            Long time = timeMap.get(musicName);

            long loopNum = time / sheet.size();
            long leftTime = time % sheet.size();

            StringBuilder sbNext = new StringBuilder();
            for (int j = 0; j < loopNum; j++) {
                for (int k = 0; k < sheet.size(); k++) {
                    sbNext.append(sheet.get(k));
                }
            }
            for (int j = 0; j < leftTime; j++) {
                sbNext.append(sheet.get(j));
            }

            if(sbNext.toString().contains(sbOrigin.toString())) {
                if(time > maxTime){
                    maxTime = Math.max(maxTime, time);
                    answer = musicName;
                }
            }

        }
        if(answer.equals("")) {
            return "(None)";
        }

        return answer;
    }

    private static List<String> sheetToList(String sheet) {
        
        List<String> list = new ArrayList<>();

        for(int i = 0; i < sheet.length()-1; i++){
            char character = sheet.charAt(i);
            char afterCharacter = sheet.charAt(i+1);
            if(character == '#') {
                continue;
            }
            if(afterCharacter == '#') {
                list.add(String.valueOf(character).toLowerCase());
            }else{
                list.add(String.valueOf(character));
            }
        }

        String lastCharacter = String.valueOf(sheet.charAt(sheet.length()-1));

        if(!lastCharacter.equals("#")) {
            list.add(lastCharacter);
        }
        return list;
    }

}