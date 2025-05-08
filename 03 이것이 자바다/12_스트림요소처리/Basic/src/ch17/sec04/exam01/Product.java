package ch17.sec04.exam01;

public class Product {
    private int pno;
    private String name;
    private String company;
    private int price;

    //생성자 - 롬복 / Generate
    public Product(int pno, String name, String company, int price) {
        this.pno = pno;
        this.name = name;
        this.company = company;
        this.price = price;
    }

    //Getter - 롬복 / Generate

    public int getPno() {
        return pno;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public int getPrice() {
        return price;
    }

    //Setter - 롬복 / Generate

    public void setPno(int pno) {
        this.pno = pno;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    //toString - 롬복 / Generate

    @Override
    public String toString() {
        return "Product{" +
                "pno=" + pno +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", price=" + price +
                '}';
    }
}
