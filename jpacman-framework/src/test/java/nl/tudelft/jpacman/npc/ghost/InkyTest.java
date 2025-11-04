package nl.tudelft.jpacman.npc.ghost;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class InkyTest {

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
    private Inky inky;
    private Optional<Direction> inkyDirection;

    @BeforeEach
    void setUp() {
        PacManSprites pacManSprites = new PacManSprites();

        GhostFactory ghostFactory = new GhostFactory(pacManSprites);
        LevelFactory levelFactory = new LevelFactory(pacManSprites, ghostFactory);

        BoardFactory boardFactory = new BoardFactory(pacManSprites);

        playerFactory = new PlayerFactory(pacManSprites);

        mapParser = new GhostMapParser(levelFactory, boardFactory, ghostFactory);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    void BlinkyFreePathAndInkyFreePathTest() {
        //Arrange
        List<String> map = List.of(
            "##  P#####",
            "##   B  ##",
            "#        #",
            "###  I  ##"
        );

        //Act
        level = mapParser.parseMap(map);
        pacman = playerFactory.createPacMan();
        pacman.setDirection(Direction.SOUTH);
        level.registerPlayer(pacman);
        inky = Navigation.findUnitInBoard(Inky.class, level.getBoard());
        assert inky!= null;
        inkyDirection = inky.nextAiMove();

        //Assert
        assert inkyDirection.equals(Optional.of(Direction.WEST));
    }

    @Test
    void BlinkyisBlockedandInkyisFreeTest() {


    }

}
