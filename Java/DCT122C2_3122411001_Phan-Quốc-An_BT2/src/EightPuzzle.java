import java.util.*;

class State {
    int[] state;
    int g;
    int f;

    public int getF() {
        return this.f;
    }

    State(int[] state, int g, int f) {
        this.state = state;
        this.g = g;
        this.f = f;
    }

    @Override
    public String toString() {
        return Arrays.toString(state) + "_f(S" + g + ")=" + f;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof State)) return false;
        State other = (State) obj;
        return Arrays.equals(this.state, other.state);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(state);
    }
}

public class EightPuzzle {
    static int[] goalState = {1, 2, 3, 8, 0, 4, 7, 6, 5};

    static int heuristic(int[] state) {
        int misplaced = 0;
        for (int i = 0; i < state.length; i++) {
            if (state[i] != goalState[i] && state[i] != 0) {
                misplaced++;
            }
        }
        return misplaced;
    }

    static List<int[]> generateSuccessors(int[] state) {
        List<int[]> successors = new ArrayList<>();
        int zeroIndex = -1;
        for (int i = 0; i < state.length; i++) {
            if (state[i] == 0) {
                zeroIndex = i;
                break;
            }
        }
        int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] move : moves) {
            int newIndex = zeroIndex + move[0] * 3 + move[1];
            if (newIndex >= 0 && newIndex < state.length) {
                int[] newState = state.clone();
                newState[zeroIndex] = newState[newIndex];
                newState[newIndex] = 0;
                successors.add(newState);
            }
        }
        return successors;
    }

    static void printOpenList(List<State> openList) {
        System.out.println("OPEN: [");
        if (openList.isEmpty()) {
            System.out.println("]\n");
            return;
        }
        for (State state : openList) {
            System.out.println("\t" + state + ",");
        }
        System.out.println("]\n");
    }

    static void printClosedSet(Set<State> closedSet) {
        System.out.println("CLOSE: [");
        if (closedSet.isEmpty()) {
            System.out.println("]\n");
            return;
        }
        for (State state : closedSet) {
            System.out.println("\t" + state + ",");
        }
        System.out.println("]\n");
    }

    static int[][] aStar(int[] initial) {
        PriorityQueue<State> openList = new PriorityQueue<>(Comparator.comparingInt(s -> s.f));
        Set<State> closedSet = new HashSet<>();

        State initialState = new State(initial, 0, heuristic(initial));
        openList.add(initialState);
        int stepNumber = 0;

        while (!openList.isEmpty()) {
            System.out.println("**Step: " + (stepNumber + 1));
            State currentState = openList.poll();
            int[] state = currentState.state;
            System.out.println("Current State: " + currentState);
            closedSet.add(currentState);
            System.out.println("Next State: \n");
            List<int[]> successors = generateSuccessors(state);

            for (int[] successor : successors) {
                int gSuccessor = currentState.g + 1;
                int fSuccessor = gSuccessor + heuristic(successor);
                State nextState = new State(successor, gSuccessor, fSuccessor);
                if (!closedSet.contains(nextState)) {
                    openList.add(nextState);
                }
            }

            printOpenList(new ArrayList<>(openList));
            printClosedSet(closedSet);

            if (Arrays.equals(state, goalState)) {
                return to2DArray(state);
            }
            stepNumber++;
        }
        return null;
    }

    static int[][] to2DArray(int[] array) {
        int[][] result = new int[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(array, i * 3, result[i], 0, 3);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] initialState = {2, 8, 3, 1, 6, 4, 7, 0, 5};
        int[][] finalState = aStar(initialState);
        if (finalState != null) {
            System.out.println("Final State:");
            for (int[] row : finalState) {
                System.out.println(Arrays.toString(row));
            }
        } else {
            System.out.println("No solution found!");
        }
    }
}
