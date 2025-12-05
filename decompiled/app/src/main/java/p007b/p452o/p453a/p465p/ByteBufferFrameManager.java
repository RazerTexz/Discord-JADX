package p007b.p452o.p453a.p465p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.LinkedBlockingQueue;
import p007b.p452o.p453a.p455n.Camera1Engine2;
import p007b.p452o.p453a.p455n.p461t.Angles;
import p007b.p452o.p453a.p473x.Size3;

/* compiled from: ByteBufferFrameManager.java */
/* renamed from: b.o.a.p.a, reason: use source file name */
/* loaded from: classes3.dex */
public class ByteBufferFrameManager extends FrameManager<byte[]> {

    /* renamed from: i */
    public LinkedBlockingQueue<byte[]> f14050i;

    /* renamed from: j */
    public a f14051j;

    /* renamed from: k */
    public final int f14052k;

    /* compiled from: ByteBufferFrameManager.java */
    /* renamed from: b.o.a.p.a$a */
    public interface a {
    }

    public ByteBufferFrameManager(int i, @Nullable a aVar) {
        super(i, byte[].class);
        this.f14051j = aVar;
        this.f14052k = 0;
    }

    @Override // p007b.p452o.p453a.p465p.FrameManager
    /* renamed from: c */
    public void mo7380c(@NonNull byte[] bArr, boolean z2) {
        byte[] bArr2 = bArr;
        if (z2 && bArr2.length == this.f14060c) {
            if (this.f14052k == 0) {
                ((Camera1Engine2) this.f14051j).m7222m1(bArr2);
            } else {
                this.f14050i.offer(bArr2);
            }
        }
    }

    @Override // p007b.p452o.p453a.p465p.FrameManager
    /* renamed from: d */
    public void mo7381d() {
        super.mo7381d();
        if (this.f14052k == 1) {
            this.f14050i.clear();
        }
    }

    @Override // p007b.p452o.p453a.p465p.FrameManager
    /* renamed from: e */
    public void mo7382e(int i, @NonNull Size3 size3, @NonNull Angles angles) {
        super.mo7382e(i, size3, angles);
        int i2 = this.f14060c;
        for (int i3 = 0; i3 < this.f14059b; i3++) {
            if (this.f14052k == 0) {
                ((Camera1Engine2) this.f14051j).m7222m1(new byte[i2]);
            } else {
                this.f14050i.offer(new byte[i2]);
            }
        }
    }
}
