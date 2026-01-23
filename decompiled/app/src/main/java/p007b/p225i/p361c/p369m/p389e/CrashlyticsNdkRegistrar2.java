package p007b.p225i.p361c.p369m.p389e;

import android.content.Context;
import com.google.firebase.crashlytics.ndk.CrashlyticsNdkRegistrar;
import com.google.firebase.crashlytics.ndk.JniNativeApi;
import java.io.File;
import java.util.Objects;
import p007b.p225i.p361c.p368l.ComponentContainer;
import p007b.p225i.p361c.p368l.ComponentFactory;

/* JADX INFO: renamed from: b.i.c.m.e.b, reason: use source file name */
/* JADX INFO: compiled from: CrashlyticsNdkRegistrar.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class CrashlyticsNdkRegistrar2 implements ComponentFactory {

    /* JADX INFO: renamed from: a */
    public final CrashlyticsNdkRegistrar f12788a;

    public CrashlyticsNdkRegistrar2(CrashlyticsNdkRegistrar crashlyticsNdkRegistrar) {
        this.f12788a = crashlyticsNdkRegistrar;
    }

    @Override // p007b.p225i.p361c.p368l.ComponentFactory
    /* JADX INFO: renamed from: a */
    public Object mo6341a(ComponentContainer componentContainer) {
        Objects.requireNonNull(this.f12788a);
        Context context = (Context) componentContainer.mo6346a(Context.class);
        return new FirebaseCrashlyticsNdk(new BreakpadController(context, new JniNativeApi(context), new NdkCrashFilesManager(new File(context.getFilesDir(), ".com.google.firebase.crashlytics-ndk"))));
    }
}
