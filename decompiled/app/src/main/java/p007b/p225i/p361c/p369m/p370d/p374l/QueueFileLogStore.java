package p007b.p225i.p361c.p369m.p370d.p374l;

import java.io.IOException;
import java.io.InputStream;
import p007b.p225i.p361c.p369m.p370d.p374l.QueueFile;

/* compiled from: QueueFileLogStore.java */
/* renamed from: b.i.c.m.d.l.d, reason: use source file name */
/* loaded from: classes3.dex */
public class QueueFileLogStore implements QueueFile.d {

    /* renamed from: a */
    public final /* synthetic */ byte[] f12489a;

    /* renamed from: b */
    public final /* synthetic */ int[] f12490b;

    public QueueFileLogStore(QueueFileLogStore2 queueFileLogStore2, byte[] bArr, int[] iArr) {
        this.f12489a = bArr;
        this.f12490b = iArr;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p374l.QueueFile.d
    /* renamed from: a */
    public void mo6512a(InputStream inputStream, int i) throws IOException {
        try {
            inputStream.read(this.f12489a, this.f12490b[0], i);
            int[] iArr = this.f12490b;
            iArr[0] = iArr[0] + i;
        } finally {
            inputStream.close();
        }
    }
}
