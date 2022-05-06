package com.example.finalproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.concurrent.TimeUnit;

public class MusicFragment extends Fragment {

    //Initialize variable
    TextView playerPosition,playerDuration;
    SeekBar seekBar;
    ImageView btRew,btPlay,btPause,btFf;

    MediaPlayer mediaPlayer;
    Handler handler = new Handler();
    Runnable runnable;
    private Object View;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.music_fragment,container,false);

        playerPosition = view.findViewById(R.id.player_position);
        playerDuration = view.findViewById(R.id.player_duration);
        seekBar = view.findViewById(R.id.seek_bar);
        btRew = view.findViewById(R.id.bt_rew);
        btPlay = view.findViewById(R.id.bt_play);
        btPause = view.findViewById(R.id.bt_pause);
        btFf = view.findViewById(R.id.bt_ff);

        //Initialize media player
        //CSDN解决帖子<https://bbs.csdn.net/topics/391881897?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522165184904716780357225441%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=165184904716780357225441&biz_id=&utm_medium=distribute.pc_search_result.none-task-discussion_topic-2~all~first_rank_ecpm_v1~rank_v31_ecpm-2-391881897-null-null.142^v9^pc_search_result_cache,157^v4^control&utm_term=fragment%E4%B8%AD%E6%92%AD%E6%94%BE%E9%9F%B3%E4%B9%90&spm=1018.2226.3001.4187>
        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.ghost);//使用this无法获取当前fragment 同时导入音频文件时注意是否识别（建议wav格式）

        //Initialize runnable
        runnable = new Runnable() {
            @Override
            public void run() {
                //Set progress on seek bar
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                //Handler post delay for 0.5s
                handler.postDelayed(this,500);
            }
        };

        //Get duration of media player
        int duration = mediaPlayer.getDuration();
        //Convert millisecond to minute and second
        String sDuration = convertFormat(duration);
        //Set duration on text view
        playerDuration.setText(sDuration);

        btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                //Hide play button
                btPlay.setVisibility(android.view.View.GONE);
                //Show pause button
                btPause.setVisibility(android.view.View.VISIBLE);
                //Start media player
                mediaPlayer.start();
                //Set max on seek bar
                seekBar.setMax(mediaPlayer.getDuration());
                //Start handler
                handler.postDelayed(runnable,0);
            }
        });

        btPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                //Hide pause button
                btPause.setVisibility(android.view.View.GONE);
                //Show play button
                btPlay.setVisibility(android.view.View.VISIBLE);
                //Pause media player
                mediaPlayer.pause();
                //Stop handler
                handler.removeCallbacks(runnable);
            }
        });

        btFf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                //Get current position of media player
                int currentPosition = mediaPlayer.getCurrentPosition();
                //Get duration of media player
                int duration = mediaPlayer.getDuration();
                //Check condition
                if (mediaPlayer.isPlaying() && duration != currentPosition){
                    //When media is playing and duration is not equal to current position
                    //Fast forward for 5 seconds
                    currentPosition = currentPosition + 5000;
                    //Set current position on text view
                    playerPosition.setText(convertFormat(currentPosition));
                    //Set progress on seek bar
                    mediaPlayer.seekTo(currentPosition);
                }
            }
        });

        btRew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                //Get current position of media player
                int currentPosition = mediaPlayer.getCurrentPosition();
                //Check condition
                if (mediaPlayer.isPlaying() && currentPosition > 5000){
                    //When media is playing and current position in greater than 5s
                    //Rewind for 5s
                    currentPosition = currentPosition - 5000;
                    //Get current position on text view
                    playerPosition.setText(convertFormat(currentPosition));
                    //Set progress on seek bar
                    mediaPlayer.seekTo(currentPosition);
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //Check condition
                if (b){
                    //When drag the seek bar
                    //Set progress on seek bar
                    mediaPlayer.seekTo(i);
                }
                //Set current position on text view
                playerPosition.setText(convertFormat(mediaPlayer.getCurrentPosition()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                //Hide pause button
                btPause.setVisibility(android.view.View.GONE);
                //Show play button
                btPlay.setVisibility(android.view.View.VISIBLE);
                //Set media player to initial position
                mediaPlayer.seekTo(0);
            }
        });

        return view;
    }

    @SuppressLint("DefaultLocale")
    private String convertFormat(int duration){
        return String.format("%02d:%02d"
                , TimeUnit.MILLISECONDS.toMinutes(duration)
                ,TimeUnit.MILLISECONDS.toSeconds(duration) -
                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
    }

}
