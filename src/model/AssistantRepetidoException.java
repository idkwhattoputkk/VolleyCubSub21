package model;


@SuppressWarnings("serial")
public class AssistantRepetidoException extends Exception{

	public AssistantRepetidoException(int ides) {
		 super( "Ya existe un asistente con ese id: " + ides);
	}

}
