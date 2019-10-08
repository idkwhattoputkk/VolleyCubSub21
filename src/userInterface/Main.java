package userInterface;

import java.util.Scanner;

import model.Participant;

public class Main {
	private Scanner reader;
	private Controller c;
	public Main() {
		reader = new Scanner(System.in);
		showWelcoming();
		c = new Controller();
		appManagement();
	}
	private void appManagement() {
		boolean out = false;

		while (!out) {
			int valorUsuario = appMenuPrincipal();
			switch(valorUsuario) {
			case 1:
				long ini = System.currentTimeMillis();
				System.out.println(c.loadCVS());
				long fin = System.currentTimeMillis();
				System.out.println("Tiempo en mili segundos: ");
				System.out.println(fin-ini);		
				break;
			case 2:
				ini = System.currentTimeMillis();
				System.out.println("Digite el id del participante a buscar");
				int x = Integer.parseInt(reader.nextLine());
				System.out.println(c.buscarParticipant(x));
				System.out.println("");
				fin = System.currentTimeMillis();
				System.out.println("Tiempo en mili segundos: ");
				System.out.println(fin-ini);
				break;
			case 3:
				ini = System.currentTimeMillis();
				System.out.println("Digite el id del asistente a buscar");
				x = Integer.parseInt(reader.nextLine());
				System.out.println(c.buscarAssistant(x));
				System.out.println("");
				fin = System.currentTimeMillis();
				System.out.println("Tiempo en mili segundos: ");
				System.out.println(fin-ini);
				break;
			case 4:
				System.out.println("1. Mostar arbol por pais");
				System.out.println("2. Mostrar la lista por pais");
				int opcion = Integer.parseInt(reader.nextLine());
				switch (opcion){
					case 1:
						ini = System.currentTimeMillis();
						System.out.println("Digite el pais para mostrar la lista");
						System.out.println(c.printLinkedList(reader.nextLine()));
						fin = System.currentTimeMillis();
						System.out.println("Tiempo en mili segundos: ");
						System.out.println(fin-ini);
						break;
					case 2:
						ini = System.currentTimeMillis();
						System.out.println("Digite el pais para mostrar el arbol");
						System.out.println(c.tree(reader.nextLine()));
						fin = System.currentTimeMillis();
						System.out.println("Tiempo en mili segundos: ");
						System.out.println(fin-ini);
						break;
				}
				break;
			case 5:
				out=true;
				break;
			}
		}
	}
	public void showWelcoming() {

		String mensaje = "";

		mensaje += "******************************************************************\n";
		mensaje += "*************** BIENVENIDO AL VOLLEY WORLD CUP *******************\n";
		mensaje += "*************** Desarrollado por: Emmanuel Umana *****************\n";
		mensaje += "******************        A00351911         **********************\n";
		mensaje += "********************** Universidad Icesi  ************************\n";
		mensaje += "******************************************************************\n";
		System.out.println(mensaje);
	}
	
	public int appMenuPrincipal(){
		int valor=0;
		System.out.println("Que deseas hacer ?");
		System.out.println("1. Cargar los archivos");
		System.out.println("2. buscar un participante");
		System.out.println("3. buscar un asistente ");
		System.out.println("4. Mostrar arbol por pais");
		System.out.println("5. Salir");
		valor = Integer.parseInt(reader.nextLine());
		return valor;		
	}
	public static void main(String[] args) {
		Main m = new Main();

	}

}
