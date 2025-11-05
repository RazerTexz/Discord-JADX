package b.o.a.p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: ByteBufferFrameManager.java */
/* loaded from: classes3.dex */
public class a extends c<byte[]> {
    public LinkedBlockingQueue<byte[]> i;
    public InterfaceC0175a j;
    public final int k;

    /* compiled from: ByteBufferFrameManager.java */
    /* renamed from: b.o.a.p.a$a, reason: collision with other inner class name */
    public interface InterfaceC0175a {
    }

    public a(int i, @Nullable InterfaceC0175a interfaceC0175a) {
        super(i, byte[].class);
        this.j = interfaceC0175a;
        this.k = 0;
    }

    @Override // b.o.a.p.c
    public void c(@NonNull byte[] bArr, boolean z2) {
        byte[] bArr2 = bArr;
        if (z2 && bArr2.length == this.c) {
            if (this.k == 0) {
                ((b.o.a.n.b) this.j).m1(bArr2);
            } else {
                this.i.offer(bArr2);
            }
        }
    }

    @Override // b.o.a.p.c
    public void d() {
        super.d();
        if (this.k == 1) {
            this.i.clear();
        }
    }

    @Override // b.o.a.p.c
    public void e(int i, @NonNull b.o.a.x.b bVar, @NonNull b.o.a.n.t.a aVar) {
        super.e(i, bVar, aVar);
        int i2 = this.c;
        for (int i3 = 0; i3 < this.f1946b; i3++) {
            if (this.k == 0) {
                ((b.o.a.n.b) this.j).m1(new byte[i2]);
            } else {
                this.i.offer(new byte[i2]);
            }
        }
    }
}
