package br.com.unicesumar.common.entidade;

public interface State<E extends Enum<E>> {

    E nextState();
}
