package com.example.logonrmlocal.demoqrcode

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_video.*

class VideoActivity : AppCompatActivity(), YouTubePlayer.OnInitializedListener {

    private var youTubePlayer: YouTubePlayer? = null

    override fun onInitializationSuccess(provider: YouTubePlayer.Provider?, player: YouTubePlayer?, wasRestored: Boolean) {
        if (!wasRestored) {
            youTubePlayer = player
            youTubePlayer?.setFullscreen(true)
            youTubePlayer?.setShowFullscreenButton(false)
            player?.let {
                it.cueVideo(intent.getStringExtra("tghsZJ193rM"))
            }
        }

    }

    override fun onInitializationFailure(provider: YouTubePlayer.Provider?, errorReason: YouTubeInitializationResult?) {
        val error = String.format("Erro", errorReason.toString())
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        ytVideo.initialize("AIzaSyASsVvWmEI9nIX0HGnZIYyVWCVtLMcssTo", this)
    }
}
