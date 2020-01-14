package com.example.practicatema5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConfigurarNotificacion extends AppCompatActivity {

    EditText txtTitulo;
    EditText txtMensaje;
    EditText txtSeg;
    Button btnEnviar;

    final String CHANNEL_ID = "Id del Canal";
    final int NOTIFICATION_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_notificacion);
        createNotificationChannel();

        txtTitulo = (EditText) findViewById(R.id.txtTitulo);
        txtMensaje = (EditText) findViewById(R.id.txtMensaje);
        txtSeg = (EditText) findViewById(R.id.txtSeg);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                notificacion(v);

            }
        });
    }

    public void notificacion(View v) {
        Intent abrirApp = new Intent(getBaseContext(), Inicio.class);
        PendingIntent pendingAbrirApp = PendingIntent.getActivity(this, 0, abrirApp, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.haloicon)
                .setContentTitle(txtTitulo.getText().toString())
                .setContentText(txtMensaje.getText().toString())
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingAbrirApp);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(0, builder.build());
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Nombre";
            String description = "Descripción";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

}
