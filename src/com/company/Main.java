package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        int Moc;
        int Cena;
        String Kolor;
        double Spalanie;

        Scanner scanner = new Scanner(System.in);

        Samochod renault = null;
        Samochod vw = null;
        Samochod dodge = null;

        try {

            System.out.println("Podaj specyfikacje Renault Clio:");
            System.out.println("Podaj moc:");
            Moc = scanner.nextInt();
            System.out.println("Podaj cene:");
            Cena = scanner.nextInt();
            System.out.println("Podaj kolor:");
            Kolor = scanner.next();
            System.out.println("Podaj spalanie:");
            Spalanie = scanner.nextDouble();

            renault = new Samochod(Moc, Cena, Kolor, Spalanie);

            System.out.println("Podaj specyfikacje VW Polo:");
            System.out.println("Podaj moc:");
            Moc = scanner.nextInt();
            System.out.println("Podaj cene:");
            Cena = scanner.nextInt();
            System.out.println("Podaj kolor:");
            Kolor = scanner.next();
            System.out.println("Podaj spalanie:");
            Spalanie = scanner.nextDouble();

            vw = new Samochod(Moc, Cena, Kolor, Spalanie);

            System.out.println("Podaj specyfikacje Dodge Durango:");
            System.out.println("Podaj moc:");
            Moc = scanner.nextInt();
            System.out.println("Podaj cene:");
            Cena = scanner.nextInt();
            System.out.println("Podaj kolor:");
            Kolor = scanner.next();
            System.out.println("Podaj spalanie:");
            Spalanie = scanner.nextDouble();

            dodge = new Samochod(Moc, Cena, Kolor, Spalanie);
        }
        catch(SamochodException ex){
            System.out.println("Blad " + ex.NumerBledu + ex.TrescBledu);
            return;
        }
        catch(InputMismatchException ex){
            System.out.println("Blad, zle dane!");
            return;
        }
        finally {
            System.out.println("Finally!");
        }
        System.out.println("Renault Clio:");
        System.out.println("Koszt utrzymania: " + renault.LiczKosztUtrzymania());
        System.out.println("Zuzycie paliwa: " + renault.LiczZuzyciePaliwa());

        System.out.println("VW Polo:");
        System.out.println("Koszt utrzymania: " + vw.LiczKosztUtrzymania());
        System.out.println("Zuzycie paliwa: " + vw.LiczZuzyciePaliwa());

        System.out.println("Dodge Durango:");
        System.out.println("Koszt utrzymania: " + dodge.LiczKosztUtrzymania());
        System.out.println("Zuzycie paliwa: " + dodge.LiczZuzyciePaliwa());

        PrintWriter writer = new PrintWriter("Tekst.txt");

        writer.println("Renault Clio:");
        writer.println("Koszt utrzymania: " + renault.LiczKosztUtrzymania());
        writer.println("Zuzycie paliwa: " + renault.LiczZuzyciePaliwa());

        writer.println("VW Polo:");
        writer.println("Koszt utrzymania: " + vw.LiczKosztUtrzymania());
        writer.println("Zuzycie paliwa: " + vw.LiczZuzyciePaliwa());

        writer.println("Dodge Durango:");
        writer.println("Koszt utrzymania: " + dodge.LiczKosztUtrzymania());
        writer.println("Zuzycie paliwa: " + dodge.LiczZuzyciePaliwa());

        writer.flush();
        writer.close();
    }
}

class Samochod{
    public int Moc;
    public int Cena;
    public String Kolor;
    public double Spalanie;
    private static double BazowyKosztUtrzymania = 200.5;
    private static double KosztPaliwa = 4.5;

    public Samochod(int moc, int cena, String kolor, double spalanie) throws SamochodException {
        Moc = moc;
        Cena = cena;
        Kolor = kolor;
        Spalanie = spalanie;

        if(Moc <= 0){
            throw new SamochodException("1", "Moc musi byc wieksza od 0!");
        }

        if(Cena <= 0){
            throw new SamochodException("2", "Cena musi byc wieksza od 0!");
        }

        if(Spalanie <= 0){
            throw new SamochodException("3", "Spalanie musi byc wieksze od 0!");
        }

    }

    public double LiczKosztUtrzymania(){
        return (BazowyKosztUtrzymania*Cena)/Moc;
    }

    public double LiczZuzyciePaliwa(){
        return KosztPaliwa*Spalanie;
    }
}

class SamochodException extends Exception
{
    public String NumerBledu;
    public String TrescBledu;

    public SamochodException(String numer, String tresc)
    {
        NumerBledu = numer;
        TrescBledu = tresc;
    }
}