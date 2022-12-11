package br.com.natalia.demo;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // usar Locale.US para usar ponto como separador decimal
        Scanner entrada = new Scanner(System.in).useLocale(Locale.US);

// ler valores
        double x1 = entrada.nextDouble();
        double y1 = entrada.nextDouble();
        double x2 = entrada.nextDouble();
        double y2 = entrada.nextDouble();

// calcular distância
        double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
