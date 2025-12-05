package p007b.p109f.p132g.p133a.p134a.p136h.p137i;

import com.facebook.imagepipeline.request.ImageRequest;
import p007b.p109f.p115d.p126k.MonotonicClock;
import p007b.p109f.p132g.p133a.p134a.p136h.ImagePerfState;
import p007b.p109f.p161j.p176k.BaseRequestListener;

/* compiled from: ImagePerfRequestListener.java */
/* renamed from: b.f.g.a.a.h.i.c, reason: use source file name */
/* loaded from: classes.dex */
public class ImagePerfRequestListener extends BaseRequestListener {

    /* renamed from: a */
    public final MonotonicClock f3251a;

    /* renamed from: b */
    public final ImagePerfState f3252b;

    public ImagePerfRequestListener(MonotonicClock monotonicClock, ImagePerfState imagePerfState) {
        this.f3251a = monotonicClock;
        this.f3252b = imagePerfState;
    }

    @Override // p007b.p109f.p161j.p176k.BaseRequestListener, p007b.p109f.p161j.p176k.RequestListener
    /* renamed from: a */
    public void mo1079a(ImageRequest imageRequest, Object obj, String str, boolean z2) {
        this.f3252b.f3229n = this.f3251a.now();
        ImagePerfState imagePerfState = this.f3252b;
        imagePerfState.f3218c = imageRequest;
        imagePerfState.f3219d = obj;
        imagePerfState.f3217b = str;
        imagePerfState.f3233r = z2;
    }

    @Override // p007b.p109f.p161j.p176k.BaseRequestListener, p007b.p109f.p161j.p176k.RequestListener
    /* renamed from: c */
    public void mo1080c(ImageRequest imageRequest, String str, boolean z2) {
        this.f3252b.f3230o = this.f3251a.now();
        ImagePerfState imagePerfState = this.f3252b;
        imagePerfState.f3218c = imageRequest;
        imagePerfState.f3217b = str;
        imagePerfState.f3233r = z2;
    }

    @Override // p007b.p109f.p161j.p176k.BaseRequestListener, p007b.p109f.p161j.p176k.RequestListener
    /* renamed from: g */
    public void mo1081g(ImageRequest imageRequest, String str, Throwable th, boolean z2) {
        this.f3252b.f3230o = this.f3251a.now();
        ImagePerfState imagePerfState = this.f3252b;
        imagePerfState.f3218c = imageRequest;
        imagePerfState.f3217b = str;
        imagePerfState.f3233r = z2;
    }

    @Override // p007b.p109f.p161j.p176k.BaseRequestListener, p007b.p109f.p161j.p176k.RequestListener
    /* renamed from: k */
    public void mo1082k(String str) {
        this.f3252b.f3230o = this.f3251a.now();
        this.f3252b.f3217b = str;
    }
}
