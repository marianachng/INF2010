package tp1;

import java.util.*;
import java.util.stream.Collectors;

public class BaseShape implements Cloneable {
    private Collection<Point2d> coords;

    // TODO Initialiser la liste de points.
    public BaseShape() {
        coords = new ArrayList<Point2d>(); // a verifier quelle structure utiliser
    }

    // TODO prendre une liste de points et creer une nouvelle forme.
    public BaseShape(Collection<Point2d> coords) {
        this.coords = new ArrayList<Point2d>(coords);
    }

    // TODO ajouter ou retirer des coordonnees a la liste de points.
    public BaseShape add(Point2d coord) {
        coords.add(coord);
        return this;
    }
    public BaseShape add(BaseShape shape) {
        coords.addAll(shape.coords);
        return this;
    }
    public BaseShape addAll(Collection<Point2d> coords) {
        this.coords.addAll(coords);
        return this;
    }
    public BaseShape remove(Point2d coord) {
        coords.remove(coord);
        return this;
    }
    public BaseShape remove(BaseShape shape) {
        coords.removeAll(shape.coords);
        return this;
    }
    public BaseShape removeAll(Collection<Point2d> coords) {
        this.coords.removeAll(coords);
        return this;
    }

    // TODO retourner les coordonnees de la liste.
    public Collection<Point2d> getCoords() {
        return coords;
    }

    // TODO retourner une nouvelle liste ou tous les points sont des copy
    public Collection<Point2d> getCoordsDeepCopy() {
        Collection<Point2d> copy = new ArrayList<Point2d>();
        for(Point2d point : coords){
            copy.add(new Point2d(point.X(), point.Y()));
        }
        return copy;
    }

    // TODO appliquer la translation sur la forme.
    public BaseShape translate(Point2d point) {
        for(Point2d currentPoint : coords){
            currentPoint.translate(point);
        }
        return this;
    }

    // TODO appliquer la rotation sur la forme.
    public BaseShape rotate(Double angle) {
        for(Point2d point : coords){
            point.rotate(angle); // peut etre toRad();
        }
        return this;
    }

    // TODO donner la plus grande valeur en X
    public Double getMaxX() {
        Double max = null;
        for(Point2d point : coords){
            if(max == null || max < point.X()){
                max = point.X();
            }
        }
        return max;
    }

    // TODO donner la plus grande valeur en Y
    public Double getMaxY() {
        Double max = null;
        for(Point2d point : coords){
            if(max == null || max < point.Y()){
                max = point.Y();
            }
        }
        return max;
    }

    // TODO donner les plus grandes valeurs en X et Y
    public Point2d getMaxCoord() {
        return new Point2d(getMaxX(), getMaxY());
    }

    // TODO donner la plus petite valeur en X
    public Double getMinX() {
        Double min = null;
        for(Point2d point : coords){
            if(min == null || min > point.X()){
                min = point.X();
            }
        }
        return min;
    }
    // TODO donner la plus petite valeur en Y
    public Double getMinY() {
        Double min = null;
        for(Point2d point : coords){
            if(min == null || min > point.Y()){
                min = point.Y();
            }
        }
        return min;
    }

    // TODO donner les plus petites valeurs en X et Y
    public Point2d getMinCoord() {
        return new Point2d(getMinX(), getMinY());
    }

    // TODO retourner une nouvelle forme.
    public BaseShape clone() {
        Collection<Point2d> coordsCopy = getCoordsDeepCopy();
        return new BaseShape(coordsCopy);
    }
}
