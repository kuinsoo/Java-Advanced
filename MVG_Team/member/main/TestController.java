package member.main;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import member.dao.ProdDao;
import member.service.IProdService;
import member.service.ProdService;
import member.vo.ProdVo;

public class TestController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker dataPicker;

    @FXML
    private ListView<ProdVo> listView;

    @FXML
    private MediaView mediaView;

    @FXML
    void initialize() {
        assert dataPicker != null : "fx:id=\"dataPicker\" was not injected: check your FXML file 'test.fxml'.";
        assert listView != null : "fx:id=\"listView\" was not injected: check your FXML file 'test.fxml'.";
        assert mediaView != null : "fx:id=\"mediaView\" was not injected: check your FXML file 'test.fxml'.";


        /*날짜값*/
        LocalDate localDate = dataPicker.getValue();
        if (localDate != null) {
            System.out.println("dateExit: " + localDate.toString());
        }

        /*리스트뷰*/
        IProdService service = ProdService.getInstance();
        List<ProdVo> prodVoList = service.getAllProd();
        ObservableList<ProdVo> items = FXCollections.observableArrayList(prodVoList);
        listView.setItems(items);



        /*미디어*/

//        Media media = new Media(getClass().getResource("media/audio.mp3").toString());



        // 해당 상태가 되면 실행할 Runnable 설정
      /*  mPlayer.setOnReady(new Runnable() {
            @Override
            public void run() {
//                btnPlay.setDisable(false);
//                btnPause.setDisable(true);
//                btnStop.setDisable(true);
                mPlayer.play();
                mediaView.setVisible(true);
                if (mPlayer.isAutoPlay()) {

                }
            }
        });*/

//        mPlayer.setOnPlaying(() -> {
//            btnPlay.setDisable(true); btnPause.setDisable(false); btnStop.setDisable(false);
//        });
//
//        mPlayer.setOnPaused(() -> {
//            btnPlay.setDisable(false); btnPause.setDisable(true); btnStop.setDisable(false);
//        });
//
//        mPlayer.setOnEndOfMedia(() -> {
//            btnPlay.setDisable(false); btnPause.setDisable(true); btnStop.setDisable(true);
//        });
//
//        mPlayer.setOnStopped(() -> {
//            btnPlay.setDisable(false); btnPause.setDisable(true); btnStop.setDisable(true);
//        });
//
//        btnPlay.setOnAction(event -> {
//            if (endOfMedia) {
//                mPlayer.stop();
//                mPlayer.seek(mPlayer.getStartTime());
//            }
//            mPlayer.play();
//            endOfMedia = false;
//        });
//
//        btnPause.setOnAction(event->mPlayer.pause());
//        btnStop.setOnAction(event->mPlayer.stop());
    }



}
