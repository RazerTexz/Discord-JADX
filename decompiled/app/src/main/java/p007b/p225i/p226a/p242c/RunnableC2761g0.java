package p007b.p225i.p226a.p242c;

import com.google.android.exoplayer2.ExoPlaybackException;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p259f3.Log2;

/* compiled from: lambda */
/* renamed from: b.i.a.c.g0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2761g0 implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ ExoPlayerImplInternal2 f6806j;

    /* renamed from: k */
    public final /* synthetic */ PlayerMessage f6807k;

    public /* synthetic */ RunnableC2761g0(ExoPlayerImplInternal2 exoPlayerImplInternal2, PlayerMessage playerMessage) {
        this.f6806j = exoPlayerImplInternal2;
        this.f6807k = playerMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ExoPlayerImplInternal2 exoPlayerImplInternal2 = this.f6806j;
        PlayerMessage playerMessage = this.f6807k;
        Objects.requireNonNull(exoPlayerImplInternal2);
        try {
            exoPlayerImplInternal2.m3239d(playerMessage);
        } catch (ExoPlaybackException e) {
            Log2.m3039b("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e);
            throw new RuntimeException(e);
        }
    }
}
