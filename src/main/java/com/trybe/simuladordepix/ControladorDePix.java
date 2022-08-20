package com.trybe.simuladordepix;

import java.io.IOException;

/**
 * Class Controldor.
 */

public class ControladorDePix {

  private final ProcessadorDePix processadorDePix;

  public ControladorDePix(ProcessadorDePix processadorDePix) {
    this.processadorDePix = processadorDePix;
  }

  /**
   * Método a ser executado no momento em que a pessoa usuária confirmar
   * a operação de Pix.
   *
   * @param valor Valor em centavos a ser transferido.
   * @param chave Chave Pix do beneficiário da transação.
   * @return Mensagem a ser exibida à pessoa usuária, informando-a sobre
   */
  public String aoConfirmarPix(int valor, String chave) {

    try {
      processadorDePix.executarPix(valor, chave);

      return Mensagens.SUCESSO;
    } catch (ErroDePix error) {
      return error.getMessage();
    } catch (IOException e) {
      return Mensagens.ERRO_DE_CONEXAO;
    }
  }
}
