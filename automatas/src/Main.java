import java.util.Scanner;

public class Main {
    String id_ing;
    boolean band1 = true, band2 = false, band3 = false;
    char arregloSim []= new char[54];
    int [] arregloNum = new int[10];
    char[] caracter;

    Scanner scan = new Scanner(System.in);

    public void init (){
        char[] mayus;            // Hasta char[51]     MAYUSCULAS
        mayus=new char[26];
        for ( int i=0; i<26; i++) {
            mayus[i] = (char) ('A' + i );
        }

        char[] minus;
        minus=new char[26];  // Hasta char[25]         MINUSCULAS
        for ( int i=0; i<26; i++) {
            minus[i] = (char) ('a' + i );
        }

        char[] sim;          //               SIMBOLOS
        sim=new char[26];
        sim[0] = '_';
        sim[1] = '$';



        for (int i = 0; i < 26; i++) {          // ARREGLO DE SIMBOLOS
            arregloSim[i] = minus[i];
            arregloSim[i+26] = mayus[i];
        }

        arregloSim[52] = sim[0];               // ARREGLO COMPLETO
        arregloSim[53] = sim[1];

        //0 - 25
        //26 - 51
        //52 - 53
        //54 - 63

        for (int i = 0; i < arregloNum.length; i++) {  // ARREGLO DE NUMEROS
            arregloNum[i] = i;
        }
        id_ing = scan.nextLine();
    }

    public void revision1Term(){
      //  String parts[] = id_ing.split("");
        caracter = id_ing.toCharArray();
        for (int i = 0; i < arregloSim.length; i++) {
            if (caracter[0] == arregloSim[i])
                band1 = false;
            if (band1 == false)
                band2 = true;
        }
    }

    public void revisionComp(){
        for (int i = 1; i < caracter.length; i++) {
            for (int j = 0; j < arregloSim.length; j++) {
                if (!(caracter[i] == arregloSim[j]))
                    band1 = false;
            }
            for (int j = 0; j < arregloNum.length; j++) {
                if (caracter[i] != arregloNum[j])
                    band1 = false;
                if (band1 == false)
                    band3 = true;
            }
        }
    }
    public void validacion(){
        if (band2 && band3 == true) {
            System.out.println("La cadena ingresada pertenece al lenguaje Java");
        }
        else
            System.out.println("La cadena ingresada no pertenece al lenguaje Java");
    }

    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println("Inserte la cadena");
        obj.init();
        obj.revision1Term();
        obj.revisionComp();
        obj.validacion();

    }

}