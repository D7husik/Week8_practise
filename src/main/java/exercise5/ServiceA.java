package exercise5;


import org.springframework.stereotype.Service;

@Service
public class ServiceA {
    private final IdBean idBean;

    public ServiceA(IdBean idBean) {
        this.idBean = idBean;
        System.out.println("ServiceA initialized with IdBean: " + idBean.getId());
    }

    public String getId() {
        return "ServiceA: " + idBean.getId();
    }

    public String getIdWithCounter() {
        return "ServiceA: " + idBean.getId() +
                " (counter: " + idBean.incrementAndGet() + ")";
    }
}
