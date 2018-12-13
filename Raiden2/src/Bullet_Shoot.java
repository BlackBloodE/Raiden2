import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bullet_Shoot extends Thread{
    private double Y;
    private double X;
    private ImageView IVB = new ImageView(new Image("bullet.png"));
    public Bullet_Shoot(double y,double x){
        Y = y;
        X = x;
        IVB.setX(X);
        IVB.setY(Y);
        IVB.setFitWidth(150);
        IVB.setFitHeight(150);
        Raiden2.root.getChildren().add(IVB);
    }
    public void run(){

        while (true){
            if (Y > -150 && Y < 720){
                Y = Y - 10;
                IVB.setY(Y);
            }
            else if (Y <= -150){
                System.out.println("break");
                break;
            }

            System.out.println("in"+Y);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
