import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {
 private Pokemon pikachu = new Pokemon("Pikachu",100,45);
 private Pokemon squirtle = new Pokemon("Squirtle",150,35);

 private Pokemon snorlax = new Pokemon("Snorlax",80,65);


    @Test //Test getting initial health
    void getHealth() {
       int pikachuHealth = pikachu.getHealth();
       int pokemon1Health = 100;
       assertEquals(pokemon1Health, pikachuHealth);

        int squirtleHealth = squirtle.getHealth();
        int pokemon2Health = 150;
        assertEquals(pokemon2Health, squirtleHealth);

        int snorlaxHealthHealth = snorlax.getHealth();
        int pokemon3Health = 80;
        assertEquals(pokemon3Health, snorlaxHealthHealth);


    }

    @Test //Test getting initial attack power
    void getAttackPower() {
        int pikachuAttackPower = pikachu.getAttackPower();
        int pokemon1AttackPower = 45;
        assertEquals(pokemon1AttackPower, pikachuAttackPower);

        int squirtleAttackPower = squirtle.getAttackPower();
        int pokemon2AttackPower = 35;
        assertEquals(pokemon2AttackPower, squirtleAttackPower);

        int snorlaxAttackPower = snorlax.getAttackPower();
        int pokemon3AttackPower = 65;
        assertEquals(pokemon3AttackPower, snorlaxAttackPower);
    }

    @Test //Test getting Pokemon Name
    void getName() {
        String pikachuName = pikachu.getName();
        String pokemon1Name = "Pikachu";
        assertEquals(pokemon1Name, pikachuName);

        String squirtleName = squirtle.getName();
        String pokemon2Name = "Squirtle";
        assertEquals(pokemon2Name, squirtleName);

        String snorlaxName = snorlax.getName();
        String pokemon3Name = "Snorlax";
        assertEquals(pokemon3Name, snorlaxName);

    }

    @Test //Test to see if Pokemon is dead , (health = 0)
    void isDead() {
        int pikachuHealth = pikachu.getHealth() - 100;
        boolean death = pikachu.isDead();
        assertEquals(false, death);

        int squirtleHealth = squirtle.getHealth() - 150;
        boolean death2 = squirtle.isDead();
        assertEquals(false, death2);

        int snorlaxHealth = snorlax.getHealth() - 80;
        boolean death3 = snorlax.isDead();
        assertEquals(false, death3);
    }

    @Test //Test Pokemons attack changes/reduces the attacked pokemons health
    void attack() {

    pikachu.attack(squirtle);
    //-45 attack on +150 health = 35 health remaining
    int squirtleHealth = squirtle.getHealth();
    assertEquals(105,squirtleHealth);

    pikachu.attack(snorlax);
    //-45 attack on +80 health = 105 health remaining
    int snorlaxHealth = snorlax.getHealth();
    assertEquals(35,snorlaxHealth);


    }

    @Test //Tests the change in health from different amounts of damage inflicted on another pokemon
    void takeDamage() {
//More damage than health
    pikachu.takeDamage(110, squirtle);
    int pHealth = pikachu.getHealth();
    assertEquals(0,pHealth);

//Normal range of damage
    squirtle.takeDamage(50, pikachu);
    int sHealth = squirtle.getHealth();
    assertEquals(100,sHealth);

//No damage to health
    snorlax.takeDamage(0, pikachu);
   int ssHealth = snorlax.getHealth();
   assertEquals(80,ssHealth);

//Heal ability instead of damage (Edge case)
       snorlax.takeDamage(-10, squirtle);
       int snHealth = snorlax.getHealth();
       assertEquals(90,snHealth);

    }

    @Test //Tests the String prints out the name, health, and attack of a Pokemon
    void testToString() {
       String  pName = pikachu.getName();
       int pHealth = pikachu.getHealth();
       int pAttackPower = pikachu.getAttackPower();
       String pika = pikachu.toString();
       String pikaPika = "Pokemon " + pName + ":\n\thealth: " + pHealth + "\n\tattack: " + pAttackPower;

       assertEquals(pikaPika,pika);

    }
}