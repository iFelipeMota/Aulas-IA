
package semana03;

public class Exerciocio02_2 {

    public static void main(String[] args) {
     String p1 = "parmeira";
     String p2 = "palmeiras";
     String p3 = "corinthians";
     String p4 = "curingão";
     String[] glossario = {"palmeira", "santos", "corinthians", "são paulo", "portuguesa"};
     String[][] referencia = {
         {"sem mundial","verdão"},
         {"alvinegro praiano"},
         {"curintia"},
         {"tricolor"},
         {"lusa"}
     };
        
        System.out.println("Conta Iguais:");
        System.out.println(contaIguais(p1, p2));
        System.out.println(contaIguais(p1, p3));
        System.out.println("");
       
        System.out.println("Conta Proporção:");
        System.out.println(contaProporcao(p1, p2));
        System.out.println(contaProporcao(p1, p3));
        System.out.println("");
        
        System.out.println("Conta Posição:");
        System.out.println(contaPosicao(p1, p2));
        System.out.println(contaPosicao(p1, p3));
        System.out.println("");
        
        System.out.println("Obter Similaridade:");
        System.out.println(obterSimilaridade(p1, p2));
        System.out.println(obterSimilaridade(p1, p3));
        System.out.println("");
                
        System.out.println("Obter Distância: ");
        System.out.println(obterDistancia(p1, p2));
        System.out.println(obterDistancia(p1, p3));
        System.out.println("");
        
        System.out.println("Obter Mais Próximo: ");
        System.out.println(indicarTextoMaisProximo(p4, glossario));
        System.out.println("Obter Mais Próximo Com Referencia: ");
        System.out.println(indicarMaisProximo(p4, glossario, referencia));
    }
    
    public static String indicarTextoMaisProximo(String p1, String[] glossario){
        String maisProximo = "";
        double menorDistancia = 1;
        for(int i = 0; i < glossario.length; i++){
            double distancia = obterDistancia(p1, glossario[i]);
            if(distancia < menorDistancia){
                menorDistancia = distancia;
                maisProximo = glossario[i];
            }
        }
        String indicacao = "Você quis dizer "+ maisProximo + "?";
        System.out.println(menorDistancia);
        return indicacao;
    }
    
    public static String[] indicarReferenciaMaisProxima(String p1, String[][] referencia){
        String maisProximo []= new String[2];
        double menorDistancia = 1;
        for(int i = 0; i < referencia.length; i++){
            for(int j = 0; j<referencia[i].length; j++){
                System.out.println(referencia[i][j]);
                double distancia = obterDistancia(p1, referencia[i][j]);
                if(distancia < menorDistancia){
                    maisProximo = referencia[i];
                    menorDistancia = distancia;
                }
            }
        }
        return maisProximo;
    }
    
    public static String indicarMaisProximo(String p1, String[] glossario, String[][] referencia){
        String maisProximo = "";
        double menorDistancia = 1;
        for(int i = 0; i < glossario.length; i++){
            double distancia = obterDistancia(p1, glossario[i]);
            if(distancia < menorDistancia){
                menorDistancia = distancia;
                maisProximo = glossario[i];
            }
        }
        String[] referenciaProxima = indicarReferenciaMaisProxima(p1, referencia);
        
        if(menorDistancia > Integer.parseInt(referenciaProxima[1])){
            maisProximo = referenciaProxima[0];
        }
        String indicacao = "Você quis dizer "+ maisProximo + "?";
        System.out.println(menorDistancia);
        return indicacao;
    }
    
    public static double obterDistancia(String p1, String p2){
        double distancia = 0;
        double pontuacaoMaxima = obterPontuacao(p2, p2);
        double pontuacaoObtida = obterPontuacao(p1, p2);
        distancia = 1 - pontuacaoObtida/pontuacaoMaxima;
        return distancia;
    }
    
    public static double obterSimilaridade(String p1, String p2) {
        double similaridade = 0;
        double pontuacaoMaxima = obterPontuacao(p2, p2);
        double pontuacaoObtida = obterPontuacao(p1, p2);
        similaridade = pontuacaoObtida/pontuacaoMaxima;

        return similaridade;
    }
    
    public  static int obterPontuacao(String p1, String p2){
        int pontuacao = 0;
        pontuacao += contaIguais(p1, p2);
        pontuacao += contaProporcao(p1, p2);
        pontuacao += contaPosicao(p1, p2);
        return pontuacao;
    }
      
    public static int contaIguais(String p1, String p2){
            int pontos = 0;
            for(int i = 0; i < p1.length(); i++){
                char l1 = p1.charAt(i);
                for(int j = 0; j < p2.length(); j++){
                    char l2 = p2.charAt(j);
                    if(l1 == l2)
                        pontos++;
                }
            }
            return pontos;
    }
    public static int contaProporcao(String p1, String p2){
        int pontos = 0;
        for (int i = 0; i < p1.length(); i++){
            char letra = p1.charAt(i);
            int qtdeL1 = contaLetras(p1, letra);
            int qtdeL2 = contaLetras(p2, letra);
            if(qtdeL1 == qtdeL2){
                pontos += 2;
            }
        }
        return pontos;
    }
    public static int contaPosicao(String p1, String p2){
        int pontos = 0;
        for (int i = 0; i < p1.length(); i++){
            if (i >= p2.length())
                break;
            char l1 = p1.charAt(i);
            char l2 = p2.charAt(i);
            if(l1==l2)
                pontos += 3;
        }
        return pontos;
    }

    private static int contaLetras(String p1, char letra) {
        int qtde = 0;
        for(int i = 0; i<p1.length(); i++){
            char l1 = p1.charAt(i);
            if(l1 == letra)
                qtde++;
        }
        return qtde;
    }
    
}
