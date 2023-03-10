
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 특정 위치에서 시도할 수 있는 연산 3가지
// 1칸 뒤로가기(1초), 1칸 앞으로 가기(1초), 2배 앞으로 가기(0초)
// 모든 경우 시도해보고, N이 K가 되면 종료

// 수빈이의 위치와 소요시간을 우선순위큐에 넣기 (소요시간이 가장 적은 위치가 맨 앞에 위치하도록)
// 우선순위큐는 값을 많이 넣지 않을 때 사용하기
// 현재까지 각 위치를 도달하는데 걸린 최소 시간 저장해놓고, 그 최솟값보다 작은 값일 때만 큐에 넣기

public class Main_13549 { // 13549. 숨바꼭질 3
	
	static int N; // 수빈이의 위치
	static int K; // 동생의 위치
	static int time; // 소요시간
	static int[] min = new int[100001]; // 각 위치까지의 최소 시간 저장
	static PriorityQueue<Integer[]> queue; // { 위치, 시간 }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
		K = Integer.parseInt(st.nextToken()); // 동생의 위치
		Arrays.fill(min, Integer.MAX_VALUE);
		queue = new PriorityQueue<Integer[]>(new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				return o1[1] - o2[1];
			}
		});
		queue.offer(new Integer[] { N, 0 }); // 현재 수빈이의 위치와 시간(0)
		
		System.out.println(move());
		
	}
	
	public static int move() {
		while (true) {
			Integer[] cur = queue.poll();
			if (cur[0] == K) { return cur[1]; }
			
			if (cur[0] >= 0 && cur[0] <= 100000) { // 현 위치가 범위 이내
				if (min[cur[0]] > cur[1]) {
					min[cur[0]] = cur[1];
					queue.offer(new Integer[] { cur[0] * 2, cur[1] }); // 순간이동 (0초)
					queue.offer(new Integer[] { cur[0] + 1, cur[1] + 1 }); // 앞으로 한 칸
					queue.offer(new Integer[] { cur[0] - 1, cur[1] + 1 }); // 뒤로 한 칸
				}
			}
		}
	}
}
