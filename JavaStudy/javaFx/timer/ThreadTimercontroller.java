
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ThreadTimercontroller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnStop;

    @FXML
    private Button btnStart;

    @FXML
    private Label lblTime;

    /* 확인용 */
    private boolean stop;

    @FXML
    void initialize() {
        assert btnStop != null : "fx:id=\"btnStop\" was not injected: check your FXML file 'ThreadTimer.fxml'.";
        assert btnStart != null : "fx:id=\"btnStart\" was not injected: check your FXML file 'ThreadTimer.fxml'.";
        assert lblTime != null : "fx:id=\"lblTime\" was not injected: check your FXML file 'ThreadTimer.fxml'.";
        /* 직접 구현 */
        btnStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stop = false;
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

                        while(!stop) {
                            String strTime = simpleDateFormat.format(new Date());

                            /* 일반 쓰레드에서 JAVAFX의 컨트롤 값을 변경시키면
                                JAVAFX에서 컨트롤들을 처리하는 쓰레드와 충돌을 일으키는데
                                이 충돌을 방지하기 위해서는 Platform.runLater() 메서드를 사용하여
                                컨트롤의 값을 변경해야 한다.
                            */
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                lblTime.setText(strTime);
                                }
                            });

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e){

                            }
                        }
                    }
                };
                thread.setDaemon(true);
                thread.start();
            }
        });
        btnStop.setOnAction(event -> {
            stop = true;
        });
    }
}
