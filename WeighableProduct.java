package groupproject;

class WeighableProduct extends Product {

    public double getPrice(double weight) {
        return price * weight;
    }
}