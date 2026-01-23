package p007b.p225i.p226a.p242c.p266w2;

import android.media.MediaDrm;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p266w2.ExoMediaDrm;

/* JADX INFO: renamed from: b.i.a.c.w2.o */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2984o implements MediaDrm.OnEventListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ FrameworkMediaDrm f8005a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ExoMediaDrm.b f8006b;

    public /* synthetic */ C2984o(FrameworkMediaDrm frameworkMediaDrm, ExoMediaDrm.b bVar) {
        this.f8005a = frameworkMediaDrm;
        this.f8006b = bVar;
    }

    @Override // android.media.MediaDrm.OnEventListener
    public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
        FrameworkMediaDrm frameworkMediaDrm = this.f8005a;
        ExoMediaDrm.b bVar = this.f8006b;
        Objects.requireNonNull(frameworkMediaDrm);
        DefaultDrmSessionManager.HandlerC10706c handlerC10706c = DefaultDrmSessionManager.this.f19837x;
        Objects.requireNonNull(handlerC10706c);
        handlerC10706c.obtainMessage(i, bArr).sendToTarget();
    }
}
