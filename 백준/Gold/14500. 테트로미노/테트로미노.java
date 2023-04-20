import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    // 맵의 크기와 맵
    static int N;
    static int M;
    static int[][] map;

    // 블럭의 정보를 모두 담고 있을 list
    static List<boolean[][]> list = new ArrayList<>();

    // 최대값
    static int max = 0;

    // 블럭의 기본 정보
    static boolean[][] square = {{true, true}, {true, true}};
    static boolean[][] l = {{true, true, true, true}};
    static boolean[][] L = {{true, true, true}, {true, false, false}};
    static boolean[][] rl = {{false, true, true}, {true, true, false}};
    static boolean[][] h = {{true, true, true}, {false, true, false}};

    // 대칭 메소드
    static void symmetry(boolean[][] block) {
        boolean[][] tempBlock = new boolean[block.length][block[0].length];
        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < block[i].length; j++) {
                tempBlock[i][j] = block[i][block[i].length - j - 1];
            }
        }
        list.add(tempBlock);
        rotate(0, tempBlock);
    }

    // 회전 메소드
    static void rotate(int n, boolean[][] block) {
        if (n == 3) return;

        boolean[][] tempBlock = new boolean[block[0].length][block.length];
        for (int i = 0; i < tempBlock.length; i++) {
            for (int j = 0; j < tempBlock[i].length; j++) {
                tempBlock[i][j] = block[tempBlock[i].length - j - 1][i];
            }
        }
        list.add(tempBlock);
        rotate(n + 1, tempBlock);
    }

    // 탐색 메소드
    static void search(int x, int y, boolean[][] block) {
        int temp = 0;
        for (int i = x; i < x + block.length; i++) {
            for (int j = y; j < y + block[i-x].length; j++) {
                if (!block[i - x][j - y]) continue;
                if (i < 0 || j < 0 || i >= N || j >= M) return;
                temp += map[i][j];
            }
        }
        max = max > temp ? max : temp;
    }

    public static void main(String[] args) throws IOException {

        // 입력 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 입력 끝

        // 기본 블럭 리스트에 입력시키기
        list.add(square);
        list.add(l);
        list.add(L);
        list.add(rl);
        list.add(h);

        // 회전 대칭 시킨 것 리스트에 넣기 정사각형 제외
        for (int i = 1; i < 5; i++) {
            rotate(0, list.get(i));
            symmetry(list.get(i));
        }

        // 탐색하기 시작하기
        // 회전 대칭 포함에 모든 블록 저장된 것 탐색
        for (boolean[][] b : list) {

            // 완전탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    // 해당 위치에 블럭 넣어보기
                    search(i, j, b);
                }
            }
        }
        System.out.println(max);
    }
}