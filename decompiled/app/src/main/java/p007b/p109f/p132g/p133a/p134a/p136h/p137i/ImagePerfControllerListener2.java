package p007b.p109f.p132g.p133a.p134a.p136h.p137i;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.image.ImageInfo;
import java.io.Closeable;
import java.util.Objects;
import p007b.p109f.p115d.p126k.MonotonicClock;
import p007b.p109f.p132g.p133a.p134a.p136h.ImagePerfMonitor;
import p007b.p109f.p132g.p133a.p134a.p136h.ImagePerfNotifier;
import p007b.p109f.p132g.p133a.p134a.p136h.ImagePerfState;
import p007b.p109f.p148h.p158b.p159a.BaseControllerListener2;
import p007b.p109f.p148h.p158b.p159a.ControllerListener2;

/* compiled from: ImagePerfControllerListener2.java */
/* renamed from: b.f.g.a.a.h.i.a, reason: use source file name */
/* loaded from: classes.dex */
public class ImagePerfControllerListener2 extends BaseControllerListener2<ImageInfo> implements Closeable {

    /* renamed from: j */
    public static Handler f3242j;

    /* renamed from: k */
    public final MonotonicClock f3243k;

    /* renamed from: l */
    public final ImagePerfState f3244l;

    /* renamed from: m */
    public final ImagePerfNotifier f3245m;

    /* renamed from: n */
    public final Supplier<Boolean> f3246n;

    /* renamed from: o */
    public final Supplier<Boolean> f3247o;

    /* compiled from: ImagePerfControllerListener2.java */
    /* renamed from: b.f.g.a.a.h.i.a$a */
    public static class a extends Handler {

        /* renamed from: a */
        public final ImagePerfNotifier f3248a;

        public a(@NonNull Looper looper, @NonNull ImagePerfNotifier imagePerfNotifier) {
            super(looper);
            this.f3248a = imagePerfNotifier;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Object obj = message.obj;
            Objects.requireNonNull(obj);
            ImagePerfState imagePerfState = (ImagePerfState) obj;
            int i = message.what;
            if (i == 1) {
                ((ImagePerfMonitor) this.f3248a).m1066b(imagePerfState, message.arg1);
            } else {
                if (i != 2) {
                    return;
                }
                ((ImagePerfMonitor) this.f3248a).m1065a(imagePerfState, message.arg1);
            }
        }
    }

    public ImagePerfControllerListener2(MonotonicClock monotonicClock, ImagePerfState imagePerfState, ImagePerfNotifier imagePerfNotifier, Supplier<Boolean> supplier, Supplier<Boolean> supplier2) {
        this.f3243k = monotonicClock;
        this.f3244l = imagePerfState;
        this.f3245m = imagePerfNotifier;
        this.f3246n = supplier;
        this.f3247o = supplier2;
    }

    @Override // p007b.p109f.p148h.p158b.p159a.ControllerListener2
    /* renamed from: a */
    public void mo1071a(String str, Object obj, ControllerListener2.a aVar) {
        long jNow = this.f3243k.now();
        ImagePerfState imagePerfStateM1075e = m1075e();
        imagePerfStateM1075e.m1069b();
        imagePerfStateM1075e.f3224i = jNow;
        imagePerfStateM1075e.f3216a = str;
        imagePerfStateM1075e.f3219d = obj;
        imagePerfStateM1075e.f3215A = aVar;
        m1077n(imagePerfStateM1075e, 0);
        imagePerfStateM1075e.f3238w = 1;
        imagePerfStateM1075e.f3239x = jNow;
        m1078q(imagePerfStateM1075e, 1);
    }

    @Override // p007b.p109f.p148h.p158b.p159a.ControllerListener2
    /* renamed from: b */
    public void mo1072b(String str, Throwable th, ControllerListener2.a aVar) {
        long jNow = this.f3243k.now();
        ImagePerfState imagePerfStateM1075e = m1075e();
        imagePerfStateM1075e.f3215A = aVar;
        imagePerfStateM1075e.f3227l = jNow;
        imagePerfStateM1075e.f3216a = str;
        imagePerfStateM1075e.f3236u = th;
        m1077n(imagePerfStateM1075e, 5);
        imagePerfStateM1075e.f3238w = 2;
        imagePerfStateM1075e.f3240y = jNow;
        m1078q(imagePerfStateM1075e, 2);
    }

    @Override // p007b.p109f.p148h.p158b.p159a.ControllerListener2
    /* renamed from: c */
    public void mo1073c(String str, ControllerListener2.a aVar) {
        long jNow = this.f3243k.now();
        ImagePerfState imagePerfStateM1075e = m1075e();
        imagePerfStateM1075e.f3215A = aVar;
        imagePerfStateM1075e.f3216a = str;
        int i = imagePerfStateM1075e.f3237v;
        if (i != 3 && i != 5 && i != 6) {
            imagePerfStateM1075e.f3228m = jNow;
            m1077n(imagePerfStateM1075e, 4);
        }
        imagePerfStateM1075e.f3238w = 2;
        imagePerfStateM1075e.f3240y = jNow;
        m1078q(imagePerfStateM1075e, 2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m1075e().m1068a();
    }

    @Override // p007b.p109f.p148h.p158b.p159a.ControllerListener2
    /* renamed from: d */
    public void mo1074d(String str, Object obj, ControllerListener2.a aVar) {
        long jNow = this.f3243k.now();
        ImagePerfState imagePerfStateM1075e = m1075e();
        imagePerfStateM1075e.f3215A = aVar;
        imagePerfStateM1075e.f3226k = jNow;
        imagePerfStateM1075e.f3230o = jNow;
        imagePerfStateM1075e.f3216a = str;
        imagePerfStateM1075e.f3220e = (ImageInfo) obj;
        m1077n(imagePerfStateM1075e, 3);
    }

    /* renamed from: e */
    public final ImagePerfState m1075e() {
        return Boolean.FALSE.booleanValue() ? new ImagePerfState() : this.f3244l;
    }

    /* renamed from: f */
    public final boolean m1076f() {
        boolean zBooleanValue = this.f3246n.get().booleanValue();
        if (zBooleanValue && f3242j == null) {
            synchronized (this) {
                if (f3242j == null) {
                    HandlerThread handlerThread = new HandlerThread("ImagePerfControllerListener2Thread");
                    handlerThread.start();
                    Looper looper = handlerThread.getLooper();
                    Objects.requireNonNull(looper);
                    f3242j = new a(looper, this.f3245m);
                }
            }
        }
        return zBooleanValue;
    }

    /* renamed from: n */
    public final void m1077n(ImagePerfState imagePerfState, int i) {
        if (!m1076f()) {
            ((ImagePerfMonitor) this.f3245m).m1066b(imagePerfState, i);
            return;
        }
        Handler handler = f3242j;
        Objects.requireNonNull(handler);
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = 1;
        messageObtainMessage.arg1 = i;
        messageObtainMessage.obj = imagePerfState;
        f3242j.sendMessage(messageObtainMessage);
    }

    /* renamed from: q */
    public final void m1078q(ImagePerfState imagePerfState, int i) {
        if (!m1076f()) {
            ((ImagePerfMonitor) this.f3245m).m1065a(imagePerfState, i);
            return;
        }
        Handler handler = f3242j;
        Objects.requireNonNull(handler);
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = 2;
        messageObtainMessage.arg1 = i;
        messageObtainMessage.obj = imagePerfState;
        f3242j.sendMessage(messageObtainMessage);
    }
}
