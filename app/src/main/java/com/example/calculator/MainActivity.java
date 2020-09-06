package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean operasimatematika = false;
    boolean angkaditekan = false;
    private double angkapertama = 0;
    private int indexangkakedua = 0;
    private char operasiyangberjalan;
    float hasil = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView screen = findViewById(R.id.screen);
        Button clear = findViewById(R.id.clear);
        Button delete = findViewById(R.id.delete);
        Button devide = findViewById(R.id.devide);
        Button multiply = findViewById(R.id.multiply);
        Button minus = findViewById(R.id.minus);
        Button plus = findViewById(R.id.plus);
        Button equal = findViewById(R.id.equal);
        Button one = findViewById(R.id.one);
        Button two = findViewById(R.id.two);
        Button three = findViewById(R.id.three);
        Button four = findViewById(R.id.four);
        Button five = findViewById(R.id.five);
        Button six = findViewById(R.id.six);
        Button seven = findViewById(R.id.seven);
        Button eight = findViewById(R.id.eight);
        Button nine = findViewById(R.id.nine);
        Button zero = findViewById(R.id.zero);
        Button zero2 = findViewById(R.id.zero2);
        Button titik = findViewById(R.id.titik);


        final View.OnClickListener screenListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //to know which button click we have to given it an id
                final int id = v.getId();
                switch (id){
                    case R.id.clear:
                        screen.clearComposingText();
                        break;
                    case R.id.delete:
                        break;
                    // OPERASI
                    case R.id.devide:
                        if (operasimatematika == false) {
                            String screenContent = screen.getText().toString();
                            indexangkakedua = screenContent.length() + 1;
                            angkapertama = Double.parseDouble(screenContent);
                            screen.append("/");
                            operasimatematika = true;
                            angkaditekan = false;
                            operasiyangberjalan = '/';
                        }
                        if(angkaditekan == false){
                            return;
                        }


                        break;
                    case R.id.multiply:
                        if(operasimatematika == false){
                            String screenContent = screen.getText().toString();
                            indexangkakedua = screenContent.length() + 1;
                            angkapertama = Double.parseDouble(screenContent);
                            screen.append("X");
                            operasimatematika = true;
                            angkaditekan = false;
                            operasiyangberjalan = '*';
                        }
                        if(angkaditekan == false){
                            return;
                        }

                        break;

                    case R.id.minus:
                        if(operasimatematika == false){
                            String screenContent = screen.getText().toString();
                            indexangkakedua = screenContent.length()+1;
                            angkapertama = Double.parseDouble(screenContent);
                            screen.append("-");
                            operasimatematika = true;
                            angkaditekan = false;
                            operasiyangberjalan = '-';
                        }
                        if(angkaditekan == false){
                            return;
                        }

                        break;

                    case R.id.plus:
                        if(operasimatematika == false){
                            String  screenContent = screen.getText().toString();
                            indexangkakedua = screenContent.length()+1;
                            angkapertama = Double.parseDouble(screenContent);
                            screen.append("+");
                            operasimatematika = true;
                            angkaditekan = false;
                            operasiyangberjalan = '+';
                        }
                        if(angkaditekan == false){
                            return;
                        }
                        break;
                        //END OF OPERATION

                    case R.id.equal:
                        if(angkaditekan == false){
                            return;
                        }

                        else {
                            if (operasimatematika == true) {
                                String screenContent = screen.getText().toString();
                                String Stringangkakedua = screenContent.substring(indexangkakedua, screenContent.length());
                                double angkakedua = Double.parseDouble(Stringangkakedua);
                                if (Stringangkakedua.isEmpty()) {
                                    return;
                                }
                                if (operasiyangberjalan == '+') {
                                    angkakedua += angkapertama;
                                } else if (operasiyangberjalan == '-') {
                                    angkakedua = angkapertama - angkakedua;
                                } else if (operasiyangberjalan == '*') {
                                    angkakedua = angkapertama * angkakedua;
                                } else if (operasiyangberjalan == '/') {
                                    if (angkakedua == 0) {
                                        return;
                                    }

                                    angkakedua = angkapertama / angkakedua;
                                }
                                // result from all of operation
                                String hasil = String.valueOf(angkakedua);
                                if (hasil.endsWith(".0")) {
                                    hasil = hasil.substring(0, hasil.length() - 2);
                                }
                                operasimatematika = false;
                                angkaditekan = true;
                                screen.setText(hasil);
                            }
                        }
                        break;
                    case R.id.one:
                        angkaditekan = true;
                        screen.append("1");
                        break;
                    case R.id.two:
                        angkaditekan = true;
                        screen.append("2");
                        break;
                    case R.id.three:
                        angkaditekan = true;
                        screen.append("3");
                        break;
                    case R.id.four:
                        angkaditekan = true;
                        screen.append("4");
                        break;
                    case R.id.five:
                        angkaditekan = true;
                        screen.append("5");
                        break;
                    case R.id.six:
                        angkaditekan =true;
                        screen.append("6");
                        break;
                    case R.id.seven:
                        angkaditekan = true;
                        screen.append("7");
                        break;
                    case R.id.eight:
                        angkaditekan = true;
                        screen.append("8");
                        break;
                    case R.id.nine:
                        angkaditekan = true;
                        screen.append("9");
                        break;
                    case R.id.zero:
                        angkaditekan = true;
                        screen.append("0");
                        break;
                    case R.id.zero2:
                        angkaditekan = true;
                        screen.append("00");
                        break;
                    case R.id.titik:
                        screen.append(".");
                        break;


                }
            }
        };

        clear.setOnClickListener(screenListener);
        delete.setOnClickListener(screenListener);
        devide.setOnClickListener(screenListener);
        multiply.setOnClickListener(screenListener);
        minus.setOnClickListener(screenListener);
        plus.setOnClickListener(screenListener);
        equal.setOnClickListener(screenListener);
        one.setOnClickListener(screenListener);
        two.setOnClickListener(screenListener);
        three.setOnClickListener(screenListener);
        four.setOnClickListener(screenListener);
        five.setOnClickListener(screenListener);
        six.setOnClickListener(screenListener);
        seven.setOnClickListener(screenListener);
        eight.setOnClickListener(screenListener);
        nine.setOnClickListener(screenListener);
        zero.setOnClickListener(screenListener);
        zero2.setOnClickListener(screenListener);
        titik.setOnClickListener(screenListener);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String banyakdata = screen.getText().toString();
            int jumlahdata = banyakdata.length();
            operasimatematika = false;
            if(jumlahdata > 0 ){
                banyakdata = banyakdata.substring(0,jumlahdata - 1);
                screen.setText(banyakdata);
                if(jumlahdata < 0){
                    angkaditekan = false;
                }
            }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operasimatematika == true){
                    operasimatematika = false;
                }
                angkaditekan = false;
                screen.setText("");
            }
        });



    }
}



//delet element
