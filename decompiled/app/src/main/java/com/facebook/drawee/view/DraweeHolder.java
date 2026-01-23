package com.facebook.drawee.view;

import android.graphics.drawable.Drawable;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p119d.Objects2;
import p007b.p109f.p132g.p138b.DraweeEventTracker;
import p007b.p109f.p132g.p142e.VisibilityAwareDrawable;
import p007b.p109f.p132g.p142e.VisibilityCallback;

/* JADX INFO: loaded from: classes.dex */
public class DraweeHolder<DH extends DraweeHierarchy> implements VisibilityCallback {

    /* JADX INFO: renamed from: d */
    public DH f19528d;

    /* JADX INFO: renamed from: f */
    public final DraweeEventTracker f19530f;

    /* JADX INFO: renamed from: a */
    public boolean f19525a = false;

    /* JADX INFO: renamed from: b */
    public boolean f19526b = false;

    /* JADX INFO: renamed from: c */
    public boolean f19527c = true;

    /* JADX INFO: renamed from: e */
    public DraweeController f19529e = null;

    public DraweeHolder(DH dh) {
        this.f19530f = DraweeEventTracker.f3261b ? new DraweeEventTracker() : DraweeEventTracker.f3260a;
        if (dh != null) {
            m8694h(dh);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m8687a() {
        if (this.f19525a) {
            return;
        }
        this.f19530f.m1084a(DraweeEventTracker.a.ON_ATTACH_CONTROLLER);
        this.f19525a = true;
        DraweeController draweeController = this.f19529e;
        if (draweeController == null || draweeController.mo8653b() == null) {
            return;
        }
        this.f19529e.mo8655d();
    }

    /* JADX INFO: renamed from: b */
    public final void m8688b() {
        if (this.f19526b && this.f19527c) {
            m8687a();
        } else {
            m8689c();
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m8689c() {
        if (this.f19525a) {
            this.f19530f.m1084a(DraweeEventTracker.a.ON_DETACH_CONTROLLER);
            this.f19525a = false;
            if (m8691e()) {
                this.f19529e.mo8652a();
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public Drawable m8690d() {
        DH dh = this.f19528d;
        if (dh == null) {
            return null;
        }
        return dh.mo8670e();
    }

    /* JADX INFO: renamed from: e */
    public boolean m8691e() {
        DraweeController draweeController = this.f19529e;
        return draweeController != null && draweeController.mo8653b() == this.f19528d;
    }

    /* JADX INFO: renamed from: f */
    public void m8692f(boolean z2) {
        if (this.f19527c == z2) {
            return;
        }
        this.f19530f.m1084a(z2 ? DraweeEventTracker.a.ON_DRAWABLE_SHOW : DraweeEventTracker.a.ON_DRAWABLE_HIDE);
        this.f19527c = z2;
        m8688b();
    }

    /* JADX INFO: renamed from: g */
    public void m8693g(DraweeController draweeController) {
        boolean z2 = this.f19525a;
        if (z2) {
            m8689c();
        }
        if (m8691e()) {
            this.f19530f.m1084a(DraweeEventTracker.a.ON_CLEAR_OLD_CONTROLLER);
            this.f19529e.mo1045e(null);
        }
        this.f19529e = draweeController;
        if (draweeController != null) {
            this.f19530f.m1084a(DraweeEventTracker.a.ON_SET_CONTROLLER);
            this.f19529e.mo1045e(this.f19528d);
        } else {
            this.f19530f.m1084a(DraweeEventTracker.a.ON_CLEAR_CONTROLLER);
        }
        if (z2) {
            m8687a();
        }
    }

    /* JADX INFO: renamed from: h */
    public void m8694h(DH dh) {
        this.f19530f.m1084a(DraweeEventTracker.a.ON_SET_HIERARCHY);
        boolean zM8691e = m8691e();
        Object objM8690d = m8690d();
        if (objM8690d instanceof VisibilityAwareDrawable) {
            ((VisibilityAwareDrawable) objM8690d).mo1102k(null);
        }
        Objects.requireNonNull(dh);
        this.f19528d = dh;
        Drawable drawableMo8670e = dh.mo8670e();
        m8692f(drawableMo8670e == null || drawableMo8670e.isVisible());
        Object objM8690d2 = m8690d();
        if (objM8690d2 instanceof VisibilityAwareDrawable) {
            ((VisibilityAwareDrawable) objM8690d2).mo1102k(this);
        }
        if (zM8691e) {
            this.f19529e.mo1045e(dh);
        }
    }

    public String toString() {
        Objects2 objects2M526h2 = AnimatableValueParser.m526h2(this);
        objects2M526h2.m970b("controllerAttached", this.f19525a);
        objects2M526h2.m970b("holderAttached", this.f19526b);
        objects2M526h2.m970b("drawableVisible", this.f19527c);
        objects2M526h2.m971c("events", this.f19530f.toString());
        return objects2M526h2.toString();
    }
}
