import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    // 0,0~ 9,9까지에 1을 붙이기 2를 붙이기 3을 붙이기 4를 붙이기 5를 붙이기 완전탐색
    // 진행 되는 xy가 x/10 x%10

    // 맵
    static boolean[][] map;
    // 최솟값
    static int min;
    // 1의 숫자
    static int aa;
    // 색종이 숫자 빼고 더할 배열
    static int[] aa2 = {0, 1, 4, 9, 16, 25};

    // 색종이 개수
    static int[] pQ;

    // 색종이를 붙일 수 있는지 여부 판단 메소드
    static boolean isOk(int x, int y, int n) {
        if(x+n > 10 || y+n > 10) return false;
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (!map[i][j]) return false;
            }
        }
        return true;
    }

    // 맵 색종이 붙이기 && 떼기
    static void cMap(int x, int y, int n, boolean cc) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                map[i][j] = cc;
            }
        }
    }

    // dfs
    // 브루트포스 + 백트래킹
    static void dfs(int n, int cnt) {

        // 이미 최소값 보다 더 붙였으면, 백트레킹 가지치기
        if (cnt >= min) return;

        // 완전 탐색 했다면
        if (n == 100) {
            // 남아있는 1이 없다면
            if (aa == 0) {
                min = Math.min(min, cnt);
            }
            return;
        }
        // 좌표값 모듈러로 구하기
        int x = n / 10;
        int y = n % 10;
        // 해당 좌표가 1이 아니라면
        if (!map[x][y]) dfs(n + 1, cnt);

            // 해당좌표에 색종이를 붙여야 된다면
        else {
            // 큰 것 부터 붙이는게 효율적일 가능성이 높으므로
            for (int i = 5; i >= 1; i--) {
                // 해당 크기의 색종이 붙일 수 있고, 남아있는 색종이가 있다면
                if (isOk(x, y, i) && pQ[i] > 0) {
                    // 남아있는 1 차감
                    aa -= aa2[i];
                    // 맵변경
                    cMap(x, y, i, false);
                    // 색종이 숫자 차감
                    pQ[i]--;
                    // 다음 위치 사이즈만큼 진행
                    dfs(n + i, cnt + 1);
                    // 맵복구
                    cMap(x, y, i, true);
                    // 색종이 숫자 복구
                    pQ[i]++;
                    //남아있는 1 복구
                    aa += aa2[i];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력

        // TC
        // 테스트케이스 순회

        // 최솟값 초기화
        min = Integer.MAX_VALUE;
        // 색종이 초기화
        pQ = new int[]{0, 5, 5, 5, 5, 5};
        // 맵생성
        map = new boolean[10][10];
        // 1의 개수
        aa = 0;
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                if (st.nextToken().equals("1")) {
                    map[i][j] = true;
                    // 1개수 증가
                    aa++;
                }
            }
        }
        // dfs 진행
        dfs(0, 0);
        // 한번도 min 값이 갱신되지 않았다면 -1
        if (min == Integer.MAX_VALUE) min = -1;

        System.out.println(min);
    }
}