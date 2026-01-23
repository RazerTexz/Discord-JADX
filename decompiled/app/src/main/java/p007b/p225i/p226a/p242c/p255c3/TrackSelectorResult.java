package p007b.p225i.p226a.p242c.p255c3;

import androidx.annotation.Nullable;
import p007b.p225i.p226a.p242c.RendererConfiguration;
import p007b.p225i.p226a.p242c.TracksInfo;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* JADX INFO: renamed from: b.i.a.c.c3.r, reason: use source file name */
/* JADX INFO: compiled from: TrackSelectorResult.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TrackSelectorResult {

    /* JADX INFO: renamed from: a */
    public final int f6326a;

    /* JADX INFO: renamed from: b */
    public final RendererConfiguration[] f6327b;

    /* JADX INFO: renamed from: c */
    public final ExoTrackSelection2[] f6328c;

    /* JADX INFO: renamed from: d */
    public final TracksInfo f6329d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public final Object f6330e;

    public TrackSelectorResult(RendererConfiguration[] rendererConfigurationArr, ExoTrackSelection2[] exoTrackSelection2Arr, TracksInfo tracksInfo, @Nullable Object obj) {
        this.f6327b = rendererConfigurationArr;
        this.f6328c = (ExoTrackSelection2[]) exoTrackSelection2Arr.clone();
        this.f6329d = tracksInfo;
        this.f6330e = obj;
        this.f6326a = rendererConfigurationArr.length;
    }

    /* JADX INFO: renamed from: a */
    public boolean m2755a(@Nullable TrackSelectorResult trackSelectorResult, int i) {
        return trackSelectorResult != null && Util2.m2993a(this.f6327b[i], trackSelectorResult.f6327b[i]) && Util2.m2993a(this.f6328c[i], trackSelectorResult.f6328c[i]);
    }

    /* JADX INFO: renamed from: b */
    public boolean m2756b(int i) {
        return this.f6327b[i] != null;
    }
}
