package dongyoon;

import java.util.*;

class Song implements Comparable<Song> {
    int idx, plays; // 노래 고유 번호, 재생 횟수
    
    public Song(int idx, int plays) {
        this.idx = idx;
        this.plays = plays;
    }
    
    @Override
    public int compareTo(Song s) {
        if (this.plays == s.plays) return this.idx - s.idx; // 고유 번호 오름차순
        return s.plays - this.plays; // 재생 횟수 내림차순
    }
}

class Genre implements Comparable<Genre> {
    String name; // 장르명
    int totalCount = 0; // 장르 총 재생 횟수
    PriorityQueue<Song> songList = new PriorityQueue<>();
    
    public Genre(String name) {
        this.name = name;
    }
    
    public void addTotalCount(int totalCount) {
        this.totalCount += totalCount;
    }
    
    public void addSong(Song s) {
        this.songList.add(s);
    }
    
    public List<Integer> pollSong() {
        List<Integer> arr = new ArrayList<>();
        int cnt = 0;
        
        while(!songList.isEmpty() && ++cnt <= 2) {
            Song s = songList.poll();
            arr.add(s.idx);
        }
        
        return arr;
    }
    
    @Override
    public int compareTo(Genre g) {
        return g.totalCount - this.totalCount; // 총 재생 횟수 내림차순
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Genre> map = new HashMap<>(); // 장르명, 장르 정보
        
        for (int i = 0; i < genres.length; i++) {
            if (map.get(genres[i]) == null) {
                Genre genre = new Genre(genres[i]);
                genre.addTotalCount(plays[i]);
                Song song = new Song(i, plays[i]);
                genre.addSong(song);
                map.put(genres[i], genre);
            } else {
                Genre genre = map.get(genres[i]);
                genre.addTotalCount(plays[i]);
                Song song = new Song(i, plays[i]);
                genre.addSong(song);              
            }
        }
        
        PriorityQueue<Genre> genrePQ = new PriorityQueue<>();
      
        for (Genre g : map.values()) 
            genrePQ.add(g);
        
        while(!genrePQ.isEmpty()) {
            Genre g = genrePQ.poll();
            
            List<Integer> temp = g.pollSong();
            
            answer.addAll(temp);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}