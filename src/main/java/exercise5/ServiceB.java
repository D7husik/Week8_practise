package exercise5;


import org.springframework.stereotype.Service;

@Service
public class ServiceB {
    private final IdBean idBean;

    public ServiceB(IdBean idBean) {
        this.idBean = idBean;
        System.out.println("ServiceB initialized with IdBean: " + idBean.getId());
    }

    public String getId() {
        return "ServiceB: " + idBean.getId();
    }

    public String getIdWithCounter() {
        return "ServiceB: " + idBean.getId() +
                " (counter: " + idBean.incrementAndGet() + ")";
    }
}