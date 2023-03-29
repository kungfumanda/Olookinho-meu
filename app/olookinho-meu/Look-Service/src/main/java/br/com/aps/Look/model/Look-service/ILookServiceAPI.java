package br.com.aps.olookinho.model.Look;

public class ILookServiceAPI {

    boolean enoughBalance(Long lookId, Long valueToBeDecreased);

    void updateBalance(Long lookId, Long valueToBeAppended);
}
}
