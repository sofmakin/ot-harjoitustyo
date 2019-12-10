
package snakegame.domain;

/**
 * 
 * Pelialustan pisteitä ilmentävä luokka.
 */
public class Point {
    
    public  int x;
    public int y;

    /**
     *Konstruktori luo uuden pisteen.
     * 
     * @param x käyttäjän antama x-koordinaatti
     * 
     * @param y käyttäjän antama y-koordinaatti
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point:" + "x=" + x + ", y=" + y;
    }
    
    
}
