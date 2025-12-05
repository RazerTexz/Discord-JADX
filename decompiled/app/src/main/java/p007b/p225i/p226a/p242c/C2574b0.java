package p007b.p225i.p226a.p242c;

import androidx.core.view.PointerIconCompat;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoTimeoutException;
import p007b.p225i.p226a.p242c.Player2;
import p007b.p225i.p226a.p242c.p259f3.ListenerSet;

/* compiled from: lambda */
/* renamed from: b.i.a.c.b0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2574b0 implements ListenerSet.a {

    /* renamed from: a */
    public static final /* synthetic */ C2574b0 f5738a = new C2574b0();

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.a
    public final void invoke(Object obj) {
        int i = ExoPlayerImpl.f6651b;
        ((Player2.c) obj).mo260s(ExoPlaybackException.m8753b(new ExoTimeoutException(1), PointerIconCompat.TYPE_HELP));
    }
}
