package base;

public class Rectangle {
    Vector2D position;
    int height;
    int width;

    public Rectangle() {
        this(new Vector2D(), 5, 5);
    }

    public Rectangle(Vector2D position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    // chắc sẽ đúng trong trường hợp width height dương
    public boolean intersects(Rectangle other) {
        boolean intersects = false;
        for (int i =0; i <= other.width; i+=other.width) {
            for (int j=0; j <= other.height; j+= other.height) {
                Vector2D dinh = other.position.addThis(i,j);
                // 2 vòng lặp với dòng trên là để lấy 4 đỉnh của other nhé
                // còn mấy dòng dưới là so sánh x,y của 4 đỉnh other với 4 đỉnh this, gặp trường hợp nào ở trong là break luôn
                Vector2D comparator1 = this.position.substractThis(dinh);
                Vector2D comparator2 = this.position.addThis(width, height).substractThis(dinh);
                if (comparator1.x <= 0 && comparator1.y <= 0) {
                    if (comparator2.x >= 0 && comparator2.y >= 0) {
                        intersects = true;
                        break;
                    }
                }

            }
        }
        return intersects;
    }

    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle((new Vector2D(0, 0)), 10, 10);
        Rectangle rect2 = new Rectangle((new Vector2D(5, 5)), 10, 10);
        Rectangle rect3 = new Rectangle((new Vector2D(5, -15)), 10, 10);
    }
}

