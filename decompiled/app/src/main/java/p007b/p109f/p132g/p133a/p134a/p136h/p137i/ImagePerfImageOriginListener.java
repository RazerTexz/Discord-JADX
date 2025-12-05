package p007b.p109f.p132g.p133a.p134a.p136h.p137i;

import p007b.p109f.p132g.p133a.p134a.p136h.ImageOriginListener;
import p007b.p109f.p132g.p133a.p134a.p136h.ImagePerfMonitor;
import p007b.p109f.p132g.p133a.p134a.p136h.ImagePerfState;

/* compiled from: ImagePerfImageOriginListener.java */
/* renamed from: b.f.g.a.a.h.i.b, reason: use source file name */
/* loaded from: classes.dex */
public class ImagePerfImageOriginListener implements ImageOriginListener {

    /* renamed from: a */
    public final ImagePerfState f3249a;

    /* renamed from: b */
    public final ImagePerfMonitor f3250b;

    public ImagePerfImageOriginListener(ImagePerfState imagePerfState, ImagePerfMonitor imagePerfMonitor) {
        this.f3249a = imagePerfState;
        this.f3250b = imagePerfMonitor;
    }

    @Override // p007b.p109f.p132g.p133a.p134a.p136h.ImageOriginListener
    /* renamed from: a */
    public void mo1061a(String str, int i, boolean z2, String str2) {
        ImagePerfState imagePerfState = this.f3249a;
        imagePerfState.f3231p = i;
        imagePerfState.f3232q = str2;
        this.f3250b.m1066b(imagePerfState, 1);
    }
}
