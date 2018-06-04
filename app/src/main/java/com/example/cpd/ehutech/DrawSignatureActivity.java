package com.example.cpd.ehutech;

import android.content.DialogInterface;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.UUID;

public class DrawSignatureActivity extends AppCompatActivity implements MediaStore.Images.ImageColumns{
    Button buttonnew;
    Button buttonsave;
    DrawingView drawView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_signature);
        Anhxa();
        KyLai();
        LuuChyKy();
    }
void Anhxa(){
    buttonnew = findViewById(R.id.btn_new);
    buttonsave = findViewById(R.id.btn_save);
    drawView = findViewById(R.id.drawing);
}
void KyLai(){
    buttonnew.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //new button
            AlertDialog.Builder newDialog = new AlertDialog.Builder(DrawSignatureActivity.this);
            newDialog.setTitle("Ký Tên");
            newDialog.setMessage("Bạn Muốn Ký Lại Tên?");
            newDialog.setPositiveButton("Đồng Ý", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){
                    drawView.startNew();
                    dialog.dismiss();
                }
            });
            newDialog.setNegativeButton("Hủy", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){
                    dialog.cancel();
                }
            });
            newDialog.show();
        }
    });
}
void LuuChyKy(){
    buttonsave.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder saveDialog = new AlertDialog.Builder(DrawSignatureActivity.this);
            saveDialog.setTitle("Ký Tên");
            saveDialog.setMessage("Lưu Chữ Ký?"+ "\n" + "Vui Lòng Giữ Chữ Ký Để Đối Chiếu Nếu Cần Thiết");
            saveDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){
                    //save drawing
                    drawView.setDrawingCacheEnabled(true);
                    String imgSaved = MediaStore.Images.Media.insertImage(
                            getContentResolver(), drawView.getDrawingCache(),
                            UUID.randomUUID().toString()+".png", "drawing");
                    if(imgSaved!=null){
                        Toast savedToast = Toast.makeText(getApplicationContext(),
                                "Lưu Thành Công!!", Toast.LENGTH_SHORT);
                        savedToast.show();
                    }
                    else{
                        Toast unsavedToast = Toast.makeText(getApplicationContext(),
                                "Oops! Lưu Thất Bại.", Toast.LENGTH_SHORT);
                        unsavedToast.show();
                    }
                    drawView.startNew();
                }
            });
            saveDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){
                    dialog.cancel();
                }
            });
            saveDialog.show();
        }
    });
}
}
