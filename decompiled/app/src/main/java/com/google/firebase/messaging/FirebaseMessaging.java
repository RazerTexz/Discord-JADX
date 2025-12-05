package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p228b.TransportFactory;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p299e.p308o.p309j.ThreadFactoryC3408a;
import p007b.p225i.p226a.p288f.p340n.C4358c0;
import p007b.p225i.p226a.p288f.p340n.C4378v;
import p007b.p225i.p361c.DataCollectionDefaultChange;
import p007b.p225i.p361c.FirebaseApp2;
import p007b.p225i.p361c.p396q.EventHandler2;
import p007b.p225i.p361c.p396q.Subscriber2;
import p007b.p225i.p361c.p397r.HeartBeatInfo;
import p007b.p225i.p361c.p398s.C4823n;
import p007b.p225i.p361c.p398s.C4826q;
import p007b.p225i.p361c.p400t.Provider2;
import p007b.p225i.p361c.p401u.InterfaceC4843g;
import p007b.p225i.p361c.p406w.C4870h;
import p007b.p225i.p361c.p406w.C4872j;
import p007b.p225i.p361c.p406w.C4887y;
import p007b.p225i.p361c.p406w.CallableC4886x;
import p007b.p225i.p361c.p406w.RunnableC4869g;
import p007b.p225i.p361c.p407x.UserAgentPublisher;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* loaded from: classes3.dex */
public class FirebaseMessaging {

    /* renamed from: a */
    @Nullable
    @SuppressLint({"FirebaseUnknownNullness"})
    @VisibleForTesting
    public static TransportFactory f21448a;

    /* renamed from: b */
    public final Context f21449b;

    /* renamed from: c */
    public final FirebaseApp2 f21450c;

    /* renamed from: d */
    public final FirebaseInstanceId f21451d;

    /* renamed from: e */
    public final C11088a f21452e;

    /* renamed from: f */
    public final Executor f21453f;

    /* renamed from: g */
    public final Task<C4887y> f21454g;

    /* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    /* renamed from: com.google.firebase.messaging.FirebaseMessaging$a */
    public class C11088a {

        /* renamed from: a */
        public final Subscriber2 f21455a;

        /* renamed from: b */
        public boolean f21456b;

        /* renamed from: c */
        @Nullable
        public EventHandler2<DataCollectionDefaultChange> f21457c;

        /* renamed from: d */
        @Nullable
        public Boolean f21458d;

        public C11088a(Subscriber2 subscriber2) {
            this.f21455a = subscriber2;
        }

        /* renamed from: a */
        public synchronized void m9193a() {
            if (this.f21456b) {
                return;
            }
            Boolean boolM9195c = m9195c();
            this.f21458d = boolM9195c;
            if (boolM9195c == null) {
                C4872j c4872j = new C4872j(this);
                this.f21457c = c4872j;
                this.f21455a.mo6359a(DataCollectionDefaultChange.class, c4872j);
            }
            this.f21456b = true;
        }

        /* renamed from: b */
        public synchronized boolean m9194b() {
            m9193a();
            Boolean bool = this.f21458d;
            if (bool != null) {
                return bool.booleanValue();
            }
            return FirebaseMessaging.this.f21450c.m6333g();
        }

        @Nullable
        /* renamed from: c */
        public final Boolean m9195c() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            FirebaseApp2 firebaseApp2 = FirebaseMessaging.this.f21450c;
            firebaseApp2.m6330a();
            Context context = firebaseApp2.f12118d;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
    }

    public FirebaseMessaging(FirebaseApp2 firebaseApp2, FirebaseInstanceId firebaseInstanceId, Provider2<UserAgentPublisher> provider2, Provider2<HeartBeatInfo> provider22, InterfaceC4843g interfaceC4843g, @Nullable TransportFactory transportFactory, Subscriber2 subscriber2) {
        try {
            Class.forName("com.google.firebase.iid.FirebaseInstanceIdReceiver");
            f21448a = transportFactory;
            this.f21450c = firebaseApp2;
            this.f21451d = firebaseInstanceId;
            this.f21452e = new C11088a(subscriber2);
            firebaseApp2.m6330a();
            Context context = firebaseApp2.f12118d;
            this.f21449b = context;
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new ThreadFactoryC3408a("Firebase-Messaging-Init"));
            this.f21453f = scheduledThreadPoolExecutor;
            scheduledThreadPoolExecutor.execute(new RunnableC4869g(this, firebaseInstanceId));
            C4826q c4826q = new C4826q(context);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor2 = new ScheduledThreadPoolExecutor(1, new ThreadFactoryC3408a("Firebase-Messaging-Topics-Io"));
            int i = C4887y.f13060b;
            Task<C4887y> taskM4323o = C3404f.m4323o(scheduledThreadPoolExecutor2, new CallableC4886x(context, scheduledThreadPoolExecutor2, firebaseInstanceId, c4826q, new C4823n(firebaseApp2, c4826q, provider2, provider22, interfaceC4843g)));
            this.f21454g = taskM4323o;
            C4358c0 c4358c0 = (C4358c0) taskM4323o;
            c4358c0.f11472b.m6031a(new C4378v(new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC3408a("Firebase-Messaging-Trigger-Topics-Io")), new C4870h(this)));
            c4358c0.m6028w();
        } catch (ClassNotFoundException unused) {
            throw new IllegalStateException("FirebaseMessaging and FirebaseInstanceId versions not compatible. Update to latest version of firebase-messaging.");
        }
    }

    @NonNull
    @Keep
    public static synchronized FirebaseMessaging getInstance(@NonNull FirebaseApp2 firebaseApp2) {
        FirebaseMessaging firebaseMessaging;
        firebaseApp2.m6330a();
        firebaseMessaging = (FirebaseMessaging) firebaseApp2.f12121g.mo6346a(FirebaseMessaging.class);
        AnimatableValueParser.m595z(firebaseMessaging, "Firebase Messaging component is not present");
        return firebaseMessaging;
    }
}
