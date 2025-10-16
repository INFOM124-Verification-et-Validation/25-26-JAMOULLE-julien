package nl.tudelft.jpacman.npc.ghost;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.level.*;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * Tests the methods provided by the {@link Clyde} class.
 */
public class ClydeTest {


    /**
     * Map Parser used to parse the map
     */
    private GhostMapParser mapParser;

    /**
     * Player Factory used to create pacman
     */
    private PlayerFactory playerFactory;

    /**
     * variable reused in each test
     */
    private Level level;
    private Player pacman;
    private Clyde clyde;
    private Optional<Direction> clydeDirection;

    @BeforeEach
     void setUp() {
        PacManSprites pacManSprites = new PacManSprites();

        GhostFactory  ghostFactory= new GhostFactory(pacManSprites);
        LevelFactory levelFactory = new LevelFactory(pacManSprites,ghostFactory);

        BoardFactory boardFactory = new BoardFactory(pacManSprites);

        playerFactory = new PlayerFactory(pacManSprites);

        mapParser = new GhostMapParser(levelFactory,boardFactory,ghostFactory);
    }

    @AfterEach
    public void tearDown() {}

    @Test
    void Distance_Lower_Than_8_and_FreePath() {

        //Arrange
        char[][] map = {
            {'#','#','#','#','#','#','#','#','#','#','#','#'},
            {'#','P',' ',' ','C',' ',' ',' ',' ',' ',' ','#'},
            {'#','#','#','#','#','#','#','#','#','#','#','#'}
        };

        //Act
        level= mapParser.parseMap(map);
        pacman=playerFactory.createPacMan();
        pacman.setDirection(Direction.EAST);
        level.registerPlayer(pacman);
        clyde= Navigation.findUnitInBoard(Clyde.class,level.getBoard());
        clydeDirection= clyde.nextAiMove();

        //Assert
        assert clydeDirection.equals(Direction.SOUTH);

    }

    @Test
    void Distance_Greater_Than_8_and_FreePath() {

        //Arrange
        char[][] map = {
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
            {'#','P',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','C','#'},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#'}
        };

        //Act
        level= mapParser.parseMap(map);
        pacman=playerFactory.createPacMan();
        pacman.setDirection(Direction.EAST);
        level.registerPlayer(pacman);
        clyde= Navigation.findUnitInBoard(Clyde.class,level.getBoard());
        clydeDirection=clyde.nextAiMove();

        //Assert
        assert clydeDirection.equals(Direction.NORTH);


    }






}




