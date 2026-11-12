package modelo;

/**
 *  Tipos de serviço de reforma oferecidos no CalcuLAR.
 * <p>
 *  É uma lista fechada: o cliente escolhe um desses tipos na tela
 * inicial, e o profissional define quanto cobra por cada um.
 * Cada tipo tem um nome amigável, sem termos técnicos, para
 * ser exibido ao cliente.
 */
public enum TipoServico {
          ALVENARIA("Paredes e Muros"),
          PINTURA("Pintura"),
          REVESTIMENTO("Piso e Revestimento"),
          ELETRICA("Parte Elétrica"),
          HIDRAULICA("Encanamento");

          private final String nomeAmigavel;

 /** 
  * Cria um tipo de serviço com o nome de que será mostrado na tela.
  * 
  *  @param nomeAmigavel nome do serviço em linguagem simples
  */
          TipoServico(String nomeAmigavel) {
                   this.nomeAmigavel = nomeAmigavel;

          }

          /** 
           * Devolve o nome do serviço para exibir ao cliente.
           *
           *  @return nome do serviço sem termos técnicos, por exemplo "Encanamento"
           */                                
          public String getNomeAmigavel() {
                    return nomeAmigavel;
          }
}