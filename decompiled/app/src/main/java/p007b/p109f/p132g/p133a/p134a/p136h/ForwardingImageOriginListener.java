package p007b.p109f.p132g.p133a.p134a.p136h;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p007b.p109f.p115d.p120e.FLog;

/* JADX INFO: renamed from: b.f.g.a.a.h.a, reason: use source file name */
/* JADX INFO: compiled from: ForwardingImageOriginListener.java */
/* JADX INFO: loaded from: classes.dex */
public class ForwardingImageOriginListener implements ImageOriginListener {

    /* JADX INFO: renamed from: a */
    public final List<ImageOriginListener> f3199a;

    public ForwardingImageOriginListener(ImageOriginListener... imageOriginListenerArr) {
        ArrayList arrayList = new ArrayList(imageOriginListenerArr.length);
        this.f3199a = arrayList;
        Collections.addAll(arrayList, imageOriginListenerArr);
    }

    @Override // p007b.p109f.p132g.p133a.p134a.p136h.ImageOriginListener
    /* JADX INFO: renamed from: a */
    public synchronized void mo1061a(String str, int i, boolean z2, String str2) {
        int size = this.f3199a.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageOriginListener imageOriginListener = this.f3199a.get(i2);
            if (imageOriginListener != null) {
                try {
                    imageOriginListener.mo1061a(str, i, z2, str2);
                } catch (Exception e) {
                    FLog.m978f("ForwardingImageOriginListener", "InternalListener exception in onImageLoaded", e);
                }
            }
        }
    }
}
