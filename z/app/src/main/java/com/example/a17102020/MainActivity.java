package com.example.a17102020;

//jest to aplikacja zajmująca się kodowaniem oraz dekodowaniem szyfrem Cezara, który polega na przesunięciu znaków o jakąś wyznaczoną wartość stanowiącą klucz
//istotą szyfru Cezara jest umieszczenie zmienianych liter na tarczy. Zmieniajac litery z końca alfabetu często są kodowane jako wartości początkowe
//bowiem przy przekroczeniu końca założonej puli znaków, klucz zaczyna liczenie od początku alfabetu

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //występują trzy zmienne, powiązane z trzema polami zmienialnymi: poelem z tekstem oryginalnym oraz polem z kluczem, które są wypełniane przez użytkownika
    //oraz pole nieedytowalne, gdzie wyświetlany jest zakodowany lub odkodowany tekst
    TextView codedText;
    EditText oryginalText, keyText;

    //metoda szyfrująca
    public void encrypt(View v){
        //pobranie tekstu oraz klucza
        String plainText=oryginalText.getText().toString();
        int key=Integer.parseInt(keyText.getText().toString());//parsowany na inta, bowiem pobiera się jako włąśnie String

        //odwołanie się do metody statycznej, stąd zapis przez klasa kropka metoda, metoda jest w Caesar.java w java/com.example.a171020
        String encryptedText=Casear.encrypt(key,plainText);

        //wysłanie zakodowanego tekstu użytkownikowi
        codedText.setText(encryptedText);

    }

    //metoda deszyfrująca, zasady identyczne jak wyżej
    public void decrypt(View v){
        String encryptedText=oryginalText.getText().toString();
        int key=Integer.parseInt(keyText.getText().toString());
        String decryptedText=Casear.decrypt(key,encryptedText);
        codedText.setText(decryptedText);

    }



    //poniżej standard, w activity_main.xml ustalono id okienek i tutaj jest ich wyszukiwanie
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oryginalText = findViewById(R.id.oryginalText);
        codedText = findViewById(R.id.CodedText);
        keyText = findViewById(R.id.key);
    }
}