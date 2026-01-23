package p007b.p109f.p148h.p158b.p159a;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import p007b.p109f.p148h.p158b.p159a.ControllerListener2;

/* JADX INFO: renamed from: b.f.h.b.a.c, reason: use source file name */
/* JADX INFO: compiled from: ForwardingControllerListener2.java */
/* JADX INFO: loaded from: classes.dex */
public class ForwardingControllerListener2<I> extends BaseControllerListener2<I> {

    /* JADX INFO: renamed from: j */
    public final List<ControllerListener2<I>> f3568j = new ArrayList(2);

    @Override // p007b.p109f.p148h.p158b.p159a.ControllerListener2
    /* JADX INFO: renamed from: a */
    public void mo1071a(String str, Object obj, ControllerListener2.a aVar) {
        int size = this.f3568j.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener2<I> controllerListener2 = this.f3568j.get(i);
                if (controllerListener2 != null) {
                    controllerListener2.mo1071a(str, obj, aVar);
                }
            } catch (Exception e) {
                m1168e("ForwardingControllerListener2 exception in onSubmit", e);
            }
        }
    }

    @Override // p007b.p109f.p148h.p158b.p159a.ControllerListener2
    /* JADX INFO: renamed from: b */
    public void mo1072b(String str, Throwable th, ControllerListener2.a aVar) {
        int size = this.f3568j.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener2<I> controllerListener2 = this.f3568j.get(i);
                if (controllerListener2 != null) {
                    controllerListener2.mo1072b(str, th, aVar);
                }
            } catch (Exception e) {
                m1168e("ForwardingControllerListener2 exception in onFailure", e);
            }
        }
    }

    @Override // p007b.p109f.p148h.p158b.p159a.ControllerListener2
    /* JADX INFO: renamed from: c */
    public void mo1073c(String str, ControllerListener2.a aVar) {
        int size = this.f3568j.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener2<I> controllerListener2 = this.f3568j.get(i);
                if (controllerListener2 != null) {
                    controllerListener2.mo1073c(str, aVar);
                }
            } catch (Exception e) {
                m1168e("ForwardingControllerListener2 exception in onRelease", e);
            }
        }
    }

    @Override // p007b.p109f.p148h.p158b.p159a.ControllerListener2
    /* JADX INFO: renamed from: d */
    public void mo1074d(String str, I i, ControllerListener2.a aVar) {
        int size = this.f3568j.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ControllerListener2<I> controllerListener2 = this.f3568j.get(i2);
                if (controllerListener2 != null) {
                    controllerListener2.mo1074d(str, i, aVar);
                }
            } catch (Exception e) {
                m1168e("ForwardingControllerListener2 exception in onFinalImageSet", e);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public final synchronized void m1168e(String str, Throwable th) {
        Log.e("FwdControllerListener2", str, th);
    }
}
