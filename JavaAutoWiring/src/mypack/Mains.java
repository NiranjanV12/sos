package mypack;

import java.io.*;

import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.MyConfig;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=MyConfig.class)
public class Mains {

@Autowired
private Guns gun;

	
@Autowired
private Players player;

@Test
public void cdShouldNotBeNull() {
assertNotNull(gun);
}

@Test
public void cdShouldNotBeNull2() {
assertNotNull(player);
}

@Test
public void play() {

	player.getReady();

}
}
