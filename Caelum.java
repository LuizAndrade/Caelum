package Caelum;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.String;
import java.io.BufferedReader;

/*
letras:
a-z: 1-26
A-Z: 27-52

ASCII:
a-z: 97-122
A-Z: 65-90

Convertendo:
a: 1+96 = 97
h: 8+96 = 104

A: 1+64 = 65
H: 8+64 = 72

As palavras vao variar de 1-20 caracteres
*/


public class Caelum{
    public static void main(String[] args) throws IOException {
        Integer num;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("O programa se encerra apos digitar somente # e apertar o Enter");
        System.out.print("Digite uma palavra: ");
        String s = br.readLine();

        while(!s.equals("#")){
            if(checkTamanho(s)){
                s = checkPalavra(s);
                num = getNumeros(s);
                if(isPrimo(num))
                {
                    System.out.println("It is a prime word."+"\n");
                }else{
                    System.out.println("It is not a prime word."+"\n");
                }
            }else{
                System.out.println("Limite da palavra nao respeitado!"+"\n"+
                        "O tamanho da palavra deve estar entre 1 e 20"+"\n" +
                        "Tente novamente"+"\n");
            }

            System.out.print("Digite uma palavra: ");
            s = br.readLine();
        }

        System.out.println("Fim");
        System.exit(0);
    }

    /*
        Soma as palavras em seu valor convertido
     */
    public static Integer getNumeros(String s){
        int soma=0;
        for(int i=0; i<s.length();i++){
            soma += conversorPalavra(s.charAt(i));
        }
        return soma;
    }

    /*
        Converte cada letra da String e
         retorna seu valor denominado
     */
    public static Integer conversorPalavra(char c){
        int count;
        if(Character.isUpperCase(c)){
            count = (int)c - 38;
        }else{
            count = (int)c - 96;
        }
        return count;
    }

    /* Metodo: checkPalavra(String s)
        Checa se a palavra possui espacos, caracteres especiais,
        numeros e retorna a palavra(String) somente com letras.
    */
    public static String checkPalavra(String s){
        String result;
        result = s.trim();
        char[] aux = new char[result.length()];
        for(int i = 0;i < result.length(); i++){
            if(Character.isLetter(result.charAt(i))){
                aux[i]+=result.charAt(i);
            }
        }
        result = String.valueOf(aux);
        result = result.replace("\u0000", "");
        return result;
    }

    /* Metodo: checkTamanho(String s)
        Checa se a palavra esta dentro do limite determinado.
    */
    public static Boolean checkTamanho(String s){
        return s.length() <= 20 && s.length() > 0 ;
    }

    public static Boolean isPrimo(Integer n){
        if(n%2 == 0 && n>2){
            return false;
        }
        for(int i = 2; i < n/2;i++){
            if(n%i == 0){
                return false;
            }

        }
        return true;
    }

}