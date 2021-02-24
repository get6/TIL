package hash;

import java.util.*;
import java.util.stream.Collectors;

public class Test4 {

    class Song {
        String genre;
        int play;
        int originIndex;

        Song(String genre, int play, int originIndex) {
            this.genre = genre;
            this.play = play;
            this.originIndex = originIndex;
        }

        public String getGenre() {
            return genre;
        }
    }

    // TODO: 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때,
    // 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
    // 한 장르당 최대 두 개씩 들어감. 하나면 하나만
    public int[] solution(String[] genres, int[] plays) {
        // TODO: answer 배열에 장르별로 최대 두 개씩 꺼내서 재생 횟수 순으로 각 index 순서로 넣는다.
        // answer은 재생횟수별 순서가 기존 index 순서로 통합적으로 나열된 배열 반환
        /**
         * 1. 장르별로 분류?
         * 1.1 분류하면 index가 엉킬 가능성
         * 1.2 분류시 c
         */
        List<String> genreList = Arrays.stream(genres).distinct().collect(Collectors.toList());
        HashMap<String, List<Song>> hm = new HashMap<>();
        // Song 객체 목록
        List<Song> list = new ArrayList<>();
        // Song 생성, 더하기
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            list.add(new Song(genre, play, i));
        }

        for (int i = 0; i < genreList.size(); i++) {
            String genre = genreList.get(i);
            hm.put(genre, list.stream().filter(song -> song.getGenre().equals(genre)).collect(Collectors.toList()));
        }
        System.out.println(hm.toString());

        int[] answer = {};
        return answer;
    }

    public static void main(String[] args) {
        Test4 test = new Test4();
        test.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
    }
}
