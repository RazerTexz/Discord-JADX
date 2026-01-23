package com.discord.stores;

import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.google.firebase.dynamiclinks.internal.DynamicLinkData;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4361e;
import p007b.p225i.p361c.FirebaseApp2;
import p007b.p225i.p361c.p391o.AbstractC4767a;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p658rx.Emitter;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: com.discord.stores.StoreDynamicLink$getDynamicLinkObservable$firebaseDynamicLinks$1, reason: use source file name */
/* JADX INFO: compiled from: StoreDynamicLink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreDynamicLink2<T> implements Action1<Emitter<Uri>> {
    public final /* synthetic */ Intent $intent;

    /* JADX INFO: renamed from: com.discord.stores.StoreDynamicLink$getDynamicLinkObservable$firebaseDynamicLinks$1$1 */
    /* JADX INFO: compiled from: StoreDynamicLink.kt */
    public static final /* synthetic */ class C58791 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
        public C58791(Emitter emitter) {
            super(1, emitter, Emitter.class, "onError", "onError(Ljava/lang/Throwable;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            ((Emitter) this.receiver).onError(th);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreDynamicLink$getDynamicLinkObservable$firebaseDynamicLinks$1$2 */
    /* JADX INFO: compiled from: StoreDynamicLink.kt */
    public static final class C58802<TResult> implements InterfaceC4361e<PendingDynamicLinkData> {
        public final /* synthetic */ Emitter $it;

        public C58802(Emitter emitter) {
            this.$it = emitter;
        }

        @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4361e
        public /* bridge */ /* synthetic */ void onSuccess(PendingDynamicLinkData pendingDynamicLinkData) {
            onSuccess2(pendingDynamicLinkData);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0015  */
        /* JADX INFO: renamed from: onSuccess, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onSuccess2(PendingDynamicLinkData pendingDynamicLinkData) {
            Uri uri;
            String str;
            Emitter emitter = this.$it;
            if (pendingDynamicLinkData != null) {
                DynamicLinkData dynamicLinkData = pendingDynamicLinkData.f21421a;
                uri = null;
                if (dynamicLinkData != null && (str = dynamicLinkData.f21423k) != null) {
                    uri = Uri.parse(str);
                }
                if (uri == null) {
                    uri = Uri.EMPTY;
                }
            }
            emitter.onNext(uri);
            this.$it.onCompleted();
        }
    }

    public StoreDynamicLink2(Intent intent) {
        this.$intent = intent;
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Emitter<Uri> emitter) {
        AbstractC4767a abstractC4767a;
        synchronized (AbstractC4767a.class) {
            FirebaseApp2 firebaseApp2M6327b = FirebaseApp2.m6327b();
            synchronized (AbstractC4767a.class) {
                firebaseApp2M6327b.m6330a();
                abstractC4767a = (AbstractC4767a) firebaseApp2M6327b.f12121g.mo6346a(AbstractC4767a.class);
            }
            abstractC4767a.mo6703a(this.$intent).mo6009d(new StoreDynamicLink3(new C58791(emitter))).mo6011f(new C58802(emitter));
        }
        abstractC4767a.mo6703a(this.$intent).mo6009d(new StoreDynamicLink3(new C58791(emitter))).mo6011f(new C58802(emitter));
    }

    @Override // p658rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Emitter<Uri> emitter) {
        call2(emitter);
    }
}
