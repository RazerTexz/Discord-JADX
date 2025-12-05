package p007b.p225i.p226a.p242c.p260g3;

import android.util.Log;
import android.view.Display;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p260g3.VideoFrameReleaseHelper;

/* compiled from: lambda */
/* renamed from: b.i.a.c.g3.b */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2765b implements VideoFrameReleaseHelper.b.a {

    /* renamed from: a */
    public final /* synthetic */ VideoFrameReleaseHelper f6810a;

    public /* synthetic */ C2765b(VideoFrameReleaseHelper videoFrameReleaseHelper) {
        this.f6810a = videoFrameReleaseHelper;
    }

    /* renamed from: a */
    public final void m3120a(Display display) {
        VideoFrameReleaseHelper videoFrameReleaseHelper = this.f6810a;
        Objects.requireNonNull(videoFrameReleaseHelper);
        if (display != null) {
            long refreshRate = (long) (1.0E9d / display.getRefreshRate());
            videoFrameReleaseHelper.f6936k = refreshRate;
            videoFrameReleaseHelper.f6937l = (refreshRate * 80) / 100;
        } else {
            Log.w("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            videoFrameReleaseHelper.f6936k = -9223372036854775807L;
            videoFrameReleaseHelper.f6937l = -9223372036854775807L;
        }
    }
}
