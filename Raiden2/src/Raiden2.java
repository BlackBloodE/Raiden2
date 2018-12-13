import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Raiden2 extends Application {

    static ImageView background = new ImageView(new Image("bg.png"));
    static ImageView player1 = new ImageView(new Image("player.png"));
    static ImageView bullet1 = new ImageView(new Image("bullet.png"));
    static boolean w = false;
    static boolean s = false;
    static boolean a = false;
    static boolean d = false;
    static boolean space = false;
    static Group root = new Group();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("雷電");

        //Group root = new Group();

        Scene scene = new Scene(root,480,720);
        root.requestFocus();//很重要!!!沒有這個鍵盤事件會沒反應
        root.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()){
                    case W:
                        w = true;
                        System.out.println("w:"+w);
                        break;
                    case S:
                        s = true;
                        System.out.println("s:"+s);
                        break;
                    case A:
                        a = true;
                        System.out.println("a:"+a);
                        break;
                    case D:
                        d = true;
                        System.out.println("d:"+d);
                        break;
                    case SPACE:
                        space = true;
                        System.out.println("空白鍵:"+space);
                        Thread bs = new Thread(new Bullet_Shoot(Player1.by,Player1.bx));
                        bs.start();
                        break;
                }
            }
        });
        root.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                switch (e.getCode()){
                    case W:
                        w = false;
                        System.out.println("w:"+w);
                        break;
                    case S:
                        s = false;
                        System.out.println("s:"+s);
                        break;
                    case A:
                        a = false;
                        System.out.println("a:"+a);
                        break;
                    case D:
                        d = false;
                        System.out.println("d:"+d);
                        break;
                    case SPACE:
                        space = false;
                        System.out.println("空白鍵:"+space);
                        break;
                }
            }
        });

        // Set the scene and display the stage
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        //設定背景
        background.setX(0);
        background.setY(-1083);
        background.setFitHeight(1803);
        background.setFitWidth(480);
        root.getChildren().add(background);

        //設定背景動畫
        KeyValue yValue  = new KeyValue(background.yProperty(), -183);
        KeyFrame keyFrame  = new KeyFrame(Duration.millis(5000), yValue);
        Timeline timeline  = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);
        timeline.getKeyFrames().addAll(keyFrame);
        timeline.play();

        //設定戰機
        player1.setX(165);
        player1.setY(556);
        player1.setFitWidth(150);
        player1.setFitHeight(150);
        root.getChildren().add(player1);

        //戰機控制
        Thread thread1 = new Thread(new Player1("thread1",player1.getX(),player1.getY(),player1));
        thread1.start();

        //設定子彈
        bullet1.setX(165);
        bullet1.setY(1080);
        bullet1.setFitWidth(150);
        bullet1.setFitHeight(150);
        root.getChildren().add(bullet1);

        //子彈控制
//        Thread thread_bullet = new Thread(new Bullet(bullet1.getX(),bullet1.getY(),bullet1));
//        thread_bullet.start();

    }
}
