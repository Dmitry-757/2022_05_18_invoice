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
    }

    public String getName() {
        return name;
    }

    public int getInn() {
        return inn;
    }

}
