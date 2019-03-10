package execicio;

import execicio.objetos.Brasil;
import execicio.objetos.Pais;
import execicio.objetos.Russia;

import static execicio.constant.Constants.QUANTIDADE_DOWNLOAD_ILEGAIS_BRASIL;
import static execicio.constant.Constants.QUANTIDADE_DOWNLOAD_ILEGAIS_RUSSIA;

public class FaculdadeExercicioMain {

    public static void main(String args[]) {

        Brasil brasil = new Brasil(QUANTIDADE_DOWNLOAD_ILEGAIS_BRASIL);
        Russia russia = new Russia(QUANTIDADE_DOWNLOAD_ILEGAIS_RUSSIA);
        int anos = 7;

        int baixadosIlegaisBrasil = getQuantidadeDeDownloadsIlegaisPorAno(brasil, anos);
        int baixadosIlegaisRussia = getQuantidadeDeDownloadsIlegaisPorAno(russia, anos);

        System.out.println("Downloads ilegais Brasil em " + anos + " anos " + baixadosIlegaisBrasil);
        System.out.println("Downloads ilegais Russia em " + anos + " anos " + baixadosIlegaisRussia);

        float porcentagemPorAno01 = 0.2f;
        float porcentagemPorAno02 = 4f;

        int anosPrevisao01 = 4;
        int anosPrevisao02 = 2;

        apresentarInformacoes(anosPrevisao01, porcentagemPorAno01, brasil);
        apresentarInformacoes(anosPrevisao02, porcentagemPorAno02, russia);
    }

    private static void apresentarInformacoes(int anos, float porcentagemPorAno, Pais pais) {
        System.out.println("Quantidade de downloads em " + anos + " anos se tiver um aumento de " + porcentagemPorAno + "% por ano");
        System.out.println("Brasil " + getPrevisaoDeAumentoPorAnos(pais,anos,porcentagemPorAno));
        System.out.println("Russia " + getPrevisaoDeAumentoPorAnos(pais,anos,porcentagemPorAno));
    }

    private static int getPrevisaoDeAumentoPorAnos(Pais pais, int anos, float porcentagemPorAno) {
        float porcentagemPorAnoParaCalcular = porcentagemPorAno / 100;

        int quantidade = pais.getQuantidadeDownloadsIlegais();
        int quantidadeDoUltimoAno = pais.getQuantidadeDownloadsIlegais();

        for(int i = 0 ; i < anos ; i++) {
            int quantidadeDesteAno = (int) ((porcentagemPorAnoParaCalcular * quantidade) + quantidadeDoUltimoAno);
            quantidadeDoUltimoAno = quantidadeDesteAno;
            quantidade += quantidadeDesteAno;
        }

        return quantidade;
    }

    private static int getQuantidadeDeDownloadsIlegaisPorAno(Pais pais, int ano) {
        return pais.getQuantidadeDownloadsIlegais() * ano;
    }

}