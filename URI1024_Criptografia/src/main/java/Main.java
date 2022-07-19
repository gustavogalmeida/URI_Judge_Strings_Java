/*
Solicitaram para que você construisse um programa simples de criptografia.
Este programa deve possibilitar enviar mensagens codificadas sem que alguém
consiga lê-las. O processo é muito simples. São feitas três passadas em tod o texto.

Na primeira passada, somente caracteres que sejam letras minúsculas e maiúsculas
devem ser deslocadas 3 posições para a direita, segundo a tabela ASCII: letra 'a'
deve virar letra 'd', letra 'y' deve virar caractere '|' e assim sucessivamente.
Na segunda passada, a linha deverá ser invertida. Na terceira e última passada,
tod e qualquer caractere a partir da metade em diante (truncada) devem ser deslocados
uma posição para a esquerda na tabela ASCII. Neste caso, 'b' vira 'a' e 'a' vira '`'.

Por exemplo, se a entrada for “Texto #3”, o primeiro processamento sobre esta entrada
deverá produzir “Wh{wr #3”. O resultado do segundo processamento inverte os caracteres
e produz “3# rw{hW”. Por último, com o deslocamento dos caracteres da metade em diante,
o resultado final deve ser “3# rvzgV”.

Entrada
A entrada contém vários casos de teste. A primeira linha de cada caso de teste contém
um inteiro N (1 ≤ N ≤ 1 * 10^4), indicando a quantidade de linhas que o problema deve
tratar. As N linhas contém cada uma delas M (1 ≤ M ≤ 1*10^3) caracteres.

Saída
Para cada entrada, deve-se apresentar a mensagem criptografada.
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // quantidade de linhas n
        int n = scanner.nextInt();
        scanner.nextLine();

        // lê e criptografa N vezes
        for (int h = 0; h<n;h++){

            String entrada = scanner.nextLine();
            String[] criptografado1 = new String[entrada.length()];

            // criptografar #1 (apenas letras maisculas e minusculas)
            for (int i = 0; i<entrada.length(); i++){
                char caracterNormal = entrada.charAt(i);
                int ASCI = caracterNormal; // char passar para (int) ASCII
                if (ASCI >= 65 && ASCI <=90 || ASCI >= 97 && ASCI <= 122){
                    ASCI = ASCI+3;
                    char caracterCriptografado = (char) ASCI; // int ASCI para char
                    criptografado1[i] = String.valueOf(caracterCriptografado);
                } else {
                    criptografado1[i] = String.valueOf(caracterNormal);
                }
            }

            // criptografar #2 invertendo linha
            String[] criptografado2 = new String[criptografado1.length];
            int j=0;
            for (int i = criptografado1.length-1; i >= 0; i--) {
                criptografado2[i] = criptografado1[j];
                j++;
            }

            // criptografar #3 uma para esquerda na tabela ASCI da metade da string pra frente
            for(int i = criptografado2.length/2; i < criptografado2.length; i++ ){
                String cStr = criptografado2[i];
                char cChar = cStr.charAt(0);
                int ASCI = cChar;
                ASCI--;
                char carcaterCriptografado = (char) ASCI;
                criptografado2[i] = String.valueOf(carcaterCriptografado);
            }

            String criptografado="";
            // passar de Array para string
            for (int i = 0; i < criptografado2.length;i++){
                criptografado = criptografado+criptografado2[i];
            }

            System.out.println(criptografado);

        }
    }
}