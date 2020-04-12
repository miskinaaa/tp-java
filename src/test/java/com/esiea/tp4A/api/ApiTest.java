package com.esiea.tp4A.api;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void get_name_game() {
        String name = "Game";
        String myTest = this.testRestTemplate.getForObject("/join", String.class);
        assertThat(myTest).contains("idPlayer");

    }

    @Test
    public void get_current_position() {
        String join = this.testRestTemplate.getForObject("/join",String.class);
        String id = join.split("=")[1];
        String myTest = this.testRestTemplate.getForObject("/rover/position?id="+id, String.class);
        assertThat(myTest).contains("This is the current position of the rover : ");
    }


    @Test
    public void get_position_after_moving_forward() {
        String join = this.testRestTemplate.getForObject("/join",String.class);
        String id = join.split("=")[1];
        String myTest = this.testRestTemplate.getForObject("/rover/move?id="+id+"&command=f", String.class);
        assertThat(myTest).contains("This is the current position of the rover : ");

    }

    @Test
    public void get_shoot() {
        String join = this.testRestTemplate.getForObject("/join",String.class);
        String id = join.split("=")[1];
        String myTest = this.testRestTemplate.getForObject("/rover/shoot?id="+id, String.class);
        assertThat(myTest).isEqualTo("You just shot !");
    }

    @Test
    public void get_laser_range() {
        String join = this.testRestTemplate.getForObject("/join",String.class);
        String id = join.split("=")[1];
        String myTest = this.testRestTemplate.getForObject("/rover/shoot/range?id="+id, String.class);
        assertThat(myTest).contains("My laser range = ");

    }

    @Test
    public void get_detection_position() {
        String join = this.testRestTemplate.getForObject("/join",String.class);
        String id = join.split("=")[1];
        String myTest = this.testRestTemplate.getForObject("/rover/detection?id="+id, String.class);
        assertThat(myTest).contains("Position: ");

    }

    @Test
    public void get_status_alive_or_dead() {
        String join = this.testRestTemplate.getForObject("/join",String.class);
        String id = join.split("=")[1];
        String myTest = this.testRestTemplate.getForObject("/rover/status?id="+id, String.class);
        Boolean isPlayerAlive = myTest.contains("You are still alive")|| myTest.contains("Sorry but you are dead");
        assertThat(isPlayerAlive).isEqualTo(true);
    }

}
