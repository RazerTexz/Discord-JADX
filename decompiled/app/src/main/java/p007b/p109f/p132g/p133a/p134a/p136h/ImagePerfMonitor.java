package p007b.p109f.p132g.p133a.p134a.p136h;

import android.graphics.Rect;
import com.facebook.common.internal.Supplier;
import java.util.Iterator;
import java.util.List;
import p007b.p109f.p115d.p119d.Suppliers2;
import p007b.p109f.p115d.p126k.MonotonicClock;
import p007b.p109f.p132g.p133a.p134a.PipelineDraweeController;
import p007b.p109f.p132g.p133a.p134a.p136h.p137i.ImagePerfControllerListener2;
import p007b.p109f.p132g.p133a.p134a.p136h.p137i.ImagePerfImageOriginListener;
import p007b.p109f.p132g.p133a.p134a.p136h.p137i.ImagePerfRequestListener;
import p007b.p109f.p132g.p145h.SettableDraweeHierarchy;
import p007b.p109f.p148h.p158b.p159a.ForwardingControllerListener2;
import p007b.p109f.p161j.p176k.ForwardingRequestListener;

/* JADX INFO: renamed from: b.f.g.a.a.h.f, reason: use source file name */
/* JADX INFO: compiled from: ImagePerfMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class ImagePerfMonitor implements ImagePerfNotifier {

    /* JADX INFO: renamed from: a */
    public final PipelineDraweeController f3204a;

    /* JADX INFO: renamed from: b */
    public final MonotonicClock f3205b;

    /* JADX INFO: renamed from: c */
    public final ImagePerfState f3206c = new ImagePerfState();

    /* JADX INFO: renamed from: d */
    public final Supplier<Boolean> f3207d;

    /* JADX INFO: renamed from: e */
    public ImageOriginRequestListener f3208e;

    /* JADX INFO: renamed from: f */
    public ImageOriginListener f3209f;

    /* JADX INFO: renamed from: g */
    public ImagePerfRequestListener f3210g;

    /* JADX INFO: renamed from: h */
    public ImagePerfControllerListener2 f3211h;

    /* JADX INFO: renamed from: i */
    public ForwardingRequestListener f3212i;

    /* JADX INFO: renamed from: j */
    public List<ImagePerfDataListener> f3213j;

    /* JADX INFO: renamed from: k */
    public boolean f3214k;

    public ImagePerfMonitor(MonotonicClock monotonicClock, PipelineDraweeController pipelineDraweeController, Supplier<Boolean> supplier) {
        this.f3205b = monotonicClock;
        this.f3204a = pipelineDraweeController;
        this.f3207d = supplier;
    }

    /* JADX INFO: renamed from: a */
    public void m1065a(ImagePerfState imagePerfState, int i) {
        List<ImagePerfDataListener> list;
        if (!this.f3214k || (list = this.f3213j) == null || list.isEmpty()) {
            return;
        }
        ImagePerfData imagePerfDataM1070c = imagePerfState.m1070c();
        Iterator<ImagePerfDataListener> it = this.f3213j.iterator();
        while (it.hasNext()) {
            it.next().m1064b(imagePerfDataM1070c, i);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m1066b(ImagePerfState imagePerfState, int i) {
        List<ImagePerfDataListener> list;
        SettableDraweeHierarchy settableDraweeHierarchy;
        imagePerfState.f3237v = i;
        if (!this.f3214k || (list = this.f3213j) == null || list.isEmpty()) {
            return;
        }
        if (i == 3 && (settableDraweeHierarchy = this.f3204a.f19461k) != null && settableDraweeHierarchy.mo8670e() != null) {
            Rect bounds = settableDraweeHierarchy.mo8670e().getBounds();
            this.f3206c.f3234s = bounds.width();
            this.f3206c.f3235t = bounds.height();
        }
        ImagePerfData imagePerfDataM1070c = imagePerfState.m1070c();
        Iterator<ImagePerfDataListener> it = this.f3213j.iterator();
        while (it.hasNext()) {
            it.next().m1063a(imagePerfDataM1070c, i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: c */
    public void m1067c(boolean z2) {
        this.f3214k = z2;
        if (!z2) {
            ImageOriginListener imageOriginListener = this.f3209f;
            if (imageOriginListener != null) {
                PipelineDraweeController pipelineDraweeController = this.f3204a;
                synchronized (pipelineDraweeController) {
                    ImageOriginListener imageOriginListener2 = pipelineDraweeController.f3176G;
                    if (imageOriginListener2 instanceof ForwardingImageOriginListener) {
                        ForwardingImageOriginListener forwardingImageOriginListener = (ForwardingImageOriginListener) imageOriginListener2;
                        synchronized (forwardingImageOriginListener) {
                            forwardingImageOriginListener.f3199a.remove(imageOriginListener);
                        }
                    } else if (imageOriginListener2 == imageOriginListener) {
                        pipelineDraweeController.f3176G = null;
                    }
                }
            }
            ImagePerfControllerListener2 imagePerfControllerListener2 = this.f3211h;
            if (imagePerfControllerListener2 != null) {
                ForwardingControllerListener2<INFO> forwardingControllerListener2 = this.f3204a.f19460j;
                synchronized (forwardingControllerListener2) {
                    int iIndexOf = forwardingControllerListener2.f3568j.indexOf(imagePerfControllerListener2);
                    if (iIndexOf != -1) {
                        forwardingControllerListener2.f3568j.remove(iIndexOf);
                    }
                }
            }
            ForwardingRequestListener forwardingRequestListener = this.f3212i;
            if (forwardingRequestListener != null) {
                this.f3204a.m1044L(forwardingRequestListener);
                return;
            }
            return;
        }
        if (this.f3211h == null) {
            this.f3211h = new ImagePerfControllerListener2(this.f3205b, this.f3206c, this, this.f3207d, Suppliers2.f3101a);
        }
        if (this.f3210g == null) {
            this.f3210g = new ImagePerfRequestListener(this.f3205b, this.f3206c);
        }
        if (this.f3209f == null) {
            this.f3209f = new ImagePerfImageOriginListener(this.f3206c, this);
        }
        ImageOriginRequestListener imageOriginRequestListener = this.f3208e;
        if (imageOriginRequestListener == null) {
            this.f3208e = new ImageOriginRequestListener(this.f3204a.f19463m, this.f3209f);
        } else {
            imageOriginRequestListener.f3200a = this.f3204a.f19463m;
        }
        if (this.f3212i == null) {
            this.f3212i = new ForwardingRequestListener(this.f3210g, this.f3208e);
        }
        ImageOriginListener imageOriginListener3 = this.f3209f;
        if (imageOriginListener3 != null) {
            this.f3204a.m1038F(imageOriginListener3);
        }
        ImagePerfControllerListener2 imagePerfControllerListener22 = this.f3211h;
        if (imagePerfControllerListener22 != null) {
            ForwardingControllerListener2<INFO> forwardingControllerListener22 = this.f3204a.f19460j;
            synchronized (forwardingControllerListener22) {
                forwardingControllerListener22.f3568j.add(imagePerfControllerListener22);
            }
        }
        ForwardingRequestListener forwardingRequestListener2 = this.f3212i;
        if (forwardingRequestListener2 != null) {
            this.f3204a.m1039G(forwardingRequestListener2);
        }
    }
}
