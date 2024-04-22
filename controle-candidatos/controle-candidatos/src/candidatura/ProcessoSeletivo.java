package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        System.out.println("*** PROCESSO SELETIVO ***");
        String [] candidatos = { "CARLOS", "EDUARDO", "THOMPSON", "MIGUEL", "MATHEUS" };

        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }
        // selecaoCandidatos();
        // imprimirSelecionados();
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando) {
                tentativasRealizadas++;
            
            } else {
                System.out.println("CONTATO REALIZADO COM SUCESSO");
            }
        } while(continuarTentando && tentativasRealizadas < 3);

        if (atendeu) {
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVAS");
        } else {
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NÚMERO MÁXIMO DE TENTATIVAS " + tentativasRealizadas + " REALIZADA");
        }
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }
    
    static void imprimirSelecionados() {
        String [] candidatos = { "Carlos", "Eduardo", "Thompson", "Cadu", "Miguel", "Matheus" };
        System.out.println("Imprimindo a lista de candidatos informando o índice do elemento");
        
        for(int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de nº: " + (indice + 1) + " é " + candidatos[indice]);
        }
        
        System.out.println("Forma abreviada de interação for each");

        for (String candidato : candidatos) {
            System.out.println("O candidato selecionado foi: " + candidato);
        }
    }

    static void selecaoCandidatos() {
        String [] candidatos = { "Carlos", "Eduardo", "Thompson", "Cadu", "Miguel", "Matheus" };

        int candidatosSelecionados = 0;
        int candidatosAtuais = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < candidatos.length) {
            String candidato = candidatos[candidatosAtuais];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " Solicitou este valor de salário " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga!");
                candidatosSelecionados++;
            } 
            candidatosAtuais++;
        }
    } 

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if( salarioBase > salarioPretendido ) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if ( salarioBase == salarioPretendido ) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
     
}
