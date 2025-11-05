package b.i.a.c.w2;

import android.media.MediaDrm;
import b.i.a.c.w2.a0;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import java.util.Objects;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class o implements MediaDrm.OnEventListener {
    public final /* synthetic */ c0 a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a0.b f1154b;

    public /* synthetic */ o(c0 c0Var, a0.b bVar) {
        this.a = c0Var;
        this.f1154b = bVar;
    }

    @Override // android.media.MediaDrm.OnEventListener
    public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
        c0 c0Var = this.a;
        a0.b bVar = this.f1154b;
        Objects.requireNonNull(c0Var);
        DefaultDrmSessionManager.c cVar = DefaultDrmSessionManager.this.f2931x;
        Objects.requireNonNull(cVar);
        cVar.obtainMessage(i, bArr).sendToTarget();
    }
}
