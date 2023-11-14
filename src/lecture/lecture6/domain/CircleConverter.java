package lecture.lecture6.domain;

public class CircleConverter implements EntityConverter<Circle> {
    @Override
    public String toString(Circle object) {
        return object.getId() + "," + object.getName() + "," + object.getRadius();
    }

    @Override
    public Circle fromString(String line) {
        String[] tokens = line.split(",");
        return new Circle(Integer.parseInt(tokens[0]), tokens[1], Double.parseDouble(tokens[2]));
    }
}
