import java.util.*;

class State {
    int b1; // Dung lượng nước trong bình 1
    int b2; // Dung lượng nước trong bình 2
    State parent; // Trạng thái cha

    public State(int b1, int b2) {
        this.b1 = b1;
        this.b2 = b2;
    }

    // Override phương thức equals để so sánh trạng thái
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        State state = (State) obj;
        return b1 == state.b1 && b2 == state.b2;
    }

    // Override phương thức hashCode để sử dụng trong việc sử dụng HashSet
    @Override
    public int hashCode() {
        return Objects.hash(b1, b2);
    }
}

public class TwoWaterJugsBFS {
    static final int b1Capacity = 4;
    static final int b2Capacity = 3;
    static final int targetAmount = 2;

    // Hàm kiểm tra trạng thái hợp lệ của trạng thái bình nước
    static boolean isValidState(State state) {
        return state.b1 >= 0 && state.b2 >= 0 && state.b1 <= b1Capacity && state.b2 <= b2Capacity;
    }

    // Hàm tạo ra các trạng thái kế tiếp từ trạng thái hiện tại
    static List<State> getNextStates(State currentState) {
        List<State> nextStates = new ArrayList<>();

        // Đổ nước từ bình 1 sang bình 2
        nextStates.add(new State(Math.max(0, currentState.b1 - (b2Capacity - currentState.b2)), Math.min(b2Capacity, currentState.b1 + currentState.b2)));

        // Đổ nước từ bình 2 sang bình 1
        nextStates.add(new State(Math.min(b1Capacity, currentState.b1 + currentState.b2), Math.max(0, currentState.b2 - (b1Capacity - currentState.b1))));

        // Đổ đầy bình 1
        nextStates.add(new State(b1Capacity, currentState.b2));

        // Đổ đầy bình 2
        nextStates.add(new State(currentState.b1, b2Capacity));

        // Đổ hết nước từ bình 1 ra
        nextStates.add(new State(0, currentState.b2));

        // Đổ hết nước từ bình 2 ra
        nextStates.add(new State(currentState.b1, 0));

        return nextStates;
    }

    // Hàm kiểm tra trạng thái mục tiêu
    static boolean isGoalState(State state) {
        return state.b1 == targetAmount || state.b2 == targetAmount;
    }

    // Hàm thực hiện thuật toán BFS
    static void BFS(State initialState) {
        Queue<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();
        List<State> closed = new ArrayList<>(); // Tập CLOSED

        queue.add(initialState);
        visited.add(initialState);

        while (!queue.isEmpty()) {
            State currentState = queue.poll();
            System.out.println("Trạng thái đang xét: " + currentState.b1 + " " + currentState.b2);
            closed.add(currentState); // Thêm trạng thái đang xét vào tập CLOSED

            if (isGoalState(currentState)) {
                System.out.println("Tìm thấy giải pháp:");
                printPath(currentState);
                return;
            }

            List<State> nextStates = getNextStates(currentState);
            for (State nextState : nextStates) {
                if (isValidState(nextState) && !visited.contains(nextState)) {
                    queue.add(nextState);
                    visited.add(nextState);
                    nextState.parent = currentState;
                    System.out.println("Thao tác: " + currentState.b1 + "," + currentState.b2 + " -> " + nextState.b1 + "," + nextState.b2);
                }
            }

            // Hiển thị tập OPEN và CLOSED
            System.out.println("Tập OPEN:");
            for (State s : queue) {
                System.out.print("(" + s.b1 + "," + s.b2 + ") ");
            }
            System.out.println();
            System.out.println("Tập CLOSED:");
            for (State s : closed) {
                System.out.print("(" + s.b1 + "," + s.b2 + ") ");
            }
            System.out.println();
            System.out.println("----------------------------------------------------------------");

        }

        System.out.println("Không tìm thấy giải pháp.");
    }

    // Hàm in ra đường đi từ trạng thái ban đầu đến trạng thái mục tiêu
    static void printPath(State state) {
        Stack<State> path = new Stack<>();
        while (state != null) {
            path.push(state);
            state = state.parent;
        }
        while (!path.isEmpty()) {
            State currentState = path.pop();
            System.out.println("Trạng thái: " + currentState.b1 + " " + currentState.b2);
        }
    }

    public static void main(String[] args) {
        State initialState = new State(0, 0);
        BFS(initialState);
    }
}
