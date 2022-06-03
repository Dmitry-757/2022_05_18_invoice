import java.util.Objects;

public class Client {
    private String name;
    private int inn;

    public Client(String name, int inn) throws Exception {
//        if( StoreService.<Client, Integer>isUsingForbidden(this, inn)) { //Explicit type arguments can be inferred
        if( StoreService.isUsingForbidden(this, inn)) {
            throw new Exception("Client with inn "+inn+" already exist!");
        }

        this.name = name;
        this.inn = inn;
        StoreService.addClient(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInn() {
        return inn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return inn == client.inn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(inn);
    }
}
