package b.i.a.c;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import b.i.a.c.k2;
import java.util.Objects;
import org.webrtc.MediaStreamTrack;

/* compiled from: AudioFocusManager.java */
/* loaded from: classes3.dex */
public final class t0 {
    public final AudioManager a;

    /* renamed from: b, reason: collision with root package name */
    public final a f1114b;

    @Nullable
    public b c;

    @Nullable
    public b.i.a.c.t2.o d;
    public int e;
    public int f;
    public float g = 1.0f;
    public AudioFocusRequest h;

    /* compiled from: AudioFocusManager.java */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        public final Handler j;

        public a(Handler handler) {
            this.j = handler;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            this.j.post(new c(this, i));
        }
    }

    /* compiled from: AudioFocusManager.java */
    public interface b {
    }

    public t0(Context context, Handler handler, b bVar) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        Objects.requireNonNull(audioManager);
        this.a = audioManager;
        this.c = bVar;
        this.f1114b = new a(handler);
        this.e = 0;
    }

    public final void a() {
        if (this.e == 0) {
            return;
        }
        if (b.i.a.c.f3.e0.a >= 26) {
            AudioFocusRequest audioFocusRequest = this.h;
            if (audioFocusRequest != null) {
                this.a.abandonAudioFocusRequest(audioFocusRequest);
            }
        } else {
            this.a.abandonAudioFocus(this.f1114b);
        }
        d(0);
    }

    public final void b(int i) {
        b bVar = this.c;
        if (bVar != null) {
            k2.b bVar2 = (k2.b) bVar;
            boolean zJ = k2.this.j();
            k2.this.m0(zJ, i, k2.g0(zJ, i));
        }
    }

    public void c(@Nullable b.i.a.c.t2.o oVar) {
        if (b.i.a.c.f3.e0.a(this.d, null)) {
            return;
        }
        this.d = null;
        this.f = 0;
        b.c.a.a0.d.m(true, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
    }

    public final void d(int i) {
        if (this.e == i) {
            return;
        }
        this.e = i;
        float f = i == 3 ? 0.2f : 1.0f;
        if (this.g == f) {
            return;
        }
        this.g = f;
        b bVar = this.c;
        if (bVar != null) {
            k2 k2Var = k2.this;
            k2Var.j0(1, 2, Float.valueOf(k2Var.B * k2Var.k.g));
        }
    }

    public int e(boolean z2, int i) {
        int iRequestAudioFocus;
        int i2 = 1;
        if (i == 1 || this.f != 1) {
            a();
            return z2 ? 1 : -1;
        }
        if (!z2) {
            return -1;
        }
        if (this.e != 1) {
            if (b.i.a.c.f3.e0.a >= 26) {
                AudioFocusRequest audioFocusRequest = this.h;
                if (audioFocusRequest == null) {
                    AudioFocusRequest.Builder builder = audioFocusRequest == null ? new AudioFocusRequest.Builder(this.f) : new AudioFocusRequest.Builder(this.h);
                    b.i.a.c.t2.o oVar = this.d;
                    boolean z3 = oVar != null && oVar.k == 1;
                    Objects.requireNonNull(oVar);
                    this.h = builder.setAudioAttributes(oVar.a()).setWillPauseWhenDucked(z3).setOnAudioFocusChangeListener(this.f1114b).build();
                }
                iRequestAudioFocus = this.a.requestAudioFocus(this.h);
            } else {
                AudioManager audioManager = this.a;
                a aVar = this.f1114b;
                b.i.a.c.t2.o oVar2 = this.d;
                Objects.requireNonNull(oVar2);
                iRequestAudioFocus = audioManager.requestAudioFocus(aVar, b.i.a.c.f3.e0.t(oVar2.m), this.f);
            }
            if (iRequestAudioFocus == 1) {
                d(1);
            } else {
                d(0);
                i2 = -1;
            }
        }
        return i2;
    }
}
