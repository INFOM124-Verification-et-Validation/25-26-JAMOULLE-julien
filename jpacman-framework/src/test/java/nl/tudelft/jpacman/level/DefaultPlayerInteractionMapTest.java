package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class DefaultPlayerInteractionMapTest {

    @BeforeEach
    void setUp() {}

    @AfterEach
    void tearDown() {}


    private PacManSprites pacManSprites = new PacManSprites();
    private GhostFactory ghostFactory= new GhostFactory(pacManSprites);
    private PlayerFactory playerFactory = new PlayerFactory(pacManSprites);
    private DefaultPlayerInteractionMap playerInteractionMap= new DefaultPlayerInteractionMap();


    @Test
    public void PacmanCollideGhost(){
    //Arrange
    Player pacman=playerFactory.createPacMan();
    Ghost clyde=ghostFactory.createClyde();

    //Act
    playerInteractionMap.collide(pacman, clyde);

    //assert
    assert !pacman.isAlive();
    }

    @Test
    public void PacmanCollidePellet(){
    //Arrange
    Player pacman=playerFactory.createPacMan();
    Pellet pellet=new Pellet(10,pacManSprites.getPelletSprite());

    //Act
    playerInteractionMap.collide(pacman,pellet);

    //assert
    assert pacman.getScore()==10;
    assert !pellet.hasSquare();
    }

}
