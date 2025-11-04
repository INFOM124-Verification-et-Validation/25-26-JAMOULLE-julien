package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.npc.ghost.Clyde;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.npc.ghost.GhostMapParser;
import nl.tudelft.jpacman.npc.ghost.Navigation;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

public class PlayerCollisionsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {}


    private PacManSprites pacManSprites = new PacManSprites();
    private GhostFactory ghostFactory= new GhostFactory(pacManSprites);
    private PlayerFactory playerFactory = new PlayerFactory(pacManSprites);
    private PlayerCollisions collisionMap = new PlayerCollisions();


    @Test
    public void PacmanCollideGhost(){
        //Arrange
        Player pacman=playerFactory.createPacMan();
        Ghost clyde=ghostFactory.createClyde();

        //Act
        collisionMap.collide(pacman, clyde);

        //assert
        assert !pacman.isAlive();

    }

    @Test
    public void GhostCollideGPacman(){
        //Arrange
        Player pacman=playerFactory.createPacMan();
        Ghost clyde=ghostFactory.createClyde();

        //Act
        collisionMap.collide(clyde, pacman);

        //assert
        assert !pacman.isAlive();

    }

    @Test
    public void PacmanCollidePellet(){
        //Arrange
        Player pacman=playerFactory.createPacMan();
        Pellet pellet=new Pellet(10,pacManSprites.getPelletSprite());

        //Act
        collisionMap.collide(pacman,pellet);

        //assert
        assert pacman.getScore()==10;

    }

    @Test
    public void PelletCollidePacman(){
        //Arrange
        Player pacman=playerFactory.createPacMan();
        Pellet pellet=new Pellet(10,pacManSprites.getPelletSprite());

        //Act
        collisionMap.collide(pellet,pacman);

        //assert
        assert pacman.getScore()==10;
        assert !pellet.hasSquare();

    }

}
