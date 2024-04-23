import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// Định nghĩa cấu trúc dữ liệu để biểu diễn trạng thái của bài toán
class State {
    int x, y; // Dung tích của bình 1 và bình 2
    State parent; // Trạng thái cha

    public State(int x, int y, State parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        State other = (State) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class WaterJugProblem {

    // Hàm kiểm tra trạng thái hợp lệ của bình nước
    static boolean isValid(State s, int jug1, int jug2) {
        return s.x >= 0 && s.y >= 0 && s.x <= jug1 && s.y <= jug2;
    }

    // Hàm tạo ra các trạng thái kế tiếp từ trạng thái hiện tại
    static Set<State> getNextStates(State currentState, int jug1, int jug2) {
        Set<State> nextStates = new HashSet<>();

        // Đổ nước từ bình 1 sang bình 2
        nextStates.add(new State(Math.max(0, currentState.x - (jug2 - currentState.y)), Math.min(jug2, currentState.y + currentState.x), currentState));
        // Đổ nước từ bình 2 sang bình 1
        nextStates.add(new State(Math.min(jug1, currentState.x + currentState.y), Math.max(0, currentState.y - (jug1 - currentState.x)), currentState));
        // Đổ nước ra khỏi bình 1
        nextStates.add(new State(0, currentState.y, currentState));
        // Đổ nước ra khỏi bình 2
        nextStates.add(new State(currentState.x, 0, currentState));
        // Đổ nước vào bình 1 đầy
        nextStates.add(new State(jug1, currentState.y, currentState));
        // Đổ nước vào bình 2 đầy
        nextStates.add(new State(currentState.x, jug2, currentState));

        return nextStates;
    }

    // Hàm kiểm tra trạng thái mục tiêu
    static boolean isGoalState(State s, int target) {
        return s.x == target || s.y == target;
    }

    // Hàm thực hiện thuật toán BFS
// Hàm thực hiện thuật toán BFS
static void BFS(State initialState, int jug1, int jug2, int target) {
    Queue<State> queue = new LinkedList<>();
    Set<State> visited = new HashSet<>();
    Set<State> enqueued = new HashSet<>(); // Thêm một Set để theo dõi các trạng thái đã được thêm vào hàng đợi
    queue.add(initialState);
    enqueued.add(initialState); // Thêm trạng thái ban đầu vào Set enqueued
    boolean found = false;
    int step = 0; // Khởi tạo biến step và gán giá trị ban đầu là 1

    System.out.println("Starting BFS algorithm...");
    System.out.println("Initial state: " + initialState);

    State currentState = null; // Khai báo currentState ở đây

    while (!queue.isEmpty()) {
        System.out.println("Step " + step++ + ":");
        currentState = queue.poll();
        System.out.println("Current state: " + currentState);

        // Kiểm tra xem trạng thái hiện tại có phải là trạng thái mục tiêu không
        if (isGoalState(currentState, target)) {
            System.out.println("Found solution:");
            printSolution(currentState);
            found = true;
            break;
        }

        // Thêm trạng thái hiện tại vào tập đã thăm (CLOSED)
        

        // Tạo ra các trạng thái kế tiếp và kiểm tra
        Set<State> nextStates = getNextStates(currentState, jug1, jug2);
        for (State nextState : nextStates) {
            // Trước khi thêm vào hàng đợi, kiểm tra xem trạng thái đã được thêm vào hàng đợi hay chưa
            if (!enqueued.contains(nextState)) {
                queue.add(nextState);
                enqueued.add(nextState);
                System.out.println("Adding to OPEN: " + nextState);
            }
        }

        System.out.println("Current OPEN: " + queue);
        System.out.println("Current CLOSED: " + visited);
        visited.add(currentState);
        System.out.println("Moving state to CLOSED: " + currentState);
        System.out.println("----------------------------------------------------------------");

        
    }
    if (!found) {
        System.out.println("No solution found.");
    }
}
    // Hàm in ra không gian trạng thái của bài toán
    static void printStateSpace(Queue<State> queue, Set<State> visited) {
        System.out.println("OPEN:");
        for (State state : queue) {
            System.out.println(state);
        }
        System.out.println("CLOSED:");
        for (State state : visited) {
            System.out.println(state);
        }
    }

    // Hàm in ra các bước để đạt được trạng thái mục tiêu
    static void printSolution(State goalState) {
        System.out.println("Steps to achieve the target:");
        State currentState = goalState;
        LinkedList<String> steps = new LinkedList<>();
        while (currentState != null) {
            steps.addFirst("(" + currentState.x + ", " + currentState.y + ")");
            currentState = currentState.parent;
        }
        for (String step : steps) {
            System.out.println(step);
        }
    }

    public static void main(String[] args) {
        int jug1Capacity = 4; // Dung tích của bình 1
        int jug2Capacity = 3; // Dung tích của bình 2
        int targetVolume = 2; // Dung tích cần đạt được

        State initialState = new State(0, 0, null); //
        BFS(initialState, jug1Capacity, jug2Capacity, targetVolume);
    }
    }