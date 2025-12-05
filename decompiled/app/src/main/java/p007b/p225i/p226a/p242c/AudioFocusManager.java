package p007b.p225i.p226a.p242c;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.Objects;
import org.webrtc.MediaStreamTrack;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.SimpleExoPlayer;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p263t2.AudioAttributes;

/* compiled from: AudioFocusManager.java */
/* renamed from: b.i.a.c.t0, reason: use source file name */
/* loaded from: classes3.dex */
public final class AudioFocusManager {

    /* renamed from: a */
    public final AudioManager f7658a;

    /* renamed from: b */
    public final a f7659b;

    /* renamed from: c */
    @Nullable
    public b f7660c;

    /* renamed from: d */
    @Nullable
    public AudioAttributes f7661d;

    /* renamed from: e */
    public int f7662e;

    /* renamed from: f */
    public int f7663f;

    /* renamed from: g */
    public float f7664g = 1.0f;

    /* renamed from: h */
    public AudioFocusRequest f7665h;

    /* compiled from: AudioFocusManager.java */
    /* renamed from: b.i.a.c.t0$a */
    public class a implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: j */
        public final Handler f7666j;

        public a(Handler handler) {
            this.f7666j = handler;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            this.f7666j.post(new RunnableC2631c(this, i));
        }
    }

    /* compiled from: AudioFocusManager.java */
    /* renamed from: b.i.a.c.t0$b */
    public interface b {
    }

    public AudioFocusManager(Context context, Handler handler, b bVar) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        Objects.requireNonNull(audioManager);
        this.f7658a = audioManager;
        this.f7660c = bVar;
        this.f7659b = new a(handler);
        this.f7662e = 0;
    }

    /* renamed from: a */
    public final void m3460a() {
        if (this.f7662e == 0) {
            return;
        }
        if (Util2.f6708a >= 26) {
            AudioFocusRequest audioFocusRequest = this.f7665h;
            if (audioFocusRequest != null) {
                this.f7658a.abandonAudioFocusRequest(audioFocusRequest);
            }
        } else {
            this.f7658a.abandonAudioFocus(this.f7659b);
        }
        m3463d(0);
    }

    /* renamed from: b */
    public final void m3461b(int i) {
        b bVar = this.f7660c;
        if (bVar != null) {
            SimpleExoPlayer.b bVar2 = (SimpleExoPlayer.b) bVar;
            boolean zMo2908j = SimpleExoPlayer.this.mo2908j();
            SimpleExoPlayer.this.m3289m0(zMo2908j, i, SimpleExoPlayer.m3282g0(zMo2908j, i));
        }
    }

    /* renamed from: c */
    public void m3462c(@Nullable AudioAttributes audioAttributes) {
        if (Util2.m2993a(this.f7661d, null)) {
            return;
        }
        this.f7661d = null;
        this.f7663f = 0;
        AnimatableValueParser.m543m(true, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
    }

    /* renamed from: d */
    public final void m3463d(int i) {
        if (this.f7662e == i) {
            return;
        }
        this.f7662e = i;
        float f = i == 3 ? 0.2f : 1.0f;
        if (this.f7664g == f) {
            return;
        }
        this.f7664g = f;
        b bVar = this.f7660c;
        if (bVar != null) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            simpleExoPlayer.m3286j0(1, 2, Float.valueOf(simpleExoPlayer.f7198B * simpleExoPlayer.f7215k.f7664g));
        }
    }

    /* renamed from: e */
    public int m3464e(boolean z2, int i) {
        int iRequestAudioFocus;
        int i2 = 1;
        if (i == 1 || this.f7663f != 1) {
            m3460a();
            return z2 ? 1 : -1;
        }
        if (!z2) {
            return -1;
        }
        if (this.f7662e != 1) {
            if (Util2.f6708a >= 26) {
                AudioFocusRequest audioFocusRequest = this.f7665h;
                if (audioFocusRequest == null) {
                    AudioFocusRequest.Builder builder = audioFocusRequest == null ? new AudioFocusRequest.Builder(this.f7663f) : new AudioFocusRequest.Builder(this.f7665h);
                    AudioAttributes audioAttributes = this.f7661d;
                    boolean z3 = audioAttributes != null && audioAttributes.f7780k == 1;
                    Objects.requireNonNull(audioAttributes);
                    this.f7665h = builder.setAudioAttributes(audioAttributes.m3494a()).setWillPauseWhenDucked(z3).setOnAudioFocusChangeListener(this.f7659b).build();
                }
                iRequestAudioFocus = this.f7658a.requestAudioFocus(this.f7665h);
            } else {
                AudioManager audioManager = this.f7658a;
                a aVar = this.f7659b;
                AudioAttributes audioAttributes2 = this.f7661d;
                Objects.requireNonNull(audioAttributes2);
                iRequestAudioFocus = audioManager.requestAudioFocus(aVar, Util2.m3012t(audioAttributes2.f7782m), this.f7663f);
            }
            if (iRequestAudioFocus == 1) {
                m3463d(1);
            } else {
                m3463d(0);
                i2 = -1;
            }
        }
        return i2;
    }
}
