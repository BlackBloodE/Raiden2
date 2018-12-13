import javafx.scene.image.ImageView;

public class Bullet extends ImageView implements Runnable {
    private double BX;
    private double BY;
    private ImageView BIV;
    private boolean bl;

    public Bullet(double x,double y,ImageView iv){
        BX = Player1.X;
        BY = Player1.Y - 51;
        BIV = iv;
    }

    public void run(){
        while (true){
            //IV.setX(X);
            if (Raiden2.space == true) {
                //Y = Thread1.Y - 51;
                //BX = Thread1.X;
                if (BIV.getY() < -50) {
                    bl = false;
                    System.out.println("bl:"+bl);
                }
                if (BIV.getY() > 0){
                    bl = true;
                    System.out.println("bl:"+bl);
                }


            }
            if (BIV.getY() < -50) {
                bl = false;
                System.out.println("bl:"+bl);
            }

            if (bl == true){
                BY = BY - 10;
                BIV.setY(BY);
                System.out.println("BY:"+BY);
                //IV.setX(X);
            }
            else if (bl == false){
                BY = Player1.Y - 51;
                BIV.setY(BY);
                BIV.setX(BX);
                System.out.println("BY:"+BY);
            }



            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
