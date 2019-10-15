package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import model.AssistantRepetidoException;
import model.WorldCup;

class WorldCupTest {
	private WorldCup c;
	public void setUpScenery1() throws IOException, AssistantRepetidoException {
		c = new WorldCup();
		File f = new File("data"+File.separator+"info.csv");
		c.chargeData(f);
	}
	public void setUpScenery2() throws IOException, AssistantRepetidoException {
		c = new WorldCup();
		File f = new File("data"+File.separator+"totalInfo.csv");
		c.chargeData(f);
	}
	void setUpScenery3() throws IOException, AssistantRepetidoException {
		c = new WorldCup();
		File f = new File("data"+File.separator+"info2.csv");
		c.chargeData(f);
	}
	@Test
	void testChargeData() {
		try {
			setUpScenery1();
			File f = new File("data"+File.separator+"totalInfo.csv");
			c.chargeData(f);
		} catch (IOException e) {
			fail("no era la excepcion esperada");
		} catch (AssistantRepetidoException e) {
			assertEquals(e.getMessage() ,"Ya existe un asistente con ese id: " +1);
		}
	}
	@Test
	void testSearchAssistant() {
		try {
			setUpScenery2();
			assertEquals(c.searchAssistant(1).getEmail(),"dkrikorian0@bigcartel.com");
			assertEquals(c.searchAssistant(100).getEmail(),"epurtell2r@oakley.com");
			assertEquals(c.searchAssistant(12).getEmail(),"jkwietakb@sakura.ne.jp");
		} catch (IOException | AssistantRepetidoException e) {
			fail("Excepcion no esperada");
		}
	}

	@Test
	void testSearchParticipant() {
		try {
			setUpScenery3();
			assertEquals(c.searchParticipant(2000).getBirthday(),"2019/05/31");
			assertEquals(c.searchParticipant(1500).getBirthday(),"2018/10/03");
			assertEquals(c.searchParticipant(1002).getBirthday(),"2019/07/31");
		} catch (IOException | AssistantRepetidoException e) {
			e.printStackTrace();
		}

	}


}
