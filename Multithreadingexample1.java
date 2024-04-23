public class Multithreadingexample1 extends Application {
    public static void main(String[] args) {
        Application.launch(args);
        
    }

    public void start(Stage primaryStage) throws Exception{
        BorderPane pane= new BorderPane();
        Hbox buttons = new HBox();
        Button countUp = new Button("Count to 10");
        countUp.setOnAction(e->{
            for (int i =1; i<=10;i++){
                System.out.println(i);
                try{
                    Thread.sleep(1000);
                } catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        Button countDown = new Button ("Count down from 10");
        countDown.setOnAction(e->{
            for (int i = 10; i>0; i--){
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        buttons.getChildren().addAll(countUp, countDown);
        pane.setCenter(buttons);
        pane.setAlignment(countUp, Pos.CENTER);
        button.setAlignment(Pos.CENTER);
        Scene scene = new Scene(pane, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}

public class Countup implements Runnable {
    public void run(){
        for (int i=1; i<=10; i++){
            System.out.println("Count up" +i);
            try {
                Thread.sleep(1000);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}

public class CountDown  implements Runnable {
    public void run(){
        for (int i = 10; i>0; i--){
            System.out.println("Count Down " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}