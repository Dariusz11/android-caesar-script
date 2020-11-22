package com.example.a17102020;

public class Casear {

    //metoda szyfrująca, wykorzystuje dwa argumenty: tekst do szyfrowania oraz przesunięcie
    public static String encrypt(int key,String plainText){

        //tworzenie niowego obiektu, który będzie zwracany, wybrany typ ułatwia pracę w pętli
        StringBuilder encryptTextBuilder=new StringBuilder();

        //pętla szyfrująca, czysty tekst jest podzielony na znaki, każdym znakiem typu char zajmuje się kolejny obieg pętli
        //zmieniane są wyłącznie litery: wielkie na wielkie, małe na małe, wszystkie inne znaki, na przykład spacje są pozostawiane jak były
        //czyli generalnie operowanie jest na dwóch tarczach, dla małych liter oraz wielkich
        for (int i=0;i<plainText.length();i++){
            char letter=plainText.charAt(i);
            if (letter>='a'&&letter<='z'){
                letter=(char)(((letter-'a'+key)%('z'-'a'+1))+'a');//nowa litera będąca wynikiem przesunięcia,
                //bazowanie na reszcie % modulo pozwala na wstawianie dowolnie wielkich kluczy stanowiących wielokrotność ilości liter alfabetu,
                //sprawdza się resztę podzielenia o ilość liter i o tyle przesuwa, przesunięcie następuje zgodnie z ruchem wskazówek zegara
            }
            //wykonanie identyczne jak dla małych liter
            else if (letter>='A'&&letter<='Z'){
                letter=(char)(((letter-'A'+key)%('Z'-'A'+1))+'A');
            }
            //StringBuilder append() – dodaje kolejną literę do istniejącego obiektu
            encryptTextBuilder.append(letter);
        }
        return encryptTextBuilder.toString();
    }
    //jak wyżej plus niewielkie zmiany, ponieważ klucz przesuwa w stronę przeciwną wskazówkom zegara
    public static String decrypt(int key,String encryptedText){

        StringBuilder plainTextBuilder=new StringBuilder();

        key=-key;
        for (int i=0;i<encryptedText.length();i++){
            char letter=encryptedText.charAt(i);
            if (letter>='a'&&letter<='z'){
                letter=(char)(((letter-'z'+key)%('z'-'a'+1))+'z');
            }
            else if (letter>='A'&&letter<='Z'){
                letter=(char)(((letter-'Z'+key)%('Z'-'A'+1))+'Z');
            }
            plainTextBuilder.append(letter);
        }
        return plainTextBuilder.toString();
    }





}
