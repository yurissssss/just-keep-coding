package ch14.exam;

public class ThreadExample {
    public static void main(String[] args) {
        //두 스레드 동시 운영

        Thread thread1 = new MovieThread();
        thread1.start();

        Thread thread2 = new Thread(new MusicRunnable());
        thread2.start();
    }
}

/**
 * 동영상을 재생합니다.
 * 음악을 재생합니다.
 * 음악을 재생합니다.
 * 동영상을 재생합니다.
 * 음악을 재생합니다.
 * 음악을 재생합니다.
 * 동영상을 재생합니다.
 * 음악을 재생합니다.
 * 음악을 재생합니다.
 */