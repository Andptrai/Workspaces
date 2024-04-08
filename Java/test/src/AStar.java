import java.util.*;

class State {
    int[][] board;
    int cost;
    int x;
    int y;
    State parent;

    public State(int[][] board, int x, int y, int newX, int newY, int cost, State parent) {
        this.board = new int[board.length][];
        for (int i = 0; i < board.length; i++) {
            this.board[i] = board[i].clone();
        }
        this.board[x][y] = this.board[newX][newY];
        this.board[newX][newY] = 0;
        this.cost = cost;
        this.x = newX;
        this.y = newY;
        this.parent = parent;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof State)) return false;
        State state = (State) obj;
        for (int i = 0; i < board.length; i++) {
            if (!Arrays.equals(board[i], state.board[i])) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(board);
    }
}

public class AStar {
    PriorityQueue<State> open;
    Set<State> closed;
    int[][] goal;
    int[][] start;

    public AStar(int[][] start, int[][] goal) {
        this.start = start;
        this.goal = goal;
        this.open = new PriorityQueue<>(Comparator.comparingInt(s -> s.cost + heuristic(s)));
        this.closed = new HashSet<>();
    }

    public int heuristic(State state) {
        int count = 0;
        for (int i = 0; i < state.board.length; i++) {
            for (int j = 0; j < state.board[i].length; j++) {
                if (state.board[i][j] != goal[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public List<State> getSuccessors(State state) {
        List<State> successors = new ArrayList<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            int newX = state.x + dx[i];
            int newY = state.y + dy[i];
            if (newX >= 0 && newX < state.board.length && newY >= 0 && newY < state.board[0].length) {
                State newState = new State(state.board, state.x, state.y, newX, newY, state.cost + 1, state);
                successors.add(newState);
            }
        }
        return successors;
    }

    public List<State> search() {
        open.add(new State(start, 0, 0, 0, 0, 0, null));
        while (!open.isEmpty()) {
            State currentState = open.poll();
            if (Arrays.deepEquals(currentState.board, goal)) {
                List<State> path = new ArrayList<>();
                while (currentState != null) {
                    path.add(currentState);
                    currentState = currentState.parent;
                }
                Collections.reverse(path);
                return path;
            }
            closed.add(currentState);
            List<State> successors = getSuccessors(currentState);
            for (State successor : successors) {
                if (!closed.contains(successor)) {
                    open.add(successor);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[][] start = {
            {2, 8, 3},
            {1, 6, 4},
            {7, 0, 5}
        };
        int[][] goal = {
            {1, 2, 3},
            {8, 0, 4},
            {7, 6, 5}
        };
        AStar aStar = new AStar(start, goal);
        List<State> path = aStar.search();
        if (path != null) {
            for (State state : path) {
                for (int[] row : state.board) {
                    System.out.println(Arrays.toString(row));
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution found");
        }
    }
}
