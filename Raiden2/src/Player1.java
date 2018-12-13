

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Player1 extends ImageView implements Runnable{
    private String id;
    static double X = 0;
    static double Y = 0;
    static double by;
    static double bx;

    public ImageView player;

    public Player1(String str,double x,double y,ImageView IV){
        id = str;
        X = x;
        Y = y;
        player = IV;
    }
    public void run(){
        //System.out.println(this.getId());
        while (true){
            if (Raiden2.w == true){
                if (Y <= -50){
                }
                else {
                    Y = Y - 10;
                }
            }
            if (Raiden2.s == true){
                if (Y >= 600){
                }
                else {
                    Y = Y + 10;
                }
            }
            if (Raiden2.a == true){
                if (X <= -70){
                }
                else {
                    X = X - 10;
                }
            }
            if (Raiden2.d == true){
                if (X >= 400){
                }
                else {
                    X = X + 10;
                }
            }
            if (Raiden2.space == true){
                //ImageView bullet0 = new ImageView(new Image("bullet.png"));
                bx = X;
                by = Y - 51;
                System.out.println("p1:"+by);
            }
            player.setX(X);
            //System.out.println("playerX:"+player.getX());
            player.setY(Y);
            //System.out.println("playerY:"+player.getY());

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
