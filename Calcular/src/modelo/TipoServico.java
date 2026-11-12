package modelo;

public enum TipoServico {
          ALVENARIA("Paredes e Muros"),
          PINTURA("Pintura"),
          REVESTIMENTO("Piso e Revestimento"),
          ELETRICA("Parte Elétrica"),
          HIDRAULICA("Encanamento");

          private final String nomeAmigavel;

          TipoServico(String nomeAmigavel) {
                   this.nomeAmigavel = nomeAmigavel;

          }

          public String getNomeAmigavel() {
                    return nomeAmigavel;
          }
}