import java.util.Scanner;

public class Solution {

    static int N;
    static int M;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Point {
        int x;
        int y;
        char direction;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        // 테스트케이스

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            // 높이 너비
            N = sc.nextInt();
            M = sc.nextInt();
            Point point = new Point();

            map = new char[N][M];


            // 맵 입력
            for (int i = 0; i < N; i++) {
                String s = sc.next();
                for (int j = 0; j < M; j++) {
                    map[i][j] = s.charAt(j);

                    
                    // 초기 시작 위치 잡기
                    if (map[i][j] == '<') {
                        point.x = i;
                        point.y = j;
                        point.direction = '<';
                    }
                    if (map[i][j] == '>') {
                        point.x = i;
                        point.y = j;
                        point.direction = '>';
                    }
                    if (map[i][j] == '^') {
                        point.x = i;
                        point.y = j;
                        point.direction = '^';
                    }
                    if (map[i][j] == 'v') {
                        point.x = i;
                        point.y = j;
                        point.direction = 'v';
                    }
                }
            }

            int C = sc.nextInt();
            String next = sc.next();
            for (int i = 0; i < C; i++) {
                // 커맨드 수행
                switch (next.charAt(i)) {
                    case 'U':
                        if (point.x - 1 >= 0 && map[point.x - 1][point.y] == '.') {
                            map[point.x][point.y] = '.';

                            point.x--;
                        }
                        point.direction = '^';
                        map[point.x][point.y] = '^';
                        break;
                    case 'D':
                        if (point.x + 1 < N && map[point.x + 1][point.y] == '.') {
                            map[point.x][point.y] = '.';
                            point.x++;
                        }
                        point.direction = 'v';
                        map[point.x][point.y] = 'v';
                        break;
                    case 'L':

                        if (point.y - 1 >= 0 && map[point.x][point.y-1] == '.') {
                            map[point.x][point.y] = '.';
                            point.y--;
                        }
                        point.direction = '<';
                        map[point.x][point.y] = '<';
                        break;

                    case 'R':

                        if (point.y + 1 < M && map[point.x][point.y+1] == '.') {
                            map[point.x][point.y] = '.';
                            point.y++;
                        }
                        point.direction = '>';
                        map[point.x][point.y] = '>';
                        break;
                    case 'S':
                        int dx =0;
                        int dy =0;
                        switch (point.direction) {

                            case '>' :
                                dy = 1;
                                break;
                            case '<' :
                                dy = -1;
                                break;
                            case '^' :
                                dx = -1;
                                break;
                            case 'v' :
                                dx = 1;
                                break;
                            default:
                                break;

                        }
                        int nx = point.x;
                        int ny = point.y;
                        while (true) {
                            nx += dx;
                            ny += dy;

                            if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == '#') {
                                break;
                            } else if (map[nx][ny] == '*') {
                                map[nx][ny] = '.';
                                break;
                            }
                        }
                        break;
                }
            }

            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }

        // 커맨드 입력 하나씩 처리
        System.out.println(sb);
    }
}