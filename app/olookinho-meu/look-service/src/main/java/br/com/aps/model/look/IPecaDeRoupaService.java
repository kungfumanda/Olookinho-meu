package br.com.aps.model.look;

public interface IPecaDeRoupaService {

    boolean enoughBalance(Long accountId, Long valueToBeDecreased);

    void updateBalance(Long accountId, Long valueToBeAppended);
}
