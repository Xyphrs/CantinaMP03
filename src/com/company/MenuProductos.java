package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuProductos {

    Scanner scanner = new Scanner(System.in);
    ControlProducto controlProducto = new ControlProducto();
    AccesoAProductos accesoAProductos = new AccesoAProductos();
    static ArrayList<Productos> productosComprados = new ArrayList<>();
    static ArrayList<Float> precioTotalDeLaCompra = new ArrayList<>();

    public void anadirProductos()   {
        int opcionAnadir = 0;

        while (opcionAnadir != 4) {

            System.out.println("\n[1] Bocadillos");
            System.out.println("[2] Bebidas");
            System.out.println("[3] Cafes");
            System.out.println("[4] Salir \n");
            System.out.print("Que quieres añadir?: ");

            opcionAnadir = scanner.nextInt();
            switch (opcionAnadir) {
                case 1: {
                    System.out.print("\nID del bocadillo: ");
                    int id = scanner.nextInt();
                    System.out.print("Nombre del bocadillo: ");
                    String nom = scanner.next();
                    System.out.print("Precio del bocadillo: ");
                    float precio = scanner.nextFloat();

                    Productos producto = new Productos(id, nom, precio);

                    ControlProducto.tiposDeBocadillos.add(producto);
                    System.out.println("\nProducto añadido :)");
                    break;
                }
                case 2: {
                    System.out.print("\nID de Bebida: ");
                    int id = scanner.nextInt();
                    System.out.print("Nombre de la bebida: ");
                    String nom = scanner.next();
                    System.out.print("Precio de la bebida: ");
                    float precio = scanner.nextFloat();

                    Productos producto = new Productos(id, nom, precio);

                    ControlProducto.tipoBebidas.add(producto);
                    System.out.println("\nProducto añadido :)");
                    break;
                }
                case 3: {
                    System.out.print("\nID del cafe: ");
                    int id = scanner.nextInt();
                    System.out.print("Nombre del cafe: ");
                    String nom = scanner.next();
                    System.out.print("Precio del cafe: ");
                    float precio = scanner.nextFloat();

                    Productos producto = new Productos(id, nom, precio);

                    ControlProducto.cafes.add(producto);
                    System.out.println("\nProducto añadido :)");
                    break;
                }
            }
        }
    }

    public void borrarProductos() throws IOException, InterruptedException {
        int opcionBorrar = 0;
        while (opcionBorrar != 4) {

            System.out.println("\n[1] Bocadillos");
            System.out.println("[2] Bebidas");
            System.out.println("[3] Cafes");
            System.out.println("[4] Salir\n");
            System.out.print("Que quieres eliminar?: ");



            opcionBorrar = scanner.nextInt();
            switch (opcionBorrar) {
                case 1: {



                    System.out.print("\nID del Bocadillo: ");
                    int id = scanner.nextInt();
                    ControlProducto.tiposDeBocadillos.remove(id - 1);
                    System.out.println("\nProducto eliminado\n");
                    break;
                }
                case 2: {
                    System.out.print("ID de Bebida: ");
                    int id = scanner.nextInt();
                    ControlProducto.tipoBebidas.remove(id - 1);
                    System.out.println("\nProducto eliminado\n");
                    break;
                }
                case 3: {
                    System.out.print("ID del Cafe: ");
                    int id = scanner.nextInt();
                    ControlProducto.cafes.remove(id - 1);
                    System.out.println("\nProducto eliminado\n");
                    break;
                }
            }
        }
    }

    public void clientePideBocadillo() throws IOException, InterruptedException {
        System.out.print("\nQue bocadillo quieres?: ");
        controlProducto.listarBocadillos();


        int idDelBocadilloQueQuiero = scanner.nextInt() - 1;

        System.out.println("Este es el bocadillo que as pedido:");
        System.out.println("Nom: " + ControlProducto.tiposDeBocadillos.get(idDelBocadilloQueQuiero).getNom() + " | Precio: " + ControlProducto.tiposDeBocadillos.get(idDelBocadilloQueQuiero).getPrecio());

        productosComprados.add(ControlProducto.tiposDeBocadillos.get(idDelBocadilloQueQuiero));
        precioTotalDeLaCompra.add(ControlProducto.tiposDeBocadillos.get(idDelBocadilloQueQuiero).getPrecio());

    }

    public void clientePideBebida() throws IOException, InterruptedException {
        System.out.print("\nQue bebida quieres?: ");
        controlProducto.listarbebidas();

        int idDelaBebidaQueQuiero = scanner.nextInt() - 1;

        System.out.println("Esta es la bebida que as pedido:");
        System.out.println("Nom: " + ControlProducto.tipoBebidas.get(idDelaBebidaQueQuiero).getNom() + " | Precio: " + ControlProducto.tipoBebidas.get(idDelaBebidaQueQuiero).getPrecio());

        productosComprados.add(ControlProducto.tipoBebidas.get(idDelaBebidaQueQuiero));
        precioTotalDeLaCompra.add(ControlProducto.tipoBebidas.get(idDelaBebidaQueQuiero).getPrecio());

    }

    public void clientePideCafe() throws IOException, InterruptedException {
        System.out.print("\nQue cafe quieres?: ");
        controlProducto.listarCafes();

        int idDelcafeQueQuiero = scanner.nextInt() - 1;

        System.out.println("Este es el Café que as pedido: ");
        System.out.println("Nom: " + ControlProducto.cafes.get(idDelcafeQueQuiero).getNom() + " | Precio: " + ControlProducto.cafes.get(idDelcafeQueQuiero).getPrecio());

        productosComprados.add(ControlProducto.cafes.get(idDelcafeQueQuiero));
        precioTotalDeLaCompra.add(ControlProducto.cafes.get(idDelcafeQueQuiero).getPrecio());

    }

    public void resumenDeLaCompra() {

        System.out.println("\n---------------------------------------------");
        System.out.println("Resumen de tu compra:");

        for (Productos p: productosComprados) {
            System.out.println("Nombre: " + p.getNom() + " Precio: " + p.getPrecio());

        }

        float suma = 0f;

        float laSumaTotal = 0f;

        for (float p: precioTotalDeLaCompra) {
            laSumaTotal = suma += p;
        }

        System.out.println("---------------------------------------------");
        System.out.printf("Precio total a pagar : " +"%.2f%n", laSumaTotal);
        System.out.println("---------------------------------------------\n");


    }

    public void start() throws IOException, InterruptedException {

        int opcion = 0;
        while (opcion != 4) {

            System.out.println(" ");
            System.out.println("[1] Pedir un bocadillo");
            System.out.println("[2] Pedir una bebida");
            System.out.println("[3] Pedir un cafe");
            System.out.println("[4] Salir");
            System.out.print("\nQue quieres pedir?: ");

            opcion = scanner.nextInt();
            switch (opcion) {
                case 1: {
                    System.out.print("\n");
                    accesoAProductos.getProductos(opcion).forEach(System.out::println);
                    clientePideBocadillo();
                    break;
                }
                case 2: {
                    System.out.print("\n");
                    accesoAProductos.getProductos(opcion).forEach(System.out::println);
                    clientePideBebida();
                    break;
                }
                case 3: {
                    System.out.print("\n");
                    accesoAProductos.getProductos(opcion).forEach(System.out::println);
                    clientePideCafe();
                    break;
                }
                case 4: {
                    resumenDeLaCompra();
                    break;
                }
            }
        }
    }



}
