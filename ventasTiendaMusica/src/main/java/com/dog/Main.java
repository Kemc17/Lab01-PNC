package com.dog;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Artista> artistas = new ArrayList<>();
    static List<Disco> discos = new ArrayList<>();
    public static void main(String[] args)
    {
        while (true) {
            System.out.println("Bienvenido al sistema de gestión de artistas y discos.");
            System.out.println("1. Agregar artista");
            System.out.println("2. Agregar disco");
            System.out.println("3. Calcular artista más discos vendido");
            System.out.println("4. Mostrar disco con más de X vendido");
            System.out.println("5. Vender disco");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el ID del artista: ");
                    String id = scanner.nextLine();
                    System.out.print("Ingrese el nombre del artista: ");
                    String nombre = scanner.nextLine();
                    artistas.add(new Artista(id, nombre, "",0));
                    break;
                case 2:
                    System.out.print("Ingrese el id del artista: ");
                    String artista = scanner.nextLine();
                    System.out.print("Ingrese el título del disco: ");
                    String titulo = scanner.nextLine();
                    discos.add(new Disco(artista, titulo, 0));
                    break;
                case 3:
                    Artista artistaMasDiscosVendidos = artistaMasBuscado(artistas);
                    if (artistaMasDiscosVendidos != null) {
                        System.out.println("El artista con más discos vendidos es: " + artistaMasDiscosVendidos.getNombre());
                    } else {
                        System.out.println("No hay artistas registrados.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el número mínimo de ventas: ");
                    int minVentas = scanner.nextInt();
                    scanner.nextLine();
                    discos.stream()
                            .filter(disco -> (disco.getVentasTotales()) >= minVentas)
                            .forEach(disco -> System.out.println("Disco: " + disco.getTitulo() + ", Ventas: " + disco.getVentasTotales()));
                    break;
                case 5:
                    ventaProducto();
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
    public static Artista artistaMasBuscado (List<Artista> artistas){
        return artistas.stream()
                .max(Comparator.comparing(Artista::getVentasTotales))
                .orElse(null);
    }
    public static void ventaProducto(){
        System.out.print("Ingrese el título del disco a vender: ");
        String tituloDisco = scanner.nextLine();
        Disco discoAVender = discos.stream()
                .filter(disco -> disco.getTitulo().equals(tituloDisco))
                .findFirst()
                .orElse(null);
        if (discoAVender != null) {
            System.out.print("Ingrese la cantidad de ventas: ");
            int ventas = scanner.nextInt();
            scanner.nextLine();
            discoAVender.setVentasTotales(discoAVender.getVentasTotales() + ventas);
            System.out.println("Ventas actualizadas para el disco " + tituloDisco + ": " + discoAVender.getVentasTotales());
            System.out.println(discoAVender.toString());
            Artista artistaDeDisco = artistas.stream()
                    .filter(artista -> artista.getId().equals(discoAVender.getArtista()))
                    .findFirst()
                    .orElse(null);
            artistaDeDisco.setVentasTotales(artistaDeDisco.getVentasTotales() + ventas);
        } else {
            System.out.println("Disco no encontrado.");
        }
    }
}