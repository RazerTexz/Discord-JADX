package p007b.p225i.p226a.p242c.p255c3;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import p007b.p225i.p226a.p242c.RendererCapabilities;
import p007b.p225i.p226a.p242c.Timeline;
import p007b.p225i.p226a.p242c.p243a3.MediaSource2;
import p007b.p225i.p226a.p242c.p243a3.TrackGroupArray;
import p007b.p225i.p226a.p242c.p257e3.BandwidthMeter;

/* JADX INFO: renamed from: b.i.a.c.c3.q, reason: use source file name */
/* JADX INFO: compiled from: TrackSelector.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class TrackSelector {

    /* JADX INFO: renamed from: a */
    @Nullable
    public BandwidthMeter f6325a;

    /* JADX INFO: renamed from: a */
    public abstract void mo2752a(@Nullable Object obj);

    /* JADX INFO: renamed from: b */
    public abstract TrackSelectorResult mo2753b(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray, MediaSource2.a aVar, Timeline timeline) throws ExoPlaybackException;
}
