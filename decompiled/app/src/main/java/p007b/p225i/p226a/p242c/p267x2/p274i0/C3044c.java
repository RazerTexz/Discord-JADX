package p007b.p225i.p226a.p242c.p267x2.p274i0;

import java.util.Objects;
import p007b.p225i.p355b.p356a.Function2;

/* JADX INFO: renamed from: b.i.a.c.x2.i0.c */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C3044c implements Function2 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ FragmentedMp4Extractor f8348a;

    public /* synthetic */ C3044c(FragmentedMp4Extractor fragmentedMp4Extractor) {
        this.f8348a = fragmentedMp4Extractor;
    }

    @Override // p007b.p225i.p355b.p356a.Function2
    public final Object apply(Object obj) {
        Track track = (Track) obj;
        Objects.requireNonNull(this.f8348a);
        return track;
    }
}
