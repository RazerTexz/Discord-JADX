package p007b.p225i.p361c.p369m.p370d.p388u;

import android.content.Context;
import android.content.res.Resources;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p369m.p370d.Logger3;
import p007b.p225i.p361c.p369m.p370d.p373k.CommonUtils;

/* compiled from: ResourceUnityVersionProvider.java */
/* renamed from: b.i.c.m.d.u.a, reason: use source file name */
/* loaded from: classes3.dex */
public class ResourceUnityVersionProvider {

    /* renamed from: a */
    public final Context f12781a;

    /* renamed from: b */
    public boolean f12782b = false;

    /* renamed from: c */
    public String f12783c;

    public ResourceUnityVersionProvider(Context context) {
        this.f12781a = context;
    }

    /* renamed from: a */
    public String m6697a() throws Resources.NotFoundException {
        String string;
        if (!this.f12782b) {
            Context context = this.f12781a;
            int iM6420n = CommonUtils.m6420n(context, "com.google.firebase.crashlytics.unity_version", "string");
            if (iM6420n != 0) {
                string = context.getResources().getString(iM6420n);
                outline.m868o0("Unity Editor version is: ", string, Logger3.f12227a);
            } else {
                string = null;
            }
            this.f12783c = string;
            this.f12782b = true;
        }
        String str = this.f12783c;
        if (str != null) {
            return str;
        }
        return null;
    }
}
