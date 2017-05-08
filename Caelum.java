//package Caelum;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.String;
import java.io.BufferedReader;

public class Caelum{
    public static void main(String[] args) throws IOException {
        System.out.println("O programa se encerra apos digitar somente # e apertar o Enter");
        Integer num;
        String s = lePalavra();

        while(!s.equals("#")){
            s = conferePalavra(s);
            num = somaNumeros(s);
            if(conferePrimo(num))
            {
                System.out.println("It is a prime word."+"\n");
            }else{
                System.out.println("It is not a prime word."+"\n");
            }
            s = lePalavra();
        }

        System.out.println("Fim");
        System.exit(0);
    }

    /*
    Metodo: lePalavra()
    Sumario: Le a palavra inserida pelo usuario, conferindo seu tamanho
    Parametros: Nao recebe
    Retorna: Uma string contendo a palavra escrita
     */
    public static String lePalavra() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        while(!confereTamanho(s)){
            System.out.println("Limite da palavra nao respeitado!"+"\n"+
                    "O tamanho da palavra deve estar entre 1 e 20"+"\n" +
                    "Tente novamente");
            s = br.readLine();
        }
        return s;
    }
    /*
    Metodo: somaNumeros(String s)
    Sumario: Soma os valores de cada letra
    Parametros: Recebe a string inserida
    Retorna: Um inteiro com a soma dos valores
     */
    public static Integer somaNumeros(String s){
        int soma=0;
        for(int i=0; i<s.length();i++){
            soma += conversorPalavra(s.charAt(i));
        }
        return soma;
    }

    /*
    Metodo: conversorPalavra(char c)
    Sumario: Converte as letras da palavra inserida retornando seu valor delimitado
    Parametros: Recebe cada letra da palavra
    Retorna: Um inteiro com o valor da letra
     */
    public static Integer conversorPalavra(char c){
        int contador;
        if(Character.isUpperCase(c)){
            contador = (int)c - 38;
        }else{
            contador = (int)c - 96;
        }
        return contador;
    }

    /*
    Metodo: conferePalavra(String s)
    Sumario: Retira qualquer caracter especial, numero, espaço em branco
    Parametros: Recebe a palavra inserida
    Retorna: A string (palavra) devidamente formatada
     */
    public static String conferePalavra(String s){
        String resultado;
        resultado = s.trim();
        char[] aux = new char[resultado.length()];
        for(int i = 0;i < resultado.length(); i++){
            if(Character.isLetter(resultado.charAt(i))){
                aux[i]+=resultado.charAt(i);
            }
        }
        resultado = String.valueOf(aux);
        resultado = resultado.replace("\u0000", "");
        return resultado;
    }

    /*
    Metodo: confereTamanho(String s)
    Sumario: Confere se a palavra inserida esta no limite previsto, entre 1 e 20 letras
    Parametros: Recebe a palavra inserida
    Retorna: Um booleano com a verificacao
     */
    public static Boolean confereTamanho(String s){
        return s.length() <= 20 && s.length() > 0 ;
    }

    /*
    Metodo: conferePrimo(Integer n)
    Sumario: Confere se o numero e primo, ou nao
    Parametros: Recebe a soma dos valores de cada letra
    Retorna: Um booleano com a verificacao
     */
    public static Boolean conferePrimo(Integer n){
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
