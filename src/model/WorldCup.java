package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WorldCup {
	private Assistant raizAssistant;
	private Participant firstP;
	private int numAssistants;
	private int numParticipants;

	
	
	public WorldCup() {
		raizAssistant =null;
		numAssistants = 0;
		numParticipants = 0;
	}



	public void chargeData(File f) throws AssistantRepetidoException, NumberFormatException, IOException {
		
		BufferedReader br = null;
        String line ="";
        String cvsSplitBy = ",";
        try {
        	int i=0;
            br = new BufferedReader(new FileReader(f));
            while ((line = br.readLine()) != null) {
            	
                String[] lines = line.split(cvsSplitBy);
                	int id =Integer.parseInt(lines[0]);
                	Assistant p = new Assistant(id, lines[1], lines[2], lines[3], lines[4], lines[5], lines[6], lines[7]);
                	if(raizAssistant == null) 
                		raizAssistant = p;
                		
                	else
                		raizAssistant.insert(p);
                	numAssistants++;
                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
	}
        finally {
			try {
				if (br != null)
					br.close();

			} catch (IOException ex) {
				ex.printStackTrace();
			}
        }
	}
	public Assistant searchAssistant( int aidi){
	        return raizAssistant == null ? null : raizAssistant.search(aidi);
	}
	public Participant searchParticipant(int id) {
	        Participant actual = firstP;
	        while( actual != null && actual.getId( ) != id ) {
	            actual = actual.getNext();
	        }
	        return actual;
	}
	public void addOrderedParticipants(Assistant a) {
		Participant n = new Participant(a.getId(),a.getFirst_name(),a.getLast_name(),a.getEmail(),a.getGender(),a.getCountry(),a.getPhoto(),a.getBirthday());
		if( firstP == null )
			firstP = n;
		else if( firstP.getId() >= a.getId() )
		{
			firstP.addBefore(n);
			firstP= n;
		}
		else
		{
			Participant temp0 = null;
			Participant temp1 = firstP;
			while( temp1 != null && temp1.getId() < a.getId() )
			{
				temp0 = temp1;
				temp1 = temp1.getNext();
			}
			temp0.addAfter(n);
		}
	}
	public int getNumAssistants() {
		return numAssistants;
	}



	public void setNumAssistants(int numAssistants) {
		this.numAssistants = numAssistants;
	}



	public int getNumParticipants() {
		return numParticipants;
	}



	public void setNumParticipants(int numParticipants) {
		this.numParticipants = numParticipants;
	}



	public Assistant getRaizAssistant() {
		return raizAssistant;
	}



	public void setRaizAssistant(Assistant raizAssistant) {
		this.raizAssistant = raizAssistant;
	}



	public Participant getFirstP() {
		return firstP;
	}



	public void setFirstP(Participant firstP) {
		this.firstP = firstP;
	}



	public String printTree() {
		// TODO Auto-generated method stub
		return null;
	}
}

