package p007b.p008a.p041q.p044m0.p045c;

import com.hammerandchisel.libdiscord.Discord;
import java.util.List;
import p007b.p008a.p041q.p044m0.Codec2;
import p658rx.Emitter;
import p658rx.functions.Action1;

/* compiled from: MediaEngineLegacy.kt */
/* renamed from: b.a.q.m0.c.q */
/* loaded from: classes.dex */
public final class C1239q<T> implements Action1<Emitter<List<? extends Codec2>>> {

    /* renamed from: j */
    public final /* synthetic */ C1233k f1753j;

    public C1239q(C1233k c1233k) {
        this.f1753j = c1233k;
    }

    @Override // p658rx.functions.Action1
    public void call(Emitter<List<? extends Codec2>> emitter) {
        Emitter<List<? extends Codec2>> emitter2 = emitter;
        Discord discord = this.f1753j.f1726f;
        if (discord != null) {
            discord.getSupportedVideoCodecs(new C1238p(this, emitter2));
        }
    }
}
