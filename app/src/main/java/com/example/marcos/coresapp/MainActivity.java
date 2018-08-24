package com.example.marcos.coresapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar skVermelho;
    private SeekBar skVerde;
    private SeekBar skAzul;
    private TextView tvOutput;
    private TextView tvColor;
    private String[] hexColor = {"00", "00", "00"};

    public class EventSeek implements SeekBar.OnSeekBarChangeListener {
        private byte color;

        public EventSeek(byte color) {
            this.color = color;
        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            setHexNumber(progress, color);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        skVermelho = (SeekBar)findViewById(R.id.skVermelho);
        skVerde    = (SeekBar)findViewById(R.id.skVerde);
        skAzul     = (SeekBar)findViewById(R.id.skAzul);

        skVermelho.setOnSeekBarChangeListener(new EventSeek((byte)0));
        skVerde.setOnSeekBarChangeListener(new EventSeek((byte)1));
        skAzul.setOnSeekBarChangeListener(new EventSeek((byte)2));

        tvOutput = (TextView)findViewById(R.id.tvOutput);
        tvColor  = (TextView)findViewById(R.id.tvColor);

        setColor("#" + hexColor[0] + hexColor[1] + hexColor[2]);
    }

    private void setColor(String str) {
        tvOutput.setText(str);
        tvColor.setBackgroundColor(Color.parseColor(str));
    }

    private void setHexNumber(int progress, byte color) {
        String c = Integer.toHexString(progress);
        hexColor[color] = (c.length() == 2 ? "" : "0") + c;
        setColor("#" + hexColor[0] + hexColor[1] + hexColor[2]);
    }
}

