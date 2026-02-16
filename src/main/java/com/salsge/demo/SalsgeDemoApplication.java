package com.salsge.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SalsgeDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(SalsgeDemoApplication.class, args);

		boolean salir = false;
		Scanner sn = new Scanner(System.in);

		while(!salir) {

			System.out.println("------ MENU ------");
			System.out.println("""
					1. LISTAR TODOS LOS EMPLEADOS
					2. LISTAR EMPLEADO
					3. CREAR EMPLEADO
					4. EDITAR EMPLEADO
					5. ELIMINAR EMPLEADO
					6. SALIR
				""");


			System.out.print("Elige una opcion: ");
			int opcionNumeroUsuario = sn.nextInt();

			if(opcionNumeroUsuario <= 0 || opcionNumeroUsuario > 6) {
				throw new IllegalArgumentException("Opcion invalida");
			}

			ConsoleOption opcionUsuario = ConsoleOption.convertEnum(opcionNumeroUsuario);

			salir = opcionUsuario.execute();

		}

		sn.close();

	}



}
