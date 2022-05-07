package com.example.finalproject;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;
import android.widget.MediaController;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class VideoFragment extends Fragment {

    VideoView videoView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.video_fragment,container,false);

        videoView = view.findViewById(R.id.videofragment_vv);
        videoView.setVideoURI(Uri.parse("android.resource://com.example.finalproject/" + R.raw.video));
        videoView.setMediaController(new MediaController(getActivity()));
        videoView.start();

        return view;
    }

}
