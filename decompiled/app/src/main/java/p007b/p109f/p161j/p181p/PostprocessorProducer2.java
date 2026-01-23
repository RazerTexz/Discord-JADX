package p007b.p109f.p161j.p181p;

import com.facebook.common.references.CloseableReference;
import p007b.p109f.p161j.p175j.CloseableImage;
import p007b.p109f.p161j.p181p.PostprocessorProducer;

/* JADX INFO: renamed from: b.f.j.p.u0, reason: use source file name */
/* JADX INFO: compiled from: PostprocessorProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class PostprocessorProducer2 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ PostprocessorProducer.b f4237j;

    public PostprocessorProducer2(PostprocessorProducer.b bVar) {
        this.f4237j = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        CloseableReference<CloseableImage> closeableReference;
        int i;
        boolean zM1522s;
        synchronized (this.f4237j) {
            PostprocessorProducer.b bVar = this.f4237j;
            closeableReference = bVar.f4228g;
            i = bVar.f4229h;
            bVar.f4228g = null;
            bVar.f4230i = false;
        }
        if (CloseableReference.m8640y(closeableReference)) {
            try {
                PostprocessorProducer.b.m1517n(this.f4237j, closeableReference, i);
                closeableReference.close();
            } catch (Throwable th) {
                if (closeableReference != null) {
                    closeableReference.close();
                }
                throw th;
            }
        }
        PostprocessorProducer.b bVar2 = this.f4237j;
        synchronized (bVar2) {
            bVar2.f4231j = false;
            zM1522s = bVar2.m1522s();
        }
        if (zM1522s) {
            PostprocessorProducer.this.f4223c.execute(new PostprocessorProducer2(bVar2));
        }
    }
}
