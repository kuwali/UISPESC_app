package com.uispesc.app.uispesc_app.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.uispesc.app.uispesc_app.R;

/*
 * Copyright 2016 Kustiawanto Halim.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class BroadcastFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_broadcast, container, false);

        String frameVideo = "<html><body><iframe class=\"youtube-player\" type=\"text/html\" width=\"320\" height=\"240\" src=\"http://www.youtube.com/embed/cJvikcJyrMY\" frameborder=\"0\"></body></html>";

        WebView displayVideo = (WebView) view.findViewById(R.id.webviewBroadcast);
        displayVideo.getSettings().setJavaScriptEnabled(true);
        displayVideo.loadData(frameVideo, "text/html", "utf-8");

        return view;
    }


}
