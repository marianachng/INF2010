package tp1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Rectangle extends BaseShape {
    // TODO creer un rectangle avec une largeur et une longueur.
    public Rectangle(Double width, Double height) {
        Point2d topLeftCorner = new Point2d(-width / 2, height / 2);
        Point2d topRightCorner = new Point2d(width / 2, height / 2);
        Point2d bottomLeftCorner = new Point2d(-width / 2, -height / 2);
        Point2d bottomeRightCorner = new Point2d(width / 2, -height / 2);
        Collection<Point2d> corners = new ArrayList<Point2d>(Arrays.asList(
                topLeftCorner, topRightCorner, bottomeRightCorner, bottomLeftCorner));
        //On aurait pu mettre 4 .add (une pur chaque Point2D);
    }

    // TODO creer un rectangle avec les dimensions contenu dans un Point.
    public Rectangle(Point2d dimensions) {
        Double width = dimensions.X();
        Double height = dimensions.Y();
        Point2d topLeftCorner = new Point2d(-width / 2, height / 2);
        Point2d topRightCorner = new Point2d(width / 2, height / 2);
        Point2d bottomLeftCorner = new Point2d(-width / 2, -height / 2);
        Point2d bottomeRightCorner = new Point2d(width / 2, -height / 2);
        Collection<Point2d> corners = new ArrayList<Point2d>(Arrays.asList(
                topLeftCorner, topRightCorner, bottomeRightCorner, bottomLeftCorner));
    }

    // TODO initialiser le parent.
    private Rectangle(Collection<Point2d> coords) {
        super(coords);
    }

    // TODO appliquer la translation sur la forme.
    @Override
    public Rectangle translate(Point2d point) {
        super.translate(point);
        return this;
    }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Rectangle rotate(Double angle) {
        super.rotate(angle);
        return this;
    }

    // TODO retourner une nouvelle forme.
    @Override
    public Rectangle clone() {
        Rectangle rect = new Rectangle(getCoordsDeepCopy());
        return rect;
        //essayer de call clone, voir le line avec baseShape.clone();
    }
}
