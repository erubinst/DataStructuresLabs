//Esme Rubinstein
import org.junit.jupiter.api.Test;

class MazeTest {

    @Test
    void test() {
	Maze test = new Maze();
	test.loadMaze("maze-1");
	test.printMaze();
    }

}
